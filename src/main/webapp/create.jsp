<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <c:import url="common/header.html"></c:import>
<title>Account Registeration</title>
</head>
<body>
<c:import url="common/navbar.jsp"></c:import>
	
	<div class="container p-3">
    <form action="account" method="post">
        <h2 class="text-center">Account Registration</h2>
        
        <input type="hidden" name="mode" value="CREATE">
        
        <div class="mb-3">
            <label for="accountno" class="form-label">*AccountNo</label>
            <input type="text" id="accountno" name="accountno" placeholder="Enter Account No" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="name" class="form-label">*UserName</label>
            <input type="text" id="name" name="name" placeholder="Enter Your Name" class="form-control" required="required" autofocus>
        </div>
        
     
         <div class="mb-3">
            <label for="amount" class="form-label">*Amount</label>
            <input type="number" id="amount" name="amount" placeholder="Enter Amount" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <label for="address" class="form-label">*Address</label>
            <input type="text" id="address" name="address" placeholder="Enter Address" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="phno" class="form-label">*Phone No</label>
            <input type="number" id="phno" name="phno" placeholder="Enter Phone Number" class="form-control" required="required" autofocus>
        </div>
        
        <div class="mb-3">
            <div class="col-sm-9 col-sm-offset-3">
                <span class="help-block">*Required fields</span>
            </div>
        </div>
        

        
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
</div> <!-- ./container -->
	
	
	<!-- Footer Java Script -->
	<c:import url="common/footer.html"></c:import>
</body>
</html>