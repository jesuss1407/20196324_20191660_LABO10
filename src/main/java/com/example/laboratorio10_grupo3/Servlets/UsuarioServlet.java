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
                view = request.getRequestDispatcher("/formularioNuevo.jsp");
                view.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EstudianteBean e = new EstudianteBean();
        e.setIdcodigo(Integer.parseInt(request.getParameter("idcodigo")));
        e.setNombre(request.getParameter("nombre"));
        e.setApellido(request.getParameter("apellido"));
        e.setEdad(Integer.parseInt(request.getParameter("edad")));
        e.setEspecialidad(request.getParameter("especialidad"));
        e.setCorreo(request.getParameter("coreo"));
        e.setContasena_hashed(request.getParameter("contrasena"));

        EstudianteDao estudianteDao = new EstudianteDao();
        if (request.getParameter("employee_id") == null) {
            try {
                estudianteDao.guardarUsuario(e);
                response.sendRedirect("UsuarioServlet?msg=Empleado creado exitosamente");
            } catch (SQLException ex) {
                response.sendRedirect("UsuarioServlet?err=Error al crear empleado");
            }

        }
    }
}