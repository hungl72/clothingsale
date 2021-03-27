package controllers.admins.categories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import constants.GlobalConstant;
import daos.PictureDAO;
import daos.ProductDAO;
import models.ProductDetail;
import utils.FileUtil;
@MultipartConfig
public class Multiupload extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Multiupload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAO productDAO = new ProductDAO();
		ArrayList<ProductDetail> listProductDetail = new ArrayList<ProductDetail>();
		listProductDetail = productDAO.findAllProductDetailMultiupload();
		request.setAttribute("listProductDetail",listProductDetail);
		request.getRequestDispatcher("/views/admin/product/addmulti.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		int idproduct = Integer.parseInt(request.getParameter("idproduct"));System.out.print("idproduct "+idproduct);
		PictureDAO pictureDao = new PictureDAO();
		String fileName = "";
		List<String> listPicture = new ArrayList<String>();
		List<Part> fileParts = request.getParts().stream().filter(part -> "picture".equals(part.getName()))
				.collect(Collectors.toList());
		if (fileParts != null && fileParts.size() > 0 && (fileParts.size() <= 5 || fileParts.size() < 1)) {
			for (Part filePart : fileParts) {
				fileName = FileUtil.rename(Paths.get(filePart.getSubmittedFileName()).getFileName().toString());
				System.out.print("fileName "+fileName);
				// InputStream fileContent = filePart.getInputStream();
				// System.out.println("fileContent: "+fileContent);
				if (!"".equals(fileName)) {
					// lấy đường dẫn thực của dự án
					String dirPath = request.getServletContext().getRealPath("") + GlobalConstant.DIR_UPLOAD;
					File saveDir = new File(dirPath);
					if (!saveDir.exists()) {
						saveDir.mkdirs();
					}
					String filePath = dirPath + File.separator + fileName;
					filePart.write(filePath);System.out.println(filePath);
				}
				pictureDao.add(fileName,idproduct);
			}
	}
	}
}
