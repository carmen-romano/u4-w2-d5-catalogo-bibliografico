package carmenromano;

import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Iterator;
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
        catalogoList.add(new Libri(titolo,genere,autore));
    }
    public void aggiungiRivista(String titolo, Periodicità periodicità) {
        catalogoList.add(new Riviste(titolo, periodicità));
    }
    public List<Catalogo> searchByISBN(String ISBN) {
        return catalogoList.stream().filter(elemento -> elemento.getCodiceISBN().equals(ISBN))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Archivio{" +
                "catalogoList=" + catalogoList +
                '}';
    }
}
