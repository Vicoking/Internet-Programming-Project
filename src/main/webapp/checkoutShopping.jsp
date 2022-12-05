<%@ page session="true" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"
	import="java.util.*, com.model.Shopping"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Checkout</title>
</head>
<body bgcolor="#33CCFF">
	<center>
		<h1>VCD Shopping Checkout</h1>
	</center>
	<hr>
	<p>
		<%
	Vector buylist = (Vector) session.getAttribute("cart");
	String amount = (String) request.getAttribute("amount");
	if (buylist != null && (buylist.size() > 0))
			{
	%>
	
	<center>
		<table border="0" cellpadding="0" width="100%" bgcolor="#FFFFFF">
			<tr>
				<td><b>VCD TITLE</b></td>
				<td><b>ACTOR</b></td>
				<td><b>PRICE</b></td>
				<td><b>QUANTITY</b></td>
				<td></td>
			</tr>
			<%
			for (int index=0; index < buylist.size();index++)
				{
					Shopping anOrder = (Shopping) buylist.elementAt(index);
			%>
			<tr>
				<td><b><%= anOrder.getTitle() %></b></td>
				<td><b><%= anOrder.getActor() %></b></td>
				<td><b><%= anOrder.getPrice() %></b></td>
				<td><b><%= anOrder.getQuantity() %></b></td>
			</tr>

			<%
  			}
  			session.invalidate();
 			%>
			<tr>
				<td></td>
				<td></td>
				<td><b>TOTAL</b></td>
				<td><b><%= amount %></b></td>
				<td></td>
			</tr>
		</table>
		<p>
 <a href="index.jsp">Shop some more!</a>
 <%}%>
</body>
</html>