package com.primavera.www.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.Member.AjaxCheckIdAction;
import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;

public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HashMap<String,Action> map;
	
    public AjaxController() {
    		
    	map = new HashMap<String, Action>();
    	
    	// ! important ========= hashMap url 담는 클래스 만들기 !  =======
    	
    	map.put("checkID.ajax", new AjaxCheckIdAction());
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}//doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}//doPost

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

		String uri = request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(cmd);
		
		ActionForward forward = null;
		Action action = map.get(cmd);
				
		try {
			forward = action.execute(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
                RequestDispatcher dispatcher
                = request.getRequestDispatcher(forward.getPath());
                System.out.println(forward.getPath());
                dispatcher.forward(request, response);
			}
		}
		
	}//doProcess
	
}
