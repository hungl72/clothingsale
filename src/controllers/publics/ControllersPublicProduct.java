package controllers.publics;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CommentDAO;
import daos.ProductDAO;
import models.Product;

public class ControllersPublicProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		ProductDAO productDAO = new ProductDAO();
		int categories_id = Integer.parseInt(request.getParameter("categories_id"));System.out.println("cateid"+categories_id);
		int currentPage = 1;int numberPerPages = 4;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (Exception e) {
			currentPage = 1;
		}
		int numberOfItems = productDAO.findAllProductByCategoriesId(categories_id).size();
		int numberOfPages = (int)Math.ceil((float)numberOfItems/numberPerPages);
		if(currentPage > numberOfPages || currentPage < 1) {
			currentPage = 1;
		}
		int offset = (currentPage -1) * numberPerPages;
		ArrayList<Product> listProduct = productDAO.getItemPagination(categories_id,offset, numberPerPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("listProduct", listProduct);
		request.setAttribute("parent_id", categories_id);
		request.setAttribute("listproduct", productDAO.findAllProductByCategoriesId(categories_id));
		request.getRequestDispatcher("/views/public/products.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
