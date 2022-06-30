package com.example.laboratorio10_grupo3.Daos;
import  com.example.laboratorio10_grupo3.Beans.ViajesBean;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ViajesDao extends DaoBase {
    public ArrayList<ViajesBean> listarViaje(int estudiantes_idcodigo){

        ArrayList<ViajesBean> listaViaje = new ArrayList<>();
        String sql = "select v.idviajes, cv.fecha_reserva, v.fecha_viaje, v.ciudad_origen, v.ciudad_destino, v.seguro, cv.cantidadcompra, cv.cantidadcompra*(v.costo_unitario),cv.estudiantes_idcodigo\n" +
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
                    p.setEstudiantes_idcodigo(resultSet.getInt(9));

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

    public void borrarcompraViajes(int estudiantes_idcodigo ,int idviajes) {
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM compraviajes WHERE estudiantes_idcodigo = ? and viajes_idviajes = ?")) {

            pstmt.setInt(1, estudiantes_idcodigo);
            pstmt.setInt(2, idviajes);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void borrarViaje(int idviajes) {
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM viajes WHERE idviajes = ?")) {

            pstmt.setInt(1, idviajes);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public ViajesBean obtenerCompraViaje(int estudiantes_idcodigo ,int idcompraviajes) {

        ViajesBean p = null;

        String sql = "select * FROM compraviajes WHERE estudiantes_idcodigo = ? and idcompraviajes = ?; ";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, estudiantes_idcodigo);
            pstmt.setInt(2, idcompraviajes);

            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()) {
                    p = new ViajesBean();
                    p.setEstudiantes_idcodigo(rs.getInt(1));
                    p.setViajes_idviajes(rs.getInt(2));
                    p.setIdcompraviajes(rs.getInt(3));
                    p.setCantidadcompra(rs.getInt(4));
                    p.setFecha_reserva(rs.getString(5));
                }
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión obteneter super!");
            e.printStackTrace();
        }
        return p;

    }
    public ViajesBean obtenerViaje(int idviajes) {

        ViajesBean p = null;

        String sql = "select * FROM viajes WHERE  idviajes = ?  ";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idviajes);

            try (ResultSet rs = pstmt.executeQuery();) {
                while (rs.next()){
                    p = new ViajesBean();
                    p.setIdviajes(rs.getInt(1));
                    p.setFecha_viaje(rs.getString(2));
                    p.setCiudad_origen(rs.getString(3));
                    p.setCiudad_destino(rs.getString(4));
                    p.setCosto_unitario(rs.getInt(5));
                    p.setSeguro(rs.getString(6));
                }
            }

        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión en obtenerViaje!");
            e.printStackTrace();
        }
        return p;

    }

    public void actualizarViaje(ViajesBean viaje) {
        String sql = "update viajes set fecha_viaje = ?, ciudad_origen=?, ciudad_destino=?, costo_unitario= ?,seguro= ?\n" +
                "                where idviajes= ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, viaje.getFecha_viaje());
            pstmt.setString(2, viaje.getCiudad_origen());
            pstmt.setString(3, viaje.getCiudad_destino());
            pstmt.setInt(4, viaje.getCosto_total());
            pstmt.setString(5, viaje.getSeguro());
            pstmt.setInt(6, viaje.getIdviajes());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Hubo un error en la conexión obteneter actualizar!");
            ex.printStackTrace();
        }
    }
    public void actualizarViaje2(int idviaje, int cantidadcompra) {
        String sql = "update compraviajes set cantidadcompra= ?\n" +
                "                where viajes_idviajes= ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, cantidadcompra);
            pstmt.setInt(2, idviaje);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Hubo un error en la conexión obteneter actualizar!");
            ex.printStackTrace();
        }
    }



    public ArrayList<ViajesBean> listarUnSoloViaje(int idviaje){

        ArrayList<ViajesBean> listaUnSoloViaje = new ArrayList<>();
        String sql = "select v.idviajes, cv.fecha_reserva, v.fecha_viaje, v.ciudad_origen, v.ciudad_destino, v.seguro, cv.cantidadcompra, cv.cantidadcompra*(v.costo_unitario),cv.estudiantes_idcodigo\n" +
                "                from compraviajes cv \n" +
                "                left join viajes v on cv.viajes_idviajes = v.idviajes\n" +
                "                where v.idviajes=?;";


        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){

            pstmt.setInt(1, idviaje);

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
                    p.setEstudiantes_idcodigo(resultSet.getInt(9));

                    listaUnSoloViaje.add(p);
                }
            }
        } catch (SQLException e) {
            System.out.println("Hubo un error en la conexión!");
            e.printStackTrace();
        }
        return listaUnSoloViaje;
    }

}
