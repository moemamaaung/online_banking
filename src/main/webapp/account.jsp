<%@page import="com.bank.model.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="common/header.html"></c:import>
</head>
<body>
<c:import url="common/navbar.jsp"></c:import>
<div>
	<div class="container p-5">
		<table id="account" class="table table-striped">
			<thead>
				<tr>
					<th>ACCOOUNT NO</th>
					<th>USERNAME</th>
					<th>AMOUNT</th>
					<th>ADDRESS</th>
					<th>PHONE</th>
					
				
				</tr>
			</thead>
			<tbody>
				<c:forEach var="account" items="${accountList }">
					<tr>
					
					<td> <c:out value="${account.accountno }"></c:out> </td>
						<td> <c:out value="${account.name }"></c:out> </td>
						<td> <c:out value="${account.amount }"></c:out> </td>
						<td> <c:out value="${account.address }"></c:out> </td>
						<td> <c:out value="${account.phno }"></c:out> </td>
			
					</tr>
					</c:forEach>
			</tbody>
			<tfoot>
				<tr>
					<th>ACCOOUNT NO</th>
					<th>USERNAME</th>
					<th>AMOUNT</th>
					<th>ADDRESS</th>
					<th>PHONE</th>
					
				</tr>
			</tfoot>
		</table>
	</div>
	
	</div>	
	
	<c:import url="common/footer.html"></c:import>
	
</body>
</html>