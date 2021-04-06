/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Postulacion;
import Modelo.Vacante;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDPost extends CRUD<Postulacion> {
    public List verPorVacante(Vacante v);
    
}
