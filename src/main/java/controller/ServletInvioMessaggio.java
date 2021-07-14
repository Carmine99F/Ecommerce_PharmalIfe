package controller;

import model.messaggio.Messaggio;
import model.messaggio.MessaggioDAO;
import model.utente.Utente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

@WebServlet(name = "ServletInvioMessaggio", value = "/ServletInvioMessaggio")
public class ServletInvioMessaggio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeUtente=request.getParameter("firstname");
        String cognome=request.getParameter("lastname");
        String telefono=request.getParameter("telefono");
        String email=request.getParameter("email");
        String messaggio=request.getParameter("messaggio");
        HttpSession session = request.getSession();
        Utente utente = (Utente) session.getAttribute("utente");

        //String cf = request.getParameter("codiceFiscale");

        //Date data1 = new Date();
        Date data2 = new Date(System.currentTimeMillis());
        Time time1 = new Time(System.currentTimeMillis());

        MessaggioDAO service = new MessaggioDAO();
        Messaggio m = new Messaggio();
        Utente u=new Utente();
        u.setNome(nomeUtente);
        u.setCognome(cognome);
        u.setTelefono(telefono);
        u.setEmail(email);
        u.setCodiceFiscale(utente.getCodiceFiscale());
        m.setTesto(messaggio);
        m.setData(data2);
        m.setOra(time1);
        //m.setOra(ora);
        //u.setCodiceFiscale(cf);

        m.setUtente(u);
        service.insertMessaggio(m);

        String address="index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}

