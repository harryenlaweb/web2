<%@page import="java.util.Iterator"%>
<%@page import="java.util.*"%>
<%@page import="Modelo.Carrera"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAO.CarreraDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>UNA | Listar Carreras</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Data Tables -->
    <link href="css/plugins/dataTables/dataTables.bootstrap.css" rel="stylesheet">
    <link href="css/plugins/dataTables/dataTables.responsive.css" rel="stylesheet">
    <link href="css/plugins/dataTables/dataTables.tableTools.min.css" rel="stylesheet">

    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

    
     <!-- Mainly scripts -->
    <script src="js/jquery-2.1.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/plugins/jeditable/jquery.jeditable.js"></script>

    <!-- Data Tables -->
    <script src="js/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script src="js/plugins/dataTables/dataTables.responsive.js"></script>
    <script src="js/plugins/dataTables/dataTables.tableTools.min.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="js/inspinia.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>

    <style>

    </style>

    <!-- Page-Level Scripts -->
    <script>
       $(document).ready(function() {
            $('#example').DataTable( {
                "pagingType": "full_numbers"
            } );
        } );

       
    </script>

</head>

<body>

    <div id="wrapper">

    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="img/profile_small.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">David Williams</strong>
                             </span> <span class="text-muted text-xs block">Art Director <b class="caret"></b></span> </span> </a>
                        <ul class="dropdown-menu animated fadeInRight m-t-xs">
                            <li><a href="profile.html">Profile</a></li>
                            <li><a href="contacts.html">Contacts</a></li>
                            <li><a href="mailbox.html">Mailbox</a></li>
                            <li class="divider"></li>
                            <li><a href="login.html">Logout</a></li>
                        </ul>
                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                </li>
                <li>
                    <a><i class="fa fa-sitemap"></i> <span class="nav-label">Carreras</span> <span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a  href="Controlador?accion=add_carrera">Agregar</a></li>
                        <li><a  href="Controlador?accion=listarC">Listar</a></li>                        
                    </ul>
                </li>                
                <li>
                    <a><i class="fa fa-files-o"></i> <span class="nav-label">Materias</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level collapse">
                        <li><a href="vistas/add_carrera.jsp">Agregar</a></li>
                        <li><a href="vistas/listaCarreras.jsp">Listar</a></li>                        
                    </ul>
                </li>
                

        </div>
    </nav>

        <div id="page-wrapper" class="gray-bg">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>                    
                </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li>
                            <span class="m-r-sm text-muted welcome-message">Universidad Nacional Argentina</span>
                        </li>                   


                        <li>
                            <a href="vistas/login.jsp?cerrar=true">                                
                                <i  class="fa fa-sign-out"></i>Salir
                            </a>
                        </li>
                    </ul>

                </nav>
            </div>
        <div>           

            <% 
                String usuario = "";
                boolean admin = false;
                String opts = "";
                String ads ="";
                String hed=""; 
                
                if(session.getAttribute("nivel") != null && Integer.parseInt(session.getAttribute("nivel").toString()) == 3) {
                    opts = "<td><a class=\"btn btn-info btn-xs\" href=\"Controlador?accion=verMaterias\">Editar</a> | <a class=\"btn btn-info btn-xs\" href=\"Controlador?accion=verMaterias\">Eliminar</a></td>";
                    ads="<a href=\"Controlador?accion=add_carrera\" class=\"btn btn-primary \">Agregar nueva carrera</a>";
                    hed="<th>Opciones Administrativas</th>";
                }
                else {
                    ads="<a href=\"Controlador?accion=verVacantes\" class=\"btn btn-primary \">Ver vacantes abiertas</a>";
                }
            
            %>

        </div>
 
<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>Carreras</h2>
        <ol class="breadcrumb">
            <li>
                <a>Home</a>
            </li>
            <li>
                <a>Carreras</a>
            </li>
            <li class="active">
                <strong>Listar</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-2">

    </div>
</div>
            
<div class="wrapper wrapper-content animated fadeInRight">
    
    <div class="row">
            <div class="col-lg-12">
            <div class="ibox float-e-margins">
            <div class="ibox-title">
                <h5>Listado de carreras</h5>
                <div class="ibox-tools">
                    <a class="collapse-link">
                        <i class="fa fa-chevron-up"></i>
                    </a>                    
                    <a class="close-link">
                        <i class="fa fa-times"></i>
                    </a>
                </div>
            </div>
            <div class="ibox-content">
            <div class="">
           <%=ads%>
            </div>
            <table class="table table-striped table-bordered table-hover" id="example">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Catedras</th>
  
                <%=hed%>
 
            </tr>
            </thead>
            <tbody>
            <%
                    CarreraDAO dao = new CarreraDAO();
                    List<Carrera>list=dao.listar();
                    Iterator<Carrera>iter=list.iterator();
                    Carrera car = null;   
                    while(iter.hasNext()){
                        car = iter.next();


               %>
            <tr class="gradeX">
                <td><%= car.getIdCarrera()%></td>
                <td><%= car.getNombreCarrera()%></td>
                <td><a class="btn btn-info btn-xs" href="Controlador?accion=verMaterias&idC=<%= car.getIdCarrera()%>">Ver info</a></td>
                <%=opts%>

            </tr>
            
              <%
                    }
                    %>
            </tbody>
            <tfoot>
           
            </tfoot>
            </table>

            </div>
            </div>
            </div>
    </div>
</div>
    
    
    
    
    
       
    </body>
</html>
