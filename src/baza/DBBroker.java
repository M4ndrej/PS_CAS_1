/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Andrej
 */
public class DBBroker {
    
     public List<Autor> ucitajAutoreIzBaze() {
        List<Autor> listaAutora = new ArrayList<>();
        
        try {
            String upit = "SELECT * FROM autor a";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                
                int autorId = rs.getInt("a.id");
                String ime = rs.getString("a.ime");
                String prezime = rs.getString("a.prezime");
                String biografija = rs.getString("a.biografija");
                String godinaRodjenja = rs.getString("a.godinaRodjenja");
                Autor a = new Autor(autorId,ime,prezime,godinaRodjenja,biografija);
                Konekcija.getInstance().getConnection().commit();
                listaAutora.add(a);
            
        }
            
            return listaAutora;
        } catch (SQLException sQLException) {
        }
        
        return listaAutora;
    }

    public List<Knjiga> ucitajListuIzBaze() {
        List<Knjiga> lista = new ArrayList<>();
        
        try {
            String upit = "SELECT * FROM KNJIGA k JOIN AUTOR a ON k.autorId = a.id";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
                int id = rs.getInt("k.id");
                String naslov = rs.getString("k.naslov");
                String godinaIzdanja = rs.getString("k.godinaIzdanja");
                String ISBN = rs.getString("k.ISBN");
                String zanr = rs.getString("k.zanr");
                Zanr z = Zanr.valueOf(zanr);
                int autorId = rs.getInt("a.id");
                String ime = rs.getString("a.ime");
                String prezime = rs.getString("a.prezime");
                String biografija = rs.getString("a.biografija");
                String godinaRodjenja = rs.getString("a.godinaRodjenja");
                Autor a = new Autor(autorId,ime,prezime,godinaRodjenja,biografija);
                
                Knjiga k = new Knjiga(id, naslov, a, ISBN, godinaIzdanja, z);
                Konekcija.getInstance().getConnection().commit();
                lista.add(k);
            
        }
            
            return lista;
        } catch (SQLException sQLException) {
        }
        
        return lista;
    }

    public void obrisiKnjigu(int id) {
        String upit = "DELETE FROM knjiga WHERE id =?";
        
         try {
             PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
             ps.setInt(1,id);
             ps.executeUpdate();
             System.out.println(upit);
             Konekcija.getInstance().getConnection().commit();
             
         } catch (SQLException ex) {
             Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
             
         }
        
    }

    public void dodajKnjigu(Knjiga knjiga) {
        
        try{
        String upit = "INSERT INTO knjiga(id,naslov,autorId,ISBN,godinaIzdanja,zanr)" + "VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
        ps.setInt(1, knjiga.getId());
        ps.setString(2,knjiga.getNaslov());
        ps.setInt(3,knjiga.getAutor().getId());
        ps.setString(4,knjiga.getISBN());
        ps.setString(5, knjiga.getGodinaIzdanja());
        ps.setString(6, String.valueOf(knjiga.getZanr()));
        ps.executeUpdate();
        Konekcija.getInstance().getConnection().commit();}
        catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        
        try{
        String upit = "UPDATE knjiga SET naslov = ?, autorId = ?, godinaIzdanja = ?, zanr = ? WHERE id = ?";
        PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
        
        ps.setString(1,knjigaZaIzmenu.getNaslov());
        ps.setInt(2,knjigaZaIzmenu.getAutor().getId());
        ps.setString(3, knjigaZaIzmenu.getGodinaIzdanja());
        ps.setString(4, String.valueOf(knjigaZaIzmenu.getZanr()));
        ps.setInt(5, knjigaZaIzmenu.getId());
        ps.executeUpdate();
        
        Konekcija.getInstance().getConnection().commit();
        
        }catch(Exception e){
            
        }
        
    }
    
}
