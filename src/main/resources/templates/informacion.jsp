<%@page contentType="text/html; charset=UTF-8"
import="java.util.*, org.tecsharp.apiservlet.webapp.headers.models.*"%>
<%
Optional<String> username = (Optional<String>) request.getAttribute("username");
Usuario usuario = (Usuario) request.getAttribute("usuario");
Optional<Integer> userAdminOptional = (Optional<Integer>) request.getAttribute("userAdminOptional");
String infoRecuperada = (String) request.getAttribute("infoRecuperada");

%>

<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>Tecland | Informacion</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
      <!-- bootstrap css -->
      <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
   </head>
   <!-- body -->
   <body class="main-layout inner_page">

      <!-- header -->
      <div class="header">
         <div class="container">
            <div class="row d_flex">
               <div class=" col-md-2 col-sm-3 col logo_section">
                  <div class="full">
                     <div class="center-desk">
                        <div class="logo">
                           <a href="index.html"><img src="images/logo.png" alt="#" /></a>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col-md-8 col-sm-12">
                  <nav class="navigation navbar navbar-expand-md navbar-dark ">
                     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                     <span class="navbar-toggler-icon"></span>
                     </button>

                     <div class="collapse navbar-collapse" id="navbarsExample04">
                        <ul class="navbar-nav mr-auto">
                           <li class="nav-item">

                              <a class="nav-link" href="<%=request.getContextPath()%>/">INICIO</a>
                           </li>
                           <li class="nav-item active">
                              <a class="nav-link" href="<%=request.getContextPath()%>/informacion">TECLAND</a>
                           </li>
                           <li class="nav-item">
                              <a class="nav-link" href="<%=request.getContextPath()%>/membresias">MEMBRESIAS</a>
                           </li>
                           <li class="nav-item">
                              <a class="nav-link" href="<%=request.getContextPath()%>/contacto">CONTACTO</a>
                           </li>
                        </ul>
                     </div>

                  </nav>
               </div>
               <div class="col-md-2  d_none">
                  <ul class="email text_align_right">
                     <li><a href="<%=request.getContextPath()%>/login">INICIAR SESION
                        </a>
                     </li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
      <!-- end header inner -->
      <!-- about -->
      <div class="about">
         <div class="container">
            <div class="row">
               <div class="col-md-12">
                  <div class="titlepage text_align_center">
                     <h2>TECLAND <span class="blue_light">ROLEPLAY</span></h2>
                  </div>
               </div>
               <div class="col-md-10 offset-md-1">
                  <div class="about_img text_align_center">
                     <figure><img src="images/about.png" alt="#"/></figure>

                     <%=infoRecuperada%>

                     <a class="read_more" href="mediafire.com">Dscargar mods</a>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- end about -->

      <!-- IMAGE -->

      <div class="image">
               <div class="container">
                  <div class="row">
                     <div class="col-md-12">
                        <div class="titlepage text_align_center">

                        </div>
                     </div>
                     <div class="col-md-10 offset-md-1">
                        <div class="imagetranspararente">

                           <p></p>
                        </div>
                     </div>
                  </div>
               </div>
            </div>

      <!-- END IMAGE -->

      <!--  footer -->
      <jsp:include page="footer.jsp" />
      <!-- end footer -->
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <!-- sidebar -->
      <script src="js/custom.js"></script>
   </body>
</html>