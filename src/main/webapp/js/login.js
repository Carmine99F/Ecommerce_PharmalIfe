/*function mostraForm() {

    document.getElementsByClassName("container")[0].style.display = "block";
    // document.getElementsByClassName8("container")[0].style.animation="animatezoom 06s";
    document.getElementsByTagName("body")[0].style.backgroundColor = "black";
    document.getElementsByTagName("body")[0].style.background = "rgba(0,0,0,0.8)";
}*/

var emailUtente;
var passwordUtente;
function  cercaUtente(){
   // event.preventDefault();
    var x;
     emailUtente=document.forms["loginUser"]["emailUser"].value;
    passwordUtente=document.forms["loginUser"]["password"].value;
    alert(emailUtente);

    var vaalore;
    const xmlhttp= new XMLHttpRequest();
    xmlhttp.onreadystatechange=function (){
        if(this.readyState==4 && this.status==200){
           // console.log(this.responseText+"weee");
            cerca(this);
            alert(cerca(this));
           if(!cerca(this)){
               valore="ciao";
               alert("valore =" + valore);
            // event.preventDefault();
           }
           else{
               valore="salve";
               alert("valore "+ valore);
           }
        }
    };
    alert("x = " + x);
    xmlhttp.open("POST","ServletLogin",true);
    xmlhttp.setRequestHeader("content-type", "application/x-www-form-urlencoded");
    //xmlhttp.setRequestHeader("connection","close");
   // xmlhttp.send("email="+emailUtente+"&password="+passwordUtente);
    xmlhttp.send("email="+emailUtente+"&password="+passwordUtente);


    if(valore=="ciao"){
        return event.preventDefault();
    }
    if(valore=="salve"){
        return  true;
    }
}

function cerca(xhttp){

    var avviso=document.getElementsByClassName("title")[0];

    if(xhttp.responseText=="assente") {
        alert("Utente non trovato");
        avviso.style.color = "red";
        avviso.fontSize = "5px";
        avviso.innerHTML = "Nome utente o password errati";
     return   false
        //  document.getElementsByClassName("title")[0].style.color="red".innerHTML=xhttp.responseText;
    }
    return  true;

}

