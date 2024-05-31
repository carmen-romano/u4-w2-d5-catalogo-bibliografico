package carmenromano.files;

import carmenromano.Archivio;
import carmenromano.Catalogo;
import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class fileMain {
    public static void main(String[] args) {
        File archivioDisc = new File("src/archivio.txt");
        try {Archivio archivio = new Archivio();
            archivio.riempiConLibriCasuali();
            archivio.riempiConRivisteCasuali();
            for (Catalogo elemento : archivio.getCatalogoList()) {
                FileUtils.writeStringToFile(archivioDisc, elemento + System.lineSeparator(), StandardCharsets.UTF_8, true);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}


