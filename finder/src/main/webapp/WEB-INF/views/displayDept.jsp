<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Department Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 40px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 50%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px 20px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #007BFF;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Department Details</h1>

    <table>
        <tr>
            <th>ID</th>
            <th>Department Name</th>
        </tr>
        <tr>
            <td>${deptInfo.id}</td>
            <td>${deptInfo.name}</td>
        </tr>
    </table>
</body>
</html>
