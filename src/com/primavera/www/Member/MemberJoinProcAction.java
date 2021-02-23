package com.primavera.www.Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.common.BCrypt;
import com.primavera.www.service.MemberService;
import com.primavera.www.vo.MemberVo;


public class MemberJoinProcAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String passwordchk = request.getParameter("passwordchk");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		
		//pwd,pwd확인 일치하는지 검사
		if (!password.equals(passwordchk)) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('두 비밀번호가 일치하지 않습니다.');location.href='/ChungChunPrj/index.do';</script>");
			out.close();
			return null;
		}
		
		MemberVo membervo = new MemberVo(id,name,
				BCrypt.hashpw(password, BCrypt.gensalt(10)),email,gender,tel);

		MemberService service = new MemberService();
        if (!service.insertMember(membervo)) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('회원 가입에 실패하였습니다.');location.href='/ChungChunPrj/index.do';</script>");
            out.close();
            return null;
        }
        
        //메인페이지로 이동
        ActionForward forward = new ActionForward();
        forward.setPath("/viws/index.do");
        forward.setRedirect(true);
        return forward;
        
	}
	
}
