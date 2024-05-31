package carmenromano;

import carmenromano.enums.Genere;


public class Libri extends Catalogo{
    private String autore;
    private Genere genere;


    public Libri(String titolo, Genere genere, String autore) {
        super(titolo);
        this.genere = genere;
        this.autore = autore;
    }
}
