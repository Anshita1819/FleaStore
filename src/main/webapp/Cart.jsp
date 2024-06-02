<%@page import="flea.store.pojos.Cart"%>
<%@page import="java.util.*"%>
<%@page import="flea.store.dao.BookDao"%>
<%@page import="flea.store.dao.BookDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	BookDao bookDao=new BookDaoImpl();
	cartProduct=bookDao.addToCart(cart_list);
	request.setAttribute("cart_list", cart_list);
}
%>	
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/Cart.css">

<meta charset="ISO-8859-1">
<title>Cart Page</title>
<style type="text/css">
.table tbody td{
vertical-align: middle;
}
.btn-incre, .btn-decre{
box-shadow: none;
font-size: 25px;
}
</style>
</head>
<body>
    <div class="header">
    <div class="header-logo">
              <img src="images/FinalLogo8.jpeg">
              </div>
            <div class="header-content">
              <ul>
              <li><a href="HomePage.html">Home</a></li>
              <li><a href="#">Saved</a></li>
              <li><a href="Cart.jsp">Cart</a></li>
              <li><a href="#">My Account</a></li>
              <li><a href="Login.html">Logout</a></li>
              </ul>
            </div>
      </div>
      <br>
      <div class="mycart">
      <h2><i>My Cart</i></h2><br><br>
      </div>
      
	<div class="carttable">
		
		<table border="1" cellspacing="1" cellpadding="5" bordercolor="#9C640C" bgcolor="#CB9489" width="800" height="150">
        <tr>
          <th>Product Name</th>
          <th>Category</th>
          <th>Price</th>
          <th>Buy Now</th>
          <th>Cancel</th>
        </tr>
			<tbody>
				<% 
				if (cart_list != null) {
					for (Cart c : cartProduct) {
				%>
				<tr>
					<td><%=c.getName()%></td>
					<td><%=c.getCategory()%></td>
					<td><%=c.getPrice()%></td>
					<td>
						<form action="order-now" method="post" class="form-inline">
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="quantity-inc-dec?action=inc&id=<%=c.getId()%>"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value="<%=c.getQuantity()%>" readonly> 
								<a class="btn btn-sm btn-decre" href="quantity-inc-dec?action=dec&id=<%=c.getId()%>"><i class="fas fa-minus-square"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
					<td><a href="remove-from-cart?id=<%=c.getId() %>" class="btn btn-sm btn-danger">Remove</a></td>
				</tr>

				<%}
					}%>
			</tbody>
		</table>
	</div>
	<section class="footer">
          <ul class="list">
            <li>
               <a href="#">About Us</a>
            </li>
            <li>
               <a href="#">Contact</a>
            </li>
            <li>
               <a href="#">FAQs</a>
            </li>

      </section>

</body>
</html>