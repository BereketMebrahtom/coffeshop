<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products List</title>
</head>
<body>	
		<h1>Add a new product</h1>
		
		<br> 
		
		
		<form:form action="/product/create" method="post" commandName="product">
		
		
		<p>Product Name: <form:input type="text" path="productName" name="productName" required="required"/></p>
		<p>Description: <form:textarea rows="20" cols="30" path="description" name="description"/></p>
		<p>Price $: <form:input type="text"  path="price" name="price" required="required"/></p>
		<p>Product Type: <form:input type="text" path="productType" name="productType" required="required" /></p>
		<p> <input type="submit" value="Create Product" ></p>
		
		</form:form>
 		<br>
 		<a href="<c:url value="/logout" />"> LogOut </a> 
		
		<br>
		
		
		<a href="<c:url value="/products/manage" />"> Back </a>
		
</body>
</html>