package sample;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RezultatKolokvijuma {
    private String ime;
    private String prezime;
    private String brIndexa;
    private String brBodova;
    private LocalDate datum;
    private String napomena;
    private static List<RezultatKolokvijuma> sviRezultati = new ArrayList<>();

    public RezultatKolokvijuma() {
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrIndexa() {
        return brIndexa;
    }

    public void setBrIndexa(String brIndexa) {
        this.brIndexa = brIndexa;
    }

    public String getBrBodova() {
        return brBodova;
    }

    public void setBrBodova(String brBodova) {
        this.brBodova = brBodova;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public static List<RezultatKolokvijuma> getSviRezultati() {
        return sviRezultati;
    }

    public static void setSviRezultati(List<RezultatKolokvijuma> sviRezultati) {
        RezultatKolokvijuma.sviRezultati = sviRezultati;
    }

    @Override
    public String toString() {
        return ime +" " + prezime + ": " + brBodova;
    }
}
