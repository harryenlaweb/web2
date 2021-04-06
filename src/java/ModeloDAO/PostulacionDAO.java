/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDPost;
import Modelo.Catedra;
import Modelo.Postulacion;
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
public class PostulacionDAO implements CRUDPost {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Postulacion j;
    @Override
    public List listar() {
        ArrayList<Postulacion> a = new ArrayList<>();
        return a;
    }

    @Override
    public Postulacion list(int id) {
        String sql = "SELECT * FROM postulacionVacante WHERE idPosVac ="+id+";";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                j.setIdPostulacionVacante(rs.getInt("idPosVac"));
                j.setIdPostulante(rs.getInt("idPostulante"));
                j.setIdVacante(rs.getInt("idVacante"));
                j.setOrdenMerito(rs.getInt("ordenMerito"));
               ;
                
            }
        } catch (Exception e) {
        }
        return j;
    }

    @Override
    public boolean add(Postulacion us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(Postulacion c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List verPorVacante(Vacante v) {
        ArrayList<Postulacion> list = new ArrayList<>();
        String sql = "SELECT * FROM postulacionVacante WHERE idVacante = "+v.getIdVacante()+";";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Postulacion p = new Postulacion();
                p.setIdPostulante(rs.getInt("idPostulante"));
                p.setIdVacante(rs.getInt("idVacante"));
                p.setOrdenMerito(rs.getInt("ordenMerito"));
                p.setIdPostulacionVacante(rs.getInt("idPosVacante"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List verPorCatedra(Catedra c) {
        ArrayList<Postulacion> list = new ArrayList<>();
            String sql = "SELECT * FROM postulacionVacante INNER JOIN vacante INNER JOIN catedra on postulacionVacante.idVacante = vacante.idVacante WHERE vacante.idCatedra = "+c.getIdCatedra()+" GROUP BY postulacionVacante.idPosVacante;";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Postulacion p = new Postulacion();
                p.setIdPostulante(rs.getInt("idPostulante"));
                p.setIdVacante(rs.getInt("idVacante"));
                p.setOrdenMerito(rs.getInt("ordenMerito"));
                p.setIdPostulacionVacante(rs.getInt("idPosVacante"));
                list.add(p);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
}
