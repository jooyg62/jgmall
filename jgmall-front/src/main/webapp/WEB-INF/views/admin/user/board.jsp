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
	<c:import url='/WEB-INF/views/includes/admin-navigation.jsp'>
		<c:param name="active" value="login" />
	</c:import>
	<!-- /.Navigation -->

 	<div class="container">
 		<div class="card card-container">
            	신규 회원수: ${vo.data.joinTodayCount} 
            	<br/>
            	전체 회원수: ${vo.data.totalUserCount}
        </div>
        <!-- /.card-container -->
        <div>
        	<span>-------- 회원 리스트 현황 --------</span>
        	<table>
        		<tr>
        			<td>아이디</td>
        			<td>가입일</td>
        			<td>이름</td>
        			<td>휴대전화</td>
        			<td>성별</td>
        			<td>나이</td>
        		</tr>
        		<c:forEach items='${vo.data.userInfoList}' var='item' varStatus='status'>
	        		<tr>
	        			<td>${item.userId }</td>
	        			<td>${item.joinDate }</td>
	        			<td>${item.userNm }</td>
	        			<td>${item.telNum }</td>
	        			<td>${item.gender }</td>
	        			<td>${item.age }</td>
	        		</tr>
        		</c:forEach>
        	</table>
        </div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>