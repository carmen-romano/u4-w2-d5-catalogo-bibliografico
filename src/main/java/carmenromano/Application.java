package carmenromano;

import carmenromano.Libri;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        archivio.riempiConLibriCasuali();
        archivio.riempiConRivisteCasuali();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Cosa vuoi fare?");
                System.out.println("1. Trovare un libro tramite autore");
                System.out.println("2. Uscire");

                int scelta = scanner.nextInt();
                scanner.nextLine();

                switch (scelta) {
                    case 1:
                        System.out.println("Inserisci l'autore:");
                        String autore = scanner.nextLine();
                        List<Libri> autoreLibro = archivio.searchByAutore(autore);
                        if (autoreLibro.isEmpty()) {
                            System.out.println("Nessun libro trovato per l'autore specificato.");
                        } else {
                            System.out.println("Libri trovati:");
                            for (Libri libro : autoreLibro) {
                                System.out.println(libro);
                            }
                        }
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Scelta non valida. Riprova.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Inserisci un input valido");
                scanner.nextLine();
            }
        }
    }
}
