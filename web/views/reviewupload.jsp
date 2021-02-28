<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://localhost:8080/ChungChunPrj/css/reviewupload.css">
</head>
<body>

<div class="reviewPost-wrapper">
 <form action="reviewUploadPro.do" method="post" enctype="multipart/form-data">
	<span>상품 이름</span>
	<div>
        <select class="" name="prodlist">
            <option>구매하신 상품이 없습니다.</option>
        </select>
    </div>
	<textarea rows="30" cols="100" name="prodcontent" id ="prodcontent">	</textarea><br>	
	
	<input type="file" name="prodfname">

	<input type="submit" value="저장하기" id="submit" onclick="btnSubmit(event)">
	
	<select name="star">
	    <option>평점주기</option>
		<option value="1">★</option>
		<option value="2">★★</option>
		<option value="3">★★★</option>
		<option value="4">★★★★</option>
		<option value="5">★★★★★</option>
	</select>
</form>
</div>
<a href="reviewDetail.do">목록으로 가기</a>
</body>

<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>

	var text = $('#prodcontent').val();
	
	function btnSubmit(e) {
/* 		if (text.replace(/\s|　/gi,"").length == 0){
			alert("내용을 입력하세요.");
			e.preventDefault();
			return; 
		} */
	}
	
</script>

</html>