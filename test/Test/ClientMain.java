/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Test;

import controller.IClientDao;
import controller.IReservaDao;
import controllerImpl.ClienteDaoImpl;
import controllerImpl.ReservaDaoImpl;
import java.util.List;
import model.Cliente;
import model.Reserva;
import model.Usuario;

/**
 *
 * @author tpp
 */
public class ClientMain {

    public static void main(String[] args) {
        ClientMain c = new ClientMain();
        // c.listCliente();
       // c.insert();
        // c.delete();
        c.SearchById();
    }

    public void listCliente() {
        IClientDao Cl = new ClienteDaoImpl();

        List<Cliente> listaCliente = Cl.listAll();
        if (listaCliente != null && !listaCliente.isEmpty()) {
            for (Cliente cliente : listaCliente) {
                System.out.println("nombre: " + cliente.getNombre());
                System.out.println("nombre: " + cliente.getApellidos());
                System.out.println("nombre: " + cliente.getDni());
                System.out.println("nombre: " + cliente.getGenero());
                System.out.println("nombre: " + cliente.getEmail());
            }
        }

    }

    public void insert() {

        Cliente c = new Cliente();

        c.setNombre("juan");
        c.setApellidos("PEREZ");
        c.setDni("65665556");
        c.setGenero("M");
        c.setEmail("pedro@gmail.com");

        IClientDao clienteDao = new ClienteDaoImpl();
        boolean result = clienteDao.insert(c);

        if (result) {
            System.out.println("success!!!");
        } else {
            System.out.println("error");
        }

    }

    public void delete() {
        Cliente c = new Cliente();
        c.setIdcliente(2);

        IClientDao clienteDao = new ClienteDaoImpl();
        boolean result = clienteDao.delete(c);

        if (result) {
            System.out.println("success delete!!!");
        } else {
            System.out.println("error");
        }

    }

    public void SearchById() {
        IClientDao clienteDao = new ClienteDaoImpl();
        Cliente c = clienteDao.searchById(3);
        if (c != null) {
            System.out.println("idcliente:" + c.getIdcliente());
            System.out.println("nombre:" + c.getNombre());
            System.out.println("apellido:" + c.getApellidos());
            System.out.println("genero:" + c.getGenero());
            System.out.println("dni:" + c.getDni());
            } else {
            System.out.println("no existe ese Id");
        }
    }
}
