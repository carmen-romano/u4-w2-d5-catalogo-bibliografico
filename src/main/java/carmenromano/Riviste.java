package carmenromano;

import carmenromano.enums.Periodicità;

import java.time.Year;

public class Riviste extends Catalogo {
    private Periodicità periodicità;

    public Riviste(String titolo, Year annoPubblicazione, long codiceISBN, int numeroPagine, Periodicità periodicità) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

}
