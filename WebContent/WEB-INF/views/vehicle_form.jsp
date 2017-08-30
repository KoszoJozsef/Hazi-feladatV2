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
		

		<button type="submit">Add Vehicle</button>
		
	
	</form>

</body>
</html>