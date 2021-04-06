<%-- 
    Document   : index
    Created on : 30/03/2021, 19:07:05
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        <div>
            <a href="vistas/login.jsp?cerrar=true">Cerrar Sesion</a> |

            <% 
                String usuario = "";
                String level = "";
                if(session.getAttribute("usuario") != null) usuario = session.getAttribute("usuario").toString();
                if(session.getAttribute("nivel") != null) level = session.getAttribute("nivel").toString();
                if(usuario.equals("admin") && usuario != null){
                    out.println("Hola "+usuario+ " administrador");
                }else{
                    out.println("Hola "+usuario + " tu nivel es " + level);
                }
            
            %>
            <%
               if(session.getAttribute("usuario")== null){
                   response.sendRedirect("vistas/login.jsp");
               }
            %>
        </div>
        <div class="container">
            <a class="btn btn-success btn-lg" href="Controlador?accion=listarC">Listar Carreras</a> <!-- Controlador va a servlet controlador y da la accion listar. 
                                                                  Todo funciona en base a controlador. Vista no tiene acceso a modelo(DB) solo mediante la capa controlador-->

        </div>
    </body>
</html>
