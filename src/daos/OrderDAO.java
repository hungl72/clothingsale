package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xpath.internal.operations.Or;

import models.Comment;
import models.Order;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class OrderDAO extends AbstractDAO{
	public List<Order> getItemPagination(int offset) {
		Order order = null;
		con = DBConnectionUtil.getConnection();
		String sql = "select * from orderproduct order by order_id desc limit ?,? ";
		List<Order> listOrder = new ArrayList<Order>();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				order = new Order(rs.getInt("order_id"),
						rs.getString("order_brand"), 
						rs.getString("order_color"), 
						rs.getString("order_size"), 
						rs.getString("order_material"), 
						rs.getString("order_origin"), 
						rs.getInt("order_amount"), 
						rs.getDouble("order_total"), 
						rs.getString("order_message"), 
						rs.getString("order_user"), 
						rs.getString("order_address"));
				listOrder.add(order);
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listOrder;
	}
	public List<Order> findAllOrder() {
		Order order = null;
		List<Order> listOrder = new ArrayList<Order>();
		con = DBConnectionUtil.getConnection();
		String sql = "select * from orderproduct";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				order = new Order(rs.getString("order_brand"), 
						rs.getString("order_color"), 
						rs.getString("order_size"), 
						rs.getString("order_material"), 
						rs.getString("order_origin"), 
						rs.getInt("order_amount"), 
						rs.getDouble("order_total"), 
						rs.getString("order_message"), 
						rs.getString("order_user"), 
						rs.getString("order_address"));
				listOrder.add(order);
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, st, con);
		}
		return listOrder;
	}
}
