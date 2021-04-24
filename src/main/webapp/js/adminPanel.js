$(document).ready(function() {
    console.log("Hola mundo");

    $(".datos").click(function(){
        console.log("Datos de " + $(this).attr("id"))
        let usernameForm = $(this).attr("id");
        $.ajax({
            url: "getAccountInternal",
            method: "POST",
            data: {
                username: usernameForm
            },
            success: function(data){
                $("#username2").html(data.username);
                $("#fullName").html(data.firstName + data.lastName);
                $("#emailModal").html(data.email);
                $("#curpModal").html(data.curp);
                $("#roleNameModal").html(data.roleName);
                let last_test = data.testList[data.testList.length]
                console.log(data)
                console.log(data.testList.length)
            },
            error: function(xhr, statusText){
                console.log(statusText);
            }

        })
    })
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
    $('#TheChamber').DataTable( {
        language: { //Holaaa
            url: '//cdn.datatables.net/plug-ins/1.10.24/i18n/Spanish.json'
        }

    } );



    $('.toast').toast({
        delay: 1500
    })

    $("mostrartostados").click(function(){
        console.log("Tostados de" + $(this).attr("id"))
        let usernameForm = $(this).attr("id");
        $('.toast').toast({
            delay: 1500,
            show: true
        })
    })
} );
