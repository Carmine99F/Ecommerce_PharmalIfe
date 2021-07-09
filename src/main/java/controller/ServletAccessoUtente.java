package controller;

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
       // String email=request.getParameter("emailUser");
      //  String password=request.getParameter("password");

       Utente utente=(Utente) session.getAttribute("utente");
      String valore=request.getParameter("value");
     System.out.println(valore);
        switch (valore){
            case "login":

                if (utente==null){

                    String email=request.getParameter("emailUser");
                    System.out.println("email " +email);
                    String password=request.getParameter("password");
                    UtenteDAO utenteDAO=new UtenteDAO();

                    utente=(Utente)utenteDAO.cercaUtentebyEmail(email);
                    System.out.println("dndinfdif");
                    System.out.println(utente.getPassword());

                    Utente u= new Utente();
                    u.criptPassword(password);


                   System.out.println("utente " + u.getPassword());
                    if(utente!=null){
                        if(utente.getPassword().equals(u.getPassword())) {
                            session.setAttribute("utente", utente);
                            response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/index.jsp"));
                        }
                        else {
                            RequestDispatcher requestDispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/pagine/formLogin.jsp");
                            request.setAttribute("errore", "Utente non trovato");
                            requestDispatcher.forward(request, response);
                        }
                    }else {

                        request.setAttribute("errore","Utente non trovato");
                        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/pagine/formLogin.jsp");
                        dispatcher.forward(request,response);
                    }

                }
                else {
                    response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/index.jsp"));
                }
                break;
            case "logout":
                if(utente!=null){

                    session.removeAttribute("utente");
                    response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/index.jsp"));
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       doGet(request,response);
    }
}
