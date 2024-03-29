<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The Chamber - Control Panel</title>
    <!-- CSS Externo-->
    <link rel="stylesheet" href="css/LoginReg.css" />
    <link rel="stylesheet" href="css/all.css" />
    <link rel="stylesheet" href="css/fontawesome.css" />
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script src="js/bootstrap.bundle.min.js"></script>
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
                            <img src="img/indra2.png " class="img-fluid" alt="Logo Indra">
                            <br>
                            <h2>Centro de descargas</h2>
                        </div>
                        <div class="formbutton">
                            <h3>The Chamber for Windows</h3>
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal"
                                onclick="javascript:window.location.href='LoginPanel.html';">
                                <i class="fab fa-windows"></i>
                                Windows 64-bit
                            </button>
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal"
                                onclick="javascript:window.location.href='LoginPanel.html';">
                                <i class="fab fa-windows"></i>
                                Windows 32-bit
                            </button>
                            <p></p>
                            <h3>The Chamber for Mac</h3>
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal"
                                onclick="javascript:window.location.href='LoginPanel.html';">
                                <i class="fab fa-apple"></i>
                                Apple 64-bit
                            </button>
                            <p></p>
                            <h2>Requisitos Minimos</h2>
                            <ul>SO: Windows 8/8.1/10 o Mac OS "El Capitan"</ul>
                            <ul>Procesador: Una patata</ul>
                            <ul>RAM: Al menos 1GB </ul>
                        </div>
                        <center>
                            <div class="downFoot">
                                <button type="button" class="btn-warning btn-sm"
                                    onclick="javascript:window.location.href='https://www.google.com/';">
                                    <i class="fas fa-sign-out-alt"></i>
                                    Salir
                                </button>
                            </div>
                        </center>
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

    <footer>
        <!-- Copyright -->
        <div class="text-center p-3">
            © 2021 Copyright:
            <b class="text-dark">Team The Chamber</b>
        </div>
        <!-- Copyright -->
    </footer>
    <!-- Footer -->
</body>

</html>