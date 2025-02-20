<%@page import="com.revature.pms.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>customer by id</title>
<link rel="stylesheet" href=https://cdn.jsdelivr.net/npm/@fortawesome/fontawesome-free@5.15.3/css/fontawesome.min.css>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
h2 {

	text-align: center;
	margin-top: 2cm;
}
p {
	text-align: center;
}
body{

background-color:orange;
}
table
{
	border: solid;
	
}
td,th
{
	border: solid;
	
	padding :25px;
}
th
{
	font: 18px;
	font-style: italic;
	font-weight: bold;
	color:green;	
}

</style>
</head>
<body style="background-color:orange;">

<nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <div class="navbar-header">
            <a class="navbar-brand" href="#"><b>Titli Bank</b></a>
          </div>
          <ul class="nav navbar-nav">
            <li class="active"><a href="EmployeeHome.html">Home</a></li>
            <li><a href="EmployeeHome.html">Employee</a></li>
            <li><a href="Home.html">About Us</a></li>
            <li><a href="EmployeeLogin.html">Log out</a></li>
          </ul>
        </div>
      </nav>
	<h2 align="center">The Customer Details Are</h2>
	<%
	List<Customer> customer = (List<Customer>) session.getAttribute("allCustomer");
	%>
	<table align="center" cellspecing="10" cellpadding="10">
		<th>CUSTOMER ID</th>
		<th>CUSTOMER NAME</th>
		<th>MOBILE NUMBER</th>
		<th>BALANCE</th>
		<th>EMAIL</th>
		<th>REGISTRATION DATE</th>

		<%
		for (int i = 0; i < customer.size(); i++) {
			Customer customer1 = customer.get(i);
		%>
		<tr>
			<td><%=customer1.getCustomerId()%></td>
			<td><%=customer1.getCustomerName()%></td>
			<td><%=customer1.getMobileNumber()%></td>
			<td><%=customer1.getBalance()%></td>
			<td><%=customer1.getEmailId()%></td>
			<td><%=customer1.getRegistrationDate()%></td>
		</tr>
		<%
		}
		%>
	</table>

</body>
</html>