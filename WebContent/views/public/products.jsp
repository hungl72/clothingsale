<%@page import="models.Categories"%>
<%@page import="models.Cart"%>
<%@page import="models.Product"%>
<%@page import="daos.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
		<div class="container">
		<%
			int parent_id = (int)request.getAttribute("parent_id");
			int categories_id = Integer.parseInt(request.getParameter("categories_id"));
		%>
			<div class="products">
					<h2 class=" products-in">TẤT CẢ <%=new ProductDAO().findCategoriesNameOfCategoriesByCategoriesIdOfProduct(parent_id).getCategories_name()%></h2>
					<div class=" top-products">
					<%
					ArrayList<Product> listProduct = null;
						Cart cartProduct = (Cart)session.getAttribute("cartProduct");
						if(cartProduct == null){
							cartProduct = new Cart();
							session.setAttribute("cartProduct", cartProduct);
						}
						if(request.getAttribute("listProduct")!=null){
							listProduct = (ArrayList<Product>)request.getAttribute("listProduct");
							for(Product product : listProduct){
					%>
						<div class="col-md-3 md-col" style="margin-bottom: 60px;">
							<div class="col-md">
								<a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>&&parent_id=<%=parent_id%>&&categories_id=<%=product.getCategory_id()%>"><img src="<%=request.getContextPath()%>/uploads/images/<%=product.getProduct_image()%>" alt="" /></a>	
								<div class="top-content">
									<h5><a href="single.html"><%=product.getProduct_name()%></a><a href="<%=request.getContextPath()%>/favourite?product_id=<%=product.getProduct_id()%>" ><button class="btn btn-warning btn-xs" style="float: right;"><span>YÊU THÍCH</span></button></a></h5>
									<div class="white">
										<a href="<%=request.getContextPath()%>/cart?command=addcart&&productid=<%=product.getProduct_id()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">Cho vào giỏ</a>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
				<%
						}
					}
						int currentPage = (int)request.getAttribute("currentPage");System.out.print(currentPage);
						int numberOfPages = (int)request.getAttribute("numberOfPages");System.out.print(numberOfPages);
						if(listProduct != null && listProduct.size() > 0 && numberOfPages > 1){
				%>
					<div class="clearfix"></div>
							<h4>Trang <%=currentPage%> của <%=numberOfPages%></h4>
					<ul class="start" style="padding-bottom: 0px;">
					<%
						if(currentPage > 1){
							int back = currentPage - 1;
					%>
					<li ><a href="<%=request.getContextPath()%>/index?page=<%=back%>&&categories_id=<%=parent_id%>"></a></li>
					<%
						} 
						for(int i = 1; i <= numberOfPages ; i++){
							if(currentPage == i){
					%>
					<li><span><%=i%></span></li>
					<%
							}else{
					%>
					<li class="arrow"><a href="<%=request.getContextPath()%>/product?page=<%=i%>&&categories_id=<%=parent_id%>"><%=i%></a></li>
					<%} %>
				<%					
						}
					}
						if(currentPage < numberOfPages){
							int next = currentPage + 1;
				%>
				<li ><a href="<%=request.getContextPath()%>/product?page=<%=next%>&&categories_id=<%=parent_id%>"><i  class="next"></i></a></li>
				<%}%>
				</ul>
				</div>
			</div>
		</div>
<%@ include file="/templates/public/inc/footer.jsp" %>