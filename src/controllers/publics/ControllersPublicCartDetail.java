package controllers.publics;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Cart;
import models.Item;

public class ControllersPublicCartDetail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String success = null;
		try {
			if(request.getParameter("success") != null) {
				success = request.getParameter("success");
			}
		} catch (Exception e) {
			
	}
		request.setAttribute("success", success);
		request.getRequestDispatcher("/views/public/cartdetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
