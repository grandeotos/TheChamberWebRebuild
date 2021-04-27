<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Chamber - Control Panel</title>
    <!-- CSS Externo-->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
    <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/LoginReg.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>

<body class="body-bcolor">
    <div class="row">
        <div class="col-md-3 col-xs-12">
        </div>
        <div class="col-md-6 col-xs-12">
            <div class="holamundo">
                <div class="container">
                    <div class="ind-login-box">
                        <div class="ind-login-text">
                            <img src="${pageContext.request.contextPath}/img/indra2.png " class="img-fluid" alt="Logo Indra">
                            <br>
                            <h2>Alta de aplicantes</h2>
                            <h6>Datos candidato</h6>
                            <br>
                            <c:if test="${not empty message}">
                                <c:choose>
                                    <c:when test="${messageType == 'Success'}">
                                        <div class="alert alert-success" role="alert">
                                            <h4 class="alert-heading"><i class="fas fa-check-circle"></i> Completado:</h4>
                                            <p>${message}</p>
                                        </div>
                                    </c:when>
                                    <c:when test="${messageType == 'WarningError'}">
                                        <div class="alert alert-warning" role="alert">
                                            <h4 class="alert-heading"><i class="fas fa-exclamation-triangle"></i> Atención:</h4>
                                            <p>${message}</p>
                                        </div>
                                    </c:when>
                                    <c:when test="${messageType == 'FatalError'}">
                                        <div class="alert alert-danger" role="alert">
                                            <h4 class="alert-heading"><i class="fas fa-exclamation-triangle"></i> ERROR FATAL:</h4>
                                            <p>${message}</p>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="alert alert-primary" role="alert">
                                            <h4 class="alert-heading"><i class="fas fa-exclamation-triangle"></i> Alerta:</h4>
                                            <p>${message}</p>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                            <br>
                        </div>
                        <div class="formbutton">
                            <form role="form" action="gamerRegist" method="POST">
                                <div>
                                    <div class="form-group">
                                        <br>
                                        <label id="lfirstName" for="firstName">Nombre(s): </label>
                                        <input type="text" class="form-control" id="firstName"
                                        name="firstName" placeholder="Ingrese su(s) Nombre(s)" value="${firstName}">
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="llastName" for="lastName">Apellido(s) </label>
                                        <input type="text" class="form-control" id="lastName"
                                        name="lastName" placeholder="Ingrese su(s) Apellido(s)" required="required" value="${lastName}">
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="lcurp" for="password">CURP </label>
                                        <input type="text" class="form-control" id="curp"
                                        name="curp" placeholder="Ingrese su CURP" required="required" value="${curp}">
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="lusername" for="usernameForm">Username</label>
                                        <input type="text" class="form-control" id="usernameForm" placeholder="Hay un problema, deberia estar prellenado" value="${username}" disabled>
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="labpass" for="emailForm">Email</label>
                                        <input type="text" class="form-control" id="emailForm"
                                               placeholder="Hay un problema, deberia estar prellenado" value="${email}" disabled>
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="passwordLabel" for="password">Contraseña</label>
                                        <input type="password" class="form-control" id="password" name="password"
                                            placeholder="Ingrese su contraseña" required="required">
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="password2Label" for="password2">Confirmar contraseña</label>
                                        <input type="password" class="form-control" id="password2" name="password2"
                                            placeholder="Repita su contraseña" required="required">
                                    </div>
                                    <div class="form-group">
                                        <input type="hidden" id="usernameHidden" name="username" value="${username}">
                                        <input type="hidden" id="emailHidden" name="email" value="${email}">
                                    </div>
                                    <div class="checkbox">
                                        <br>
                                        <label>
                                            <input type="checkbox"> Recordar contraseña (No recomendar en dispositivos
                                            compartidos)
                                        </label>
                                        <p></p>
                                    </div>
                                </div>
                                <center>
                                    <button type="submit" class="btn btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#registSuccessModal"><i class="fas fa-sign-in-alt"></i>
                                        Registrar cuenta
                                    </button>
                                </center>
                            </form>
                            <p></p>
                            </center>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="col-md-3 col-xs-12">
    </div>
    </div>



    <!-- Modal -->
    <div class="modal fade" id="registSuccessModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Registro completado</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Tu registro se ha completado de manera exitosa, ahora accede al portal para poder descargar el juego</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal"
                        onclick="javascript:window.location.href='Downloads.html';">
                        <i class="fas fa-download"></i>
                        Descargar "The Chamber"
                    </button>
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">
                        <i class="fas fa-check-circle"></i>
                        Listo
                    </button>
                </div>
            </div>
        </div>
    </div>

       <!-- Modal -->
    <div class="modal" id="bienvenidos" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="bienvenidoModalLabel"><i class="fas fa-info-circle"></i> Bienvenido</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Este portal es para registrarse para poder realizar el test psicometrico, llenando los datos proporcionados por Minsait</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">
                        <i class="fas fa-check-circle"></i>
                        Entendido
                    </button>
                </div>
            </div>
        </div>
    </div>

        <footer class="text-light">
            <!-- Copyright -->
            <div class="text-center p-3">
                © 2021 Copyright:
                <b>Chayomix Studios</b>
            </div>
            <!-- Copyright -->
        </footer>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>

</body>

</html>