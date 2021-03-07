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
<link rel="stylesheet" href="http://localhost:8080/ChungChunPrj/css/review.css">
</head>
<body>
			<div id="best">
				<div class="best-title">
					<h2>리뷰 게시판</h2>
				</div>
				<div class="best-wrap">
			<c:set var="a" value="0"></c:set>
			<div class="bestline first">
			<c:forEach var="r" items="${list }">
				<c:set var="a" value="${a+1 }"/>
				<c:if test="${a >= 4 }">
				<c:set var="a" value="0"/>
				</c:if>				
				<ul class="items">
					<li class="best-item-image"><a href="reviewDetail.do?r_no=${r.r_no }"><img src="../upload/${r.fname }" width="200" height="200"></a></li>
					<li class="title"><a href="reviewDetail.do?r_no=${r.r_no }" class="a">${r.title }</a></li>
				</ul>
			</c:forEach>
					</div>
				</div>
			</div>
</body>
</html>