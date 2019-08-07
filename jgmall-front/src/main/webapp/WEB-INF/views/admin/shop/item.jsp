<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Shop Homepage - Start Bootstrap Template</title>
	<!-- Bootstrap core CSS -->
	<link href="${pageContext.servletContext.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-item.css" rel="stylesheet">
</head>

<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="shopping" />
	</c:import>
	<!-- /.Navigation -->

	<!-- Page Content -->
	<div class="container">
		<div class="row">

			<div class="col-lg-3">
				<h1 class="my-4">JGMall</h1>
			</div>
			<!-- /.col-lg-3 -->

			<div class="col-lg-9">

				<div class="card mt-4">
					<img class="card-img-top img-fluid"
						src="http://placehold.it/900x400" alt="">
					<div class="card-body">
						<h3 class="card-title">${vo.data.productNm }</h3>
						<h4>${vo.data.sellPrc }</h4>
						<p class="card-text">
							${vo.data.productDpt }
						</p>
					</div>
				</div><br/>
				<!-- /.card -->
				<form method="post" action="${pageContext.servletContext.contextPath }/shop/basket/product/${vo.data.productNo}" class="form-signin" name="basketForm">
					<input type="hidden" name="optionNo" value="${vo.data.productOptVoList[0].optionNo }" />
					<input type="hidden" name="userNo" value="${mallAuthUser.no }" />
					<input type="hidden" name="productAmt" value="1" />
					<button class="btn btn-info" type="submit">장바구니 담기</button>
				</form>
				<br />
				<a href="#" class="btn btn-success">구매하기</a>
			</div>
			<!-- /.col-lg-9 -->

		</div>

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>