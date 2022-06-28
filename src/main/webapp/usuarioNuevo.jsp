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

</head>
<body>
<div class='container'>

    <div class="row mb-4">
        <div class="col"></div>
        <div class="col-md-6">
            <h1 class='mb-3'>Nuevo usuario</h1>
            <hr>
            <form method="POST" action="UsuarioServlet?action=crear">
                <div class="mb-3">
                    <label class="form-label" for="nombre">Nombre</label>
                    <input type="text" class="form-control form-control-sm" id="nombre" name="nombre">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="apellido">Apellido</label>
                    <input type="text" class="form-control form-control-sm" id="apellido" name="apellido">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="edad">Edad</label>
                    <input type="number" class="form-control form-control-sm" id="edad" name="edad" min="18" max="30" title="Debe tener de entre 18 a 30 años">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="idcodigo">Codigo PUCP</label>
                    <input type="tel" class="form-control form-control-sm" id="idcodigo" name="idcodigo" pattern="[0-9]{8}" title="Debe ingresar 8 dígitos numericos">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="correo">Correo PUCP</label>
                    <input type="email" class="form-control form-control-sm" id="correo" name="correo">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="especialidad">Especialidad</label>
                    <input type="text" class="form-control form-control-sm" id="especialidad" name="especialidad">
                </div>
                <div class="mb-3">
                    <label class="form-label" for="contrasena">Contraseña</label>
                    <input type="text" class="form-control form-control-sm" id="contrasena" name="contrasena">
                </div>


                <a href="<%= request.getContextPath()%>/UsuarioServlet" class="btn btn-danger">Cancelar</a>
                <input type="submit" value="Guardar" class="btn btn-primary"/>
            </form>
        </div>
        <div class="col"></div>
    </div>
</div>

</body>
</html>
