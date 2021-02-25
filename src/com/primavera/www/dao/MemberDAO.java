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
			pstmt = conn.prepareStatement("INSERT INTO member (no,id,name,password,email,gender,addr,tel,join_date) VALUES (seq_member.nextval,?,?,?,?,?,?,?,SYSDATE)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());	
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getAddr());
			pstmt.setString(7, member.getTel());
			
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
	
	/**
	 * 로그인 시 아이디가 존재하는지 확인하기 위한 메소드
	 * @param id index.jsp에서 파라미터로 넘어온 클라이언트 id
	 * @return 1 아이디가 존재 / 0 해당 아이디 없음
	 */
	public int getID(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int re = -1;
		
		try {
			pstmt = conn.prepareStatement("SELECT COUNT(ID) AS CNT FROM member WHERE id = ?");
			pstmt.setString(1, id);
			
			// ResultSet을 통해 새로운 inline view를 만든다.
			rs = pstmt.executeQuery();
			
			//id를 조회 후 조회되는 아이디가 있을 시 1 없을 시 0 
			if(rs.next()) {
				re = rs.getInt(1);
			}//end if
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return re;
	}//getID
	
	public String getPWD(String id) {
		String pwd = "";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			pstmt = conn.prepareStatement("SELECT password FROM member WHERE id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pwd = rs.getString(1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return pwd;
	}

}//class