package com.primavera.www.Member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.service.ProductService;
import com.primavera.www.vo.ProductVo;

public class MyDetailWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ActionForward forward = new ActionForward();

		int no = Integer.parseInt(request.getParameter("no"));

		ProductService service = new ProductService();
		
		ArrayList<ProductVo> list = service.findDeatilProduct(no);

		forward.setPath("myDetailWrite.jsp");
		
		request.setAttribute("list", list);
		
		return forward;
	}

}
