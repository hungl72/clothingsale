package controllers.publics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UserDAO;
import utils.StringUtil;

public class ControllersPublicSignup extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/public/signup.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		UserDAO userDAO = new UserDAO();
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		int result = 0;
		result = userDAO.addUser(fullname, email, pass);
		if(result > 0) {
			request.setAttribute("result",result);
			request.getRequestDispatcher("/views/public/login.jsp").forward(request, response);
		}else {
				
			}
	}

}
