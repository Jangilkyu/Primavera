package com.primavera.www.Member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.service.MemberService;

public class AjaxCheckIdAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String id = request.getParameter("id");
		
		System.out.println("action안에 "+id);
		
		MemberService service = new MemberService();

		int re = service.idCheck(id);
		
		System.out.println(re);
		
        request.setAttribute("count", service.idCheck(id));

        System.out.println("getAttribute의 값	" + request.getAttribute("count"));
        
        ActionForward forward = new ActionForward();
        forward.setPath("/ajax/AjaxCheckJoin.jsp");
        
        return forward;
	}
}
