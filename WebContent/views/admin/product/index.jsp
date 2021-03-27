<%@page import="daos.DecentralizationDAO"%>
<%@page import="models.ProductDetail"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý sản phẩm</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                        	<%
	                        	DecentralizationDAO decentralization = new DecentralizationDAO();
	                        	   if(decentralization.checkAddDecentralization(admin.getUser_id()) == 1){
	                        %>
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath()%>/adminaddproductsdetail" class="btn btn-success btn-md">Thêm</a>
                                </div>
                            </div>
                            <%}%>
 									<%
 									String msg = request.getParameter("msg");
										try{
											if(msg.equals("1")){
									%>
										<h4>Sửa sản phẩm thành công</h4>
									<%
											}else if(msg.equals("0")){
									%>
										<h4>Sửa sản phẩm thất bại</h4>
									<%	
			                            	}else if(request.getParameter("msg").equals("delcomplete")){
			                            %>
			                            	<h4>Xóa sản phẩm thành công</h4>
			                            <%
			                            	}else if(request.getParameter("msg").equals("delerror")){
			                            %>
			                                <h4>Xóa sản phẩm thất bại</h4>
			                            <%
			                                	}
										}catch(Exception e){}
									%>
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Mã sản phẩm</th>
                                        <th>Thương hiệu</th>
                                        <th>Màu</th>
                                        <th>Kích cỡ</th>
                                        <th>Chất liệu</th>
                                        <th>Xuất xứ</th>
                                        <th>Số lượng</th>
                                        <th>Đơn giá</th>
                                        <th>Hình ảnh</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                        <%
                                       		ArrayList<ProductDetail> listProductDetail = null;
								        	if(request.getAttribute("productDetailList") != null){
								        		listProductDetail = (ArrayList<ProductDetail>)request.getAttribute("productDetailList");
								        		for(ProductDetail product : listProductDetail){
        								%>
                                    <tr>
                                        <td class="center"><%=product.getProduct_detail_id()%></td>
                                        <td class="center"><%=product.getProduct_detail_brand()%></td>
                                        <td class="center"><%=product.getProduct_detail_color()%></td>
                                        <td class="center"><%=product.getProduct_detail_size()%></td>
                                        <td class="center"><%=product.getProduct_detail_material()%></td>
                                        <td class="center"><%=product.getProduct_detail_origin()%></td>
                                        <td class="center"><%=product.getProduct_detail_amount()%></td>
                                        <td class="center"><%=product.getProduct_detail_price()%></td>
                                        <td class="center">
											<img width="200px" height="200px" src="<%=request.getContextPath()%>/uploads/images/<%=product.getProduct_detail_image()%>" alt="Đổi thay"/>
                                        </td>
                                        <td class="center">
                                        <%
                                        if(decentralization.checkEditDecentralization(admin.getUser_id()) == 1){
                                        %>
                                            <a href="<%=request.getContextPath()%>/admineditproductsdetail?product_id=<%=product.getProduct_detail_id()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                        <%}%>
                                        <%
                                        if(decentralization.checkDelDecentralization(admin.getUser_id()) == 1){
                                        %>
                                            <a href="<%=request.getContextPath()%>/adminproductdel?product_id=<%=product.getProduct_detail_id()%>" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        <%}%>
                                        </td>
                                    </tr>
                                    <%}} %>
                                </tbody>
                            </table>
                             <div class="row">
                            <%
                           		int numberOfPages=(Integer)request.getAttribute("numberOfPages");
                           		int currentPage=(Integer)request.getAttribute("currentPage");
                           		if(listProductDetail != null && listProductDetail.size() > 0 && numberOfPages > 1){
                           		
                          	 	
                            %>
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Trang <%=currentPage%> của <%=numberOfPages %> </div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                               
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                <%
    							 	if (currentPage > 1) {
     								int back = currentPage - 1;
    							 %>
                                            <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/adminproductsindex?page=<%=back%>">Trang trước</a></li>
                                <%
                                  }
                                %>
                                 	<%
                                        for(int i=1;i<=numberOfPages;i++){
                                    		if(currentPage==i){
                                 	 %>
                                            <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/adminproductsindex?page=<%=i%>"><%=i %></a></li>
									<%
                                    		}else{
                                    %>
                                            <li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/adminproductsindex?page=<%=i%>"><%=i %></a></li>
                                    		
                                    <%
                                    		}
                                    	}
                                 	if (currentPage < numberOfPages) {
                                		int next = currentPage + 1;
									%>		
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/adminproductsindex?page=<%=next%>">Trang tiếp</a></li>
                                     <%
    										}
   									  %>
                                        </ul>
                                    </div>
                                </div>
                                <%}%>
                            </div>
                        </div>

                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
</div>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/assets/inc/footer.jsp" %>