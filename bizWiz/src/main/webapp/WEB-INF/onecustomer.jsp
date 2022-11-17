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
		<center><h1 class="subheader-title">CUSTOMER: ${oneCustomerView.customerName}</h1></center>
		<div class="customer-box">
	  		<div class="row g-3">
	  			<div class="col-md-6">${oneCustomerView.customerName}</div>
	  			<div class="col-md-6">${oneCustomerView.contactName}</div>
	  			<div class="col-md-6">${oneCustomerView.phoneNumber}</div>
	  			<div class="col-md-6">${oneCustomerView.email}</div>
	  			<div class="col-md-12">${oneCustomerView.address}</div>
	  			<div class="col-md-6">${oneCustomerView.city}</div>
	  			<div class="col-md-4">${oneCustomerView.state}</div>
	  			<div class="col-md-2">${oneCustomerView.zip}</div>
	  		</div>
	  	</div>
	  </div>

</body>
</html>