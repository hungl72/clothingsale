package daos;

import utils.DBConnectionUtil;

public class OrderProductDAO extends AbstractDAO{
	public void insertOrder(String order_brand,String order_color,String order_size,String order_material,String order_origin,int order_amount
			,double order_total,String order_message,String order_user,String order_address) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into orderproduct (order_brand,order_color,order_size,order_material,order_origin,order_amount,order_total,order_message,order_user,order_address) values (?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, order_brand);
			pst.setString(2, order_color);
			pst.setString(3, order_size);
			pst.setString(4, order_material);
			pst.setString(5, order_origin);
			pst.setInt(6, order_amount);
			pst.setDouble(7, order_total);
			pst.setString(8, order_message);
			pst.setString(9, order_user);
			pst.setString(10, order_address);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
	}
}
