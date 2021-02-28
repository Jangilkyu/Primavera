package com.primavera.www.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.service.ReviewService;
import com.primavera.www.vo.ReviewVo;

public class ReviewDetailAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		ActionForward forward = new ActionForward();
		
		int r_no = Integer.parseInt(request.getParameter("r_no"));
		
		ReviewService service = new ReviewService();
		
	    ArrayList<ReviewVo> list = service.getDetailReview(r_no);
		
	    request.setAttribute("list", list);
	    
		forward.setPath("reviewDetail.jsp");
		
		return forward;
	}

	
}
