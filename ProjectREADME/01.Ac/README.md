`Action interface`와 `ActionForward class`를 생성 후
 Action interface의 자손 클래스인 ???Action.java를 생성 하고, 각각의 Action 객체마다 path를 저장시켜 보내줄 수 있다.

## [Action]클래스

```java
public interface Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
```

## [ActionForward]클래스

ActionForward 클래스는 페이지 이동 처리를 하는 클래스 이다.

- path : 이동할 페이지 경로를 가지고 있는 String 변수이다.
- redirect : sendRedirect 와 forward 둘 중 어떤 걸 이용해서 페이지를 이동할지 결정하는 boolean 변수이다. 

```java
package com.primavera.www.common;

public class ActionForward {

	String path; // 경로 정보
	boolean redirect; // true => redirect | false => dispatcher
	
	public ActionForward() {
	}

	public ActionForward(String path, boolean redirect) {
		this.path = path;
		this.redirect = redirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	
}
```

## **web.xml**
`com.primavera.www.controller.BoardController 클래스`를 
`*.do`매핑 방식으로 설정하였다.

클라이언트가 xxx.do를 요청 시 Controller에서는 map에 key값에 xxx.do가 있는 값에 클래스를 실행한다. 

<img src="https://user-images.githubusercontent.com/69107255/111912831-c2148780-8aae-11eb-89b6-ade5438f79fc.png">


## Controller

`web.xml`에 등록했 던 BoardController클래스를 생성하였다.
```java
package com.primavera.www.controller;

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
		map.put("productDetailList.do", new ProductDetailAction());
    }//BoardController

	/**
	 * GET 방식 doGet()
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}//doGet

	/**
	 * POST 방식 doPost()
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}// doPost
	
	/**
	 * 명령어에 따른 Action을 지정해준다.
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 넘어온 uri를 담는다.
		String uri = request.getRequestURI();
		
		// uri중에서 command를 추출한다.
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		
		ActionForward forward = null;

		// map에 담겨있는 cmd 즉 "xxx.do"경로를 찾아서 안에 있는 값(객체)를 실행한다.
        // 즉 각 command에 해당하는 action을 실행하게 된다.
		Action action = map.get(cmd);
				
		try {
			forward = action.execute(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}//end catch
		
        // 화면이동 - isRedirect() 값에 따라 sendRedirect 또는 forward를 사용
        // sendRedirect : 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
        // forward : 현재 실행중인 페이지와 forwad에 의해 호출될 페이지는 request와 response 객체를 공유
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
                RequestDispatcher dispatcher
                = request.getRequestDispatcher(forward.getPath());
        dispatcher.forward(request, response);
			}//end else
		}//end if
	}//doProcess
}// class

```
