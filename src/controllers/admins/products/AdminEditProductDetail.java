package controllers.admins.products;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductDAO;
import models.ProductDetail;
import utils.FileUtil;
@MultipartConfig
public class AdminEditProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminEditProductDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int product_id = Integer.parseInt(request.getParameter("product_id"));System.out.println("product_id"+product_id);
		ProductDAO productDAO = new ProductDAO();
		request.setAttribute("productDetail", productDAO.findProductDetailByProductId(product_id));
		request.getRequestDispatcher("/views/admin/product/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int idproduct = Integer.parseInt(request.getParameter("idp"));
		String brand = request.getParameter("brand");
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String material = request.getParameter("material");
		String origin = request.getParameter("origin");
		int amount = Integer.parseInt(request.getParameter("amount"));
		double price = Double.parseDouble(request.getParameter("price"));
		String fileName=FileUtil.upload("picture", request);
		System.out.println(fileName);
		ProductDAO productDAO = new ProductDAO();
		if("".equals(fileName)) {
			ProductDetail productDetail = productDAO.findProductDetailByProductId(idproduct);
			fileName= productDetail.getProduct_detail_image();
		}
		ProductDetail productDetail = new ProductDetail(idproduct, brand, color, size, material, origin, amount, price, fileName);
		if(productDAO.update(productDetail)>0) {
			response.sendRedirect(request.getContextPath()+"/adminproductsindex?msg=1");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/adminproductsindex?msg=0");
		}
	}

}
