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
	
	init();
	
	$("#payOrder").on("click", function(event) {
		
		//구매 상품 리스트
		var orderProductVoList = [];
		
		//담기
		var items = $(".items");
		
		for(var i=0; i < items.length; i++) {
			var orderProductVo = {
				"productOptNo": Number(items.eq(i).attr("productOptNo")),
				"orderAmt": 1,
				"payPrc": Number(items.eq(i).attr("sellPrc")),
				"productOptNm": items.eq(i).attr("productOptNo"),
				"basketNo": Number(items.eq(i).attr("basketNo"))
			}
			
			orderProductVoList.push(orderProductVo);
			
			console.log( Number(items.eq(i).attr("productOptNo")));
		}
		
		// 결제하기
		$.ajax({
			url: "${pageContext.servletContext.contextPath}/api/order/pay",
			type: "post",
			cache: false,
			contentType: "application/json",
			dataType: "json",
			data: JSON.stringify({
				"userNo" : Number(${mallAuthUser.no }),
				"orderNm" : $("#orderNm").val(),
				"addrGb" : "A",
				"addr" : $("#addr").val(),
				"telNum" : $("#telNum").val(),
				"memo" : $("#memo").val(),
				"totPayPrc" : $("#totPayPrc").val(),
				"orderProductVoList" : orderProductVoList
			}),
			success: function(response) {
				
				if("success" != response.result) {
					alert(response.message);
					return;
				}
				
				// 체크 목록 삭제
				$(".checkboxItems").closest(".items").remove();
				
				alert("상품을 구매하였습니다.")
				
			},
			error: function (request, status, error) {
				alert("서버와의 통신에 문제가 발생하였습니다.");
			}
		});
		
	});
	
	
});

var	init = function() {
		sum = 0;
		var $sellPrc = $(".sellPrc");
		for(var i=0; i < $sellPrc.length; i++) {
			sum += Number($sellPrc.eq(i).text()); 
		}
		
		$("#totPayPrc").val(sum);
	}
</script>
<body>
	<!-- Navigation -->
	<c:import url='/WEB-INF/views/includes/navigation.jsp'>
		<c:param name="active" value="login" />
	</c:import>
	<!-- /.Navigation -->

 	<div class="container">
        <div class="card card-container">
       		<br />
               <span>주문자명: </span>
               <input class="form-control" placeholder="주문자명" id="orderNm" name="orderNm" value="서장규" required autofocus><br />
               <span>주소: </span>
               <input class="form-control" placeholder="주소" id="addr" name="addr" value="서울특별시 서초구 서초동 서초대로74길 33 비트교육센터" ><br />
               <span>휴대번호: </span>
               <input class="form-control" placeholder="휴대번호" id="telNum" name="telNum" value="01041156736" ><br />
               <span>메모내용: </span>
               <input class="form-control" placeholder="메모내용" id="memo" name="memo" value="부재시 집앞에 놓아 주세요" ><br />
               <span>총 결제금액: </span>
               <input class="form-control" placeholder="" id="totPayPrc" name="totPayPrc" value="" readonly><br />
        </div>
        <!-- /.card-container -->
        <div>
        	<h3>장바구니 리스트 현황</h3>
        	<table class="table">
        		<tr>
        			<td><input type="checkbox" checked></td>
        			<td>상품번호</td>
        			<td>상품명</td>
        			<td>판매가격</td>
        			<td>상품요약설명</td>
        		</tr>
        		<c:forEach items='${vo.data}' var='item' varStatus='status'>
	        		<tr class="items" productOptNo="${item.optionNo }" 
	        		productNm="${item.productNm }" 
	        		sellPrc="${item.sellPrc }" 
	        		basketNo="${item.basketNo }" >
	        			<td><input type="checkbox" class="checkboxItems" checked></td>
	        			<td>${item.productNo }</td>
	        			<td >${item.productNm }</td>
	        			<td class="sellPrc"><fmt:formatNumber value="${item.sellPrc }" pattern="#,###"/></td>
	        			<td>${item.productDpt }</td>
	        		</tr>
        		</c:forEach>
        	</table>
        	<a id="payOrder" class="btn btn-success">선택 상품 구매하기</a>
        </div>
	</div>
	<!-- /.container -->

	<!-- Footer -->
	<c:import url='/WEB-INF/views/includes/footer.jsp' />
	<!-- /.Footer -->
</body>
</html>