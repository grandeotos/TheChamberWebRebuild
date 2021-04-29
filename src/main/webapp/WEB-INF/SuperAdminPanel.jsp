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

</head>

<body class="body-bcolor">
<div class="ind-login-box">
  <div class="row" style="padding: 1%">
    <div class="col-4">
      <div class="logoIndra">
        <img src="${pageContext.request.contextPath}/img/indra2.png" alt="Logo Indra" width="150px"
             height="30px">
        <h5>Admin Panel</h5>
      </div>
    </div>
    <div class="col-4">
      <div class="container">
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" id="tostados">
          <div class="toast-header">
            <strong class="me-auto">The Chamber - Mnesaje</strong>
            <small class="text-muted">Ahora</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
          </div>
          <div class="toast-body" id="tostadosMensaje">
          </div>
        </div>
      </div>
    </div>
    <div class="col-4" style="text-align: right">
      <div class="row">
        <div class="col-10" style="text-align: right">
          <b>Bienvenido: ${superAdministrador.firstName} ${superAdministrador.lastName}</b>
          <br>
          <b>Usuario: ${superAdministrador.username}</b>
          <br>
          <b> Rol: ${superAdministrador.roleName}</b>
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
      <button type="button" class="btn btn-primary createNewGamer" data-bs-toggle="modal"
              data-bs-target="#createNew">
        <i class="fas fa-user-plus"></i> Crear nuevo GID
      </button>
      <button type="button" class="btn btn-danger createNewAdmin" data-bs-toggle="modal"
              data-bs-target="#createNewAdminModal">
        <i class="fas fa-user-plus"></i> Crear nuevo Administrador
      </button>
      <button type="button" class="btn btn-secondary" data-bs-toggle="modal"
              onclick="javascript:window.location.href='${pageContext.request.contextPath}/OnQueue';">
        <i class="fas fa-list-ol"></i> Ver nuevos candidatos
      </button>
    </div>
    <table id="TheChamber" class="table table-hover table-dark">
      <thead>
      <tr>
        <th scope="col">GamerID</th>
        <th scope="col">Nombre(s)</th>
        <th scope="col">Apellido(s)</th>
        <th scope="col">Correo</th>
        <th scope="col">Rol</th>
        <th scope="col">Descargas</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${accTable}" var="cuenta" varStatus="status">
        <tr>
          <td>${cuenta.username}</td>
          <td>
            <c:out value="${cuenta.firstName}" />
          </td>
          <td>
            <c:out value="${cuenta.lastName}" />
          </td>
          <td>
            <c:out value="${cuenta.email}" />
          </td>
          <td>
            <c:out value="${cuenta.roleName}" />
          </td>
          <td>
            <form role="form" action="advancedView" method="POST">
              <button type="button" id="${cuenta.username}" class="btn btn-outline-primary datos"
                      data-bs-toggle="modal" data-bs-target="#ModalInfo">
                <i class=" fas fa-info-circle"></i> VER
              </button>
              <input type="hidden" id="accountIdHidden${status.index}" name="username" value="${cuenta.username}">
              <input type="hidden" id="generatedByHidden${status.index}" name="generatedBy" value="${superAdministrador.username} ${superAdministrador.firstName} ${superAdministrador.lastName}">
              <button type="submit" class="btn btn-outline-danger">
              <i class="far fa-file-pdf"></i> PDF
            </button>
            </form>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <div class="formbutton">
  </div>
</div>
</div>



<!-- Modal -->
<div class="modal fade" id="ModalInfo" role="dialog">
  <div class="modal-dialog modal-dialog-scrollable modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="ModalLabels"><i class=" fas fa-info-circle"></i> Información del
          candidato
        </h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <h5>Informacion básica</h5>
        <table class="table table-hover table-dark">
          <thead>
          </thead>
          <tbody>
          <tr>
            <th>GamerID</th>
            <td id="username2"></td>
          </tr>
          <tr>
            <th scope="row">Nombre</th>
            <td id="fullName"></td>
          </tr>
          <tr>
            <th scope="row">Correo</th>
            <td id="emailModal"></td>
          </tr>
          <tr>
            <th scope="row">CURP</th>
            <td id="curpModal"></td>
          </tr>
          <tr>
            <th scope="row">Rol del GamerID</th>
            <td id="roleNameModal"></td>
          </tr>
          </tbody>
        </table>
        <h5>Test mas reciente</h5>
        <table class="table table-hover table-dark">
          <thead>
          <tr>
            <th scope="col">#Prueba (#ID General)</th>
            <th scope="col">Status</th>
            <th scope="col">Fecha de Inicio</th>
            <th scope="col">Fecha de Terminacion</th>
            <th scope="col">Tiempo tomado</th>
            <th scope="col">Puntaje general</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td id="testId"></td>
            <td id="testStatus"></td>
            <td id="beginAt"></td>
            <td id="finishAt"></td>
            <td id="timeElapsed"></td>
            <td id="score"></td>
          </tr>
          </tbody>
        </table>
        <h5>Puntajes de soft-skills del test más reciente</h5>
        <table class="table table-hover table-dark">
          <thead>
          <tr>
            <th scope="col">SCORE ID</th>
            <th scope="col">PRUEBA</th>
            <th scope="col">SOFT SKILL</th>
            <th scope="col">Resultado</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td id="scoreIdOne"></td>
            <td id="testIdOne"></td>
            <td id="softSkillOne"></td>
            <td id="scoreOne"></td>
          </tr>
          <tr>
            <td id="scoreIdTwo"></td>
            <td id="testIdTwo"></td>
            <td id="softSkillTwo"></td>
            <td id="scoreTwo"></td>
          </tr>
          <tr>
            <td id="scoreIdThree"></td>
            <td id="testIdThree"></td>
            <td id="softSkillThree"></td>
            <td id="scoreThree"></td>
          </tr>
          <tr>
            <td id="scoreIdFour"></td>
            <td id="testId1Four"></td>
            <td id="softSkillFour"></td>
            <td id="scoreFour"></td>
          </tr>
          </tbody>
        </table>
      </div>
      <center>
        <p>Para consultar todas las pruebas y puntuaciones individuales en las que se ha encontrado este
          usuario, abra el reporte completo en WEB</p>
      </center>
      <div class="modal-footer">
        <form role="form" action="advancedView" method="POST">
          <button type="button" class="btn btn-success advanced" id="advancedReport">
            <i class="fas fa-id-card"></i>
            Ver reporte completo en WEB
          </button>
          <input type="hidden" class="accountIdHiddenModal" id="accountIdHiddenModal" name="username">
          <input type="hidden" id="generatedByHiddenModal" name="generatedBy" value="${superAdministrador.username} - ${superAdministrador.firstName} ${superAdministrador.lastName}">
          <button type="submit" class="btn btn-danger export">
            <i class="far fa-file-pdf"></i> Exportar reporte a PDF
          </button>
        </form>
      </div>
    </div>
  </div>
</div>



<!-- Modal -->
<div class="modal fade" id="createNew" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="createNewModalLabel"><i class="fas fa-user-plus"></i> Crear nuevo GID
        </h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form role="form" action="gidCMake" method="POST" id="formNewGID">
          <div class="mb-3">
            <label for="emailInputNewGID" class="form-label">E-mail del candidato a enviar el
              GamerID</label>
            <input type="email" name="email" class="form-control" id="emailInputNewGID"
                   aria-describedby="emailHelp" value="example@example.com">
            <div id="emailHelp" class="form-text">Por favor, verifique la direccion de correo antes de
              enviar.</div>
          </div>
          <div class="mb-3">
            <label for="randomGamerIdShow" class="form-label">GamerID a enviar</label>
            <input type="text" class="form-control" id="randomGamerIdShow" disabled>
            <input type="hidden" name="username" class="form-control" id="randomGamerIdHidden">
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
<div class="modal fade" id="createNewAdminModal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="createNewAdminModalLabel"><i class="fas fa-user-plus"></i> Crear nuevo Administrador
        </h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form role="form" action="admMake" method="POST" id="formNewAdm">
          <div class="mb-3">
            <label for="emailInputNewGID" class="form-label">E-mail del administrador a enviar el
              Username</label>
            <input type="email" name="email" class="form-control" id="emailInputNewAdm"
                   aria-describedby="emailHelp" value="example@example.com">
            <div id="emailHelpAdm" class="form-text">Por favor, verifique la direccion de correo antes de
              enviar.</div>
          </div>
          <div class="mb-3">
            <label for="randomAdmShow" class="form-label">Username a enviar</label>
            <input type="text" class="form-control" id="randomAdmShow" disabled>
            <input type="hidden" name="username" class="form-control" id="randomAdmHidden">
          </div>
          <div class="mb-3">
            <label for="accountTypeAdm">Crear cuenta como:</label>
            <select id="accountTypeAdm" name="accountTypeAdm" form="formNewAdm">
              <option value="adm">Administrador - Solo crea candidatos</option>
              <option value="super">Super-Administrador - Creacion de administradores y candidatos</option>
            </select>
          </div>
          <div class="mb-3 form-check">
            <input type="checkbox" class="form-check-input" id="exampleCheck2">
            <label class="form-check-label" for="exampleCheck1">Enviar copia a correo Minsait</label>
          </div>
          <button type="submit" name="submitCreateNewAdmin" class="btn btn-success">Enviar</button>
        </form>
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
        <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-info-circle"></i> Bienvenido:
          ${superAdministrador.firstName}</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>Bienvenido a The Chamber WEB<br>En este portal podrás realizar diversas actividades
          administrativas, relacionadas al juego The Chamber
          <br>Dependiendo de tus permisos asignados a la cuenta, algunas actividades estarán
          restringidas<br>Actualmente eres un <b>${superAdministrador.roleName}</b>
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


<script type="text/javascript" src="${pageContext.request.contextPath}/js/superAdminPanel.js"></script>
</body>

</html>