package model.carrello;

import java.util.ArrayList;
import java.util.Optional;

public interface CarrelloDAOMethod {

    public Optional<Carrello> cercaCarrello(int codiceCarrello);
    public void deleteCarrello(int codiceCarrello);
    public void insertCarrello(Carrello c);
    public void updateCarrello(Carrello c, int codiceCarrello);
    public ArrayList<Carrello> doRetraiveByAllCarrelli();
    public ArrayList<Carrello> cercaCarrelli(int start,int end);
}
