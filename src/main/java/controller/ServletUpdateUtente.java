package controller;

import model.utente.Utente;
import model.utente.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletUpdateUtente", value = "/ServletUpdateUtente")
public class ServletUpdateUtente extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String codiceFiscale=request.getParameter("codiceFiscale");
        String nomeUtente=request.getParameter("nome");
        String cognomeUtente=request.getParameter("cognome");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String nuovaPassword=request.getParameter("newPassword");
        Utente utente= new Utente();
        utente.setCodiceFiscale(codiceFiscale);
        utente.setNome(nomeUtente);
        utente.setCognome(cognomeUtente);
        utente.setEmail(email);
        utente.criptPassword(nuovaPassword);

        UtenteDAO utenteDAO= new UtenteDAO();
        HttpSession session= request.getSession();
        String up="";
        if(utenteDAO.updateUtente(utente)){
          up="Dati Aggiornati Correttamente";
            Utente u=(Utente) utenteDAO.cercaUtente(utente.getCodiceFiscale());
            System.out.println("Ute" + u.getEmail());
            if(utente!=null){
                session.setAttribute("utente",u);
            }
        }else{
            up="Errore durante l'Aggiornamento";
        }

        request.setAttribute("update",up);
        RequestDispatcher dispatcher= request.getRequestDispatcher("WEB-INF/pagine/InfoUtente.jsp");
        dispatcher.forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
