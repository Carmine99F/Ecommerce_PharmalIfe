<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.prodotto.Prodotto" %><%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 08/07/2021
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Prodotto> prodotti=(ArrayList<Prodotto>) request.getAttribute("prodotti");  %>
<html>
<head>
    <jsp:include page="/WEB-INF/pagine/default/head.jsp">
        <jsp:param name="title" value="Lista Prodotti - Admin"/>
        <jsp:param name="style" value="styleHeader,styleFooter,styleListaProdottiAdmin"/>
        <jsp:param name="script" value="header,footer"/>
    </jsp:include>
    <script src="js/header.js" type="text/javascript" defer></script>
</head>
<body>
<jsp:include page="../default/header.jsp"/>

<h1 class="list">LISTA PRODOTTI</h1>


<table>

    <tr>
        <th>Codice</th>
        <th>Nome</th>
        <th>Categoria</th>
        <th>Prezzo</th>
        <th>Marchio</th>
        <th>Elimina</th>
        <th>Aggiorna</th>
    </tr>
    <%for(Prodotto p : prodotti) {  %>
    <tr>
        <td><%=p.getCodiceProdotto()%></td>
        <td><%=p.getNome()%></td>
        <td><%=p.getCategoria().getNomeCategoria()%></td>
        <td><%=p.getPrezzo()%> £ </td>
        <td><%=p.getMarchio().getNomeMarchio()%></td>
        <td><a href="">Delete</a></td>
        <td><a href="">Update</a></td>
    </tr>
    <%  }  %>
 <!--  <tr>
        <td>01</td>
        <td>Pilorex</td>
        <td>Integratore</td>
        <td>12.50$</td>
        <td>Pompa protonica</td>
        <td><a href="">Delete</a></td>
        <td><a href="">Update</a></td>
    </tr>
    <tr>
        <td>01</td>
        <td>Pilorex</td>
        <td>Integratore</td>
        <td>12.50$</td>
        <td>Pompa protonica</td>
        <td>Delete</td>
        <td>Update</td>
    </tr>
    <tr>
        <td>01</td>
        <td>Pilorex</td>
        <td>Integratore</td>
        <td>12.50$</td>
        <td>Pompa protonica</td>
        <td>Delete</td>
        <td>Update</td>
    </tr>
    <tr>
        <td>01</td>
        <td>Pilorex</td>
        <td>Integratore</td>
        <td>12.50$</td>
        <td>Pompa protonica</td>
        <td>Delete</td>
        <td>Update</td>
    </tr>
    <tr>
        <td>01</td>
        <td>Pilorex</td>
        <td>Integratore</td>
        <td>12.50$</td>
        <td>Pompa protonica</td>
        <td>Delete</td>
        <td>Update</td>
    </tr>
    <tr>
        <td>01</td>
        <td>Pilorex</td>
        <td>Integratore</td>
        <td>12.50$</td>
        <td>Pompa protonica</td>
        <td>Delete</td>
        <td>Update</td>
    </tr>
    <tr>
        <td>01</td>
        <td>Pilorex</td>
        <td>Integratore</td>
        <td>12.50$</td>
        <td>Pompa protonica</td>
        <td>Delete</td>
        <td>Update</td>
    </tr>-->
</table>
<button onclick="tornaIndietro()">Torna alla home Admin</button>
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
<jsp:include page="../default/footer.jsp"/>
<script>
    function tornaIndietro(){
        window.history.back();
    }
</script>
</body>
</html>
