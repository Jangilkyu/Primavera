package com.primavera.www.board;

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
import com.primavera.www.service.ProductService;
import com.primavera.www.vo.ProductVo;

public class ProductProAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");

		LoginSessionListener lsl = LoginSessionListener.getInstance();
		String id = lsl.getUserID(request.getSession());

		if (id == null) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인 후 후기 작성이 가능합니다.!'); location.href='/ChungChunPrj/views/index.do'; </script>");
			out.close();
			return null;
		}
		
		
		//상품 이미지 업로드
		String path =  request.getRealPath("goods");
		System.out.println(path);
		MultipartRequest multi 
		= new MultipartRequest(request, path , 5 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		
		String name = multi.getParameter("name");
		String content = multi.getParameter("content");
		String tel = multi.getParameter("tel");
		String address = multi.getParameter("address");
		int price = Integer.parseInt(multi.getParameter("price")); 
		File prodfname = multi.getFile("prodfname");
		
		String fname = "";
		if(prodfname != null){
			fname = multi.getFilesystemName("prodfname");
		}
		ProductService service = new ProductService();
		
		ProductVo vo = new ProductVo();
		vo.setName(name);
		vo.setContent(content);
		vo.setTel(tel);
		vo.setPrice(price);
		vo.setAddress(address);
		vo.setFname(fname);
		vo.setM_no(service.getMemberNo(id));
		
		
		if(!service.insertProduct(vo)) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('글 저장에 실패했습니다.');history.back();</script>");
            out.close();
            return null;	
		}
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("productWrite.jsp");
		
		return forward;
	}
}
