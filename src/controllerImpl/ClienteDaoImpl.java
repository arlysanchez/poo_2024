/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllerImpl;

import Utils.ConexionSingleton;
import controller.IClientDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Reserva;

/**
 *
 * @author tpp
 */
public class ClienteDaoImpl implements IClientDao{

       private Connection cn;
    @Override
    public boolean insert(Cliente c) {
        boolean flag = false;

        PreparedStatement st;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;

        try {
            query = " INSERT INTO cliente (nombre, apellidos, dni, email, genero) VALUES (?, ?, ?, ?, ?);";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);

            st.setString(1, c.getNombre());
            st.setString(2, c.getApellidos());
            st.setString(3, c.getDni());
            st.setString(4, c.getEmail());
            st.setString(5, c.getGenero());
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("Error al insertar un cliente" + e.getMessage());
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
    public boolean update(Cliente c) {
        boolean flag = false;

        PreparedStatement st;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;

        try {
            query = "UPDATE cliente SET nombre = ?, apellidos = ?, dni = ?, email = ? , genero = ? "
                    + " WHERE idcliente = ?;";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);

            st.setString(1, c.getNombre());
            st.setString(2, c.getApellidos());
            st.setString(3, c.getDni());
            st.setString(4, c.getEmail());
            st.setString(5, c.getGenero());
            st.setInt(6, c.getIdcliente());
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("Error al actualizar un cliente" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            flag = false;
            System.out.println("Error, No se pudo actualizar el registro");
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
    public Cliente searchById(int id) {
        
        Cliente cl = null;
        PreparedStatement st;
        //resultado que devuelve los datos de la base de datos
        ResultSet rs;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;
        try {
            //sentencia de sql para traer todas las reservas
            query = "SELECT * FROM cliente WHERE idcliente = ?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            st.setInt(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                cl = new Cliente();

                cl.setIdcliente(rs.getInt("idcliente"));
                cl.setNombre(rs.getString("nombre"));
                cl.setApellidos(rs.getString("apellidos"));
                cl.setDni(rs.getString("dni"));
                cl.setEmail(rs.getString("email"));
                cl.setGenero(rs.getString("genero"));
                
            }
            
        } catch (Exception e) {
            System.out.println("Error al buscar un cliente" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            
            System.out.println("Error, No se pudo buscar un cliente por ID");
        } finally {
            if (cn != null) {
                try {
                } catch (Exception e) {
                }
            }
        }
        return cl;
        
    }

    @Override
    public boolean delete(Cliente c) {
        boolean flag = false;

        PreparedStatement st;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;

        try {
            query = "DELETE FROM cliente WHERE idcliente = ?";
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);

            st.setInt(1, c.getIdcliente());
            st.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("Error al eliminar un cliente" + e.getMessage());
            try {
                cn.rollback();
            } catch (Exception ex) {
            }
            flag = false;
            System.out.println("Error, No se pudo eliminar un cliente por ID");
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
    public List<Cliente> listAll() {
        //declaracion de un arreglo
        List<Cliente> lista = null;
        //declar la clase cliente
        Cliente cl;
        PreparedStatement st;
        //resultado que devuelve los datos de la base de datos
        ResultSet rs;
        //declaro la variable que va contener la consulta a la base de datos
        String query = null;

        try {
            //sentencia de sql para traer todas las reservas
            query = "SELECT * FROM cliente ";
            // sobreescribir la lista en un arreglo
            lista = new ArrayList<>();
            cn = ConexionSingleton.getConnection();
            st = cn.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                cl = new Cliente();
                
                cl.setNombre(rs.getString("nombre"));
                cl.setApellidos(rs.getString("apellidos"));
                cl.setDni(rs.getString("dni"));
                cl.setEmail(rs.getString("email"));
                cl.setGenero(rs.getString("genero"));
                lista.add(cl);
            }
        } catch (Exception e) {
            System.out.println("Error al listar a las cliente" + e.getMessage());
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
