package controllers.publics;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.ProductDAO;
import models.Cart;
import models.Item;
import models.Product;
import models.ProductDetail;

public class ControllersPublicCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllersPublicCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cartProduct");
		ProductDAO productDAO = new ProductDAO();
		String command = request.getParameter("command");
		int productid = Integer.parseInt(request.getParameter("productid"));
		Product product = productDAO.findProductByProductId(productid);
		ProductDetail productDetail = productDAO.findProductDetailByProductId(productid);
		if(command.equalsIgnoreCase("addcart")) {
			if(cart.getCartItem().containsKey(productid)){
				cart.add(productid, new Item(productDetail,cart.getCartItem().get(productid).getAmountItem()));
					productDAO.amountDatabaseAfterAddCart(productDetail.getProduct_detail_id());
				}else {
					cart.add(productid, new Item(productDetail,1));
					productDAO.amountDatabaseAfterAddCart(productDetail.getProduct_detail_id());
				}
		}else {
			cart.del(productDetail.getProduct_detail_id());
			productDAO.amountDatabaseAfterRemoveAddCart(productDetail.getProduct_detail_id());
		}
		session.setAttribute("cartProduct", cart);
		response.sendRedirect(request.getContextPath()+"/detailproduct?product_id="+productDetail.getProduct_detail_id()+"&&parent_id="+productDetail.getCategories_id());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
