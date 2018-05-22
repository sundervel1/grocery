<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OnlineGroceryShop</title>

</head>

<body style="background-color: pink">
   <center><h2> Online Grocery Shop</h2>
   <h3>Add An Item</h3>
   <form:form action="submitGrocery.obj" method="post"
      modelAttribute="grocery">
      <table border="1" >
         <tr>
            <td>Item Name</td>
            <td><form:input path="name" /> 
            <form:errors path="name" /></td>
         </tr>
         <tr>
            <td>Price(Rs)</td>
            <td><form:input path="price"/> 
               <form:errors path="price" /> </td>
         </tr>
         <tr>
            <td>Category</td>
            <td><form:select path="category">
                  <form:option value="Select"></form:option>
                  <form:options items="${clist }"/>
               </form:select><form:errors path="category" /></td>

         </tr>
         <tr>
            <td>Quantity</td>
            <td><form:input path="quantity"/> 
               <form:errors path="quantity" /> </td>
         </tr>
         <tr>
            <td>Unit</td>
            <td><form:input path="unit"/> 
            </td>
         </tr>
         <tr>
            <td>Description</td>
            <td><form:input path="description"/> 
              </td>
         </tr>
         <tr>
            <td><input type="submit" value="Add Grocery Item" />
                 <input type="reset" value="Cancel"></td>
            <td><a href ="goHome.obj">Go Home</a><br><br></td>
         </tr></table>
         </form:form>
         </center>
</body>
</html>