/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Config.Conexion;
import Modelo.JefeCatedra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author user
 */
public interface CRUDJef extends CRUD<JefeCatedra> {

    public List verCatedras(JefeCatedra j);
    
}
