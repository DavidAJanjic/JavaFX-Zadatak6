package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectIO {

    public List<RezultatKolokvijuma> readFile() {
        List<RezultatKolokvijuma> rezultati = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(AppConfig.filepath);
            ois = new ObjectInputStream(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rezultati = (ArrayList<RezultatKolokvijuma>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return rezultati;
    }

    public void writeFile(List<RezultatKolokvijuma> rezultati) {

        writeObjectToFile(rezultati);
    }

    private void writeObjectToFile(List<RezultatKolokvijuma> rezultati) {
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
