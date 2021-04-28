$(document).ready(function() {
    console.log("Hola mundo");
    var oldUsername = "advancedReport"
    var toastHTMLEelement = document.getElementById("tostados")
    var toastElement = new bootstrap.Toast(toastHTMLEelement, {
        animation: true,
        delay: 5000
    })

    $(".datos").click(function(){
        console.log("click en aplicante")
        let usernameForm = $(this).attr("id");
        $.ajax({
            url: "getAccountInternal",
            method: "POST",
            data: {
                username: usernameForm
            },
            success: function(data){
                var x = document.getElementsByClassName("advanced");
                for (i = 0; i < x.length; i++) {
                    console.log(x[i])
                    x[i].id = data.username;
                }
                $("#username2").html(data.username);
                $("#fullName").html(data.firstName + data.lastName);
                $("#emailModal").html(data.email);
                $("#curpModal").html(data.curp);
                $("#roleNameModal").html(data.roleName);
                $("#testId").html(data.testList[(data.testList.length)-1].testId);
                $("#testStatus").html(data.testList[(data.testList.length)-1].testStatus);
                $("#beginAt").html(data.testList[(data.testList.length)-1].beganAtTimeStamp);
                $("#finishAt").html(data.testList[(data.testList.length)-1].finishedAtTimeStamp);
                $("#timeElapsed").html(data.testList[(data.testList.length)-1].duration);
                $("#score").html(data.testList[(data.testList.length)-1].overallScore);
                $("#scoreIdOne").html(data.testList[(data.testList.length)-1].scores[0].scoreId);
                $("#testIdOne").html(data.testList[(data.testList.length)-1].scores[0].test_testId);
                $("#softSkillOne").html(data.testList[(data.testList.length)-1].scores[0].softSkillName);
                $("#scoreOne").html(data.testList[(data.testList.length)-1].scores[0].softSkillScore);
                $("#scoreIdTwo").html(data.testList[(data.testList.length)-1].scores[1].scoreId);
                $("#testIdTwo").html(data.testList[(data.testList.length)-1].scores[1].test_testId);
                $("#softSkillTwo").html(data.testList[(data.testList.length)-1].scores[1].softSkillName);
                $("#scoreTwo").html(data.testList[(data.testList.length)-1].scores[1].softSkillScore);
                $("#scoreIdThree").html(data.testList[(data.testList.length)-1].scores[2].scoreId);
                $("#testIdThree").html(data.testList[(data.testList.length)-1].scores[2].test_testId);
                $("#softSkillThree").html(data.testList[(data.testList.length)-1].scores[2].softSkillName);
                $("#scoreThree").html(data.testList[(data.testList.length)-1].scores[2].softSkillScore);
                $("#scoreIdFour").html(data.testList[(data.testList.length)-1].scores[3].scoreId);
                $("#testId1Four").html(data.testList[(data.testList.length)-1].scores[3].test_testId);
                $("#softSkillFour").html(data.testList[(data.testList.length)-1].scores[3].softSkillName);
                $("#scoreFour").html(data.testList[(data.testList.length)-1].scores[3].softSkillScore);
                //data.testlist[pos_x].scores[posy]
                oldUsername = data.username;
                console.log(oldUsername);
            },
            error: function(xhr, statusText){
                console.log(statusText);
            }

        })
    })




    $(".advanced").click(function(){
        let usernameForm = $(this).attr("id");
        let actualurl = (window.location.href);
        actualurl = actualurl.replace("superAdminPanel","");
        window.location.href=actualurl+'advancedView?username='+usernameForm
    })


    $(".createNewGamer").click(function(){
        console.log("Click en create new")
        $.ajax({
            url: "getAccountInternal",
            method: "get",
            data: {
            },
            success: function(data){
                console.log(data)
                $("#randomGamerIdShow").val(data);
                $("#randomGamerIdHidden").val(data);
            },
            error: function(xhr, statusText){
                console.log(statusText);
            }

        })
    })

    $(".createNewAdmin").click(function(){
        console.log("Click en create new admin")
        $.ajax({
            url: "getAccountInternal",
            method: "get",
            data: {
            },
            success: function(data){
                console.log(data)
                $("#randomAdmShow").val(data);
                $("#randomAdmHidden").val(data);
            },
            error: function(xhr, statusText){
                console.log(statusText);
            }

        })
    })


    /* attach a submit handler to the form */
    $("#formNewGID").submit(function(event) {

        /* stop form from submitting normally */
        event.preventDefault();
        console.log('Gid: ' + $('#randomGamerIdHidden').val() + ' email: ' + $('#emailInputNewGID').val())
        $.ajax({
            url: "gidCMake",
            method: "post",
            data: {
                username: $('#randomGamerIdHidden').val(),
                email: $('#emailInputNewGID').val()
            },
            success: function(data){
                console.log(data)
                $("#createNew").modal('hide');
                alert('El registro del gamerId ha sido exitoso');
                toastElement.show()
                $("#tostadosMensaje").html('Hemos creado al usuario ' +$('#randomGamerIdHidden').val() + ' correctamente');
                setTimeout("location.reload();",1500)
            },
            error: function(xhr, statusText){
                console.log(statusText);
                alert('El registro del gamerId ha fallado');
            }
        });
    });

    /* attach a submit handler to the form */
    $("#formNewAdm").submit(function(event) {

        /* stop form from submitting normally */
        event.preventDefault();
        console.log('Gid: ' + $('#randomAdmShow').val() + ' email: ' + $('#emailInputNewAdms').val())
        $.ajax({
            url: "admMake",
            method: "post",
            data: {
                username: $('#randomAdmHidden').val(),
                email: $('#emailInputNewAdm').val(),
                role: $('#accountTypeAdm').val()
            },
            success: function(data){
                console.log(data)
                $("#createNewAdminModal").modal('hide');
                alert('El registro del gamerId ha sido exitoso');
                toastElement.show()
                $("#tostadosMensaje").html('Hemos creado al usuario ' +$('#randomGamerIdHidden').val() + 'correctamente');
                setTimeout("location.reload();",3000)
            },
            error: function(xhr, statusText){
                console.log(statusText);
                alert('El registro del gamerId ha fallado');
            }
        });
    });

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




    $("#mostrartostados").click(function(){
        console.log("Tostados de" + $(this).attr("id"))
        toastElement.show()

    })
} );
