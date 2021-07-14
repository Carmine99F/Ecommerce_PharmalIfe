<%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 06/07/2021
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/pagine/default/head.jsp">
        <jsp:param name="title" value="Assistenza"/>
        <jsp:param name="style" value="styleHeader,styleFooter,styleAssistenza"/>
        <jsp:param name="script" value="header,footer"/>
    </jsp:include>
    <script src="js/header.js" type="text/javascript" defer></script>
</head>
<body>
<jsp:include page="default/header.jsp"/>
<h1 class="assistenza">TI AIUTIAMO NOI</h1>
<h1 class="assistenza">CI PENSA PHARMALIFE</h1><br>


<div class="padre">

    <div class="image">
        <img src="./immagini/ti-aiutiamo-noi.jpg">
    </div>

    <div class="flex-container">
        <form action="ServletInvioMessaggio" method="post">
            <div>
                <label for="fname"></label>
                <input type="text" id="fname" name="firstname" placeholder="Nome"><br>
            </div>

            <div>
                <label for="cognome"></label>
                <input type="text" id="cognome" name="lastname" placeholder="Cognome">
            </div>

            <div>
                <label for="telefono"></label>
                <input type="text" id="telefono" name="telefono" placeholder="Telefono">
            </div>
            <div>
                <label for="email"></label>
                <input type="text" id="email" name="email" placeholder="Email">
            </div>
            <div>
                <label for="subject"></label>
                <textarea id="subject" name="messaggio" placeholder="Il Tuo Messaggio" style="height:200px"></textarea>
            </div>
            <input type="submit" value="INVIA">
        </form>
    </div>
</div>
<jsp:include page="default/footer.jsp"/>
</body>
</html>
