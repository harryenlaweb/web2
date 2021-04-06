/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author ariel
 */
public class Usuario {
    int id;
    String username;
    String password;
    String nombre;
    String apellido;
    int dni;
    String email;
    String codCV;

    public Usuario() {
    }

    public Usuario(int id, String username, String password, String nombre, String apellido, int dni, String email, String codCV) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.codCV = codCV;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void setCodCV(String codCV) {
        this.codCV = codCV;
        
    }
    public String getCodCV() {
        return this.codCV;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
    
    
    
}
