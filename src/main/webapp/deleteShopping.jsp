<%@ page session="true" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*, com.model.Shopping"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Item Remove</title>
</head>
<body bgcolor="#33CCFF">

<center><B>VCD title = <% vcd.getTitle(); %> removed from your shopping cart</B></center><br>
<center><a href="ShoppingController?action=VIEW">view</a>&nbsp;&nbsp;
<a href="/index.jsp">shopping</a>&nbsp;&nbsp;
<a href="ShoppingController?action=CHECKOUT">checkout</a>&nbsp;&nbsp;
<a href="ShoppingController?action=LOGOUT">logout/remove</a>
</body>
</html>