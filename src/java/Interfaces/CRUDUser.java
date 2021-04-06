/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Usuario;

/**
 *
 * @author user
 */
public interface CRUDUser extends CRUD<Usuario> {
    public int loguear(String usuario, String password);
    public boolean registrarUsuario(Usuario usr);
    public boolean cargarCV(Usuario u, String f);
}
