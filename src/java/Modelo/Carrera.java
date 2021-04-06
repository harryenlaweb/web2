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
public class Carrera {
    private int idCarrera;
    private String nombreCarrera;
    private ArrayList<Catedra> listaCatedras;

    public Carrera(int idCarrera, String nombreCarrera, ArrayList<Catedra> listaCatedras) {
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.listaCatedras = listaCatedras;
    }

    public Carrera() {
        
    }

    public ArrayList<Catedra> getListaCatedras() {
        return listaCatedras;
    }

    public void setListaCatedras(ArrayList<Catedra> listaCatedras) {
        this.listaCatedras = listaCatedras;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }
    
    
}
