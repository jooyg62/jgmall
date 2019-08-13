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
<script src="${pageContext.servletContext.contextPath}/assets/js/jquery/jquery.js"></script>
<script>
$(function(){

	
});

</script>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/admin-navigation.jsp'>
		<c:param name="active" value="login" />
	</c:import>
	<!-- /.Navigation -->
	<div class="container">
        <div>
        	<h3>주문목록 리스트</h3>
        	<table class="table table-hover">
        		<tr>
        			<td>주문번호</td>
        			<td>상품번호</td>
        			<td>상품명</td>
        			<td>반품여부</td>
        			<td>주문수량</td>
        			<td>상태</td>
        			<td>결제금액</td>
        		</tr>
        		<c:forEach items='${vo.data}' var='item' varStatus='status'>
	        		<tr class="items">
	        			<td>${item.orderNo }</td>
	        			<td>${item.productNo }</td>
	        			<td>${item.productNm }</td>
	        			<td>${item.returnFl }</td>
	        			<td>${item.orderAmt }</td>
	        			<td>배송중</td>
	        			<td><fmt:formatNumber value="${item.payPrc }" pattern="#,###"/></td>
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