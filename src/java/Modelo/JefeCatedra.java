/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author user
 */
public class JefeCatedra extends Usuario {
    private int idJefe;

    public JefeCatedra(String nombre, String apellido, int dni, String email, String username, String pass) {
        
    }

    public JefeCatedra() {
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }
    
    
    
}
