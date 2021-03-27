package controllers.publics;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ProductDAO;
import models.FavouriteHandling;
import models.Product;
import models.ProductDetail;

public class ControllersPublicFavourites extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		FavouriteHandling favouritehandling = (FavouriteHandling)session.getAttribute("favouritehandling");
		ProductDetail productFavourite = new ProductDetail();
		ProductDAO productDAO = new ProductDAO();
		int product_id  = Integer.parseInt(request.getParameter("product_id"));
		productFavourite = productDAO.findProductDetailFavouriteByProductId(product_id);
		int result = favouritehandling.add(product_id, productFavourite);System.out.println(result);
		session.setAttribute("favouritehandling", favouritehandling);
		request.setAttribute("product_id", product_id);
		request.setAttribute("result", result);
		request.getRequestDispatcher("/views/public/favourite.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
