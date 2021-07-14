<%@ page import="model.carrello.Carrello" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.prodotto.Prodotto" %>
<%@ page import="model.utente.Utente" %><%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 13/07/2021
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!Utente utente;  %>
<%!ArrayList<Prodotto> prodotti; %>
<%Carrello carrello=(Carrello)session.getAttribute("carrello"); %>
<%
    if(carrello!=null) {
        prodotti = carrello.getProdotti();
         utente= carrello.getUtente();
    }
%>

<html>
<head>
    <jsp:include page="/WEB-INF/pagine/default/head.jsp">
        <jsp:param name="title" value="PHarmaLife - Supermercato Farmaceutico"/>
        <jsp:param name="style" value="styleHeader,styleFooter,styleCarrello"/>
        <jsp:param name="script" value="header,footer"/>
    </jsp:include>
    <script src="js/header.js" type="text/javascript" defer></script>
    <style>
        h2{
            text-align: center;
            color: deepskyblue;
        }
    </style>


</head>
<body>
<jsp:include page="default/header.jsp"/>

<% if(carrello==null){  %>
<h2>Il tuo Carrello è vuoto, acquista per aggiungere prodotti al carrello</h2>
<% } else { %>
<% if(utente!=null){ %>
<h2>Ecco il tuo  carrello  <%=utente.getNome()%> </h2>
<% }  else{ %>
<h2>Ecco il tuo carrello Visitatore</h2>
<% } %>
<div class="include-tutto">
     <div class="lista-prodotti">
        <div class="titolo">
            <h1>CARRELLO DELLA SPESA</h1>
        </div>

        <div class="card-prodotti">
            <div class="immagine-card-prodotti">
                <img src="https://faimed.it/5177-cart_default/filorga-time-filler-crema-50ml.jpg" alt="filorga-time-filler-crema-50ml">
            </div>
            <div class="info-card-prodotti">
                <a class="label" href="">
                  Oki </a>
                <div class="product-discount">
                    <span class="regular-price" style="text-decoration: line-through;">65,00&nbsp;€ </span>
                    <span class="discount-percentage"> -55,54% </background> </span>
                </div>
                <div class="current-price">
                    <span class="price"> 12 €</span>
                </div>
            </div>
            <div class="card-quantita">
                <div class="quantita">
                    <button name="incrementa" onclick="incrementa()"><i class="fas fa-plus"></i></button>
                    <input class="totale-prodotti" type="number" min="1" max="30" value="1">
                    <button name="decremento" onclick="decrementa()"><i class="fas fa-minus"></i></button>
                </div>
            </div>
            <div class="total-delete">
                    <span class="product-price">
                        <strong> 86,70 &nbsp;€</strong>
                    </span>
                <a href="">
                    <i class="fas fa-trash-alt"></i>
                </a>
            </div>
        </div>

    <!-- <div class="card-prodotti">
            <div class="immagine-card-prodotti">
                <img src="https://faimed.it/5177-cart_default/filorga-time-filler-crema-50ml.jpg" alt="filorga-time-filler-crema-50ml">
            </div>
            <div class="info-card-prodotti">
                <a class="label" href="">
                    FILORGA TIME FILLER CREMA 50ML</a>
                <div class="product-discount">
                    <span class="regular-price" style="text-decoration: line-through;">65,00&nbsp;€ </span>
                    <span class="discount-percentage"> -55,54% </background> </span>
                </div>
                <div class="current-price">
                    <span class="price">28,90&nbsp;€</span>
                </div>
            </div>
            <div class="card-quantita">
                <div class="quantita">
                    <button name="incrementa" onclick="incrementa()"><i class="fas fa-plus"></i></button>
                    <input class="totale-prodotti" type="number" min="1" max="30" value="1">
                    <button name="decremento" onclick="decrementa()"><i class="fas fa-minus"></i></button>
                </div>
            </div>
            <div class="total-delete">
                    <span class="product-price">
                        <strong> 86,70 &nbsp;€</strong>
                    </span>
                <a href="">
                    <i class="fas fa-trash-alt"></i>
                </a>
            </div>
        </div>


         <div class="card-prodotti">
             <div class="immagine-card-prodotti">
                 <img src="https://faimed.it/5177-cart_default/filorga-time-filler-crema-50ml.jpg" alt="filorga-time-filler-crema-50ml">
             </div>
             <div class="info-card-prodotti">
                 <a class="label" href="">
                     FILORGA TIME FILLER CREMA 50ML</a>
                 <div class="product-discount">
                     <span class="regular-price" style="text-decoration: line-through;">65,00&nbsp;€ </span>
                     <span class="discount-percentage"> -55,54% </background> </span>
                 </div>
                 <div class="current-price">
                     <span class="price">28,90&nbsp;€</span>
                 </div>
             </div>
             <div class="card-quantita">
                 <div class="quantita">
                     <button name="incrementa" onclick="incrementa()"><i class="fas fa-plus"></i></button>
                     <input class="totale-prodotti" type="number" min="1" max="30" value="1">
                     <button name="decremento" onclick="decrementa()"><i class="fas fa-minus"></i></button>
                 </div>
             </div>
             <div class="total-delete">
                    <span class="product-price">
                        <strong> 86,70 &nbsp;€</strong>
                    </span>
                 <a href="">
                     <i class="fas fa-trash-alt"></i>
                 </a>
             </div>
         </div>-->







   <!--     <div class="card-prodotti">
            <div class="immagine-card-prodotti">
                <img src="https://faimed.it/5177-cart_default/filorga-time-filler-crema-50ml.jpg" alt="filorga-time-filler-crema-50ml">
            </div>
            <div class="info-card-prodotti">
                <a class="label" href="">
                    FILORGA TIME FILLER CREMA 50ML</a>
                <div class="product-discount">
                    <span class="regular-price" style="text-decoration: line-through;">65,00&nbsp;€ </span>
                    <span class="discount-percentage"> -55,54% </background> </span>
                </div>
                <div class="current-price">
                    <span class="price">28,90&nbsp;€</span>
                </div>
            </div>
            <div class="card-quantita">
                <div class="quantita">
                    <button name="incrementa" onclick="incrementa()"><i class="fas fa-plus"></i></button>
                    <input class="totale-prodotti" type="number" min="1" max="30" value="1">
                    <button name="decremento" onclick="decrementa()"><i class="fas fa-minus"></i></button>
                </div>
            </div>
            <div class="total-delete">
                    <span class="product-price">
                        <strong> 86,70 &nbsp;€</strong>
                    </span>
                <a href="">
                    <i class="fas fa-trash-alt"></i>
                </a>
            </div>
        </div>-->
         <div class="continua-shopping">
             <a class="shopping" href="https://faimed.it/">
                 <i class="fas fa-chevron-left">Continua lo shopping</i>
             </a>
         </div>

         <div class="center-pagination">
             <div class="pagination">
                 <a href="#">&laquo;</a>
                 <a href="#" class="active">1</a>
                 <a href="#" >2</a>
                 <a href="#">3</a>
                 <a href="#">4</a>
                 <a href="#">5</a>
                 <a href="#">6</a>
                 <a href="#">&raquo;</a>
             </div>
         </div>

    </div>


    <div class="cassa">
        <div class="numero-articoli">
            <span class="label js-subtotal">3 articoli</span>
            <span class="value"> 86,70&nbsp;€ </span>
        </div>
        <div class="spedizione">
            <span class="label"> Spedizione </span>
            <span class="value"> Gratis </span>
        </div>
        <div class="totale">
            <span class="label">Totale&nbsp;(Tasse incl.)</span>
            <span class="value"> 86,70&nbsp;€ </span>
        </div>
        <div class="codice-sconto">
            <p class="promo-code-button display-promo">
                <a class="collapse-button" href="#promo-code"> Hai un codice sconto? </a>
            </p>
        </div>
        <div class="promo-code">
            <form action="https://faimed.it/carrello" data-link-action="add-voucher" method="post">
                <input type="hidden" name="token" value="406a80666b6957b3c5c46ea8e5494f3e">
                <input type="hidden" name="addDiscount" value="1">
                <input class="promo-input" type="text" name="discount_name" placeholder="Codice Sconto">
                <button type="submit" class="btn btn-primary">
                    <span>Applica</span>
                </button>
            </form>
            <div class="alert alert-danger js-error" role="alert">
                <i class="material-icons"></i>
                <span class="ml-1 js-error-text"></span>
            </div>
        </div>
        <div class="checkout">
            <div class="text-centered">
                <a href="https://faimed.it/ordine" class="button-outline">Vai in cassa</a>
            </div>
        </div>
    </div>

    </div>
<% } %>
<jsp:include page="default/footer.jsp"/>
</body>
</html>
