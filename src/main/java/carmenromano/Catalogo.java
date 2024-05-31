package carmenromano;

import java.time.Year;
import java.util.Random;
import java.util.UUID;

public abstract class Catalogo {
    protected String codiceISBN;
    protected String titolo;
    protected Year annoPubblicazione;
    protected int numeroPagine;
    private static int codiceISBNCounter = 1000;

    public Catalogo(String titolo) {
        this.titolo = titolo;
        this.annoPubblicazione = Year.of(generateRandomYear());
        this.codiceISBN = generateUUID();
        this.numeroPagine = generateRandomPag();
    }

    private String generateUUID() {
        codiceISBNCounter++;
        return "ISBN-" + codiceISBNCounter;
    }
    private int generateRandomYear() {
        Random random = new Random();
        return random.nextInt(1990, 2024);
    }

    private int generateRandomPag() {
        Random random = new Random();
        return random.nextInt(10, 200);
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(String codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public Year getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Year annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "codiceISBN='" + codiceISBN + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}

