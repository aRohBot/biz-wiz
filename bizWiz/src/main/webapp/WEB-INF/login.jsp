<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%> 


<jsp:include page="includes/header2.jsp"/>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/css/main.css">
<meta charset="UTF-8">
<title>BizWiz</title>
</head>

<body>
	<div class="container px-4">

		<div class="row gx-5 gy-5">
			<div class="col border border-rounded p-5 gy-5">
				<form:form action="/bizwiz/register" method="POST" modelAttribute="newUserView">
				<div class="mb-3 p-3">
    					<form:label path="firstName">FIRST NAME:</form:label>
    					<form:errors class="text-danger" path="firstName"/>
    					<form:input class="form-control" path="firstName"/>  							
    			</div>				
    			<div class="mb-3 p-3">
    					<form:label path="lastName">LAST NAME:</form:label>
    					<form:errors class="text-danger" path="lastName"/>
    					<form:input class="form-control" path="lastName"/>  							
    			</div>
				<div class="mb-3 p-3">
    					<form:label path="business">BUSINESS NAME:</form:label>
    					<form:errors class="text-danger" path="business"/>
    					<form:input class="form-control" path="business"/>  							
    			</div>
				<div class="mb-3 p-3">
    					<form:label path="email">EMAIL:</form:label>
    					<form:errors class="text-danger" path="email"/>
    					<form:input class="form-control" path="email"/>  	
 				</div>
 				<div class="mb-3 p-3">
    					<form:label path="password">PASSWORD:</form:label>
    					<form:errors class="text-danger" path="password"/>
    					<form:password class="form-control" path="password"/>  	
 				</div>
 				<div class="mb-3 p-3">
    					<form:label path="confirm">CONFIRM PASSWORD:</form:label>
    					<form:errors class="text-danger" path="confirm"/>
    					<form:password class="form-control" path="confirm"/>  	
 				</div>
	  			<button type="submit" class="loginbtn">REGISTER</button>
				</form:form>
  			</div>	
 
  				<!-- LOGIN FORM -->
  			<div class="col border border-rounded p-5 gy-5">
				<form:form action="/bizwiz/login" modelAttribute="newLoginView">
				<div class="mb-3 p-3">
    					<form:label path="email">EMAIL:</form:label>
    					<form:errors class="text-danger" path="email"/>
    					<form:input class="form-control" path="email"/>  							
    			</div>
				<div class="mb-3 p-3">
    					<form:label path="password">PASSWORD:</form:label>
    					<form:errors class="text-danger" path="password"/>
    					<form:password class="form-control" path="password"/>  	
 				</div>
	  			<button type="submit" class="loginbtn">LOGIN</button>
				</form:form>
  			</div>				
  		</div>			
  	</div>
</body>
</html>
