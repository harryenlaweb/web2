<%-- 
    Document   : listaCarreras
    Created on : 31/03/2021, 03:28:51
    Author     : user
--%>


<%@page import="Modelo.Catedra"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.*"%>
<%@page import="Modelo.Carrera"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CarreraDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <a href="vistas/login.jsp?cerrar=true">Cerrar Sesion</a> |

            <% 
                String usuario = "";
                if(session.getAttribute("usuario") != null) usuario = session.getAttribute("usuario").toString();

            
            %>

        </div>
        <div class="container">
            <h1>Materias de la carrera</h1>
            <a class="btn btn-success" href="../Controlador?accion=add">Ver postulaciones abiertas</a>
            <br>
            <br>
            <table border="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID materia</th>
                        <th class="text-center">Nombre de materia</th>
                        <th class="text-center">ID Jefe Cátedra</th>
                    </tr>
                </thead>
                <%
                    
                     CarreraDAO dao = new CarreraDAO();
                     Carrera c = dao.list(Integer.parseInt(request.getParameter("idC")));
                     List<Catedra>list=dao.verMaterias(c);
                     Iterator<Catedra>iter=list.iterator();
                     Catedra cat = null;
                     while(iter.hasNext()){
                         cat = iter.next();
                     

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= cat.getIdCatedra()%></td>
                        <td class="text-center"><%= cat.getNombreCatedra()%></td>

                        <td class="text-center">
                            <%= cat.getIdJefe()%>

                        </td>
                    </tr>
                    <%
                    }
                    %>
                </tbody>
            </table>

        </div>
    </body>
</html>
