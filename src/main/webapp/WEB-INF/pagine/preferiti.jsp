<%@ page import="java.util.ArrayList" %>
<%@ page import="model.prodotto.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 06/07/2021
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Prodotto> prodotti=(ArrayList<Prodotto>) request.getAttribute("prodottiPref");%>
<%String nonRegistrato=(String)request.getAttribute("nonRegistrato");%>
<html>
<head>
    <jsp:include page="/WEB-INF/pagine/default/head.jsp">
        <jsp:param name="title" value="Preferiti"/>
        <jsp:param name="style" value="styleHeader,styleFooter,stylePreferiti"/>
        <jsp:param name="script" value="header,footer"/>
    </jsp:include>
    <script src="js/header.js" type="text/javascript" defer></script>
</head>
<body>
<jsp:include page="default/header.jsp"/>
<% if(session.getAttribute("utente")==null){%>
<h1 class="pref" style="text-align: center">Registrati per accedere all'area Preferiti</h1>
<%} else{%>

<h1 class="pref">LISTA DEI DESIDERI</h1><hr>


<div class="flexpadre">
    <%for(Prodotto p : prodotti) { %>
   <!-- <div class="flex-padre2">-->
        <div class="flex-blocco">
            <div class="icona-delete">
                <a href="ServletRimuoviPreferito?value=<%=p.getCodiceProdotto()%>"><i class="fas fa-trash-alt"></i></a>
            </div>
            <div class="image">
                <img src="<%=application.getContextPath()%>/immaginiFarmaci/<%=p.getPathImmagine()%>">
            </div >
            <div>
                <a href=""><p><%=p.getNome()%></p></a>
            </div>
        </div>
        <%  }  %>
 <!--   </div>-->

</div>
<%}%>


<!--
<h1 class="pref">NON HAI PREFERITI</h1>>>
-->

<jsp:include page="default/footer.jsp"/>
</body>
</html>
