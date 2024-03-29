<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>The Chamber - Control Panel</title>
  <!-- CSS Externo-->
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
  <div class="holamundo">
    <div class="container">
      <div class="ind-login-box">
        <p class="redirection" id="${pageContext.request.contextPath}"></p>
        <div class="ind-login-text">
          <img src="../img/indra2.png " class="img-fluid" alt="Logo Indra">
          <h2>Admin Panel</h2>
        </div>
        <b>Logueado como: Test01</b>
        <br>
        <br>
        <div class="container-fluid">
          <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#createNew">
            <i class="fas fa-user-plus"></i> Crear nuevo GID
          </button>
          <button type="button" class="btn btn-danger">
            <i class="far fa-file-pdf"></i> Exportar selección a PDF
          </button>
          <button type="button" class="btn btn-success">
            <i class="fas fa-file-csv"></i> Exportar selección a CSV
          </button>
          <button type="button" class="btn btn-success">
            <i class="fas fa-check-square"></i> Seleccionar TODOS
          </button>
          <button type="button" class="btn btn-secondary">
            <i class="fas fa-times-circle"></i> Quitar selección
          </button>
          <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="#logOut">
            <i class="fas fa-sign-out-alt"></i> Cerrar sesión
          </button>
        </div>
        <br>
        <div class="container"style="background: rgba(255, 255, 255, 1); padding: 10px;border-radius: 5px;">
          <table id="TheChamber" class="table table-hover table-dark">
            <thead>
            <tr>
              <th scope="col">GamerID</th>
              <th scope="col">Nombre(s)</th>
              <th scope="col">Apellido(s)</th>
              <th scope="col">Status</th>
              <th scope="col">Descargas</th>
            </tr>
            </thead>
            <tbody>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            <tr>
              <th scope="row"><input type="checkbox" name="gamerid"> MXA01246040</th>
              <td>Carlos Gerardo</td>
              <td>Olivas Córdova</td>
              <td>SIN INICIAR</td>
              <td>
                <button type="button" class="btn btn-outline-primary" data-bs-toggle="modal"
                        data-bs-target="#infoModal">
                  <i class=" fas fa-info-circle"></i>
                </button>
                <button type="button" class="btn btn-outline-danger">
                  <i class="far fa-file-pdf"></i>
                </button>
                <button type="button" class="btn btn-outline-success">
                  <i class="fas fa-file-csv"></i>
                </button>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      <div class="formbutton">
      </div>
    </div>
  </div>
  </div>



  <!-- Modal -->
  <div class="modal fade" id="infoModal" role="dialog">
    <div class="modal-dialog modal-dialog modal-dialog-scrollable modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel"><i class=" fas fa-info-circle"></i> Información del candidato
          </h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">

          <h5>Informacion básica</h5>
          <table class="table table-hover table-dark">
            <tbody>
              <tr>
                <th scope="row">GamerID</th>
                <td>MXA01246040</td>
              </tr>
              <tr>
                <th scope="row">Nombre del candidato</th>
                <td>Carlos Gerardo Olivas Córdova</td>
              </tr>
              <tr>
                <th scope="row">STATUS DE JUEGO</th>
                <td>COMPLETADO</td>
              </tr>
              <tr>
                <th scope="row">PUNTAJE</th>
                <td>EXCELENTE (100 / 100)</td>
              </tr>
              <tr>
                <th scope="row">FECHA DE INICIO</th>
                <td>11/03/2021 22:09 CDT</td>
              </tr>
              <tr>
                <th scope="row">FECHA DE FINAL</th>
                <td>12/03/2021 07:09 CDT</td>
              </tr>
            </tbody>
          </table>
          <h5>Resultados desglosados</h5>
          <table class="table table-hover table-dark">
            <thead>
              <tr>
                <th scope="col">Dato</th>
                <th scope="col">Tiempo de juego</th>
                <th scope="col">Resultado</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">TUTORIAL (SIN VALOR)</th>
                <td>01:59:59</td>
                <td>100 / 100</td>
              </tr>
              <tr>
                <th scope="row">Nivel 1 (PRESION)</th>
                <td>01:59:59</td>
                <td>100 / 100</td>
              </tr>
              <tr>
                <th scope="row">Nivel 1 (LÓGICA)</th>
                <td>01:59:59</td>
                <td>100 / 100</td>
              </tr>
              <th scope="row">Nivel 2 (PRESION)</th>
              <td>01:59:59</td>
              <td>100 / 100</td>
              </tr>
              <tr>
                <th scope="row">Nivel 2 (LÓGICA)</th>
                <td>01:59:59</td>
                <td>100 / 100</td>
              </tr>
              <th scope="row">Nivel 3 (PRESION)</th>
              <td>01:59:59</td>
              <td>100 / 100</td>
              </tr>
              <tr>
                <th scope="row">Nivel 3 (LÓGICA)</th>
                <td>01:59:59</td>
                <td>100 / 100</td>
              </tr>
              <th scope="row">Nivel 4 (PRESION)</th>
              <td>01:59:59</td>
              <td>100 / 100</td>
              </tr>
              <tr>
                <th scope="row">Nivel 4 (LÓGICA)</th>
                <td>01:59:59</td>
                <td>100 / 100</td>
              </tr>
              <th scope="row">Nivel 3 (LÓGICA)</th>
              <td>01:59:59</td>
              <td>100 / 100</td>
              </tr>
              <th scope="row">Nivel 5 (PRESION)</th>
              <td>01:59:59</td>
              <td>100 / 100</td>
              </tr>
              <tr>
                <th scope="row">Nivel 5 (LÓGICA)</th>
                <td>01:59:59</td>
                <td>100 / 100</td>
              </tr>
              <tr>
                <th scope="row">Nivel 5 (EMOCIONAL)</th>
                <td>01:59:59</td>
                <td>100 / 100</td>
              </tr>
              <tr>
                <th scope="row">TOTAL</th>
                <td>01:59:59</td>
                <td>100 (EXCELENTE)</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-danger">
            <i class="far fa-file-pdf"></i> Exportar reporte a PDF
          </button>
          <button type="button" class="btn btn-success">
            <i class="fas fa-file-csv"></i> Exportar datos a CSV
          </button>
        </div>
      </div>
    </div>
  </div>

  <!-- Modal -->
  <div class="modal fade" id="createNew" role="dialog">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel"><i class="fas fa-user-plus"></i> Crear nuevo GID</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form>
            <div class="mb-3">
              <label for="exampleInputEmail1" class="form-label">E-mail del candidato a enviar el GamerID</label>
              <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
              <div id="emailHelp" class="form-text">Por favor, verifique la direccion de correo antes de enviar.</div>
            </div>
            <div class="mb-3">
              <label for="exampleInputPassword1" class="form-label">GamerID a enviar</label>
              <input type="text" class="form-control" id="exampleInputPassword1" value="MXA01751038"
                readonly="readonly">
            </div>
            <div class="mb-3 form-check">
              <input type="checkbox" class="form-check-input" id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">Enviar copia a correo Minsait</label>
            </div>
            <button type="submit" class="btn btn-success">Enviar</button>
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
            onclick="javascript:window.location.href='LoginPanel.html';">
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
  <footer class="text-light">
    <!-- Copyright -->
    <div class="text-center p-3">
        © 2021 Copyright:
        <b>Chayomix Studios</b>
    </div>
    <!-- Copyright -->
</footer>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</body>

</html>