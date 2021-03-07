<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css" rel="stylesheet"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
</head>
<body>


		<form action="myPageProc.do" method="post">
	<c:forEach var="m" items="${list }">
	     <div class="row">
	        <div class="input-field col s12">
	          <input readonly="readonly" value="${m.id }" id="id" name="id" type="text" class="validate">
	          <label for="disabled">아이디</label>
	        </div>
	      </div>
      <div class="row">
        <div class="input-field col s6">
          <input placeholder="이름" value="${m.name }" id="name" name="name" type="text" class="validate">
          <label for="first_name">이름</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input type="text" value="${m.email }" id="email" name="email" class="validate">
          <label for="email">Email</label>
        </div>
      </div>
    <div class="row">
        <div class="input-field col s1">
          <input type="text"  value="${m.tel1 }" id="tel1" name="tel1"class="validate">
          <label for="first_name">전화번호</label>
        </div>
        <div class="input-field col s1">
          <input i value="${m.tel2 }" id="tel2" name="tel2" type="text" class="validate">
        </div>
        <div class="input-field col s1">
          <input  id="post3" name="tel3" value="${m.tel3 }" id="last_name" type="text" class="validate">
        </div>
      </div>
      
      <div class="row">
        <div class="input-field col s1">
          <input type="text" id="post1" name="post1" placeholder="우편번호" value="${m.post1 }"class="validate">
          <label for="first_name">우편번호</label>
        </div>
        <div class="input-field col s3">
          <input id="post2" name="post2" placeholder="우편번호" value="${m.post2 }" type="text" class="validate">
          <label for="last_name">주소</label>
        </div>
        <div class="input-field col s5">
          <input  id="post3" name="post3" value="${m.post3 }" id="last_name" type="text" class="validate">
          <label for="last_name">세부주소</label>
        </div>
          <a class="waves-effect waves-light btn-large" onclick="PostCode()">우편번호 검색</a>
      </div>
		
		  <button class="btn waves-effect waves-light" type="submit">변경사항 저장하기
  		  <i class="material-icons right">send</i>
 		 </button>
		</c:forEach>
		
		</form>	

<%-- 
    <form class="col s12"  action="myPageProc.do" method="post">
  <div class="row">
    <c:forEach var="m" items="${list }">
     <div class="row">
        <div class="input-field col s12">
          <input disabled value="${m.id }" id="id" name="id" type="text" class="validate">
          <label for="disabled">아이디</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s6">
          <input placeholder="이름" value="${m.name }" id="name" name="name" type="text" class="validate">
          <label for="first_name">이름</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input type="text" value="${m.email }" id="email" name="email" class="validate">
          <label for="email">Email</label>
        </div>
      </div>
    <div class="row">
        <div class="input-field col s1">
          <input type="text"  value="${m.tel1 }" id="tel1" name="tel1"class="validate">
          <label for="first_name">전화번호</label>
        </div>
        <div class="input-field col s1">
          <input value="${m.tel2 }" id="tel2" name="tel2" type="text" class="validate">
        </div>
        <div class="input-field col s1">
          <input  id="post3" name="tel3" value="${m.tel3 }" id="last_name" type="text" class="validate">
        </div>
      </div>
      
      <div class="row">
        <div class="input-field col s1">
          <input type="text" id="post1" name="post1" placeholder="우편번호" value="${m.post1 }"class="validate">
          <label for="first_name">우편번호</label>
        </div>
        <div class="input-field col s3">
          <input id="post2" name="post2" placeholder="우편번호" value="${m.post2 }" type="text" class="validate">
          <label for="last_name">주소</label>
        </div>
        <div class="input-field col s5">
          <input  id="post3" name="post3" value="${m.post3 }" id="last_name" type="text" class="validate">
          <label for="last_name">세부주소</label>
        </div>
          <a class="waves-effect waves-light btn-large" onclick="PostCode()">우편번호 검색</a>
      </div>
    </c:forEach>
          <button class="btn waves-effect waves-light" type="submit" >변경하기
   		  <i class="material-icons right">send</i></button>
  </div>
    </form>
	 --%>
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