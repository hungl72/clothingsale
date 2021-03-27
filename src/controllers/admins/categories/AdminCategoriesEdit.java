package controllers.admins.categories;

import java.io.IOException;
import java.util.Locale.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import models.Categories;

public class AdminCategoriesEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminCategoriesEdit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categories_id = Integer.parseInt(request.getParameter("categories_id"));
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		request.setAttribute("categories", categoriesDAO.findCategories(categories_id));
		request.getRequestDispatcher("/views/admin/cat/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		try {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		Categories cat = new Categories(id,name);
		int edit = categoriesDAO.edit(cat);
		if(edit>0) {
			//sua thanh cong
			response.sendRedirect(request.getContextPath()+"/admincategories?msg=1");
			return;
		}
		//sua that bai
		request.setAttribute("cat", cat);
		}catch(Exception e) {}
		RequestDispatcher rd=request.getRequestDispatcher("/admincategories?msg=2");
		rd.forward(request, response);
	}

}
