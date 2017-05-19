<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Agencia de Viajes</title>
</head>
<body>

	<div>Numero de usuarios en el sito web: ${numeroUsuarios}</div>

	<div> 
		<table>
			<thead>Viaje en promocion:</thead>
			<tr>
				<th>Destino</th>
				<th>Duración</th>
				<th>Precio</th>
				<th>Fav</th>
			</tr>
			<tr>
				<td>${promocion.destino}</td>
				<td>${promocion.duracion} días</td>
				<td>${promocion.precio} &euro;</td>
				<td><a href="Favoritos?id=${promocion.id}" title="Añadir a favoritos: ${promocion.destino}"><button>Favoritos</button></a></td>
			</tr>
		</table>
	</div>
	
	<a href="Listado">Listado de nuestros viajes</a>
	<br/>
	<a href="formularioBuscar.jsp">Buscar destino</a>
</body>
</html>