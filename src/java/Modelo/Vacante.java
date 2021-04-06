/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author user
 */
public class Vacante {
    private int idVacante;
    private String fecInicio;
    private String comentarios;
    private int idCatedra;
    

    public Vacante(int idVacante, String fecInicio, String comentarios, int idCatedra) {
        this.idVacante = idVacante;
        this.fecInicio = fecInicio;
        this.comentarios = comentarios;
        
    }

    public Vacante() {
       
    }

    public int getIdCatedra() {
        return idCatedra;
    }

    public void setIdCatedra(int idCatedra) {
        this.idCatedra = idCatedra;
    }


    public int getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(int idVacante) {
        this.idVacante = idVacante;
    }

    public String getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(String fecInicio) {
        this.fecInicio = fecInicio;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    
    
}
