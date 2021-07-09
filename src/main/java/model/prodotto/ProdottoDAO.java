package model.prodotto;

import model.storage.ConPool;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class ProdottoDAO implements ProdottoDAOMethod {

    public Optional<Prodotto> cercaProdotto(int codiceProdotto)  {
        try(Connection connection= ConPool.getConnection()){
            PreparedStatement preparedStatement;
            preparedStatement=connection.prepareStatement("select * from Prodotto where codiceProdotto=?");
            preparedStatement.setInt(1,codiceProdotto);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                Prodotto prodotto= new Prodotto();
                prodotto.setCodiceProdotto(resultSet.getInt(1));
                prodotto.getCarrello().setCodiceCarrello(resultSet.getInt(2));
                UtenteDAO utenteDAO= new UtenteDAO();
                ArrayList<Utente> lista = utenteDAO.doRetraiveByAllUtenti();
                for(Utente u : lista){
                    if(u.getCodiceFiscale().equals(resultSet.getString(3))){
                        prodotto.addUtente(u);
                    }
                }
                prodotto.setNome(resultSet.getString(4));
                prodotto.setPrezzo(resultSet.getInt(5));
                prodotto.getMarchio().setNomeMarchio(resultSet.getString(6));
                prodotto.setQuantita(resultSet.getInt(7));
                prodotto.getCategoria().setIdCategoria(resultSet.getInt(8));
                return Optional.of(prodotto);
            }
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
        return Optional.empty();
    }

    @Override
    public void deleteProdotto(int codiceProdotto) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("delete from Prodotto where codiceProdotto=?");
            ps.setInt(1, codiceProdotto);
            ps.execute();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void insertProdotto(Prodotto p)  {
        try(Connection connection=ConPool.getConnection()){
            PreparedStatement ps= connection.prepareStatement
                    ("insert into Prodotto value (?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1,p.getCodiceProdotto());
            ps.setInt(1,p.getCarrello().getCodiceCarrello());
            ps.setString(2, null);
            ps.setString(3,p.getNome());
            ps.setDouble(4,p.getPrezzo());
            ps.setString(5,p.getMarchio().getNomeMarchio());
            ps.setInt(6,p.getQuantita());
            ps.setInt(7,p.getCategoria().getIdCategoria());
            ps.setString(8, p.getPathImmagine());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            p.setCodiceProdotto(id);
            ps.execute();
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void updateProdotto(Prodotto p, int codiceProdotto){
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("update Messaggio set codiceCarrello = ?, nome = ?, prezzo = ?," +
                    "nomeMarchio = ?, quantita = ?, idCategoria = ?" +
                    "where codiceProdotto = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getCarrello().getCodiceCarrello());
           // ps.setString(2, p.getUtente().getCodiceFiscale()); NON PUOI E' PRIMARY KEY
            ps.setString(2, p.getNome());
            ps.setDouble(3, p.getPrezzo());
            ps.setString(4, p.getMarchio().getNomeMarchio());
            ps.setInt(5, p.getQuantita());
            ps.setInt(6, p.getCategoria().getIdCategoria());
            ps.setInt(7, p.getCodiceProdotto());
            if(ps.executeUpdate() != 1) {
                throw new RuntimeException("update error");
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void aggiungiUtente(Utente utente) {

    }

   /* @Override
    public void aggiungiUtente(int codiceProdotto,Utente utente) {
        try(Connection connection=ConPool.getConnection()){
            ProdottoDAO prodottoDAO= new ProdottoDAO();
            Optional<Prodotto> prodotto=prodottoDAO.cercaProdotto(codiceProdotto);
            if(prodotto.isPresent()){

            }



        }catch (SQLException sqlException){

            throw new RuntimeException(sqlException);
        }
    }*/

    @Override
    public ArrayList<Prodotto> doRetraiveByAllProdotti(){
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("select * from Prodotto");
            ResultSet rs = ps.executeQuery();
            ArrayList<Prodotto> lista = new ArrayList<>();
            while (rs.next()) {
                Prodotto prodotto=new Prodotto();
                prodotto.setCodiceProdotto(rs.getInt(1));
               // prodotto.getCarrello().setCodiceCarrello(rs.getInt(2));
            //    prodotto.getUtente().setCodiceFiscale(rs.getString(3)); NULL
                prodotto.setNome(rs.getString(4));
                prodotto.setPrezzo(rs.getInt(5));
               // prodotto.getMarchio().setNomeMarchio(rs.getString(6));
                prodotto.setQuantita(rs.getInt(7));
                prodotto.setPathImmagine(rs.getString(9));
            //    prodotto.getCategoria().setIdCategoria(rs.getInt(8));
                lista.add(prodotto);
            }
            connection.close();
            return lista;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public ArrayList<Prodotto> doRetraiveByAllProdottiByMarchio(String nomeMarchio) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("select distinct * from Prodotto where nomeMarchio = ?");
            ps.setString(1, nomeMarchio);
            ResultSet rs = ps.executeQuery();
            ArrayList<Prodotto> lista = new ArrayList<>();
            while (rs.next()) {
                Prodotto prodotto=new Prodotto();
                prodotto.setCodiceProdotto(rs.getInt(1));
                prodotto.getCarrello().setCodiceCarrello(rs.getInt(2));
                // prodotto.getUtente().setCodiceFiscale(rs.getString(3)); NULL
                prodotto.setNome(rs.getString(4));
                prodotto.setPrezzo(rs.getInt(5));
                prodotto.getMarchio().setNomeMarchio(rs.getString(6));
                prodotto.setQuantita(rs.getInt(7));
                prodotto.getCategoria().setIdCategoria(rs.getInt(8));
                lista.add(prodotto);
            }
            connection.close();
            return lista;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public ArrayList<Prodotto> cercaProdotti(int start, int end) {
        ArrayList<Prodotto> lista =new ArrayList<>();
        try(Connection connection=ConPool.getConnection()){

            PreparedStatement ps=connection.prepareStatement("select * from Prodotto order by codiceProdotto" +
                    "limit ? offset ?");
            ps.setInt(1,start);
            ps.setInt(2,end);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Prodotto prodotto=new Prodotto();
                prodotto.setCodiceProdotto(rs.getInt(1));
                prodotto.getCarrello().setCodiceCarrello(rs.getInt(2));
              //  prodotto.getUtente().setCodiceFiscale(rs.getString(3)); NULL
                prodotto.setNome(rs.getString(4));
                prodotto.setPrezzo(rs.getInt(5));
                prodotto.getMarchio().setNomeMarchio(rs.getString(6));
                prodotto.setQuantita(rs.getInt(7));
                prodotto.getCategoria().setIdCategoria(rs.getInt(8));
                lista.add(prodotto);
            }
            connection.close();
            return lista;
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }
}