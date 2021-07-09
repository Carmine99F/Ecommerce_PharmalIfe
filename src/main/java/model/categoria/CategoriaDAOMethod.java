package model.categoria;

import java.util.ArrayList;
import java.util.Optional;

public interface CategoriaDAOMethod {

    public Optional<Categoria> cercaCategoria(int idCategoria);
    public void deleteCategoria(int idCategoria);
    public void insertCategoria(Categoria c);
    public void updateCategoria(Categoria c, int idCategoria);
    public ArrayList<Categoria> doRetraiveByAllCategorie();
    public ArrayList<Categoria> cercaCategorie(int start,int end);

}
