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

public class ProductUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		ActionForward forward = new ActionForward();
		
		  LoginSessionListener lsl = LoginSessionListener.getInstance(); 
		  String id = lsl.getUserID(request.getSession());
		  
		  if (id == null) {
			  response.setContentType("text/html;charset=UTF-8");
			  PrintWriter out = response.getWriter();
			  out.println("<script>alert('로그인 후 후기 작성이 가능합니다.!'); location.href='/ChungChunPrj/index.do'; </script>");
			  out.close();
			  return null;
		  }

		String path = request.getRealPath("goods");

		// 이때 클라이언트가 업로드한 파일이 서버에 저장됩니다.
		// 그리고 클라이언트가 입력한 정보들도 multi객체에 담기게 됩니다.
		MultipartRequest multi = new MultipartRequest(request, path, 1024 * 1024 * 5, "utf-8",
				new DefaultFileRenamePolicy());

		int no = Integer.parseInt(multi.getParameter("no"));
		System.out.println(no+"adfkjaofa");
		String name = multi.getParameter("name");
		String tel = multi.getParameter("tel");
		int price = Integer.parseInt(multi.getParameter("price"));
		String address = multi.getParameter("address");
		String content = multi.getParameter("content");
		File file = multi.getFile("upload");
		String oldFname = multi.getParameter("fname");

		String fname = oldFname;
		if (file != null) {
			fname = multi.getFilesystemName("upload");
		}
		ProductService service = new ProductService();
		
		ProductVo vo = new ProductVo(no,name,content,tel,price,address,service.getMemberNo(id),fname,id);
		
		int re = service.updateProduct(vo);

		if (re == 1) { // 파일은 수정할 수도 있고 수정하지 않을 수도 있도록 하려는데
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('수정에 성공하였습니다.');</script>");
            
			// 파일을 수정 안했는데도 삭제가 일어 날 수 있다.
			if (file != null) {
				File oldFile = new File(path + "/" + oldFname);
				oldFile.delete();
			}
		} else {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('잘못된 접근입니다');</script>");
		}
		
		forward.setPath("myWrite.do");
		forward.setRedirect(true);
		return forward;
	}

}
