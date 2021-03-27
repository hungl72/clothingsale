package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CommentDAO;
import daos.ProductDAO;
import models.Product;

public class ControllersPublicDetail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		int categories_id = Integer.parseInt(request.getParameter("categories_id"));
		int parent_id =Integer.parseInt(request.getParameter("parent_id"));
		Product product = productDAO.findProductByProductId(product_id);
		request.setAttribute("listproductequalcategories", productDAO.findProductRelatedByCategoriesId(parent_id));
		request.setAttribute("product", product);
		request.setAttribute("fullComment", new CommentDAO().findAll(categories_id));
		request.getRequestDispatcher("/views/public/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
