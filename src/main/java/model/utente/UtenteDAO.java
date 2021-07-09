package model.utente;

import model.messaggio.Messaggio;
import model.ordine.Ordine;
import model.prodotto.Prodotto;
import model.storage.ConPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class UtenteDAO implements UtenteDAOMethod {

    @Override
    public Optional<Utente> cercaUtente(String codiceFiscale) {
        try(Connection connection= ConPool.getConnection()){

            PreparedStatement ps;
            ps=connection.prepareStatement("select * from Utente where codiceFiscale=?");
            ps.setString(1, codiceFiscale);

            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                Utente utente= new Utente();
                utente.setCodiceFiscale(rs.getString(1));
                utente.setNome(rs.getString(2));
                utente.setCognome(rs.getString(3));
                utente.setEmail(rs.getString(4));
                utente.setPassword(rs.getString(5));
                utente.setVia(rs.getString(6));
                utente.setNumeroCivico(rs.getInt(7));
                utente.setCap(rs.getString(8));
                utente.setTelefono(rs.getString(9));
                utente.setAdmin(rs.getBoolean(10));
                return Optional.of(utente);
            }
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
        return Optional.empty();
    }

    @Override
    public Utente cercaUtentebyEmail(String email) {
        try(Connection connection= ConPool.getConnection()){

            PreparedStatement ps;
            ps=connection.prepareStatement("select * from Utente where email=?");
            ps.setString(1, email);

            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                Utente utente= new Utente();
                utente.setCodiceFiscale(rs.getString(1));
                utente.setNome(rs.getString(2));
                utente.setCognome(rs.getString(3));
                utente.setEmail(rs.getString(4));
                utente.setPassword(rs.getString(5));
                utente.setVia(rs.getString(6));
                utente.setNumeroCivico(rs.getInt(7));
                utente.setCap(rs.getString(8));
                utente.setTelefono(rs.getString(9));
                utente.setAdmin(rs.getBoolean(10));
                return utente;
            }
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
        return null;
    }

    @Override
    public ArrayList<Prodotto> preferiti(String codiceFiscale) {
        ArrayList<Prodotto> prodottiPreferiti= new ArrayList<>();
        try(Connection connection=ConPool.getConnection()){

            PreparedStatement ps=connection.prepareStatement("select * from Preferito as pref inner join Utente ut " +
                    "on pref.codiceFiscale=ut.codiceFiscale inner join Prodotto pro on pref.codiceProdotto=pro.codiceProdotto" +
                    "where ut.codiceFiscale=?");
            ps.setString(1,codiceFiscale);

            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Prodotto p= new Prodotto();

                p.setCodiceProdotto(rs.getInt(12));
                p.getCarrello().setCodiceCarrello(rs.getInt(13));
                UtenteDAO utenteDAO= new UtenteDAO();
                ArrayList<Utente> lista = utenteDAO.doRetraiveByAllUtenti();
                for(Utente u : lista){
                    if(u.getCodiceFiscale().equals(rs.getString(1))){
                        p.addUtente(u);
                    }
                }
                p.setNome(rs.getString(15));
                p.setPrezzo(rs.getDouble(16));
                p.getMarchio().setNomeMarchio(rs.getString(17));
                p.setQuantita(rs.getInt(18));
                p.getCategoria().setIdCategoria(rs.getInt(19));
                prodottiPreferiti.add(p);
            }
        }catch (SQLException sqlException){

            throw new RuntimeException(sqlException);
        }

        return prodottiPreferiti;

    }

    @Override
    public ArrayList<Ordine> ordiniAllUtenti() {
        ArrayList<Ordine> ordini= new ArrayList<>();
        try(Connection connection=ConPool.getConnection()){

            PreparedStatement ps=connection.prepareStatement("select * from Ordine o , Utente u  " +
                    "where o.cfUtente=u.codiceFiscale;");
           ResultSet rs=ps.executeQuery();
           while (rs.next()){
               Ordine o = new Ordine();
               o.setIdOrdine(rs.getInt(1));
               o.setDataOrdine(rs.getDate(2));
               o.setOra(rs.getTime(3));
               o.getUtente().setCodiceFiscale(rs.getString(4));
               o.getUtente().setNome(rs.getString(6));
               o.getUtente().setCognome(rs.getString(7));
               o.getUtente().setEmail(rs.getString(8));
               o.getUtente().setVia(rs.getString(10));
               o.getUtente().setNumeroCivico(rs.getInt(11));
               o.getUtente().setCap(rs.getString(12));
               o.getUtente().setTelefono(rs.getString(13));
               o.getUtente().setAdmin(rs.getBoolean(14));

               ordini.add(o);
           }

        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
        return ordini;
    }

    @Override
    public ArrayList<Messaggio> messaggiAllUtenti() {
        ArrayList<Messaggio> messaggi= new ArrayList<>();
        try(Connection connection=ConPool.getConnection()){

            PreparedStatement ps=connection.prepareStatement("select * from Messaggio m , Utente u  " +
                    "where m.cf=u.codiceFiscale;");
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Messaggio m = new Messaggio();
                m.setCodiceMessaggio(rs.getInt(1));
                m.setTesto(rs.getString(2));
                m.setData(rs.getDate(3));
                m.setOra(rs.getTime(4));
                m.getUtente().setCodiceFiscale(rs.getString(5));
                m.getUtente().setNome(rs.getString(7));
                m.getUtente().setCognome(rs.getString(8));
                m.getUtente().setEmail(rs.getString(9));
                m.getUtente().setAdmin(rs.getBoolean(10));

                messaggi.add(m);
            }

        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
        return messaggi;
    }


    @Override
    public void deleteUtente(String codiceFiscale) {
        try(Connection connection=ConPool.getConnection()){
            PreparedStatement ps;
            ps=connection.prepareStatement("delete from Utente where codiceFiscale=?");
            ps.setString(1, codiceFiscale);
            ps.execute();
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void insertUtente(Utente u) {
        try(Connection connection=ConPool.getConnection()){

            PreparedStatement ps= connection.prepareStatement("insert into Utente value (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getCodiceFiscale());
            ps.setString(2, u.getNome());
            ps.setString(3, u.getCognome());
            ps.setString(4, u.getEmail());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getVia());
            ps.setInt(7, u.getNumeroCivico());
            ps.setString(8, u.getCap());
            ps.setString(9, u.getTelefono());
            ps.setBoolean(10, u.isAdmin());
            ps.execute();

        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void updateUtente(Utente u, String codiceFiscale) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("update Utente set nome = ?, cognome = ?, email = ?, password = ?, via = ?," +
                    "numeroCivico = ?, cap = ?, telefono = ?, isAdmin = ? " +
                    "where codiceFiscale = ?", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getCognome());
            ps.setString(3, u.getEmail());
            ps.setString(4, u.getPassword());
            ps.setString(5, u.getVia());
            ps.setInt(6, u.getNumeroCivico());
            ps.setString(7, u.getCap());
            ps.setString(8, u.getTelefono());
            ps.setBoolean(9, u.isAdmin());
            ps.setString(10, u.getCodiceFiscale());
            if(ps.executeUpdate() != 1) {
                throw new RuntimeException("update error");
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public ArrayList<Utente> doRetraiveByAllUtenti() {
        ArrayList<Utente> lista = new ArrayList<>();
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("select * from Utente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               Utente utente=new Utente();
               utente.setCodiceFiscale(rs.getString(1));
               utente.setNome(rs.getString(2));
               utente.setCognome(rs.getString(3));
               utente.setEmail(rs.getString(4));
               utente.setPassword(rs.getString(5));
               utente.setVia(rs.getString(6));
               utente.setNumeroCivico(rs.getInt(7));
               utente.setCap(rs.getString(8));
               utente.setTelefono(rs.getString(9));
               utente.setAdmin(rs.getBoolean(10));
               lista.add(utente);
            }
            connection.close();
            return lista;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public ArrayList<Utente> cercaUtenti(int start, int end) {
        ArrayList<Utente> lista =new ArrayList<>();
        try(Connection connection=ConPool.getConnection()){

            PreparedStatement ps=connection.prepareStatement("select * from Utente order by codiceProdotto" +
                    "limit ? offset ?");
            ps.setInt(1,start);
            ps.setInt(2,end);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Utente utente=new Utente();
                utente.setCodiceFiscale(rs.getString(1));
                utente.setNome(rs.getString(2));
                utente.setCognome(rs.getString(3));
                utente.setEmail(rs.getString(4));
                utente.setPassword(rs.getString(5));
                utente.setVia(rs.getString(6));
                utente.setNumeroCivico(rs.getInt(7));
                utente.setCap(rs.getString(8));
                utente.setTelefono(rs.getString(9));
                utente.setAdmin(rs.getBoolean(10));
                lista.add(utente);
            }
            connection.close();
            return lista;
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }
}
