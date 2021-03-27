package controllers.admins.categories;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;

public class AdminCategoriesDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminCategoriesDel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		int id = Integer.parseInt(request.getParameter("categories_id"));
		int del = categoriesDAO.del(id);
		if(del > 0) {
			//xóa thành công
			response.sendRedirect(request.getContextPath()+"/admincategories?msg=delcomplete");
			return;
		}
		//thất bại
		response.sendRedirect(request.getContextPath()+"/admincategories?err=delerror");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
