//the first line of code states that the script will run only after the page has loaded
//and the script is ready to be executed.
$(document).ready(function ()
{
//select the close by class and apply a click even listener
    if(/*sessionStorage.getItem('#modalPlay') !== 'true'*/true){
        $('#bienvenido').modal('show');
//then the modal will be set true in the current session due to which the modal won't
//reappear on the refresh, we need to reload the page in a new tab to make the modal
//reappear.
        sessionStorage.setItem('#modalPlay','true');
    }
    else {
        $('#bienvenido').modal('hide');
    }
});