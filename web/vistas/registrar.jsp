<%-- 
    Document   : registrar
    Created on : 30/03/2021, 19:08:50
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page session="true" %>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro - UNA</title>
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
            <div  class="nav navbar-header col-xs-11">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#about"><img src="../img/UNA.gif" width="50" height="50" class="img-responsive"/></a>
            </div>

            <div id="navbar" class="navbar-collapse collapse col-xs-1">
                <ul class="nav navbar-nav  ">
                    <li>
                        <a class="nav-link" href="../index.jsp">Inicio</a>
                    </li>          
                </ul>
                <!--          <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                          </form>-->
            </div>
        </nav>

        <!--<form action="Controlador">
            <table>
                <tr>
                    <td>Usuario:</td><td><input type="text" name="username" required></td>
                </tr>
                <tr>
                    <td>Clave:</td><td><input type="text" name="password" required></td>
                </tr>
                <tr>
                    <td>Nombre:</td><td><input type="text" name="nombre" required></td>
                </tr>
                <tr>
                    <td>Apellido: </td><td><input type="text" name="apellido" required></td>
                </tr>
                <tr>
                    <td>DNI: </td><td><input type="text" name="dni" required></td>
                </tr>
                <tr>
                    <td>email:</td><td><input type="text" name="email" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="registrar"></td>
                </tr>
            </table>    
            
        </form>
        -->
        <div class="container">
            <main>
                <div class="row">
                    <div class="col-xs-4">                        
                    </div>
                    <div class="col-xs-4">
                        <form action="../Controlador?accion=registrar">
                            <table align="center">
                                <th colspan="2"><h3 class="text-center">Agregar usuario</h3></th> 

                                <tr>
                                    <td>Usuario</td> <td><input class="form-control" type="text" name="username"></td>
                                </tr>

                                <tr>
                                    <td>Password</td> <td><input  class="form-control" type="text" name="password"></td>
                                </tr>

                                <tr>
                                    <td>Nombre</td> <td><input  class="form-control" type="text" name="nombre"></td>
                                </tr>
                                
                                <tr>
                                    <td>Apellido</td> <td><input  class="form-control" type="text" name="apellido"></td>
                                </tr>
                                 <tr>
                                    <td>DNI</td> <td><input  class="form-control" type="text" name="dni"></td>
                                </tr>
                                 <tr>
                                    <td>E-mail</td> <td><input  class="form-control" type="text" name="email"></td>
                                </tr>
                                <tr>
                                    <td colspan="2"><input  class="btn btn-block boton1"  type="submit" name="accion" value="registrar"></td>
                                </tr>
                            </table>    
                        </form>

                    </div>
                    <div class="col-xs-4">                        
                    </div>
                </div>
            </main>

        </div>
      <p></p>    
        <footer>
            <p> Facultad Nacional Argentina - Av. Los Cárcanos 1564 - Córdoba - Argentina </p>

        </footer>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
