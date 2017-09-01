<!DOCTYPE html>
<html>
<head>
<title>Editing Vehicle</title>
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



	<h2>Edit vehicle</h2>

	<form method="POST" action="EditVehicleServlet">
		
		Brand:
		
		<input name="eBrand" type="text"></input>
		
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
		

		<button type="submit">Edit Vehicle</button>
		
	</form>

</body>
</html>