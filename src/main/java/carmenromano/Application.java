package carmenromano;

import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;

import java.time.Year;
import java.util.UUID;

public class Application {

    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        archivio.riempiConLibriCasuali();
        archivio.riempiConRivisteCasuali();
        System.out.println(archivio);

        archivio.aggiungiLibro("Titolo1",Genere.FANTASY,"Frank");
        archivio.aggiungiRivista("Titolo2", Periodicità.SEMESTRALE);

        archivio.searchByISBN("fe3ddb59-704b");
    }
}
