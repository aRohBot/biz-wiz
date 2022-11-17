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


<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<!-- /* HERE IN THE TOP BOX SHOULD AUTO POPULATE CUSTOMER INFORMATION AND ORDER DETAILS  */ -->
<body>
	<div class="container">
		<h1 class="subheader-title">Customer Details</h1>
		<div class="customer-box">
			<div class="row g-3">
				<div class="col-md-6">
				Invoice Number: <!-- ${} this should now be populated since the invoice has been created -->
				</div>
				<div class="col-md-6">
				Invoice Date: <!-- ${invoice.createdAt} -->
				</div>
				<div class="col-md-6">
				Customer Name: <%-- ${ } --%>
				</div>	
				<div class="col-md-6">
				Contact Number:  <%-- ${ } --%>
				</div>		
				<div class="col-md-12">
				Address:  <%-- ${ } --%>
				</div>	
			</div>
		</div>
<!-- HERE THE PRODUCTS FROM YOUR LIST SHOULD AUTO POPULATE INTO THE SELECT MENU
AND QUANTITY SHOULD BE ABLE TO BE ENTERED
ONCE YOU CLICK THE BUTTON IT SHOULD ADD THE ITEMS TO THE BOTTOM TABLE-->
		<h1 class="subheader-title">Add Items to Invoice</h1>
		<div class="customer-box">
			<div class="row g-3">
				<div class="col-md-6">
				Select Product:  <%-- ${ } --%>
				</div>
				<div class="col-md-6">
				Enter Quantity:  <%-- ${ } --%>
				</div>	
				 <%-- button that will add the item to the table below --%>
			</div>
		</div>
		<h1 class="subheader-title">Invoice Details</h1>
		<div class="customer-box">
			<table>
				<thead>
					<tr>
						<th scope="col">SKU</th>
						<th scope="col">DESCRIPTION</th>
				        <th scope="col">UNIT PRICE</th>
				        <th scope="col">QTY</th>
				        <th scope="col">TOTAL COST</th><%--UNIT PRICE x QUANTITY --%>
				        <th scope="col">ACTION</th><%--remove the item from the cart --%>
					</tr>
				</thead>
				<tbody>
					<tr>
					
					
					</tr>
				</tbody>
				
			
			</table>
		
		</div>
	</div>

</body>
</html>