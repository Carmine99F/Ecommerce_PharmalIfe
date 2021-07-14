<%@ page import="model.prodotto.ProdottoDAO" %>
<%@ page import="model.prodotto.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 13/07/2021
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Prodotto prodotto=(Prodotto) request.getAttribute("prodotto"); %>
<html>
<head>
    <jsp:include page="/WEB-INF/pagine/default/head.jsp">
        <jsp:param name="title" value="PHarmaLife - Supermercato Farmaceutico"/>
        <jsp:param name="style" value="styleHeader,styleFooter,styleSchedaProdotto"/>
        <jsp:param name="script" value="header,footer"/>
    </jsp:include>
    <script src="js/header.js" type="text/javascript" defer></script>
</head>
<body>
<jsp:include page="default/header.jsp"/>
<div class="container">
    <div class="immagine">
        <img src="<%=application.getContextPath()%>/immaginiFarmaci/<%=prodotto.getPathImmagine()%>" alt="Prodotto">

    </div>
    <div class="infoProdotto">

        <h2><%=prodotto.getNome()%>   <%=prodotto.getPrezzo()%>£</h2>
        <div class="bottoni">
            <div class="quantita">
                <button name="incrementa" onclick="incrementa()"><i class="fas fa-plus"></i></button>
                <input id="quantita" type="number" min="1" max="30" value="1">
                <button name="decremento" onclick="decrementa()"><i class="fas fa-minus"></i></button>
            </div>
            <button class="aggiungiAlCarrello">Aggiungi Al Carrello</button>
            <a href=""> <i class="fas fa-heart" title="Aggiungi ai preferiti"></i></a>
        </div>
        <div class="descrizione">
            <div class="note">
                <fieldset>
                    <legend>Informazioni</legend>
                    Categoria :          Farmaco da Banco <br>
                    Codice Prodotto :    0PR00<%=prodotto.getCodiceProdotto()%><br>
                    Descrizione :
                    OKI fa parte della categoria degli antiinfiammatori non steroidei. <br>
                    Trattamento sintomatico e di breve durata di stati infiammatori <br>
                    associati a dolore quali quelli a carico dell'apparato osteoarticolare<br>
                    dolore post operatorio e otiti.
                </fieldset>

            </div>

            <div class="card">
                <i class="fab fa-cc-mastercard" style="color: green;"></i>
                <i class="fab fa-cc-visa"></i>
                <i class="fab fa-cc-paypal" style="color: gold;"></i>
                <i class="fab fa-cc-amazon-pay" style="color: orange;"></i>
                <i class="fab fa-cc-amex" style="color:royalblue;"></i>
                <i class="fab fa-cc-discover"></i>
            </div>
        </div>
    </div>
</div>
<jsp:include page="default/footer.jsp"/>
<script>
    function incrementa(){
        var x= document.getElementById("quantita").value;
        x++;
        document.getElementById("quantita").value=x;
    }
    function decrementa(){
        var x= document.getElementById("quantita").value;
        x--;
        if(x<1){
            x=1;
        }
        document.getElementById("quantita").value=x;
    }
</script>
</body>
</html>
