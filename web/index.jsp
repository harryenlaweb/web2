<%-- 
    Document   : index
    Created on : 30/03/2021, 19:07:05
    Author     : ariel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="vistas/tpl/head.jsp" %>

<div class="container">
    <main>
        <div class="row">
            <!-- Insert/Drop Grid Column codes below-->
            <div class="col-xs-12">

                <div id="carousel-1" class="carousel slide" data-ride="carousel" data-interval="5000">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-1" data-slide-to="0"></li>
                        <li data-target="#carousel-1" data-slide-to="1"></li>
                        <li data-target="#carousel-1" data-slide-to="2" class="active"></li>
                    </ol>
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item">
                            <img src="img/1.jpg" width="840" height="400" class="img-responsive" alt="imagen1"/>

                            <div class="carousel-caption">
                                <h5>UNIVERSIDAD NACIONAL ARGENTINA</h5>
                                <p>Carreras presenciales y a Distancia</p>
                            </div>
                        </div>
                        <div class="item">
                            <img src="img/2.jpeg" width="840" height="400" class="img-responsive" alt="imagen2"/>
                            <div class="carousel-caption">
                                <h5>INSCRIPCIONES ABIERTAS</h5>
                                <a href="#" class="btn btn-block btn-lg active boton1" role="button" aria-pressed="true">INSCRIBIRME AHORA</a>
                            </div>
                        </div>
                        <div class="item active">
                            <img src="img/3.jpg" width="840" height="400" alt="imagen3"/>
                            <div class="carousel-caption">
                                <h5>CONVOCATORIA PARA DOCENTES Y PROFESIONALES</h5>
                                <p>Vacantes en todas las Carreras</p>
                                <a href="Controlador?accion=verVacantes" class="btn  btn-block active boton1" role="button" aria-pressed="true">POSTULACIONES</a>
                            </div>
                        </div>
                    </div>
                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-1" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-1" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>

        </div>
    </main>
</div>
<%@include  file="vistas/tpl/footer.jsp" %>
