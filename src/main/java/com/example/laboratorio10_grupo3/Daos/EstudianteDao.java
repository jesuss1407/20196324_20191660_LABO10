package com.example.laboratorio10_grupo3.Daos;

import java.sql.*;
import java.util.ArrayList;

import com.example.laboratorio10_grupo3.Beans.EstudianteBean;
import com.example.laboratorio10_grupo3.Daos.EstudianteDao;

public class EstudianteDao extends DaoBase {

    public EstudianteBean obtenerUsuario(int idcodigo) {

        EstudianteBean estudiante = null;

        String sql = "SELECT * FROM estudiantes WHERE idcodigo = ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, idcodigo);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    estudiante = new EstudianteBean();
                    estudiante.setIdcodigo(rs.getInt(1));
                    estudiante.setNombre(rs.getString(2));
                    estudiante.setApellido(rs.getString(3));
                    estudiante.setEdad(rs.getInt(4));
                    estudiante.setEspecialidad(rs.getString(5));
                    estudiante.setStatus(rs.getString(6));

                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return estudiante;
    }

    public EstudianteBean validarUsuarioPassword(String usuario, String contrasena) {

        EstudianteBean estudiante = null;

        //String sql = "select * from employees_credentials where email = ? and password = sha2(?,256);";
        String sql = "select * from credenciales_estudiantes where correo = ? and contrasena_hashed = sha2(?,256);";
        try (Connection connection = this.getConection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, usuario);
            pstmt.setString(2, contrasena);

            try (ResultSet rs = pstmt.executeQuery();) {
                if (rs.next()) {
                    estudiante = this.obtenerUsuario(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return estudiante;
    }

    public ArrayList<EstudianteBean> listarViajes() {

    }

}