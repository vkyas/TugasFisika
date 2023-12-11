package com.tugas.fisika;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button buttonClear, buttonKe, buttonKinetic, buttonStart, style;
    @FXML
    private TextField textInp1, textInp2, textInp3;
    @FXML
    private VBox vbox_message;

    @FXML
    private void setMomentum() {
        double mass = Double.parseDouble(textInp1.getText());
        double velocity = Double.parseDouble(textInp2.getText());
        double momentum = mass * velocity;
        displayResult("P = " + momentum + " KG·M/S");
    }

    private void momentum(double momentum) {
        HBox hBox = createHBox();
        Text text = new Text("P = " + momentum + " KG·M/S");
        setVbox_message(hBox, text);
    }

    private void potensial(double potensial) {
        HBox hBox = createHBox();
        Text text = new Text("PE = " + potensial + " J");
        setVbox_message(hBox, text);
    }

    private HBox createHBox() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(30, 28, 5, 10));
        return hBox;
    }

    private void setVbox_message(HBox hBox, Text text) {
        TextFlow textFlow = new TextFlow(text);
        vbox_message.setMinSize(0, 0);
        textFlow.setStyle("-fx-color: rgb(239, 242, 255);" +
                "-fx-background-color: darkgray; " +
                "-fx-background-radius: 20px");

        textFlow.setPadding(new Insets(5, 10, 5, 10));
        vbox_message.getChildren().retainAll();
        text.setFill(Color.BLACK);

        hBox.getChildren().add(textFlow);
        vbox_message.getChildren().add(hBox);
    }

    private void potentialEnergy() {
        try {
            double input1 = Double.parseDouble(textInp1.getText());
            double input2 = Double.parseDouble(textInp2.getText());
            double input3 = Double.parseDouble(textInp3.getText());
            double potensial = input1 * input2 * input3;
            potensial(potensial);
        } catch (NumberFormatException e) {
            displayError("Invalid input. Please enter valid numbers.");
        }
    }

    private void displayResult(String result) {
        HBox hBox = createHBox();
        Text text = new Text(result);
        setVbox_message(hBox, text);
    }

    private void displayError(String errorMessage) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(errorMessage);
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonStart.setOnAction(actionEvent -> potentialEnergy());

        buttonClear.setOnAction(actionEvent -> clearFields());

        buttonKe.setOnAction(actionEvent -> {
            try {
                double m = Double.parseDouble(textInp1.getText());
                double v = Double.parseDouble(textInp2.getText());
                double kinetikEnergi = 0.5 * m * v * v;
                displayKinetikEnergi(kinetikEnergi);
            } catch (NumberFormatException e) {
                displayError("Invalid input. Please enter valid numbers.");
            }
        });

        buttonKinetic.setOnAction(actionEvent -> setupKineticEnergyCalculation());
    }

    private void displayKinetikEnergi(double kinetikEnergi) {
        vbox_message.setMinSize(0, 0);

        HBox hBox = createHBox();
        HBox hFox = createHBox();

        Text text = new Text("KE = " + kinetikEnergi + " J");
        Text rum = new Text();

        TextFlow textFlow = createTextFlow(text);
        TextFlow textFlos = createTextFlow(rum);

        hBox.getChildren().add(textFlow);
        hFox.getChildren().add(textFlos);

        vbox_message.getChildren().addAll(hBox, hFox);
    }

    private TextFlow createTextFlow(Text text) {
        TextFlow textFlow = new TextFlow(text);
        textFlow.setStyle("-fx-color: rgb(239, 242, 255);" +
                "-fx-background-color: darkgray; " +
                "-fx-background-radius: 15px");

        textFlow.setPadding(new Insets(5, 10, 5, 10));
        text.setFill(Color.BLACK);
        return textFlow;
    }

    private void clearFields() {
        buttonKe.setVisible(false);
        buttonStart.setLayoutY(256);
        buttonStart.setVisible(true);
        style.setVisible(false);
        textInp1.setPrefWidth(250);
        textInp1.clear();
        textInp2.setPromptText("Gravity");
        textInp2.clear();
        textInp3.setVisible(true);
        textInp3.clear();
        vbox_message.getChildren().clear();
    }

    private void setupKineticEnergyCalculation() {
        buttonKe.setVisible(true);
        buttonKe.setLayoutY(219);
        buttonKe.setPrefWidth(185);
        buttonStart.setVisible(false);
        textInp1.clear();
        textInp1.setPrefWidth(185);
        textInp2.clear();
        textInp2.setPromptText("Velocity");
        textInp3.setVisible(false);
        style.setVisible(true);
        vbox_message.getChildren().clear();
    }
}
