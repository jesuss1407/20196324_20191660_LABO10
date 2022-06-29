<%--
  Created by IntelliJ IDEA.
  User: Jorge
  Date: 28/06/2022
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/includes/headCss.jsp"></jsp:include>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.laboratorio10_grupo3.Beans.ViajesBean" %>
<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="listaViaje" scope="request" type="java.util.ArrayList<com.example.laboratorio10_grupo3.Beans.ViajesBean>" />


<html>

<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Menu Viajes"/>
</jsp:include>
<body>
<div class='container'>

    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="Viajes"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor d-flex justify-content-between align-items-center">
        <div class="col-lg-6">
            <br>
            <br>
            <h1 class='text-light'>Historial de viajes</h1>

        </div>

    </div>
    <div class="tabla">

        <br>
        <br>
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <tr>
                <th># IDENTIF.</th>
                <th>FECHA RESERVA</th>
                <th>FECHA VIAJE</th>
                <th></th>
                <th>CIUDAD ORIGEN</th>
                <th></th>
                <th>CIUDAD DESTINO</th>
                <th></th>
                <th>EMPRESA DE SEGUROS</th>
                <th># DE BOLETOS</th>
                <th> </th>
                <th>COSTO TOTAL</th>


            </tr>
            </thead>
            <tbody>


            <%for (ViajesBean viaje : listaViaje){ %>
            <tr>
                <td><%=viaje.getIdviajes()%></td>
                <td><%=viaje.getFecha_reserva()%></td>
                <td><%=viaje.getFecha_viaje()%></td>
                <td></td>
                <td><%=viaje.getCiudad_origen()%></td>
                <td></td>
                <td><%=viaje.getCiudad_destino()%> </td>
                <td></td>
                <td><%=viaje.getSeguro()%> </td>
                <td><%=viaje.getCantidadcompra()%> </td>
                <td></td>
                <td><%=viaje.getCosto_total()%> </td>




            </tr>
            <%}%>

            </tbody>
        </table>

    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
