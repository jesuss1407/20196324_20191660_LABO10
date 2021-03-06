package com.example.laboratorio10_grupo3.Servlets;
import com.example.laboratorio10_grupo3.Daos.EstudianteDao;
import com.example.laboratorio10_grupo3.Daos.ViajesDao;
import com.example.laboratorio10_grupo3.Beans.ViajesBean;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Random;

@WebServlet(name = "ViajesServlet", value = {"/ViajesServlet"})
public class ViajesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listarViaje" : request.getParameter("action");
        ViajesDao viajesDao = new ViajesDao();
        RequestDispatcher view;
        switch (action) {
            case "listarViaje":
                String correo = request.getParameter("username");
                int estudiantes_idcodigo = viajesDao.obteneridCorreo(correo);
                request.setAttribute("listaViaje", viajesDao.listarViaje(estudiantes_idcodigo));
                view = request.getRequestDispatcher("lista.jsp");
                view.forward(request, response);
                break;


            case "listarUnSoloViaje":
                int idviaje= Integer.parseInt(request.getParameter("id"));
                int codigo2 = Integer.parseInt(request.getParameter("codigoid"));
                request.setAttribute("listaUnSoloViaje", viajesDao.listarUnSoloViaje(idviaje));
                request.setAttribute("codigo",codigo2);
                view = request.getRequestDispatcher("editarViaje.jsp");
                view.forward(request, response);
                break;


            case "agregarViaje":
                int codigo = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("codigo", codigo);
                view = request.getRequestDispatcher("agregarViaje.jsp");
                view.forward(request, response);
                break;

            case "borrar":
                if (request.getParameter("id") != null) {
                    String idcompraviajesString = request.getParameter("id");
                    String estudiantes_idcodigoString = request.getParameter("codigoid");
                    String idviajesString = request.getParameter("id");
                    int idcompraviajes = 0;
                    int estudiantesidcodigo = 0;
                    int idviajes = 0;
                    try {
                        idcompraviajes = Integer.parseInt(idcompraviajesString);
                        estudiantesidcodigo = Integer.parseInt(estudiantes_idcodigoString);
                        idviajes = Integer.parseInt(idviajesString);
                        request.setAttribute("listaViaje", viajesDao.listarViaje(estudiantesidcodigo));
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("ViajesServlet");
                    }

                    ViajesBean viaje1 = viajesDao.obtenerCompraViaje(estudiantesidcodigo, idviajes);
                    ViajesBean viaje2 = viajesDao.obtenerViaje(idviajes);

                    if ( viaje2 != null) {
                        viajesDao.borrarcompraViajes(estudiantesidcodigo, idviajes);
                        viajesDao.borrarViaje(idviajes);
                    }
                }

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        ViajesDao viajesDao = new ViajesDao();
        Random random = new Random();

        int value = random.nextInt(99999999 + 10000000) + 10000000;



        switch (action){
            case "crear":
                String code = request.getParameter("idd");
                int idcodigo = Integer.parseInt(code);
                int idviajes= value;
                String fecha_reserva= request.getParameter("fecha_reserva");
                String fecha_viaje=request.getParameter("fecha_viaje");
                String ciudad_origen= request.getParameter("ciudad_origen");
                String ciudad_destino=request.getParameter("ciudad_destino");
                int cantidadcompra = Integer.parseInt(request.getParameter("cantidadcompra"));
                String seguro=request.getParameter("seguro");
                int costo_total=200*cantidadcompra;;

                viajesDao.crear1(idviajes,fecha_viaje,ciudad_origen,ciudad_destino,costo_total,seguro);
                viajesDao.crear2(idcodigo,idviajes,cantidadcompra);


                response.sendRedirect(request.getContextPath()+"/ViajesServlet?action=agregarViaje");
                break;

            case "actualizar":
                String code2 = request.getParameter("idd");
                ViajesBean viaje = new ViajesBean();
                viaje.setFecha_viaje(request.getParameter("fecha"));
                viaje.setCiudad_origen(request.getParameter("ciudad_origen"));
                viaje.setCiudad_destino(request.getParameter("ciudad_destino"));
                viaje.setSeguro(request.getParameter("seguro"));

                int idviajes2 = Integer.parseInt(code2);
                viaje.setIdviajes(idviajes2);
                int cantidadcompra2 = Integer.parseInt(request.getParameter("cantidadcompra"));
                int costo_total2=200*cantidadcompra2;;
                viaje.setIdviajes(costo_total2);

                viajesDao.actualizarViaje(viaje);
                viajesDao.actualizarViaje2(idviajes2,cantidadcompra2);

                response.sendRedirect("ViajesServlet?action=listar");

                break;

        }
    }
}

