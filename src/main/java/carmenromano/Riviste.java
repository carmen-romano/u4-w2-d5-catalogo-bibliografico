package carmenromano;

import carmenromano.enums.Periodicità;

public class Riviste extends Catalogo {
    private Periodicità periodicità;


    public Riviste(String titolo, Periodicità periodicità) {
        super(titolo);
        this.periodicità = periodicità;
    }

}

