package com.primavera.www.picture;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;

public class PictureAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ActionForward forward = new ActionForward();
		
		forward.setPath("board/pictureBoard.jsp");
		
		return forward;
	}

	
}
