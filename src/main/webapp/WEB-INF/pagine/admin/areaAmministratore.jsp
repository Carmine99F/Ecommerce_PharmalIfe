<%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 08/07/2021
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/pagine/default/head.jsp">
        <jsp:param name="title" value="Area Admin"/>
        <jsp:param name="style" value="styleHeader,styleFooter,styleAreaAmministratore"/>
        <jsp:param name="script" value="header,footer"/>
    </jsp:include>
</head>
<body>
<jsp:include page="../default/header.jsp"/>

<!-- <img src="of-medicines-medical-supplies-placed-on-a-blue.jpg" width="700" height="400">-->
<div class="opzione">
    <div class="scelte">
        <!--   <h2>Scegli un'opzione</h2>-->
        <ul>
            <li><a href="ServletAdmin?value=listaProdotti">Lista prodotti </a><i class="fas fa-pills"></i> </li>
            <li><a href="ServletAdmin?value=insertProdotto">Inserisci prodotto </a> <i class="fas fa-pills"></i></li>
            <li><a href="ServletAdmin?value=insertCategoria">Inserisci categoria </a><i class="fas fa-box-open"></i></li>
            <li> <a href="ServletAdmin?value=insertMarchio">Inserisci marchio</a><i class="fas fa-business-time"></i></li>                       </li>
            <li><a href="ServletAdmin?value=listaUtenti">Lista utenti </a> <i class="fas fa-users"></i></li>
            <li><a href="ServletAdmin?value=messaggi">Assistenza utenti </a> <i class="fas fa-comment-alt"></i></li>
        </ul>
    </div>
</div>
<jsp:include page="../default/footer.jsp"/>
</body>
</html>
