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
    <title>Registro iNube</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/formulario.css">
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/intl-tel-input-12.0.0/build/css/intlTelInput.css">
</head>

<body>
    <a id="barra_arriba" target="_blank"><img id="foto" src="${pageContext.request.contextPath}/img/inube_logo.png"></a><br>
    <div id="cuerpo" class="container">
        <form action="CreateNegocioServlet" method="post">
            <br>
            <br>
            <br>
            <h3>Información de contacto:</h3>

            <fieldset>
                <p><label for="name">Nombre*:</label><br>
                    <input name="name" id="name" required></p>

                <p><label for="surname">Apellidos*:</label><br>
                    <input name="surname" id="surname" required></p>

                <p><label for="phone">Teléfono*:</label><br>
                    <input type="tel" name="phone" id="phone" required></p>
<!--                 <input type="hidden" name="hidden_phone" id="hidden_phone"> -->

                <p><label for="email">e-mail*:</label><br>
                    <input type="email" name="email" id="email" placeholder="hello@iNube.com" required></p>
            </fieldset>

            <br>

            <h3>Información sobre el negocio</h3>

            <fieldset>
            
            	<p><label for="nif">NIF*(usuario):</label><br>
                    <input name="nif" id="nif" placeholder="92781496W" required></p>
                    
            	<p><label for="password">Contraseña*:</label><br>
                    <input type="password" name="password" id="password" required></p>

                <p><label for="repeat_password">Repetir contraseña*:</label><br>
                    <input type="password" name="repeat_password" id="repeat_password" required></p>
                    
                <p><label for="company">Nombre de empresa*:</label><br>
                    <input name="company" id="company" required></p>

                <p><label for="cp">Código Postal*:</label><br>
                    <input name="cp" id="cp" placeholder="28006" required></p>

<!--                 <p>Logo de la empresa:<br> -->
<!--                     <label for="logo" class="custom-file-upload"> -->
<!--                         Subir logo -->
<!--                     </label></p> -->
<!--                 <input type="file" name="logo" id="logo" accept="image/*"> -->

                <p><label for="bussiness_type">¿De que tipo de negocio se trata?</label></p>
                <select name="bussiness_type" id="bussiness_type">
                    <option>--------------------</option>
                    <option value="resturant">Restauración</option>
                    <option value="fashion">Moda</option>
                    <option value="beauty">Estética</option>
                </select>
            </fieldset>
            <input type="submit" class="boton_enviar" value="Registrarse">
        </form>
    </div>
</body>
<script src="${pageContext.request.contextPath}/resources/jquery-3.2.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/formulario.js?v=1.2"></script>
<script src="${pageContext.request.contextPath}/resources/intl-tel-input-12.0.0/build/js/intlTelInput.js?v=1.2"></script>
<script>
    $("#phone").intlTelInput();
</script>

</html>
