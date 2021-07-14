package controller;

import model.categoria.Categoria;
import model.categoria.CategoriaDAO;
import model.marchio.Marchio;
import model.marchio.MarchioDAO;
import model.utente.Utente;
import model.utente.UtenteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletStart", value = "/ServletStart",loadOnStartup = 0)
public class ServletStart extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();

        CategoriaDAO categoriaDAO= new CategoriaDAO();
        ArrayList<Categoria>categorie= categoriaDAO.doRetraiveByAllCategorieRoot();
        MarchioDAO marchioDAO= new MarchioDAO();
        ArrayList<Marchio> marchi= marchioDAO.doRetraiveByAllMarchi();
        getServletContext().setAttribute("marchi",marchi);
        getServletContext().setAttribute("categorie",categorie);
        System.out.println("size " + marchi.size());

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
