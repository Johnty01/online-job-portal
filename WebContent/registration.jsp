<html>
<head>

	<script>
	
	var check_pass = function() {
		  if (document.getElementById('psswrd').value ==
		    document.getElementById('psswrd-repeat').value) {
		    document.getElementById('message').style.color = 'green';
		    document.getElementById('message').innerHTML = 'matching';
		  } else {
		    document.getElementById('message').style.color = 'red';
		    document.getElementById('message').innerHTML = 'not matching';
		  }
		}
		
		
		/*function check_pass() {
		    if (document.getElementById('psswrd').value ==
		            document.getElementById('psswrd-repeat').value) {
		        document.getElementById('submit').disabled = false;
		    } else {
		        document.getElementById('submit').disabled = true;
		    }
		}*/

	</script>
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
	<div class="bigbox" style="width=100%"align="center">
		<h2 align="center">REGISTRATION</h2>
		<form name="loginform" action=RegistrationPrimary>
			<table align="center">
				<br/>
				<br/>
				<tr>
					<td>Email-address</td>
					<td>
						<input type="email" name="email" title="Enter Valid Email Address" maxlength="80" size="30">
					</td>
				</tr>
				
				<!--  <tr>
					<td>Set Password</td>
					<td>
						<input type="password" name = "psswrd" id="psswrd" maxlength="14" size="30">
					</td>   <!-- onchange='check_pass();
				</tr>
				<tr><td></td><td></td></tr>
				<tr>
				<tr>
					<td>Repeat Password</td>
					<td>
						<input type="password" name = "psswrd-repeat" id="psswrd-repeat" maxlength="14" size="30">
					</td>
				</tr> -->
				<tr><td></td><td></td></tr>
				<tr>
					<td>
					</td>
					<td>
						<input type="submit" value="Submit" name="sbmt" id="submit">
						<input type="reset" value="Reset" name="rst" id="submit">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
</html>