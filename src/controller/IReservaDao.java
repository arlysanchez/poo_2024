/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.List;
import model.Reserva;

/**
 *
 * @author tpp
 */
public interface IReservaDao {
    
    //metod para insert una reserva
    public boolean insert(Reserva reserva);
    //metodo para actualizar
    public boolean update(Reserva reserva);
    //metodo para buscar por Id
    public Reserva searchById(int id);
    //metodo para eliminar la reserva
    public boolean delete(Reserva reserva);
    //metodo para listar las reservas
    public List<Reserva> listAll();
    
    
    
}
