/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDVac;
import Modelo.Carrera;
import Modelo.Catedra;
import Modelo.Persona;
import Modelo.Usuario;
import Modelo.Vacante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class VacanteDAO implements CRUDVac{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Vacante v;
    @Override
    public List listar() {
        ArrayList <Vacante> list=new ArrayList<>();
        String sql = "SELECT * FROM vacante WHERE fecInicio > CURRENT_DATE;";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Vacante vac = new Vacante();
                vac.setComentarios(rs.getString("comentarios"));
                vac.setFecInicio(rs.getString("fecInicio"));
                vac.setIdCatedra(rs.getInt("idCatedra"));
                vac.setIdVacante(rs.getInt("idVacante"));
                list.add(vac);
                
            }
        } catch (Exception e) {
        }

        return list;
        
    }

    @Override
    public Vacante list(int id) {
        String sql = "SELECT * FROM vacante WHERE idVacante = "+id+";";
        Vacante v = new Vacante();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                v.setComentarios(rs.getString("comentarios"));
                v.setIdVacante(rs.getInt("idVacante"));
                v.setFecInicio(rs.getString("fecInicio"));
                v.setIdCatedra(rs.getInt("idCatedra"));
                
            }
        } catch (Exception e) {
        }
        return v;
    }

    @Override
    public boolean add(Vacante v) {
        String sql = "INSERT INTO vacante(fecInicio, idCatedra, comentarios) VALUES('"+v.getFecInicio()+"',"+v.getIdCatedra()+",'"+v.getComentarios()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public boolean edit(Vacante v) {
        //String sql = "UPDATE carrera SET nombreCarrera='"+c.getNombreCarrera()+"' WHERE id="+c.getIdCarrera();
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
        VacanteDAO daoV = new VacanteDAO();
        

    }

    @Override
    public boolean registrarNuevoPostulante(Usuario u, Vacante v) {
        String sql = "INSERT INTO postulacionVacante(idPostulante, idVacante, ordenMerito) VALUES('"+u.getId()+"',"+v.getIdVacante()+",0);";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public List verPorCatedra(Catedra c) {
        ArrayList<Vacante> list = new ArrayList<>();
        String sql = "SELECT * FROM vacante WHERE fecInicio > CURRENT_DATE AND idCatedra="+c.getIdCatedra()+";";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Vacante vac = new Vacante();
                vac.setComentarios(rs.getString("comentarios"));
                vac.setFecInicio(rs.getString("fecInicio"));
                vac.setIdCatedra(rs.getInt("idCatedra"));
                vac.setIdVacante(rs.getInt("idVacante"));
                list.add(vac);
                
            }
        } catch (Exception e) {
        }
        return list;
                
    }



}

