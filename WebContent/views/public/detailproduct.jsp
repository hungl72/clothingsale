<%@page import="models.Picture"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="models.ProductDetail"%>
<%@page import="daos.ProductDAO"%>
<%@page import="models.Categories"%>
<%@page import="com.sun.javafx.beans.IDProperty"%>
<%@page import="models.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
		<div class="container">
			<div class="single">
				<div class="col-md-9 top-in-single">
				<%
				ProductDAO productDAO = new ProductDAO();
				Product detailProduct = (Product)request.getAttribute("product");
				ProductDetail productDetail = (ProductDetail)request.getAttribute("productDetail");
				int idProductViewing = productDetail.getProduct_id();System.out.print("idproductview"+idProductViewing);
				int ParentId = Integer.parseInt(request.getParameter("parent_id"));				
				%>
					<div class="col-md-5 single-top">	
						<ul id="etalage">
							<li>
								<a href="optionallink.html">
									<img class="etalage_thumb_image img-responsive" src="<%=request.getContextPath()%>/uploads/images/<%=productDetail.getProduct_detail_image()%>" alt="" >
									<img class="etalage_source_image img-responsive" src="<%=request.getContextPath()%>/uploads/images/<%=productDetail.getProduct_detail_image()%>" alt="" >
								</a>
							</li>
							<%
								if(request.getAttribute("listPicture") != null){
									ArrayList<Picture> listPicture = (ArrayList<Picture>)request.getAttribute("listPicture");
									for(Picture p : listPicture){
							%>
							<li>
								<img class="etalage_thumb_image img-responsive" src="<%=request.getContextPath()%>/uploads/images/<%=p.getPicture_name()%>" alt="" >
								<img class="etalage_source_image img-responsive" src="<%=request.getContextPath()%>/uploads/images/<%=p.getPicture_name()%>" alt="" >
							</li>
							<%										
									}
								}
							%>
						</ul>

					</div>	
					<div class="col-md-7 single-top-in">
						<div class="single-para">
						<span class="idproductviewing" hidden><%=idProductViewing%></span>
						<span class="parentid" hidden><%=ParentId%></span>
							<h4><%=productDetail.getProduct_detail_brand()%></h4>
							<div class="para-grid">
								<span class="add-to">Đơn giá : <%=productDetail.getProduct_detail_price()%></span>
								<%
									if(session.getAttribute("user") != null){
								%>
								<a href="<%=request.getContextPath()%>/cart?command=addcart&&productid=<%=productDetail.getProduct_detail_id()%>" class="hvr-shutter-in-vertical cart-to">Cho vào giỏ</a>	
								<%}else{%>
								<a href="javascript:void(0)" onclick="alert('Bạn cần đăng nhập để cho vào giỏ !!!')" class="hvr-shutter-in-vertical cart-to">Cho vào giỏ</a>
								<%}%>				
								<div class="clearfix"></div>
							 </div>
							<h5>Trong kho còn <%=productDetail.getProduct_detail_amount()%> sản phẩm</h5><br />
							<h4>Chất liệu : </h4>
							<p><%=productDetail.getProduct_detail_material()%></p>
							<h4>Xuất xứ : </h4>
							<p><%=productDetail.getProduct_detail_origin()%></p>
							<h4>Màu : </h4>
							<p><%=productDetail.getProduct_detail_color()%></p>
							<h4>Kích cỡ : </h4>
							<p><%=productDetail.getProduct_detail_size()%></p>
						</div>
					</div>

					<div class="clearfix"></div>
					</div>
				</div>
				<div class="clearfix"> </div>
		</div>
	</div>
<%@ include file="/templates/public/inc/footer.jsp" %>