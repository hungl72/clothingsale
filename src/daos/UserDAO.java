package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Categories;
import models.User;
import utils.DBConnectionUtil;
import utils.DefineUtil;
import utils.StringUtil;

public class UserDAO extends AbstractDAO{
	public int addUser(String fullname,String email,String pass) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into users(full_name,email,password) values(?,?,?)");
			pst.setString(1, fullname);pst.setString(2, email);pst.setString(3, StringUtil.md5(pass));
			result = pst.executeUpdate();
			if(result <= 0) {
				result = 0;
			}
		}catch (Exception e) {e.printStackTrace();
		}finally {DBConnectionUtil.close(pst, con);}
		return result;
	}
	public User loginUser(String email,String pass) {
		User user = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from users where email = ? and password = ?");
			pst.setString(1, email);pst.setString(2, StringUtil.md5(pass));
			rs = pst.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("user_id"),rs.getString("full_name"),rs.getString("email"),rs.getString("password"));
			}
		}catch (Exception e) {e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return user;
	}
	public User loginAdmin(String email,String pass) {
		User user = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from users where email = ? and  password = ?");
			pst.setString(1, email);pst.setString(2, pass);
			rs = pst.executeQuery();
			while(rs.next()) {
				user = new User(rs.getInt("user_id"),rs.getString("email"),rs.getString("password"));
			}
		}catch (Exception e) {e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return user;
	}
	public int checkMail(String email) {
		int result  = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from users where email = ?");
			pst.setString(1, email);
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
	public ArrayList<User> listUser(){
		ArrayList<User> listUser = new ArrayList<User>();
		User users = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from users");
			while(rs.next()) {
				users = new User(rs.getInt("user_id"),rs.getString("full_name"),rs.getString("email"));
				listUser.add(users);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listUser;
	}
	public User user(int user_id) {
		User user = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from users where user_id  = ?");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("user_id"),rs.getString("full_name"),rs.getString("email"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return user;
	}

	public int update(User user) {
		int result=0;
		con=DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("update users set user_id = ?, full_name = ? , email = ? , password = ? WHERE user_id = ? ");
			pst.setInt(1, user.getUser_id());
			pst.setString(2, user.getFull_name());
			pst.setString(3, user.getEmail());
			pst.setString(4, StringUtil.md5(user.getPassword()));
			pst.setInt(5, user.getUser_id());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public int del(int id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("delete from users where user_id = ?");
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public List<User> getItemPagination(int offset) {
		User user = null;
		con = DBConnectionUtil.getConnection();
		String sql = "select * from users order by user_id desc limit ?,? ";
		List<User> listUsers = new ArrayList<User>();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("full_name"), rs.getString("email"));
				listUsers.add(user);
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listUsers;
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
}
