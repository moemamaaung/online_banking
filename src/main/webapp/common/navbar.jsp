<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
  <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
  
  
  
  
  
   <div class="container-xxl bg-white p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->


        <!-- Navbar & Hero Start -->
        <div class="container-xxl position-relative p-0">
            <nav class="navbar navbar-expand-lg navbar-light px-4 px-lg-5 py-3 py-lg-0">
                <a href="index.html" class="navbar-brand p-0">
                    <h1 class="m-0">My-Bank</h1>
                    <!-- <img src="img/logo.png" alt="Logo"> -->
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
                    <span class="fa fa-bars"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarCollapse">
                    <div class="navbar-nav ms-auto py-0">
                        <a href="account" class="nav-item nav-link">Home</a>
                        <c:if test="${fn:contains(user.role,'admin') }"> 
 					<a class="nav-link" href="create.jsp">New Account</a>
 					</c:if> 
 					<a class="nav-link" href="balance">Balance</a>
<!--  					<a class="nav-link" href="deposit">Deposit</a> -->
<!--  					<a class="nav-link" href="withdrawn">Withdraw</a> -->
                        <a href="about.jsp" class="nav-item nav-link active">About</a>
                        <a href="service.jsp" class="nav-item nav-link">Service</a>
                        <div class="nav-item dropdown">
                            <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">Pages</a>
                            <div class="dropdown-menu m-0">
                                <a href="feature.jsp" class="dropdown-item">Features</a>
                                <a href="quote.jsp" class="dropdown-item">Free Quote</a>
                                <a href="team.jsp" class="dropdown-item">Our Team</a>
                                <a href="testimonial.jsp" class="dropdown-item">Testimonial</a>
                                <a href="404.jsp" class="dropdown-item">404 Page</a>
                               
                            </div>
                        </div>
                        <a href="contact.jsp" class="nav-item nav-link">Contact</a>
                         <a href="login" class="nav-item nav-link">Logout</a></li>
						
                    </div>
                    <a href="" class="btn btn-light rounded-pill text-primary py-2 px-4 ms-lg-5">Free Quote</a>
                </div>
            </nav>


       
  
