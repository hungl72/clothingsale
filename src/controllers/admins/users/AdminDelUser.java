package controllers.admins.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import daos.UserDAO;

public class AdminDelUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminDelUser() {
        super();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
		int id = Integer.parseInt(request.getParameter("user_id"));
		int result = userDAO.del(id);
		if(result > 0) {
			//xóa thành công
			response.sendRedirect(request.getContextPath()+"/adminusersindex?msg=delcomplete");
			return;
		}else {
		//thất bại
		response.sendRedirect(request.getContextPath()+"/adminusersindex?msg=delerror");
		return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
