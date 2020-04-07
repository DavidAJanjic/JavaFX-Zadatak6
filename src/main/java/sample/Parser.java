package sample;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<RezultatKolokvijuma> parse(List<String> fileList) {
        List<RezultatKolokvijuma> rezultati = new ArrayList<>();
        for (String line : fileList) {
            RezultatKolokvijuma rez = new RezultatKolokvijuma();
            String[] s1 = line.split(",", 2);
            rez.setIme(s1[0]);
            String[] s2 = s1[1].split(",", 2);
            rez.setPrezime(s2[0]);
            String[] s3 = s2[1].split(",", 2);
            rez.setBrIndexa(s3[0]);
            String[] s4 = s3[1].split(",", 2);
            rez.setBrBodova(s4[0]);
            String[] s5 = s4[1].split(",", 2);
            String[] s6 = s5[0].split("-",3);
            rez.setDatum(LocalDate.of(Integer.parseInt(s6[0]),Integer.parseInt(s6[1]),Integer.parseInt(s6[2])));
            rez.setNapomena(s5[1]);

            rezultati.add(rez);
        }
        return rezultati;
    }

    public static String parseOut(List<RezultatKolokvijuma> rezultati) {
        String result = "";
        for (RezultatKolokvijuma x : rezultati) {
            result += x.getIme() + "," + x.getPrezime() + "," + x.getBrIndexa() + ","
                    + x.getBrBodova() + "," + x.getDatum().toString() + "," + x.getNapomena() + "\n";
        }
        return result;
    }

}
