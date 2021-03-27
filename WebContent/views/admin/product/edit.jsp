<%@page import="models.ProductDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục</h2>
            </div>
        </div>
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form action="<%=request.getContextPath()%>/admineditproductsdetail" method="post" enctype="multipart/form-data">
                                		<%
						        			if(request.getAttribute("productDetail") != null){
						        				ProductDetail product = (ProductDetail)request.getAttribute("productDetail");System.out.print("product id "+product.getProduct_id());
						        		%>
                                   <div class="form-group">
                                        <label for="name">Mã sản phẩm</label>
                                        <input type="text" value="<%=product.getProduct_detail_id()%>" name="idp" class="form-control" readonly/>
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Thương hiệu</label>
                                        <input type="text" id="name" value="<%=product.getProduct_detail_brand()%>" name="brand" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Màu</label>
                                        <input type="text" id="name" value="<%=product.getProduct_detail_color()%>" name="color" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Kích cỡ</label>
                                        <input type="text" id="name" value="<%=product.getProduct_detail_size()%>" name="size" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Chất liệu</label>
                                        <input type="text" id="name" value="<%=product.getProduct_detail_material()%>" name="material" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Xuất xứ</label>
                                        <input type="text" id="name" value="<%=product.getProduct_detail_origin()%>" name="origin" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Số lượng</label>
                                        <input type="text" id="name" value="<%=product.getProduct_detail_amount()%>" name="amount" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Đơn giá</label>
                                        <input type="text" id="name" value="<%=product.getProduct_detail_price()%>" name="price" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                    <img alt="<%=request.getContextPath() %>/uploads/images/<%=product.getProduct_detail_image()%>" src="<%=request.getContextPath() %>/uploads/images/<%=product.getProduct_detail_image()%>"><br/>
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" />
                                    </div>
                                    <%}%>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
                                         
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    <!-- /. PAGE INNER  -->
</div>
<script>
    document.getElementById("cat").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/assets/inc/footer.jsp" %>