package controllers.publics;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.encoding.soap.SOAP12Constants;

import daos.PictureDAO;
import daos.ProductDAO;
import models.Picture;
import models.ProductDetail;

public class ControllersPublicDetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersPublicDetailProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		PictureDAO pictureDAO = new PictureDAO();
		ArrayList<Picture> listPicture = null;
		ProductDetail productDetail = null;
		int product_id = Integer.parseInt(request.getParameter("product_id"));System.out.println("product_id"+product_id);
		productDetail =  productDAO.productDetailByIdProductDetail(product_id);System.out.println("productDetail"+productDetail);
		listPicture = pictureDAO.listPicture(product_id);System.out.println("PRODUCTID : "+product_id+"listPicture : "+listPicture);
		for(Picture pp : listPicture) {
			System.out.println(pp.getPicture_name());
		}
		request.setAttribute("listPicture", listPicture) ;
		request.setAttribute("productDetail", productDetail);
		request.getRequestDispatcher("views/public/detailproduct.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
