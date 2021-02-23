package com.primavera.www.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        ActionForward forward = new ActionForward();
        forward.setPath("/views/join.jsp");

		return forward;
	}
}
