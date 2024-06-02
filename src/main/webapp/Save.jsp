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
              <li><a href="#">Logout</a></li>
              </ul>
            </div>
      </div>
      <div class="content">
        <%
        String bId=request.getParameter("id");
        int id=Integer.parseInt(bId);
        BookDao bookDao=new BookDaoImpl();
        SellBook s=bookDao.saveBook(id);
        %>
        <table>
		<tr>
		<td>BOOK NAME<%=s.getBookName()%></td>
		<td>AUTHOR NAME<%=s.getAuthorName()%></td>
		<td>EDITION YEAR<%=s.getBookEditionYear()%></td>
		<td>LANGUAGE<%=s.getBookLanguage()%></td>
		<td>CATEGORY<%=s.getCategory()%></td>
		<td>DESCRIPTION<%=s.getDescription()%></td>
		<td>PRICE<%=s.getPrice()%></td>
		
     
		</tr>
		</table>
	
        
        
        
        
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <br><br><br><br><br><br><br><br><br><br><br><br>
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