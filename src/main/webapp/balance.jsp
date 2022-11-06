<%@page import="com.bank.model.AccountDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="common/header.html"></c:import>
<title>Insert title here</title>
</head>
<body>
<c:import url="common/navbar.jsp"></c:import>

	<div class="container mt-5">
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
			
					<tr>
						<td> <c:out value="${personalAcc.accountno }"></c:out> </td>
						<td> <c:out value="${personalAcc.name }"></c:out> </td>
						<td> <c:out value="${personalAcc.amount }"></c:out> </td>
						<td> <c:out value="${personalAcc.address }"></c:out> </td>
						<td> <c:out value="${personalAcc.phno }"></c:out> </td>

					
					</tr>
				
				 
				
				
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
	
	</table>
	
	
<c:import url="common/footer.html"></c:import>
		
	
</body>
</html>