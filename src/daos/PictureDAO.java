package daos;

import java.util.ArrayList;

import models.Picture;
import utils.DBConnectionUtil;

public class PictureDAO extends AbstractDAO{
	public int add(String fileName,int idproduct) {
		int result = 0;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into picture (picture_name,product_detail_id) values (?,?)");
			pst.setString(1, fileName);
			pst.setInt(2, idproduct);
			result = pst.executeUpdate();
			if(result > 0) {
				return result = 1;
			}else {
				return result = 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public ArrayList<Picture> listPicture(int idproduct){
		ArrayList<Picture> listPicture = new ArrayList<Picture>();
		Picture picture = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from picture where product_detail_id = ?");
			pst.setInt(1, idproduct);
			rs = pst.executeQuery();
			while(rs.next()) {
				picture = new Picture(rs.getString("picture_name"), rs.getInt("product_detail_id"));
				listPicture.add(picture);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return listPicture;
	}
}
