package model.prodotto;

import model.categoria.Categoria;
import model.marchio.Marchio;
import model.storage.ConPool;
import model.utente.Utente;
import model.utente.UtenteDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class ProdottoDAO implements ProdottoDAOMethod {

    public Prodotto cercaProdotto(int codiceProdotto) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement preparedStatement;
            preparedStatement = connection.prepareStatement("select * from Prodotto where codiceProdotto=?");
            preparedStatement.setInt(1, codiceProdotto);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Prodotto prodotto = new Prodotto();
                prodotto.setCodiceProdotto(resultSet.getInt("codiceProdotto"));

             /*   UtenteDAO utenteDAO= new UtenteDAO();
                ArrayList<Utente> lista = utenteDAO.doRetraiveByAllUtenti();
                for(Utente u : lista){
                    if(u.getCodiceFiscale().equals(resultSet.getString(3))){
                        prodotto.addUtente(u);
                    }
                }*/
                prodotto.setNome(resultSet.getString("nome"));
                prodotto.setPrezzo(resultSet.getInt("prezzo"));
                Marchio m = new Marchio();
                m.setNomeMarchio(resultSet.getString("nomeMarchio"));
                prodotto.setMarchio(m);
                //  prodotto.getMarchio().setNomeMarchio(resultSet.getString("nomeMarchio"));
                prodotto.setQuantita(resultSet.getInt("quantita"));
                Categoria c = new Categoria();
                c.setIdCategoria(resultSet.getInt("idCategoria"));
                prodotto.setCategoria(c);
                prodotto.setPathImmagine(resultSet.getString("pathImmagine"));
                prodotto.setDescrrizione(resultSet.getString("descrizione"));
                return prodotto;
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return null;
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

    //(nome,prezzo,nomeMarchio,quantita,idCategoria,pathImmagine,descrizione)
    @Override
    public void insertProdotto(Prodotto p) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement
                    ("insert into Prodotto(nome,prezzo,nomeMarchio,quantita,idCategoria,pathImmagine,descrizione) " +
                            "value (?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            //ps.setInt(1,p.getCodiceProdotto());
            // ps.setInt(1,p.getCarrello().getCodiceCarrello());
            //  ps.setString(1, null);

            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getPrezzo());
            ps.setString(3, p.getMarchio().getNomeMarchio());
            ps.setInt(4, p.getQuantita());
            ps.setInt(5, p.getCategoria().getIdCategoria());
            ps.setString(6, p.getPathImmagine());
            ps.setString(7, p.getDescrrizione());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            p.setCodiceProdotto(id);
            //ps.execute();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }


    @Override
    public void updateProdotto(Prodotto p, int codiceProdotto) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("update Messaggio set codiceCarrello = ?, nome = ?, prezzo = ?," +
                    "nomeMarchio = ?, quantita = ?, idCategoria = ?" +
                    "where codiceProdotto = ?", Statement.RETURN_GENERATED_KEYS);

            // ps.setString(2, p.getUtente().getCodiceFiscale()); NON PUOI E' PRIMARY KEY
            ps.setString(2, p.getNome());
            ps.setDouble(3, p.getPrezzo());
            ps.setString(4, p.getMarchio().getNomeMarchio());
            ps.setInt(5, p.getQuantita());
            ps.setInt(6, p.getCategoria().getIdCategoria());
            ps.setInt(7, p.getCodiceProdotto());
            if (ps.executeUpdate() != 1) {
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
    public ArrayList<Prodotto> doRetraiveByAllProdotti() {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("select * from Prodotto");
            ResultSet rs = ps.executeQuery();
            ArrayList<Prodotto> lista = new ArrayList<>();
            while (rs.next()) {
                Prodotto prodotto = new Prodotto();
                prodotto.setCodiceProdotto(rs.getInt(1));
                // prodotto.getCarrello().setCodiceCarrello(rs.getInt(2));
                //    prodotto.getUtente().setCodiceFiscale(rs.getString(3)); NULL
                prodotto.setNome(rs.getString(4));
                prodotto.setPrezzo(rs.getInt(5));
                // prodotto.getMarchio().setNomeMarchio(rs.getString(6));
                prodotto.setQuantita(rs.getInt(7));
                prodotto.setPathImmagine(rs.getString(9));
                prodotto.setDescrrizione(rs.getString(10));
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
                Prodotto prodotto = new Prodotto();
                prodotto.setCodiceProdotto(rs.getInt(1));

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
    public ArrayList<Prodotto> cercaProdottiRoot(int root) {
        try (Connection connection = ConPool.getConnection()) {
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            PreparedStatement ps;
            if (root == 2 || root == 3) {
                ps = connection.prepareStatement("select p.codiceProdotto,p.nome,p.prezzo,p.nomeMarchio,p.quantita,p.idCategoria,p.pathImmagine,p.descrizione" +
                        " from Prodotto p where p.idCategoria=?;");
                ps.setInt(1, root);
            } else {
                ps = connection.prepareStatement("select p.codiceProdotto,p.nome,p.prezzo,p.nomeMarchio,p.quantita," +
                        "p.idCategoria,p.pathImmagine,p.descrizione " +
                        "from Prodotto p,Categoria c where p.idCategoria=c.idCategoria and ?= c.root;");
                ps.setInt(1, root);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodiceProdotto(rs.getInt("codiceProdotto"));


                p.setNome(rs.getString("nome"));
                p.setPrezzo(rs.getDouble("prezzo"));
                Marchio m = new Marchio();
                m.setNomeMarchio(rs.getString("nomeMarchio"));
                p.setMarchio(m);
                p.setQuantita(rs.getInt("quantita"));
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                p.setCategoria(c);
                p.setPathImmagine(rs.getString("pathImmagine"));
                p.setDescrrizione(rs.getString("descrizione"));
                prodotti.add(p);
            }
            return prodotti;

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }

    }

    @Override
    public ArrayList<Prodotto> cercaProdotti(int root, int start, int end) {
        try (Connection connection = ConPool.getConnection()) {
            ArrayList<Prodotto> prodotti = new ArrayList<>();
            PreparedStatement ps;
            if (root == 2 || root == 3) {
                ps = connection.prepareStatement("select p.codiceProdotto,p.nome,p.prezzo,p.nomeMarchio,p.quantita,p.idCategoria,p.pathImmagine,p.descrizione" +
                        " from Prodotto p where p.idCategoria=? limit ?,?;");
                ps.setInt(1, root);
                ps.setInt(2, start);
                ps.setInt(3, end);
            } else {
                ps = connection.prepareStatement("select p.codiceProdotto,p.nome,p.prezzo,p.nomeMarchio,p.quantita," +
                        "p.idCategoria,p.pathImmagine,p.descrizione " +
                        "from Prodotto p,Categoria c where p.idCategoria=c.idCategoria and ?= c.root limit ?,?;");
                ps.setInt(1, root);
                ps.setInt(2, start);
                ps.setInt(3, end);
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Prodotto p = new Prodotto();
                p.setCodiceProdotto(rs.getInt("codiceProdotto"));


                p.setNome(rs.getString("nome"));
                p.setPrezzo(rs.getDouble("prezzo"));
                Marchio m = new Marchio();
                m.setNomeMarchio(rs.getString("nomeMarchio"));
                p.setMarchio(m);
                p.setQuantita(rs.getInt("quantita"));
                Categoria c = new Categoria();
                c.setIdCategoria(rs.getInt("idCategoria"));
                p.setCategoria(c);
                p.setPathImmagine(rs.getString("pathImmagine"));
                p.setDescrrizione(rs.getString("descrizione"));
                prodotti.add(p);
            }
            return prodotti;

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}