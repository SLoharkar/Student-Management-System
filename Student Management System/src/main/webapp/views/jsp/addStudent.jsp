<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Register Student</title>
	<style type="text/css">
		<%@ include file="/views/css/style.css"%>
	</style>
 <!-- 	<link rel="stylesheet" href="css/style.css" />  -->
</head>
<body>

	<div class="container">
		<h1 class="heading">Student Management System</h1>
		<ul class="nav">
			<li><a href="viewAllStudent">Display All Student</a></li>
			<li><a href="/">Home</a></li>
		</ul>
		<h2 class="heading">Register Student</h2>
        <div class="add-form">
          <form action="addStud" method="post">
             <table>
                 <tr>
                    <th>
                         <label for="sno">Student No. : </label>         
                    </th>
                    <td>
                         <input type="number" name="studNo" class="input-field" id="sno" maxlength="10" value="1" required>
                    </td>
                 </tr>
                 <tr>
                    <th>
                         <label for="sname">Student Name : </label>      
                    </th>
                    <td>
                         <input type="text" name="studName" class="input-field" id="sname" maxlength="40" value="Stud Name"  required>
                    </td>
                 </tr>
                 <tr>
                    <th>
                         <label for="sdob">Date of Birth : </label> 
                    </th>
                    <td>            
                        <input type="date" name="studDOB" class="input-field" id="sdob" value="1990-12-01" required>
                    </td>
                 </tr>
                 <tr>
                    <th>
                        <label for="sdoj">Date of Joining : </label>
                    </th>
                    <td>
                        <input type="date" name="studDOJ" class="input-field" id="sdoj" value="2017-01-10" required>
                    </td>
                 </tr>
                 <tr >
                    <td colspan="2">
                        <input type="submit" class="input-field" value="Add Student">
                    </td>
                 </tr>
            </table>
         </form>
       </div>
	</div>
	<div>${PrintSwal}</div>
</body>
</html>