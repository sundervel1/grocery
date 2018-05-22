<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Grocery Shop</title>
<style>
 td{text-align:center;}
 table{border-collapse:collapse;}
</style>
</head>
<body style="background-color: pink">

<c:choose>
<c:when test="${glist.size()>0 }">
  
<h2><center>Online Grocery Shop</center></h2>
<h3><center>Available Items</center></h3>
<table border="2" align="center" bgcolor="cyan">
<tr>
		<td><b>Grocery Id</b></td>
		<td><b>Name</b></td>
		<td><b>Price(Rs)</b></td>
		<td><b>Quantity</b></td>
		<td><b>Unit</b></td>
		<td><b>Category</b></td>
		<td><b>Description</b></td>
	</tr>
<c:forEach var="glist" items="${glist}">
<tr>
	<tr>
	<td>${glist.id}</td> 
	<td>${glist.name}</td>
	<td>${glist.price}</td>
	<td>${glist.quantity}</td>
	<td>${glist.unit}</td>
	<td>${glist.category}</td>
	<td>${glist.description}</td>
</tr>
</c:forEach>
</table>
<br>
</c:when>
<c:otherwise>
  <h3><center>No Data Found</center></h3>
</c:otherwise>
</c:choose>
<center><a href ="goHome.obj">Go Home</a></center><br><br>
</body>
</html>