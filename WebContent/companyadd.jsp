<html>
<head>
	<title>Welcome Admin</title>
	<link rel="stylesheet" href="style.css">
	<style>
	
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #FAF8FB;
    width: 100%;
	}

	li 
	{
    	float: left;
	}
	li a, .dropbtn {
    display: block;
    color: black;
    text-align: center;
    padding: 16px;
    text-decoration: none;
	}

li a:hover, .dropdown:hover .dropbtn {
    background-color:#6C223D  ;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #6C223D;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #6C223D}

.dropdown:hover .dropdown-content {
    display: block;
}

.bigbox
		{
			margin: auto;
			border: 3px solid black;
			padding: 10px;
			padding-bottom: 80px;
			background-color: #D7DBDD;
			height:30%;
		}	
	</style>	
</head>
<body>
	<div class="header">
		<h1 class="heading-main" align="center">Magnanimous Jobverse </h1>
	</div>
	
	<ul>
  <li><a href="">Home</a></li>
  <li><a href="#contact">Contact</a></li>
  <li><a href="about_us.jsp">About</a></li>
  
  <li style="float:right"><a href="homepage.jsp">LOGOUT</a></li>
  <li class="dropdown" style="float:right">
    <a href="javascript:void(0)">Student</a>
    <div class="dropdown-content">
      <a href="#studentremove.jsp">REMOVE Student</a>
    </div>
  </li>
  
 <!-- <li class="dropdown" style="float:right">
    <a href="javascript:void(0)">Jobs</a>
    <div class="dropdown-content">
      <a href="adminportal.jsp">View Jobs</a>
      <a href="adminportal.jsp">search jobs</a>
    </div>
    </li> -->
    
  <li class="dropdown" style="float:right">
    <a href="javascript:void(0)">Companies</a>
    <div class="dropdown-content">
      <a href="companyadd.jsp">Add Companies</a>
      <a href="companyremoval.jsp">Remove Companies</a>
    </div>
  </li>
  
<!--  <li style="float:right"><a href="adminportal.jsp">History</a></li> -->
  
</ul><br>
<div class="bigbox" style="width=100%";align="center">
		<h2 align="center">ADMIN</h2>
		<form name="deletionform" action="CompanyAdd">
			<table align="center">
				<br/>
				<br/>
				<tr>
					<td>Company-Name</td>
					<td>
						<input type="text" name="compname" maxlength="30" size="30">
					</td>
				<tr>
				<tr>
					<td>Email-address</td>
					<td>
						<input type="email" name="email" title="Enter Valid Email Address" maxlength="80" size="30">
					</td>
				</tr>
				<tr>
					<td>Password</td>
					<td>
						<input type="password" name="psw"  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain atleast one number and one uppercase and lowercase letter, and atleast 8 or more characters'required" maxlength="14" size="30">
				</tr>
					<td>
					</td>
					<td>
						<input type="submit" value="Submit" name="sbmt">
						<input type="reset" value="Reset" name="rst">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>