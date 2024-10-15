/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author tpp
 */
public class Usuario extends Persona{
    private int idUsuario;
    private String user;
    private String password;
    private String tipoUser;

    public Usuario() {
    }

    public Usuario(int idUsuario, String user, String password, String tipoUser, String nombre, String apellidos, String dni) {
        super(nombre, apellidos, dni);
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
        this.tipoUser = tipoUser;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
       
    
}
