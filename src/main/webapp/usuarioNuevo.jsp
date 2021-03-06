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

    <section class="vh-100 gradient-custom">
        <div class="container py-5 h-100">
            <div class="row justify-content-center align-items-center h-100">
                <div class="col-12 col-lg-9 col-xl-7">
                    <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                        <div class="card-body p-4 p-md-5">
                            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registrar usuario</h3>

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
                                    <input type="number" class="form-control form-control-sm" id="edad" name="edad" min="18" max="29" title="Debe tener de entre 18 a 30 a??os" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="idcodigo">Codigo PUCP</label>
                                    <input type="tel" class="form-control form-control-sm" id="idcodigo" name="idcodigo" pattern="[0-9]{8}" title="Debe ingresar 8 d??gitos numericos" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="correo">Correo PUCP</label>
                                    <input type="email" class="form-control form-control-sm" id="correo" name="correo" required>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="especialidad">Especialidad</label>
                                    <select class="form-control" id="especialidad" name="especialidad" >
                                        <option value="1" disabled>Escoge una opcion</option>
                                        <option value="telecomunicaciones">Telecomunicaciones</option>
                                        <option value="industrial">Industrial</option>
                                        <option value="minas">Minas</option>
                                        <option value="informatica">Informatica</option>
                                        <option value="civil">Civil</option>
                                        <option value="electronica">Electronica</option>
                                        <option value="mecatronica">Mecatronica</option>
                                    </select>

                                </div>

                                <div class="mb-3">
                                    <label class="form-label" for="contrasena0">Contrase??a</label>
                                    <input type="password" class="form-control form-control-sm"  id="contrasena0" name="contrasena0" >
                                </div>
                                <div class="mb-3">
                                    <label class="form-label" for="contrasena">Confirme contrase??a</label>
                                    <input type="password" class="form-control form-control-sm" id="contrasena" name="contrasena" pattern="(?=^.{6,}$)(?=.*\d)(?=.*[!@#$%^&*]+)(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" title="Contrase??a con una may??scula, un n??mero y un car??cter especial" required>
                                </div>

                                <script >
                                    function verificarPasswords() {

                                        // Ontenemos los valores de los campos de contrase??as
                                        pass1 = document.getElementById('contrasena0');
                                        pass2 = document.getElementById('contrasena');

                                        // Verificamos si las constrase??as no coinciden
                                        if (pass1.value !== pass2.value) {

                                            // Si las constrase??as no coinciden mostramos un mensaje
                                            document.getElementById("error").classList.add("mostrar");

                                            return false;
                                        } else {

                                            // Si las contrase??as coinciden ocultamos el mensaje de error
                                            document.getElementById("error").classList.remove("mostrar");

                                            // Mostramos un mensaje mencionando que las Contrase??as coinciden
                                            document.getElementById("ok").classList.remove("ocultar");

                                            // Desabilitamos el bot??n de login
                                            document.getElementById("login").disabled = true;

                                            // Refrescamos la p??gina (Simulaci??n de env??o del formulario)
                                            setTimeout(function() {
                                                location.reload();
                                            }, 3000);

                                            return true;
                                        }

                                    }
                                </script>
                                <a href="<%= request.getContextPath()%>/LoginServlet" class="btn btn-secondary">Volver</a>
                                <input type="submit" id="login" value="Guardar" class="btn btn-primary"/>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    </div>
</div>

</body>
</html>
