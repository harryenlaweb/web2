<%@page import="ModeloDAO.JefeCatedraDAO"%>
<%@page import="Modelo.JefeCatedra"%>
<%@page import="Modelo.Usuario"%>
<%@page import="Modelo.Postulacion"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page import="ModeloDAO.PostulacionDAO"%>
<%@page import="ModeloDAO.CatedraDAO"%>
<%@page import="Modelo.Catedra"%>
<%@page import="Modelo.Vacante"%>
<%@page import="ModeloDAO.VacanteDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.*"%>
<%@page import="Modelo.Carrera"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CarreraDAO"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="tpl/head2.jsp" %>
<div>           

            <% 
                

            
            %>

        </div>
        <div class="container">
            <h1>Postulaciones de sus cátedras</h1>
            
            <br>
            <br>
            <table border="1" class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID Postulacion</th>
                        <th class="text-center">ID Vacante</th>
                        <th class="text-center">Cátedra</th>
                        <th class="text-center">DNI Postulante</th>
                        <th class="text-center">Descargar CV</th>
                        <th class="text-center">Asignar Orden Merito</th>
                    </tr>
                </thead>
                <%
                     JefeCatedraDAO dao = new JefeCatedraDAO();
                     UsuarioDAO usd = new UsuarioDAO();
                     JefeCatedra j = new JefeCatedra();
                     j = dao.list(Integer.parseInt(session.getAttribute("idUsuario").toString()));
                     VacanteDAO vacD = new VacanteDAO();
                     CatedraDAO cd = new CatedraDAO();
                     PostulacionDAO pd = new PostulacionDAO();
                     Vacante v = new Vacante();
                     ArrayList<Vacante> lV = new ArrayList<Vacante>();
                     ArrayList<Catedra> l = dao.verCatedras(j);
                     Iterator<Catedra>itC = l.iterator();
                     List<Postulacion> miLis = new ArrayList<Postulacion>();
                     Postulacion p = null;
                     Usuario u = null;
                     Catedra cat = null;
                     while(itC.hasNext()) {
                         cat = itC.next();
                         miLis = pd.verPorCatedra(cat);
                         Iterator<Postulacion>itP = miLis.iterator();
                         
                         while(itP.hasNext()) {
                             p = itP.next();
                             u = usd.list(p.getIdPostulante());
                             
                             

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%=p.getIdPostulacionVacante()%></td>
                        <td class="text-center"><%=p.getIdVacante()%></td>
                        <td class="text-center"><%=cat.getNombreCatedra()%></td>
                        <td class="text-center"><%=u.getDni()%></td>
                        <td class="text-center">
                        <a  href="./<%=u.getCodCV()%>"  >Ver CV</a>

                        </td>
                        <td><a  href="./vistas/postular.jsp?idV=&idU="  >Asignar OM</a>

                        </td>
                    </tr>
                    <%
                        }
                    }
                    %>
                </tbody>
            </table>

        </div>
    </body>
</html>
