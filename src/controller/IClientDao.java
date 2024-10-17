/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;
import model.Cliente;

public interface IClientDao {
    //metod para insert una reserva
    public boolean insert(Cliente c);
    //metodo para actualizar
    public boolean update(Cliente c);
    //metodo para buscar por Id
    public Cliente searchById(int id);
    //metodo para eliminar la reserva
    public boolean delete(Cliente c);
    //metodo para listar las reservas
    public List<Cliente> listAll();
    
}
