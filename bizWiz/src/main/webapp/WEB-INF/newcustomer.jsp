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
		<center><h1 class="subheader-title">NEW CUSTOMER</h1></center>
		<div class="customer-box">
	  		<form:form action="/bizwiz/customers/add" method="post" modelAttribute="newCustomerView" class="row g-3">
	  			<div class="col-md-6">
	    			<form:label path="customerName"> CUSTOMER NAME </form:label>
					<form:errors class="text-danger" path="customerName"/>
					<form:input type="text" class="form-control" path="customerName"/>
	  			</div>
	  			<div class="col-md-6">
	    			<form:label path="contactName"> CONTACT NAME </form:label>
					<form:errors class="text-danger" path="contactName"/>
					<form:input type="text" class="form-control" path="contactName"/>
	  			</div>
	  			<div class="col-md-6">
	    			<form:label path="phoneNumber"> CONTACT NUMBER </form:label>
					<form:errors class="text-danger" path="phoneNumber"/>
					<form:input type="text" class="form-control" path="phoneNumber" placeholder="999-999-9999"/>
	  			</div>
	  			<div class="col-md-6">
	    			<form:label path="email"> EMAIL </form:label>
					<form:errors class="text-danger" path="email"/>
					<form:input type="text" class="form-control" path="email"/>
	  			</div>
	  			<div class="col-12">
				    <form:label path="address"> ADDRESS </form:label>
					<form:errors class="text-danger" path="address"/>
					<form:input type="text" class="form-control" path="address" placeholder="1234 Main St"/>
	  			</div>
	  			<div class="col-md-6">
				    <form:label path="city"> CITY </form:label>
					<form:errors class="text-danger" path="city"/>
					<form:input type="text" class="form-control" path="city"/>
	  			</div>
	  			<div class="col-md-4">
				    <form:label path="state"> STATE </form:label>
					<form:errors class="text-danger" path="state"/>
					<form:input type="text" class="form-control" path="state" placeholder="XX"/>
	  			</div>
	  			<div class="col-md-2">
				    <form:label path="zip"> ZIP CODE </form:label>
					<form:errors class="text-danger" path="zip"/>
					<form:input type="text" class="form-control" path="zip" placeholder="00000"/>
	  			</div>
	  			<div class="col-12">
	    			<button type="submit" class="loginbtn">ADD CUSTOMER</button>
	  			</div>
		  		<form:input type="hidden" value ="${loggedInUser.id}" path="user"/>
				<input type="submit" class="loginbtn" value="ADD"/>
			</form:form>
				
 		</div>
  	</div>
  			
</body>				

</html>