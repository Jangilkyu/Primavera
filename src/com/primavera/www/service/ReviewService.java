package com.primavera.www.service;

import static com.primavera.www.common.JdbcUtil.close;
import static com.primavera.www.common.JdbcUtil.commit;
import static com.primavera.www.common.JdbcUtil.getConnection;
import static com.primavera.www.common.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.primavera.www.dao.ReviewDAO;
import com.primavera.www.vo.ReviewVo;

public class ReviewService {

	/**
	 * 회원 번호를 조회하는 메소드
	 * @param id
	 * @return
	 */
	public int getMemberNo(String id) {
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		Connection conn = getConnection();
		reviewDAO.setConnection(conn);
		
		int re = reviewDAO.getMemberNo(id);
		
		close(conn);
		
		return re;
	}//getMemberNo
	
	/**
	 * 리뷰를 등록하는 메소드
	 * @param reviewVo
	 * @return
	 */
	public int insertReview(ReviewVo reviewVo) {
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		Connection conn = getConnection();
		reviewDAO.setConnection(conn);
		
		int re =reviewDAO.insertReview(reviewVo);
		
		if(re == 1) {
            commit(conn);
		}
		else {
            rollback(conn);
		}
        close(conn);

		return re;
	}//insertReview
	
	/**
	 * 모든 리뷰를 가져오는 메소드
	 * @return
	 */
	public ArrayList<ReviewVo> findAllReview(){
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		Connection conn = getConnection();
		reviewDAO.setConnection(conn);
		
		ArrayList<ReviewVo> list = reviewDAO.findAllReview();
		
		return list;
	}//findAllReview
	
	/**
	 * 리뷰를 클릭시 세부리뷰를 가져오는 메소드
	 * @return
	 */
	public ArrayList<ReviewVo> getDetailReview(int r_no){
		
		ReviewDAO reviewDAO = ReviewDAO.getInstance();
		Connection conn = getConnection();
		reviewDAO.setConnection(conn);
		
		ArrayList<ReviewVo> list = reviewDAO.getDetailReview(r_no);
		
		return list;
	}//getDetailReview


}//class
