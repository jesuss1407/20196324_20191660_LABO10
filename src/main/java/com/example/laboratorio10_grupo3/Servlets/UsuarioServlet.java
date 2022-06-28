package com.example.laboratorio10_grupo3.Servlets;
import com.example.laboratorio10_grupo3.Beans.EstudianteBean;
import com.example.laboratorio10_grupo3.Daos.EstudianteDao;

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

@WebServlet(name = "UsuarioServlet", value = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        RequestDispatcher view;
        EstudianteDao estudianteDao = new EstudianteDao();

        switch (action) {
            case "lista":
                //request.setAttribute("listaEmpleados", estudianteDao.listarViajes());
                view = request.getRequestDispatcher("lista.jsp");
                view.forward(request, response);
                break;
            case "agregar":
                view = request.getRequestDispatcher("/usuarioNuevo.jsp");
                view.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        EstudianteDao estudianteDao = new EstudianteDao();
        switch (action){
            case "crear":

            int idcodigo=Integer.parseInt(request.getParameter("idcodigo"));
            String nombre= request.getParameter("nombre");
            String apellido=request.getParameter("apellido");
            int edad = Integer.parseInt(request.getParameter("edad"));
            String especialidad=request.getParameter("especialidad");
            String correo=request.getParameter("correo");
            String contrasena_hashed=request.getParameter("contrasena");


            estudianteDao.crear(idcodigo,nombre,apellido,edad,especialidad,correo,contrasena_hashed);
            response.sendRedirect(request.getContextPath()+"/LoginServlet");
            break;

        }
    }
}