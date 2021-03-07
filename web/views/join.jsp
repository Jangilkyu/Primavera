<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primavera : 회원가입</title>
</head>
<body>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

	<div class="container" style="width: 1500px; margin: 0 auto;">
	            <form action="http://localhost:8080/ChungChunPrj/views/joinProc.do" class="form-horizontal" role="form" method="post">
	            <h2>회원가입 양식</h2>
      			<hr>
                <!-- 아이디 -->
                <label for="firstName" class="col-sm-3 control-label">아이디</label>
                <div class="form-inline">
                    <div class="col-sm-9">
                        <input type="text" id="id" name="id" placeholder="아이디" class="form-control">&nbsp;&nbsp;&nbsp;<button type="button"  class="form-control btn-primary" id="chckid" onclick="checkID()">아이디 중복검사</button>
                    <p id="checkid"></p>
                    </div>
                </div>
	                
	            <!-- 비밀번호 -->
	            <div class="form-group">
	                    <label for="password" class="col-sm-3 control-label">비밀번호</label>
	                    <div class="col-sm-9">
	                        <input type="password" id="password" name="password" placeholder="비밀번호" class="form-control">
	                    </div>
	                </div>
	                
	            <!-- 비밀번호 확인-->
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">비밀번호 확인</label>
                    <div class="col-sm-9">
                        <input type="password" id="password" name="passwordchk" placeholder="비밀번호" class="form-control">
                    </div>
                </div>
	                
	                
	                <!-- 이름 -->
	                <div class="form-group">
	                    <label for="text" class="col-sm-3 control-label">이름</label>
	                    <div class="col-sm-9">
	                        <input type="text" id="name" name="name" placeholder="이름" class="form-control">
	                    </div>
	                </div>
	                
	                <!-- 이메일 -->
	                <div class="form-group">
	                    <label for="text" class="col-sm-3 control-label">Email</label>
	                    <div class="col-sm-9">
	                        <input type="email" id="email" name="email" placeholder="이메일" class="form-control">
	                    </div>
	                </div>
	                
	                <!-- 성별 -->
	                <div class="form-group">
	                    <label class="control-label col-sm-3">성별</label>
	                    <div class="col-sm-6">
	                        <div class="row">
	                            <div class="col-sm-4">
	                                <label class="radio-inline">
	                                    <input type="radio" id="femaleRadio" name="gender" value="남자">남자
	                                </label>
	                            </div>
	                            <div class="col-sm-4">
	                                <label class="radio-inline">
	                                    <input type="radio" id="maleRadio" name="gender" value="여자">여자
	                                </label>
	                            </div>
	                            <div class="col-sm-4">
	                                <label class="radio-inline">
	                                    <input type="radio" id="uncknownRadio" name="gender" value="선택안함">선택안함
	                                </label>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	                
	                <!-- 우편번호  -->
	                <label for="zipcode" class="col-sm-3 control-label">우편번호</label>
	                <div class="form-inline col-sm-4" role="form">
	                       <div class="form-group">
	                          <input type="text" class="form-control" id="post1" name="post1" placeholder="우편번호">                
	                            &nbsp;&nbsp;&nbsp;
	                          <input type="text" class="form-control" id="post2" name ="post2" placeholder="주소">
	                          &nbsp;&nbsp;&nbsp;
	                          <input type="text" class="form-control" id="post3" name="post3" placeholder="세부 주소">
	                          &nbsp;&nbsp;&nbsp;
	          				  <input type="button"  class="form-control btn-alert btn-primary" value="우편번호 찾기" onclick="PostCode()"></td>
	                       </div>
	                </div> 
	                <div>&nbsp;</div>
	                <!-- 전화번호  -->
	                <label for="tel" class="col-sm-3 control-label">전화번호</label>
	                <div class="form-inline col-sm-4" role="form">
	                       <div class="form-group">
	                        <select  class="form-control" name="tel1" id="tel1">
							<option value="010">010</option>
							<option value="011">011</option>
							<option value="016">016</option>
						</select>-
						<input type="text" class="form-control" name="tel2" id="tel2">-
						<input type="text" class="form-control" name="tel3" id="tel3">
	
	                       </div>
	                </div> 
	                <div>&nbsp;</div>
	                <!-- 제출 -->
	                <div class="form-group">
	                    <div class="col-sm-9 col-sm-offset-3">
	                        <button type="submit" class="btn btn-primary btn-block">Register</button>
	                    </div>
	                </div>
	            </form> 
	        </div> 

<!-- 	<div class="signup_container">
	<form action="http://localhost:8080/ChungChunPrj/views/joinProc.do" method="post">
		<table>
			<tr>
				<td>
					<label>아이디 : </label><input type="text" name="id" id="id"><button type="button" id="chckid" onclick="checkID()">아이디 중복검사</button>
					<p id="checkid"></p>
					<p id="checka"></p>
				</td>
			</tr>
			<tr>
				<td><label>비밀번호</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password"></td>
			</tr>
			<tr>
				<td><label>비밀번호 확인</label><input type="password" name="passwordchk"></td>
			</tr>
			<tr>
				<td>
					<label>이메일</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="email">	
				</td>
			</tr>
			<tr>
				<td><label>이름</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="name"></td>
			</tr>
			<tr>
				<td><label>우편번호</label>
					<input type="text" id="post1" name="post1" placeholder="주소">
					<input type="text" id="post2" name="post2" placeholder="우편번호"> 
					<input type="text" id="post3" name="post3">
				<input type="button"  value="우편번호 찾기" onclick="PostCode()"></td>
			</tr>
			<tr>
				<td><label>성별</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<select name="gender">
								<option>선택</option>
								<option>남자</option>
								<option>여자</option>
								<option>선택안함</option>
							</select>
				</td>
			</tr>
			<tr>
			<td>
			아임포트 api 사용<br>
			전화번호: <select name="tel1" id="tel1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
					</select>-
					<input type="text" name="tel2" id="tel2">-
					<input type="text" name="tel3" id="tel3">
			</tr>
		</table>
			<button type="submit">버튼</button>
		</form>
	</div> -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<script>
	toastr.options = {
			  "closeButton": true,
			  "debug": false,
			  "newestOnTop": false,
			  "progressBar": true,
			  "positionClass": "toast-top-right",
			  "preventDuplicates": false,
			  "onclick": null,
			  "showDuration": "300",
			  "hideDuration": "1000",
			  "timeOut": "5000",
			  "extendedTimeOut": "1000",
			  "showEasing": "swing",
			  "hideEasing": "linear",
			  "showMethod": "fadeIn",
			  "hideMethod": "fadeOut"
	}
	
		function checkID(){
			let id = $.trim($('#id').val());
			
			/* 아이디 값 비어있는지 검사 */
			if(id == ''){
	            $('#checkid').html('아이디는 필수 정보 입력입니다.').css('color', 'red');
	            $('#id').focus();
	            return false;
			}
			
			/* 아이디 길이 검사  */
			if(id.length >= 13){
				$('#checkid').html('아이디는 13자를 초과할 수 없습니다.').css('color','red');
				$('#id').val('');
				return false;
			}

			
			/* 아이디 중복 검사  */
			let data = $('#id').serializeArray();
			
			$.ajax({
				url : "checkID.ajax",
				type : "post",
				data : data,
	            dataType: "json",
			}).done(function (data) {
				console.log(data.count);
                if (data.count == 0) {      //0 id미중복
                    $('#checkid').html('사용 가능한 아이디').css('color', 'blue');
                } else {                    //1 중복
                    $('#checkid').html('사용 불가능한 아이디').css('color', 'red');
                    $('#id').val('');
                    $('#id').focus();
                }
			}).fail(function () {
				alert("불편을 드려 진심으로 죄송합니다. 오류가 발생하였습니다. 빠른 처리를 위해 노력하겠습니다. ");	
				location.href = "index.jsp";
			});
		}
	</script>
	
	<!-- 우편번호 -->
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