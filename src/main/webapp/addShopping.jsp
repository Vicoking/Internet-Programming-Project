<%@ page session="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.model.Shopping"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart Add Result</title>
</head>
<body bgcolor="#33CCFF">
<% Shopping vcd = (Shopping)request.getAttribute("vcd"); %>
<center><b><%= vcd.getQuantity() %> item added to your shopping cart</b></center><br>
<%-- <% out.print(vcd.getQuantity() + "item added to your shopping cart." ); %> --%>
<center><a href="ShoppingServlet?action=VIEW">view</a>&nbsp;&nbsp;
<a href="/index.jsp">shopping</a>&nbsp;&nbsp;
<a href="ShoppingServlet?action=CHECKOUT">checkout</a>&nbsp;&nbsp;
<a href="ShoppingServlet?action=LOGOUT">logout/remove</a>
</body>
</html>