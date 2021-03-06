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
		
			<th>Id</th>
			<th>Brand</th>
			<th>Model</th>
			<th>TypeDesignation</th>
			<th>VIN</th>
			<th>Comment</th>
			<th>SeatHeating</th>
			<th>Airbags</th>
			<th>OverTurningSystem</th>
			<th>User</th>

		
		</tr>
		
		<%
		
			List<Vehicle> vList = (List<Vehicle>) request.getAttribute("vehicle_list");
		
			for(int i = 0; i < vList.size(); i++){
			
		%>
		
		<tr>
		
			<td align="center"><%= vList.get(i).getId() %></td>
			<td align="center"><div contenteditable><%= vList.get(i).getBrand() %></td>
			<td align="center"><%= vList.get(i).getModel() %></td>
			<td align="center"><%= vList.get(i).getTypeDesignation() %></td>
			<td align="center"><%= vList.get(i).getVIN() %></td>
			<td align="center"><%= vList.get(i).getComment() %></td>
			<td align="center"><%= vList.get(i).isSeatHeating() %>
			<td align="center"><%= vList.get(i).isAirbags() %></td>
			<td align="center"><%= vList.get(i).isOverturningSystem() %></td>
			
			<td align="center">
				<%
					if(vList.get(i).getUserForVehicle() != null){
								
								ApplicationUser u =  vList.get(i).getUserForVehicle();
								
				%>
					<%=
						u.getFirstname() + " " + u.getLastname() + "<br />"
					%>
				<%
				
					}
				
				%>
				
			</td>
			
			<td><button type="submit" onClick="location='EditVehicleServlet'">Edit</button></td>
			<td><button type="submit" onClick="location='DeleteVehicleServlet'">Delete</button></td>
			
		
		</tr>
				
		<%
			}
		%>
	
	</table>
	
			<button type="submit" onClick="location='VehicleForm'">Back to forms</button>
	

</body>
</html>