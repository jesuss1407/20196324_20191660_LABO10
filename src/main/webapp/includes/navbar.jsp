<%@ page import="com.example.webapphr2.Controllers.LoginServlet" %>
<% String currentPage = request.getParameter("currentPage"); %>


<jsp:useBean id="empleadoLogueado" class="com.example.webapphr2.Beans.Employee"
             scope="session" type="com.example.webapphr2.Beans.Employee"/>

<nav class="navbar navbar-expand-md navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="<%=request.getContextPath()%>">Gestión HR</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link <%=currentPage.equals("emp") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/EmployeeServlet">
                        Employees
                    </a>
                </li>
                <% if (empleadoLogueado.getEmployeeId() != 0) { %>
                <li class="nav-item">
                    <a class="nav-link <%=currentPage.equals("job") ? "active" : ""%>"
                       href="<%=request.getContextPath()%>/JobServlet">
                        Jobs
                    </a>
                </li>
                <% } %>
                <div class="form-inline font-italic my-2 my-lg-0">
                    <% if (empleadoLogueado.getEmployeeId() == 0) { %>
                    <a class="nav-link" style="color: #007bff;" href="<%=request.getContextPath()%>/LoginServlet">(Iniciar
                        Sesión)</a>
                    <% }else{ %>
                    Bienvenido <%=empleadoLogueado.getFirstName()%> <%=empleadoLogueado.getLastName()%>
                    (<a href="<%=request.getContextPath()%>/LoginServlet?action=logout">Cerrar sesión</a>)
                    <% } %>
                </div>
            </ul>
        </div>
    </div>
</nav>
