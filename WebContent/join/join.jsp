<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primavera : 회원가입</title>
</head>
<body>

	<div class="signup_container">
	<form action="http://localhost:8080/ChungChunPrj/join/joinAction.jsp" method="post">
		<table>
			<tr>
				<td>
					<label>아이디 : </label><input type="text" name="id" id="id"><a type="button" id="chckid" onclick="checkID()">아이디 중복검사</a>
					<p id="id_check"></p>
				</td>
			</tr>
			<tr>
				<td><label>비밀번호</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password"></td>
			</tr>
			<tr>
				<td>
					<label>이메일</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="email">			</select>
				</td>
			</tr>
			<tr>
				<td><label>이름</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"></td>
			</tr>
			<tr>
				<td><label>성별</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="gender">
								<option>선택</option>
								<option>남자</option>
								<option>여자</option>
								<option>선택안함</option>
								</select>
				</td>
			</tr>
			<tr>
				<td><label>비밀번호 확인</label><input type="password">&nbsp;</td>
			</tr>
		</table>
			<button type="submit">버튼</button>
		</form>
	</div>
		
	
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<script>
	
		function checkID(){
			let id = $('#id').val();
						
			// 아이디 null 검사
			if(id == ''){
	            $('#id_check').html('아이디는 필수 정보 입력입니다.').css('color', 'red');
	            $('#checkid').focus();
	            return false;
			}
			
			// 아이디 길이 검사
			if(id.length >= 20){
				$('#id_check').html('아이디는 20자를 초과할 수 없습니다.').css('color','red');
				$('#id').val('');
			}
			
	        var regExpEmail = new RegExp("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$", "g");
	        if (regExpEmail.exec(email) == null) {
	            toastr.error("잘못된 이메일 형식입니다.");
	            $('#email').val("");
	            $('#email').focus();
	            return false;
	        }
	        
	        
		}
		
	
	
	</script>
	
</body>
</html>