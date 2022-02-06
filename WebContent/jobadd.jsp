<html>

<head>
	<title>Company Page of job portal</title>
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

	li a 
	{
    display: block;
    color: black;
    text-align: center;
    padding: 26px;
    font-family:"Times New Roman";
    font-size:20px;
    text-decoration: none;
	}

	li a:hover 
	{
    background-color:#6C223D;
	}
	
	.portal
	{
		border:3px solid black;
		width: 100%;
		Height:auto;
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

	<ul style="width:100%">
  		
  		<li style="float:right"><a href="jobadd.jsp">Add a Job</a></li>
  		<li style="float:right"><a href="ApplicantServlet">See Applicants</a></li>
  		<li style="float:right"><a href="homepage.jsp">Logout</a></li>
  		<li style="float:right"><a href="HistoryServlet">History</a></li>
	</ul>
	<hr>
	
	<div class="portal">
	<!-- border=3px solid black -->
		<p style="font-size=14" align="center">Company Portal</p>
	</div>
<hr>



<div class="bigbox" style="width=100%";align="center">
		<h2 align="center">ADD THE JOB</h2>
		<form name="jobadd" action="JobAdd">
			<table align="center">
				<br/>
				<br/>
				<!--<tr>
				<td>Job Name</td>
					<td>
						<input type="text" name="jname" maxlength="45" size="30">
					</td>
				</tr> -->
				
				
				
				<tr>
					<td>Job Designation</td>
					<td>
						<input type="text" name = "jdesignation" maxlength="45" size="30">
					</td>
				</tr>
				
				<tr>
					<td>Job Profile Type</td>
					<td>
						<input type="text" name = "jprofiletype" maxlength="45" size="30">
					</td>
				</tr>
				
				<tr>
					<td>CTC</td>
					<td>
						<input type="text" name = "jctc" maxlength="7" size="7">
					</td>
				</tr>
				
					<tr>
					<td>Job Venue</td>
					<td>
						<input type="text" name = "jvenue" maxlength="45" size="30">
					</td>
				</tr>
				
				<tr>
					<td>Event Venue</td>
					<td>
						<input type="textbox" name = "evenue">
					</td>
				</tr>
				<tr><td></td><td></td></tr>
				<tr>
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