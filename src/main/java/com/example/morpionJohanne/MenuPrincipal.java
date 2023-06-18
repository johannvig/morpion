package com.example.morpionjohanne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuPrincipal {

    @FXML
    private Button boutonMultiplayer;

    @FXML
    private Button boutonSoloPlayer;

    @FXML
    private Button boutonVoirLesRègles;

    private static String modeDeJeu;
    public static String getModeDeJeu(){
        return modeDeJeu;
    }
    @FXML
    void EntrerDansMultiplayerMode(ActionEvent event) throws IOException {
        modeDeJeu="Multiplayer";
        FXMLLoader fxmlLoader = new FXMLLoader(MenuPrincipal.class.getResource("creerJoueur.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void EntrerDansSoloMode(ActionEvent event) throws IOException {
        modeDeJeu="solo";
        FXMLLoader fxmlLoader = new FXMLLoader(MenuPrincipal.class.getResource("creerJoueurRobot.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

    @FXML
    void voirLesRègles(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuPrincipal.class.getResource("regle.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());

        stage.initModality(Modality.WINDOW_MODAL);
        stage.setTitle("Règle");
        stage.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
        stage.setScene(scene);
        stage.showAndWait();
    }

}
