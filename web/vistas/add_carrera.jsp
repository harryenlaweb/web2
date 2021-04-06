
<%@ include file="tpl/head2.jsp" %>


<div class="row wrapper border-bottom white-bg page-heading">
    <div class="col-lg-10">
        <h2>Basic Form</h2>
        <ol class="breadcrumb">
            <li>
                <a href="index.html">Home</a>
            </li>
            <li>
                <a>Forms</a>
            </li>
            <li class="active">
                <strong>Basic Form</strong>
            </li>
        </ol>
    </div>
    <div class="col-lg-2">

    </div>
</div>
         
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">                    
            <div class="col-lg-7">

                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Ingresar Carrera</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                                <i class="fa fa-wrench"></i>
                            </a>                                    
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <form class="form-horizontal">                                    
                            <div class="form-group"><label class="col-lg-2 control-label">Nombre</label>
                                <div class="col-lg-10"><input placeholder="Ingrese el nombre de la carrera" class="form-control" name="nombre"></div>
                            </div>
                            <div class="form-group"><label class="col-lg-2 control-label">Descripción</label>
                                <div class="col-lg-10"><input placeholder="Ingrese la descripción de la carrera" class="form-control" name="descripcion"></div>
                            </div>                                    
                            <div class="form-group">
                                <div class="col-lg-offset-2 col-lg-10">
                                    <button type="submit" name="accion" class="btn btn-w-m btn-primary">Ingresar</button>                                            
                                </div>
                            </div>
                        </form>
                    </div>
                </div>                     


            </div>
        </div>
    </div>
</div>     
        
        
  
</body>
</html>
