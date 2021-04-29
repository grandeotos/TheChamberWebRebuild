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
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/advancedView.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
  <script src="${pageContext.request.contextPath}/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.3.4/jspdf.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js" type="text/javascript"></script>
  <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css">



</head>

<body class="body-bcolor">
<div class="ind-login-box">
  <div class="row" style="padding: 1%">
    <div class="col-4">
      <div class="logoIndra">
        <img src="${pageContext.request.contextPath}/img/indra2.png" alt="Logo Indra" width="150px"
             height="30px">
        <h5>Admin Panel</h5>
        <p>Advanced Player View</p>
      </div>
    </div>
    <div class="col-4">
      <c:if test="${not empty message}">
        <c:choose>
          <c:when test="${messageType == 'Success'}">
            <div class="container">
              <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" id="tostados">
                <div class="toast-header">
                  <strong class="me-auto">The Chamber - Mnesaje</strong>
                  <small class="text-muted">Ahora</small>
                  <button type="button" class="btn-close" data-bs-dismiss="toast"
                          aria-label="Close"></button>
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
                  <button type="button" class="btn-close" data-bs-dismiss="toast"
                          aria-label="Close"></button>
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
                  <button type="button" class="btn-close" data-bs-dismiss="toast"
                          aria-label="Close"></button>
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
                  <button type="button" class="btn-close" data-bs-dismiss="toast"
                          aria-label="Close"></button>
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


  <div class="container-fluid" id="containBotones">
  </div>
  <div class="container"
       style="background: rgba(255, 255, 255, 1); padding: 5px;border-radius: 5px;color: black">
    <form role="form" action="advancedView" method="POST">
      <button type="button" class="btn btn-primary" data-bs-toggle="modal"
              onclick="javascript:window.location.href='${pageContext.request.contextPath}/adminPanel';">
        <i class="fas fa-user-plus"></i> Volver al adminPanel
      </button>
      <input type="hidden" id="accountIdHidden" name="username" value="${cuenta.username}">
      <input type="hidden" id="generatedByHidden" name="generatedBy" value="
      <c:choose>
            <c:when test="${not empty administrador}">
              ${administrador.username} - ${administrador.firstName} ${administrador.lastName}
            </c:when>
            <c:when test="${not empty superAdministrador}">
              ${superAdministrador.username} - ${superAdministrador.firstName} ${superAdministrador.lastName}
            </c:when>
            <c:otherwise>
            ${administrador.username} - ${administrador.firstName} ${administrador.lastName}
            </c:otherwise>
      </c:choose>">
      <button type="submit" class="btn btn-danger">
        <i class="far fa-file-pdf"></i> Obtener reporte en PDF
      </button>
    </form>

    <h5>Informacion básica de ${cuenta.firstName} ${cuenta.lastName} </h5>
    <table class="table table-hover table-dark">
      <tbody>
      <tr>
        <th scope="row">GamerID</th>
        <th scope="row">${cuenta.username}</th>
      </tr>
      <tr>
        <th scope="row">Nombre</th>
        <th scope="row">${cuenta.firstName} ${cuenta.lastName}</th>
      <tr>
        <th scope="row">Rol del GamerID</th>
        <th scope="row">${cuenta.roleName}</th>
      </tr>
      </tbody>
    </table>
    <c:catch var="catchException">
      <h5>Resultados Generales</h5>
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
        <c:forEach items="${cuenta.testList}" var="test" varStatus="testLista">
          <tr>
            <td>${testLista.index+1} ( ${test.testId} )</td>
            <td>${test.testStatus}</td>
            <td>${test.beganAtTimeStamp}</td>
            <td>${test.finishedAtTimeStamp}</td>
            <td>${test.duration} Segundos</td>
            <td>${test.overallScore}</td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <p></p>
      <h4>Puntajes por prueba</h4>
      <c:forEach items="${cuenta.testList}" var="test" varStatus="testLista">
        <strong>Test ${testLista.index+1}</strong>
        <div class="accordion" id="accordionScore${testLista.index}">
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
            <c:forEach items="${test.scores}" var="score" varStatus="b">
              <tr>
                <td>${score.scoreId}</td>
                <td>${score.test_testId}</td>
                <td>${score.softSkillName}</td>
                <td>${score.softSkillScore} / 100</td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
      </c:forEach>
      <h4>Resultados desglosados</h4>
      <c:forEach items="${cuenta.testList}" var="test" varStatus="testLista">
        <strong>Test ${testLista.index+1}</strong>
        <table class="table table-hover table-dark">
          <thead>
          <tr>
            <th scope="col">NIVEL</th>
            <th scope="col">PUZZLE</th>
            <th scope="col">SOFT SKILL</th>
            <th scope="col">Tiempo de juego</th>
            <th scope="col">Resultado</th>
            <th scope="col">Completado</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${test.checkpoints}" var="chkptTest" varStatus="b">
            <tr>
              <td>${chkptTest.levelName}</td>
              <td>${chkptTest.puzzleName}</td>
              <td>${chkptTest.softSkillName}</td>
              <td>${chkptTest.timeElapsed} Segundos</td>
              <td>${chkptTest.score} / ${chkptTest.maxScore}</td>
              <td>${chkptTest.timeStamp}</td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </c:forEach>
    </c:catch>
    <c:if test="${catchException != null}">
      <p>The exception is : ${catchException} <br />
        There is an exception: ${catchException.message}</p>
    </c:if>
  </div>
</div>
<div class="formbutton">
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
          ${administrador.firstName}</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <p>Bienvenido a The Chamber WEB<br>En este portal podrás realizar diversas actividades
          administrativas, relacionadas al juego The Chamber
          <br>Dependiendo de tus permisos asignados a la cuenta, algunas actividades estarán
          restringidas<br>Actualmente eres un <b>${administrador.roleName}</b>
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


<script type="text/javascript" src="${pageContext.request.contextPath}/js/advancedView.js"></script>
</body>

</html>