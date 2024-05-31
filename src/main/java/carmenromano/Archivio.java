package carmenromano;

import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;
import com.github.javafaker.Faker;

import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Archivio {
    private List<Catalogo> catalogoList;
    private String fileName;

    public Archivio(String fileName) {
        super();
        this.catalogoList = new ArrayList<>();
        this.fileName= fileName;
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
        catalogoList.add(new Libri(titolo,genere,autore));
    }
    public void aggiungiRivista(String titolo, Periodicità periodicità) {
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

    @Override
    public String toString() {
        return "Archivio{" +
                "catalogoList=" + catalogoList +
                '}';
    }
}
