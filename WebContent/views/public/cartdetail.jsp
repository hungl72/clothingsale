<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="container">
		<%
			double total = 0,totalFinal = 0;
			HttpSession session3 = request.getSession();
			Cart cart3 = (Cart)session3.getAttribute("cartProduct");
			if(cart3.totalProduct() == 0 ){
		%>
		<div class="check-out">
			<%
			try {
				if(request.getAttribute("success").equals("ordercomplete")) {
			%>
				<h3>Bạn đã đặt hàng thành công ^^</h3>
			<%
				}else{
			%>
			
			<%
				}
			} catch (Exception e) {
				
		}
			%>
    	    <h4 class="title">Giỏ đang trống, bạn hãy mua gì đi nào ^^</h4>
    	    <p class="cart">Hãy click <a href="<%=request.getContextPath()%>/index"> vào đây</a> để tiếp tục mua sắm!</p>
    	</div>
    	<%}else{%>
    	<h3 class="text-success" style="margin: 10px;">Để xem giỏ bạn đã có gì rồi nè ^^</h3>
    	<form action="orderproduct" method="post">
    	<table class="table table-striped font-weight-bold">
    		<tr>
    			<td>Thương hiệu</td>
    			<td>Màu</td>
    			<td>Kích thước</td>
    			<td>Chất liệu</td>
    			<td>Xuất xứ</td>
    			<td>Số lượng</td>
    			<td>Giá/Sản phẩm</td>
    			<td>Đơn giá</td>
    		</tr>
    		<%
	    		for(Map.Entry<Integer, Item> listCart : cart3.getCartItem().entrySet()) {
    		%>
    		<tr>
    			<td><%=listCart.getValue().getProductDetail().getProduct_detail_brand()%></td>
    			<td><%=listCart.getValue().getProductDetail().getProduct_detail_color()%></td>
    			<td><%=listCart.getValue().getProductDetail().getProduct_detail_size()%></td>
    			<td><%=listCart.getValue().getProductDetail().getProduct_detail_material()%></td>
    			<td><%=listCart.getValue().getProductDetail().getProduct_detail_origin()%></td>
    			<td><%=listCart.getValue().getAmountItem()%></td>
    			<td><%=listCart.getValue().getProductDetail().getProduct_detail_price()%></td>
    			<td><%=total = listCart.getValue().getProductDetail().getProduct_detail_price()*listCart.getValue().getAmountItem()%>
    		</tr>
    		<%
    			totalFinal += total;}
    		%>
    		<tr>
    			<td></td>
    			<td>Địa chỉ giao : </td>
    			<td><input type="text" class="form-control" name="address" placeholder="Bạn muốn giao đến đâu ..." aria-describedby="basic-addon1"></td>
    			<td>Lời nhắn : </td>
    			<td><input type="text" class="form-control" name="message" placeholder="Lưu ý cho người bán ..." aria-describedby="basic-addon1"></td>
    			<td>Tổng tiền</td>
    			<td><%=totalFinal%></td>
    			<td><a href=""><button class="btn btn-warning">Tiến hành đặt hàng</button></a></td>
    		</tr>
    	</table>
    	</form>
    	<%}%>
	</div>
<%@ include file="/templates/public/inc/footer.jsp" %>