<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
	<table>
		<tr>
				<td>ID:</td>
				<td>Destino</td>
				<td>Duración</td>
				<td>Precio</td>
			</tr>
		<c:forEach items="${lista}" var="destino">
			
			<tr>
				<td>${destino.getId()}</td>
				<td>${destino.getDestino()}</td>
				<td>${destino.getDuracion()}</td>
				<td>${destino.getPrecio()}</td>
				
				<td><a href="Favorito?id=${viaje.id}">${viaje.destino}</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>