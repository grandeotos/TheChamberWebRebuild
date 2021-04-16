//the first line of code states that the script will run only after the page has loaded
//and the script is ready to be executed.
$(document).ready(function ()
{
    console.log("Bienvenido a apply.js")
//select the close by class and apply a click even listener
    if(sessionStorage.getItem('#modalApply') !== 'true'){
        $('#bienvenido').modal('show');
//then the modal will be set true in the current session due to which the modal won't
//reappear on the refresh, we need to reload the page in a new tab to make the modal
//reappear.
        sessionStorage.setItem('#modalApply','true');
    }
    else {
        $('#bienvenido').modal('hide');
    }
});