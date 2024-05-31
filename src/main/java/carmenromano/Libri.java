package carmenromano;

import carmenromano.enums.Genere;


public class Libri extends Catalogo{
    private String autore;
    private Genere genere;


    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Libri(String titolo, Genere genere, String autore) {
        super(titolo);
        this.genere = genere;
        this.autore = autore;
    }
    public String toString() {
        return "Libri{" +
                "codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                ", genere=" + genere +
                ", autore='" + autore + '\'' +
                '}';
    }
}
