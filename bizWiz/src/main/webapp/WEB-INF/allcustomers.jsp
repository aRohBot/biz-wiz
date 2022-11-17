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
		<h1 class="subheader-title"> ALL CUSTOMERS</h1>
		<div class="table-wrapper-scroll-y my-custom-scrollbar">
			<table class="table table-hover mb-0">
    			<thead>
        			<tr>
				        <th scope="col">CUSTOMER NAME</th>
				        <th scope="col">CONTACT NAME</th>
				        <th scope="col">CONTACT NUMBER</th>
				        <th scope="col">EMAIL</th>
				        <th scope="col">ADDRESS</th>
				        <th scope="col">ACTION</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="customer" items="${allCustomersView}">
					<tr>
						<td><a href="/bizwiz/products/${customer.id}">${customer.customerName}</a></td>
						<td>${customer.contactName}</td>
						<td>${customer.phoneNumber}</td>
						<td>${customer.email}</td>
						<td>${customer.address} <br> ${customer.city} ${customer.state}, ${customer.zip}</td>
						<td>
							<c:if test = "${customer.user.id==loggedInUser.id}">
								<form:form action="/bizwiz/customers/${customer.id}/edit" method="get">
									<input type="hidden" name="_method" value="edit">
									<input type="submit" class='btn btn-delete' value="EDIT POST">
								</form:form>
								<form:form action="/bizwiz/customers/${customerid}/delete" method="post">
									<input type="hidden" name="_method" value="delete">
									<input type="submit" class='btn btn-delete' value="DELETE POST">
								</form:form>
							</c:if>
						</td>
					</tr>
					
					</c:forEach>
				</tbody>	
			</table>
			<form:form action="/bizwiz/customers/add" method="get">
				<input type="hidden" name="_method" value="add">
				<input type="submit" class='loginbtn' value="ADD CUSTOMER">
			</form:form>
		</div>
	</div>
</body>
</html>