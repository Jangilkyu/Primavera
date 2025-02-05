package com.primavera.www.service;

import static com.primavera.www.common.JdbcUtil.close;
import static com.primavera.www.common.JdbcUtil.commit;
import static com.primavera.www.common.JdbcUtil.getConnection;
import static com.primavera.www.common.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.primavera.www.dao.MemberDAO;
import com.primavera.www.vo.MemberVo;
public class MemberService {
	
    /**
     * 회원가입을 위한 메소드
     * @param memberVo
     * @return
     */
    public boolean insertMember(MemberVo memberVo) {
    	MemberDAO dao = MemberDAO.getInstance();	
    	Connection conn = getConnection();
    	dao.setConnection(conn);
        boolean isSucess = false;
        
        int result = dao.insertMember(memberVo); //dao호출
        
        if (result == 1) {
            commit(conn);
            isSucess = true;
        } else {
            rollback(conn);
        }
        close(conn);
        return isSucess;
    }//insertMember
    
    /**
     * 아이디가 중복되는지 확인하기 위한 메소드
     * @param id
     * @return
     */
    public int idCheck(String id) {
    	int result = -1;
    	MemberDAO dao = MemberDAO.getInstance();	
    	Connection conn = getConnection();
    	dao.setConnection(conn);
    	
    	result = dao.idCheck(id);
    	close(conn);
    	
    	return result;
    }//idCheck
	
    /**
     * 유효한 아이디인지 확인하는 메소드
     * @param id
     * @return
     */
    public int ValidMemberID(String id) {
    	int re = -1;
    	MemberDAO dao = MemberDAO.getInstance();
    	Connection conn = getConnection();
    	dao.setConnection(conn);
    	
    	re = dao.getID(id);
    	
    	return re;
    }//ValidMemberID
    
    public String ValidMemberPWD(String id) {
    	String re = "";
    	
    	MemberDAO dao = MemberDAO.getInstance();
    	Connection conn = getConnection();
    	
    	dao.setConnection(conn);
    	
    	re = dao.getPWD(id);
    	
    	return re;
    }//ValidMemberPWD
    
    public ArrayList<MemberVo> getMember(String id){
    	ArrayList<MemberVo> list = new ArrayList<MemberVo>();

    	MemberDAO dao = MemberDAO.getInstance();
    	Connection conn = getConnection();
    	
    	dao.setConnection(conn);
    	
    	list = dao.getMember(id);
    	
    	return list;
    }//getMember
    
    public boolean updateMember(MemberVo memberVo) {
    	
    	MemberDAO dao = MemberDAO.getInstance();
    	Connection conn = getConnection();
    	dao.setConnection(conn);

    	boolean isSucess = false;
    	
    	int re = dao.updateMember(memberVo);
    	
    	if(re == 1) {
    		commit(conn);
    		isSucess = true;
    	}else {
            rollback(conn);
    	}
    	return isSucess;
    }
	
}//class
