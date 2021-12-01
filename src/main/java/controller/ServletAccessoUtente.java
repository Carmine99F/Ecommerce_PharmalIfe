package controller;

import model.carrello.Carrello;
import model.utente.Utente;
import model.utente.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "ServletAccessoUtente", value = "/ServletAccessoUtente")
public class ServletAccessoUtente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session= request.getSession();
       Utente utente=(Utente) session.getAttribute("utente");
       String valore=request.getParameter("value");

        switch (valore){
            case "login":
                if (utente==null){
                    String email=request.getParameter("emailUser");
                    String password=request.getParameter("password");
                    UtenteDAO utenteDAO=new UtenteDAO();
                    utente=(Utente)utenteDAO.cercaUtentebyEmail(email,password);
                    if(utente!=null){
                           if(session.getAttribute("carrello")!=null){
                             //  Carrello carrello=(Carrello) session.getAttribute("carrello");
                              // utente.setCarrello(carrello);
                              session.removeAttribute("carrello");
                           }

                            session.setAttribute("utente", utente);
                            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/index.jsp"));

                    }else {
                        request.setAttribute("errore","Utente non trovato");
                        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/pagine/formLogin.jsp");
                        dispatcher.forward(request,response);
                    }

                }
              /*  else {
                    response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/index.jsp"));
                }*/
                break;
            case "logout":
                if(utente!=null){

                    session.removeAttribute("utente");
                    Carrello carrello=(Carrello) session.getAttribute("carrello");
                    if(carrello!=null){
                        session.removeAttribute("carrello");
                    }

                    response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/index.jsp"));
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       doGet(request,response);
    }
}
