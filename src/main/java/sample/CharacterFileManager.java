package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterFileManager {

    public List<RezultatKolokvijuma> readFile() {
        List<String> fileList = new ArrayList<>();
        InputStream in = null;
        try {
            in = new FileInputStream(AppConfig.filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String line;
        while (true) {
            try {
                if ((line = br.readLine()) == null) break;
                fileList.add(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<RezultatKolokvijuma> rezultati;
        rezultati = Parser.parse(fileList);
        return rezultati;
    }



    public void writeFile(List<RezultatKolokvijuma> rezultati) {

        BufferedWriter bw = null;
        try {
            String data = Parser.parseOut(rezultati);
            FileWriter fw = new FileWriter(AppConfig.filepath);
            bw = new BufferedWriter(fw);
            bw.write(data);

        } catch (IOException e) {
            System.out.println("File not found");
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}