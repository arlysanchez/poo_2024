/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllerImpl;

import Utils.ConexionSingleton;
import controller.IReservaDao;
import java.util.List;
import model.Reserva;
import java.sql.*;
import java.util.ArrayList;
import model.Cliente;
import model.Usuario;

public class ReservaDaoImpl implements IReservaDao {

    private Connection cn;

    @Override
    public boolean insert(Reserva reserva) {
        boolean flag = false;

        PreparedStatement st;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;

        try {
            query = " INSERT INTO reserva (fechaIngreso, fechaSalida, numeroPiso,"
                    + " numeroHabitacion, costo, estado, clienteId, usuarioId)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);

            st.setString(1, reserva.getFechaIngreso());
            st.setString(2, reserva.getFechaSalida());
            st.setString(3, reserva.getNumeroPiso());
            st.setInt(4, reserva.getNumeroHabitacion());
            st.setDouble(5, reserva.getCosto());
            st.setString(6, reserva.getEstado());
            st.setInt(7, reserva.getCliente().getIdcliente());
            st.setInt(8, reserva.getUsuario().getIdUsuario());
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("Error al insertar una reserva" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            flag = false;
            System.out.println("Error, No se pudo agregar el registro");
        } finally {
            if (cn != null) {
                try {
                } catch (Exception e) {
                }
            }
        }

        return flag;

    }

    @Override
    public boolean update(Reserva reserva) {
        boolean flag = false;

        PreparedStatement st;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;

        try {
            query = "UPDATE reserva SET fechaIngreso = ?, fechaSalida = ?, numeroPiso = ?, "
                    + " numeroHabitacion = ?, costo = ?, estado = ?, clienteId = ? "
                    + " WHERE idReserva = ?;";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);

            st.setString(1, reserva.getFechaIngreso());
            st.setString(2, reserva.getFechaSalida());
            st.setString(3, reserva.getNumeroPiso());
            st.setInt(4, reserva.getNumeroHabitacion());
            st.setDouble(5, reserva.getCosto());
            st.setString(6, reserva.getEstado());
            st.setInt(7, reserva.getCliente().getIdcliente());
            st.setInt(8, reserva.getIdReserva());
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("Error al insertar una reserva" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            flag = false;
            System.out.println("Error, No se pudo agregar el registro");
        } finally {
            if (cn != null) {
                try {
                } catch (Exception e) {
                }
            }
        }

        return flag;

    }

    @Override
    public Reserva searchById(int id) {
        Reserva re = null;
        Cliente cl;
        PreparedStatement st;
        //resultado que devuelve los datos de la base de datos
        ResultSet rs;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;
        try {
            //sentencia de sql para traer todas las reservas
            query = "SELECT r.idReserva, r.fechaIngreso,r.fechaSalida,"
                    + " r.numeroPiso, r.numeroHabitacion, r.costo, r.estado,"
                    + " c.nombre,u.user FROM reserva r, cliente c, usuario u"
                    + " where r.clienteId = c.idcliente"
                    + " AND r.usuarioId = u.idusuario "
                    + " AND r.idReserva = ?;";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                re = new Reserva();
                cl = new Cliente();

                re.setIdReserva(rs.getInt("idReserva"));
                re.setFechaIngreso(rs.getString("fechaIngreso"));
                re.setFechaSalida(rs.getString("fechaSalida"));
                re.setNumeroPiso(rs.getString("numeroPiso"));
                re.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
                re.setCosto(rs.getDouble("costo"));
                re.setEstado(rs.getString("estado"));
                cl.setNombre(rs.getString("nombre"));
                re.setCliente(cl);
            }
            
        } catch (Exception e) {
            System.out.println("Error al buscar una reserva" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            
            System.out.println("Error, No se pudo buscar la reserva por ID");
        } finally {
            if (cn != null) {
                try {
                } catch (Exception e) {
                }
            }
        }
        return re;
    }

    @Override
    public boolean delete(Reserva reserva) {
         boolean flag = false;

        PreparedStatement st;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;

        try {
            query = "DELETE FROM reserva WHERE idReserva = ?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);

            st.setInt(1, reserva.getIdReserva());
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("Error al eliminar una reserva" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            flag = false;
            System.out.println("Error, No se pudo eliminar la reserva por ID");
        } finally {
            if (cn != null) {
                try {
                } catch (Exception e) {
                }
            }
        }

        return flag;
    }

    @Override
    public List<Reserva> listAll() {
        //declaracion de un arreglo
        List<Reserva> lista = null;
        //declar la clase reserva
        Reserva re;
        //declar la clase cliente
        Cliente cl;
        //declaro el que para la consulta a la base de datos
        Usuario us;
        PreparedStatement st;
        //resultado que devuelve los datos de la base de datos
        ResultSet rs;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;

        try {
            //sentencia de sql para traer todas las reservas
            query = "SELECT r.idReserva, r.fechaIngreso,r.fechaSalida,"
                    + " r.numeroPiso, r.numeroHabitacion, r.costo, r.estado,"
                    + " c.nombre,u.user FROM reserva r, cliente c, usuario u"
                    + " where r.clienteId = c.idcliente"
                    + " AND r.usuarioId = u.idusuario;";
            // sobreescribir la lista en un arreglo
            lista = new ArrayList<>();
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                re = new Reserva();
                cl = new Cliente();
                us = new Usuario();

                re.setIdReserva(rs.getInt("idReserva"));
                re.setFechaIngreso(rs.getString("fechaIngreso"));
                re.setFechaSalida(rs.getString("fechaSalida"));
                re.setNumeroPiso(rs.getString("numeroPiso"));
                re.setNumeroHabitacion(rs.getInt("numeroHabitacion"));
                re.setCosto(rs.getDouble("costo"));
                re.setEstado(rs.getString("estado"));
                cl.setNombre(rs.getString("nombre"));
                us.setUser(rs.getString("user"));
                re.setCliente(cl);
                re.setUsuario(us);
                lista.add(re);
            }
        } catch (Exception e) {
            System.out.println("Error al listar a las reservas" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }

        } finally {

            if (cn != null) {
                try {
                } catch (Exception e) {
                }
            }

        }
        return lista;

    }

}
