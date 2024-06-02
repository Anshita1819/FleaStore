package flea.store.servlets;

import java.io.IOException;
//import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import flea.store.dao.LoginDao;
import flea.store.dao.LoginDaoImpl;
import flea.store.pojos.Login;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String u=request.getParameter("username");
	    String p=request.getParameter("password");
	    Login user=new Login(u,p);
		LoginDao loginDao = new LoginDaoImpl();
		if(loginDao.validUser(user))
		{
			response.sendRedirect("HomePage.html");
		}
		else {
			
			
			/*
			 * PrintWriter out=response.getWriter(); response.setContentType("text/html");
			 * out.println("<html>");
			 * out.println("<head><title>Re-enter Login details</title></head>");
			 * out.println("<body>"); out.println("<h2>");
			 * out.print("Entered email-id or password is incorrect"); out.println("</h2>");
			 * out.println("</body>"); out.println("</html>"); out.close();
			 */
			response.sendRedirect("Login.html");
			
		}
		
	} 
	

}
