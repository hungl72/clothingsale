<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
	<div class="container">
		<div class="account">
			<h2 class="account-in">Đăng ký</h2>
				<form action="signup" method="post" class="form">
				<div>
					<span>Họ tên*</span>
					<input type="text" name="fullname">
				</div> 				
				<div> 	
					<span class="mail">Email*</span>
					<input type="text" name="email"> 
				</div>
				<div> 
					<span class="word">Mật khẩu*</span>
					<input type="password" name="pass" class="pass">
				</div>
				<div> 
					<span class="word">Nhập lại mật khẩu*</span>
					<input type="password" name="repass">
				</div>			
					<input type="submit" value="Đăng ký" name="submit"> 
				</form>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function (){
			$('.form').validate({
				rules:{
					"fullname":{
						required: true,
						maxlength: 100,
					},
					"pass":{
						required: true,
						minlength: 8,
					},
					"repass":{
						required: true,
						equalTo: ".pass",
					},
					"email":{
						required: true,
						email: true,
					},
				},
				messages:{
					"fullname":{
						required: "Vui lòng nhập họ tên !",
						maxlength: "Họ tên không quá 100 ký tự !",
					},
					"pass":{
						required: "Vui lòng nhập password !",
						minlength: "Mật khẩu tối thiểu 8 ký tự !",
					},
					"repass":{
						required: "Vui lòng nhập lại mật khẩu !",
						equalTo: "Mật khẩu không trùng !",
					},
					"email":{
						required: "Vui lòng nhập email !",
						email:"Vui lòng nhập email đúng dịnh dạng !",
					},
				}
			});
		});
	</script>
<%@ include file="/templates/public/inc/footer.jsp" %>