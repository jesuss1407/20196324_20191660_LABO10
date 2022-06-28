package com.example.laboratorio10_grupo3.Daos;
import  com.example.laboratorio10_grupo3.Beans.ViajesBean;
import java.sql.*;
import java.util.ArrayList;
public class ViajesDao extends DaoBase {
    public ArrayList<ViajesBean> listar(int estudiantes_idcodigo){

        ArrayList<ViajesBean> listaViajes = new ArrayList<>();
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
                    p.setIdviajes(Integer.parseInt(resultSet.getString(1)));
                    p.setFecha_reserva(resultSet.getString(2));
                    p.setFecha_viaje(resultSet.getString(3));
                    p.setCiudad_origen(resultSet.getString(4));
                    p.setCiudad_destino(resultSet.getString(5));
                    p.setSeguro(resultSet.getString(6));
                    p.setCantidadcompra(Integer.parseInt(resultSet.getString(7)));
                    p.setCosto_total(Integer.parseInt(resultSet.getString(8)));

                    listaViajes.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }
        return listaViajes;
    }

}
