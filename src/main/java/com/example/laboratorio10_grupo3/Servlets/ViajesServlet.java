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
                String correo= request.getParameter("username");
                int estudiantes_idcodigo = viajesDao.obteneridCorreo(correo);

                request.setAttribute("listaViaje", viajesDao.listarViaje(estudiantes_idcodigo));
                view = request.getRequestDispatcher("lista.jsp");
                view.forward(request, response);
                break;


            case "agregarViaje":
                int codigo= Integer.parseInt(request.getParameter("id"));
                request.setAttribute("codigo",codigo);
                view = request.getRequestDispatcher("agregarViaje.jsp");
                view.forward(request, response);
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

                String code = request.getParameter("idcodigo");
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

        }
    }
}

