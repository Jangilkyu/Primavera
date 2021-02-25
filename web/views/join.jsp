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
				<td><label>우편번호</label><input type="text" id="zipcode" name="zipcode" placeholder="주소"> <input type="text" id="addr" name="addr" placeholder="우편번호"> <input type="button"  value="우편번호 찾기" onclick="PostCode()"></td>
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
			<td>
			아임포트 api 사용<br>
			전화번호: <input name="tel" ></td>
			</tr>
		</table>
			<button type="submit">버튼</button>
		</form>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
	<script>
		function checkID(){
				let data = $('#id').serializeArray();
				
				$.ajax({
					url : "checkID.ajax",
					type : "post",
					data : data,
		            dataType: "json",
				}).done(function (data) {
					console.log(data.count);
	                if (data.count == 0) {      //0 id미중복
	                    $('#checka').html('사용 가능한 아이디').css('color', 'blue');
	                } else {                    //1 중복
	                    $('#checka').html('사용 불가능한 아이디').css('color', 'red');
	                    $('#id').val('');
	                    $('#id').focus();
	                }
				}).fail(function () {
					alert("불편을 드려 진심으로 죄송합니다. 오류가 발생하였습니다. 빠른 처리를 위해 노력하겠습니다. ");	
					location.href = "index.jsp";
				});
				
			let id = $.trim($('#id').val());
			
			// 아이디 null 검사
			if(id == ''){
	            $('#checkid').html('아이디는 필수 정보 입력입니다.').css('color', 'red');
	            $('#id').focus();
	            return false;
			}
			
			// 아이디 길이 검사
			if(id.length >= 20){
				$('#checkid').html('아이디는 20자를 초과할 수 없습니다.').css('color','red');
				$('#id').val('');
			}
			
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
					document.getElementById("zipcode").value = data.zonecode;
					document.getElementById("addr").value = addr;
		        }
		    }).open();
		});
	}
	</script>

</body>
</html>