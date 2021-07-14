<%@ page import="java.util.ArrayList" %>
<%@ page import="model.prodotto.Prodotto" %>
<%@ page import="model.prodotto.ProdottoDAO" %>
<%@ page import="java.lang.reflect.Array" %><%--
  Created by IntelliJ IDEA.
  User: Amministratore
  Date: 07/07/2021
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%ArrayList<Prodotto> prodotti=(ArrayList<Prodotto>) request.getAttribute("prodotti"); %>

<html>
<head>
    <jsp:include page="/WEB-INF/pagine/default/head.jsp">
        <jsp:param name="title" value="Lista prodotti"/>
        <jsp:param name="style" value="styleHeader,styleFooter,styleListaProdotti"/>
        <jsp:param name="script" value="header,footer"/>
    </jsp:include>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" defer></script>
    <script src="js/aggiungiProdotto.js" type="text/javascript"defer></script>
    <script src="./js/header.js" type="text/javascript" defer></script>
</head>
<body>
<jsp:include page="default/header.jsp"/>
<%--<%for(Prodotto p : (ArrayList<Prodotto>)request.getAttribute("prodotti")) {  %>
<div>
    <p> <%=p.getNome()%></p>
    <img src="<%=application.getContextPath()%>/immaginiFarmaci/<%=p.getPathImmagine()%>" alt="oki">
</div>
<%  } %>--%>
<div id="container-prodotti">
    <aside>
        <form class="products" action="" method="post">
            <div class="filtraggio">
                <label for="nome">Nome</label>
                <input id="nome" type="text">
            </div>
            <div class="filtraggio">
                <label for="categoria">Categoria</label>
                <input id="categoria" type="text">
            </div>
            <div class="filtraggio">
                <label for="marchio">Marchio</label>
                <input id="marchio" type="text">
            </div>
            <div class="filtraggioPrezzo" id="filatraggioPrezzo">
                <label for="prezzoMinimo">Min </label>
                <input id="prezzoMinimo" class="prezzo-filter" type="text" placeholder="Da ">
                <label for="prezzoMassimo">Max </label>
                <input id="prezzoMassimo" class="prezzo-filter" type="text" placeholder="A ">
            </div>
            <input type="submit" value="CERCA">
        </form>
    </aside>
   <main>
        <div class="filter">
            <select id="ordinamento" name="ordine">
                <option value="menoCaro">Dal meno caro al più caro</option>
                <option value="piuCaro">Dal più caro al meno caro</option>
                <option value="crescente">Dalla a alla Z</option>
                <option value="descrescente">Dalla Z  alla A</option>
            </select>
        </div>
        <div class="prodotti">
            <%for(Prodotto p : prodotti) {  %>
            <article>
                <figure>
                    <a href="ServletSchedaProdotto?value=<%=p.getCodiceProdotto()%>">
                        <img src="<%=application.getContextPath()%>/immaginiFarmaci/<%=p.getPathImmagine()%>" alt="Oki" height="200" width="200">
                    </a>
                    <figcaption>
                        <a href=""><%=p.getNome()%> </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <form action="ServletAggiungiAlCarrello" method="post">
                        <input type="hidden" name="prodotto" value="<%=p.getCodiceProdotto()%>">
                   <!--     <input type="hidden" name="nomeJsp" value="listaProdotti">-->
                        <span class="iconaCarrello" > <i class="fas fa-cart-plus"></i> </span>
                        <span class="btn"><button type="submit">Aggiungi Al Carrello</button></span>
                        <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;"><%=p.getPrezzo()%>$</span>
                    </form>

                </div>
            </article>
            <%  }  %>
      <!--     <article>
            <figure>
                <a href=""><img src="./immagini/Collutorio-Oki-Infiammazione-e-Dolore - Copia.jpg" alt="Oki" height="120" width="120"></a>
                    <figcaption>
                        <a href="">Colluttorio Oki   Avenoo </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>

            <article>
                <figure>
                    <img src="pilorex.jpg" alt="Oki" height="120" width="120">
                    <figcaption>
                        <a href="">Pilorex </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:red;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>
            <article>
                <figure>
                    <img src="Collutorio-Oki-Infiammazione-e-Dolore.jpg" alt="Oki" height="120" width="120">
                    <figcaption>
                        <a href="">Colluttorio Oki </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>
            <article>
                <figure>
                    <img src="Collutorio-Oki-Infiammazione-e-Dolore.jpg" alt="Oki" height="120" width="120">
                    <figcaption>
                        <a href="">Colluttorio Oki </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>
            <article>
                <figure>
                    <img src="Collutorio-Oki-Infiammazione-e-Dolore.jpg" alt="Oki" height="120" width="120">
                    <figcaption>
                        <a href="">Colluttorio Oki </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>
            <article>
                <figure>
                    <img src="Collutorio-Oki-Infiammazione-e-Dolore.jpg" alt="Oki" height="120" width="120">
                    <figcaption>
                        <a href="">Colluttorio Oki </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>
            <article>
                <figure>
                    <img src="Collutorio-Oki-Infiammazione-e-Dolore.jpg" alt="Oki" height="120" width="120">
                    <figcaption>
                        <a href="">Colluttorio Oki </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>
            <article>
                <figure>
                    <img src="Collutorio-Oki-Infiammazione-e-Dolore.jpg" alt="Oki" height="120" width="120">
                    <figcaption>
                        <a href="">Colluttorio Oki </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>
            <article>
                <figure>
                    <img src="Collutorio-Oki-Infiammazione-e-Dolore.jpg" alt="Oki" height="120" width="120">
                    <figcaption>
                        <a href="">Colluttorio Oki </a>
                    </figcaption>
                </figure>
                <div class="aggiungi">
                    <span class="iconaCarrello"> <i class="fas fa-cart-plus"></i> </span>
                    <span class="btn"><button> Aggiungi Al Carrello</button>  </span>
                    <span style="display: inline;float: right;color:gray;padding: 2px;margin-top: 4px;border-radius: 4px;">12.90$</span>
                </div>
            </article>-->




     </div>
       <div class="center-pagination">
           <div class="pagination">
               <a href="#">&laquo;</a>
               <a href="ServletListaProdotti?value=<%=request.getAttribute("idCategoria")%>&nomejsp=list" class="active">1</a>
               <a href="" >2</a>
               <a href="#">3</a>
               <a href="#">4</a>
               <a href="#">5</a>
               <a href="#">6</a>
               <a href="#">&raquo;</a>
           </div>
       </div>
    </main>

</div>
<jsp:include page="default/footer.jsp"/>
<script>

</script>
</body>
</html>
