package controllers.publics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductDAO;
import models.ProductDetail;

public class PublicSearchFillerAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PublicSearchFillerAjax() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");request.setCharacterEncoding("utf-8");request.setCharacterEncoding("utf-8");
		PrintWriter p = response.getWriter();
		ProductDAO productDAO = new ProductDAO();
		String result = request.getParameter("result");
		int idProductViewing = Integer.parseInt(request.getParameter("idProductViewing"));System.out.println("idProductViewing : "+idProductViewing);
		int parentid = Integer.parseInt(request.getParameter("parentid"));System.out.println("parentid : "+parentid);
		System.out.println("asdad"+result);
		String [] arr = result.split(",");
		ArrayList<String> listKeySearch = new ArrayList<String>();
		ArrayList<ProductDetail> arrProductSearch = new ArrayList<ProductDetail>();
		for(String s : arr) {
			listKeySearch.add(s);
		}System.out.println("listkey"+listKeySearch);
		arrProductSearch = productDAO.listProductDetailLike(listKeySearch,idProductViewing);System.out.println("mang ket qua " +arrProductSearch);
		for(ProductDetail pro : arrProductSearch) {
			p.write(pro.getProduct_detail_brand());
			p.write("<div style=\"display: flex;\">\r\n" + 
					"					<h4>Mã sản phẩm : </h4>\r\n" + pro.getProduct_id() +
					"					<h4>Thương hiệu : </h4>\r\n" + pro.getProduct_detail_brand() +
					"					<h4>Màu sắc : </h4>\r\n" + pro.getProduct_detail_color() +
					"					<h4>Kích cỡ : </h4>\r\n" + pro.getProduct_detail_size() +
					"					<h4>Chất liệu : </h4>\r\n" + pro.getProduct_detail_material() +
					"					<h4>Xuất xứ : </h4>\r\n" + pro.getProduct_detail_origin() +
					"					<h4>Số lượng : </h4>\r\n" + pro.getProduct_detail_amount() +
					"					<a href=\"detailproduct?product_id="+pro.getProduct_detail_id()+"&&parent_id="+parentid+"\">Chi tiết sản phẩm</a>\r\n" + 
					"				</div>");
		}
	}
}
