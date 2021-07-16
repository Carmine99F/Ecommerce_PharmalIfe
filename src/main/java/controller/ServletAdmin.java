package controller;

import model.messaggio.Messaggio;
import model.messaggio.MessaggioDAO;
import model.prodotto.Prodotto;
import model.prodotto.ProdottoDAO;
import model.utente.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletAdmin", value = "/ServletAdmin")
public class ServletAdmin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String valore=request.getParameter("value");
            String pagina="";
            switch (valore){
                case "listaProdotti" :
                    ProdottoDAO prodottoDAO=new ProdottoDAO();
                    ArrayList<Prodotto> prodotti= prodottoDAO.doRetraiveByAllProdotti();
                    request.setAttribute("prodotti",prodotti);
                    pagina="WEB-INF/pagine/admin/listaProdottiAdmin.jsp";
                break;
                case "insertProdotto" :
                    pagina="WEB-INF/pagine/admin/insertProdotto.jsp";
                break;
                case "insertCategoria" :
                    pagina="";
                break;
                case "insertMarchio"
                        :pagina="";
                break;
                case "listaUtenti"
                        :pagina="";
                break;
                case "messaggi":
                    MessaggioDAO messaggioDAO= new MessaggioDAO();
                    ArrayList<Messaggio> messaggi= messaggioDAO.doRetraiveByAllMessaggi();
                    request.setAttribute("messaggi",messaggi);
                    pagina="WEB-INF/pagine/admin/assistenzaUtenti.jsp";
                break;

            }
            RequestDispatcher dispatcher=request.getRequestDispatcher(pagina);
            dispatcher.forward(request,response);
    }
}
