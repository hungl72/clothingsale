<%@page import="daos.ProductDAO"%>
<%@page import="models.ProductDetail"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="models.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
<div class="banner-mat">
		<div class="container">
			<div class="banner">
	
				<!-- Slideshow 4 -->
			   <div class="slider">
			<ul class="rslides" id="slider1">
			  <li><img src="<%=request.getContextPath()%>/templates/public/images/banner.jpg" alt="">
			  </li>
			  <li><img src="<%=request.getContextPath()%>/templates/public/images/banner1.jpg" alt="">
			  </li>
			  <li><img src="<%=request.getContextPath()%>/templates/public/images/banner.jpg" alt="">
			  </li>
			  <li><img src="<%=request.getContextPath()%>/templates/public/images/banner2.jpg" alt="">
			  </li>
			</ul>
		</div>

				<div class="banner-bottom">
					<div class="banner-matter">
						<p>Childish Gambino - Camp Now Available for just $9.99</p> 
						<a href="single.html" class="hvr-shutter-in-vertical ">Purchase</a>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>				
			<!-- //slider-->
		</div>
	</div>
		<!---->
		<div class="container">
			<div class="content">
				<div class="content-top">
					<h3 class="future">Mới nhất</h3>
					<div class="content-top-in">
					<%
						if(request.getAttribute("listProductNews")!=null){
							ArrayList<Product> listProductNews = (ArrayList<Product>)request.getAttribute("listProductNews");
							for(Product product : listProductNews){
					%>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>&&parent_id=<%=product.getParent_id()%>&&categories_id=<%=product.getCategory_id()%>"><img src="<%=request.getContextPath()%>/uploads/images/<%=product.getProduct_image()%>" alt="" /></a>	
								<div class="top-content">
									<h5><a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>&&parent_id=<%=product.getParent_id()%>&&categories_id=<%=product.getCategory_id()%>"><%=product.getProduct_name()%></a><a href="<%=request.getContextPath()%>/favourite?product_id=<%=product.getProduct_id()%>" ><button class="btn btn-warning btn-xs" style="float: right;"><span>YÊU THÍCH</span></button></a></h5>
									<div class="white">
										<a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>&&parent_id=<%=product.getParent_id()%>&&categories_id=<%=product.getCategory_id()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">Xem chi tiết</a>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
					<%
								}
							}
					%>
					<div class="clearfix"></div>
					</div>
				</div>
								<div class="content-top">
					<h3 class="future">Khuyến mãi</h3>
					<div class="content-top-in">
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html"><img src="<%=request.getContextPath()%>/templates/public/images/pi.jpg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="single.html">Mascot Kitty - White</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2 ">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>2</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>

								</div>							
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html"><img src="<%=request.getContextPath()%>/templates/public/images/pi1.jpg" alt="" />	</a>
								<div class="top-content">
									<h5><a href="single.html">Bite Me</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>3</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html"><img src="<%=request.getContextPath()%>/templates/public/images/pi2.jpg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="single.html">Little Fella</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>5</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
						<div class="col-md-3 md-col">
							<div class="col-md">
								<a href="single.html"><img src="<%=request.getContextPath()%>/templates/public/images/pi3.jpg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="single.html">Astral Cruise</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>4</span><span>5</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
					<div class="clearfix"></div>
					</div>
				</div>
				<!---->
				<div class="content-middle">
					<h3 class="future">Nhãn hiệu đang kinh doanh</h3>
					<div class="content-middle-in">
					<ul id="flexiselDemo1">			
						<li><img src="<%=request.getContextPath()%>/templates/public/images/ap.png"/></li>
						<li><img src="<%=request.getContextPath()%>/templates/public/images/ap1.png"/></li>
						<li><img src="<%=request.getContextPath()%>/templates/public/images/ap2.png"/></li>
						<li><img src="<%=request.getContextPath()%>/templates/public/images/ap3.png"/></li>
					
					</ul>
            		<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo1").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/templates/public/js/jquery.flexisel.js"></script>

					</div>
				</div>
				<!---->
				<div class="content-bottom">
					<h3 class="future">Xem nhiều nhất</h3>
					<div class="content-bottom-in">
					<ul id="flexiselDemo2">			
						<li><div class="col-md men">
								<a href="single.html" class="compare-in "><img src="<%=request.getContextPath()%>/templates/public/images/pi4.jpg" alt="" />
								<div class="compare in-compare">
									<span>Add to Compare</span>
									<span>Add to Whislist</span>
								</div></a>
								<div class="top-content bag">
									<h5><a href="single.html">Symbolic Bag</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>4</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div></li>
						<li><div class="col-md men">
								<a href="single.html" class="compare-in "><img src="<%=request.getContextPath()%>/templates/public/images/pi5.jpg" alt="" />
								<div class="compare in-compare">
									<span>Add to Compare</span>
									<span>Add to Whislist</span>
								</div></a>	
								<div class="top-content bag">
									<h5><a href="single.html">Interesting Read</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>2</span><span>5</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div></li>
						<li><div class="col-md men">
								<a href="single.html" class="compare-in "><img src="<%=request.getContextPath()%>/templates/public/images/pi6.jpg" alt="" />
								<div class="compare in-compare">
									<span>Add to Compare</span>
									<span>Add to Whislist</span>
								</div></a>	
								<div class="top-content bag">
									<h5><a href="single.html">The Carter</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>1</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div></li>
						<li><div class="col-md men">
								<a href="single.html" class="compare-in "><img src="<%=request.getContextPath()%>/templates/public/images/pi7.jpg" alt="" />
								<div class="compare in-compare">
									<span>Add to Compare</span>
									<span>Add to Whislist</span>
								</div></a>	
								<div class="top-content bag">
									<h5><a href="single.html">Onesie</a></h5>
									<div class="white">
										<a href="single.html" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">ADD TO CART</a>
										<p class="dollar"><span class="in-dollar">$</span><span>6</span><span>0</span></p>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div></li>
					
					</ul>
					<script type="text/javascript">
		$(window).load(function() {
			$("#flexiselDemo2").flexisel({
				visibleItems: 4,
				animationSpeed: 1000,
				autoPlay: true,
				autoPlaySpeed: 3000,    		
				pauseOnHover: true,
				enableResponsiveBreakpoints: true,
		    	responsiveBreakpoints: { 
		    		portrait: { 
		    			changePoint:480,
		    			visibleItems: 1
		    		}, 
		    		landscape: { 
		    			changePoint:640,
		    			visibleItems: 2
		    		},
		    		tablet: { 
		    			changePoint:768,
		    			visibleItems: 3
		    		}
		    	}
		    });
		    
		});
	</script>
					</div>
				</div>
				<ul class="start">
					<li ><a href="#"><i></i></a></li>
					<li><span>1</span></li>
					<li class="arrow"><a href="#">2</a></li>
					<li class="arrow"><a href="#">3</a></li>
					<li class="arrow"><a href="#">4</a></li>
					<li class="arrow"><a href="#">5</a></li>
					<li ><a href="#"><i  class="next"> </i></a></li>
				</ul>
			</div>
		</div>
<%@ include file="/templates/public/inc/footer.jsp" %>