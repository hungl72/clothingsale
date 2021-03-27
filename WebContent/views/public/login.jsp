<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
	<div class="container">
		<%
		if((int)request.getAttribute("result") > 0){
	%>
		<br /><h3>Đăng ký thành công, mời bạn đăng nhập!</h3>
	<%
		}
	%>
	<%
		if((int)request.getAttribute("result") == -1){
	%>
		<br /><h3>Sai email hoặc mật khẩu, mời bạn nhập lại!</h3>
	<%		
		}
	%>
		<div class="account">
			<h2 class="account-in">Đăng nhập</h2>
				<form action="<%=request.getContextPath()%>/login" method="post" class="form">
				<div>
					<span class="mail">Email*</span>
					<input type="text" name="email"> 
				</div>
				<div> 
					<span class="word">Password*</span>
					<input type="password" name="pass">
				</div>				
					<input type="submit" value="Đăng nhập"> 
				</form>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function (){
			$('.form').validate({
				rules:{
					"email":{
						required: true,
						email: true,
					},
					"pass":{
						required: true,
						minlength: 8,
					},
				},
				messages:{
					"email":{
						required: "Vui lòng nhập email !",
						email:"Vui lòng nhập email đúng dịnh dạng !",
					},
					"pass":{
						required: "Vui lòng nhập password !",
						minlength: "Mật khẩu tối thiểu 8 ký tự !",
					},
				}
			});
		});
	</script>
<%@ include file="/templates/public/inc/footer.jsp" %>