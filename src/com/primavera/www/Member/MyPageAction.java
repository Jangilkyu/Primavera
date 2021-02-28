package com.primavera.www.Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.common.LoginSessionListener;
import com.primavera.www.service.MemberService;
import com.primavera.www.vo.MemberVo;

public class MyPageAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		
		LoginSessionListener lsl = LoginSessionListener.getInstance();
		String id = lsl.getUserID(request.getSession());

		if (id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 마이페이지 이용이 가능합니다.!'); location.href='/ChungChunPrj/views/index.do'; </script>");
			out.close();
			return null;
		}//end if

		
		MemberService service = new MemberService();
		
		ArrayList<MemberVo> list =  service.getMember(id);
		
		request.setAttribute("list", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("myPage.jsp");
		
		return forward;
	}

	
	
}
