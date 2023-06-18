package com.example.morpionjohanne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class Regle {

    @FXML
    private Button boutonRetour;

    @FXML
    void retourEnArriere(ActionEvent event) throws IOException {
        Stage stage = (Stage) boutonRetour.getScene().getWindow();
        stage.close();
    }

}
