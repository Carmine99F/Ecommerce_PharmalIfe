package controller;

import model.utente.Utente;
import model.utente.UtenteDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletLogin", value = "/ServletLogin")
public class ServletLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UtenteDAO utenteDAO = new UtenteDAO();
        ArrayList<Utente> utenti = utenteDAO.doRetraiveByAllUtenti();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String risposta = "assente";
        for (Utente u : utenti) {
            if (u.getEmail().contains(email) && u.getPassword().contains(password)) {
                risposta = "trovato";
            }
        }
        response.getWriter().write(risposta);
        System.out.println(request.getParameter("email") + " ciao" + "RISPOSTA=" +risposta);
    }
}