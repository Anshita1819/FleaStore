<%@page import="flea.store.pojos.SellBook"%>
<%@page import="java.util.List"%>
<%@page import="flea.store.dao.BookDaoImpl"%>
<%@page import="flea.store.dao.BookDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <link rel="stylesheet" type="text/css" href="css/Buy.css">
    <title>Buy page</title>
  </head>
  <body>
    <div class="main">
      <div class="header">
      <div class="header-logo">
              <img src="images/FinalLogo8.jpeg">
              </div>
            <div class="header-content">
        
              <ul>
              <li><a href="HomePage.html">Home</a></li>
              <li><a href="Save.jsp">Saved</a></li>
              <li><a href="Cart.jsp">Cart</a></li>
              <li><a href="Account.jsp">My Account</a></li>
              <li><a href="Login.html">Logout</a></li>
              </ul>
            </div>
      </div>
      <br>
      <div class="content">
        <%
          BookDao bookDao=new BookDaoImpl();
          List<SellBook> books=bookDao.buyBook();
        
        %>
        <%
        
        for(SellBook s:books){%>
		
		
		<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<table border="1" cellspacing="1" cellpadding="15" bordercolor="#9C640C" bgcolor="#CB9489" width="300" height="150">
		<tr>
		<th>BOOK NAME</th>
		<th>AUTHOR NAME</th>
		<th>EDITION YEAR</th>
		<th>LANGUAGE</th>
		<th>CATEGORY</th>
		<th>DESCRIPTION</th>
		<th>PRICE</th>
		
		</tr>
		<tr>
		<td><%=s.getBookName()%></td>
		<td><%=s.getAuthorName()%></td>
		<td><%=s.getBookEditionYear()%></td>
		<td><%=s.getBookLanguage()%></td>
		<td><%=s.getCategory()%></td>
		<td><%=s.getDescription()%></td>
		<td><%=s.getPrice()%></td>
		<td colspan="2"><a href="Save.jsp?id=<%=s.getId()%>">SAVE</a><br><br><a href="cart?id=<%=s.getId()%>">ADD TO CART</a></td>
		
		</tr>
		</table>
		<% }%>
	     
        
        
        
        <br><br><br><br><br><br>
      </div>
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
            </ul>>

      </section>
  </body>
</html>