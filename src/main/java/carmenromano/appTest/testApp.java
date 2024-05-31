package carmenromano.appTest;

import carmenromano.Archivio;
import carmenromano.Catalogo;
import carmenromano.Libri;
import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;

import java.util.List;

public class testApp {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        archivio.riempiConLibriCasuali();
        archivio.riempiConRivisteCasuali();
        System.out.println(archivio);

        archivio.aggiungiLibro("Titolo1", Genere.FANTASY, "Frank");
        archivio.aggiungiRivista("Titolo2", Periodicità.SEMESTRALE);
        List<Catalogo> libriTrovati = archivio.searchByISBN("ISBN-1001");
        System.out.println("Libri trovati:");
        for (Catalogo libro : libriTrovati) {
            System.out.println(libro);
        }


    }

}
