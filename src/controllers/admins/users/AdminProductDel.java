package controllers.admins.users;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import daos.ProductDAO;

public class AdminProductDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminProductDel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		int id = Integer.parseInt(request.getParameter("product_id"));
		int del = productDAO.del(id);
		if(del > 0) {
			//xóa thành công
			response.sendRedirect(request.getContextPath()+"/adminproductsindex?msg=delcomplete");
			return;
		}
		//thất bại
		response.sendRedirect(request.getContextPath()+"/adminproductsindex?err=delerror");
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
