<%@page import="daos.DecentralizationDAO"%>
<%@page import="models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li class="text-center">
                <img src="<%=request.getContextPath()%>/templates/admin/assets/img/find_user.png" class="user-image img-responsive" />
            </li>
            <li>
                <a id="index" href="<%=request.getContextPath()%>/adminindex"><i class="fa fa-dashboard fa-3x"></i> Trang chủ</a>
            </li>
            <%
            	if(session.getAttribute("adminInfo") != null){
            		if(new DecentralizationDAO().checkAdministrators(admin.getUser_id()) == 1){
			%>
            <li>
                <a id="contact" href="<%=request.getContextPath()%>/administrator"><i class="fa fa-envelope fa-3x"></i> Phân quyền</a>
            </li>
            <%}}%>
            <li>
                <a id="category" href="<%=request.getContextPath()%>/admincategories"><i class="fa fa-list fa-3x"></i> Quản lý danh mục</a>
            </li>
            <li>
                <a id="song" href="<%=request.getContextPath()%>/adminproductsindex"><i class="fa fa-music fa-3x"></i> Quản lý sản phẩm</a>
            </li>
            <%
            	if(session.getAttribute("adminInfo") != null){
            		if(new DecentralizationDAO().checkAdministrators(admin.getUser_id()) == 1 || new DecentralizationDAO().checkAdmin(admin.getUser_id()) == 1){
			%>
            <li>
                <a id="user" href="<%=request.getContextPath()%>/adminusersindex"><i class="fa fa-user fa-3x"></i> Quản lý người dùng</a>
            </li>
            <li>
                <a id="contact" href="<%=request.getContextPath()%>/multiupload"><i class="fa fa-envelope fa-3x"></i> Tải thêm ảnh cho sản phẩm</a>
            </li>
             <li>
                <a id="contact" href="<%=request.getContextPath()%>/adminindexcomments"><i class="fa fa-envelope fa-3x"></i> Quản lý bình luận</a>
            </li>
            <li>
                <a id="contact" href="<%=request.getContextPath()%>/adminindexorder"><i class="fa fa-envelope fa-3x"></i> Đơn hàng</a>
            </li>
            <%}}%>
        </ul>
    </div>
</nav>
<!-- /. NAV SIDE  -->