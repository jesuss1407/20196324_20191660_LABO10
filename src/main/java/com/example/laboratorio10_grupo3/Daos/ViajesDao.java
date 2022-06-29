package com.example.laboratorio10_grupo3.Daos;
import  com.example.laboratorio10_grupo3.Beans.ViajesBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViajesDao extends DaoBase {
    public ArrayList<ViajesBean> listarViaje(int estudiantes_idcodigo){

        ArrayList<ViajesBean> listaViaje = new ArrayList<>();
        String sql = "select v.idviajes, cv.fecha_reserva, v.fecha_viaje, v.ciudad_origen, v.ciudad_destino, v.seguro, cv.cantidadcompra, cv.cantidadcompra*(v.costo_unitario)\n" +
                "from compraviajes cv \n" +
                "left join viajes v on cv.viajes_idviajes = v.idviajes\n" +
                "where estudiantes_idcodigo= ?\n" +
                "group by cv.idcompraviajes;";


        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){

            pstmt.setInt(1, estudiantes_idcodigo);

            try (ResultSet resultSet = pstmt.executeQuery();) {
                while (resultSet.next()) {
                    ViajesBean p = new ViajesBean();
                    p.setIdviajes(resultSet.getInt(1));
                    p.setFecha_reserva(resultSet.getString(2));
                    p.setFecha_viaje(resultSet.getString(3));
                    p.setCiudad_origen(resultSet.getString(4));
                    p.setCiudad_destino(resultSet.getString(5));
                    p.setSeguro(resultSet.getString(6));
                    p.setCantidadcompra(resultSet.getInt(7));
                    p.setCosto_total(resultSet.getInt(8));

                    listaViaje.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }
        return listaViaje;
    }
    public int  obteneridCorreo(String correo) {

        Integer id = null;
        String sql = "select idcodigo from estudiantes where correo = ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setString(1, correo);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return id;
    }


    public void crear1(int idviajes,String fecha_viaje,String ciudad_origen,String ciudad_destino,int costo_total,String seguro)  {

        String sql = "INSERT INTO viajes (idviajes, fecha_viaje, ciudad_origen, ciudad_destino,costo_unitario,seguro)\n" +
                "                VALUES (?, ?,?, ?, ?, ? );";

        try(Connection conn= this.getConection();
            PreparedStatement pstmt= conn.prepareStatement(sql)){
            pstmt.setInt(1, idviajes);
            pstmt.setString(2, fecha_viaje);
            pstmt.setString(3,ciudad_origen);
            pstmt.setString(4 ,ciudad_destino);
            pstmt.setInt(5, costo_total);
            pstmt.setString(6, seguro);
            pstmt.executeUpdate();

        }catch(SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }


    }
    public void crear2(int estudiantes_idcodigo,int idviajes,int cantidadcompra)  {

        String sql = "INSERT INTO compraviajes (estudiantes_idcodigo,viajes_idviajes,cantidadcompra,fecha_reserva)\n" +
                "                VALUES (?, ?,?, current_date());";

        try(Connection conn= this.getConection();
            PreparedStatement pstmt= conn.prepareStatement(sql)){
            pstmt.setInt(1, estudiantes_idcodigo);
            pstmt.setInt(2, idviajes);
            pstmt.setInt(3,cantidadcompra);
            pstmt.executeUpdate();

        }catch(SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }


    }




}
