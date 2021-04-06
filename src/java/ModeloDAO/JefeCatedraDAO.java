/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDJef;
import Modelo.Catedra;
import Modelo.JefeCatedra;
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
public class JefeCatedraDAO implements CRUDJef{
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Vacante v;
  

    public JefeCatedraDAO() {
    }
    
    @Override
    public List listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public JefeCatedra list(int id) {
        JefeCatedra j = new JefeCatedra();
        String sql = "SELECT * FROM jefeCatedra INNER JOIN usuarios ON usuarios.id = jefeCatedra.idUsuario WHERE usuarios.id=7;";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                j.setApellido(rs.getString("apellido"));
                j.setNombre(rs.getString("nombre"));
                j.setDni(rs.getInt("dni"));
                j.setEmail(rs.getString("email"));
                j.setUsername(rs.getString("username"));
                j.setId(rs.getInt("id"));
                j.setIdJefe(rs.getInt("idJefeCatedra"));
                
            }
        } catch (Exception e) {
        }
        return j;
    }

    @Override
    public boolean add(JefeCatedra us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean edit(JefeCatedra c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Catedra> verCatedras(JefeCatedra j) {
        ArrayList <Catedra> list=new ArrayList<>();
        String sql = "SELECT * FROM catedra WHERE idJefeCatedra = "+j.getIdJefe()+";";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Catedra c = new Catedra();
                c.setIdCatedra(rs.getInt("idCatedra"));
                c.setNombreCatedra(rs.getString("nombreCatedra"));
                c.setIdJefe(rs.getInt("idJefeCatedra"));
                list.add(c);
                
            }
        } catch (Exception e) {
        }

        return list;
        
    }
    
}
