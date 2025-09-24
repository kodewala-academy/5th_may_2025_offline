<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Order Result</title>
</head>
<body>
	<h2>Order Placement Status</h2>

	<c:choose>
		<c:when test="${not empty message}">
			<p>${message}</p>
		</c:when>
		<c:otherwise>
			<p>Something went wrong. Please try again.</p>
		</c:otherwise>
	</c:choose>

	<c:if test="${not empty order}">
		<h3>Order Details:</h3>
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
				<td>${order.user.firstName}${order.user.lastName}</td>
			</tr>
		</table>
	</c:if>

	<br />
	<a href="placeOrder.jsp">Place Another Order</a>
</body>
</html>
