/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;

import Interfaces.CRUDCar;
import Interfaces.CRUDCat;
import Modelo.Carrera;
import Modelo.Catedra;
import Modelo.Persona;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ariel
 * lógica de negocio conectada con la DB
 */
public class CatedraDAO implements CRUDCat{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Catedra c = new Catedra();
    Persona p = new Persona();
    Usuario u = new Usuario();
    @Override
    public List listar() {
        ArrayList <Carrera> list=new ArrayList<>();
        String sql = "SELECT * FROM carrera";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Carrera car = new Carrera();
                car.setIdCarrera(rs.getInt("idCarrera"));
                car.setNombreCarrera(rs.getString("nombreCarrera"));
                list.add(car);
                
            }
        } catch (Exception e) {
        }
        return list;
        
    }

    @Override
    public Catedra list(int id) {
        String sql = "SELECT * FROM catedra WHERE idCatedra="+id+";";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setIdCatedra(rs.getInt("idCatedra"));
                c.setNombreCatedra(rs.getString("nombreCatedra"));
                c.setIdJefe(rs.getInt("idJefeCatedra"));
                
            }
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean add(Catedra c) {
        String sql = "";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Catedra c) {
        String sql = "";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Actualización exitosa");
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "DELETE FROM carrera WHERE idCarrera="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        return false;
    }

    public static void main(String[] args) {
        CarreraDAO daoC = new CarreraDAO();
        

    }




}

