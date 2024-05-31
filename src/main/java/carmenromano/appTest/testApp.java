package carmenromano.appTest;

import carmenromano.Archivio;
import carmenromano.Catalogo;
import carmenromano.Libri;
import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;

import java.time.Year;
import java.util.List;

public class testApp {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        archivio.riempiConLibriCasuali();
        archivio.riempiConRivisteCasuali();
        System.out.println(archivio);

        archivio.aggiungiLibro("Titolo1", Genere.FANTASY, "Frank");
        archivio.aggiungiRivista("Titolo2", Periodicità.SEMESTRALE);
        List<Catalogo> libriTrovati = archivio.searchByISBN("ISBN-12345678913");
        System.out.println("Libro trovato:" + libriTrovati);
        archivio.removeByIsbn("ISBN-12345678913");

        List<Catalogo> libriTrovati2 = archivio.searchByISBN("ISBN-12345678913");
        System.out.println("Libro trovato:" + libriTrovati2);

        List<Catalogo> risultati = archivio.searchByYear(Year.of(2010));
        System.out.println("Libri trovati:" + risultati);

        List<Libri> cercoPerAutore = archivio.searchByAutore("Frank");
        System.out.println("Libri trovati tramite ricerca autore:" + cercoPerAutore);



    }

}
