<%@page import="ModeloDAO.CatedraDAO"%>
<%@page import="Modelo.Catedra"%>
<%@page import="Modelo.Vacante"%>
<%@page import="ModeloDAO.VacanteDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.*"%>
<%@page import="Modelo.Carrera"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CarreraDAO"%>
<%@include file="securing.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="tpl/head2.jsp" %>




        <div>           



        </div>
        <div class="container">
            <h1>Vacantes abiertas</h1>
            
            <br>
            <br>
            <table border="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">Nombre de cátedra</th>
                        <th class="text-center">Fecha</th>
                        <th class="text-center">Comentarios</th>
                        <th class="text-center">Postular</th>
                    </tr>
                </thead>
                <%
                     VacanteDAO dao = new VacanteDAO();
                     CatedraDAO catd = new CatedraDAO();
                     List<Vacante>list=dao.listar();
                     Iterator<Vacante>iter=list.iterator();
                     Vacante vac = null;
                     Catedra c = null;
                     while(iter.hasNext()){
                         vac = iter.next();
                         c = catd.list(vac.getIdCatedra());

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= vac.getIdVacante()%></td>
                        <td class="text-center"><%= c.getNombreCatedra()%></td>
                        <td class="text-center"><%= vac.getFecInicio()%></td>
                        <td class="text-center"><%= vac.getComentarios()%></td>

                        <td class="text-center">
                            <a class="btn btn-warning" href="./vistas/postular.jsp?idV=<%= vac.getIdVacante()%>&idU=<%=session.getAttribute("idUsuario")%>"  >Enviar postulación</a>

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
