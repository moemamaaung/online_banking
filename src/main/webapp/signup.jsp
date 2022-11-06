<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<c:import url="common/header.html"></c:import>
<title>User Register Page</title>
</head>
<body>

	<div class="container">
		<form action="user" method="post">
			<h2 class="mb-3 text-right">OPEN ACCOUNT FORM</h2>
			<h2>Registration form</h2>

			<input type="hidden" name="mode" value="SIGNUP">

			
          <div class="mb-3">
            <label for="text" class="form-label">*AccountNo</label>
            <input type="password" id="accountno" name="accountno" placeholder="Enter Your AccountNo" class="form-control" required="required" autofocus>
        </div> 


			<div class="mb-3">
				<label for="name" class="form-label">*Username</label> 
				<input type="text" id="name" name="name"placeholder="Enter Your Name" class="form-control" required="required" autofocus>
			</div>

			<div class="mb-3">
				<label for="password" class="form-label">*Password</label> 
				<input type="password" id="password" name="password" placeholder="Enter Your Password" class="form-control"required="required" autofocus>
			</div>

	
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="role" name="role" value="true"> 
				<label class="form-check-label" for="role">Admin</label>
			</div>

			<div class="mb-3">
				<div class="col-sm-9 col-sm-offset-3">
					<span class="help-block">*Required fields</span>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
		<!-- /form -->
		<p>
			Already has an account ? <a href="signin.jsp">Please Sign in</a>
		</p>
	</div>
	<!-- ./container -->


	<c:import url="common/footer.html"></c:import>
</body>
</html>