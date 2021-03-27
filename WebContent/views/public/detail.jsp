<%@page import="models.Comment"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="models.ProductDetail"%>
<%@page import="daos.ProductDAO"%>
<%@page import="models.Categories"%>
<%@page import="com.sun.javafx.beans.IDProperty"%>
<%@page import="models.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/public/inc/header.jsp" %>
		<div class="container">
			<div class="single">
				<div class="col-md-9 top-in-single" id="review">
				<%
				Product detailProduct = (Product)request.getAttribute("product");
				int idCategories = Integer.parseInt(request.getParameter("categories_id"));
				int idProductViewing = detailProduct.getProduct_id();
				int ParentId = Integer.parseInt(request.getParameter("parent_id"));
					if(request.getAttribute("product")!=null){					
				%>
					<div class="col-md-5 single-top">	
						<ul id="etalage">
							<li>
								<a href="optionallink.html">

									<img class="etalage_source_image img-responsive" src="<%=request.getContextPath()%>/uploads/images/<%=detailProduct.getProduct_image()%>" alt="" >
								</a>
							</li>
						</ul>

					</div>	
					<div class="col-md-7 single-top-in">
						<div class="single-para">
						<span class="idproductviewing" hidden><%=idProductViewing%></span>
						<span class="parentid" hidden><%=ParentId%></span>
							<h4>Sản phẩm : <%=detailProduct.getProduct_name()%></h4>
							<h4>Mô tả sản phẩm : </h4>
							<p><%=detailProduct.getProduct_description()%></p>
						</div>
					</div>
					<h3 id="review"></h3>
					<h4>Bình luận về sản phẩm này :</h4>
			    <div class="comment-form-container">
			    <form id="frm-comment">
			        <div class="input-row">
			            <input type="hidden" name="comment_id" value="<%=idCategories%>" id="commentId"placeholder="Name" /> 
			            <input class="input-field" type="text" name="name" id="name" placeholder="Name" />
			        </div><br />
			        <div class="input-row">
			            <textarea class="input-field" type="text" name="comment"
			                id="commentarea" placeholder="Add a Comment"></textarea>
			        </div><br />
			        <div>
			            <input type="button" class="btn-submit" id="submitButton"
			                value="Gửi bình luận" />
			        </div>
			    </form>
			</div>
			<div id="displaycomment">
	<%
		if(request.getAttribute("fullComment") != null){
			ArrayList<Comment> listComment = (ArrayList)request.getAttribute("fullComment");
			for(Comment c : listComment){
	%>
	<span><%=c.getDetail()%> - Bình luận bởi : <%=c.getUser()%> - Vào lúc <%=c.getTime()%></span><br />
	<%
			}
		}
	%>
</div>
<script>
var average = 0;var value = 0;
$("#submitButton").click(function() {
	$("#comment-message").css('display', 'none');
	var categories_id = $("input[id='commentId']").val();
	var name = $("input[id='name']").val();;
	var comment = $("textarea[id='commentarea']").val();
	$.ajax({
		url : '<%=request.getContextPath()%>/ajaxcomment',
		type : 'post',
		data :{categories_id : categories_id, name : name, comment : comment},
		success : function(data) {
			$("#displaycomment").html(data);
			$("#name").val("");
			$("#commentarea").val("");
		}
	});
});
</script>
				<%
					}
				%>
				<div class="clearfix"> </div><br />
				<h3>Các loại <%=detailProduct.getProduct_name()%> : </h3><br />
				<table class="table table-bordered font-weight-bold">
					<tr>
						<td>Thương hiệu</td>
						<td>Màu sắc</td>
						<td>Kích cỡ</td>
						<td>Chất liệu</td>
						<td>Xuất xứ</td>
						<td>Kho hàng</td>
						<td>Yêu thích</td>
						<td>Chi tiết sản phẩm</td>
					</tr>
					<%
						ArrayList<ProductDetail> arrProductDetail = new ArrayList<ProductDetail>();
						ProductDAO productDAO = new ProductDAO();
						arrProductDetail = productDAO.listProductDetailInDetail(Integer.parseInt(request.getParameter("product_id")));
						if(arrProductDetail != null && arrProductDetail.size() > 0){
					%>
					
					<%
					for(ProductDetail pd : arrProductDetail){
					%>
					<tr>
						<td><%=pd.getProduct_detail_brand()%></td>
						<td><%=pd.getProduct_detail_color()%></td>
						<td><%=pd.getProduct_detail_size()%></td>
						<td><%=pd.getProduct_detail_material()%></td>
						<td><%=pd.getProduct_detail_origin()%></td>
						<td><%=pd.getProduct_detail_amount()%></td>
						<td><a href="<%=request.getContextPath()%>/favourite?product_id=<%=pd.getProduct_detail_id()%>" ><button class="btn btn-danger btn-xs" style="float: right;"><span>YÊU THÍCH</span></button></a></td>
						<td><a href="detailproduct?product_id=<%=pd.getProduct_detail_id()%>&&parent_id=<%=ParentId%>">Xem chi tiết</a></td>
					</tr>
					<%}%>
				</table><br />
				<%}else{%>
					<table style="border : 2px solid black">
					<tr style="font-weight: bold;border : 2px solid #FB5E33"><h4>Sản phẩm này chưa có thông tin nào!</h4></tr>
				</table><br />
				<%} %>
				<h3>Sản phẩm cùng loại</h3>
				<div class="content-top-in">
				<%
					if(request.getAttribute("listproductequalcategories")!=null){
						ArrayList<Product> listProduct = (ArrayList<Product>)request.getAttribute("listproductequalcategories");
						for(Product product : listProduct){
							if(product.getProduct_id()!=idProductViewing){
				%>
						<div class="col-md-4 top-single">
							<div class="col-md">
								<a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>&&parent_id=<%=ParentId%>&&categories_id=<%=product.getCategory_id()%>"><img src="<%=request.getContextPath()%>/templates/public/images/pic8.jpg" alt="" /></a>	
								<div class="top-content">
									<h5><a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>&&parent_id=<%=product.getParent_id()%>&&categories_id=<%=product.getCategory_id()%>"><%=product.getProduct_name()%></a><a href="<%=request.getContextPath()%>/favourite?product_id=<%=product.getProduct_id()%>" ><button class="btn btn-warning btn-xs" style="float: right;"><span>YÊU THÍCH</span></button></a></h5>
									<div class="white">
										<a href="<%=request.getContextPath()%>/detail?product_id=<%=product.getProduct_id()%>&&parent_id=<%=ParentId%>&&categories_id=<%=product.getCategory_id()%>" class="hvr-shutter-in-vertical hvr-shutter-in-vertical2">Xem chi tiết</a>
										<div class="clearfix"></div>
									</div>
								</div>							
							</div>
						</div>
				<%
							}
						}
					}
				%>
					<div class="clearfix"></div>
					</div>
				</div>
				<div class="col-md-3">
				<h4>BỘ LỌC TÌM KIẾM</h4><br />
			<%
			ArrayList<ProductDetail> listProductDetail = productDAO.listProductDetail();
			Categories categories = null;
			int categories_id = Integer.parseInt(request.getParameter("categories_id"));
			%>
        <h4>BẠN MUỐN TÌM LOẠI <%=productDAO.findCategoriesNameOfCategoriesByCategoriesIdOfProduct(categories_id).getCategories_name()%> NÀO?</h4><br />
        <h4>Màu sắc</h4><br />
        <%
        		ArrayList<String> arrRoot = new ArrayList<String>();
       		    ArrayList<String> arrChanged = new ArrayList<String>();
       		    String [] strR = null;
        		for(ProductDetail productDetailFilter : listProductDetail){
            		strR = productDetailFilter.getProduct_detail_color().split(",");
            		for(String root : strR){
            			arrRoot.add(root);
            		}
        		}
        		for(String changed : arrRoot){
        			if (!arrChanged.contains(changed)) {
        				arrChanged.add(changed);
        			}
        		}
        		for(String loadArrayChanged : arrChanged){
        %>
        <input type="checkbox" name="hobby" value="<%=loadArrayChanged%>"/> <label><%=loadArrayChanged%></label> <br/>
        <%}%><br />
        <h4>Kích thước</h4><br />
        <%
        		ArrayList<String> arrayRoot = new ArrayList<String>();
       		    ArrayList<String> arrayChanged = new ArrayList<String>();
       		    String [] strRoot = null;
        		for(ProductDetail productDetailFilter : listProductDetail){
            		strRoot = productDetailFilter.getProduct_detail_size().split(",");
            		for(String root : strRoot){
            			arrayRoot.add(root);
            		}
        		}
        		for(String changed : arrayRoot){System.out.print(changed);
        			if (!arrayChanged.contains(changed)) {
        				arrayChanged.add(changed);
        			}
        		}
        		for(String loadArrayChanged : arrayChanged){
        %>
        <input type="checkbox" name="hobby" value="<%=loadArrayChanged%>"/> <label><%=loadArrayChanged%></label> <br/>
        <%}%><br />
        <input type="button" id="btn" value="ÁP DỤNG"/>
        
        <script language="javascript">
            document.getElementById('btn').onclick = function()
            {
                // Khai báo tham số
                var checkbox = document.getElementsByName('hobby');
                var result = "";
                var idProductViewing = $('.idproductviewing').html();
                var parentid = $('.parentid').html();
                // Lặp qua từng checkbox để lấy giá trị
                for (var i = 0; i < checkbox.length; i++){
                    if (checkbox[i].checked === true){
                        result += checkbox[i].value+",";
                    }
                }
                
                $.ajax({                
            		url : '<%=request.getContextPath()%>/searchajax',
            		type : 'post',
            		data :{result : result,idProductViewing : idProductViewing,parentid : parentid},
            		success : function(data) {
            			$('#review').html(data);
            		}
                });
            };
        </script>
				</div>
				<div class="clearfix"> </div>
		</div>
	</div>
<%@ include file="/templates/public/inc/footer.jsp" %>