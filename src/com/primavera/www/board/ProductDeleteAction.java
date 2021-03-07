package com.primavera.www.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.service.ProductService;

public class ProductDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ActionForward forward = new ActionForward();
		
		ProductService service = new ProductService();
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		int re = service.deleteProduct(no);

		if(re == 1) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('성공적으로 삭제가 되었습니다.');</script>");
		}else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('잘못된 접근입니다');</script>");
		}
		
		forward.setPath("myWrite.do");
		forward.setRedirect(true);
		return forward;
	}

	
	
}
