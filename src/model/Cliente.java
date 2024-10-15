/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tpp JAST
 */
public class Cliente extends Persona{
    private int idCliente;
    private String email;
    private String genero;

    public Cliente() {
    }

    public Cliente(int idCliente, String email, String genero, String nombre, String apellidos, String dni) {
        super(nombre, apellidos, dni);
        this.idCliente = idCliente;
        this.email = email;
        this.genero = genero;
    }

    public int getIdcliente() {
        return idCliente;
    }

    public void setIdcliente(int idcliente) {
        this.idCliente = idcliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
  
    
    
    
}
