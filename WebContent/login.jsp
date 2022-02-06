<html>

<head>
	<title>do login</title>
	<%@include file="homepage.jsp" %>
	<style>
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
	<div class="bigbox" style="width=100%";align="center">
		<h2 align="center">LOGIN</h2>
		<form name="loginform" action=LoginServlet>
			<table align="center">
				<br/>
				<br/>
				<tr>
					<td>Email-address</td>
					<td>
						<input type="text" name="email" maxlength="80" size="30">
					</td>
				</tr>
				
				<tr>
					<td>Password</td>
					<td>
						<input type="password" name = "psw" maxlength="14" size="30">
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