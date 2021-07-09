package model.prodotto;

import model.utente.Utente;

import java.util.ArrayList;
import java.util.Optional;

public interface ProdottoDAOMethod {
    public Optional<Prodotto> cercaProdotto(int codiceProdotto);
    public void deleteProdotto(int codiceProdotto);
    public void insertProdotto(Prodotto p);
    public void updateProdotto(Prodotto p, int codiceProdotto);
    public void aggiungiUtente(Utente utente);
    public ArrayList<Prodotto> doRetraiveByAllProdotti();
    public ArrayList<Prodotto> doRetraiveByAllProdottiByMarchio(String nomeMarchio);
    public ArrayList<Prodotto> cercaProdotti(int start, int end);
}