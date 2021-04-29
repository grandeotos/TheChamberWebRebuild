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
    <script src="${pageContext.request.contextPath}/js/apply.js"></script>
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
                            <br>
                            <h2>Registro</h2>
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
                            <p>Por favor, llena tus datos en el siguiente formulario:</p>
                            <br>
                        </div>
                        <div>

                        </div>
                        <div class="formbutton">
                            <form role="form" action="appReg" method="POST">
                                <div>
                                    <div class="form-group">
                                        <br>
                                        <label id="nameLabel" for="firstName">Nombre(s)</label>
                                        <input type="text" class="form-control" id="firstName"
                                            name="firstName" placeholder="Ingrese su(s) nombre(s)" required="required">
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="lastNameLabel" for="lastName">Apellidos(s)</label>
                                        <input type="text" class="form-control" id="lastName"
                                        name="lastName" placeholder="Ingrese su(s) Apellido(s)" required="required">
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="emailLabel" for="email">E-mail</label>
                                        <input type="email" class="form-control" id="email"
                                            name="email" placeholder="Ingrese su e-mail" required="required">
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="telepLabel" for="telep">Telefono</label>
                                        <input type="tel" class="form-control" id="telep"
                                        name="telep" placeholder="Ingrese su telefono" required="required">
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="experLabel" for="exper">Seleccione su experiencia</label>
                                        <br>
                                        <select id="exper" name="exper" class="form-control" required="required">
                                            <option value="1">Sin experiencia</option>
                                            <option value="2">Becas</option>
                                            <option value="3">Menos de 5 años</option>
                                            <option value="4">Más de 5 años</option>
                                            <option value="5">Gestión</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <br>
                                        <label id="profixLabel" for="profix">Seleccione su perfil</label>
                                        <br>
                                        <select id="profix" name="profix" class="form-control" required="required">
                                            <option value="1">Agencia digital</option>
                                            <option value="2">Arquitecturas</option>
                                            <option value="3">Big Data</option>
                                            <option value="4">Ciberseguridad</option>
                                            <option value="5">Consultoría ERP</option>
                                            <option value="6">Consultoría Estratégica y de Negocio</option>
                                            <option value="7">Consultoría Funcional</option>
                                            <option value="8">Consultoría Tecnológica</option>
                                            <option value="9">DataScience & AI</option>
                                            <option value="10">Desarrollo de Software</option>
                                            <option value="11">Hardware y Comunicaciones</option>
                                            <option value="12">Perfiles Corporativos</option>
                                            <option value="13">QA & Testing</option>
                                            <option value="14">Sistemas/BBDD/Redes</option>
                                            <option value="15">Soporte a Usuarios y Operación</option>
                                            <option value="16">Otros</option>
                                        </select>
                                    </div>
                                </div>
                                <br>
                                <center>
                                    <button type="submit" class="btn btn-primary"><i class="fas fa-arrow-circle-up"></i>
                                        Enviar solicitud
                                    </button>
                                    <p></p>
                                    <button type="button" class="btn btn-success" onclick="javascript:window.location.href='${pageContext.request.contextPath}/';"><i class="fas fa-user-tie"></i>
                                        Regresar al portal principal
                                    </button>
                                </center>
                            </form>
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
                    <p>Este panel es para aplicantes de "The Chamber", probablemente estes aquí por error</p>
                    <p>Da click al botón de <b>"Ir al panel de empleados"</b> para poder ingresar al portal
                        correspondiente para tí</p>
                    <p>Si eres aplicante de "The Chamber", estas en el portal correcto, y solo da clic al botón de
                        <b>"Seguir en este portal</b>"</p>
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
    <div class="modal fade" id="gamerIdModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="gamerIdModalModalLabel">Panel de Registro</h5>
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
                            onclick="javascript:window.location.href='${pageContext.request.contextPath}/';">
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
    <!-- Modal -->
    <div class="modal fade" id="empleadoWarn" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="empleadoWarnModalLabel">Atencion empleado</h5>
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
                        onclick="javascript:window.location.href='${pageContext.request.contextPath}/';">
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
        <!-- Modal -->
        <div class="modal" id="bienvenido" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="bienvenidoModalLabel"><i class="fas fa-info-circle"></i> Bienvenido</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <p>Si deseas aplicar para un trabajo en Minsait, puedes registrarte en este portal, para
                            poder ser elegible para jugar a "The Chamber"<br><br>Personal de Minsait se pondrá en
                            contacto contigo en caso de haber vacantes disponibles y se te dará un nombre de usuario (GamerID) e instrucciones para poder jugar a "The Chamber"<br><br>Si ya tienes un GamerID/Usuario asignado, da clic en el botón <b>"Volver al portal de inicio"</b><br><br>En caso contrario por favor, llena tus datos en el siguiente formulario, dando clic en el botón <b>"Aplicar"</b></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-warning" data-bs-dismiss="modal"
                            onclick="javascript:window.location.href='${pageContext.request.contextPath}/';">
                            <i class="fas fa-home"></i>
                            Volver al portal de inicio
                        </button>
                        <button type="button" class="btn btn-success" data-bs-dismiss="modal">
                            <i class="fas fa-check-circle"></i>
                            Aplicar
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
</body>

</html>