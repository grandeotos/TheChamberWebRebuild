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
    <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
</head>

<body class="body-bcolor">
    <div class="row">
        <div class="col-md-2 col-xs-12">
        </div>
        <div class="col-md-8 col-xs-12">
            <div class="holamundo">
                <div class="container">
                    <div class="ind-login-box">
                        <div class="ind-login-text">
                            <img src="${pageContext.request.contextPath}/img/indra2.png " class="img-fluid" alt="Logo Indra">
                            <br>
                            <h2>The Chamber</h2>
                            <br>
                            <h3>Juego finalizado</h3>
                            <h4>Hola, jugador, si ves esta página, es porque ya has finalizado el juego, felicidades.
                            <br>Espera a recibir un correo de minsait con los proximos pasos a seguir</h4>
                            <h5>Muchas gracias por jugar<br>Atentamente:</h5>
                            <h6>Chayomix Studios & minsait</h6>
                        </div>
                        <br>
                        <center>
                            <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#logOut">
                                <i class="fas fa-sign-out-alt"></i> Cerrar sesión
                            </button>
                        </center>

                        <br>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <div class="col-md-2 col-xs-12">
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
                    <p>Este panel es para aplicantes de "The Chamber", probablemente estes aquí por error</p>
                    <p>Da click al botón de <b>"Ir al panel de empleados"</b> para poder ingresar al portal
                        correspondiente para tí</p>
                    <p>Si eres aplicante de "The Chamber", estas en el portal correcto, y solo da clic al botón de
                        <b>"Seguir en este portal</b>"</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">
                        <i class="fas fa-download"></i>
                        Descargar "The Chamber"
                    </button>
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal"
                        onclick="javascript:window.location.href='LoginPanel.html';">
                        <i class="fas fa-check-circle"></i>
                        Listo
                    </button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="aplicanteModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">¡ATENCIÓN EMPLEADO!</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Este panel es para aplicantes de "The Chamber", probablemente estes aquí por error</p>
                    <p>Da click al botón de <b>"Ir al panel de empleados"</b> para poder ingresar al portal
                        correspondiente para tí</p>
                    <p>Si eres aplicante de "The Chamber", estas en el portal correcto, y solo da clic al botón de
                        <b>"Seguir en este portal</b>"</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-warning" data-bs-dismiss="modal"
                        onclick="javascript:window.location.href='LoginPanel.html';">
                        <i class="fas fa-sign-out-alt"></i>
                        Ir al panel de empleados
                    </button>
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">
                        <i class="fas fa-check-circle"></i>
                        Seguir en este portal
                    </button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal" id="bienvenido" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-info-circle"></i> Bienvenido</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p>Bienvenido a The Chamber WEB<br>En este portal podrás realizar diversas actividades relacionadas al Portal de The Chamber
                        <br>Para entrar, ingresa tus credenciales correspondientes<br>En este portal Solamente pueden entrar
                    <ul>
                        <li>Empleado de Minsait</li>
                        <li>Candidatos que se les haya asignado un GamerID</li>
                    </ul>
                    Si eres un aplicante, revisa el botón <b>"Aplicar a Minsait"</b>
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
    <div class="modal fade" id="logOut" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5>
                        <i class="fas fa-sign-out-alt"> </i> Cerrar sesión
                    </h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <h2>¿Deseas cerrar sesión?</h2>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal"
                            onclick="javascript:window.location.href='${pageContext.request.contextPath}/logout';">
                        <i class="fas fa-sign-out-alt"></i>
                        Cerrar sesión
                    </button>
                    <button type="button" class="btn btn-success" data-bs-dismiss="modal">
                        <i class="fas fa-check-circle"></i>
                        Seguir en este portal
                    </button>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <!-- Copyright -->
        <div class="text-center p-3">
            © 2021 Copyright:
            <b class="text-dark">Team The Chamber</b>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/play.js"></script>

</body>

</html>