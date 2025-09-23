<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Zepto User Registration</title>
</head>
<body>

<form action="/SpringWebMVCModelAttribute/registerORM" method="post">

       First Name : <input type="text" name="firstName" required><br><br>
Last Name : <input type="text" name="lastName" required><br><br>
        <input type="submit" value="Register">
</form>


</body>
</html>