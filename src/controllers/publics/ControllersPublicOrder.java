package controllers.publics;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.OrderProductDAO;
import models.Cart;
import models.Item;
import models.User;

public class ControllersPublicOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ControllersPublicOrder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Cart cart = null;
		if(session.getAttribute("cartProduct") != null) {
			cart = (Cart)session.getAttribute("cartProduct");
		}
		User user = (User)session.getAttribute("user");
		double total = 0,totalFinal = 0;
		String order_brand = "",order_color = "",order_size = "",order_material = "",order_origin = "";
		int order_amount = 0;double order_total = 0;
		for(Map.Entry<Integer, Item> listCart : cart.getCartItem().entrySet()) {
			order_brand += listCart.getValue().getProductDetail().getProduct_detail_brand()+",";
			order_color +=  listCart.getValue().getProductDetail().getProduct_detail_color()+",";
			order_size += listCart.getValue().getProductDetail().getProduct_detail_size()+",";
			order_material += listCart.getValue().getProductDetail().getProduct_detail_material()+",";
			order_origin += listCart.getValue().getProductDetail().getProduct_detail_origin()+",";
			order_amount += listCart.getValue().getAmountItem();
			order_total += listCart.getValue().getProductDetail().getProduct_detail_price()*listCart.getValue().getAmountItem();
			totalFinal += order_total;
		}
		String order_user = user.getFull_name();
		String order_address = request.getParameter("address");
		String order_message = request.getParameter("message");
		new OrderProductDAO().insertOrder(order_brand, order_color, order_size, order_material, order_origin, order_amount, order_total, order_message, order_user, order_address);
		session.removeAttribute("cartProduct");
		response.sendRedirect(request.getContextPath()+"/cartdetail?success=ordercomplete");
	}

}
