package controller;

import model.carrello.Carrello;
import model.carrello.CarrelloDAO;
import model.prodotto.Prodotto;
import model.prodotto.ProdottoDAO;
import model.utente.Utente;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletAggiungiAlCarrello", value = "/ServletAggiungiAlCarrello")
public class ServletAggiungiAlCarrello extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idProdotto=Integer.parseInt(request.getParameter("prodotto"));
        HttpSession session=request.getSession();
        Utente utente=(Utente) session.getAttribute("utente");
        ProdottoDAO prodottoDAO= new ProdottoDAO();
        Prodotto prodotto= prodottoDAO.cercaProdotto(idProdotto);
        if(utente!=null){
          Carrello carrello=(Carrello) session.getAttribute("carrello");

            if(carrello==null){
                carrello.addProdotto(prodotto);
                carrello.setUtente(utente);
                session.setAttribute("carrello",carrello);
            }else {
                carrello.addProdotto(prodotto);
            }
        }else{
            Carrello carrello= new Carrello();
            carrello.addProdotto(prodotto);
            HttpSession session1=request.getSession();
            session1.setAttribute("carrello",carrello);
            session1.setMaxInactiveInterval(5000);

        }



       // CarrelloDAO carrelloDAO= new CarrelloDAO();
        //carrelloDAO.insertCarrello(carrello);

        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/pagine/carrello.jsp");
        dispatcher.forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
