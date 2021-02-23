package com.primavera.www.dao;

import static com.primavera.www.common.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.primavera.www.vo.MemberVo;
public class MemberDAO {
	
	private Connection conn;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private static class LazyHolder {
		private static final MemberDAO INSTANCE = new MemberDAO();
	}
	
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
	
	public int insertMember(MemberVo member) {
		PreparedStatement pstmt = null;
		int re = -1;
		
		try {
			pstmt = conn.prepareStatement("INSERT INTO member (no,id,name,password,email,gender,tel,join_date) VALUES (seq_member.nextval,?,?,?,?,?,?,SYSDATE)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());	
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getTel());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}//end finally
		return re;
	}//insertMember
	
	public int idCheck(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int re = -1;

		try {
			pstmt = conn.prepareStatement("SELECT COUNT(*) AS CNT FROM member WHERE ID = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				re = rs.getInt(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}//finally
		return re;
	}//idCheck

}//class