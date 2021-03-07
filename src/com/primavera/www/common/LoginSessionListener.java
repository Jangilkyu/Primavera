package com.primavera.www.common;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author owner
 *
 */
public class LoginSessionListener implements HttpSessionBindingListener {

	
	/**
	 *	Login을 한 접속자를 저장한 HashTable 
	 */
	private static Hashtable<HttpSession, String> loginUser = new Hashtable<HttpSession,String>();
	
	
	//싱글톤 
	
	private LoginSessionListener() {
		
	}
	
    public static LoginSessionListener getInstance() {
        return LoginSessionListener.LazyHolder.INSTANCE;
    }

    //싱글톤으로 인스턴스 생성
    private static class LazyHolder {
        private static final LoginSessionListener INSTANCE = new LoginSessionListener();
    }

	/**
	 * 세션 연결할 때 호출(HashTable에 접속자를 저장한다.)
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		loginUser.put(event.getSession(), event.getName());
		System.out.println(event.getName() + " 로그인 완료");
	}

	/**
	 * 세션이 끊겼을 때 호출
	 * 로그아웃 버튼을 눌르지 않았을 때 컴퓨터종료,세션만료등에 이유로 로그아웃 된다.
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		loginUser.remove(event.getSession());
	}
    
    /**
     * 로그아웃 버튼 눌렀을 때, 해쉬테이블 순차적으로 배치시킴, while 키 값이 존재하는동안,session에 키 값 받아옴
     * 입력받은 아이디를 해시테이블에서 삭제
     * @param userId
     */
    public void removeSession(String userId) {
        Enumeration<HttpSession> e = loginUser.keys();
        HttpSession session = null;
        while(e.hasMoreElements()){
            session = (HttpSession)e.nextElement();
            if(loginUser.get(session).equals(userId)){
                session.invalidate();
            }//end if
       }//end while
    }// removeSession
    
    /**
     * 입력받은 session Object로 아이디를 리턴한다.
     * @param session => 접속한 사용자의 session Object
     * @return String => 접속자의 아이디
     */
    public String getUserID(HttpSession session) {
    	return (String)loginUser.get(session);
    }//getUserID
    
    
    public void setSession(HttpSession session, String id) {
    	
    	//로그인에 this 즉 자기 자신을 집어 넣는다.
    	session.setAttribute(id, this);
    	
    }
	
}
