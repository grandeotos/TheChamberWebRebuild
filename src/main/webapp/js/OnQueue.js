$(document).ready(function() {
    //select the close by class and apply a click even listener
    /*if(sessionStorage.getItem('#modalAdminPanel') !== 'true'){
        $('#bienvenido').modal('show');
//then the modal will be set true in the current session due to which the modal won't
//reappear on the refresh, we need to reload the page in a new tab to make the modal
//reappear.
        sessionStorage.setItem('#modalAdminPanel','true');
    }
    else {
        $('#bienvenido').modal('hide');
    }*/
    //$('.toast').toast('show');
    $('#OnQueue').DataTable( {
        language: { //Holaaa
            url: '//cdn.datatables.net/plug-ins/1.10.24/i18n/Spanish.json'
        }

    } );
    $('.toast').toast({
        delay: 1500
    })

    var appId = 0;
    $(".aplicante").click(function(){
        console.log("Clic de botones");
        appId = $(this).attr("id");
        console.log(appId);
        $.ajax({
            url: "getApplicantInternal",
            method: "POST",
            data: {
                appId: appId
            },
            success: function(data){
                $("#appId").html(data.applicantId);
                $("#appFisrtName").html(data.firstName);
                $("#appLastName").html(data.lastName);
                $("#appEmail").html(data.email);
                $("#appTel").html(data.phoneNumber);
                $("#appXp").html(data.experienceName);
                $("#appTecProf").html(data.profileName);
                $("#appRevStatus").html(data.reviewStatusName);
                switch (data.reviewStatus){
                    case 0:
                        $("#dAaccept").prop( "disabled", false );
                        $("#dAReject").prop( "disabled", false );
                        $("#dAasNotViewed").prop( "disabled", true );
                        $("#dAasViewed").prop( "disabled",  false);

                        break;
                    case 1:
                    case 3:
                        $("#dAaccept").prop( "disabled", true );
                        $("#dAReject").prop( "disabled", true );
                        $("#dAasNotViewed").prop( "disabled", true );
                        $("#dAasViewed").prop( "disabled", true );
                        break;
                    case 2:
                        $("#dAaccept").prop( "disabled", false );
                        $("#dAReject").prop( "disabled", false );
                        $("#dAasNotViewed").prop( "disabled", false );
                        $("#dAasViewed").prop( "disabled", true );

                        break;
                    case 4:
                        $("#dAaccept").prop( "disabled", false );
                        $("#dAReject").prop( "disabled", false );
                        $("#dAasNotViewed").prop( "disabled", false );
                        $("#dAasViewed").prop( "disabled", false );
                        break;
                    default:
                        $("#dAaccept").prop( "disabled", true );
                        $("#dAReject").prop( "disabled", true );
                        $("#dAasNotViewed").prop( "disabled", true );
                        $("#dAasViewed").prop( "disabled", false );
                        break;

                }
            },
            error: function(xhr, statusText){
                console.log(statusText);
            }

        })

    })

    $(".doAction").click(function(){
        console.log("Clic de acciones");
        let action = $(this).attr("id");
        console.log(appId + " " + action)
        $.ajax({
            url: "upCand",
            method: "POST",
            data: {
                appId: appId,
                action: action
            },
            success: function(data){
                if(data.error == 0){
                    console.log("Siii")
                    $('#ModalCuenta').modal('hide');
                    $('#Actualizado').modal('show');
                    $("#serverMessage").html(data.message);
                    $("#gamerIdGenerado").val(data.gamerId);
                }else {
                    console.error("Nooo")
                    $('#ModalCuenta').modal('hide');
                    $('#Actualizado').modal('show');
                    $("#serverMessage").html(data.message);
                }
                //data.testlist[pos_x].scores[posy]
            },
            error: function(xhr, statusText){
                console.log(statusText);
            }

        })

    })


} );
