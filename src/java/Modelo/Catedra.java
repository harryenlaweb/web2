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
public class Catedra {
    private int idCatedra;
    private String nombreCatedra;
    private int idJefe;
    private ArrayList<Usuario> listaDocentes; // Es de tipo usuario, porque un JefeCatedra (usuario) puede ser docente también.

    public Catedra(int idCatedra, String nombreCatedra, int idJefe, ArrayList<Usuario> listaDocentes) {
        this.idCatedra = idCatedra;
        this.nombreCatedra = nombreCatedra;
        this.idJefe = idJefe;
        this.listaDocentes = listaDocentes;
    }

    public Catedra() {
        
    }

    public ArrayList<Usuario> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(ArrayList<Usuario> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public int getIdCatedra() {
        return idCatedra;
    }

    public void setIdCatedra(int idCatedra) {
        this.idCatedra = idCatedra;
    }

    public String getNombreCatedra() {
        return nombreCatedra;
    }

    public void setNombreCatedra(String nombreCatedra) {
        this.nombreCatedra = nombreCatedra;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }
    
    
}
