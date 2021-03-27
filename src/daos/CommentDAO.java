package daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Categories;
import models.Comment;
import models.User;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class CommentDAO extends AbstractDAO{
	public void insertComment(String user,String detail,String time,int cat_id) {
		List<Comment> list = new ArrayList<>();
		con = DBConnectionUtil.getConnection();
		String sql = "insert into commentsproduct (user_comment,detail_comment,time_comment,idcategories) values(?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, user);pst.setString(2, detail);pst.setString(3, time);pst.setInt(4, cat_id);
			int result = pst.executeUpdate();
			if(result > 0) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
	}
	
	public ArrayList<Comment> findAllCommentByCatId(int catid) {
		ArrayList<Comment> list = new ArrayList<Comment>();
		con = DBConnectionUtil.getConnection();
		String sql = "select * from comments where cat_id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, catid);
			rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Comment(rs.getInt("id_comment"),rs.getString("user_comment"),rs.getString("detail_comment"),rs.getString("time_comment"),rs.getInt("cat_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return list;
	}
	
	public ArrayList<Comment> findCatIDById(int id) {
		ArrayList<Comment> list = new ArrayList<Comment>();
		con = DBConnectionUtil.getConnection();
		String sql = "select cat_id from songs where id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Comment(rs.getInt("id_comment"),rs.getString("user_comment"),rs.getString("detail_comment"),rs.getString("time_comment"),rs.getInt("cat_id")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return list;
	}
	
	public ArrayList<Comment> findAll(int idcategories) {
		ArrayList<Comment> list = new ArrayList<Comment>();
		con = DBConnectionUtil.getConnection();
		String sql = "select * from commentsproduct where idcategories = ? order by id_comment desc limit 5";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, idcategories);
			rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new Comment(rs.getInt("id_comment"),rs.getString("user_comment"),rs.getString("detail_comment"),rs.getString("time_comment"),rs.getInt("idcategories")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return list;
	}
	public List<Comment> getItemPagination(int offset) {
		Comment comment = null;
		con = DBConnectionUtil.getConnection();
		String sql = "select * from commentsproduct order by id_comment desc limit ?,? ";
		List<Comment> listComment = new ArrayList<Comment>();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				comment = new Comment(rs.getInt("id_comment"),
						rs.getString("user_comment"), 
						rs.getString("detail_comment"), 
						rs.getString("time_comment"), 
						rs.getInt("idcategories"));
				listComment.add(comment);
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listComment;
	}
	public List<Comment> findAllComments() {
		Comment comment = null;
		List<Comment> listComment = new ArrayList<Comment>();
		con = DBConnectionUtil.getConnection();
		String sql = "select * from commentsproduct";
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				comment = new Comment(rs.getInt("id_comment"),
						rs.getString("user_comment"), 
						rs.getString("detail_comment"), 
						rs.getString("time_comment"), 
						rs.getInt("idcategories"));
				listComment.add(comment);
			}
			;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, st, con);
		}
		return listComment;
	}
}
