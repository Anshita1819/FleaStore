package flea.store.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



@WebServlet("/sell")
@MultipartConfig(maxFileSize = 1024 * 1024 * 20)
public class SellServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//`book_name`, `author_name`, `book_edition_year`, `category`, `price`, `book_language`, `description`, `book_photo`
		String bN=request.getParameter("book-name");
		String aN=request.getParameter("author-name");
		String bEY=request.getParameter("edition-year");
		String ct=request.getParameter("category");
		String p=request.getParameter("price");
		String l=request.getParameter("language");
		String r=request.getParameter("rating");
		Part img=request.getPart("image");
		String des=request.getParameter("description");
		InputStream iS =img.getInputStream();
        
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minor_project", "root",
					"Indore@123");
			PreparedStatement pStmt=con.prepareStatement("INSERT INTO sell_book(book_name,author_name,book_edition_year,category,price,book_language,description,book_photo,rating)VALUES(?,?,?,?,?,?,?,?,?)");
			pStmt.setString(1,bN);
			pStmt.setString(2,aN);
			pStmt.setString(3,bEY);
			pStmt.setString(4,ct);
			pStmt.setString(5,p);
			pStmt.setString(6,l);
			pStmt.setString(7,des);
			pStmt.setBlob(8, iS);
			pStmt.setString(9,r);
			pStmt.executeUpdate();
			pStmt.close();
			con.close();
			
			
	}catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}

}
}
	
