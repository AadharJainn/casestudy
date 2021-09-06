<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dan Pizza's</title>
</head>
<body>
	<form method="post" action="getdetails">
	<div align="center">
			<tbody>
				<table border="1" width="20%" cellpadding="7">
					<h3>Order with in Price Range Report</h3>
					<br>
					<tbody>
						<tr>
							<td>From Price:</td>
							<td><input type="text" name="fromPrice" value="" /></td>
							<td>To Price:</td>
							<td><input type="text" name="toPrice" value="" /></td>
						</tr>
						<tr>
					</tbody>
				</table>
				<br>
				<input type="submit" value="Fetch Details" />
				<br>
				<br>
				<table border="1">
					<thead>
						<tr>
							<td>Order Id</td>
							<td>Customer Name</td>
							<td>Pizza Id</td>
							<td>Bill</td>
							<td>Quantity</td>
						</tr>
					</thead>
					<c:forEach var="billDetails" items="${billDetails}">
						<tr>
							<td>${billDetails.orderId}</td>
							<td>${billDetails.customerName}</td>
							<td>${billDetails.pizzaId}</td>
							<td>${billDetails.bill}</td>
							<td>${billDetails.numberOfPiecesOrdered}</td>
						</tr>
					</c:forEach>
				</table>
				<a ref="index.jsp">Home</a>
		</div>
	</form>
</body>
</html>