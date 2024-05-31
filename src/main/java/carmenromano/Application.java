package carmenromano;

import carmenromano.Archivio;
import carmenromano.Catalogo;
import carmenromano.Libri;
import carmenromano.enums.Genere;
import carmenromano.enums.Periodicità;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        archivio.riempiConRivisteCasuali();
        archivio.riempiConLibriCasuali();
        Scanner scanner = new Scanner(System.in);
        boolean inCorso = true;

        while (inCorso) {
            try {
                System.out.println("Cosa vuoi fare?");
                System.out.println("1. Creare un libro");
                System.out.println("2. Creare una rivista");
                System.out.println("3. Ricerca tramite autore");
                System.out.println("4. Ricerca tramite ISBN");
                System.out.println("5. Ricerca tramite anno");
                System.out.println("6. Eliminare un elemento dall'archivio tramite ISBN");
                System.out.println("7 Visualizzare il nostro archivio");
                System.out.println("0. Uscire");

                int scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta) {
                    case 1:
                        creaLibro(archivio, scanner);
                        break;
                    case 2:
                        creaRivista(archivio, scanner);
                        break;
                    case 3:
                        trovaPerAutore(archivio, scanner);
                        break;
                    case 4:
                        trovaPerISBN(archivio, scanner);
                        break;
                    case 5:
                        trovaPerAnno(archivio, scanner);
                        break;
                    case 6:
                        eliminaPerISBN(archivio, scanner);
                        break;
                    case 7:
                        visualizzaTuttiGliElementi(archivio);
                        break;
                    case 0:
                        inCorso = false;
                        break;

                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input non valido. Riprova.");
                scanner.nextLine();
            }
        }
    }

    private static void creaLibro(Archivio archivio, Scanner scanner) {
        try {
            System.out.println("Inserisci il titolo del libro:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci il genere del libro:");
            System.out.println("1. FANTASY");
            System.out.println("2. THRILLER");
            System.out.println("3. AUTOBIOGRAFICO");
            System.out.println("4. AVVENTURA");
            System.out.println("5. AZIONE");
            Genere genere = null;
            switch (scanner.nextInt()) {
                case 1:
                    genere = Genere.FANTASY;
                    break;
                case 2:
                    genere = Genere.THRILLER;
                    break;

                case 3:
                    genere = Genere.AUTOBIOGRAFICO;
                    break;

                case 4:
                    genere = Genere.AVVENTURA;
                    break;
                case 5:
                    genere = Genere.AZIONE;
                    break;

                default:
                    System.out.println("Genere non valido. Libro non creato.");
                    return;
            }
            scanner.nextLine();

            System.out.println("Inserisci l'autore del libro:");
            String autore = scanner.nextLine();

            archivio.aggiungiLibro(titolo, genere, autore);
            System.out.println("Libro creato con successo!");
        } catch (InputMismatchException e) {
            System.out.println("Errore durante la creazione del libro.");
            scanner.nextLine();
        }
    }

    private static void creaRivista(Archivio archivio, Scanner scanner) {
        try {
            System.out.println("Inserisci il titolo della rivista:");
            String titolo = scanner.nextLine();

            System.out.println("Inserisci la periodicità della rivista:");
            System.out.println("1. MENSILE");
            System.out.println("2. SETTIMANALE");
            System.out.println("3. SEMESTRALE");
            Periodicità periodicità = null;
            switch (scanner.nextInt()) {
                case 1:
                    periodicità = Periodicità.MENSILE;
                    break;
                case 2:
                    periodicità = Periodicità.SETTIMANALE;
                    break;
                case 3:
                    periodicità = Periodicità.SEMESTRALE;
                    break;
                default:
                    System.out.println("Periodicità non valida. Rivista non creata.");
                    return;
            }
            scanner.nextLine();

            archivio.aggiungiRivista(titolo, periodicità);
            System.out.println("Rivista creata con successo!");
        } catch (InputMismatchException e) {
            System.out.println("Errore durante la creazione della rivista.");
            scanner.nextLine();
        }
    }

    private static void trovaPerAutore(Archivio archivio, Scanner scanner) {
        System.out.println("Inserisci l'autore:");
        String autore = scanner.nextLine();
        List<Libri> libriTrovati = archivio.searchByAutore(autore);
        if (libriTrovati.isEmpty()) {
            System.out.println("Nessun libro trovato per l'autore specificato.");
        } else {
            System.out.println("Libri trovati:");
            for (Libri libro : libriTrovati) {
                System.out.println(libro);
            }
        }
    }

    private static void trovaPerISBN(Archivio archivio, Scanner scanner) {
        System.out.println("Inserisci il codice ISBN:");
        String isbn = scanner.nextLine();
        List<Catalogo> elementiTrovati = archivio.searchByISBN(isbn);
        if (elementiTrovati.isEmpty()) {
            System.out.println("Nessun elemento trovato per l'ISBN specificato.");
        } else {
            System.out.println("Elemento trovato:");
            System.out.println(elementiTrovati);
        }
    }

    private static void trovaPerAnno(Archivio archivio, Scanner scanner) {
        System.out.println("Inserisci l'anno di pubblicazione:");
        int anno = scanner.nextInt();
        scanner.nextLine();
        List<Catalogo> elementiTrovati = archivio.searchByYear(Year.of(anno));
        if (elementiTrovati.isEmpty()) {
            System.out.println("Nessun elemento trovato per l'anno specificato.");
        } else {
            System.out.println("Elementi trovati per l'anno specificato:");
            for (Catalogo elemento : elementiTrovati) {
                System.out.println(elemento);
            }
        }
    }

    private static void eliminaPerISBN(Archivio archivio, Scanner scanner) {
        System.out.println("Inserisci il codice ISBN dell'elemento da eliminare:");
        String isbn = scanner.nextLine();
        archivio.removeByIsbn(isbn);
        System.out.println("Elemento eliminato con successo!");
    }

    private static void visualizzaTuttiGliElementi(Archivio archivio) {
        List<Catalogo> catalogoList = archivio.getCatalogoList();
        if (catalogoList.isEmpty()) {
            System.out.println("L'archivio è vuoto.");
        } else {
            System.out.println("Elementi nell'archivio:");
            for (Catalogo elemento : catalogoList) {
                System.out.println(elemento);
            }
        }
    }
}