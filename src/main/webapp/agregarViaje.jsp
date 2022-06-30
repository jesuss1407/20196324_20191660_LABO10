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

<%@ page import="java.util.Random" %>
<jsp:useBean id="codigo" scope="request" type="java.lang.Integer" />
<jsp:useBean id="empleadoLogueado" class="com.example.laboratorio10_grupo3.Beans.EstudianteBean"
             scope="session" type="com.example.laboratorio10_grupo3.Beans.EstudianteBean"/>
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
            <h1 class='text-light'>Añadir nuevo viaje</h1>
        </div>

    </div>
    <div class="tabla">
        <% String code = Integer.toString(codigo);%>
        <section class="vh-100 gradient-custom">
            <div class="container py-5 h-100">
                <div class="row justify-content-center align-items-center h-100">
                    <div class="col-12 col-lg-9 col-xl-7">
                        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
                            <div class="card-body p-4 p-md-5">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Datos de la compra</h3>

                                <form method="POST" action="ViajesServlet?action=crear&idd=<%= code%>">
                                    <input disabled class="form-control form-control-lg" id="idcodigo" name="idcodigo" value=<%=code%>>
                                    <br>
                                    <div class="row">
                                        <div class="col-md-6 mb-4 d-flex align-items-center">

                                            <div class="form-outline datepicker w-100">
                                                <input type="date" class="form-control form-control-lg" id="fecha_viaje" name="fecha_viaje" required />
                                                <label for="fecha_viaje" class="form-label">Fecha de ida</label>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <select class="select form-control-lg" id="seguro" name="seguro">
                                                    <option value="1" disabled>Escoge una opcion</option>
                                                    <option value="Rimac">Rimac</option>
                                                    <option value="Pacifico">Pacifico</option>
                                                    <option value="La Positiva">La Positiva</option>
                                                    <option value="Seguro Internacional">Seguro Internacional</option>
                                                    <option value="Otro">Otro</option>
                                                </select>
                                                <label class="form-label" for="seguro">Seguros</label>
                                            </div>

                                        </div>

                                    </div>


                                    <div class="row">
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <select class="select form-control-lg" id="ciudad_origen" name="ciudad_origen">
                                                    <option value="1" disabled>Escoge una opcion</option>
                                                    <option value="Lima">Lima</option>
                                                    <option value="Trujillo">Trujillo</option>
                                                    <option value="Cusco">Cusco</option>
                                                    <option value="Arequipa">Arequipa</option>
                                                </select>
                                                <label class="form-label" for="ciudad_origen">Ciudad de origen</label>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <select class="select form-control-lg" id="ciudad_destino" name="ciudad_destino">
                                                    <option value="1" disabled>Escoge una opcion</option>
                                                    <option value="Loreto">Loreto</option>
                                                    <option value="Tacna">Tacna</option>
                                                    <option value="Ica">Ica</option>
                                                    <option value="Chiclayo">Chiclayo</option>
                                                </select>
                                                <label class="form-label" for="ciudad_destino">Ciudad de destino</label>
                                            </div>

                                        </div>

                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <input type="number" id="cantidadcompra" name="cantidadcompra" class="form-control form-control-lg"  min="1" max="5" required/>
                                                <label class="form-label" for="cantidadcompra">Cantidad de boletos</label>
                                            </div>

                                        </div>
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <input type="tel" id="costo_total" name="costo_total" class="form-control form-control-lg" disabled value="200"/>
                                                <label class="form-label" for="costo_total">Costo por boleto</label>
                                            </div>

                                        </div>
                                    </div>


                                    <div class="mt-4 pt-2">
                                        <input href="<%=request.getContextPath()%>/LoginServlet" class="btn btn-primary btn-lg" type="submit" value="Agregar" />
                                    </div>

                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>
</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>

