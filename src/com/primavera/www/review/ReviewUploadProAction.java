package com.primavera.www.review;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.primavera.www.common.Action;
import com.primavera.www.common.ActionForward;
import com.primavera.www.common.LoginSessionListener;
import com.primavera.www.service.ReviewService;
import com.primavera.www.vo.ReviewVo;

public class ReviewUploadProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		request.setCharacterEncoding("UTF-8");

		LoginSessionListener lsl = LoginSessionListener.getInstance();
		String id = lsl.getUserID(request.getSession());

		if (id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 후기 작성이 가능합니다.!'); location.href='/ChungChunPrj/index.do'; </script>");
			out.close();
			return null;
		}

		//후기 이미지 업로드
		String path =  request.getRealPath("upload");
		System.out.println(path);
		MultipartRequest multi 
		= new MultipartRequest(request, path , 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		
		String prodlist = multi.getParameter("prodlist");
		String prodcontent = multi.getParameter("prodcontent");
		File prodfname = multi.getFile("prodfname");
		String fname = "";
		if(prodfname != null){
			fname = multi.getFilesystemName("prodfname");
		}
		
		int star = Integer.parseInt(multi.getParameter("star"));
		
		ReviewService service = new ReviewService();
		
		ReviewVo reviewVo = new ReviewVo();
		reviewVo.setTitle(prodlist);
		reviewVo.setContent(prodcontent);
		reviewVo.setFname(fname);
		System.out.println(fname);
		reviewVo.setM_no(service.getMemberNo(id));
		reviewVo.setStar(star);
		
		int r =service.insertReview(reviewVo);
		/*if(service.insertReview(reviewVo) != 1) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('글 저장에 실패했습니다.');history.back();</script>");
            out.close();
            return null;			
		}*/

		// 메인 페이지 이동
		ActionForward forward = new ActionForward();
		forward.setPath("views/index.do");
		forward.setRedirect(true);
		return forward;

	}

}
