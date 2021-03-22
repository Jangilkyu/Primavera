## 회원가입 사이클
<img src="https://user-images.githubusercontent.com/69107255/111951898-a00b1b80-8b27-11eb-9448-dfdf3fbfb606.png">


## join.jsp 화면

view 화면은 부트스트랩을 사용해서 html을 작성하였습니다.

- **회원가입 기능**
1. ajax을 이용한 아이디 중복검사.
2. BCrypt(비크립트)를 이용한 비밀번호 암호화
3. 카카오 지도 api를 이용한 우편번호 찾기

<img src ="https://user-images.githubusercontent.com/69107255/111958913-25df9480-8b31-11eb-970b-f69856a31366.png">


# 1.ajax을 이용한 아이디 중복 검사

web.xml에 *.ajax으로 AjaxController을 매핑하고 있다.
사용자가 아이디를 입력하고 `아이디 중복검사`를 클릭 시 
`AjaxCheckIdAction.java` 클래스로 이동 후 중복되는 아이디 있는지 확인한다.

```sql
SELECT COUNT(*) AS CNT FROM member WHERE ID = ?

if(중복 되는 아이디가 있다면)
    return 1
else 
    중복 되는 아이디가 없다면 0을 반환
```

## AjaxCheckJoin.jsp
AjaxCheckIdAction.java 에서 아래와 같이 상태 유지를 한 후 AjaxCheckJoin.jsp로 전달 한다. 
```jsp
    request.setAttribute("count", service.idCheck(id));
    forward.setPath("/ajax/AjaxCheckJoin.jsp");
```

**AjaxCheckJoin**

AjaxCheckIdAction에서 상태유지한 값을 받는다.

```jsp
    {"count" : "<%= request.getAttribute("count") %>"}
```

**join.jsp**

**중복되는 아이디가 있을 시**

<img src ="https://user-images.githubusercontent.com/69107255/111973321-b7ef9900-8b41-11eb-896c-3de317a43956.png" />


**중복되는 아이디가 없을 시**

<img src="https://user-images.githubusercontent.com/69107255/111973192-95f61680-8b41-11eb-8495-eb6bee9d6245.png">

ajax통신을 통해 checkID.ajax로 호출하고 완료 시  done을 통해 count에 값을 리턴 받는다.

```js
			/* 아이디 중복 검사  */
			let data = $('#id').serializeArray();
			
			$.ajax({
				url : "checkID.ajax",
				type : "post",
				data : data,
	            dataType: "json",
			}).done(function (data) {
				console.log(data.count);
                if (data.count == 0) {      //0 id미중복
                    $('#checkid').html('사용 가능한 아이디').css('color', 'blue');
                } else {                    //1 중복
                    $('#checkid').html('사용 불가능한 아이디').css('color', 'red');
                    $('#id').val('');
                    $('#id').focus();
                }
			}).fail(function () {
				alert("불편을 드려 진심으로 죄송합니다. 오류가 발생하였습니다. 빠른 처리를 위해 노력하겠습니다. ");	
				location.href = "index.jsp";
			});
```

# 2. BCrypt(비크립트)를 이용한 비밀번호 암호화

**member 테이블에 저장되어 있는 회원**
<img src ="https://user-images.githubusercontent.com/69107255/111965012-9938d480-8b38-11eb-8329-7b19c83a4569.png">

## **MemberJoinProcAction.java**
- Bcrypt.hashpw(password, salt)를 이용하여 패스워드를 해시한다.
- 회원가입 시 membervo에 사용자가 입력한 정보 값을 저장할 때 Salt: `BCrypt.gensalt()`를 통해 자동으로 랜덤 값을 받을 수 있다.
```java
		//회원가입 필요한 정보 Vo
		MemberVo membervo = new MemberVo(id,name,
				BCrypt.hashpw(password, BCrypt.gensalt(10)),email,gender,post1,post2,post3,tel1,tel2,tel3);
```