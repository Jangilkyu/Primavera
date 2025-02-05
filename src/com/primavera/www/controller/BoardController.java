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
import com.primavera.www.Member.MemberInfoAction;
import com.primavera.www.Member.MemberInfoProcAction;
import com.primavera.www.Member.MemberJoinProcAction;
import com.primavera.www.Member.MemberWriteAction;
import com.primavera.www.Member.MyDetailWriteAction;
import com.primavera.www.Member.MyPageAction;
import com.primavera.www.Member.myPagePro;
import com.primavera.www.action.HomeAction;
import com.primavera.www.board.ProductAction;
import com.primavera.www.board.ProductDeleteAction;
import com.primavera.www.board.ProductListAction;
import com.primavera.www.board.ProductProAction;
import com.primavera.www.board.ProductUpdateAction;
import com.primavera.www.board.ProductUpdateProAction;
import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.review.ReviewDetailAction;
import com.primavera.www.review.ReviewListAction;
import com.primavera.www.review.ReviewUploadAction;
import com.primavera.www.review.ReviewUploadProAction;

public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	HashMap<String,Action> map;
	
	
	public BoardController() {
    	
    	map = new HashMap<String, Action>();
    	
    	//회원
    	map.put("index.do", new HomeAction());
    	map.put("join.do",  new JoinAction());
    	map.put("joinProc.do", new MemberJoinProcAction());
    	map.put("loginProc.do", new LoginProAction());
    	map.put("logout.do", new LogoutAction());
    	map.put("myPage.do", new MyPageAction());
    	map.put("myPageProc.do", new myPagePro());
    	map.put("memberInfoUpdate.do", new MemberInfoAction());
    	map.put("memberInfoProc.do", new MemberInfoProcAction());
    	map.put("myWrite.do", new MemberWriteAction());

    	
    	map.put("productList.do", new ProductListAction());
    	
    	// 리뷰
    	map.put("myDetailWrite.do", new MyDetailWriteAction());
		map.put("reviewList.do", new ReviewListAction());
		map.put("reviewupload.do", new ReviewUploadAction());
		map.put("reviewUploadPro.do", new ReviewUploadProAction());
		map.put("reviewDetail.do", new ReviewDetailAction());
		map.put("rooms.do", new ProductAction());
		
		//product
		map.put("productWrite.do", new ProductAction());
		map.put("productUpload.do", new ProductProAction());
		map.put("productUpdate.do", new ProductUpdateAction());
		map.put("productUpdateProc.do", new ProductUpdateProAction());
		map.put("productDelete.do", new ProductDeleteAction());
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
