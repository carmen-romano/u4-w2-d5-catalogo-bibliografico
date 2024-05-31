package carmenromano;

import carmenromano.enums.Genere;

import java.time.Year;

public class Libri extends Catalogo{
    private String autore;
    private Genere genere;


    public Libri(String titolo, Year annoPubblicazione, long codiceISBN, int numeroPagine, Genere genere, String autore) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.genere = genere;
        this.autore = autore;
    }

}
