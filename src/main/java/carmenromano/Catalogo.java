package carmenromano;

import java.time.Year;
import java.util.UUID;

public class Catalogo {
    protected String codiceISBN;
    protected String titolo;
    protected Year annoPubblicazione;
    protected int numeroPagine;

    public Catalogo(String titolo, Year annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.codiceISBN = generateUUID();
        this.numeroPagine = numeroPagine;
    }

    private String generateUUID() {
        UUID randomUUID = UUID.randomUUID();
        String uuid = randomUUID.toString();
        return uuid.substring(0, 13);
    }


    public String getCodiceISBN() {
        return codiceISBN;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
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
}

