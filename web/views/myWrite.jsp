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

<h2>내가 작성한 글</h2>
<hr>

<table border="1" width="80%" class="highlight">
	<tr>
		<th>상품번호</th>
		<th>상품제목</th>
		<th>작성자</th>
	</tr>
 <c:forEach var ="b" items="${list }">
	<tr>
		<td>${b.no }</td>
		<td><a href="myDetailWrite.do?no=${b.no }">${b.name }</a></td>
		<td>${b.id }</td>
	</tr>
 </c:forEach>
</table>
</body>
</html>