<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>Resultado de la busqueda:</div>
	<table>
	<tr>
				<th>ID:</th>
				<th>Destino</th>
				<th>Duración</th>
				<th>Precio</th>
	</tr>
	<c:forEach items="${lista}" var="viaje">
		<tr>
			<td>${viaje.id}</td>
			<td>${viaje.destino}</td>
			<td>${viaje.duracion}</td>
			<td>${viaje.precio}</td>
			<td><a href="Favoritos?id=${viaje.id}" title="Añadir a favoritos: ${viaje.destino}"><button>Favoritos</button></a></td>
			
		</tr>
		
	</c:forEach>
		
		
	</table>
	<a href="Inicio">Inicio</a>
</body>
</html>