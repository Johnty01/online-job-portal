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
</body>

</html>