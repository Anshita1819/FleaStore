package flea.store.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import flea.store.pojos.Cart;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
	try(PrintWriter out= response.getWriter()){		
		ArrayList<Cart> cartList=new ArrayList<Cart>() ;
	String s=request.getParameter("id");
    int id=Integer.parseInt(s);
    Cart cart=new Cart();
    cart.setId(id);
    cart.setQuantity(1);
    
    HttpSession session=request.getSession();
    
    @SuppressWarnings("unchecked")
	ArrayList<Cart> cart_list=(ArrayList<Cart>) session.getAttribute("cart-list");
    if(cart_list==null)
    {
    	cartList.add(cart);
    	session.setAttribute("cart-list", cartList);
    	out.print("added");
    	response.sendRedirect("Buy.jsp");
    }
    else {
    	cartList=cart_list;
    	boolean exits=false;
    	for(Cart c:cartList) {
    		if(c.getId()==id) {
    			exits=true;
    			out.println("<h2 style='color:red text-align:center'>Item Already Exits</h2>");
    		}
    	}
    	if(!exits) {
    		cartList.add(cart);
    		response.sendRedirect("Buy.jsp");
    	}
    }
   
    
    
		
		
	}

}
}