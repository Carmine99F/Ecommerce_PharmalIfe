package model.carrello;

import model.storage.ConPool;
import model.utente.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class CarrelloDAO implements CarrelloDAOMethod {

    @Override
    public Carrello cercaCarrello(int codiceCarrello) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("select * from Carrello where codiceCarrello=? ");
            ps.setInt(1, codiceCarrello);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Carrello carrello = new Carrello();
                carrello.setCodiceCarrello(rs.getInt(1));
                carrello.getUtente().setCodiceFiscale(rs.getString(2));
                carrello.setTotaleProdotti(rs.getInt(3));
                return carrello;
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return null;
    }

    @Override
    public void deleteCarrello(int codiceCarrello) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("delete from Carrello where codiceCarrello=?");
            ps.setInt(1, codiceCarrello);
            ps.execute();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void insertCarrello(Carrello c) {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("insert into Carrello value (?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, c.getUtente().getCodiceFiscale());
            ps.setInt(2, c.getTotaleProdotti());

            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            c.setCodiceCarrello(id);

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void updateCarrello(Carrello c, int codiceCarrello) {
        // Metodo inutile per 'carrello', siccome sono tutti attributi non modificabili
    }

    @Override
    public Carrello cercaCarrelloByUtente(Utente utente) {
        try (Connection connection = ConPool.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("select * from Carrello where codiceFiscale=?");
            ps.setString(1, utente.getCodiceFiscale());

            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Carrello carrello= new Carrello();
                carrello.setCodiceCarrello(rs.getInt("codiceCarrello"));
                Utente utente1= new Utente();
                utente1.setCodiceFiscale(rs.getString("codiceFiscale"));
                carrello.setUtente(utente1);
                carrello.setTotaleProdotti(rs.getInt("totaleProdotti"));
                return carrello;
            }


    }catch(SQLException sqlException) {
        throw new RuntimeException(sqlException);
    }
        return null;

}

    @Override
    public ArrayList<Carrello> doRetraiveByAllCarrelli() {
        try (Connection connection = ConPool.getConnection()) {
            PreparedStatement ps;
            ps = connection.prepareStatement("select * from Carrello");
            ResultSet rs = ps.executeQuery();
            ArrayList<Carrello> lista = new ArrayList<>();
            while (rs.next()) {
                Carrello carrello=new Carrello();
                carrello.setCodiceCarrello(rs.getInt(1));
                carrello.getUtente().setCodiceFiscale(rs.getString(2));
                carrello.setTotaleProdotti(rs.getInt(3));
                lista.add(carrello);
            }
            connection.close();
            return lista;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public ArrayList<Carrello> cercaCarrelli(int start, int end) {
        ArrayList<Carrello> lista =new ArrayList<>();
        try(Connection connection=ConPool.getConnection()){

            PreparedStatement ps=connection.prepareStatement("select * from Carrello order by codiceCarrello" +
                    "limit ? offset ?");
            ps.setInt(1,start);
            ps.setInt(2,end);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Carrello carrello=new Carrello();
                carrello.setCodiceCarrello(rs.getInt(1));
                carrello.getUtente().setCodiceFiscale(rs.getString(2));
                carrello.setTotaleProdotti(rs.getInt(3));
                lista.add(carrello);
            }
            connection.close();
            return lista;
        }catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }
}