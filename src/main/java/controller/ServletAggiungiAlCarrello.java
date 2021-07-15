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
          //Carrello carrello=(Carrello) session.getAttribute("carrello");
            //System.out.println("Carrello " + utente.getCarrello());
            if(utente.getCarrello()!=null){
                System.out.println("Carrellooo esistente" + utente.getCarrello());
                utente.getCarrello().addProdotto(prodotto);

                //session.setAttribute("carrello",carrello1);
            }else {
                System.out.println("Carrello non esiste " +utente.getCarrello());
                Carrello carrello1= new Carrello();
                carrello1.addProdotto(prodotto);
                utente.setCarrello(carrello1);

            }
        }else{
            Carrello carrello=(Carrello) session.getAttribute("carrello");
            if(carrello!=null) {
                carrello.addProdotto(prodotto);
            }else{
                Carrello carrello1= new Carrello();
                carrello1.addProdotto(prodotto);
                session.setAttribute("carrello",carrello1);
                session.setMaxInactiveInterval(8000);
            }
          /*  carrello.addProdotto(prodotto);
            session=request.getSession();
            session.setAttribute("carrello",carrello);
            session.setMaxInactiveInterval(5000);*/

        }

        RequestDispatcher dispatcher=request.getRequestDispatcher("WEB-INF/pagine/carrello.jsp");
        dispatcher.forward(request,response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
