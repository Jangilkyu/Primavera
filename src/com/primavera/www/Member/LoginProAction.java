package com.primavera.www.Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.common.BCrypt;
import com.primavera.www.common.LoginSessionListener;
import com.primavera.www.service.MemberService;

public class LoginProAction implements Action {
	
	private final int VALID = 1;
	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if("".equals(id) || id == null || "".equals(pwd)) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('잘못된 접근입니다');</script>");
            out.close();
            return null;
		}
		
		MemberService service = new MemberService();
		
		if(service.ValidMemberID(id) != VALID) {
	        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('유효하지 않는 아이디입니다.'); location.href='/ChungChunPrj/views/index.do'; </script>");
            out.close();
            return null;
		}
		
        if("".equals(pwd)||!BCrypt.checkpw(pwd,service.ValidMemberPWD(id))){
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('비밀번호를 확인해 주세요.');history.back();</script>");
            out.close();
            return null;
        }
		
        LoginSessionListener lsl = LoginSessionListener.getInstance();
        lsl.setSession(request.getSession(), id);
      
        //메인페이지 이동
        ActionForward forward = new ActionForward();
        forward.setPath("index.do");
		
		return forward;
	}
	

}
