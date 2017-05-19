<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Busca tu destino</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>
				<form action="Buscar" method="post">
					<label for="destino">Buscar destino:</label>
					<input type="text" name="busqueda" placeholder="Destino"/>
					<button type="submit">Buscar</button>
				</form>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td><a href="Inicio">Inicio</a></td>
			</tr>
		</tfoot>
	</table>
</body>
</html>