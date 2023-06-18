package com.example.morpionjohanne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class QuiCommenceMultijoueur {

    @FXML
    private Button boutonAléatoire;

    @FXML
    private Button boutonJoueur1;

    @FXML
    private Button boutonJoueur2;
    @FXML
    private Button boutonJouer;

    @FXML
    private Button boutonRetour;

    public static Boolean tourJoueur1=true;
    public static Boolean tourJoueur2=false;
    @FXML
    void quiCommence(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        switch (clickedButton.getText()){
            case"Aléatoire":
                boutonAléatoire.setDisable(true);
                boutonJoueur1.setDisable(false);
                boutonJoueur2.setDisable(false);
                Random rand = new Random();
                if (rand.nextInt(100) % 2 == 0) {
                    tourJoueur1 = true;
                    tourJoueur2 = false;
                } else {
                    tourJoueur1 = false;
                    tourJoueur2 = true;
                }
                break;
            case"Joueur 1":
                tourJoueur1=true;
                tourJoueur2=false;
                boutonAléatoire.setDisable(false);
                boutonJoueur1.setDisable(true);
                boutonJoueur2.setDisable(false);
                break;
            case"Joueur 2":
                tourJoueur1=false;
                tourJoueur2=true;
                boutonAléatoire.setDisable(false);
                boutonJoueur1.setDisable(false);
                boutonJoueur2.setDisable(true);
                break;
        }
    }
    public static Boolean getTourJoueur1(){
        return tourJoueur1;
    }
    public static Boolean getTourJoueur2(){
        return tourJoueur2;
    }
    @FXML
    void jouer(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuiCommenceMultijoueur.class.getResource("grilleDeJeu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }
    @FXML
    void retourEnArriere(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(QuiCommenceMultijoueur.class.getResource("creerJoueur2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

}
