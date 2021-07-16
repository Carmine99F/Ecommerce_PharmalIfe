var patterNomeUtente="/[a-zA-Z]{2,20}/";
var patternPassword=/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/;

//da 6 a 20 caratteri,almeno un numero,una maiuscola e minuscola
function  validazioneDati(){
    let nomeUtente=$("#nome");
    let cognomeUtente=$("#cognome");
    let emailUtente=$("#email");
    let password=$("#password");
    let newPassword=$("#newPassword");

    alert(patternPassword.test());
    if(password.val()==newPassword.val()){
        newPassword.addClass("lampeggioBordo");
        alert("La nuova Password deve essere diversa dalla vecchia");
        return event.preventDefault();
    }
    if(!patternPassword.test(newPassword)){
        alert("Non rispetta il formato");
    }
}