package daos;

import java.util.ArrayList;

import models.Administrator;
import models.User;
import utils.DBConnectionUtil;

public class DecentralizationDAO extends AbstractDAO{
	public int checkAddDecentralization(int user_id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select full_name,action_name,check_action,lisenced,action_code from permisionuser as pe join users as u on u.user_id = pe.id_user join permision as p on pe.id_per = p.id_per join permisiondetail as pd on p.id_per = pd.id_per where u.user_id = ? AND action_code = 'ADD PRODUCT'");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt("check_action") == 1) {
					result = 1;
				}else {
					result = 0;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		System.out.println("user_id : "+result);
		return result;
	}
	public int checkEditDecentralization(int user_id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select full_name,action_name,check_action,lisenced,action_code from permisionuser as pe join users as u on u.user_id = pe.id_user join permision as p on pe.id_per = p.id_per join permisiondetail as pd on p.id_per = pd.id_per where u.user_id = ? AND action_code = 'EDIT PRODUCT'");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt("check_action") == 1) {
					result = 1;
				}else {
					result = 0;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		System.out.println("user_id : "+result);
		return result;
	}
	public int checkDelDecentralization(int user_id) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select full_name,action_name,check_action,lisenced,action_code from permisionuser as pe join users as u on u.user_id = pe.id_user join permision as p on pe.id_per = p.id_per join permisiondetail as pd on p.id_per = pd.id_per where u.user_id = ? AND action_code = 'DELETE PRODUCT'");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				if(rs.getInt("check_action") == 1) {
					result = 1;
				}else {
					result = 0;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		System.out.println("user_id : "+result);
		return result;
	}
	public ArrayList<Administrator> listUserId(){
		Administrator administrator = null;
		ArrayList<Administrator> listUserId = new ArrayList<Administrator>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select user_id from users");
			while(rs.next()) {
				administrator = new Administrator(rs.getInt("user_id"));
				listUserId.add(administrator);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listUserId;
	}
	public ArrayList<Administrator> listUser(){
		Administrator administrator = null;
		ArrayList<Administrator> listUser = new ArrayList<Administrator>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select DISTINCT user_id,full_name,email,name_per from permisionuser as pe join users as u on u.user_id = pe.id_user join permision as p on pe.id_per = p.id_per");
			while(rs.next()) {
				administrator = new Administrator(rs.getInt("user_id"), rs.getString("full_name"),rs.getString("email"), rs.getString("name_per"));
				listUser.add(administrator);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listUser;
	}
	public ArrayList<Administrator> listUserAction(int user_id){
		Administrator administrator = null;
		ArrayList<Administrator> listUserAction = new ArrayList<Administrator>();
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select user_id,full_name,email,name_per,check_action,action_code from permisionuser as pe join users as u on u.user_id = pe.id_user join permision as p on pe.id_per = p.id_per join permisiondetail as pd on pe.id_per = pd.id_per where u.user_id = ?");
			pst.setInt(1, user_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				administrator = new Administrator(rs.getInt("user_id"), rs.getString("full_name"),rs.getString("email"), rs.getString("name_per"), rs.getInt("check_action"),rs.getString("action_code"));
				listUserAction.add(administrator);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listUserAction;
	}
	public void updateUserAction(int check_action,int user_id,String action_code){
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("update permisiondetail set check_action = ? where permisiondetail.id_per = ? and permisiondetail.action_code = ?");
			pst.setInt(1, check_action);pst.setInt(2, user_id);pst.setString(3, action_code);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public int checkAdministrators(int id_user){
		int result = 0;
	con = DBConnectionUtil.getConnection();
	try {
		pst = con.prepareStatement("SELECT p.name_per FROM users as u JOIN permisionuser as pe on u.user_id = pe.id_user JOIN permision as p on pe.id_per = p.id_per AND p.name_per = 'Administrators' and u.user_id = ?");
		pst.setInt(1, id_user);
		rs = pst.executeQuery();
		if(rs.next()) {
			result = 1;
		}else {
			result = 0;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result;
}
	public int checkAdmin(int id_user){
		int result = 0;
	con = DBConnectionUtil.getConnection();
	try {
		pst = con.prepareStatement("SELECT p.name_per FROM users as u JOIN permisionuser as pe on u.user_id = pe.id_user JOIN permision as p on pe.id_per = p.id_per AND p.name_per = 'Admin' and u.user_id = ?");
		pst.setInt(1, id_user);
		rs = pst.executeQuery();
		if(rs.next()) {
			result = 1;
		}else {
			result = 0;
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return result;
}
}
