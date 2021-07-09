<%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 08/07/2021
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/pagine/default/head.jsp">
        <jsp:param name="title" value="Inserisci prodotto"/>
        <jsp:param name="style" value="styleHeader,styleFooter,styleInsertProdotto"/>
        <jsp:param name="script" value="header,footer"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../default/header.jsp"/>

<h1>AGGIUNGI UN NUOVO PRODOTTO</h1>

<form  class="insert" action="" method="POST" name="insert">
    <fieldset>
        <legend>Nuovo Prodotto</legend>
        <div class="campo">
            <label for="nomeId">Nome Prodotto</label><br>
            <input type="text" id="nomeId" placeholder="Nome Prodotto..." required>
        </div>
        <div class="campo">
            <label for="prezzoId">Prezzo</label><br>
            <input type="text" id="prezzoId" placeholder="Prezzo" required>
        </div>
        <div class="campo">
            <label for="marchioId">Marchio</label><br>
            <input type="text" id="marchioId" placeholder="Marchio" required>
        </div>
        <div class="campo">
            <label for="caegoriaId">Categoria</label><br>
            <input type="text" id="categoriaId" placeholder="Categoria" required>
        </div>
        <div class="campo">
            <label for="descrizioneId">Descrizione</label>
            <textarea></textarea>
        </div>
        <div class="campo">
            <label for="immagine">Scegli Immagine</label>
            <input type="file" id="immagine">
        </div>

    </fieldset>
</form>
<jsp:include page="../default/footer.jsp"/>
</body>
</html>
