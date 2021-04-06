/*
ESTE ES EL MODELO DB
 */
package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUD;
import Interfaces.CRUDUser;
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
public class UsuarioDAO implements CRUDUser{
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Persona p = new Persona();
    Usuario u = new Usuario();
    @Override
    public List listar() {
        ArrayList <Usuario> list=new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario us = new Usuario();
                us.setApellido(rs.getString("apellido"));
                us.setNombre(rs.getString("nombre"));
                us.setDni(rs.getInt("dni"));
                us.setEmail(rs.getString("email"));
                us.setUsername(rs.getString("username"));
                us.setCodCV(rs.getString("codCV"));
                
                
                list.add(us);
                
            }
        } catch (Exception e) {
        }
        return list;
        
    }

    @Override
    public Usuario list(int id) {
        String sql = "SELECT * FROM usuarios WHERE id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                u.setApellido(rs.getString("apellido"));
                u.setNombre(rs.getString("nombre"));
                u.setDni(rs.getInt("dni"));
                u.setEmail(rs.getString("email"));
                u.setUsername(rs.getString("username"));
                u.setId(rs.getInt("id"));
                u.setCodCV(rs.getString("codCV"));
                
                
            }
        } catch (Exception e) {
        }
        return u;
    }
    /********** ESTE MÉTODO LO VOY A UNIR CON REGISTRAR; AGREGAR A UN USUARIO SERÁ COMO REGISTRAR UNO PERO CON CAMPOS
     * DEFINIDOS POR EL ADMINISTRADOR, SI ES NECESARIO TENER ESE MÉTODO*/

    @Override
    public boolean add(Usuario us) {
        String sql = "";//"INSERT INTO persona(dni,nombre) VALUES('"+per.getDni()+"','"+per.getNombre()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Usuario us) {
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
        String sql = "";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        return false;
    }
    
  
    public int clasificar(int id) {
        try {
            String sql = "SELECT * FROM jefeCatedra WHERE idUsuario = ?";
            String sql2 = "SELECT * from administrativo WHERE idUsuario = ?";
            String sql3 = "SELECT * from docente WHERE idUsuario = ?";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.absolute(1)) {
                return 2; // retorna 2 para jefe dec ae
            }
            else {
                ps = con.prepareStatement(sql2);
                ps.setInt(1, id);
                rs = ps.executeQuery();
                if(rs.absolute(1)) 
                    return 3; // retorna 3 para administrativo
                
                else {
                    ps = con.prepareStatement(sql3);
                    ps.setInt(1, id);
                    rs = ps.executeQuery();
                    if(rs.absolute(1)) 
                        return 1; // retorna uno para docente
                    
                }
                
            }
            return 0;
           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;// retorna cero si es usuario común
        
    }
    public int loguear(String usuario, String clave){
            try {
            String sql = "SELECT * FROM usuarios WHERE username = ? and password = ?";
            
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            rs.next(); //dentro de while recorro cada una aca solo hay 1 campo de resultado.
            if(rs.absolute(1)) {
                return rs.getInt("id");
            }
            
            
        } catch (Exception e) {
            System.out.println("Error"+ e);
        }
        return -1;
    }
    @Override
    public boolean registrarUsuario(Usuario usr){
        String sql = "INSERT INTO usuarios(`nombre`, `apellido`, `email`, `password`, `username`, `codCV`, `dni`) VALUES"
                + "('"+usr.getNombre()+"','"+usr.getApellido()+"','"+usr.getEmail()+"','"+usr.getPassword()+"','"+usr.getUsername()+"',NULL,"+usr.getDni()+")";
        //String sql = "INSERT INTO usuarios(`nombre`, `apellido`, `email`, `password`, `username`, `codCV`, `dni`) VALUES"
        //        + "('test','try','testmail','testpass','tst',NULL,111)";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Carga exitosa");
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
        return false;    
    }
    
    
    
    
        public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        Persona pp = new Persona();
//        pp.setNombre("Juan");
//        pp.setDni("222222");
//        pp.setId(1);
//        System.out.println("ID: "+pp.getId());
//        System.out.println("Nombre: "+pp.getNombre());
//        System.out.println("DNI: "+pp.getDni());
        //dao.edit(pp);
       // dao.eliminar(1);
       
       //prueba de registro usuarios:
       //`username`, `password`, `nombre`, `apellido`, `dni`, `email`
       
        //Usuario u = new Usuario(0, "juany", "1234", "juan", "martinez", 23443432, "juan@juany.com");
       //dao.registrarUsuario(u);
            System.out.println(dao.loguear("admin", "admin"));
        dao.loguear("admin", "admin");
    }

    @Override
    public boolean cargarCV(Usuario u, String f) {
        u.setCodCV(f);
        String sql = "UPDATE usuarios SET codCV = '"+u.getCodCV()+"' WHERE id="+u.getId()+";";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error"+e);
            return false;
        }
    }
    
}

