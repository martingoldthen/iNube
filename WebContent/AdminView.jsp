<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin View</title>
</head>
<body>
<shiro:user>
    Welcome back <shiro:principal />! Click <a href="LogoutServlet">here</a> to logout.
</shiro:user>
<hr>
	<h2>Vista de administrador</h2>
	<shiro:lacksRole name="admin">
	No tienes permiso para ver el contenido de esta página
</shiro:lacksRole>
	<shiro:hasRole name="admin">
		<h3>Dar de alta negocio nuevo</h3>
		<form action="CreateNegocioServlet" method="post">
			<p>
				Información sobre la empresa
			</p>
			<p>
				NIF: <input type="text" name="nif" />
			</p>
			<p>
				Nombre de la empresa: <input type="text" name="company" />
			</p>
			<p>
				Password: <input type="password" name="password" />
			</p>
			<p>
				Codigo Postal: <input type="number" name="cp" />
			</p>
			<p>
				Tipo: <input type="text" name="bussiness_type" />
			</p>
			<p>
				Dueño de la empresa
			</p>
			<p>
				Nombre: <input type="text" name="name" />
			</p>
			<p>
				Apellidos: <input type="text" name="surname" />
			</p>
			<p>
				Email de empresa: <input type="email" name="email" />
			</p>
			<p>
				Teléfono de empresa: <input type="text" name="phone" />
			</p>
			<p>
				<button type="submit">Dar de alta</button>
			</p>
		</form>
		<h3>Añadir nuevo cliente</h3>
		<form action="CreateCliente" method="post">
			<p>
				idCliente: <input type="number" name="idCliente" />
			</p>
			<p>
				Código Postal: <input type="number" name="cp" />
			</p>
			<p>
				<button type="submit">Añadir cliente</button>
			</p>
		</form>
		<h3>Insertar nueva transacción</h3>
		<form action="CreateTransaccionServlet" method="post">
			<p>
				idMovimiento: <input type="number" name="idMovimiento" />
			</p>
			<p>
				idCliente: <input type="number" name="idCliente" />
			</p>
			<p>
				idNegocio: <input type="text" name="idNegocio" />
			</p>
			<p>
				Cantidad: <input type="number" name="valor" />
			</p>
			<p>
				Fecha: <input type="hh:mm:ss dd/mm/yyyy" name="fecha" />
			</p>
			<p>
				<button type="submit">Insertar transacción</button>
			</p>
		</form>
		<h3>Listado de negocios</h3>
		<table border="1">
			<tr>
				<th>CIF</th>
				<th>Nombre</th>
				<th>CP</th>
				<th>Tipo</th>
				<th>NMovimientos</th>
			</tr>
			<c:forEach items="${negocio_list}" var="negocio">
				<tr>
					<td>${negocio.cif }</td>
					<td>${negocio.nombre }</td>
					<td>${negocio.cp }</td>
					<td>${negocio.tipo }</td>
					<td>${fn:length(negocio.movimientosNegocio) }</td>
				</tr>
			</c:forEach>
		</table>
     		<h3>Listado de clientes</h3> 
     		<table border="1"> 
    			<tr> 
    				<th>idCliente</th> 
    				<th>cp</th> 
    				<th>Movimientos</th> 
    			</tr> 
    			<c:forEach items="${cliente_list}" var="clientei">
    				<tr> 
		    			<td>${clientei.idCliente }</td>
	    				<td>${clientei.cp }</td>
    					<td>${fn:length(clientei.movimientosCliente) }</td> 
   					</tr>
        		</c:forEach> 
    		</table>
	</shiro:hasRole>
</body>
</html>