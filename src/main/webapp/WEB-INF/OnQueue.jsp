<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>The Chamber - Control Panel</title>
  <!-- CSS Externo-->
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/favicon.ico" type="image/x-icon">
  <link rel="icon" href="${pageContext.request.contextPath}/img/favicon.ico" type="image/x-icon">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminPanel.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
  <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>


  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">
  <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/OnQueue.js"></script>

</head>
<body class="body-bcolor">
<c:if test="${not empty superAdministrador}">

</c:if>
      <div class="ind-login-box">
        <div class="row" style="padding: 1%">
          <div class="col-4">
            <div class="logoIndra">
              <img src="${pageContext.request.contextPath}/img/indra2.png" alt="Logo Indra" width="150px" height="30px">
              <h5>Admin Panel</h5>
            </div>
          </div>
          <div class="col-4">
            <h2>Candidatos en espera</h2>
            <c:if test="${not empty message}">
              <c:choose>
                <c:when test="${messageType == 'Success'}">
                  <div class="container">
                    <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" id="tostados">
                      <div class="toast-header">
                        <strong class="me-auto">The Chamber - Mnesaje</strong>
                        <small class="text-muted">Ahora</small>
                        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                      </div>
                      <div class="toast-body">
                          ${message}
                      </div>
                    </div>
                  </div>
                </c:when>
                <c:when test="${messageType == 'WarningError'}">
                  <div class="container">
                    <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" id="tostados">
                      <div class="toast-header">
                        <strong class="me-auto">The Chamber - Mnesaje</strong>
                        <small class="text-muted">Ahora</small>
                        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                      </div>
                      <div class="toast-body">
                          ${message}
                      </div>
                    </div>
                  </div>
                </c:when>
                <c:when test="${messageType == 'FatalError'}">
                  <div class="container">
                    <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" id="tostados">
                      <div class="toast-header">
                        <strong class="me-auto">The Chamber - Mnesaje</strong>
                        <small class="text-muted">Ahora</small>
                        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                      </div>
                      <div class="toast-body">
                          ${message}
                      </div>
                    </div>
                  </div>
                </c:when>
                <c:otherwise>
                  <div class="container">
                    <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" id="tostados">
                      <div class="toast-header">
                        <strong class="me-auto">The Chamber - Mnesaje</strong>
                        <small class="text-muted">Ahora</small>
                        <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                      </div>
                      <div class="toast-body">
                          ${message}
                      </div>
                    </div>
                  </div>
                </c:otherwise>
              </c:choose>
            </c:if>
          </div>
          <div class="col-4" style="text-align: right">
            <div class="row">
            <div class="col-10" style="text-align: right">
                <c:choose>
                  <c:when test="${not empty administrador}">
                    <b>Bienvenido: ${administrador.firstName} ${administrador.lastName}</b>
                    <br>
                    <b>Usuario: ${administrador.username}</b>
                    <br>
                    <b> Rol: ${administrador.roleName}</b>
                  </c:when>
                  <c:when test="${not empty superAdministrador}">
                    <b>Bienvenido: ${superAdministrador.firstName} ${administrador.lastName}</b>
                    <br>
                    <b>Usuario: ${superAdministrador.username}</b>
                    <br>
                    <b> Rol: ${superAdministrador.roleName}</b>
                  </c:when>
                  <c:otherwise>
                    <b>Bienvenido: ${administrador.firstName} ${administrador.lastName}</b>
                    <br>
                    <b>Usuario: ${administrador.username}</b>
                    <br>
                    <b> Rol: ${administrador.roleName}</b>
                  </c:otherwise>
                </c:choose>
            </div>
            <div class="col-2" style="text-align: right">
              <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#logOut">
                <i class="fas fa-sign-out-alt"></i>Salir</button>
            </div>
          </div>
          </div>
        </div>
        <div class="container" style="background: rgba(255, 255, 255, 1); padding: 10px;border-radius: 5px;">
          <div class="container-fluid" id="containBotones">
            <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                    onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminPanel';">
              <i class="fas fa-user-plus"></i> Volver al adminPanel
            </button>
          </div>
          <table id="OnQueue" class="table table-hover table-dark">
            <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Nombre(s)</th>
              <th scope="col">Apellido(s)</th>
              <th scope="col">Correo</th>
              <th scope="col">Teléfono</th>
              <th scope="col">Experiencia</th>
              <th scope="col">Perfil Tecnico</th>
              <th scope="col">Status de revisión</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${accTable}" var="cuenta" varStatus="status">
              <tr>
                <td>${cuenta.applicantId}</td>
                <td><c:out value="${cuenta.firstName}" /></td>
                <td><c:out value="${cuenta.lastName}" /></td>
                <td><c:out value="${cuenta.email}" /></td>
                <td><c:out value="${cuenta.phoneNumber}" /></td>
                <td><c:out value="${cuenta.experienceName}" /></td>
                <td><c:out value="${cuenta.profileName}" /></td>
                <td>${cuenta.reviewStatusName}<br>
                  <button id="${cuenta.applicantId}" type="button" class="btn btn-outline-primary btn-sm aplicante" data-bs-toggle="modal"
                            data-bs-target="#ModalCuenta">
                  <i class=" fas fa-info-circle"></i> VER / ACCIONES
                </button>
                </td>
            </c:forEach>
            </tbody>
          </table>
        </div>
      <div class="formbutton">
      </div>
    </div>


  <!-- Modal -->
  <div class="modal fade" id="createNew" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="createNewModalLabel"><i class="fas fa-user-plus"></i> Crear nuevo GID</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form role="form" action="gidMake" method="POST">
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">E-mail del candidato a enviar el GamerID</label>
              <input type="email" name="gIdEmail" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" value="example@example.com">
              <div id="emailHelp" class="form-text">Por favor, verifique la direccion de correo antes de enviar.</div>
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">GamerID a enviar</label>
              <input type="text" name="gIdUsername" class="form-control" id="exampleInputPassword1" value="ABCDE123">
            </div>
            <div class="mb-3 form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Enviar copia a correo Minsait</label>
            </div>
            <button type="submit" name="submitCreateNew" class="btn btn-success">Enviar</button>
          </form>
        </div>
      </div>
    </div>
  </div>

<!-- Modal -->
<div class="modal fade" id="Actualizado" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="ActualizadoModalLabel"><i class="fas fa-user-plus"></i> Candidato Actualizado</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form role="form" action="gidMake" method="POST">
          <div class="mb-3">
            <h3>Mensaje del servidor:</h3>
            <h4 id="serverMessage">Ninguno por el momento</h4>
          </div>
          <div class="mb-3">
            <label for="exampleInputPassword1" class="form-label">GamerID a generado (En caso de que la accion lo requiera)</label>
            <input type="text" name="gIdUsername" class="form-control" id="gamerIdGenerado" placeholder="La accion no requirio creacion de GamerID" disabled>
          </div>
          <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck1">
            <label class="form-check-label" for="exampleCheck1">Enviar copia a correo Minsait</label>
          </div>
          <button type="submit" name="submitCreateNew" class="btn btn-success">Enviar</button>
        </form>
      </div>
    </div>
  </div>
</div>

  <!-- Modal -->
  <div class="modal fade" id="ModalCuenta" role="dialog">
    <div class="modal-dialog modal-dialog-scrollable modal-xl">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="ModalLabelCuenta"><i class=" fas fa-info-circle"></i> Información del aplicante
          </h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <h5>Informacion básica</h5>
          <table class="table table-hover table-dark">
            <thead>
            <tr>
              <th>ID</th>
              <td id="appId"></td>
            </tr>
            <tr>
              <th>Nombre(s)</th>
              <td id="appFisrtName"></td>
            </tr>
            <tr>
              <th>Apellido(s)</th>
              <td id="appLastName"></td>
            </tr>
            <tr>
              <th>Correo</th>
              <td id="appEmail"></td>
            </tr>
            <tr>
              <th>Teléfono</th>
              <td id="appTel"></td>
            </tr>
            <tr>
              <th>Experiencia</th>
              <td id="appXp"></td>
            </tr>
            <tr>
              <th>Perfil Tecnico</th>
              <td id="appTecProf"></td>
            </tr>
            <tr>
              <th>Status de revisión</th>
              <td id="appRevStatus"></td>
            </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </div>
        <div>
          <center>
            <h6>Marcar aplicante como:</h6>
            <button type="button" class="btn btn-success btn-xl doAction" id="dAaccept"><i class="fas fa-check-circle"></i> APROBAR</button>
            <button type="button" class="btn btn-danger btn-xl doAction" id="dAReject"><i class="fas fa-times-circle"></i>  RECHAZAR</button>
            <button type="button" class="btn btn-secondary btn-xl doAction" id="dAasNotViewed"><i class="fas fa-clipboard"></i> SIN REVISAR</button>
            <button type="button" class="btn btn-warning btn-xl doAction" id="dAasViewed"><i class="fas fa-clipboard-check"></i> REVISADO</button>
            <p></p>
          </center>

        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-bs-dismiss="modal" aria-label="Close"> <i class="fas fa-check-circle"></i></button>
        </div>
      </div>
    </div>
  </div>



  <!-- Modal -->
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

  <div class="modal" id="bienvenido" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-info-circle"></i> Bienvenido: ${administrador.firstName}</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <p>Bienvenido a The Chamber WEB<br>En este portal podrás realizar diversas actividades administrativas, relacionadas al juego The Chamber
            <br>Dependiendo de tus permisos asignados a la cuenta, algunas actividades estarán restringidas<br>Actualmente eres un <b>${administrador.roleName}</b>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-success" data-bs-dismiss="modal">
            <i class="fas fa-check-circle"></i>
            Entiendo
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