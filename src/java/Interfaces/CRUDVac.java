/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Catedra;
import Modelo.Postulacion;
import Modelo.Usuario;
import Modelo.Vacante;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDVac extends CRUD<Vacante>{
    public boolean registrarNuevoPostulante(Usuario u, Vacante v);
    public List verPorCatedra(Catedra c);
}
