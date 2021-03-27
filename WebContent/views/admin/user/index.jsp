<%@page import="daos.DecentralizationDAO"%>
<%@page import="models.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý người dùng</h2>
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
                                    <a href="" class="btn btn-success btn-md">Thêm</a>
                                </div>
                            </div>
                            <%}%>
							<%
 									String msg = request.getParameter("msg");
										try{
											if(msg.equals("1")){
									%>
										<h4>Sửa thông tin thành công</h4>
									<%
											}else if(msg.equals("0")){
									%>
										<h4>Sửa thông tin thất bại</h4>
									<%	
			                            	}else if(request.getParameter("msg").equals("delcomplete")){
			                            %>
			                            	<h4>Xóa người dùng thành công</h4>
			                            <%
			                            	}else if(request.getParameter("msg").equals("delerror")){
			                            %>
			                                <h4>Xóa người dùng thất bại</h4>
			                            <%
			                                	}
										}catch(Exception e){}
									%>
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên đăng nhập</th>
                                        <th>Họ tên</th>
                                        <th>Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
									<%
									ArrayList<User> listUser = null;
										if(request.getAttribute("userList") != null){
											listUser = (ArrayList<User>)request.getAttribute("userList");
											for(User user : listUser){
									%>
                                    <tr>
                                        <td><%=user.getUser_id()%></td>
                                        <td class="center"><%=user.getEmail()%></td>
                                        <td class="center"><%=user.getFull_name()%></td>
                                        <td class="center">
                                        <%
                                        if(decentralization.checkEditDecentralization(admin.getUser_id()) == 1){
                                        %>
                                            <a href="<%=request.getContextPath()%>/admineditusersdetail?user_id=<%=user.getUser_id()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                        <%}%>
                                        <%
                                        if(decentralization.checkDelDecentralization(admin.getUser_id()) == 1){
                                        %>
                                            <a href="<%=request.getContextPath()%>/admindelusers?user_id=<%=user.getUser_id()%>" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        <%}%>
                                        </td>
                                    </tr>
									<%												
											}
										}
									%>
                                </tbody>
                            </table>
                           <%
                           		int numberOfPages=(Integer)request.getAttribute("numberOfPages");
                           		int currentPage=(Integer)request.getAttribute("currentPage");
                           		if(listUser != null && listUser.size() > 0 && numberOfPages > 1){
                           		
                          	 	
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
                                            <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/adminusersindex?page=<%=back%>">Trang trước</a></li>
                                <%
                                  }
                                %>
                                 	<%
                                        for(int i=1;i<=numberOfPages;i++){
                                    		if(currentPage==i){
                                 	 %>
                                            <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/adminusersindex?page=<%=i%>"><%=i %></a></li>
									<%
                                    		}else{
                                    %>
                                            <li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/adminusersindex?page=<%=i%>"><%=i %></a></li>
                                    		
                                    <%
                                    		}
                                    	}
                                 	if (currentPage < numberOfPages) {
                                		int next = currentPage + 1;
									%>		
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/adminusersindex?page=<%=next%>">Trang tiếp</a></li>
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