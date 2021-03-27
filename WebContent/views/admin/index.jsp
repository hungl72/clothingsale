<%@page import="daos.CategoriesDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
	<% 
		if(session.getAttribute("adminInfo") !=null){
	%>
<div id="page-wrapper">
    <div id="page-inner">
    	<% 
    		if(request.getAttribute("countCategories") != null && request.getAttribute("countProducts") != null && request.getAttribute("countUsers") != null){
    			int cc = (int)request.getAttribute("countCategories");System.out.print("cc"+cc);
    			int cp = (int)request.getAttribute("countProducts");
    			int cu = (int)request.getAttribute("countUsers");
    	%>
        <div class="row">
            <div class="col-md-12">
                <h2>TRANG QUẢN TRỊ VIÊN</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-green set-icon">
                    <i class="fa fa-bars"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="" title="">Quản lý danh mục</a></p>
                        <p class="text-muted"><%=cc%></p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-blue set-icon">
                    <i class="fa fa-bell-o"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="" title="">Quản lý sản phẩm</a></p>
                        <p class="text-muted"><%=cp%></p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-brown set-icon">
                    <i class="fa fa-rocket"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="" title="">Quản lý người dùng</a></p>
                        <p class="text-muted"><%=cu%></p>
                    </div>
                </div>
            </div>
            <%} %>
        </div>

    </div>
</div>
<script>
    document.getElementById("index").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/assets/inc/footer.jsp" %>
<%
		}else{
			response.sendRedirect(request.getContextPath()+"/logincontroller");
		}
%>