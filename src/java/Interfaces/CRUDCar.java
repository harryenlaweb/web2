/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Carrera;
import Modelo.Persona;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author ariel
 */
public interface CRUDCar extends CRUD<Carrera> {
    public List verMaterias(Carrera c);

}
