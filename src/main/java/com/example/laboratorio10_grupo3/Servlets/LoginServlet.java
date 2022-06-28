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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet", ""})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") != null ? request.getParameter("action") : "login";

        HttpSession session = request.getSession();

        switch (action){
            case "login":
                EstudianteBean estudiante = (EstudianteBean) session.getAttribute("usuarioLogueado");
                if(estudiante != null && estudiante.getIdcodigo() != 0){
                    response.sendRedirect(request.getContextPath());
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                    rd.forward(request, response);
                }
                break;
            case "logout":
                session.invalidate();
                response.sendRedirect(request.getContextPath());
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String usuario = request.getParameter("username");
        String contrasena = request.getParameter("password");

        EstudianteDao estudianteDao = new EstudianteDao();

        EstudianteBean estudiante = estudianteDao.validarUsuarioPassword(usuario, contrasena);

        if (estudiante != null) { //existe usuario y password
            HttpSession session = request.getSession();
            session.setAttribute("empleadoLogueado", estudiante);
            session.setMaxInactiveInterval(60 * 10);

            response.sendRedirect(request.getContextPath() + "/UsuarioServlet");
        } else {
            response.sendRedirect(request.getContextPath() + "/LoginServlet?error");
        }


    }
}