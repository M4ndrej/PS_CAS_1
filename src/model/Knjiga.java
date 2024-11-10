
package model;


public class Knjiga {
    
    private int id;
    private String naslov;
    private Autor autor;
    private String ISBN;
    private String godinaIzdanja;
    private Zanr zanr;

    public Knjiga() {
    }

    public Knjiga(int id,String naslov, Autor autor, String ISBN, String godinaIzdanja, Zanr zanr) {
        this.id = id;
        this.naslov = naslov;
        this.autor = autor;
        this.ISBN = ISBN;
        this.godinaIzdanja = godinaIzdanja;
        this.zanr = zanr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }
   

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public void setGodinaIzdanja(String godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    @Override
    public String toString() {
        return "Knjiga{" + "naslov=" + naslov + ", autor=" + autor + ", ISBN=" + ISBN + ", godinaIzdanja=" + godinaIzdanja + '}';
    }
    
    
}
