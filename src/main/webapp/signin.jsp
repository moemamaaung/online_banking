<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:import url="common/header.html"></c:import>
<title>Home Page</title>
</head>
<body>
	<div class="container">
    <form action="login" method="post">
        <h2 class="mb-3 text-center"></h2>
        
        <input type="hidden" name="mode" value="SIGNIN">
        
        <c:if test="${loginFail }">
        <div class="mb-3">
        <span class="alert alert-danger"> AccountNo or Username or Password is incorrect</span>
        </div>
        </c:if>
        
        <div class="mb-3">
            <label for="accountno" class="form-label">AccountNo</label>
            <input type="text" id="accountno" name="accountno" placeholder="Enter Your AccountNo" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="name" class="form-label">Username</label>
            <input type="text" id="name" name="name" placeholder="Enter Your Name" class="form-control" required="required" autofocus>
        </div>
        
         <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" name="password" placeholder="Enter Your PinNo" class="form-control" required="required" autofocus>
        </div>
        
        <button type="submit" class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-danger">Reset</button>
    </form> <!-- /form -->
     <p> Don't have an account? <a href="signup.jsp">Please Sign up</a> </p>
</div> <!-- ./container -->
	
	
<c:import url="common/footer.html"></c:import>
</body>
</html>