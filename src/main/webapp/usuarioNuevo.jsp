<%--
  Created by IntelliJ IDEA.
  User: jesus
  Date: 28/06/2022
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.example.laboratorio10_grupo3.Beans.EstudianteBean" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Nuevo usuario</title>
    <jsp:include page="/includes/headCss.jsp"></jsp:include>
</head>
<body background="fondo.jpg">
<div class='container'  >
    <br>
    <br>
    <div class="row mb-4" >
        <div class="col"></div>
        <br>
        <br>
        <div class="col-md-6" style="background-color: #eee" >
            <br>
            <h1 class='mb-3'>Registrar usuario</h1>
            <hr>

            <form method="POST"  action="UsuarioServlet?action=crear" >
                <div class="mb-3">
                    <label class="form-label" for="nombre">Nombre</label>
                    <input type="text" class="form-control form-control-sm" id="nombre" name="nombre" pattern="[a-zA-Z]+" title="Ingrese solo letras" required>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="apellido">Apellido</label>
                    <input type="text" class="form-control form-control-sm" id="apellido" name="apellido" pattern="[a-zA-Z]+" title="Ingrese solo letras" required>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="edad">Edad</label>
                    <input type="number" class="form-control form-control-sm" id="edad" name="edad" min="18" max="29" title="Debe tener de entre 18 a 30 años" required>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="idcodigo">Codigo PUCP</label>
                    <input type="tel" class="form-control form-control-sm" id="idcodigo" name="idcodigo" pattern="[0-9]{8}" title="Debe ingresar 8 dígitos numericos" required>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="correo">Correo PUCP</label>
                    <input type="email" class="form-control form-control-sm" id="correo" name="correo" required>
                </div>
                <div class="mb-3">
                    <label class="form-label" for="especialidad">Especialidad</label>
                    <input type="text" class="form-control form-control-sm" id="especialidad" name="especialidad" required>
                </div>

                <div class="mb-3">
                    <label class="form-label" for="contrasena0">Contraseña</label>
                    <input type="password" class="form-control form-control-sm"  id="contrasena0" name="contrasena0" >
                </div>
                <div class="mb-3">
                    <label class="form-label" for="contrasena">Confirme contraseña</label>
                    <input type="password" class="form-control form-control-sm" id="contrasena" name="contrasena" pattern="(?=^.{6,}$)(?=.*\d)(?=.*[!@#$%^&*]+)(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" title="Contraseña con una mayúscula, un número y un carácter especial" required>
                </div>

                <script >
                    function verificarPasswords() {

                        // Ontenemos los valores de los campos de contraseñas
                        pass1 = document.getElementById('contrasena0');
                        pass2 = document.getElementById('contrasena');

                        // Verificamos si las constraseñas no coinciden
                        if (pass1.value !== pass2.value) {

                            // Si las constraseñas no coinciden mostramos un mensaje
                            document.getElementById("error").classList.add("mostrar");

                            return false;
                        } else {

                            // Si las contraseñas coinciden ocultamos el mensaje de error
                            document.getElementById("error").classList.remove("mostrar");

                            // Mostramos un mensaje mencionando que las Contraseñas coinciden
                            document.getElementById("ok").classList.remove("ocultar");

                            // Desabilitamos el botón de login
                            document.getElementById("login").disabled = true;

                            // Refrescamos la página (Simulación de envío del formulario)
                            setTimeout(function() {
                                location.reload();
                            }, 3000);

                            return true;
                        }

                    }
                </script>
                <a href="<%= request.getContextPath()%>/LoginServlet" class="btn btn-danger">Cancelar</a>
                <input type="submit" id="login" value="Guardar" class="btn btn-primary"/>
                <br>
                <br>

            </form>
        </div>
        <div class="col"></div>
    </div>
</div>

</body>
</html>
