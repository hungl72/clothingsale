<%@page import="models.FavouriteHandling"%>
<%@page import="com.sun.prism.Image"%>
<%@page import="models.Item"%>
<%@page import="models.Product"%>
<%@page import="java.util.Map"%>
<%@page import="models.Cart"%>
<%@page import="models.User"%>
<%@page import="java.io.IOException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utils.DBConnectionUtil"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Bonfire a Ecommerce Category Flat Bootstarp Responsive Website Template | Single :: w3layouts</title>
<link href="<%=request.getContextPath()%>/templates/public/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="<%=request.getContextPath()%>/templates/public/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/templates/public/js/jqueryvalidatemin.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="<%=request.getContextPath()%>/templates/public/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Bonfire Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Exo:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/move-top.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/easing.js"></script>
				<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/css/etalage.css">
<script src="<%=request.getContextPath()%>/templates/public/js/jquery.etalage.min.js"></script>
		<script>
			jQuery(document).ready(function($){

				$('#etalage').etalage({
					thumb_image_width: 300,
					thumb_image_height: 400,
					source_image_width: 900,
					source_image_height: 1200,
					show_hint: true,
					click_callback: function(image_anchor, instance_id){
						alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
					}
				});

			});
		</script>
<script>$(document).ready(function(c) {
	$('.alert-close').on('click', function(c){
		$('.message').fadeOut('slow', function(c){
	  		$('.message').remove();
		});
	});	  
});
</script>
<script>$(document).ready(function(c) {
	$('.alert-close1').on('click', function(c){
		$('.message1').fadeOut('slow', function(c){
	  		$('.message1').remove();
		});
	});	  
});
</script>
</head>
<body>
  <!--header-->
	<div class="header">
		<div class="header-top">
			<div class="container">	
			<div class="header-top-in">			
				<div class="logo">
					<a href="<%=request.getContextPath()%>/index"><img src="<%=request.getContextPath()%>/templates/public/images/logo.png" alt=" " ></a>
				</div>
				<div class="header-in">
					<ul class="icon1 sub-icon1">
							<li><a href="<%=request.getContextPath()%>/viewfavourite">YÊU THÍCH (0)</a> </li>
							<li><a href="<%=request.getContextPath()%>/cartdetail" >CHI TIẾT GIỎ HÀNG</a></li>
							<li><a href="">THANH TOÁN</a> </li>	
							<li>
								<ul class="sub-icon1 list">
						  <h3>Giỏ hàng của bạn</h3>
						  <%
						  	double totalMoney = 0;int totalProduct = 0,totalProductFinal = 0;int idProduct = 0;
						  	FavouriteHandling favouritehandling = (FavouriteHandling)session.getAttribute("favouritehandling");
						  		if(favouritehandling == null){
						  			favouritehandling = new FavouriteHandling();
						  			session.setAttribute("favouritehandling", favouritehandling);
						  		}
						  	Cart cart = (Cart)session.getAttribute("cartProduct");
						  		if(cart == null){
						  			cart = new Cart();
						  			session.setAttribute("cartProduct", cart);
						  		}
						  %>
						  <div class="shopping_cart">
						  <%
						  		for(Map.Entry<Integer,Item> item : cart.getCartItem().entrySet()){
						  			totalProduct += item.getValue().getAmountItem();
						  			totalMoney += item.getValue().getProductDetail().getProduct_detail_price() * item.getValue().getAmountItem();
						  %>
							  <div class="cart_box">
							   	 <div class="message">
							   	     <a href="<%=request.getContextPath()%>/cart?command=del&&productid=<%=item.getValue().getProductDetail().getProduct_detail_id()%>"><div class="alert-close"> </div></a>
					                <div class="list_img"><img src="<%=request.getContextPath()%>/templates/public/images/14.jpg" class="img-responsive" alt=""></div>
								    <div class="list_desc"><h4><a href="#"><%=item.getValue().getProductDetail().getProduct_detail_brand()%></a></h4><%=item.getValue().getAmountItem()%> x<span class="actual">
		                             <%=item.getValue().getProductDetail().getProduct_detail_price()%>VNĐ</span></div>
		                              <div class="clearfix"></div>
	                              </div>
	                            </div>
	                       <%
						  		}session.setAttribute("cartProduct", cart);
	                       %>
	                        </div>
	                        <div class="total">
	                        	<div class="total_left">CartSubtotal : </div>
	                        	<div class="total_right"><%=totalMoney%></div>
	                        	<div class="clearfix"> </div>
	                        </div>
                            <div class="login_buttons">
							  <div class="check_button"><a href="<%=request.getContextPath()%>/cartdetail">Check out</a></div>
							  <div class="clearfix"></div>
						    </div>
					      <div class="clearfix"></div>
						</ul>
						<div class="cart">
									<a href="#" class="cart-in"> </a>
									<span><%=totalProductFinal += totalProduct%></span>
								</div>
							</li>
							<%
								if(session.getAttribute("user")==null){
							%>
							<li><a href="<%=request.getContextPath()%>/signup">ĐĂNG KÝ</a></li>
							<li><a href="<%=request.getContextPath()%>/login">ĐĂNG NHẬP</a></li>
							<%}else{
								User user = (User)session.getAttribute("user");
							%>
							<li><a>Xin chào, <%=user.getFull_name()%></a></li>
							<li><a href="<%=request.getContextPath()%>/logout">ĐĂNG XUẤT</a></li>
							<%
								} 
							%>
						</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
			</div>
		</div>
<%!
		public void CreateChildMenu(int parentId, javax.servlet.jsp.JspWriter out){	 
	        try{
	        	Connection con1 = DBConnectionUtil.getConnection();
	        	Statement st1 = con1.createStatement();
	        	ResultSet rs1 = st1.executeQuery("select product_id,product_name,categories.parent_id,categories.categories_id,categories.categories_name from categories,product where categories.categories_id = product.categories_id");
	            ArrayList<Integer> idChildMenu=new ArrayList<Integer>();
	            ArrayList<Integer> idProduct=new ArrayList<Integer>();
	            ArrayList<String> nameChildMenu=new ArrayList<String>();
	            try
	            {
	                while(rs1.next())
	                {
	                    if(rs1.getInt("parent_id")==(parentId))
	                    {
	                        idChildMenu.add(rs1.getInt("categories_id"));
	                        idProduct.add(rs1.getInt("product_id"));
	                        nameChildMenu.add(rs1.getString("categories_name"));
	                    }
	                }
	                if(idChildMenu.size()>0 && idProduct.size()>0)
	                {
	                    out.println("<ul class='drop'>");
	                    for(int i=0;i<idChildMenu.size();i++)
	                    {
	                        out.println("<li>");
	                        out.println("<a href='detail?&&product_id="+idProduct.get(i)+"&&parent_id="+parentId+"&&categories_id="+idChildMenu.get(i)+"'>"+nameChildMenu.get(i)+"</a>");
	                        CreateChildMenu(idChildMenu.get(i),out);
	                    }
	                    out.println("</ul>");
	                }
	                else
	                {
	                    out.println("</li>");
	                }
	            }catch(IOException ex){}
	        }catch (SQLException e){}
	}
		public void CreateMenu(javax.servlet.jsp.JspWriter out){
		    try{
		    	Connection con2 = DBConnectionUtil.getConnection();
	        	Statement st2 = con2.createStatement();
	        	ResultSet rs2 = st2.executeQuery("select * from categories");
		        try
		        {
		            out.println("<nav>");
		            out.println("<ul class='nav'>");
		            while(rs2.next())
		            {
		                if(rs2.getString("parent_id").equals("0")) 
		                {
		                    out.println("<li>");
		                    out.println("<a href='product?categories_id="+rs2.getInt("categories_id")+"'>"+rs2.getString("categories_name")+"</a>");
		                    CreateChildMenu(rs2.getInt("categories_id"),out);
		                }                  
		            }
		            out.println("</ul>");
		            out.println("</nav>");
		        } catch(IOException ex){}
		    }
		    catch (SQLException e)
		    {
		    }
		}
%>

		<div class="header-bottom">
		<div class="container">
			<div class="h_menu4">
				<%CreateMenu(out);%>
				<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/nav.js"></script>
			</div>
		</div>
		</div>
		<div class="header-bottom-in">
		<div class="container">
		<div class="header-bottom-on">
			<p class="wel"><a href="#">Nhập tên sản phẩm bạn muốn tìm kiếm</a></p>
			<div class="header-can">
					<div class="down-top"></div>
					<div class="search">
						<form action="<%=request.getContextPath()%>/search" method="get">
							<input type="text" placeholder="Tên sản phẩm ?" name="keyword" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '';}">
							<input type="submit" value="">
						</form>
					</div>
					<div class="clearfix"> </div>
			</div>
			<div class="clearfix"></div>
		</div>
		</div>
		</div>
	</div>