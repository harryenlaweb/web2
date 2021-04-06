///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Controlador;
//
//import Modelo.Persona;
//import Modelo.Usuario;
//import ModeloDAO.UsuarioDAO;
//import java.io.IOException;
//import java.io.PrintWriter;
//import static java.lang.System.out;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// *
// * @author ariel
// */
//public class Controlador extends HttpServlet {
//
//   
//    String listar = "vistas/listar.jsp";
//    String listarCarreras = "vistas/listaCarreras.jsp";
//    String add= "vistas/add.jsp";
//    String edit = "vistas/edit.jsp";
//    String verMaterias = "vistas/verMaterias.jsp";
//    String verVacantes = "vistas/verVacantes.jsp";
//    int id;
//    Persona p = new Persona();
//    Usuario u = new Usuario();
//    UsuarioDAO dao = new UsuarioDAO();
//    
//    
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            String action = request.getParameter("accion");
//            String acceso = "";
//            if(action.equalsIgnoreCase("IniciarSesion")){
//                String username = request.getParameter("username"); // captura valores
//                String password = request.getParameter("password");
//                int id = dao.loguear(username, password);
//                if(id != -1){
//                    HttpSession sesion = request.getSession(); // le meto a sesion
//                    sesion.setAttribute("usuario", username);
//                    sesion.setAttribute("idUsuario", id);
//                    int nivel = dao.clasificar(dao.loguear(username, password));
//                    sesion.setAttribute("nivel", nivel); 
//                    if(nivel == 3) {
//                        acceso=listarCarreras;
//                    }
//                    else if (nivel == 0) {
//                        acceso = verVacantes;
//                    }
//                    
//                }else{
//                    //response.sendRedirect("index.jsp?registro=0");
//                    acceso="index.jsp?registro=0";
//                }
//            }
//        RequestDispatcher vista = request.getRequestDispatcher(acceso);
//        vista.forward(request, response);
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //Acá TRabajo
//        String acceso = "";
//        String action = request.getParameter("accion"); //si es listar viene accion=listar
//        if(action.equalsIgnoreCase("listarC")){
//            acceso=listarCarreras;
//        }
//        else if(action.equalsIgnoreCase("add")){
//            acceso=add;
//        }
//        else if (action.equalsIgnoreCase("verMaterias")) {
//            
//            int idC = Integer.parseInt(request.getParameter("idC"));
//            acceso=verMaterias;
//        }
//        else if(action.equalsIgnoreCase("agregar")){
//            String dni = request.getParameter("dni");
//            String nombre = request.getParameter("nombre");
//            p.setDni(dni);
//            p.setNombre(nombre);
//            dao.add(u);
//            acceso=listar;
//        }
//        else if(action.equalsIgnoreCase("editar")){
//            request.setAttribute("idper", request.getParameter("id"));
//            acceso=edit;
//        }
//        else if(action.equalsIgnoreCase("Actualizar")){
//            id=Integer.parseInt(request.getParameter("id_editar"));
//            System.out.println("id: "+id);
//            String dni = request.getParameter("dni");
//            String nombre = request.getParameter("nombre");
//            System.out.println("nombre"+nombre);
//            p.setId(id);
//            p.setDni(dni);
//            p.setNombre(nombre);
//            dao.edit(u);
//            acceso=listar;
//            
//        }
//        else if(action.equalsIgnoreCase("eliminar")){
//            id = Integer.parseInt(request.getParameter("id"));
//            p.setId(id);
//            System.out.println("id: "+id);
//            dao.eliminar(id);
//            acceso=listar;
//        }
//       
//        else if(action.equalsIgnoreCase("registrar")){
//            String username = request.getParameter("username");
//            String password = request.getParameter("password");
//            String nombre = request.getParameter("nombre");
//            String apellido = request.getParameter("apellido");
//            int dni = Integer.parseInt(request.getParameter("dni"));
//            String email = request.getParameter("email");
//            u.setDni(dni);
//            u.setEmail(email);
//            u.setApellido(apellido);
//            u.setNombre(nombre);
//            u.setPassword(password);
//            u.setUsername(username);
//            dao.registrarUsuario(u);
//            acceso="index.jsp";
//        }
//        else if(action.equalsIgnoreCase("verVacantes")) {
//            acceso = verVacantes;
//        }
//
//        RequestDispatcher vista = request.getRequestDispatcher(acceso);
//        vista.forward(request, response);
//        
//        
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
