<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>Registration Successful</title>
</head>
<body>
	<h2>Registration Successful!</h2>
	<p>Your Zepto user registration has been completed.</p>

	<p>
		<strong>Your User ID:</strong> ${user.userId}
	</p>

	<form action="${pageContext.request.contextPath}/orders/place"
		method="post">
		<input type="hidden" name="userId" value="${user.userId}" /> <label>Product
			Name:</label> <input type="text" name="productName" required /><br />
		<br /> <label>Amount:</label> <input type="number" step="0.01"
			name="amount" required /><br />
		<br />

		<button type="submit">Place Your First Order</button>
	</form>

</body>
</html>
