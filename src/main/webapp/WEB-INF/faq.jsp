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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/FAQ.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/all.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/fontawesome.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
                            <h2>The Chamber</h2>
                            <h3>FAQ - Preguntas Frecuentes</h3>
                        </div>
                        <div class="ind-faq-box">
                            <div class="accordion" id="accordionExample">
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="headingOne">
                                        <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            <strong>&iquest;Qu&eacute; es &ldquo;The Chamber&rdquo;?</strong>
                                        </button>
                                    </h2>
                                    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <p>&ldquo;The Chamber&rdquo; es un juego de tipo escape room, donde tendr&aacute;s que probarte para poder escapar y completarlo.<br />Este es un juego exclusivo para personal autorizado (Usuarios con GamerID/usuario), por lo tanto requieres de uno para poder jugar.</p>                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="headingTwo">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                            <strong>&iquest;Qu&eacute; es un GamerID/Usuario?</strong>
                                        </button>
                                    </h2>
                                    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <p>Un GamerID/Usuario, es una cuenta de usuario que permite identificarte en todo el sistema de &ldquo;The Chamber&rdquo;, accediendo con un GamerID/Usuario v&aacute;lido, podr&aacute;s jugar a &ldquo;The Chamber&rdquo; y poder subir tu puntuaci&oacute;n.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="headingThree">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                            <strong>No tengo un GamerID, &iquest;Qu&eacute; puedo hacer?</strong>
                                        </button>
                                    </h2>
                                    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <p>Para obtener un Gamer es necesario ser un candidato a un puesto en Minsait, por lo tanto necesitas hacer una solicitud de empleo a Minsait, puedes hacerlo accediendo al portal de aplicantes <a href='${pageContext.request.contextPath}/'>aqu&iacute;</a>.</p>                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="headingFour">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                                            <strong>Minsait me asign&oacute; un GamerID &iquest;Qu&eacute; hago ahora?</strong>
                                        </button>
                                    </h2>
                                    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <p>Accede con tu usuario y contrase&ntilde;a que se ha mandado por correo electr&oacute;nico, para poder registrar tus datos, despu&eacute;s podr&aacute;s acceder al portal del juego.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="headingFive">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                                            <strong>Tengo un GamerID, pero al acceder al portal de acceso no puedo jugar a &ldquo;The Chamber&rdquo;, &iquest;Por qu&eacute;?</strong>
                                        </button>
                                    </h2>
                                    <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <p>Primero necesitamos obtener algunos datos personales antes de poder dejarte jugar, una vez que tu registro sea exitoso, podr&aacute;s acceder nuevamente y ser&aacute;s redirigido al juego.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="headingSix">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                                            <strong>Quiero aplicar para trabajar a minsait, &iquest;C&oacute;mo?</strong>
                                        </button>
                                    </h2>
                                    <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingSix" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <p>Puedes empezar enviando una solicitud de empleo a Minsait, puedes hacerlo accediendo al portal de aplicantes <a href='${pageContext.request.contextPath}/'>aqu&iacute;</a>.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="headingSeven">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
                                            <strong>&iquest;Es realmente necesario jugar a &ldquo;The Chamber&rdquo;?</strong>
                                        </button>
                                    </h2>
                                    <div id="collapseSeven" class="accordion-collapse collapse" aria-labelledby="headingSeven" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <p>Si, este juego tiene un doble prop&oacute;sito para Minsait, y es un <strong>requisito</strong> para cualquier candidato que desee aplicar a minsait.</p>
                                        </div>
                                    </div>
                                </div>
                                <div class="accordion-item">
                                    <h2 class="accordion-header" id="headingEight">
                                        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
                                            <strong>&iquest;Puedo volver a jugar a &ldquo;The Chamber&rdquo;?</strong>
                                        </button>
                                    </h2>
                                    <div id="collapseEight" class="accordion-collapse collapse" aria-labelledby="headingEight" data-bs-parent="#accordionExample">
                                        <div class="accordion-body">
                                            <p>No, solamente tienes un intento para jugar, despu&eacute;s de eso, no puedes volver a jugar.</p>
                                            <p>Si tienes algún problema al jugar, favor de contactar a Chayomix Studios o Minsait en **Inserte un correo aqui**.</p>
                                            <p>Podr&aacute;s volver a aplicar hasta despu&eacute;s de cierto tiempo.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <center>
                            <button type="button" class="btn btn-success" onclick="javascript:window.location.href='${pageContext.request.contextPath}/';"><i class="fas fa-user-tie"></i>
                                Regresar al portal principal
                            </button>
                        </center>
                    </div>
                </div>

        </div>

    </div>
    <div class="col-md-2 col-xs-12">
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