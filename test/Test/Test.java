/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import Utils.ConexionSingleton;
import controller.IReservaDao;
import controllerImpl.ReservaDaoImpl;

import java.sql.*;
import java.util.List;
import model.Cliente;
import model.Reserva;
import model.Usuario;

public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test t = new Test();
        // t.testConexion();
        // t.listReservas();
        // t.insert();
        // t.delete();
        // t.SearchById();
        t.update();
    }
    //metodo para testear la conexion a la bd

    public void testConexion() {
        ConexionSingleton c = new ConexionSingleton();
        try {
            Connection connection = c.getConnection();
            if (connection != null && !connection.isClosed()) {
                System.out.println("Conexion satisfatoria");
            } else {
                System.out.println("No se puede establecer conexion");
            }
        } catch (Exception e) {
            System.out.println("Error de conexion" + e.getMessage());
            e.printStackTrace();
        }
    }
    //listar

    public void listReservas() {
        IReservaDao reservaDao = new ReservaDaoImpl();

        List<Reserva> listaReserva = reservaDao.listAll();
        if (listaReserva != null && !listaReserva.isEmpty()) {
            for (Reserva reserva : listaReserva) {
                System.out.println("idReserva:" + reserva.getIdReserva());
                System.out.println("FechaIngreso:" + reserva.getFechaIngreso());
                System.out.println("FechaSalida:" + reserva.getFechaSalida());
                System.out.println("NumeroPiso:" + reserva.getNumeroPiso());
                System.out.println("NumHabitacion:" + reserva.getNumeroHabitacion());
                System.out.println("Costo:" + reserva.getCosto());
                System.out.println("Estado:" + reserva.getEstado());
                System.out.println("Cliente:" + reserva.getCliente().getNombre());
                System.out.println("Usuario:" + reserva.getUsuario().getUser());

            }
        }

    }

    //insertar
    public void insert() {

        Reserva r = new Reserva();
        Cliente c = new Cliente();
        Usuario u = new Usuario();
        r.setFechaIngreso("10/10/2024");
        r.setFechaSalida("13/10/2024");
        r.setNumeroPiso("3");
        r.setNumeroHabitacion(302);
        r.setCosto(80.00);
        r.setEstado("R");
        c.setIdcliente(1);
        u.setIdUsuario(1);
        r.setCliente(c);
        r.setUsuario(u);

        IReservaDao reservaDao = new ReservaDaoImpl();
        boolean result = reservaDao.insert(r);

        if (result) {
            System.out.println("success!!!");
        } else {
            System.out.println("error");
        }

    }

    public void delete() {
        Reserva r = new Reserva();
        r.setIdReserva(2);

        IReservaDao reservaDao = new ReservaDaoImpl();
        boolean result = reservaDao.delete(r);

        if (result) {
            System.out.println("success delete!!!");
        } else {
            System.out.println("error");
        }

    }

    public void SearchById() {
        IReservaDao reservaDao = new ReservaDaoImpl();

        Reserva r = reservaDao.searchById(1);
        if (r != null) {
            System.out.println("idReserva:" + r.getIdReserva());
            System.out.println("FechaIngreso:" + r.getFechaIngreso());
            System.out.println("FechaSalida:" + r.getFechaSalida());
            System.out.println("NumeroPiso:" + r.getNumeroPiso());
            System.out.println("NumHabitacion:" + r.getNumeroHabitacion());
            System.out.println("Costo:" + r.getCosto());
            System.out.println("Estado:" + r.getEstado());
            System.out.println("Cliente:" + r.getCliente().getNombre());
        } else {
            System.out.println("no existe ese Id");
        }
    }

    public void update() {
        Reserva r = new Reserva();
        Cliente c = new Cliente();
        Usuario u = new Usuario();
        r.setFechaIngreso("10/10/2024");
        r.setFechaSalida("13/10/2024");
        r.setNumeroPiso("3");
        r.setNumeroHabitacion(302);
        r.setCosto(80.00);
        r.setEstado("P");
        c.setIdcliente(1);
        u.setIdUsuario(1);
        r.setCliente(c);
        r.setUsuario(u);
        r.setIdReserva(4);

        IReservaDao reservaDao = new ReservaDaoImpl();
        boolean result = reservaDao.update(r);

        if (result) {
            System.out.println("success update!!!");
        } else {
            System.out.println("error");
        }

    }

}
