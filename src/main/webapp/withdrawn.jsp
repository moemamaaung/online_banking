<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="common/header.html"></c:import>
<title>Insert title here</title>

</head>
<body>
	<c:import url="common/navbar.jsp"></c:import>
	
	<div class="container">
    <form action="account" method="post">
        <h2 class="text-center">Deposit Form</h2>
        
        <input type="hidden" name="mode" value="WITHDRAWN">
        <input type="hidden" name="id" value="${account.id}">
        <h3> <c:out value="ID : ${account.id}"></c:out> </h3>
        
      <div class="mb-3">
            <label for="accountno" class="form-label">Account No</label>
            <input type="text" id="accountno" name="accountno" value="${account.accountno }"  readonly="readonly" placeholder="Enter Account Number" class="form-control" required="required" autofocus>
        </div> 
        
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="text" id="name" name="name" value="${account.name }" readonly="readonly" placeholder="Enter Name" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="amount" class="form-label">Amount</label>
            <input type="text" id="amount" name="amount" min="1000.0" value="${account.amount }" placeholder="Enter Amount" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="address" class="form-label">Address</label>
            <input type="text" id="address" name="address" value="${account.address }" readonly="readonly" placeholder="Enter Major" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="phno" class="form-label">Phone No</label>
            <input type="text" id="phno" name="phno" value="${account.phno }"  readonly="readonly" placeholder="Enter Major" class="form-control" required="required" autofocus>
        </div>
        
      
        
        <input type="submit" class="btn btn-primary" value="Submit">
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
</div> <!-- ./container -->
	
	<c:import url="common/footer.html"></c:import>

</body>
</html>