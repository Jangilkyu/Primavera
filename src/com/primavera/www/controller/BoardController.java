package com.primavera.www.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.Member.JoinAction;
import com.primavera.www.Member.LoginProAction;
import com.primavera.www.Member.LogoutAction;
import com.primavera.www.Member.MemberJoinProcAction;
import com.primavera.www.action.HomeAction;
import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.picture.PictureAction;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	HashMap<String,Action> map;
	
	
	public BoardController() {
    	
    	map = new HashMap<String, Action>();
    	
    	map.put("join.do",  new JoinAction());
    	map.put("joinProc.do", new MemberJoinProcAction());
    	map.put("index.do", new HomeAction());
    	map.put("loginProc.do", new LoginProAction());
    	map.put("logout.do", new LogoutAction());
		map.put("pictureBoard.do", new PictureAction());

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(cmd);
		
		ActionForward forward = null;
		Action action = map.get(cmd);
				
		try {
				forward = action.execute(request, response);
				System.out.println(forward);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
                RequestDispatcher dispatcher
                = request.getRequestDispatcher(forward.getPath());
        dispatcher.forward(request, response);
			}
		}
	}
}
