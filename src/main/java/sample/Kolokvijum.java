package sample;

import java.util.ArrayList;
import java.util.List;

public class Kolokvijum {
    private String nazivPredmeta;

    public Kolokvijum() {
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    private  List<RezultatKolokvijuma> sviRezultati = new ArrayList<>();

    public List<RezultatKolokvijuma> getSviRezultati() {
        return sviRezultati;
    }

    public void setSviRezultati(List<RezultatKolokvijuma> sviRezultati) {
        this.sviRezultati = sviRezultati;
    }
}
