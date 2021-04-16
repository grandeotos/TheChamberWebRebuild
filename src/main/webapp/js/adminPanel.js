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
    $('#TheChamber').DataTable( {
        language: { //Holaaa
            url: '//cdn.datatables.net/plug-ins/1.10.24/i18n/Spanish.json'
        }

    } );
    $('.toast').toast({
        delay: 1500
    })
} );

function showToast() {
    console.log("ShowToast");
    //$('.').toast({delay:11, animation:true});
    $('#tostados').toast('show');
    console.log("ShowToaster");
}
function makeid(length) {
    var result           = [];
    var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    var charactersLength = characters.length;
    for ( var i = 0; i < length; i++ ) {
        result.push(characters.charAt(Math.floor(Math.random() *
            charactersLength)));
    }
    return result.join('');
}

$(document).on("click", "#somebutton", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
    $.post("someservlet", function(responseJson) {    // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response JSON...
        var $ul = $("<ul>").appendTo($("#somediv")); // Create HTML <ul> element and append it to HTML DOM element with ID "somediv".
        $.each(responseJson, function(index, item) { // Iterate over the JSON array.
            $("<li>").text(item).appendTo($ul);      // Create HTML <li> element, set its text content with currently iterated item and append it to the <ul>.
        });
    });
});


