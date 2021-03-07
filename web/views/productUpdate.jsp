<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
    
        <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link rel="stylesheet" href="http://localhost:8080/ChungChunPrj/css/write.css">
</head>
<body>
    <h2>상품 수정</h2>
    <hr>
    
    <form action="productUpdateProc.do" method="post" enctype="multipart/form-data">
    <c:forEach var="p" items="${list }">
    <input type="hidden" name="no" value="${p.no }">
    <div class="write-wrap">
     <div class="row">
        <div class="col s12">
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">account_circle</i>
              <input id="icon_prefix" type="text" name="name" id="name" class="validate" value="${p.name }">
              <label for="icon_prefix">상품 이름</label>
            </div>
           <div class="input-field col s6">
              <i class="material-icons prefix">phone</i>
              <input id="icon_telephone" type="tel" name="tel" id="tel" class="validate" value="${p.tel }">
              <label for="icon_telephone">전화번호</label>
          </div>
        <div class="row">
		    <div class="input-field col s6">
		      <input id="first_name2" type="text" name="price" id="price" class="validate" value="${p.price }">
		      <label class="active" for="first_name2">가격</label>
		    </div>
		    <div class="input-field col s6">
		      <input  id="first_name2" name="address" id="address" type="text" class="validate" value="${p.address }">
		      <label class="active" for="first_name2">주소</label>
		    </div>
	 	</div>
          </div>
        </div>
      </div>

      <div class="row">
        <div class="col s12">
          <div class="row">
            <div class="input-field col s12">
              <i class="material-icons prefix">comment</i>
              <textarea id="textarea1" class="materialize-textarea" name="content">${p.content }</textarea>
              <label for="textarea1">글 내용</label>
            </div>
          </div>
        </div>
      </div>
    <div class="file-field input-field">
      <div class="btn">
        <span>File</span>
        <input type="hidden" name="fname"  value="${p.fname}">
        <input type="file" name="upload">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text" placeholder="Upload one or more files">
      </div>
    </div>
    </div>
        </c:forEach>
     <button class="btn waves-effect waves-light" type="submit" name="action">Submit
    <i class="material-icons right">send</i>
  </button>
    </form>    
</body>
</html>