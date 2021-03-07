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
            

</head>
<body>

	<c:forEach var="r" items="${list }" >
	
		<img class="materialboxed" src ="../upload/${r.fname }" style="width: 200px;">
	
		${r.title }
	
		${r.id }
		
		${r.content }
		
		${r.star }
		
	</c:forEach>
      <script type="text/javascript" src="js/materialize.min.js"></script>

	<script>
	  document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('.materialboxed');
		    var instances = M.Materialbox.init(elems, options);
		  });

		  // Or with jQuery

		  $(document).ready(function(){
		    $('.materialboxed').materialbox();
		  });
	</script>
</body>
</html>