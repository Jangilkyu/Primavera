package com.primavera.www.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.service.ProductService;
import com.primavera.www.vo.ProductVo;

public class ProductListProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ActionForward forward = new ActionForward();
		
		ProductService service = new ProductService();
		
		ArrayList<ProductVo> list =  service.findAllProduct();
		
		
		System.out.println(list.get(0).getName());
		
		request.setAttribute("list", list);
		
		forward.setPath("productList.jsp");
		
		return forward;
	}

}
