<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Order Details</title>
</head>
<body>
	<h2>Order Details</h2>

	<c:choose>
		<c:when test="${not empty order}">
			<table border="1" cellpadding="5">
				<tr>
					<th>Order ID</th>
					<td>${order.id}</td>
				</tr>
				<tr>
					<th>Product Name</th>
					<td>${order.productName}</td>
				</tr>
				<tr>
					<th>Amount</th>
					<td>${order.amount}</td>
				</tr>
				<tr>
					<th>User</th>
					<td>${user.firstName}${user.lastName}</td>
				</tr>
				<tr>
					<th>User Status</th>
					<td>${user.status}</td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<p>No order found for this user.</p>
		</c:otherwise>
	</c:choose>

	<br />
	<a href="placeOrder.jsp">Place New Order</a>
</body>
</html>
