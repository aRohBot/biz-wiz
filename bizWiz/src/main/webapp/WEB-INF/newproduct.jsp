<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 


<jsp:include page="includes/header.jsp"/>
<jsp:include page="includes/navi.jsp"/>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/main.css">
<meta charset="UTF-8">
<title>BizWiz</title>
</head>

<body>
	<div class="container">
			<center><h1 class="subheader-title">NEW PRODUCT</h1></center>
		<div class="customer-box">
	  		<form:form action="/bizwiz/products/add" method="post" modelAttribute="newProductView" class="row g-3">
	  			<div class="col-md-4">
				    <form:label path="skuNumber"> SKU NUMBER </form:label>
				    <form:errors class="text-danger" path="skuNumber"/>
					<form:input type="text" class="form-control" path="skuNumber"/>	
	  			</div>
	  			<div class="col-md-6">
				    <form:label path="description"> DESCRIPTION </form:label>
				    <form:errors class="text-danger" path="description"/>
				    <form:input type="text" class="form-control" path="description" placeholder="XX"/>
	  			</div>
	  			<div class="col-md-2">
				    <form:label path="price"> UNIT PRICE </form:label>
				    <form:errors class="text-danger" path="price"/>
				    <form:input type="number" class="form-control" path="price" placeholder="00.00"/>
	  			</div>
				<form:input type="hidden" value ="${loggedInUser.id}" path="user"/>
				<div class="col-12">
	  			<input type="submit" class="loginbtn" value="ADD"/></div>
			</form:form>
 		</div>
  	</div>
  			
				

</html>