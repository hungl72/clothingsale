package controllers.admins.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import daos.ProductDAO;
import daos.UserDAO;
import models.Categories;
import models.ProductDetail;
import models.User;
import utils.FileUtil;

public class AdminEditUserDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminEditUserDetail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		UserDAO userDAO = new UserDAO();
		request.setAttribute("userDetail", userDAO.user(user_id));
		request.getRequestDispatcher("/views/admin/user/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		UserDAO userDAO = new UserDAO();
		try {
		int id = Integer.parseInt(request.getParameter("userid"));
		String fullname = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(id, fullname, username, password);
		int edit = userDAO.update(user);
		if(edit>0) {
			//sua thanh cong
			response.sendRedirect(request.getContextPath()+"/adminusersindex?msg=1");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/adminusersindex?msg=0");
		}
		}catch(Exception e) {}
	}

}
