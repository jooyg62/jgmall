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
	<link href="${pageContext.servletContext.contextPath }/assets/css/shop-homepage.css" rel="stylesheet">
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

			<div class="col-lg-12">
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#carouselExampleIndicators" data-slide-to="0"
							class="active"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
						<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block img-fluid" src="https://images.kolonmall.com/cms/banner/2019/08/main_pc-709ace36-5582-4d13-b309-0ed5037607ae.jpg"
								onerror="this.src='http://placehold.it/900x350'" alt="First slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="https://images.kolonmall.com/cms/banner/2019/07/main_pc-fba912ef-f36a-472e-a4be-b4f3b32b1354.jpg"
								onerror="this.src='http://placehold.it/900x350'" alt="Second slide">
						</div>
						<div class="carousel-item">
							<img class="d-block img-fluid" src="https://images.kolonmall.com/cms/banner/2019/07/main_pc-fd86daa4-bb4f-46e5-9e9e-810342a99cad.jpg"
								onerror="this.src='http://placehold.it/900x350'" alt="Third slide">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleIndicators"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>

				<div class="row">
					<c:forEach items='${vo.data}' var='item' varStatus='status'>
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="card h-100">
								<a style="text-decoration:none;" href="${pageContext.servletContext.contextPath }/shop/product/${item.productNo}">
								<img class="card-img-top" src="${item.imgUrl }" onerror="this.src='http://placehold.it/700x400'" alt="상품 이미지"></a>
								<div class="card-body">
									<h4 class="">
										<a style="text-decoration:none; color:black;" href="${pageContext.servletContext.contextPath }/shop/product/${item.productNo}">${item.productNm}</a>
									</h4>
									<h5><fmt:formatNumber value="${item.sellPrc}" pattern="#,###"/></h5>
									<p class="card-text">${item.productDpt}</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.col-lg-9 -->
			
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>

</html>
