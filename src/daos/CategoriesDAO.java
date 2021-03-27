package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Categories;
import models.ProductDetail;
import sun.security.pkcs11.Secmod.DbMode;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class CategoriesDAO extends AbstractDAO{
	public int countCategories() {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select count(categories_id) from categories where parent_id = 0");
			if(rs.next()) {
				result = rs.getInt("count(categories_id)");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return result;
	}
	public int countProduct() {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select count(product_id) from product");
			if(rs.next()) {
				result = rs.getInt("count(product_id)");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return result;
	}
	public int countUser() {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select count(user_id) from users");
			if(rs.next()) {
				result = rs.getInt("count(user_id)");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return result;
	}	
	public ArrayList<Categories> listCategories() {
		ArrayList<Categories> listCategories = new ArrayList<Categories>();
		Categories categories = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from categories where parent_id = 0");
			while(rs.next()) {
				categories = new Categories(rs.getInt("categories_id"),rs.getString("categories_name"),rs.getInt("parent_id"));
				listCategories.add(categories);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listCategories;
	}
	public int addCategoriesParent(String categories_name) {
		int result = -1;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into categories (categories_name,parent_id) values (?,0)");
			pst.setString(1, categories_name);
			result = pst.executeUpdate();
			if(result > 0) {
				return result;
			}else {
				return result = 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public int addCategoriesSon(String categories_name,int parent_id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into categories (categories_name,parent_id) values (?,?)");
			pst.setString(1, categories_name);pst.setInt(2, parent_id);
			result = pst.executeUpdate();
			if(result > 0) {
				return result;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
	public ArrayList<Categories> listCategoriesNamebyParentIdZero(){
		ArrayList<Categories> listCategoriesName = new ArrayList<Categories>();
		Categories categories = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from categories where parent_id = 0");
			while(rs.next()) {
				categories = new Categories(rs.getInt("categories_id"),rs.getString("categories_name"));
				listCategoriesName.add(categories);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listCategoriesName;
	}
	public int edit(Categories cat) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "UPDATE categories SET categories_name = ? WHERE categories_id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, cat.getCategories_name());
			pst.setInt(2, cat.getCategories_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return result;
	}
	public Categories findCategories(int categories_id) {
		Categories categories = null;
		con = DBConnectionUtil.getConnection();
		String sql = "select * from categories where categories_id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, categories_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				categories = new Categories(rs.getInt("categories_id"),rs.getString("categories_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return categories;
	}
	public int del(int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		String sql = "delete from categories where categories_id=?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return result;
	}
	public ArrayList<Categories> listCategoriesSon(){
		Categories categories = null;
		ArrayList<Categories> listCategoriesSon = new ArrayList<Categories>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from categories where categories.parent_id != 0");
			while(rs.next()) {
				categories = new Categories(rs.getInt("categories_id"),
														   rs.getString("categories_name"),
														   rs.getInt("parent_id"));
				listCategoriesSon.add(categories);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listCategoriesSon;
	}
	public ArrayList<Categories> listCategoriesSonParentId(int parent_id){
		Connection con2 = null;
		PreparedStatement pst2 = null;
		ResultSet rs2 = null;
		ArrayList<Categories> listCategories = new ArrayList<Categories>();
		Categories categories2 = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from categories where categories.parent_id = ?");
			pst.setInt(1, parent_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				con2 = DBConnectionUtil.getConnection();
				pst2 = con2.prepareStatement("select * from categories where categories_id = ?");
				rs.getInt("parent_id");
				rs2 = pst2.executeQuery();
				while(rs2.next()) {
					categories2 = new Categories(rs2.getInt("categories_id"),
							   rs2.getString("categories_name"),
							   rs2.getInt("parent_id"));
					listCategories.add(categories2);
				}
				return listCategories;
			}
			return listCategories;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs2, pst2, con2);DBConnectionUtil.close(rs, pst, con);}
		return listCategories;
	}
	public int addCategoriesSon(String categories_name_string,String picture,String description,int categories_id_int,int parent_id_int) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into product (product_name,product_image,product_description,categories_id,parent_id) values (?,?,?,?,?)");
			pst.setString(1, categories_name_string);pst.setString(2, picture);pst.setString(3, description);pst.setInt(4, categories_id_int);pst.setInt(5, parent_id_int);
			result = pst.executeUpdate();
			if(result > 0) {
				return 1;
			}else {
				result = 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	public List<Categories> getItemPagination(int offset) {
		con = DBConnectionUtil.getConnection();
		String sql = "select * from categories where parent_id = 0 order by categories_id desc limit ?,? ";
		List<Categories> listItems = new ArrayList<Categories>();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				Categories cat = new Categories(rs.getInt("categories_id"), rs.getString("categories_name"));
				listItems.add(cat);
			};
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listItems;
	}
	public List<Categories> findAll() {
		List<Categories> list = new ArrayList<>();
		con = DBConnectionUtil.getConnection();
		String sql = "select * from categories where parent_id = 0";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Categories cat = new Categories(rs.getInt("categories_id"), rs.getString("categories_name"));
				list.add(cat);
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, st, con);
		}
		return list;
	}
	public ArrayList<Categories> findAllCategoriesParentIdNotEqualZero(){
		Categories categories = null;
		ArrayList<Categories> listCategories = new ArrayList<Categories>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from categories WHERE categories.parent_id != 0");
			while(rs.next()) {
				categories = new Categories(rs.getInt("categories_id"),
									  rs.getString("categories_name"));
				listCategories.add(categories);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listCategories;
	}
}
