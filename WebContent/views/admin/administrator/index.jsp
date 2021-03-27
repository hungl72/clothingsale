
<%@page import="models.Administrator"%>
<%@page import="daos.DecentralizationDAO"%>
<%@page import="models.Categories"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý phân quyền</h2>
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
                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên</th>
                                        <th>Email</th>
                                        <th>Quyền</th>
                                        <th>Thêm</th>
                                        <th>Sửa</th>
                                        <th>Xóa</th>
                                    </tr>
                                </thead>
                                <tbody>
								<% 
									DecentralizationDAO de = new DecentralizationDAO();
									ArrayList<Administrator> listUserAction = new ArrayList<Administrator>();
									if(request.getAttribute("listUser") != null){
										ArrayList<Administrator> listUser = (ArrayList<Administrator>)request.getAttribute("listUser");
										for(Administrator a : listUser){
								%>
                                    <tr>
                                        <td><%=a.getUser_id()%></td>
                                        <td class="center"><%=a.getFull_name()%></td>
                                        <td class="center"><%=a.getEmail()%></td> 
                                        <td class="center"><%=a.getName_per()%></td>
                                        <%
                                        	listUserAction = de.listUserAction(a.getUser_id());
                                        	for(Administrator action : listUserAction){
                                        	if(action.getCheck_action() == 1){
                                        %>
                                        <td class="center"><input class="<%=action.getUser_id()%>" type="checkbox" value="<%=action.getUser_id()%>,<%=action.getCheck_action()%>,<%=action.getAction_code()%>" checked data-toggle="toggle" data-toggle="toggle" onclick="myFunction('<%=action.getUser_id()%>,<%=action.getCheck_action()%>,<%=action.getAction_code()%>')" data-onstyle="success" data-offstyle="danger"></td>
                                        <%}else{%>
                                        <td class="center"><input class="<%=action.getUser_id()%>" type="checkbox" value="<%=action.getUser_id()%>" data-toggle="toggle" onclick="myFunction('<%=action.getUser_id()%>,<%=action.getCheck_action()%>,<%=action.getAction_code()%>')" data-onstyle="success" data-offstyle="danger"></td>
                                        <%}%>
								<%
                                        	}
										}
									}
								%>
                                </tbody>
                            </table>
                            <div class="row">
                               <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Trang 1 của 1 </div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                               
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/administrator?page=">Trang trước</a></li>
                                            <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/administrator?page=">1</a></li>
                                            <li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/administrator?page=">2</a></li>	
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/administrator?page=">Trang tiếp</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <script>
                	function myFunction(x){
                	var idActionCode = x;
                	$.ajax({
                		url : '<%=request.getContextPath()%>/ajaxdecentralization',
                		type : 'post',
                		data :{idActionCode : idActionCode},
                		success : function(data) {
                			
                		}
                	});
                	};
                </script>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
</div>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/assets/inc/footer.jsp" %>