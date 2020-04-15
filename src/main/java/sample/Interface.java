package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

public class Interface {

    public static void generateGUI(Stage stage, List<TestResults> results) {
        stage.setTitle("Test results");
        GridPane masterGrid = new GridPane();
        ObjectIO oio = new ObjectIO();

        if (results == null) {
            results = oio.firstInit();
        }

        ObservableList<TestResults> list = FXCollections.observableArrayList(results);
        ListView<TestResults> lv = new ListView<>();
        lv.getItems().addAll(list);
        lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        VBox listVievVBox = new VBox(10);
        listVievVBox.setPadding(new Insets(20, 20, 20, 20));
        listVievVBox.getChildren().addAll(lv);

        //---------------------------------------------------------------------

        GridPane displayGrid = new GridPane();
        displayGrid.setPadding(new Insets(20, 20, 20, 20));
        displayGrid.setVgap(5);
        displayGrid.setHgap(5);

        Label nameL = new Label("Name:");
        TextField nameTxtField = new TextField();
        displayGrid.add(nameL, 0, 0);
        displayGrid.add(nameTxtField, 1, 0);

        Label surnameL = new Label("Surname:");
        TextField surnameTxtField = new TextField();
        displayGrid.add(surnameL, 0, 1);
        displayGrid.add(surnameTxtField, 1, 1);

        Label indexNrL = new Label("Index number:");
        TextField indexNrTxtField = new TextField();
        displayGrid.add(indexNrL, 0, 2);
        displayGrid.add(indexNrTxtField, 1, 2);

        Label pointsL = new Label("Points:");
        TextField pointsTxtField = new TextField();
        displayGrid.add(pointsL, 0, 3);
        displayGrid.add(pointsTxtField, 1, 3);

        Label dateL = new Label("Date:");
        DatePicker datePicker = new DatePicker();
        displayGrid.add(dateL, 0, 4);
        displayGrid.add(datePicker, 1, 4);

        Label commentL = new Label("Comment:");
        TextArea commentTxtField = new TextArea();
        commentTxtField.setWrapText(true);
        commentTxtField.setPrefColumnCount(15);
        commentTxtField.setPrefRowCount(5);
        displayGrid.add(commentL, 0, 5);
        displayGrid.add(commentTxtField, 1, 5);

        Button saveBtn = new Button("Save");
        displayGrid.add(saveBtn, 1, 6);

        masterGrid.add(listVievVBox, 0, 0);
        masterGrid.add(displayGrid, 1, 0);


        lv.setOnMouseClicked(event -> {
            TestResults selectedItem = lv.getSelectionModel().getSelectedItems().get(0);
            nameTxtField.setText(selectedItem.getIme());
            nameTxtField.setDisable(true);
            surnameTxtField.setText(selectedItem.getPrezime());
            surnameTxtField.setDisable(true);
            indexNrTxtField.setText(selectedItem.getBrIndexa());
            indexNrTxtField.setDisable(true);
            pointsTxtField.setText(selectedItem.getBrBodova());
            datePicker.setValue(selectedItem.getDatum());
            commentTxtField.setText(selectedItem.getNapomena());
        });

        Text messageL = new Text();
        displayGrid.add(messageL, 1, 7);

        List<TestResults> finalResults = results;
        saveBtn.setOnAction(event -> {

            TestResults selectedItem = lv.getSelectionModel().getSelectedItem();
            selectedItem.setBrBodova(pointsTxtField.getText());
            selectedItem.setDatum(datePicker.getValue());
            selectedItem.setNapomena(commentTxtField.getText());
            oio.writeFile(finalResults);
            lv.refresh();
            messageL.setFill(Color.BLUE);
            messageL.setText("Saved!");
        });

        pointsTxtField.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.S) {
                saveBtn.fire();
            }
        });
        commentTxtField.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.S) {
                saveBtn.fire();
            }
        });
        datePicker.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.S) {
                saveBtn.fire();
            }
        });

        Scene scene = new Scene(masterGrid, 700, 500);
        stage.setScene(scene);
        stage.show();
    }

}
