<%@page import="models.Categories"%>
<%@page import="daos.CategoriesDAO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục cha</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-6">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                        <%
                        	if((int)request.getAttribute("parent") > 0){
                        %>
                        	<h4 style="color: purple;font-weight: bold;">Thêm danh mục cha thành công</h4>
                        <%
                        	}else if((int)request.getAttribute("parent") == -1){
                        %>

                        <%	
                        	}else{
                       	%>
                       		<h3 style="color: purple;font-weight: bold;">Thêm danh mục cha thất bại</h3>
                       	<%
                        	}
                        %>
                            <div class="col-md-12">
                                <form action="admincategoriesparentadd" role="form" method="post"  id="form">
                                    <div class="form-group">
                                        <label for="name">Tên danh mục cha</label>
                                        <input type="text" id="name" value="" name="name" class="form-control" />
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
         <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục con</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-6">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                        <%
                        	if((int)request.getAttribute("son") > 0){
                        %>
                        	<h4 style="color: purple;font-weight: bold;">Thêm danh mục con thành công</h4>
                        <%
                        	}else if((int)request.getAttribute("son") == -1){
                        %>

                        <%	
                        	}else{
                       	%>
                       		<h3 style="color: purple;font-weight: bold;">Thêm danh mục con thất bại</h3>
                       	<%
                        	}
                        %>
                            <div class="col-md-6">
                                <form action="admincategoriesparentadd" role="form" method="post"  id="form">
                                    <div class="form-group">
                                        <label for="name">Tên danh mục con</label>
                                        <input type="text" id="name" value="" name="nameson" class="form-control" />
                                    </div>
                            	 <label for="name">Chọn một danh mục cha</label>
                            	 <div class="form-group">
                                      <select id="categories" onchange="myFunction()" name="categories_id">
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
                                 <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục con (đệ quy)</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-6">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                        <%
                        	if((int)request.getAttribute("son") > 0){
                        %>
                        	<h4 style="color: purple;font-weight: bold;">Thêm danh mục con thành công</h4>
                        <%
                        	}else if((int)request.getAttribute("son") == -1){
                        %>

                        <%	
                        	}else{
                       	%>
                       		<h3 style="color: purple;font-weight: bold;">Thêm danh mục con thất bại</h3>
                       	<%
                        	}
                        %>
                            <div class="col-md-6">
                                <form action="admincategoriesparentadd" role="form" method="post"  id="form">
                                    <div class="form-group">
                                        <label for="name">Tên danh mục con(đệ quy)</label>
                                        <input type="text" id="name" value="" name="nameson" class="form-control" />
                                    </div>
                            	 <label for="name">Chọn một danh mục con</label>
                            	 <div class="form-group">
                                      <select id="categories" onchange="myFunction()" name="categories_id">
                                      <%
                                        if(request.getAttribute("listCategoriesSon") != null){
                                        	ArrayList<Categories> listCategoriesName = (ArrayList<Categories>)request.getAttribute("listCategoriesSon");
                                        	for(Categories cate : listCategoriesName){
									  %>
										<option value="<%=cate.getCategories_id()%>"><%=cate.getCategories_name()%></option>
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
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm sản phẩm cho danh mục con</h2>
            </div>
        </div>
        <hr />
                <div class="row">
            <div class="col-md-6">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                    <%
                        	if((int)request.getAttribute("resultSonInformation") > 0){
                        %>
                        	<h4 style="color: purple;font-weight: bold;">Thêm sản phẩm cho danh mục con thành công</h4>
                        <%
                        	}else if((int)request.getAttribute("resultSonInformation") == -1){
                        %>

                        <%	
                        	}else{
                       	%>
                       		<h3 style="color: purple;font-weight: bold;">Thêm sản phẩm cho danh mục con thất bại</h3>
                       	<%
                        	}
                        %>
                        <div class="row">
                            <div class="col-md-6">
                                <form action="admincategoriesparentadd" role="form" method="post" id="form" enctype="multipart/form-data">
                                <%
                                	if(request.getAttribute("listCategoriesSon") != null){
                                		ArrayList<Categories> listCategoriesSon = (ArrayList<Categories>)request.getAttribute("listCategoriesSon");
                                %>
                                    <div class="form-group">
                                        <label for="name">Thêm thông tin cho danh mục con</label>
                                        <select name="categoriesandparent" onchange="">
                                        <%
                                		for(Categories cate : listCategoriesSon){
                                        %>
                                        	<option value="<%=cate.getCategories_id()%>,<%=cate.getParent_id()%>,<%=cate.getCategories_name()%>"><%=cate.getCategories_name()%></option>
                                        <%
                                        	}
                                        %>
                                        </select>
                                    </div>
                                 	<div class="form-group">
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Mô tả sản phẩm</label>
                                        <input type="text" id="name" value="" name="description" class="form-control" />
                                    </div>
                                <%
                                	} 
                                %>
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