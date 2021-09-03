<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dan Pizza's</title>
</head>
<body>
	<form method="post" action="save">
		<center>
			<tbody>
				<table border="5" width="30%" cellpadding="7">
					Add Pizza Details
					<br>
					<tbody>
						<tr>
							<td>Customer Name</td>
							<td><input type="text" name="customerName" value="" /></td>
						</tr>
						<tr>
							<td>Customer Contact</td>
							<td><input type="text" name="contactNumber" value="" /></td>
						</tr>
						<tr>
							<td>Pizza Name</td>
							<td><label for="pizza"></label> <select name="pizza_name"
								id="pizzaName">
									<option >--Select--</option>
									<option value="XYZVegS">XYZVegS</option>
									<option value="XYZVegM">XYZVegM</option>
									<option value="XYZVegL">XYZVegL</option>
									<option value="XYZNonVegS">XYZNonVegS</option>
							</select></td>
						</tr>
						<tr>
							<td>Quantity</td>
							<td><input type="text" name="numberOfPiecesOrdered" value="" /></td>
						</tr>
						<tr>
					</tbody>
				</table>
				<br>
				<input type="submit" value="Order" />
				<br>
				<br>

				<a ref="index.jsp">Home</a>
			</tbody>
			<center><h3>All Errors</h3></center>
			<div class="alert alert-danger" role="alert">
	<form:errors path="pizzaOrderBean.*"/>
	</div>
	</center>
	</form>
</body>
</html>