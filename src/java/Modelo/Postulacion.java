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
public class Postulacion {
    private int idPostulacionVacante;
    private int idPostulante;
    private int ordenMerito;
    private int idVacante;
    public Postulacion(int idPostulante, int ordenMerito, int idVacante) {
        this.idPostulante = idPostulante;
        this.ordenMerito = ordenMerito;
        this.idVacante = idVacante;
    }

    public Postulacion() {
        
    }

    public int getIdPostulacionVacante() {
        return idPostulacionVacante;
    }

    public void setIdPostulacionVacante(int idPostulacionVacante) {
        this.idPostulacionVacante = idPostulacionVacante;
    }

    public int getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(int idVacante) {
        this.idVacante = idVacante;
    }
    

    public int getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(int idPostulante) {
        this.idPostulante = idPostulante;
    }

    public int getOrdenMerito() {
        return ordenMerito;
    }

    public void setOrdenMerito(int ordenMerito) {
        this.ordenMerito = ordenMerito;
    }
    
    
}
