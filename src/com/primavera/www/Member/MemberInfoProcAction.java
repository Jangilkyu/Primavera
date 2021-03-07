package com.primavera.www.Member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.service.MemberService;
import com.primavera.www.vo.MemberVo;

public class MemberInfoProcAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String tel1 = request.getParameter("tel1");
		String tel2 = request.getParameter("tel2");
		String tel3 = request.getParameter("tel3");
		String post1 = request.getParameter("post1");
		String post2 = request.getParameter("post2");
		String post3 = request.getParameter("post3");
		
		System.out.println(tel3);
		
		MemberService service = new MemberService();
		
		/*
		 * //이름 비어있는지 확인 if("".equals(name)|| name == null) {
		 * response.setContentType("text/html;charset=UTF-8"); PrintWriter out =
		 * response.getWriter();
		 * out.println("<script> alert('이름을 입력해주세요.!'); history.back(); </script>");
		 * out.close(); return null; }
		 * 
		 * //핸드폰번호 비어있는지 확인 if("".equals(tel1) || "".equals(tel2) || "".equals(tel3) ||
		 * tel1 == null || tel2 == null || tel3 == null) {
		 * response.setContentType("text/html;charset=UTF-8"); PrintWriter out =
		 * response.getWriter(); out.
		 * println("<script>alert('핸드폰 번호를 정확하게 입력해주세요.!'); history.back(); </script>");
		 * out.close(); return null; }
		 * 
		 * //주소 및 우편번호 및 기본 주소가 비어있는지 확인 if("".equals(post1) || "".equals(post2) ||
		 * "".equals(post3) || post1 == null || post2 == null || post3 == null) {
		 * response.setContentType("text/html;charset=UTF-8"); PrintWriter out =
		 * response.getWriter();
		 * out.println("<script>alert('주소 및 우편번호를 입력해주세요.!'); history.back(); </script>"
		 * ); out.close(); return null; }
		 */
		
		MemberVo memberVo = new MemberVo(id,name,email,post1,post2,post3,tel1,tel2,tel3);
		boolean re = service.updateMember(memberVo);
		System.out.println(re + "Aaaaaaaaaaaaaaaaaaaaa");
		
		/*
		 * if(!service.updateMember(memberVo)) {
		 * response.setContentType("text/html;charset=UTF-8"); PrintWriter out =
		 * response.getWriter(); out.
		 * println("<script>alert('회원정보 변경에 실패했습니다.'); location.href='/ChungChunPrj/index.do'; </script>"
		 * ); out.close(); return null; }
		 */
		
		
		ActionForward forward = new ActionForward();
        forward.setPath("index.do");
        forward.setRedirect(true);
		
		return forward;
	
	}

}
