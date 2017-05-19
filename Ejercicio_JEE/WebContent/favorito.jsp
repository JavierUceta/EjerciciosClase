<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mis favoritos</title>
</head>
<body>
	<div>Mis favoritos</div>
	<table>
			<tr>
				<th>Id</th>
				<th>Destino</th>
				<th>Duración</th>
				<th>Precio</th>
			</tr>
		<c:forEach items="${favoritos}" var="viaje">
			<tr>
				<td>${viaje.Id}</td>
				<td>${viaje.Destino}</td>
				<td>${viaje.Duracion}</td>
				<td>${viaje.Precio}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="Inicio">Inicio</a>
</body>
</html>