<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
	<title>Student Management System</title>
	<style type="text/css">
		<%@ include file="/views/css/style.css"%>
	</style>
</head>
<body>
	<div class="container">
		<h1 class="heading">Student Management System</h1>
		<ul class="nav">
			<li><a href="addStudent">Register Student</a></li>
			<li><a href="deleteStudent">Delete Student</a></li>
			<li><a href="updateStudent">Update Student</a></li>
			<li><a href="viewAllStudent">Display All Student</a></li>
			
		</ul>
	 	<marquee><h1 class="heading">Welcome to Student Management System</h1></marquee>
	</div>
	<div>${PrintSwal}</div>
</body>
</html>
