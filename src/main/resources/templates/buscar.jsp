<%@page contentType="text/html; charset=UTF-8"
import="java.util.*, org.tecsharp.apiservlet.webapp.headers.models.*"%>
<%
Optional<String> username = (Optional<String>) request.getAttribute("username");
Usuario usuario = (Usuario) request.getAttribute("usuario");
Optional<Integer> userAdminOptional = (Optional<Integer>) request.getAttribute("userAdminOptional");
ArrayList<Amigo> listaBusquedaAmigos = (ArrayList<Amigo>) request.getAttribute("listaBusquedaAmigos");
ArrayList<Notificacion> notificacionesLista = (ArrayList<Notificacion>) request.getAttribute("notificacionesLista");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">


    <title>Perfil | Tecland Roleplay</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	body{
    margin-top:20px;
    color: #1a202c;
    text-align: left;
    background: url(./images/bg.png);
}
.main-body {
    padding: 15px;
}
.card {
    box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
}

.btn-info {
    color: #fff;
    background-color: #3b8526;
    border-color: #3b8526;
}

.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid rgba(0,0,0,.125);
    border-radius: .25rem;
}

.card-body {
    flex: 1 1 auto;
    min-height: 1px;
    padding: 1rem;
}

.gutters-sm {
    margin-right: -8px;
    margin-left: -8px;
}

.gutters-sm>.col, .gutters-sm>[class*=col-] {
    padding-right: 8px;
    padding-left: 8px;
}
.mb-3, .my-3 {
    margin-bottom: 1rem!important;
}

.bg-gray-300 {
    background-color: #e2e8f0;
}
.h-100 {
    height: 100%!important;
}
.shadow-none {
    box-shadow: none!important;
}

<!-- CSS DE TABS -->

            .tab {
              overflow: hidden;
              border: 1px solid #ccc;
              background-color: #f1f1f1;
            }


            .tab button {
              background-color: inherit;
              float: left;
              border: none;
              outline: none;
              cursor: pointer;
              padding: 14px 16px;
              transition: 0.3s;
              font-size: 17px;
            }


            .tab button:hover {
              background-color: #ddd;
            }


            .tab button.active {
              background-color: #ccc;
            }


            .tabcontent {
              display: none;
              padding: 6px 12px;
              border-top: none;
            }
            <!-- CSS DE TABS -->




    </style>
</head>
<body>
<div class="container">
    <div class="main-body">

        <nav aria-label="breadcrumb" class="main-breadcrumb">
            <ol class="breadcrumb">
                <div class="tab">
                <button class="tablinks" onclick="">Inicio</button>
                <button class="tablinks" onclick="">Perfil</button>
                <button class="tablinks" onclick="">Membresías</button>
                </div>
            </ol>
        </nav>

        <div class="row gutters-sm">
            <div class="col-md-4 mb-3">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center">
                            <img src="https://minotar.net/armor/bust/<%=usuario.getUsername()%>.png" alt="<%=usuario.getUsername()%>"
                                 class="rounded-circle" width="150">
                            <div class="mt-3">
                                <h4><%=usuario.getUsername()%></h4>
                                <p class="text-secondary mb-1">
                                <%
                                if(usuario.getEstadoConexion() == 1){ %>
                                    Conectado
                                <%} else if(usuario.getEstadoConexion() == 0){%>
                                    Desconectado
                                <%}%>
                                </p>
                                <p class="text-muted font-size-sm">Ultima ip: <%=usuario.getUltimaIp()%></p>
                                <div class="row">
                                      <div class="col-sm-12">
                                      <a class="btn btn-info " target="_self" href="<%=request.getContextPath()%>/logout">Cerrar sesion</a>

                                  </div>
                               </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="card mt-3">
                                    <ul class="list-group list-group-flush">
                                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                            <h6 class="mb-0">Notificaciones   |   ver todas</h6>
                                        </li>

                                        <%for(Notificacion notifyLista : notificacionesLista){
                                        if(notifyLista.getEstado() == 1){%>
                                        <li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
                                            <h6 class="mb-0"><%=notifyLista.getNotificacionMensaje()%></h6>
                                            <form name="submitForm" method="POST" action="<%=request.getContextPath()%>/aceptar-amigo?userId=<%=notifyLista.getUsuarioId()%>">
                                                <input type="hidden" name="userId" id="userId" value="userId">
                                                <A HREF="javascript:document.submitForm.submit()">Aceptar amigo</A>
                                            </form>
                                        </li>
                                        <%}%>
                                        <%}%>
                                </div>

            </div>



            <div class="col-md-8">
                <div class="card mb-3">

                <div class="tab">
                <button class="tablinks" onclick="openCity(event, 'Amigos')">Buscar amigos</button>
                </div>
                <div class="card-body">

                <div id="Amigos" class="">

                  <table class="table">
                    <thead>
                      <tr>

                        <div class="search-container">
                          <form action="<%=request.getContextPath()%>/buscar" class="navbar-search pull-left" method="post">
                            <input type="text" placeholder="Buscar amigos.." name="buscar" id="buscar">
                            <button type="submit" class="btn-info">Buscar</button>
                          </form>
                        </div>
                      </tr>
                    </thead>

                    <tbody>
                    <%if(listaBusquedaAmigos.isEmpty()){%>
                    <p>No se ha encontrado ningún usuario</p>
                    <%}%>
                    <%for(Amigo amigos : listaBusquedaAmigos){%>

                      <tr>
                        <!-- <th scope="row">1</th> -->
                        <td><img src="https://minotar.net/armor/bust/<%=amigos.getNombre()%>.png" alt="<%=amigos.getNombre()%>" class="rounded-circle" width="40"></td>
                        <td><%=amigos.getNombre()%></td>
                        <%if(amigos.getEstado() == 0){%>
                        <td>Desconectado</td>
                        <%} else if(amigos.getEstado() == 1){%>
                        <td>Conectado</td>
                        <%} else {%>
                        <td>Desconocido</td>
                        <%}%>
                        <td>Mensaje</td>
                        <%if(amigos.getIsFriend()){%>
                        <td>
                        <div class="search-container">
                        <form action="<%=request.getContextPath()%>/eliminar-amigo?userId=<%=amigos.getId()%>" class="navbar-search pull-left" method="post">
                        <button type="submit" name="userId" id="userId" class="btn-info">Eliminar</button>
                        </form>
                        </td>
                        <%} else if(usuario.getId() == amigos.getId()){%>
                        <td></td>
                        <%} else if(amigos.getSolicitudPendiente()){%>
                        <td>

                        <form action="<%=request.getContextPath()%>/aceptar-amigo?userId=<%=amigos.getId()%>" class="navbar-search pull-left" method="post">
                        <button type="submit" name="userId" id="userId" class="btn-info">Aceptar</button>
                        </form>

                        </td>
                        <%} else if(amigos.getSolicitudEnviada()){%>
                        <td>
                        <div class="search-container">
                        <form action="<%=request.getContextPath()%>/cancelar-solicitud?userId=<%=amigos.getId()%>" class="navbar-search pull-left" method="post">
                        <button type="submit" name="userId" id="userId" class="btn-info">Cancelar solicitud</button>
                        </form>
                        </td>
                        <%} else{%>
                        <td>
                        <form action="<%=request.getContextPath()%>/agregar?userId=<%=amigos.getId()%>" class="navbar-search pull-left" method="post">
                        <button type="submit" class="btn-info">Agregar</button>
                        </form>
                        </td>
                        <%}%>
                      </tr>
                      <%}%>
                    </tbody>
                  </table>
                </div>



                 </div>
                </div>

                </div>
            </div>
        </div>
    </div>
</div>
<script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript">

</script>
</body>
</html>