package controllers.admins.categories;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CategoriesDAO;
import utils.FileUtil;
@MultipartConfig
public class AdminCategoriesParentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminCategoriesParentAdd() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		request.setAttribute("listCategoriesSon", categoriesDAO.listCategoriesSon());
		request.setAttribute("listCategoriesName", categoriesDAO.listCategoriesNamebyParentIdZero());
		request.setAttribute("parent", -1);
		request.setAttribute("son", -1);
		request.setAttribute("resultSonInformation", -1);
		request.getRequestDispatcher("/views/admin/cat/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		int parent_id = -1,resultSon = -1,parent = -1,resultSonInformation = -1;
		String categoriesAndParent = null,description = null,categories_name_son = null;
		String [] str3 = null;
		String categories_id_string = null,parent_id_string = null,categories_name_string = null,fileName = null;
		int categories_id_int = 0,parent_id_int = 0;
		CategoriesDAO categoriesDAO = new CategoriesDAO();
		try {
			parent_id = Integer.parseInt(request.getParameter("categories_id"));
			categories_name_son = request.getParameter("nameson");
			resultSon = categoriesDAO.addCategoriesSon(categories_name_son, parent_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			categoriesAndParent = request.getParameter("categoriesandparent");System.out.println(categoriesAndParent);
			str3 = categoriesAndParent.split(",");	
			categories_id_int = Integer.parseInt(categories_id_string = str3[0]);
			parent_id_int = Integer.parseInt(parent_id_string = str3[1]);
			categories_name_string = str3[2];
			fileName = FileUtil.upload("picture", request);
			description = request.getParameter("description");
			resultSonInformation = categoriesDAO.addCategoriesSon(categories_name_string, fileName, description, categories_id_int, parent_id_int);
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String categories_name_parent = request.getParameter("name");
			parent = categoriesDAO.addCategoriesParent(categories_name_parent);
		}catch (Exception e) {
			e.printStackTrace();
		}
			request.setAttribute("listCategoriesParentEqualZero", categoriesDAO.listCategoriesNamebyParentIdZero());
			request.setAttribute("parent", parent);
			request.setAttribute("categories_id", -1);
			request.setAttribute("son", resultSon);
			request.setAttribute("listCategoriesName", new CategoriesDAO().listCategoriesNamebyParentIdZero());
			request.setAttribute("listCategoriesSon", categoriesDAO.listCategoriesSon());
			request.setAttribute("resultSonInformation", resultSonInformation);
			request.getRequestDispatcher("/views/admin/cat/add.jsp").forward(request, response);
	}

}
