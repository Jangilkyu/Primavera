# 로그인 싸이클

<img src ="https://user-images.githubusercontent.com/69107255/111981674-53393c00-8b4b-11eb-9146-d6a9e3aac304.png">

## web(index.jsp)

<img src ="https://user-images.githubusercontent.com/69107255/111987130-263c5780-8b52-11eb-8450-6e264ad04a65.png">

## Controller
<img src ="https://user-images.githubusercontent.com/69107255/111987237-4d932480-8b52-11eb-8494-cc607234ff56.png">

<img src ="https://user-images.githubusercontent.com/69107255/111987298-67346c00-8b52-11eb-920e-210ff1fe13fa.png">


로그인 화면이다. 로그인화면 또한 부트스트랩을 통해 모달창 형식으로 구현하였다. 

<img src ="https://user-images.githubusercontent.com/69107255/111991071-3c004b80-8b57-11eb-8b9e-37dc40cd0c8e.png">


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

## Service

- dao.getPWD(id)를 호출해서 id에 일치하는 비밀번호를 가져온다. 

<img src="https://user-images.githubusercontent.com/69107255/111989527-3d307900-8b55-11eb-863b-1e1da72004da.png">

## MemberDao

- 조회된 회원에 패스워드를 호출했던 곳으로 전달해준다. 

<img src="https://user-images.githubusercontent.com/69107255/111989879-b039ef80-8b55-11eb-9b57-ca3b5387e64d.png">



## index.jsp

- session을 id로 상태유지하고 index.do로 이동한다.
```java
    LoginSessionListener lsl = LoginSessionListener.getInstance();
    lsl.setSession(request.getSession(), id);
```

- 위에서 상태유지한 세션을 받는다.

<img src ="https://user-images.githubusercontent.com/69107255/111988704-2a697480-8b54-11eb-9b17-e7070cb88e72.png">

- 로그인 전 화면과 로그인 후 화면을 세션이 유효한지에 따라서 처리해주었다.
<img src ="https://user-images.githubusercontent.com/69107255/111988800-4d942400-8b54-11eb-9224-3bc6192a66c4.png">


아이디에 따라서 세션이 잘 유지 되는것을 확인 할 수 있었다.

**로그인 전**
<img src ="https://user-images.githubusercontent.com/69107255/111990242-8208df80-8b56-11eb-998d-885c6dfdc3dd.png">

**로그인 후**
<img src ="https://user-images.githubusercontent.com/69107255/111990701-df049580-8b56-11eb-95cb-b76ff915168a.png">