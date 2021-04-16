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
                            <h2>The Chamber</h2>
                        </div>
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
                        <div class="formbutton">
                            <form role="form" action="auth" method="POST">
                                <div>
                                    <div class="form-group">
                                        <br>
                                        <label for="username">Usuario</label>
                                        <input type="text" class="form-control" id="username" name="username"
                                            placeholder="Ingrese su usuario" required>
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label for="password">Contraseña</label>
                                        <input type="password" class="form-control" id="password" name="password"
                                            placeholder="Ingrese su contraseña" required>
                                    </div>
                                    <!--<div class="checkbox">
                                    <br>
                                    <label>
                                        <input type="checkbox"> Recordar contraseña (No recomendar en dispositivos compartidos)
                                    </label>
                                </div>-->
                                    <div class="form-group">
                                        <br>
                                        <button type="submit" class="btn btn-primary"
                                            ><i class="fas fa-sign-in-alt"></i>
                                            Entrar a panel
                                        </button>
                                    </div>
                                    <p></p>
                                </div>
                            </form>
                            <div class="container">
                                <center>
                                    <button type="button" class="btn btn-warning" data-bs-toggle="modal"
                                    data-bs-target="#aplicanteInfo"> <i class="fas fa-question-circle"></i>
                                    ¿Deseas trabajar con nosotros?
                                </button>
                                    <p> </p>
                                    <button type="button" class="btn btn-success" onclick="javascript:window.location.href='${pageContext.request.contextPath}/FAQ';"> <i class="fas fa-question-circle"></i>
                                        Preguntas frecuentes (FAQ)
                                    </button>
                                </center>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="col-md-3 col-xs-12">
    </div>

    <!-- Modal -->
    <div class="modal fade" id="aplicanteInfo" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"><b>Atención</b></h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Bienvenido a The Chamber, un juego psicometrico para probar tus habilidades
                   <br>Si deseas aplicar para trabajar para minsait, por favor revisa el botón <b>"Aplicar a Minsait"</b> para ser redirigido al portal correspondiente y subir tu solicitud</p>
                    Si eres...
                    <ul>
                        <li>Empleado de Minsait, solamente entra con tus credenciales correspondientes, y serás redirigido al panel de control</li>
                        <li>Un candidato con un gamerID asignado, puedes entrar al portal con tu GamerID y la contraseña es tu correo, esto te llevará al portal de registro<br>O puedes dar clic al botón <b>"Registrar (GamerID)"</b> para ir al portal de registro</li>
                    </ul>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal"
                            onclick="javascript:window.location.href='${pageContext.request.contextPath}/apply';">
                        <i class="fas fa-arrow-circle-up"></i>
                        Aplicar a Minsait
                    </button>
                    <button type="button" class="btn btn-secondary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/FAQ';"> <i class="fas fa-question-circle"></i>
                        Preguntas frecuentes (FAQ)
                    </button>
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">
                        <i class="fas fa-check-circle"></i>
                    </button>

                </div>
            </div>
        </div>
    </div>
    <div class="modal" id="bienvenido" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="bienvenidoModalLabel"><i class="fas fa-info-circle"></i> Bienvenido</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Bienvenido a The Chamber, un juego psicometrico para probar tus habilidades
                        <br>Si deseas aplicar para trabajar para minsait, por favor revisa el botón <b>"Aplicar a Minsait"</b> para ser redirigido al portal correspondiente y subir tu solicitud</p>
                    Si eres...
                    <ul>
                        <li>Empleado de Minsait -- Puedes entrar con tus credenciales correspondientes, y serás redirigido al panel de control</li>
                        <li>Un candidato con un gamerID asignado sin registrar -- Puedes entrar al portal con tu GamerID y la contraseña asignada en tu correo de confirmacion</li>
                        <li>Un candidato con un gamerID asignado y que se ha registrado -- Puedes entrar con tu gamerID asignado y contrasena</li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal"
                            onclick="javascript:window.location.href='${pageContext.request.contextPath}/apply';">
                        <i class="fas fa-arrow-circle-up"></i>
                        Aplicar a Minsait
                    </button>
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">
                        <i class="fas fa-check-circle"></i>
                        Seguir en este portal
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
    <!-- Footer -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>

</body>

</html>