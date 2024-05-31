package carmenromano;
import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Archivio {
    private List<Catalogo> catalogoList;

    public Archivio() {
        super();
        this.catalogoList = new ArrayList<>();
    }

    public void riempiConLibriCasuali() {
        Supplier<Libri> libriSupplier = () -> {
            Faker faker = new Faker();
            return new Libri(faker.book().title(), Genere.FANTASY,faker.book().author());
        };

        for (int i = 0; i < 50; i++) {
            catalogoList.add(libriSupplier.get());
        }
    }
    public void riempiConRivisteCasuali() {
        Supplier<Riviste> rivisteSupplier = () -> {
            Faker faker = new Faker();
            return new Riviste(faker.book().title(), Periodicità.MENSILE);
        };

        for (int i = 0; i < 50; i++) {
            catalogoList.add(rivisteSupplier.get());
        }
    }

    public void aggiungiLibro(String titolo,Genere genere, String autore) {
        if (titolo.isEmpty() || autore.isEmpty()) {
            System.out.println("Aggiungi un titolo e/o un autore");
        }
        catalogoList.add(new Libri(titolo,genere,autore));
    }
    public void aggiungiRivista(String titolo, Periodicità periodicità){
        if (titolo.isEmpty()){
            System.out.println("Aggiungi un titolo!");
        }
        catalogoList.add(new Riviste(titolo, periodicità));
    }

    public List<Catalogo> searchByISBN(String ISBN) {
        return catalogoList.stream().filter(elemento -> elemento.getCodiceISBN().equals(ISBN))
                .collect(Collectors.toList());
    }
    public void removeByIsbn(String ISBN) {
        Catalogo isbnRemove = null;
        for (Catalogo elemento : catalogoList) {
            if (elemento.getCodiceISBN().equals(ISBN)) {
                isbnRemove = elemento;
                break;
            }
        }
        catalogoList.remove(isbnRemove);
    }

    public List<Catalogo> searchByYear(Year annoDiPubblicazione) {
        return catalogoList.stream().filter(elemento -> elemento.getAnnoPubblicazione().equals(annoDiPubblicazione))
                .collect(Collectors.toList());
    }
    public List<Libri> searchByAutore(String autore) {
        return catalogoList.stream()
                .filter(elemento -> elemento instanceof Libri).map(elemento -> (Libri) elemento).filter(libro -> libro.getAutore().equalsIgnoreCase(autore))
                .collect(Collectors.toList());
    }

    public List<Catalogo> getCatalogoList() {
        return catalogoList;
    }

    public void setCatalogoList(List<Catalogo> catalogoList) {
        this.catalogoList = catalogoList;
    }


    public void salvaSuDisco(String name, List<Catalogo> catalogoList) {
        File archivioDisc = new File("src/" + name + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivioDisc))) {
            for (Catalogo elemento : catalogoList) {
                writer.write(elemento.toString() + "|||");
                writer.newLine();
            }
            System.out.println("Dati salvati con successo su disco.");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio su disco: " + e.getMessage());
        }
    }



    @Override
    public String toString() {
        return "Archivio{" +
                "catalogoList=" + catalogoList +
                '}';
}
    }

