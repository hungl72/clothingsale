package controllers.admins.decentralization;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.DecentralizationDAO;

public class AdminIndexDecentralization extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminIndexDecentralization() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idActionCode = request.getParameter("idActionCode");
		String cutIdActionCode [] = idActionCode.split(",");
		int id = Integer.parseInt(cutIdActionCode[0]);
		int action = Integer.parseInt(cutIdActionCode[1]);
		String code = cutIdActionCode[2];
		new DecentralizationDAO().updateUserAction(action==1?0:1, id, code);System.out.println("id : "+id+"action :"+action+"code : "+code);System.out.println("ket qua : "+action);
	}

}
