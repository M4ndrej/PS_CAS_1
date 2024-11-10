
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Autor;
import model.Knjiga;
import model.Zanr;
import baza.DBBroker;


public class Controller {
    private DBBroker dbb;
    private List<Knjiga> listaKnjiga;
    private List<Autor> listaAutora;
    private static Controller instance;
    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public Controller() {
        
        dbb = new DBBroker();
        /*Autor autor1 = new Autor("Ivo","Andric", 1892, "Biografija autora Ive Andrica");
        Autor autor2 = new Autor("Danilo","Kiš", 1935, "Biografija Danila Kiša");
        
        Knjiga knjiga1 = new Knjiga("Na Drini ćuprija", autor1,"1231324234",1945,Zanr.DETEKTIVSKI);
        Knjiga knjiga2 = new Knjiga("Bašta, pepeo", autor2, "1231024932",1982,Zanr.ISTORIJSKI);
        
        listaKnjiga = new ArrayList<>();
        listaAutora = new ArrayList<>();
        
        listaKnjiga.add(knjiga1);
        listaKnjiga.add(knjiga2);
        
        listaAutora.add(autor1);
        listaAutora.add(autor2);*/
        
    }

   

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int id) {
        dbb.obrisiKnjigu(id);
    }

    public void dodajKnjigu(Knjiga knjiga) {
        dbb.dodajKnjigu(knjiga);
    }

    public List<Knjiga> ucitajListuIzBaze() {
        return dbb.ucitajListuIzBaze();
    }
    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public List<Autor> ucitajAutoreIzBaze() {
        return dbb.ucitajAutoreIzBaze();
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        dbb.azurirajKnjigu(knjigaZaIzmenu);
    }

 
 

   
    
    
}
