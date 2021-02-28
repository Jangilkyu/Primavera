package com.primavera.www.dao;

import static com.primavera.www.common.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.primavera.www.vo.ReviewVo;

public class ReviewDAO {

	private Connection conn;
	
	private ReviewDAO() {
		
	}
	
	public static ReviewDAO getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private static class LazyHolder {
		private static final ReviewDAO INSTANCE = new ReviewDAO();
	}
	
    public void setConnection(Connection conn) {
        this.conn = conn;
    }
	
    public int getMemberNo(String id) {
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	int re = -1;
    	
    	try {
    		pstmt = conn.prepareStatement("SELECT no FROM member WHERE id = ?");
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
		}
    	
    	return re;
    }//getMemberNo
    
    public int insertReview(ReviewVo reviewVo) {
    		PreparedStatement pstmt = null;
    		
    		int re = -1;
    		
    		try {
    			pstmt = conn.prepareStatement("INSERT INTO review(r_no, title, content, fname, star, m_no ,writedate) VALUES (seq_review.nextval,?,?,?,?,?,SYSDATE)");
    			pstmt.setString(1, reviewVo.getTitle());
    			pstmt.setString(2, reviewVo.getContent());
    			pstmt.setString(3, reviewVo.getFname());
    			pstmt.setInt(4, reviewVo.getStar());
    			pstmt.setInt(5, reviewVo.getM_no());

    			re = pstmt.executeUpdate();
    			
    		}catch (Exception e) {
    			e.printStackTrace();
    		}finally {
				close(pstmt);
			}
    		return re;
    }
	
    /**
     * @return
     */
    public ArrayList<ReviewVo> findAllReview(){
    	
    	ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
    		pstmt = conn.prepareStatement("SELECT review.r_no, title, content, star, review.writedate,fname, member.id "
    				+ " FROM review "
    				+ "inner JOIN  member\r\n"
    				+ "ON review.m_no = member.no");
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			ReviewVo rVo = new ReviewVo();
    			rVo.setR_no(rs.getInt(1));
    			rVo.setTitle(rs.getString(2));
    			rVo.setContent(rs.getString(3));
    			rVo.setStar(rs.getInt(4));
    			rVo.setWriteDate(rs.getTimestamp(5));
    			rVo.setFname(rs.getString(6));
    			rVo.setId(rs.getString(7));
    			
    			list.add(rVo);
    		}
    	}catch (Exception e) {
    		e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
    	
    	return list;
    }//
    
    public ArrayList<ReviewVo> getDetailReview(int r_no){
    	ArrayList<ReviewVo> list = new ArrayList<ReviewVo>();
    	ResultSet rs = null;
    	PreparedStatement pstmt = null;
    	try {
    		pstmt = conn.prepareStatement(" SELECT r_no, title, content, star, writedate, fname, member.id "
    				+ " FROM review "
    				+ " INNER JOIN  member "
    				+ " ON review.m_no = member.no "
    				+ " WHERE r_no = ? ");
    		
    		pstmt.setInt(1, r_no);
    		
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			ReviewVo rVo = new ReviewVo();
    			rVo.setR_no(rs.getInt(1));
    			rVo.setTitle(rs.getString(2));
    			rVo.setContent(rs.getString(3));
    			rVo.setStar(rs.getInt(4));
    			rVo.setWriteDate(rs.getTimestamp(5));
    			rVo.setFname(rs.getString(6));
    			rVo.setId(rs.getString(7));

    			
    			list.add(rVo);
    		}//end if
    	}catch (Exception e) {
    		e.printStackTrace();
    		System.out.println(e.getMessage());
		}finally {
			close(rs);
			close(pstmt);
		}
    	
    	return list;
    }
	
	
}//class
