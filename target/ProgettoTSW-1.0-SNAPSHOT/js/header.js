
//BARRA DI NAVIGAZIONE
function mostraMenu() {
    var x = document.getElementsByTagName("nav")[0];
    if (x.style.display === "flex") {
        x.style.display = "none";
    } else {
        x.style.display = "flex";
    }
}



/*var x=document.querySelectorAll("#slider a i");
var y=document.querySelectorAll(".img_slide img");

console.log(getComputedStyle(y[1],null).getPropertyValue("width"))
console.log(x.length+ "  sf "+ getComputedStyle(x[0],null).getPropertyValue("visibility"));

for(var i=0;i<y.length;i++){
    y[i].addEventListener("click",function (){
        x[0].style.visibility="visible";
        x[1].style.visibility="visible";
    })
}

setInterval(nascondiPrevNext,10000);

function  nascondiPrevNext(){
    if((x[0].style.visibility="visible") && (x[1].style.visibility="visible")){
        x[0].style.visibility="hidden";
        x[1].style.visibility="hidden";
    }
}



//IMMAGINI SUCCESSIVE E PRECEDENTI

var numeroImmagini=document.getElementsByClassName("img_slide").length;
var immagineCorrente=1;

function immagineSuccessiva(){
    console.log("immagineSuccessiva");

    immagineCorrente++;
    if(immagineCorrente>numeroImmagini){
        immagineCorrente=1;
    }
    for(var i=numeroImmagini;i>0;i--){
        document.querySelector(" #slider .img_slide:nth-child(" + i +")").style.display="none";
    }
    document.querySelector(" #slider .img_slide:nth-child(" + immagineCorrente +")").style.display="block";

}

function immaginePrecedente(){

    --immagineCorrente;
    if(immagineCorrente==0){
        immagineCorrente=numeroImmagini;
    }
    for(var i=numeroImmagini;i>0;i--){
        document.querySelector(" #slider .img_slide:nth-child(" + i +")").style.display="none";
    }
    document.querySelector(" #slider .img_slide:nth-child(" + immagineCorrente +")").style.display="block";

}
setInterval(immagineSuccessiva,9000);*/