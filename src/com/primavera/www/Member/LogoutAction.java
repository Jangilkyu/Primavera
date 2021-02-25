package com.primavera.www.Member;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.common.LoginSessionListener;

public class LogoutAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		LoginSessionListener lsl = LoginSessionListener.getInstance();
		
		String userId = lsl.getUserID(session);
		
		if(userId != null) {
			lsl.removeSession(userId);
		}
		
		
        //메인페이지로 이동
        ActionForward forward = new ActionForward();
        forward.setPath("views/index.do");
        forward.setRedirect(true);
        return forward;
	}

	
}
