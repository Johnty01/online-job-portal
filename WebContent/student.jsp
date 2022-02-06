<html>
<head>
	<title>Welcome Student</title>
	<link rel="stylesheet" href="style.css">
	<style>
		ul
		{
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

		.li a:hover 
		{
    		background-color:#6C223D;
		}
	</style>	
</head>

<body>
	<div class="header">
		<h1 class="heading-main" align="center">Magnanimous Jobverse </h1>
	</div>

	<ul style="width:100%">
  		
  		<li style="float:right"><a href="homepage.jsp">Logout</a></li>
  		<li style="float:right"><a href="ResultForStudents" action="ResultForStudents">Results</a></li>
  		<li style="float:right"><a href="ShowJob" action="ShowJob">Jobs</a></li>
  		<li style="float:right"><a href="AppliedListForStudents" action="AppliedListForStudents">Applied</a></li>

  		
	</ul>
	<hr>
	
</body>
</html>