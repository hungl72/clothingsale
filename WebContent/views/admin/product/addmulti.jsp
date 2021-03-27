<%@page import="models.ProductDetail"%>
<%@page import="models.Categories"%>
<%@page import="daos.CategoriesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <!-- /. ROW  -->
         <div class="row">
            <div class="col-md-12">
                <h2>Thêm ảnh cho sản phẩm</h2>
            </div>
        </div>
        <%
        String msg = request.getParameter("msg");
        	if(msg != null){
        		if(msg.equals("addcomplete")){
        %>
        	<h4 style="color: purple;font-weight: bold;">Thêm ảnh sản phẩm thành công</h4>
        <%
        	}else if(msg.equals("adderror")){
        		
        %>
        	<h4 style="color: purple;font-weight: bold;">Thêm ảnh sản phẩm thất bại</h4>
        <%		
        	}else{}
        	}
        %>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-6">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">

                            <div class="col-md-6">
                                <form action="multiupload" role="form" method="post"  id="form" enctype="multipart/form-data">
                                    <div class="form-group">
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" multiple/>
                                    </div>
                            	 <label for="name">Chọn sản phẩm cần upload thêm ảnh</label>
                            	 <div class="form-group">
                                      <select id="categories" onchange="myFunction()" name="idproduct">
                                      <%
                            	 		if(request.getAttribute("listProductDetail") != null){
                            	 			ArrayList<ProductDetail> listProductDetail = (ArrayList)request.getAttribute("listProductDetail");
                            	 			for(ProductDetail pd : listProductDetail){
                            	 	%>
										<option value="<%=pd.getProduct_detail_id()%>"><%=pd.getProduct_detail_brand()%></option>
									<%  
                            	 			}
                            	 		}
                            	 	%>
									  </select>
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
       
<script>
function myFunction() {
  var x = document.getElementById("categories").value;
  alert(x);
}
</script>

        <!-- /. ROW  -->
    <!-- /. PAGE INNER  -->
</div>
<script>
    document.getElementById("cat").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/assets/inc/footer.jsp" %>