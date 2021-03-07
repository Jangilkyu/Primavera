package com.primavera.www.board;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.common.LoginSessionListener;
import com.primavera.www.service.ProductService;
import com.primavera.www.vo.ProductVo;

public class ProductUpdateAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductService service = new ProductService();
		ActionForward forward = new ActionForward();
		  
		  int no = Integer.parseInt(request.getParameter("no"));
		  
		  LoginSessionListener lsl = LoginSessionListener.getInstance(); 
		  String id = lsl.getUserID(request.getSession());
		
		if(id == null) {
	        response.setContentType("text/html;charset=UTF-8");
          PrintWriter out = response.getWriter();
          out.println("<script>alert('로그인 후 후기 작성이 가능합니다.!'); location.href='/ChungChunPrj/index.do'; </script>");
          out.close();
          return null;
		}
		
		ArrayList<ProductVo> list = service.findDeatilProduct(no);
		request.setAttribute("list", list);
		forward.setPath("productUpdate.jsp");
				
		return forward;
	}

}
