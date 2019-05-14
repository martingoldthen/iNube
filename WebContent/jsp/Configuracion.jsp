<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <script type="text/javascript">
        if (screen.width <= 800) {
            document.head.insertAdjacentHTML('beforeEnd', '<meta name="viewport" content="width=device-width, initial-scale=0.95, maximum-scale=1.0, user-scalable=0, user-scalable=no"/>');
        }
    </script>
    <meta charset="UTF-8">
    <title>Configuracion</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formulario.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/intl-tel-input-12.0.0/build/css/intlTelInput.css">
</head>
<body>
<a id="barra_arriba" target="_blank"><img id="foto" src="${pageContext.request.contextPath}/img/inube_logo.png"></a><br>
 <div id="cuerpo" class="container">
	
	<form action="ConfiguracionServlet" method="post">
		
        <h3>Información de contacto:</h3>
        	
        	<fieldset>
                
                <p><label for="name">Nombre*:</label><br>
                    <input name="name" id="name" required value="${negocio.nombreContacto}"/></p>

                <p><label for="surname">Apellidos*:</label><br>
                    <input name="surname" id="surname" required value="${negocio.apellidosContacto}"/></p>
                    
                <p><label for="email">e-mail*:</label><br>
                    <input type="email" name="email" id="email" placeholder="hello@iNube.com" required value="${negocio.emailContacto}"/></p>
           		
           		<p><label for="phone">Teléfono*:</label><br>
                    <input type="tel" name="phone" id="phone" required  value="${negocio.telefonoContacto}"></p>
                 

                
             </fieldset>

            <br>

            <h3>Información sobre el negocio</h3>

            <fieldset>
            	<p><label for="cif">CIF*:</label><br>
                    <input name="cif" id="cif" placeholder="92781496W" required value="${negocio.cif}"/></p>
            
            
                
                <p><label for="phone">Teléfono*:</label><br>
                    <input type="tel" name="phone" id="phone" required  value="${negocio.telefonoContacto}"></p>
                 
            	<p><label for="password">Contraseña*:</label><br>
                    <input type="password" name="password" id="password" required value=""/></p>
                    
                <p><label for="company">Nombre de empresa*:</label><br>
                    <input name="company" id="company" required  value="${negocio.nombre}"/></p>

                <p><label for="cp">Código Postal*:</label><br>
                    <input name="cp" id="cp" placeholder="28006" required value="${negocio.cp}"/></p>
                    
       			<p><label for="email">e-mail*:</label><br>
                    <input type="email" name="email" id="email" placeholder="hello@iNube.com" required value="${negocio.emailContacto}"/></p>
           
		
				<p><label for="bussiness_type">¿De que tipo de negocio se trata?</label></p>
                	<select name="bussiness_type" id="bussiness_type">
                    	<option value="${negocio.tipo }" selected>${negocio.tipo }</option>
                    	<option value="resturant">Restauración</option>
                    	<option value="fashion">Moda</option>
                    	<option value="beauty">Estética</option>
                	</select>
              </fieldset>
             <button class="boton_enviar" type="submit">Modificar los datos</button>
        </form>
    </div>
</body>
</html>
	
            
 	  	
		
		