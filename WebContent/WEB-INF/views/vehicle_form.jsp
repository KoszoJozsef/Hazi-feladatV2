<!DOCTYPE html>
<html>
<head>

	<title>Vehicle Form</title>

</head>
<body>

	<%
		if(request.getAttribute("errors") != null){
			
	%>
	
		<fieldset>
			<legend>Errors:</legend>
			<ul>
				<% if(request.getAttribute("brand-error") != null) { %>
					<li class="error">Brand error</li>
				<%}%>
				<% if(request.getAttribute("model-error") != null) { %>
					<li class="error">Model error</li>
				<%}%>
				<% if(request.getAttribute("typeDesignation-error") != null) { %>
					<li class="error">Typedesignation error</li>
				<%}%>
				<% if(request.getAttribute("VIN-error") != null) { %>
					<li class="error">Invalid VIN</li>
				<%}%>
			</ul>
		</fieldset>
		
	<%
		}
	%>
	
	<%
		if(request.getAttribute("user-errors") != null) {
	%>
		
		<fieldset>
			<legend>Errors:</legend>
			<ul>
				<% if(request.getAttribute("username-error") != null) { %>
					<li class="error">Username error</li>
				<%}%>
				<% if(request.getAttribute("password-error") != null) { %>
					<li class="error">Password error</li>
				<%}%>
				<% if(request.getAttribute("firstname-error") != null) { %>
					<li class="error">Firstname error</li>
				<%}%>
				<% if(request.getAttribute("lastname-error") != null) { %>
					<li class="error">Lastname error</li>
				<%}%>
			</ul>
		</fieldset>
	<%
		}
	%>
	
	<h2>Add vehicle</h2>

	<form method="POST" action="AddVehicleServlet">
		
		Brand:
		
		<input name="brand" type="text"></input>
		
		<br /><br />
		
		Model:
		
		<input name="model" type="text"></input>
		
		<br /><br />
		
		TypeDesignation:
		
		<input name="typeDesignation" type="text"></input>
		
		<br /><br />
		
		VIN:
		
		<input name="VIN" type="text"></input>
		
		<br /><br />
		
		Comment:
		
		<input name="comment" type="text"></input>
		
		<br /><br />
	
		<input name="extra" type="checkbox" value="seatHeating">SeatHeating
		
		<input name="extra" type="checkbox" value="airbags">Airbags
		
		<input name="extra" type="checkbox" value="overturningSystem">OverturningSystem
		
		<br /><br />
		
		User ID:
		
		<input name="idUser" type="text"></input>
		
		<br /><br />
		

		<button type="submit">Add Vehicle</button>
		
		<br /><br />
	</form>
	
	<h3>Vehicle List</h3>
	
	<form method="GET" action="VehicleListServlet">
	
		<button type="submit">Continue</button>
		
		<br /><br />
	
	</form>
	
	<h3>User List</h3>
	
	<form method="GET" action="UserListServlet">
	
		<button type="submit">Continue</button>
		
		<br /><br />
	
	</form>
	
	<h4>Add user</h4>
	
	<form method="POST" action="AddUserServlet">
		
		Username: 
		
		<input name="username" type="text" ></input>
		
		<br /><br />
		
		Password: 
		
		<input name="password" type="text" ></input>
		
		<br /><br />
		
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
		
		<button type="submit">Add user</button>
		
		<br /><br />
	
	</form>
	

</body>
</html>