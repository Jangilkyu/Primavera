<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</head>
<body>

<table class="striped">
	<tr>
		<th>마이페이지 메뉴</th>
	</tr>
	<tr>
		<td><a href="memberInfoUpdate.do">회원 정보 변경</a></td>
	</tr>
	<tr>
		<td><a href="myWrite.do">내가 올린 상품</a></td>
	</tr>
	<tr>
		<td><a href="productWrite.do">상품 올리기</a></td>
	</tr>
	<tr>
		<td><a href="reviewupload.do">이용 후기 사진게시판 올리기</a></td>
	</tr>
	<tr>
		<td><a href="index.do">메인페이지로 돌아가기</a></td>
	</tr>
</table>

</body>
</html>