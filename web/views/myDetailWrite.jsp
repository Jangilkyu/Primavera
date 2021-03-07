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
     <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
</head>
<body>

	<c:forEach var="p"  items="${list }">
	<img src="../goods/${p.fname }" style="width: 200px; height: 200px">		
		${p.no }
		${p.name }
		${p.tel }
		${p.price }
		${p.address }
		${p.write_date }
		${p.id }		
	</c:forEach>

	<a class="waves-effect waves-light btn-small" href="../views/myPage.do"><i class="material-icons left">mode_edit</i>글 목록</a>
	<a class="waves-effect waves-light btn-small" href="productUpdate.do?no=${list.get(0).no }"><i class="material-icons left">mode_edit</i>글 수정</a>
	<a class="waves-effect waves-light btn-small" href="productDelete.do?no=${list.get(0).no }"><i class="material-icons left">mode_edit</i>글 삭제</a>

</body>
</html>	