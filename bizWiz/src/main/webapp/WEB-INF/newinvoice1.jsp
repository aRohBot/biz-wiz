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

<!-- /* ALL CUSTOMER NAMES SHOULD APPEAR IN THE DROP DOWN MENU */
/* ONCE ADDED.. SHOULD BE ROUTED TO NEWINVOICE2.JSP */ -->
<body>
	<div class="container">
		<h1 class="subheader-title">Customer and Order Details</h1>
		<div class="customer-box">
			<form:form action="/bizwiz/invoices/add" method=post modelAttribute="newInvoiceViewOne" class="row g-3">
				<div class="col-md-4">
					<form:label path="customerName">CUSTOMER NAME </form:label>
					<form:select path="customerName"></form:select>
					
				</div>
				
			</form:form>
		
		</div>
	</div>
</body>
</html>