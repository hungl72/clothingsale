package controllers.publics;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductDAO;
import models.Product;
import models.ProductDetail;

public class ControllersPublicSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersPublicSearch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		ArrayList<ProductDetail> listProductSearch = new ArrayList<ProductDetail>();
		String keyword = request.getParameter("keyword");
		ProductDAO productDAO = new ProductDAO();
		listProductSearch = productDAO.findAllProductByKeyWord(keyword);
		request.setAttribute("listProductSearch", listProductSearch);
		request.getRequestDispatcher("/views/public/search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
