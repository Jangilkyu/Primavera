<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


		<div class ="wrap">
			<c:forEach var="r" items="${list }">
				<div>
				    <div class="row">
		     			 <div class="col s1">
		     			 	<a href="reviewDetail.do?r_no=${r.r_no }"><img src="../upload/${r.fname }" width="200" height="200">
		     			 	${r.title }
		     			 	</a>
		     			 </div>
		   			 </div>
				</div>
<%-- 			
						<td>${r.r_no}</td>
						<td>${r.content }</td>
						<td>${r.star }</td>
						<td>${r.writeDate }</td>
						<td><img src="../upload/${r.fname }" width="200" height="200"></td>
						<td>${r.id }</td> --%>
			</c:forEach>
			</div>
		<a href="reviewupload.do">글올리기</a>
</body>
</html>