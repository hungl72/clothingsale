package controllers.admins.products;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.addressing.ProblemAction;

import daos.CategoriesDAO;
import daos.ProductDAO;
import models.ProductDetail;
import utils.FileUtil;
@MultipartConfig
public class AdminAddProductsDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddProductsDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listCategoriesName", new CategoriesDAO().listCategoriesNamebyParentIdZero());
		request.setAttribute("listCategoriesNameNotEqualZero", new CategoriesDAO().findAllCategoriesParentIdNotEqualZero());
		request.setAttribute("listProductsName", new ProductDAO().findNameAndIdProduct());
		request.getRequestDispatcher("/views/admin/product/add.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		int result = 0;
		String brand = request.getParameter("brand");System.out.println(brand);
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String material = request.getParameter("material");
		String origin = request.getParameter("origin");
		int product_id = Integer.parseInt(request.getParameter("idproduct"));
		int idcategories = 0;
		int categories_id = 0;
		try {
			idcategories = Integer.parseInt(request.getParameter("idcategories"));
			categories_id = Integer.parseInt(request.getParameter("idproductdetail"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		int amount = Integer.parseInt(request.getParameter("amount"));
		double price = Double.parseDouble(request.getParameter("price"));
		String fileName=FileUtil.upload("picture", request);
		ProductDAO productDAO = new ProductDAO();
		result = productDAO.addProductDetail(brand, color, size, material, origin, product_id, amount, categories_id, price, fileName);
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/adminaddproductsdetail?msg=addcomplete");
			return;
		}
		request.getRequestDispatcher("/adminaddproductsdetail?msg=adderror").forward(request, response);
	}

}
