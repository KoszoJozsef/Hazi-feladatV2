<!DOCTYPE html>
<html>
<head>
<title>Editing User</title>
</head>
<body>

<h4>Edit user</h4>
	
	<form method="POST" action="EditUserServlet">	
		
		Firstname: 
		
		<input name="firstname" type="text" ></input>
		
		<br /><br />
		
		Lastname: 
		
		<input name="lastname" type="text" ></input>
		
		<br /><br />
		
		Role: 
		
		<select name="role">
			<option value="Admin">Admin</option>
			<option value="User">User</option>
		</select>
		
		<br /><br />
		
		<button type="submit">Edit user</button>
		
		<br /><br />
		
	</form>

</body>
</html>