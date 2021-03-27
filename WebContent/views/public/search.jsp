<%@page import="models.ProductDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
		<div class="container">
			<div class="products">
					<h2 class=" products-in">DANH SÁCH TÌM KIẾM</h2>
					<div class=" top-products">
						<% 
								if(request.getAttribute("listProductSearch") != null){
									ArrayList<ProductDetail> listProductSearch = (ArrayList<ProductDetail>)request.getAttribute("listProductSearch");
									for(ProductDetail product : listProductSearch){
						%>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="<%=request.getContextPath()%>/detailproduct?product_id=<%=product.getProduct_detail_id()%>&&parent_id=<%=product.getCategories_id()%>"><img src="<%=request.getContextPath()%>/templates/public/images/pi.jpg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="single.html"><%=product.getProduct_detail_brand()%></a><a href="<%=request.getContextPath()%>/favourite?product_id=<%=product.getProduct_detail_id()%>&&parent_id=<%=product.getCategories_id()%>" ><button class="btn btn-warning btn-xs" style="float: right;"><span>YÊU THÍCH</span></button></a></h5>
									<div class="white">
										<a href="<%=request.getContextPath()%>/cart?command=addcart&&productid=<%=product.getProduct_detail_id()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">Cho vào giỏ</a>
										<p class="dollar"><span><%=product.getProduct_detail_price()%></span><span class="in-dollar">VNĐ</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<%}}%>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
<%@ include file="/templates/public/inc/footer.jsp" %>