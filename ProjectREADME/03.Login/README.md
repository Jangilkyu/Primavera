# 로그인 싸이클

<img src ="https://user-images.githubusercontent.com/69107255/111981674-53393c00-8b4b-11eb-9146-d6a9e3aac304.png">

## web(index.jsp)

<img src ="https://user-images.githubusercontent.com/69107255/111987130-263c5780-8b52-11eb-8450-6e264ad04a65.png">

## Controller
<img src ="https://user-images.githubusercontent.com/69107255/111987237-4d932480-8b52-11eb-8494-cc607234ff56.png">

<img src ="https://user-images.githubusercontent.com/69107255/111987298-67346c00-8b52-11eb-920e-210ff1fe13fa.png">


## Action (LoginProAction.java)

- ValidMemberID(id)을 통해 존재하는 아이디가 있을 시 1을 반환한다. VALID는 상수이고 1이라는 값을 가지고 있다. 즉, 0일 경우 회원이 없는경우 경고창을 뿌려준다. 

```java
	if(service.ValidMemberID(id) != VALID) {
	    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('유효하지 않는 아이디입니다.'); location.href='/ChungChunPrj/views/index.do'; </script>");
        out.close();
        return null;
    }
```

- 회원이 입력한 비밀번호가 데이터베이스에 저장된 값과 비교한다. 
```java
    if(!BCrypt.checkpw(pwd,service.ValidMemberPWD(id))){
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('비밀번호를 확인해 주세요.');history.back();</script>");
        out.close();
        return null;
    }
```

- session을 id로 상태유지하고 index.do로 이동한다.
```java
    LoginSessionListener lsl = LoginSessionListener.getInstance();
    lsl.setSession(request.getSession(), id);
```

## index.jsp

- 위에서 상태유지한 세션을 받는다.

<img src ="https://user-images.githubusercontent.com/69107255/111988704-2a697480-8b54-11eb-9b17-e7070cb88e72.png">

- 로그인 전 화면과 로그인 후 화면을 세션이 유효한지에 따라서 처리해주었다.
<img src ="https://user-images.githubusercontent.com/69107255/111988800-4d942400-8b54-11eb-9224-3bc6192a66c4.png">