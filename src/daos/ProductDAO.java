package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Categories;
import models.Product;
import models.ProductDetail;
import sun.security.pkcs11.Secmod.DbMode;
import utils.DBConnectionUtil;
import utils.DefineUtil;

public class ProductDAO extends AbstractDAO{
	public ArrayList<Product> findAllProduct(){
		Product product;
		ArrayList<Product> listProduct = new ArrayList<Product>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from product");
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
									  rs.getString("product_name"),
									  rs.getString("product_image"),
									  rs.getString("product_description"),
									  rs.getInt("categories_id"),
									  rs.getInt("parent_id"));
				listProduct.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listProduct;
	}
	
	public ArrayList<Product> findAllProductByCategoriesId(int categories_id){
		Product product;
		ArrayList<Product> listProduct = new ArrayList<Product>();
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select product_id,product_name,product_image,product_description,product.categories_id from categories,product where categories.parent_id = ? and categories.categories_id = product.categories_id");
			pst.setInt(1, categories_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
							rs.getString("product_name"),
							rs.getString("product_image"),
							rs.getString("product_description"),
							rs.getInt("categories_id"));
				listProduct.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return listProduct;
	}
	public Product findProductByProductId(int product_id){
		Product product = new Product();
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from product where product_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"),
													rs.getString("product_image"),
													rs.getString("product_description"),
													rs.getInt("categories_id"),
													rs.getInt("parent_id"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return product;
	}
	public ArrayList<Product> findProductNews(){
		ArrayList<Product> listProductNews = new ArrayList<Product>();
		Product product;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select product_id,product_name,product_image,product_description,product.categories_id,categories.parent_id from categories,product where categories.categories_id = product.categories_id order by product_id desc limit 4");
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"),
													rs.getString("product_image"),
													rs.getString("product_description"),
													rs.getInt("categories_id"),
													rs.getInt("parent_id"));
				listProductNews.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listProductNews;
	}
	public ArrayList<Product> findProductRelatedByCategoriesId(int categories_id){
		ArrayList<Product> listProductRelated = new ArrayList<Product>();
		Product product;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("SELECT product_id,product_name,product_image,product_description,product.categories_id,product.parent_id FROM categories,product WHERE categories.categories_id = product.categories_id AND categories.parent_id = ?");
			pst.setInt(1, categories_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"),
													rs.getString("product_image"),
													rs.getString("product_description"),
													rs.getInt("categories_id"),
													rs.getInt("parent_id"));
				listProductRelated.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return listProductRelated;
	}
	public Categories findCategoriesNameOfCategoriesByCategoriesIdOfProduct(int categories_id){
		Categories categories = new Categories();
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select categories_name from categories where categories_id = ? limit 1");
			pst.setInt(1, categories_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				categories = new Categories(rs.getString("categories_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return categories;
	}
	public ArrayList<ProductDetail> findAllProductByKeyWord(String keyword){
		ProductDetail productDetail;
		ArrayList<ProductDetail> listProduct = new ArrayList<ProductDetail>();
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from productdetail where product_detail_brand like ?");
			pst.setString(1, "%"+keyword+"%");
			rs = pst.executeQuery();
			while(rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"), rs.getString("product_detail_brand"), rs.getString("product_detail_color"), rs.getString("product_detail_size"), rs.getString("product_detail_material"), rs.getString("product_detail_origin"), rs.getInt("product_id"), rs.getInt("product_detail_amount"), rs.getInt("categories_id"), rs.getDouble("product_detail_price"), rs.getString("product_detail_image"));
				listProduct.add(productDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return listProduct;
	}
	public void addFavourite(String favourite_name,double favourite_price,int amount) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("insert into favourite (favourite_name, favourite_price, favourite_amount) values (?, ?, ?)");
			pst.setString(1, favourite_name);pst.setDouble(2, favourite_price);pst.setInt(3, amount);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(con);DBConnectionUtil.close(st);}
	}

	public ArrayList<Product> getItemPagination(int categories_id,int offset,int numberPerPage) {
		Product product = new Product();
		con = DBConnectionUtil.getConnection();
		String sql = "select product_id,product_name,product_image,product_description,product.categories_id from categories,product where categories.parent_id = ? and categories.categories_id = product.categories_id ORDER BY product_id DESC LIMIT ?,?";
		ArrayList<Product> listItems = new ArrayList<>();
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, categories_id);
			pst.setInt(2,offset );
			pst.setInt(3, numberPerPage);
			rs=pst.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"),
													rs.getString("product_image"),
													rs.getString("product_description"),
													rs.getInt("categories_id"));
				listItems.add(product);
			} ;
		} catch (SQLException e) {
			e.printStackTrace();
		
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return listItems;
	}
	
	public ArrayList<Categories> listCategories(){
		ArrayList<Categories> listCategories = new ArrayList<Categories>();
		Categories categories = null;
		con  = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from categories where parent_id = 0");
			while(rs.next()) {
				categories = new Categories(rs.getString("categories_name"));
				listCategories.add(categories);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listCategories;
	}
	
	public Categories findNameCategoriesByParentId(int parent_id, int categories_id) {
		Categories categories = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from categories where parent_id = ? and categories_id = ?");
			pst.setInt(1, parent_id);pst.setInt(2, categories_id);
			rs = pst.executeQuery();
			while(rs.next()) {
			categories = new Categories(rs.getString("categories_name"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return categories;
	}
	
	public ArrayList<ProductDetail> listProductDetail(){
		ArrayList<ProductDetail> listProductDetail = new ArrayList<ProductDetail>();
		ProductDetail productDetail = null;
		con  = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from productdetail");
			while(rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"),
						  rs.getString("product_detail_brand"),
						  rs.getString("product_detail_color"),
						  rs.getString("product_detail_size"),
						  rs.getString("product_detail_material"),
						  rs.getString("product_detail_origin"),
						  rs.getDouble("product_detail_price"),
						  rs.getInt("product_id"),
						  rs.getInt("product_detail_amount"),
						  rs.getInt("categories_id"));
				listProductDetail.add(productDetail);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listProductDetail;
	}
	
	public ArrayList<ProductDetail> listProductDetailInDetail(int product_id){
		ArrayList<ProductDetail> listProductDetail = new ArrayList<ProductDetail>();
		ProductDetail product = null;
		con  = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select productdetail.* from product,productdetail where product.product_id = productdetail.product_id and productdetail.product_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				product =  new ProductDetail(rs.getInt("product_detail_id"),
						  rs.getString("product_detail_brand"),
						  rs.getString("product_detail_color"),
						  rs.getString("product_detail_size"),
						  rs.getString("product_detail_material"),
						  rs.getString("product_detail_origin"),
						  rs.getInt("product_id"),
						  rs.getInt("product_detail_amount"),
						  rs.getInt("categories_id"));
				listProductDetail.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listProductDetail;
	}
	
	public ArrayList<ProductDetail> listProductDetailLike(ArrayList<String> result,int product_id){
		ArrayList<String> arr1 = new ArrayList<String>();
		ArrayList<String> arr2 = new ArrayList<String>();
		ArrayList<ProductDetail> arr3= new ArrayList<ProductDetail>();
		ProductDetail pd; String sql;
		for(String str : result) {
			if(str.length() == 1) {
				arr1.add(str);
			}else{
				arr2.add(str);
			}
		}System.out.println("mang 1 : "+arr1);System.out.println("mang 2 : "+arr2);
				try {
					con = DBConnectionUtil.getConnection();
					if(arr2.size() == 0) {
						for(String s1 : arr1) {						
						sql = "select * from productdetail where product_id = ? and productdetail.product_detail_size like ?";
						pst = con.prepareStatement(sql);
						pst.setInt(1, product_id);
						pst.setString(2, "%"+s1+"%");
						rs = pst.executeQuery();System.out.println("tim 1 dieu kien size");
						while(rs.next()) {
							pd = new ProductDetail(rs.getInt("product_detail_id"),
									  rs.getString("product_detail_brand"),
									  rs.getString("product_detail_color"),
									  rs.getString("product_detail_size"),
									  rs.getString("product_detail_material"),
									  rs.getString("product_detail_origin"),
									  rs.getInt("product_id"),
									  rs.getInt("product_detail_amount"),
									  rs.getInt("categories_id"));
							arr3.add(pd);System.out.println("mang 3 : "+arr3);
						}
						}System.out.println("mang 1 co");
					}else if(arr1.size() == 0){
							for(String s2 : arr2) {						
							sql = "select * from productdetail where product_id = ? and productdetail.product_detail_color like ?";
							pst = con.prepareStatement(sql);
							pst.setInt(1, product_id);
							pst.setString(2, "%"+s2+"%");
							rs = pst.executeQuery();System.out.println("tim 1 dieu kien color");
							while(rs.next()) {
								pd = new ProductDetail(rs.getInt("product_detail_id"),
										  rs.getString("product_detail_brand"),
										  rs.getString("product_detail_color"),
										  rs.getString("product_detail_size"),
										  rs.getString("product_detail_material"),
										  rs.getString("product_detail_origin"),
										  rs.getInt("product_id"),
										  rs.getInt("product_detail_amount"),
										  rs.getInt("categories_id"));
								arr3.add(pd);System.out.println("mang 3 : "+arr3);
							}
							}System.out.println("mang 1 co");
						System.out.println("mang 2 co"+arr2);
					}else {
						for(String s3 : arr1) {
							for(String s33 : arr2) {
							sql = "select * from productdetail where product_id = ? and productdetail.product_detail_size like ? and productdetail.product_detail_color like ?";
							pst = con.prepareStatement(sql);
							pst.setInt(1, product_id);
							pst.setString(2, "%"+s3+"%");
							pst.setString(3, "%"+s33+"%");
							rs = pst.executeQuery();System.out.println("tim 2 dieu kien");
							while(rs.next()) {
								pd = new ProductDetail(rs.getInt("product_detail_id"),
										  rs.getString("product_detail_brand"),
										  rs.getString("product_detail_color"),
										  rs.getString("product_detail_size"),
										  rs.getString("product_detail_material"),
										  rs.getString("product_detail_origin"),
										  rs.getInt("product_id"),
										  rs.getInt("product_detail_amount"),
										  rs.getInt("categories_id"));
								arr3.add(pd);System.out.println("mang 3 : "+arr3);
								}
							}
						}
					}

		}catch (Exception e) {
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, pst, con);}
			return arr3;
	}
	
	public ProductDetail productDetailByIdProductDetail(int product_id){
		ProductDetail productDetail = null;
		con  = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from productdetail where product_detail_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			if(rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"), rs.getString("product_detail_brand"), rs.getString("product_detail_color"), rs.getString("product_detail_size"), rs.getString("product_detail_material"), rs.getString("product_detail_origin"), rs.getInt("product_id"), rs.getInt("product_detail_amount"), rs.getInt("categories_id"), rs.getDouble("product_detail_price"), rs.getString("product_detail_image"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return productDetail;
	}
	
	public ArrayList<Product> findNameAndIdProduct(){
		Product product = null;
		ArrayList<Product> listProduct = new ArrayList<Product>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from product");
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"),
													rs.getString("product_image"),
													rs.getString("product_description"),
													rs.getInt("categories_id"),
													rs.getInt("parent_id"));
				listProduct.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listProduct;
	}
	public int addProductDetail(String product_detail_brand, String product_detail_color,
			String product_detail_size, String product_detail_material, String product_detail_origin, int product_id,
			int product_detail_amount, int categories_id,Double product_detail_price,String product_detail_image){
		int result = 0;
		ProductDetail product = null;
		con  = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("INSERT INTO productdetail (product_detail_brand,product_detail_color,product_detail_size,product_detail_material,product_detail_origin,product_id,product_detail_amount,categories_id,product_detail_price,product_detail_image) VALUES (?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, product_detail_brand);
			pst.setString(2, product_detail_color);
			pst.setString(3, product_detail_size);
			pst.setString(4, product_detail_material);
			pst.setString(5, product_detail_origin);
			pst.setInt(6, product_id);
			pst.setInt(7, product_detail_amount);
			pst.setInt(8, categories_id);
			pst.setDouble(9, product_detail_price);
			pst.setString(10, product_detail_image);
			result = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public ProductDetail findProductDetailByProductId(int product_id){
		ProductDetail productDetail = null;
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from productdetail where product_detail_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"), rs.getString("product_detail_brand"), rs.getString("product_detail_color"), rs.getString("product_detail_size"), rs.getString("product_detail_material"), rs.getString("product_detail_origin"), rs.getInt("product_id"), rs.getInt("product_detail_amount"), rs.getInt("categories_id"), rs.getDouble("product_detail_price"), rs.getString("product_detail_image"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return productDetail;
	}
	public ArrayList<ProductDetail> findAllProductDetail(){
		ArrayList<ProductDetail> listProductDetail = new ArrayList<ProductDetail>();
		ProductDetail productDetail = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from productdetail");
			while(rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"), rs.getString("product_detail_brand"), rs.getString("product_detail_color"), rs.getString("product_detail_size"), rs.getString("product_detail_material"), rs.getString("product_detail_origin"), rs.getInt("product_id"), rs.getInt("product_detail_amount"), rs.getInt("categories_id"), rs.getDouble("product_detail_price"), rs.getString("product_detail_image"));
				listProductDetail.add(productDetail);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return listProductDetail;
	}
	public ProductDetail findProductDetailFavouriteByProductId(int product_id){
		ProductDetail productDetail = new ProductDetail();
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("select * from productdetail where product_detail_id = ?");
			pst.setInt(1, product_id);
			rs = pst.executeQuery();
			while(rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"), rs.getString("product_detail_brand"), rs.getString("product_detail_color"), rs.getString("product_detail_size"), rs.getString("product_detail_material"), rs.getString("product_detail_origin"), rs.getInt("product_id"), rs.getInt("product_detail_amount"), rs.getInt("categories_id"), rs.getDouble("product_detail_price"), rs.getString("product_detail_image"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
		return productDetail;
	}

	public int update(ProductDetail productDetail) {
		int result=0;
		con=DBConnectionUtil.getConnection();
		String sql="update productdetail set product_detail_id = ? , product_detail_brand = ? , product_detail_color = ? , product_detail_size = ? , product_detail_material = ? , product_detail_origin = ? , product_detail_amount = ? , product_detail_price = ? , product_detail_image = ? WHERE product_detail_id = ? ";
		try {
			pst=con.prepareStatement(sql);
			pst.setInt(1, productDetail.getProduct_detail_id());
			pst.setString(2, productDetail.getProduct_detail_brand());
			pst.setString(3, productDetail.getProduct_detail_color());
			pst.setString(4, productDetail.getProduct_detail_size());
			pst.setString(5, productDetail.getProduct_detail_material());
			pst.setString(6, productDetail.getProduct_detail_origin());
			pst.setInt(7, productDetail.getProduct_detail_amount());
			pst.setDouble(8, productDetail.getProduct_detail_price());
			pst.setString(9, productDetail.getProduct_detail_image());
			pst.setInt(10, productDetail.getProduct_detail_id());
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
		String sql = "delete from productdetail where product_detail_id = ?";
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {DBConnectionUtil.close(rs, pst, con);}
		return result;
	}
	public ArrayList<ProductDetail> listBrand(){
		ArrayList<ProductDetail> listBrand = new ArrayList<ProductDetail>();
		ProductDetail brand = null;
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select product_detail_brand from productdetail");
			while(rs.next()) {
				brand = new ProductDetail(rs.getString("product_detail_brand"));
				listBrand.add(brand);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listBrand;
	}
	public void amountDatabaseAfterAddCart(int product_detail_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("update productdetail set product_detail_amount = product_detail_amount - 1 where product_detail_id = ?");
			pst.setInt(1, product_detail_id);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
	}
	public void amountDatabaseAfterRemoveAddCart(int product_detail_id) {
		con = DBConnectionUtil.getConnection();
		try {
			pst = con.prepareStatement("update productdetail set product_detail_amount = product_detail_amount + 1 where product_detail_id = ?");
			pst.setInt(1, product_detail_id);
			pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, pst, con);}
	}
	public ArrayList<Product> listProduct(){
		Product product = null;
		ArrayList<Product> listProduct = new ArrayList<Product>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from product");
			while(rs.next()) {
				product = new Product(rs.getInt("product_id"),
													rs.getString("product_name"),
													rs.getString("product_image"),
													rs.getString("product_description"),
													rs.getInt("categories_id"),
													rs.getInt("parent_id"));
				listProduct.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listProduct;
	}
	public ArrayList<ProductDetail> findAllProductDetailMultiupload(){
		ProductDetail productDetail;
		ArrayList<ProductDetail> listProduct = new ArrayList<ProductDetail>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from productdetail");
			while(rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"),
									  rs.getString("product_detail_brand"));
				listProduct.add(productDetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {DBConnectionUtil.close(rs, st, con);}
		return listProduct;
	}

	public List<ProductDetail> findAll() {
		ProductDetail productDetail = null;
		ArrayList<ProductDetail> listProductDetail = new ArrayList<ProductDetail>();
		con = DBConnectionUtil.getConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from productdetail");
			while(rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"), 
																	rs.getString("product_detail_brand"), 
																	rs.getString("product_detail_color"), 
																	rs.getString("product_detail_size"), 
																	rs.getString("product_detail_material"), 
																	rs.getString("product_detail_origin"), 
																	rs.getInt("product_id"), 
																	rs.getInt("product_detail_amount"), 
																	rs.getInt("categories_id"),
																	rs.getDouble("product_detail_price"),
																	rs.getString("product_detail_image"));
				listProductDetail.add(productDetail);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listProductDetail;
	}
	public List<ProductDetail> getItemPagination(int offset) {
		con = DBConnectionUtil.getConnection();
		ProductDetail productDetail = null;
		String sql = "select * from productdetail order by product_detail_id desc limit ?,? ";
		List<ProductDetail> listItems = new ArrayList<ProductDetail>();
		try {
			pst = con.prepareStatement(sql);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while (rs.next()) {
				productDetail = new ProductDetail(rs.getInt("product_detail_id"), 
						rs.getString("product_detail_brand"), 
						rs.getString("product_detail_color"), 
						rs.getString("product_detail_size"), 
						rs.getString("product_detail_material"), 
						rs.getString("product_detail_origin"), 
						rs.getInt("product_id"), 
						rs.getInt("product_detail_amount"), 
						rs.getInt("categories_id"),
						rs.getDouble("product_detail_price"),
						rs.getString("product_detail_image"));
				listItems.add(productDetail);
			};
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBConnectionUtil.close(rs, pst, con);
		}
		return listItems;
	}
}
