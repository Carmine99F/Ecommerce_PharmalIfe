var nomeUtente;
var cognomeUtente;
var emailUtente;
var codiceFiscale;
var password;
var passwordRepeat;


function  blink(val){
    $(document).ready(function (){
        alert("bub");
        $("#Id"+val).addClass("lampeggioBordo");
        $("#Id"+val).val("Nome Errato").css("color","red");
        $("#Id"+val).mouseenter(function (){
           $("#Id"+val).css("color","black");
       })
        $("#Id"+val).mouseleave(function (){
            $("#Id"+val).css("color","red");
        })
       // $("#Idnome").focus().css("color","black");
      //  $("#Idnome").attr("placeholder","Nome corto");
      //  $(".error").show();
    })
}
function  validazioneIscrizione(){
        password = document.forms["registrazione"]["psw"].value;
        passwordRepeat=document.forms["registrazione"]["psw-rip"].value;

        if(password!=passwordRepeat){
            blink("psw");
            console.log("wee");
            return event.preventDefault();
        }
    if(nomeUtente.length<10) {
       blink ("nome");
        return event.preventDefault();
    }
    return event.preventDefault();
}

