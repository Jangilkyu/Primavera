package com.primavera.www.dao;

import static com.primavera.www.common.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.primavera.www.vo.ProductVo;

public class ProductDao {
	private Connection conn;
	
	private ProductDao() {
		
	}
	
	public static ProductDao getInstance() {
		return LazyHolder.INSTANCE;
	}
	
	private static class LazyHolder {
		private static final ProductDao INSTANCE = new ProductDao();
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
    
    public int insertProduct(ProductVo vo) {
    	int re = -1;
    	
		PreparedStatement pstmt = null;
    	
		try {
			pstmt = conn.prepareStatement("INSERT INTO PRODUCTS (no,name,content,tel,price,address,fname,m_no,write_date,write_update) VALUES (seq_product.nextval,?,?,?,?,?,?,?,sysdate,sysdate)");
		
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getTel());
			pstmt.setInt(4, vo.getPrice());
			pstmt.setString(5, vo.getAddress());
			pstmt.setString(6, vo.getFname());
			pstmt.setInt(7, vo.getM_no());
			
			re = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
    	return re;
    }//insertProduct
    
    public ArrayList<ProductVo> productWriteInfo(String id) {
    	ArrayList<ProductVo> list = new ArrayList<ProductVo>();
    	
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
    		pstmt = conn.prepareStatement("select products.no, products.name, products.tel, products.price, products.address, products.fname, products.m_no,member.id\r\n"
    				+ "from\r\n"
    				+ "products\r\n"
    				+ "inner join\r\n"
    				+ "member\r\n"
    				+ "on products.m_no = member.no\r\n"
    				+ "where member.id = ?");
    		
    		pstmt.setString(1, id);
    		
    		rs = pstmt.executeQuery();
    		
    		while(rs.next()) {
    			ProductVo Pvo = new ProductVo();
    			
    			Pvo.setNo(rs.getInt(1));
    			Pvo.setName(rs.getString(2));
    			Pvo.setTel(rs.getString(3));
    			Pvo.setPrice(rs.getInt(4));
    			Pvo.setAddress(rs.getString(5));
    			Pvo.setFname(rs.getString(6));
    			Pvo.setM_no(rs.getInt(7));
    			Pvo.setId(rs.getString(8));
    			
    			list.add(Pvo);
    		}
    		
    		
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	
    	return list;
    }//productWriteInfo
    
    public ArrayList<ProductVo> findDeatilProduct(int no){
    	ArrayList<ProductVo> list = new ArrayList<ProductVo>();
    	
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	try {
    		pstmt = conn.prepareStatement("select products.no, products.name,products.content ,products.tel, products.price, products.address, products.fname, products.m_no,products.write_update,member.id\r\n"
    				+ "from\r\n"
    				+ "products\r\n"
    				+ "inner join\r\n"
    				+ "member\r\n"
    				+ "on products.m_no = member.no\r\n"
    				+ "where products.no = ?");
    		
    		pstmt.setInt(1, no);
    		
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			ProductVo Pvo = new ProductVo();
    			
    			Pvo.setNo(rs.getInt(1));
    			Pvo.setName(rs.getString(2));
    			Pvo.setContent(rs.getString(3));
    			Pvo.setTel(rs.getString(4));
    			Pvo.setPrice(rs.getInt(5));
    			Pvo.setAddress(rs.getString(6));
    			Pvo.setFname(rs.getString(7));
    			Pvo.setM_no(rs.getInt(8));
    			Pvo.setWrite_date(rs.getTimestamp(9));
    			Pvo.setId(rs.getString(10));
    			
    			list.add(Pvo);
    		}
    		
    	}catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return list;
    }
    
    public int updateProduct(ProductVo vo) {
    	int re = -1;
    	PreparedStatement pstmt = null;
    	
    	try {
    		pstmt = conn.prepareStatement("update products set name=?,content=?,tel=?,price=?,address=?,fname=?,write_update=sysdate where no = ?");
    		
    		pstmt.setString(1, vo.getName());
    		pstmt.setString(2, vo.getContent());
    		pstmt.setString(3, vo.getTel());
    		pstmt.setInt(4, vo.getPrice());
    		pstmt.setString(5, vo.getAddress());
    		pstmt.setString(6, vo.getFname());
    		pstmt.setInt(7, vo.getNo());

    		re = pstmt.executeUpdate();
    		
    	}catch (Exception e) {
    		e.printStackTrace();
		}
    	return re;
    }

	public int deleteProduct(int no) {
    	int re = -1;
    	PreparedStatement pstmt = null;		

    	try {
    		pstmt = conn.prepareStatement("delete products where no = ?");
    		
    		pstmt.setInt(1, no);
    		
    		re = pstmt.executeUpdate();
    		
    	}catch (Exception e) {
    		e.printStackTrace();
		}
		return re;
	}

	public ArrayList<ProductVo> findAllProduct() {
		
		ArrayList<ProductVo> list = new ArrayList<ProductVo>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM PRODUCTS");

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				ProductVo vo = new ProductVo();
				
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setTel(rs.getString(4));
				vo.setPrice(rs.getInt(5));
				vo.setAddress(rs.getString(6));
				vo.setFname(rs.getString(7));
				vo.setM_no(rs.getInt(8));
				vo.setWrite_date(rs.getTimestamp(9));
				vo.setUpdate_date(rs.getTimestamp(10));
				
				list.add(vo);
				
			}//end while
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		return list;
	}
	
}
