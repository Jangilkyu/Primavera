<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<form action="myPageProc.do" method="post">
	<c:forEach var="m" items="${list }">
				<span>아이디</span>
				<input type="text" value="${m.id }" readonly="readonly" id="id" name="id"><br>
				<span>이름</span>
				<input type="text" value="${m.name }" id="name" name="name"><br>
				<span>email</span>
				<input type="text" value="${m.email }" id="email" name="email"><br>
				<span>전화번호</span>
				<input type="text" value="${m.tel1 }" id="tel1" name="tel1">-
				<input type="text" value="${m.tel2 }" id="tel2" name="tel2">-<input type="text" value="${m.tel3 }" id="tel2" name="tel3"><br>
				<span>우편번호</span>
				<input type="text" id="post1" name="post1" placeholder="우편번호" value="${m.post1 }">
				<span>주소</span>
				 <input type="text" id="post2" name="post2" placeholder="주소" value="${m.post2 }">
				 <input type="text" id="post3" name="post3" value="${m.post3 }">
				 <input type="button"  value="우편번호 찾기" onclick="PostCode()"><br>
				<input type="submit" value="변경사항 저장하기">
		</c:forEach>
		</form>	
	
	<!-- 우편번호 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	function PostCode(){
		daum.postcode.load(function (data) {
		    new daum.Postcode({
		        oncomplete: function(data) {
		        	//주소 변수
		        	let = '';
		        	//클라이언트가 도로명 주소를 클릭 했을 경우
		        	if(data.userSelectedType === 'R'){
		        		addr = data.roadAddress;
		        	}
		        	else {
		        		//지번 주소 클릭했을 경우
		        		addr = data.jibunAddress;
		        	}
					document.getElementById("post1").value = data.zonecode;
					document.getElementById("post2").value = addr;
		        }
		    }).open();
		});
	}
	</script>
</body>
</html>