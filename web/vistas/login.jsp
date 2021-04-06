<%-- 
    Document   : login
    Created on : 30/03/2021, 19:07:50
    Author     : ariel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login - UNA</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" href="../img/icon_UNA.ico" />
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <!-- Optional Bootstrap Theme -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" rel="stylesheet">
        <link rel="stylesheet" href="../css/Estilos.css"/>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div  class="nav navbar-header col-xs-9">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#about"><img src="../img/UNA.gif" width="50" height="50" class="img-responsive"/></a>
            </div>

            <div id="navbar" class="navbar-collapse collapse col-xs-3">
                <ul class="nav navbar-nav  ">
                    <li>
                        <a class="nav-link" href="../index.jsp">Inicio</a>
                    </li>
                    <li>
                        <a class="nav-link" href="../vistas/registrar.jsp">Registrarme</a>
                    </li>           
                </ul>
                <!--          <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                          </form>-->
            </div>
        </nav>

        <div class="container">
            <main>

                <div class="row">
                    <div class="col-xs-4">                        
                    </div>
                    <div class="col-xs-4">
                        <form method="post" enctype="multipart/form-data" action="../Controlador">
                            <table class="align-center">
                                <th colspan="2"><h3 class="text-center">Acceso</h3></th> 

                                <tr>
                                    <td>Usuario</td> <td><input class="form-control" type="text" name="username"></td>
                                </tr>

                                <tr>
                                    <td>Password</td> <td><input  class="form-control" type="text" name="password"></td>
                                </tr>

                                <tr>
                                    <td colspan="2"><input type="hidden" name="accion" value="IniciarSesion"/><input  class="btn btn-block boton1" type="submit" name="b" value="Ingresar"></td>
                                </tr>
                            </table>    
                        </form>

                    </div>
                    <div class="col-xs-4">                        
                    </div>
                </div>
            </main>

        </div>
        <%
            int registro = 1;
            if (request.getParameter("registro") != null) {
                registro = Integer.parseInt(request.getParameter("registro"));
            }

            if (registro == 0) {
                out.print("<br><strong>Usuario o contraseña inválida</strong>");
            }
            int registrar = 1;
            if (request.getParameter("registrar") != null) {
                registrar = Integer.parseInt(request.getParameter("registrar"));
            }
            if (registrar == 0) {
                out.print("<br><strong>No se registró</strong>");

            }

            if (request.getParameter("cerrar") != null) {
                session.invalidate();
                response.sendRedirect("../index.jsp");
            }
        %>

        <p></p>    
        <footer>
            <p> Facultad Nacional Argentina - Av. Los Cárcanos 1564 - Córdoba - Argentina </p>

        </footer>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </body>
    <%

    %>
</html>
