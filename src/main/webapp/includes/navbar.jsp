<%@ page import="com.example.laboratorio10_grupo3.Servlets.LoginServlet" %>
<% String currentPage = request.getParameter("currentPage"); %>


<jsp:useBean id="empleadoLogueado" class="com.example.laboratorio10_grupo3.Beans.EstudianteBean"
             scope="session" type="com.example.laboratorio10_grupo3.Beans.EstudianteBean"/>

<nav class="navbar navbar-expand-md navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%=request.getContextPath()%>">INICIO</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <b class="nav-link "
                       href="<%=request.getContextPath()%>/UsuarioServlet">
                        Mis viajes
                    </b>
                </li>
                <li class="nav-item">
                </li>

                <div class="form-inline font-italic my-2 my-lg-0">
                    <% if (empleadoLogueado.getIdcodigo() != 0) { %>
                    BIENVENIDO <%=empleadoLogueado.getNombre()%> <%=empleadoLogueado.getApellido()%>
                    (<a href="<%=request.getContextPath()%>/LoginServlet?action=logout">Cerrar sesión</a>)
                    <% } %>
                </div>
            </ul>
        </div>
    </div>
</nav>
