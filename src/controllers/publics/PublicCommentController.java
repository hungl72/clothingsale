package controllers.publics;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.CommentDAO;
import models.Comment;
import utils.DBConnectionUtil;

public class PublicCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public PublicCommentController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");response.setContentType("text/html");response.setCharacterEncoding("UTF-8");
		ArrayList<Comment> arrComment = new ArrayList<Comment>();
		PrintWriter print = response.getWriter();
		int categories_id = Integer.parseInt(request.getParameter("categories_id"));
		String name = request.getParameter("name");
		String commentarea = request.getParameter("comment");
		SimpleDateFormat s = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
		Date d = new Date();
		String date = String.valueOf(s.format(d.getTime()));
		new CommentDAO().insertComment(name, commentarea, date, categories_id);
		arrComment = new CommentDAO().findAll(categories_id);
		for(Comment comment : arrComment) {
		print.write(comment.getDetail()+" - Bình luận bởi : "+comment.getUser()+" - Vào lúc "+comment.getTime()+"<br />");
		}
	}

}
