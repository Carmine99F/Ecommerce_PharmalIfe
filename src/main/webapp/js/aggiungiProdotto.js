 $(document).ready(function (){
         $('.iconaCarrello').click(function (e) {
             $(e.delegateTarget).next('.btn').toggle();
         });
     });



 function  aggiungiAlCarrello(idProdotto){

     $.ajax({
         "type":"post",
         "url" : "ServletAggiungiAlCarrello",
         "data":"prodotto="+ idProdotto,
         "success": function (data){
             //alert("sss" )
             $("h2").text(data);
            $("h2").css("visibility","visible");
             $("h2").css("color","red");
             setTimeout(function (){
                 $("h2").css("visibility","hidden")
             },4000)
         }
     })
 }
