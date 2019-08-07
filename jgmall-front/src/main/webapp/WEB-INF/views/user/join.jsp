<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-login.css" rel="stylesheet">
</head>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="login" />
	</c:import>
	<!-- /.Navigation -->

 	<div class="container">
 		<div class="card card-container">
            <form method="post" action="${pageContext.servletContext.contextPath }/user/join" class="form-signin" name="joinForm">
                <span id="reauth-email" class="reauth-email"></span>
                <span>아이디: </span>
                <input type="input" id="inputId" class="form-control" placeholder="아이디" name="userId" value="dooly1234" required autofocus>
                <span>패스워드: </span>
                <input type="password" id="inputPassword" class="form-control" placeholder="비밀번호" name="password" value="!@dooly1234">
                <span>이름: </span>
                <input type="input" id="inputName" class="form-control" placeholder="이름" name="userNm" value="둘리">
                <span>휴대번호: </span>
                <input type="input" id="inputTel" class="form-control" placeholder="휴대번호" name="telNum" value="01055556666">
                <span>성별: </span>
                <input type="radio" name="gender" value="M" checked="checked"/><span>남자</span>
                <input type="radio" name="gender" value="F" /><span>여자</span><br />
                <span>나이: </span>
                <input type="input" id="inputAge" class="form-control" placeholder="나이" name="age" value="124">
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">회원가입</button>
            </form>
        </div>
        <!-- /.card-container -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>