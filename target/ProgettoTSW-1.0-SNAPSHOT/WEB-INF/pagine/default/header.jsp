

<%@ page contentType="text/html; charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@ page import="java.util.ArrayList,model.marchio.Marchio" %>
<%@ page import="model.utente.Utente" %>
<%@ page import="model.categoria.Categoria" %>
<%@ page import="model.marchio.MarchioDAO" %>
<% Utente utente=(Utente) session.getAttribute("utente"); %>
<% ArrayList<Categoria> categorie=(ArrayList<Categoria>) application.getAttribute("categorie");%>
<%ArrayList<Marchio> marchi=(ArrayList<Marchio>) application.getAttribute("marchi"); %>


<header class="top-header">
    <p class="info">
        Info e Assistenza Clienti: (+39) 3920591662 | Spedizioni gratuite per ordini superiori a 69,99€
    </p>
        <div class="logo">
            <form action="" name="formInputSearch" onsubmit="">
                <label class="field" for="input" >
                    <input type="text" name="ricerca" placeholder="Cerca..." >
                    <button type="submit" name="sumbit" value="sumbit"> <i class="fas fa-search" style="font-size: 17px"></i></button>
                </label>
            </form>

            <a href="ServletLink?scelta=home"><img  src="./immagini/LogoPharmaLife.svg" alt="Logo Farmacia" width="150" height="150"></a>

            <div class="contenitore-icone " style="order: 3;">
               <a href="javascript:void(0);"  class="linkMenu"   onclick="mostraMenu()">
                    <i class="fas fa-bars" style="font-size: 20px"></i>
                </a>
                <a   href="ServletLink?scelta=login"  class="icone"> <i class="fa fa-user-circle"  onclick="mostraForm()" style="color: limegreen;font-size: 30px" ></i> </a>
                <a   href="https://www.facebook.com/pharmalife.ivane.5" class="icone"> <i class="fab fa-facebook-f" style="color: limegreen;font-size: 30px" ></i></a>
                <a   href="ServletAssistenza" class="icone"> <i class="fas fa-phone-square" style="color: limegreen;font-size: 30px"></i> </a>
                <a   href="ServletLink?scelta=carrello" class="icone"><i class="fas fa-shopping-cart" style="color: limegreen;font-size: 30px"></i></a>
                <a  title="Logout" href="ServletLink?scelta=preferiti" class="icone"><i class="far fa-heart" style="color: limegreen;font-size: 30px"></i> </a>
                <% if(utente!=null){%>
                <a  style="order: 6" href="ServletAccessoUtente?value=logout" class="icone"><i class="fas fa-sign-out-alt" style="color: limegreen;font-size: 30px"></i></a>
                <% }%>
            </div>
        </div>

</header>
<nav>
    <a href="ServletLink?scelta=home" class="home">Home</a>
    <div class="dropdown">
        <button class="dropbtn">Prodotti</button>
        <div class="dropdown-content">
            <div class="row">
                <div class="colum uno">
                    <% for(int i=0;i<(categorie.size()/2)+1;i++){    %>
                    <a href="ServletListaProdotti?value=<%=categorie.get(i).getIdCategoria()%>&nomejsp=header">
                        <%=categorie.get(i).getNomeCategoria()%>
                    </a>
                    <% } %>
                   <!-- <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>-->
                </div>
              <div class="colum due">
                  <% for(int i=(categorie.size()/2)+1;i<categorie.size();i++){    %>
                  <a href="ServletListaProdotti?value=<%=categorie.get(i).getIdCategoria()%>&nomejsp=header">
                      <%=categorie.get(i).getNomeCategoria()%></a>
                  <% } %>
                  <!--  <a href="#">Link 1</a>
                    <a href="#">Link 2</a>
                    <a href="#">Link 3</a>-->
                </div>
            </div>
        </div>
    </div>
   <div class="dropdown">
       <button class="dropbtn">Marchi</button>
       <div class="dropdown-content">
           <div class="row">
               <div class="colum">
                    <%for(int i=0;i< (marchi.size()/2)+1;i++){   %>
                   <a href=""><%=marchi.get(i).getNomeMarchio()%></a>
                   <% } %>
              <!--    <a href="#">Link 2</a>
                   <a href="#">Link 3</a>-->
               </div>
               <div class="colum">
                   <% for(int i= (marchi.size()/2)+1;i<marchi.size();i++){  %>
                   <a href=""><%=marchi.get(i).getNomeMarchio()%></a>
                   <%  } %>
                <!--  <a href="#">Link 1</a>
                   <a href="#">Link 2</a>
                   <a href="#">Link 3</a>-->
               </div>
           </div>
       </div>
   </div>
    <a href="ServletLink?scelta=infoAzienda">Chi siamo</a>
    <a href="ServletAssistenza">Contatti</a>
    <a href="ServletLink?scelta=assistenza">Ti Aiutiamo Noi</a>
</nav>

