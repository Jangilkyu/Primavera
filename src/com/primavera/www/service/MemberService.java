package com.primavera.www.service;

import static com.primavera.www.common.JdbcUtil.close;
import static com.primavera.www.common.JdbcUtil.commit;
import static com.primavera.www.common.JdbcUtil.getConnection;
import static com.primavera.www.common.JdbcUtil.rollback;

import java.sql.Connection;

import com.primavera.www.dao.MemberDAO;
import com.primavera.www.vo.MemberVo;
public class MemberService {
	
    //회원가입 메소드
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
    
    public int idCheck(String id) {
    	int result = -1;
    	MemberDAO dao = MemberDAO.getInstance();	
    	Connection conn = getConnection();
    	dao.setConnection(conn);
    	
    	result = dao.idCheck(id);
    	close(conn);
    	
    	return result;
    }
	
	
}//class
