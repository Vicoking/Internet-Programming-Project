<%@ page session="true" language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*, com.model.Shopping"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart Example - View Cart</title>
</head>
<body bgcolor="#33CCFF">
	<%
	Vector buylist = (Vector) session.getAttribute("cart");
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
				<td>
					<form name="deleteForm" action="ShoppingController" method="POST">
						<input type="submit" value="Delete">
						<input type="hidden" name="delindex" value=<%= index %>>
						<input type="hidden" name="action" value="DELETE">
					</form>
				</td>
			</tr>

			<%}%>

		</table>
		<center>
			<a href="index.jsp">shopping</a>&nbsp;&nbsp;
			<a href="ShoppingController?action=CHECKOUT">checkout</a> &nbsp;&nbsp;
			<a href="ShoppingController?action=LOGOUT">logout/remove</a>
		</center>
		<%}%>
</body>
</body>
</html>