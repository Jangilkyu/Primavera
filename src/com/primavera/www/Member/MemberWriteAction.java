package com.primavera.www.Member;

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

public class MemberWriteAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ActionForward forward = new ActionForward();
		
		LoginSessionListener lsl = LoginSessionListener.getInstance();
		String id = lsl.getUserID(request.getSession());

		if (id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.'); location.href='/ChungChunPrj/views/index.do'; </script>");
			out.close();
			return null;
		}//end if
		
		ProductService service = new ProductService();
		
		ArrayList<ProductVo> list = service.productWriteInfo(id);
		
		System.out.println(list.get(0).getNo());
		request.setAttribute("list", list);
		forward.setPath("myWrite.jsp");
		
		return forward;
	}

}
