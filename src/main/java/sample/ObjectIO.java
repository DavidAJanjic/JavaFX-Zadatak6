package sample;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ObjectIO {

    public List<TestResults> firstInit() {
        List<TestResults> rez = new ArrayList<>();
        TestResults rk = new TestResults("David", "Janjic", "464/16", "20",
                LocalDate.of(2020, 03, 07), "dodatni poeni na prezentaciju");
        TestResults rk1 = new TestResults("Natalija", "Pantelic", "251/16", "18",
                LocalDate.of(2020, 03, 24), "poeni sa vezbi");
        TestResults rk2 = new TestResults("Nikola", "Curcic", "151/16", "16",
                LocalDate.of(2020, 03, 24), "Nije radio test");
        TestResults rk3 = new TestResults("Gorcin", "Rancic", "53/16", "19.5",
                LocalDate.of(2020, 03, 07), "skoro max bodova");
        rez.add(rk);
        rez.add(rk1);
        rez.add(rk2);
        rez.add(rk3);

        return rez;
    }

    public List<TestResults> readFile() {
        List<TestResults> rezultati = new ArrayList<>();

        File file = new File(AppConfig.filepath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            rezultati = firstInit();
        } else {
//        file.exists();   AKO NE POSTOJI NAPRAVI NOVI FILE I VRATI firstInit()
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {
                fis = new FileInputStream(AppConfig.filepath);
                ois = new ObjectInputStream(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ois == null) {
                    rezultati = firstInit();
                } else {
                    rezultati = (ArrayList<TestResults>) ois.readObject();
                }
                // if rezultati = null or empty, vrati firstInit()
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null) {
                        fis.close();
                    }
                    if (ois != null) {
                        ois.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return rezultati;
    }

    public void writeFile(List<TestResults> rezultati) {

        writeObjectToFile(rezultati);
    }

    private void writeObjectToFile(List<TestResults> rezultati) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(AppConfig.filepath);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(rezultati);
            System.out.println("Object succesfully written to a file.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
