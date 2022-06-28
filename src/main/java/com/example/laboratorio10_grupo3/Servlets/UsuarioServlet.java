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

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet", ""})
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
        }
    }
}