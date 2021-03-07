package com.primavera.www.service;

import static com.primavera.www.common.JdbcUtil.close;
import static com.primavera.www.common.JdbcUtil.commit;
import static com.primavera.www.common.JdbcUtil.getConnection;
import static com.primavera.www.common.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.primavera.www.dao.ProductDao;
import com.primavera.www.vo.ProductVo;

public class ProductService {
	
	/**
	 * 회원 번호를 조회하는 메소드
	 * @param id
	 * @return
	 */
	public int getMemberNo(String id) {
		
		ProductDao dao = ProductDao.getInstance();
		Connection conn = getConnection();
		dao.setConnection(conn);
		
		int re = dao.getMemberNo(id);
		
		close(conn);
		
		return re;
	}//getMemberNo
	
	/**
	 * 상품을 추가하는 메소드
	 * @param vo
	 * @return
	 */
	public boolean insertProduct(ProductVo vo) {
		
		ProductDao dao = ProductDao.getInstance();
    	Connection conn = getConnection();
    	dao.setConnection(conn);
        boolean isSucess = false;
        
        int result = dao.insertProduct(vo); //dao호출
        System.out.println(result);
	      if (result == 1) {
	            commit(conn);
	            isSucess = true;
	        } else {
	            rollback(conn);
	        }
	        close(conn);
	        return isSucess;
	}//insertProduct
	
	
	/**
	 * mywrite.jsp에 내가 등록 상품에 정보들을 가져오는 메소드
	 * @param id
	 * @return
	 */
	public ArrayList<ProductVo> productWriteInfo(String id) {
		ProductDao dao = ProductDao.getInstance();
    	Connection conn = getConnection();
    	dao.setConnection(conn);
        
        ArrayList<ProductVo> list = dao.productWriteInfo(id); //dao호출
        close(conn);

	        return list;
	}//productWriteInfo
	
	/**
	 * mywrite.jsp에 등록 상품 클릭 시 한상품에 대한 디테일 정보를 가져오는 메소드
	 * @param no
	 * @return
	 */
	public ArrayList<ProductVo> findDeatilProduct(int no){
		ProductDao dao = ProductDao.getInstance();
    	Connection conn = getConnection();
    	dao.setConnection(conn);
        
    	ArrayList<ProductVo> list = dao.findDeatilProduct(no); //dao호출
        close(conn);
		return list;
	}
	
	public int updateProduct(ProductVo vo) {
		int re = -1;
		ProductDao dao = ProductDao.getInstance();
    	Connection conn = getConnection();
    	dao.setConnection(conn);
        
    	re = dao.updateProduct(vo);
		
        if (re == 1) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
		return re;
	}

	/**
	 * 상품을 삭제하는 메소드
	 * @param no
	 * @return
	 */
	public int deleteProduct(int no) {
		int re = -1;
		ProductDao dao = ProductDao.getInstance();
    	Connection conn = getConnection();
    	dao.setConnection(conn);
        
    	re = dao.deleteProduct(no);
		
        if (re == 1) {
            commit(conn);
        } else {
            rollback(conn);
        }
        close(conn);
		return re;
	}

	/**
	 * 상품보기에 상품 리스트를 뿌려주는 메소드
	 * @return
	 */
	public ArrayList<ProductVo> findAllProduct() {
		ProductDao dao = ProductDao.getInstance();
    	Connection conn = getConnection();
    	dao.setConnection(conn);
        
        ArrayList<ProductVo> list = dao.findAllProduct(); //dao호출
        close(conn);

	       return list;
	}
}
