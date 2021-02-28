package com.primavera.www.dao;

import static com.primavera.www.common.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
			pstmt = conn.prepareStatement("INSERT INTO member (no,id,name,password,email,gender,post1,post2,post3,tel1,tel2,tel3,join_date) VALUES (seq_member.nextval,?,?,?,?,?,?,?,?,?,?,?,SYSDATE)");
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());	
			pstmt.setString(3, member.getPassword());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getPost1());
			pstmt.setString(7, member.getPost2());
			pstmt.setString(8, member.getPost3());
			pstmt.setString(9, member.getTel1());
			pstmt.setString(10, member.getTel2());
			pstmt.setString(11, member.getTel3());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
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
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return pwd;
	}//getPWD
	
	public ArrayList<MemberVo> getMember(String id){
		ArrayList<MemberVo> list = new ArrayList<MemberVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			
			pstmt = conn.prepareStatement("SELECT id, name,email, post1, post2 , post3, tel1, tel2, tel3 FROM member WHERE id = ? ");

			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				MemberVo mVo = new MemberVo();
				
				mVo.setId(rs.getString(1));
				mVo.setName(rs.getString(2));
				mVo.setEmail(rs.getString(3));
				mVo.setPost1(rs.getString(4));
				mVo.setPost2(rs.getString(5));
				mVo.setPost3(rs.getString(6));
				mVo.setTel1(rs.getString(7));
				mVo.setTel2(rs.getString(8));
				mVo.setTel3(rs.getString(9));
				
				list.add(mVo);
			}//end if
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}//getMember
	
	
	public int updateMember(MemberVo memberVo) {
		
		PreparedStatement pstmt = null;
		int re = -1;
		
		try {
		
			pstmt = conn.prepareStatement("UPDATE MEMBER SET name = ?, email = ?, tel1 = ?, tel2 = ?, tel3 = ?, post1 = ?, post2 = ?, post3 = ? WHERE id = ? ");
			
			pstmt.setString(1, memberVo.getName());
			pstmt.setString(2, memberVo.getEmail());
			pstmt.setString(3, memberVo.getTel1());
			pstmt.setString(4, memberVo.getTel2());
			pstmt.setString(5, memberVo.getTel3());
			pstmt.setString(6, memberVo.getPost1());
			pstmt.setString(7, memberVo.getPost2());
			pstmt.setString(8, memberVo.getPost3());
			pstmt.setString(9, memberVo.getId());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}finally {
			close(pstmt);
		}
		return re;
	}
	
	
	

}//class