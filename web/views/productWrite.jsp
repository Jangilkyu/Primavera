<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
<body>
    <h2>상품 등록</h2>
    <hr>
    
    <form action="productUpload.do" method="post"  method="post" enctype="multipart/form-data">
    <div class="write-wrap">
     <div class="row">
        <div class="col s12">
          <div class="row">
            <div class="input-field col s6">
              <i class="material-icons prefix">account_circle</i>
              <input id="name" name="name" type="text" class="validate">
              <label for="icon_prefix">상품 이름</label>
            </div>
           <div class="input-field col s6">
              <i class="material-icons prefix">phone</i>
              <input id="tel" name="tel" type="tel" class="validate">
              <label for="icon_telephone">전화번호</label>
          </div>
        <div class="row">
		    <div class="input-field col s6">
		      <input value="0" id="price" name="price" type="text" class="validate">
		      <label class="active" for="first_name2">가격</label>
		    </div>
		    <div class="input-field col s6">
		      <input id="addrress" name="address" type="text" class="validate">
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
              <textarea id="content" name="content" class="materialize-textarea"></textarea>
              <label for="textarea1">글 내용</label>
            </div>
          </div>
        </div>
      </div>
    <div class="file-field input-field">
      <div class="btn">
        <span>File</span>
        <input type="file" name="prodfname" id="prodfname" multiple>
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text" placeholder="Upload one or more files">
      </div>
    </div>
     <button class="btn waves-effect waves-light" type="submit" name="action">Submit
    <i class="material-icons right">send</i>
  	</button>
    </div>
    
    </form>    
</html>