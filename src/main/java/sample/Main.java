package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    CharacterFileManager cfm = new CharacterFileManager();
    List<String> lista = new ArrayList<>();

    //    List<RezultatKolokvijuma> rezultati = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Rezultati kolokvijuma");
        GridPane masterGrid = new GridPane();

        RezultatKolokvijuma.setSviRezultati(cfm.readFile());
        for (RezultatKolokvijuma x : RezultatKolokvijuma.getSviRezultati()) {
            lista.add(x.toString());
        }
        ObservableList<String> list = FXCollections.observableArrayList(lista);
        ListView lv = new ListView<>();
        lv.getItems().addAll(list);
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(lv);

        //---------------------------------------------------------------------

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(5);
        grid.setHgap(5);

        Label imeL = new Label("Ime:");
        TextField imeTf = new TextField();
        grid.add(imeL, 0, 0);
        grid.add(imeTf, 1, 0);

        Label prezimeL = new Label("Prezime:");
        TextField prezimeTf = new TextField();
        grid.add(prezimeL, 0, 1);
        grid.add(prezimeTf, 1, 1);

        Label brIndexaL = new Label("Broj indexa:");
        TextField brIndexaTf = new TextField();
        grid.add(brIndexaL, 0, 2);
        grid.add(brIndexaTf, 1, 2);

        Label brojBodovaL = new Label("Broj bodova:");
        TextField brojBodovaTf = new TextField();
        grid.add(brojBodovaL, 0, 3);
        grid.add(brojBodovaTf, 1, 3);

        Label datumL = new Label("Datum:");
        DatePicker datumDp = new DatePicker();
        grid.add(datumL, 0, 4);
        grid.add(datumDp, 1, 4);

        Label napomenaL = new Label("Napomena:");
        TextArea napomenaTa = new TextArea();
        napomenaTa.setWrapText(true);
        napomenaTa.setPrefColumnCount(15);
        napomenaTa.setPrefRowCount(5);
        grid.add(napomenaL, 0, 5);
        grid.add(napomenaTa, 1, 5);

        Button button = new Button("Sacuvaj");
        grid.add(button, 1, 6);

        masterGrid.add(layout, 0, 0);
        masterGrid.add(grid, 1, 0);


        lv.setOnMouseClicked(event -> {
            RezultatKolokvijuma rk = new RezultatKolokvijuma();
            String a = (String) lv.getSelectionModel().getSelectedItems().get(0);
            for (int i = 0; i < RezultatKolokvijuma.getSviRezultati().size(); i++) {
                if (a.equals(RezultatKolokvijuma.getSviRezultati().get(i).toString())) {
                    rk = cfm.readFile().get(i);
                }
            }
            imeTf.setText(rk.getIme());
            imeTf.setDisable(true);
            prezimeTf.setText(rk.getPrezime());
            prezimeTf.setDisable(true);
            brIndexaTf.setText(rk.getBrIndexa());
            brIndexaTf.setDisable(true);
            brojBodovaTf.setText(rk.getBrBodova());
            datumDp.setValue(rk.getDatum());
            napomenaTa.setText(rk.getNapomena());
        });

        Text porukaL = new Text();
        grid.add(porukaL, 1, 7);

        button.setOnAction(event -> {
            for (int i = 0; i < RezultatKolokvijuma.getSviRezultati().size(); i++) {
                if (lv.getSelectionModel().getSelectedItems().get(0).equals(RezultatKolokvijuma.getSviRezultati().get(i).toString())) {
                    RezultatKolokvijuma.getSviRezultati().get(i).setBrBodova(brojBodovaTf.getText());
                    RezultatKolokvijuma.getSviRezultati().get(i).setDatum(datumDp.getValue());
                    RezultatKolokvijuma.getSviRezultati().get(i).setNapomena(napomenaTa.getText());
                    cfm.writeFile(RezultatKolokvijuma.getSviRezultati());
                    ObservableList<String> items = list;
                    list.clear();
                    list.setAll(items);

                    porukaL.setFill(Color.BLUE);
                    porukaL.setText("Sacuvano!");

                }
            }
        });

        brojBodovaTf.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.S) {
                button.fire();
            }
        });
        napomenaTa.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.S) {
                button.fire();
            }
        });
        datumDp.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.S) {
                button.fire();
            }
        });

        Scene scene = new Scene(masterGrid, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
