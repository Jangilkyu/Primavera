<%@page import="com.primavera.www.common.LoginSessionListener"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    LoginSessionListener lsl = LoginSessionListener.getInstance();
    String id = lsl.getUserID(session);
    System.out.println(id);
%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
	<link rel="stylesheet" href = "http://localhost:8080/ChungChunPrj/css/style.css">
	<link rel="stylesheet" href="http://localhost:8080/ChungChunPrj/css/reset.css">
    <title>Primavera</title>
  </head>
  
  <body>
   
  	     <div class="black-background">  
	        <div class="white-backgrounds">
				<form action="loginProc.do" method="post">
					<div class="mb-3">
						<label for="exampleInputEmail1" class="form-label">아이디</label> 
						<input type="text" class="form-control" id="id" name="id" placeholder="아이디를 입력해주세요.">
					</div>
					<div class="mb-3">
						<label for="exampleInputPassword1" class="form-label">비밀번호</label>
						<input type="password" class="form-control" id="pwd" name="pwd" placeholder="비밀번호를 입력해주세요.">
					</div>
					<div class="mb-3 form-check">
						<input type="checkbox" class="form-check-input" id="exampleCheck1">
						<label class="form-check-label" for="exampleCheck1">기억하기</label>
					</div>
						<button type="submit" class="btn btn-primary" id="btn-login">로그인</button>
						<button type="button" class="btn btn-danger" id="btn-cancel">취소</button>
				</form>
			</div>       
	   	</div>
  
  	<div style="margin: 0 auto; width: 1420px">
	  	<div class="nav-container">
		       <p class="menu-logo"><a href="http://localhost:8080/ChungChunPrj/index.do">Primavera</a></p>
		       <span style="flex-grow: 10"></span>
		        <% if(id == null) {%>
		       <span class="menu-item"><a type="button" id="login">로그인</a></span>
		       <span class="menu-item"><a type="button" id="a" href="http://localhost:8080/ChungChunPrj/views/join.do">회원가입</a></span>
		       <span class="menu-item"><a href="myPage.do">마이페이지</a></span>
		       <%
		       		} else {
		       %>
			   <span class="menu-item"><a type="button"  href="logout.do">로그아웃</a></span>
			   <span class="menu-item"><a href="myPage.do">마이페이지</a></span>
		       <% } %>
	   </div>

		<div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
		    <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
		  </ol>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="http://localhost:8080/ChungChunPrj/img/img1.jpg"  class="d-block w-100 slide-img" alt="왜..">
		      <div class="carousel-caption d-none d-md-block">
		        <h5>First slide label</h5>
		        <p>Some representative placeholder content for the first slide.</p>
		      </div>
		    </div>
		    <div class="carousel-item">
		      <img src="http://localhost:8080/ChungChunPrj/img/img2.jpg"  class="d-block w-100 slide-img" alt="...">
		      <div class="carousel-caption d-none d-md-block">
		        <h5>Second slide label</h5>
		        <p>Some representative placeholder content for the second slide.</p>
		      </div>
		    </div>
		    <div class="carousel-item">
		      <img src="http://localhost:8080/ChungChunPrj/img/img3.jpg" class="d-block w-100 slide-img" alt="...">
		      <div class="carousel-caption d-none d-md-block">
		        <h5>3번째 라벨</h5>
		        <p>쇼핑몰</p>
		      </div>
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
		</div>
		
		<!-- li  -->
		<ul>
			<li><a href="pictureBoard.do">사진게시판</a></li>
			
		</ul>		
		
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
	<script>
	    $('#login').click(function(){
	        $('.black-background').show();
	    });
	    
	    $('#btn-cancel').click(function () {
			$('.black-background').hide();
		});
	</script>
  </body>
</html>