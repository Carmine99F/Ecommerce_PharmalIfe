package controller;

import model.utente.Utente;
import model.utente.UtenteDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletIscrizione", value = "/ServletIscrizione")
public class ServletIscrizione extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fn=request.getParameter("nome");
        String ln=request.getParameter("cognome");
        String cf= request.getParameter("CodiceFiscale");
        String email=request.getParameter("email");
        String psw=request.getParameter("psw");
        String psw_rip=request.getParameter("psw-rip");
        String via=request.getParameter("via");
        int numeroCivico=Integer.parseInt(request.getParameter("numeroCivico"));
        String cap=request.getParameter("cap");
        String telefono=request.getParameter("telefono");
        System.out.println(request.getParameter("telefono"));
        UtenteDAO service=new UtenteDAO();
        Utente c=new Utente();
        c.setNome(fn);
        c.setCognome(ln);
        c.setCodiceFiscale(cf);
        c.setEmail(email);
        c.criptPassword(psw);
        c.setVia(via);
        c.setNumeroCivico(numeroCivico);
        c.setCap(cap);
        c.setTelefono(telefono);

        service.insertUtente(c);
        request.setAttribute("customer",c);

        String address="index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(address);
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
