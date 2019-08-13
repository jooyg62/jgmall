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
	
	$("#imgAttach").on("change", function(event) {
		
		var file    = this.files[0];
		var reader  = new FileReader();
		
		var fileNames = file.name.split(".");
		var fileOriName = fileNames[0];
		var ext = fileNames[1];

		reader.addEventListener("load", function () {
			//파일 읽어오기 후 loadend 이벤트 발생
			var base64Img = reader.result.substr(reader.result.indexOf(",")+1);
			fileUploadBase64(fileOriName, ext, base64Img);
		}, false);

		if (file) {
			// 파일 읽어오기
			reader.readAsDataURL(file);
		}
		
		
		
	});
	
	fileUploadBase64 = function(fileOriName, ext, base64Img) {
		
		// 이미지 업로드
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/api/file/upload/image",
			type: "post",
			cache: false,
			contentType: "application/json",
			dataType: "json",
			data: JSON.stringify({
				"typeCd" : "A",
				"oriNm" : fileOriName,
				"saveUrl" : "",
				"extNm" : ext,
				"base64EncodingData" : base64Img
			}),
			success: function(response) {
				
				if("success" != response.result) {
					alert(response.message);
					return;
				}
				
				var saveUrl = response.data.saveUrl;
				$("#preview").attr("src", saveUrl);
				$("#inputImg").val(saveUrl);
				$("#imgUpload").addClass("d-none");
				$("#imgAttach").addClass("d-none");
			},
			error: function (request, status, error) {
				alert("서버와의 통신에 문제가 발생하였습니다.");
			}
		});
	}
	
})
</script>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/admin-navigation.jsp'>
		<c:param name="active" value="login" />
	</c:import>
	<!-- /.Navigation -->

 	<div class="container">
 		<div class="card card-container">
 			<label id="imgUpload" for="imgAttach">이미지 업로드:</label><input type="file" id="imgAttach" name="imgAttach">
 			<img class="card-img-top" id="preview" src="">
        	<form method="post" action="${pageContext.servletContext.contextPath }/admin/shop/product" class="form-signin" name="productForm">
        		<input type="hidden" id="inputImg" name="imgUrl" value="" >
        		<br />
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
        	<h3>상품 리스트</h3>
        	<table class="table">
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
	        			<td><fmt:formatNumber value="${item.sellPrc }" pattern="#,###"/></td>
	        			<td><fmt:formatNumber value="${item.salePrc }" pattern="#,###"/></td>
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