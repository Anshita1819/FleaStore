package flea.store.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
     
		String firstName = request.getParameter("First-name");
		String lastName = request.getParameter("Last-name");
		String emailId = request.getParameter("Email-id");
		String mobileNo = request.getParameter("Mobile-number");
		String state = request.getParameter("State");
		String pinCode = request.getParameter("Pin-code");
		String password = request.getParameter("Password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/minor_project", "root",
					"Indore@123");
			PreparedStatement pStmt=con.prepareStatement("INSERT INTO registration_page(first_name,last_name,email_id,mobile_no,state,pincode,password)VALUES(?,?,?,?,?,?,?)");
            pStmt.setString(1,firstName);
            pStmt.setString(2, lastName);
            pStmt.setString(3,emailId);
            pStmt.setString(4, mobileNo);
            pStmt.setString(5,state);
            pStmt.setString(6, pinCode);
            pStmt.setString(7, password);
            
            if(pStmt.executeUpdate()>0) {
            	response.sendRedirect("Login.html");
            }
            	
            
            
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
