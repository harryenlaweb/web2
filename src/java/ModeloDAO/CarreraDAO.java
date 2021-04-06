/*
ESTE ES EL MODELO DB
 */
package ModeloDAO;

import Config.Conexion;

import Interfaces.CRUDCar;
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
public class CarreraDAO implements CRUDCar{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Carrera c = new Carrera();
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
    public Carrera list(int id) {
        String sql = "SELECT * FROM carrera WHERE idCarrera="+id+";";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setIdCarrera(rs.getInt("idCarrera"));
                c.setNombreCarrera(rs.getString("nombreCarrera"));
                
            }
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean add(Carrera c) {
        String sql = "INSERT INTO carrera(nombreCarrera) VALUES('"+c.getNombreCarrera()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Carrera c) {
        String sql = "UPDATE carrera SET nombreCarrera='"+c.getNombreCarrera()+"' WHERE id="+c.getIdCarrera();
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
    @Override
    public List verMaterias(Carrera c) {
        ArrayList <Catedra> list=new ArrayList<>();
        //String sql = "SELECT catedra.idCatedra, catedra.nombreCatedra, catedra.idJefeCatedra FROM carreraCatedra INNER JOIN catedra ON carreraCatedra.idCatedra = catedra.idCatedra WHERE carreraCatedra.idCarrera="+c.getIdCarrera()+";";
        String sql = "SELECT * FROM catedra";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Catedra cat = new Catedra();
                cat.setIdJefe(rs.getInt("idJefeCatedra"));
                cat.setIdCatedra(rs.getInt("idCatedra"));
                cat.setNombreCatedra(rs.getString("nombreCatedra"));
                list.add(cat);
                
            }
        } catch (Exception e) {
        }
        return list;
    }
    public static void main(String[] args) {
        CarreraDAO daoC = new CarreraDAO();
        

    }



}

