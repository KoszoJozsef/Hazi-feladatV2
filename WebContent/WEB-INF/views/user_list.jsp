<%@ page import="java.util.*,com.register.entities.*" %>

<!DOCTYPE html>
<html>
<head>
<title>User List</title>
</head>
<body>

	<h1>List of users</h1>
	
	<table>
	
		<tr>
		
			<th>Id</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Role</th>

		
		</tr>
		
		<%
					List<ApplicationUser> uList = (List<ApplicationUser>) request.getAttribute("user_list");
						
					for(int i = 0; i < uList.size(); i++){
				%>
		
		<tr>
		
			<td align="center"><%= uList.get(i).getId() %></td>
			<td align="center"><%= uList.get(i).getFirstname() %></td>
			<td align="center"><%= uList.get(i).getLastname() %></td>
			<td align="center"><%= uList.get(i).getRole() %></td>
			
			<td><button type="submit">Edit</button></td>
			
		
		</tr>
		
		<%
			}
		%>
	
	</table>
	
		<button type="submit" onClick="location='VehicleForm'">Back to forms</button>

</body>
</html>