package controllers.admins.index;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;

public class AdminIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AdminIndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		request.setAttribute("countCategories", categoriesDAO.countCategories());
		request.setAttribute("countProducts", categoriesDAO.countProduct());
		request.setAttribute("countUsers", categoriesDAO.countUser());
		request.getRequestDispatcher("/views/admin/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
