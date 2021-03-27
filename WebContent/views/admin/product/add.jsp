<%@page import="models.Categories"%>
<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm sản phẩm</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <%
        String msg = request.getParameter("msg");
        	if(msg != null){
        		if(msg.equals("addcomplete")){
        %>
        	<h4 style="color: purple;font-weight: bold;">Thêm sản phẩm thành công</h4>
        <%
        	}else if(msg.equals("adderror")){
        		
        %>
        	<h4 style="color: purple;font-weight: bold;">Thêm sản phẩm thất bại</h4>
        <%		
        	}else{}
        	}
        %>
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form action="adminaddproductsdetail" role="form" method="post" enctype="multipart/form-data" id="form">
                                    <div class="form-group">
                                        <label for="name">Tên thương hiệu</label>
                                        <input type="text" id="name" value="" name="brand" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Màu</label>
                                        <input type="text" id="name" value="" name="color" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Kích cỡ</label>
                                        <input type="text" id="name" value="" name="size" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Chất liệu</label>
                                        <input type="text" id="name" value="" name="material" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Xuất xứ</label>
                                        <input type="text" id="name" value="" name="origin" class="form-control" />
                                    </div>
                            	 <label for="name">Chọn sản phẩm</label>
                            	 <div class="form-group">
                                      <select id="idproduct" onchange="myFunction()" name="idproduct">
                                      <option>Chọn sản phẩm</option>
                                      <%
                                        if(request.getAttribute("listProductsName") != null){
                                        	ArrayList<Product> listProductsName = (ArrayList<Product>)request.getAttribute("listProductsName");
                                        	for(Product pro : listProductsName){
									  %>
										<option value="<%=pro.getProduct_id()%>"><%=pro.getProduct_name()%></option>
									  <%                                        			
                                        	}
                                        }
                                      %>
									  </select>
                                 </div>
                                 <label for="name">Chọn danh mục con</label>
                            	 <div class="form-group">
                                      <select id="idcategories" onchange="myFunction()" name="idcategories">
                                      <option>Chọn danh mục con</option>
                                      <%
                                        if(request.getAttribute("listCategoriesNameNotEqualZero") != null){
                                        	ArrayList<Categories> listCategoriesName = (ArrayList<Categories>)request.getAttribute("listCategoriesNameNotEqualZero");
                                        	for(Categories cate : listCategoriesName){
									  %>
										<option value="<%=cate.getCategories_id()%>"><%=cate.getCategories_name()%></option>
									  <%                                        			
                                        	}
                                        }
                                      %>
									  </select>
                                 </div>
                                 <label for="name">Chọn danh mục cha</label>
                            	 <div class="form-group">
                                      <select id="categories" onchange="myFunctio()" name="idproductdetail">
                                      <option>Chọn danh mục cha</option>
                                      <%
                                        if(request.getAttribute("listCategoriesName") != null){
                                        	ArrayList<Categories> listCategoriesName = (ArrayList<Categories>)request.getAttribute("listCategoriesName");
                                        	for(Categories cate : listCategoriesName){
									  %>
										<option value="<%=cate.getCategories_id()%>"><%=cate.getCategories_name()%></option>
									  <%                                        			
                                        	}
                                        }
                                      %>
									  </select>
                                 </div>
                                 <div class="form-group">
                                        <label for="name">Số lượng</label>
                                        <input type="text" id="name" value="" name="amount" class="form-control" />
                                    </div>
                                 <div class="form-group">
                                        <label for="name">Giá tiền</label>
                                        <input type="text" id="name" value="" name="price" class="form-control" />
                                    </div>
                                 <div class="form-group">
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" multiple/>
                                    </div>
                                 <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
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
function myFunction() {
  var x = document.getElementById("idproduct").value;
  alert(x);
}
function myFunctio() {
	  var y = document.getElementById("categories").value;
	  alert(y);
	}
</script>
<script>
    document.getElementById("song").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/assets/inc/footer.jsp" %>