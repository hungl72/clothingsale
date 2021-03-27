<%@page import="models.ProductDetail"%>
<%@page import="models.FavouriteHandling"%>
<%@page import="models.Favourite"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="container">
  <h3>Danh sách yêu thích</h3> 
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Tên sản phẩm</th>
        <th>Đơn giá</th>
        <th>Tình trạng</th>
      </tr>
    </thead>

    <tbody>
    	<%
    	int result;
    	try{
    		result = (int)request.getAttribute("result");
    	}catch(Exception e){result = 0;}
    	FavouriteHandling fh = (FavouriteHandling)session.getAttribute("favouritehandling");
    	if(result == 1){
    	%>
    		<h4  style="color: red;">Sản phẩm này đã được thêm vào danh sách yêu thích rồi ^^</h4>
    		 <%
	      	for(Map.Entry<Integer,ProductDetail> favourite : fh.getFavourite().entrySet()){System.out.print("adasdsad");
	     %>
	      <tr>
	        <td><%=favourite.getValue().getProduct_detail_brand()%></td>
	        <td><%=favourite.getValue().getProduct_detail_price()%></td>
	        <td><%if(favourite.getValue().getProduct_detail_amount() > 0){ %>Còn hàng (<%=favourite.getValue().getProduct_detail_amount()%>) sản phẩm<%}else{ %>Hết hàng<%} %></td>
	      </tr>
	      <%}%>
    	<%
    	}else if(result == 2){
    		%>
    		<h4 style="color: red;">Thêm sản phẩm vào danh sách yêu thích thành công</h4>
    	 <%
	      	for(Map.Entry<Integer,ProductDetail> favourite : fh.getFavourite().entrySet()){System.out.print("adasdsad");
	     %>
	      <tr>
	        <td><%=favourite.getValue().getProduct_detail_brand()%></td>
	        <td><%=favourite.getValue().getProduct_detail_price()%></td>
	        <td><%if(favourite.getValue().getProduct_detail_amount() > 0){ %>Còn hàng (<%=favourite.getValue().getProduct_detail_amount()%>) sản phẩm<%}else{ %>Hết hàng<%} %></td>
	      </tr>
	      <%}%>
	     <%
    	}else{
	      	for(Map.Entry<Integer,ProductDetail> favourite : fh.getFavourite().entrySet()){System.out.print("adasdsad");
	     %>
	      <tr>
	        <td><%=favourite.getValue().getProduct_detail_brand()%></td>
	        <td><%=favourite.getValue().getProduct_detail_price()%></td>
	        <td><%if(favourite.getValue().getProduct_detail_amount() > 0){ %>Còn hàng (<%=favourite.getValue().getProduct_detail_amount()%>) sản phẩm<%}else{ %>Hết hàng<%} %></td>
	      </tr>
    	<%}}%>
    </tbody>

  </table>
</div>
<%@ include file="/templates/public/inc/footer.jsp" %>