<%@ page import="java.util.*,com.register.entities.*" %>

<!DOCTYPE html>
<html>

<head>

	<title>Vehicle List</title>
	
</head>

<body>
	
	<h1>List of vehicles</h1>
	
	<table>
	
		<tr>
		
			<th>Brand</th>
			<th>Model</th>
			<th>TypeDesignation</th>
			<th>VIN</th>
			<th>Comment</th>
			<th>SeatHeating</th>
			<th>Airbags</th>
			<th>OverTurningSystem</th>
		
		</tr>
		
		<%
		
			List<Vehicle> vList = (List<Vehicle>) request.getAttribute("vehicle_list");
		
			for(int i = 0; i < vList.size(); i++){
			
		%>
		
		<tr>
		
			<td><%= vList.get(i).getBrand() %></td>
			<td><%= vList.get(i).getModel() %></td>
			<td><%= vList.get(i).getTypeDesignation() %></td>
			<td><%= vList.get(i).getVIN() %></td>
			<td><%= vList.get(i).getComment() %></td>
			<td><%= vList.get(i).isSeatHeating() %></td>
			<td><%= vList.get(i).isAirbags() %></td>
			<td><%= vList.get(i).isOverturningSystem() %></td>
		
		</tr>
		
		<%
			}
		%>
	
	</table>

</body>
</html>