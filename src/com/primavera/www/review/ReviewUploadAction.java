package com.primavera.www.review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.common.LoginSessionListener;

public class ReviewUploadAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ActionForward forward = new ActionForward();
		
		  LoginSessionListener lsl = LoginSessionListener.getInstance(); 
		  String id = lsl.getUserID(request.getSession());
		
		if(id == null) {
	        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('로그인 후 후기 작성이 가능합니다.!'); location.href='/ChungChunPrj/index.do'; </script>");
            out.close();
            return null;
		}
		
		forward.setPath("/views/reviewupload.jsp");
		
		return forward;
	}

	
	
}
