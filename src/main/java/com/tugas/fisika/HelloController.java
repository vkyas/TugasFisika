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
        double mass, velocity, momentum;
        mass = Double.parseDouble(textInp1.getText());
        velocity = Double.parseDouble(textInp2.getText());
        momentum = mass *velocity;
        momentum(momentum);
    }

    private void momentum(double momentum) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(30, 28, 5, 10));

        Text text = new Text("P = " + momentum + " KG·M/S");
        setVbox_message(hBox, text);
    }

    private void potensial(double potensial) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(30, 28, 5, 10));

        Text text = new Text("PE = " + potensial + " J");
        setVbox_message(hBox, text);
    }

    private void setVbox_message(HBox hBox, Text text) {
        TextFlow textFlow = new TextFlow(text);
        vbox_message.setMinSize(0, 0);
        textFlow.setStyle("-fx-color: rgb(239, 242, 255);" +
                "-fx-background-color: darkgray; " +
                "-fx-background-radius: 20px");

        textFlow.setPadding(new Insets(5, 10, 5, 10));
        vbox_message.getChildren().retainAll();
        text.setFill(Color.color(0, 0, 0));

        hBox.getChildren().add(textFlow);
        vbox_message.getChildren().add(hBox);
    }

    private void potentialEnergy() {
        float input1, input2, input3, potensial;
        input1 = Float.parseFloat(textInp1.getText());
        input2 = Float.parseFloat(textInp2.getText());
        input3 = Float.parseFloat(textInp3.getText());
        potensial = input1 * input2 * input3;
        potensial(potensial);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        buttonStart.setOnAction(actionEvent -> {
            potentialEnergy();
        });

        buttonClear.setOnAction(actionEvent -> {
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
        });

        buttonKe.setOnAction(actionEvent -> {
            float m, v, kinetikEnergi;
            m = Float.parseFloat(textInp1.getText());
            v = Float.parseFloat(textInp2.getText());
            kinetikEnergi = (float) (0.5 * m * v * v);

            vbox_message.setMinSize(0, 0);

            HBox hBox = new HBox();
            hBox.setAlignment(Pos.CENTER);
            HBox hFox = new HBox();
            vbox_message.getChildren().retainAll();
            hFox.setAlignment(Pos.CENTER);
            hBox.setPadding(new Insets(30, 28, 5, 10));
            hFox.setPadding(new Insets(5, 10, 5, 10));

            Text text = new Text("KE = " + kinetikEnergi + " J");
//            Text rum = new Text("KE = 1/2 * " + m + " kg " + " * " + (v) + " m/s²");
            Text rum = new Text();
            TextFlow textFlow = new TextFlow(text);
            TextFlow textFlos = new TextFlow(rum);
            textFlow.setStyle("-fx-color: rgb(239, 242, 255);" +
                    "-fx-background-color: darkgray; " +
                    "-fx-background-radius: 15px");

            textFlos.setStyle("-fx-color: rgb(239, 242, 255);" +
                    "-fx-background-radius: 20px");
            textFlow.setPadding(new Insets(5, 10, 5, 10));
            text.setFill(Color.color(0, 0, 0));

            textFlos.setPadding(new Insets(5, 10, 5, 10));
            rum.setFill(Color.color(0, 0, 0));

            hBox.getChildren().add(textFlow);
            hFox.getChildren().add(textFlos);
            vbox_message.getChildren().add(hBox);
            vbox_message.getChildren().add(hFox);
        });

        buttonKinetic.setOnAction(actionEvent -> {
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
        });
    }


}
