<%@page import="models.Order"%>
<%@page import="models.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/assets/inc/header.jsp" %>
<%@ include file="/templates/admin/assets/inc/leftbar.jsp" %>
	<% 
		if(session.getAttribute("adminInfo") !=null){
	%>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý đơn hàng</h2>
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
                                        <th>Brand</th>
                                        <th>Color</th>
                                        <th>Size</th>
                                        <th>Material</th>
                                        <th>Origin</th>
                                        <th>amount</th>
                                        <th>Total</th>
                                        <th>Message</th>
                                        <th>User</th>
                                        <th>Address</th>
                                        <th>Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
									<%
										ArrayList<Order> listOrder = null;
										if(request.getAttribute("listOrder") != null){
											listOrder = (ArrayList<Order>)request.getAttribute("listOrder");
											for(Order o : listOrder){
									%>
                                    <tr>
                                        <td class="center"><%=o.getOrder_id()%></td>
                                        <td class="center"><%=o.getOrder_brand()%></td>
                                        <td class="center"><%=o.getOrder_color()%></td>
                                        <td class="center"><%=o.getOrder_size()%></td>
                                        <td class="center"><%=o.getOrder_material()%></td>
                                        <td class="center"><%=o.getOrder_origin()%></td>
                                        <td class="center"><%=o.getOrder_amount()%></td>
                                        <td class="center"><%=o.getOrder_total()%></td>
                                        <td class="center"><%=o.getOrder_message()%></td>
                                        <td class="center"><%=o.getOrder_user()%></td>
                                        <td class="center"><%=o.getOrder_address()%></td>
                                        <td class="center">
                                            <a href="" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
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
                           		if(listOrder != null && listOrder.size() > 0 && numberOfPages > 1){
                           		
                          	 	
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
                                            <li class="paginate_button previous" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/adminindexorder?page=<%=back%>">Trang trước</a></li>
                                <%
                                  }
                                %>
                                 	<%
                                        for(int i=1;i<=numberOfPages;i++){
                                    		if(currentPage==i){
                                 	 %>
                                            <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/adminindexorder?page=<%=i%>"><%=i %></a></li>
									<%
                                    		}else{
                                    %>
                                            <li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/adminindexorder?page=<%=i%>"><%=i %></a></li>
                                    		
                                    <%
                                    		}
                                    	}
                                 	if (currentPage < numberOfPages) {
                                		int next = currentPage + 1;
									%>		
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/adminindexorder?page=<%=next%>">Trang tiếp</a></li>
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
<%
		}else{
			response.sendRedirect(request.getContextPath()+"/logincontroller");
		}
%>