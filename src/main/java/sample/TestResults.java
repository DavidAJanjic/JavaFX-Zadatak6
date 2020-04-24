package sample;

import java.io.Serializable;
import java.time.LocalDate;

public class TestResults implements Serializable {

    private static final long serialVersionUID = -7693695196859447629L;

    private String ime;
    private String prezime;
    private String brIndexa;
    private String brBodova;
    private LocalDate datum;
    private String napomena;

    public TestResults() {
    }

    public TestResults(String ime, String prezime, String brIndexa, String brBodova, LocalDate datum, String napomena) {
        this.ime = ime;
        this.prezime = prezime;
        this.brIndexa = brIndexa;
        this.brBodova = brBodova;
        this.datum = datum;
        this.napomena = napomena;
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


    @Override
    public String toString() {
        return ime + " " + prezime + ": " + brBodova;
    }
}
