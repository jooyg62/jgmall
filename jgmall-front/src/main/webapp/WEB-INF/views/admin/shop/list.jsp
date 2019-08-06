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
        	<form method="post" action="${pageContext.servletContext.contextPath }/admin/shop/product" class="form-signin" name="productForm">
                <span>상품명: </span>
                <input class="form-control" placeholder="상품명" name="productNm" value="슈퍼 런닝화" required autofocus><br />
                <span>판매가격: </span>
                <input class="form-control" placeholder="판매가격" name="sellPrc" value="27000" ><br />
                <span>할인가격: </span>
                <input class="form-control" placeholder="할인가격" name="salePrc" value="13700" ><br />
                <span>판매여부: </span>
                <input type="radio" name="sellFl" value="Y" checked="checked"/><span>판매함</span>
                <input type="radio" name="sellFl" value="N" /><span>판매 안함</span><br />
                <span>진열여부: </span>
                <input type="radio" name="displaySt" value="Y" checked="checked"/><span>진열함</span>
                <input type="radio" name="displaySt" value="N" /><span>진열 안함</span><br /><br />
                <span>상품요약설명: </span>
                <input class="form-control" placeholder="상품요약설명" name="productDpt" value="기능성 슈퍼 런닝화 짱짱맨~~~" ><br />
                <input type="hidden" name="optionFl" value="N" ><!-- 옵션 사용 안함 -->
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">상품 등록</button>
            </form>
        </div>
        <!-- /.card-container -->
        <div>
        	<span>-------- 상품 리스트 --------</span>
        	<table>
        		<tr>
        			<td>상품명</td>
        			<td>판매가격</td>
        			<td>할인가격</td>
        			<td>상품요약설명</td>
        			<td>판매여부</td>
        			<td>진열여부</td>
        			<td>등록일</td>
        		</tr>
        		<c:forEach items='${vo.data}' var='item' varStatus='status'>
	        		<tr>
	        			<td>${item.productNm }</td>
	        			<td>${item.sellPrc }</td>
	        			<td>${item.salePrc }</td>
	        			<td>${item.productDpt }</td>
	        			<td>${item.sellFl }</td>
	        			<td>${item.displaySt }</td>
	        			<td>${item.regDate }</td>
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