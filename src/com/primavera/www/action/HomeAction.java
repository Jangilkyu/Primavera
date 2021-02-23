package com.primavera.www.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;

public class HomeAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ActionForward forward = new ActionForward();
		forward.setPath("/views/index.jsp");
		return forward;
	}
}//HomeAction