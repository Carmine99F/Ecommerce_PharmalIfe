<%@ page import="java.util.ArrayList" %>
<%@ page import="model.categoria.Categoria" %><%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 23/06/2021
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Categoria> categorie=(ArrayList<Categoria>) application.getAttribute("categorie"); %>


<div id="slider">
   <div class="img_slide">
        <img src="./immagini/unnamed.jpg">
    </div>
    <div class="img_slide">
        <img src="./immagini/01_medicine-plus-preview.__large_preview.jpg" >
    </div>
    <div class="img_slide">
        <img src="./immagini/slide-1-1-1243x500.jpg">
    </div>
    <a class="prev" onmouseover="immaginePrecedente()">  <i class="fas fa-arrow-circle-left"> </i> </a>
    <a class="next" onclick="immagineSuccessiva()"> <i class="fas fa-arrow-circle-right"> </i> </a>
</div>

<div class="cat">
    <h3 >LE NOSTRE CATEGORIE</h3>
    <h5 class="sub-cat">Scopri i migliori prodotti di pHarmaLife in base alle tue esigenze...</h5>
    <hr>
    <div class="listaCategorie">
        <% for(Categoria c : categorie){  %>
        <div class="categoria" >
            <%=c.getNomeCategoria()%>
        </div>
        <% } %>
       <!-- <div class="categoria" >
            Farmaci da Banco
        </div>
        <div class="categoria">
            Cosemtici da Banco
        </div>
        <div  class="categoria">
           Igiene e benessere
        </div>-->
    </div>

</div>



<div class="info">

<fieldset>
    <legend>Spediamo Felicità</legend>
    <p class="sub-sped"  > PHarmaLife è la risposta alla tua personale ricerca di benessere.

        La <b>farmacia on-line</b> che ti offre il più vasto assortimento di marche e prodotti <b>al miglior prezzo con consegna in 24/48h
            e reso gratuito.</b>

        Su  pHarmaLife  potrai trovare i migliori integratori alimentari, i tuoi prodotti di bellezza preferiti
        (<b>Bionike, Lierac, Somatoline, Avene, La Roche-Posay, Klorane, Vichy</b>, ecc) e tutto il necessario per la cura del bambino.
        Scopri la linea completa di prodotti per l'igiene orale.

        Inoltre  pHarmaLife  ti offre un servizio costante di farmacisti pronti a supportarti in ogni esigenza.</p>
</fieldset>

</div>
