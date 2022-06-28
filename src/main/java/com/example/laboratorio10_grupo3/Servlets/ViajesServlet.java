package com.example.laboratorio10_grupo3.Servlets;
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

@WebServlet(name = "ViajesServlet", value = {"/ViajesServlet"})
public class ViajesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "listar" : request.getParameter("action");
        ViajesDao viajesDao = new ViajesDao();
        switch (action) {
            case "listar":
                String estudiantes_idcodigo = request.getParameter("estudiantes_idcodigo");
                request.setAttribute("listaViajes", viajesDao.listar(Integer.parseInt(estudiantes_idcodigo)));
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
                requestDispatcher.forward(request, response);
                break;
        }
    }
}
