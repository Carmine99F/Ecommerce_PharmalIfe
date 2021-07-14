package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletInvioMessaggio", value = "/ServletInvioMessaggio")
public class ServletInvioMessaggio extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nomeUtente=request.getParameter("firstname");
        String cognome=request.getParameter("lastname");
        String telefono=request.getParameter("telefono");
        String email=request.getParameter("email");
        String messaggio=request.getParameter("messaggio");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
