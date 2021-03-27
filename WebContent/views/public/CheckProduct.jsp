<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/templates/public/inc/header.jsp" %>
    <div class="container">
                <div class="account">
                <h2 class="account-in">Check Product</h2>
                    <form action="<%=request.getContextPath()%>/checkproduct" method="post">
                        <div> 	
                            <span>Address</span> 
                            <input type="text" name="address"> 
                        </div>
                        <div> 
                                <span>Payment</span>
                                <select name="payment">
                                        <option value="bank">Bank Transfer</option>
                                        <option value="live">Live</option>
                                </select>
                        </div>
                        <input type="submit" value="Check Product">
                    </form>            
                </div>
            </div>
<%@ include file="/templates/public/inc/footer.jsp" %>