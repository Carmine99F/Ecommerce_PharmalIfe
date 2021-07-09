package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

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
                case "messaggi"
                    :pagina="";
                break;

            }
            RequestDispatcher dispatcher=request.getRequestDispatcher(pagina);
            dispatcher.forward(request,response);
    }
}
