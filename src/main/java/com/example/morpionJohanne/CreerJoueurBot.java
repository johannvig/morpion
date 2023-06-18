package com.example.morpionjohanne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class CreerJoueurBot {

    @FXML
    private ImageView SymbolePlayer;


    @FXML
    private Button boutonRetour;

    @FXML
    private Button boutonSuivant;

    @FXML
    private TextField labelNomJoueur;

    @FXML
    private Label nomJoueur;

    @FXML
    private Button boutonChoixNiveauFacile;

    @FXML
    private Button boutonChoixNiveauExpert;
    public static String nom="Joueur 1";
    public static String symbole;
    public static String niveauBot = "facile";

    String[] listeNomSymbole = {"Croix.png","pomme.png","perroquet.png","tempete-tropicale.png","fantome-de-pacman.png"};
    int indexSymbole=0;

    @FXML
    void SymboleDroit(ActionEvent event) {
        if(indexSymbole>=listeNomSymbole.length-1)
            indexSymbole=0;
        else{
            indexSymbole++;
        }
        symbole=listeNomSymbole[indexSymbole];
        SymbolePlayer.setImage(new Image(listeNomSymbole[indexSymbole]));
        SymbolePlayer.setFitHeight(55);
        SymbolePlayer.setFitWidth(55);
    }

    @FXML
    void SymboleGauche(ActionEvent event){
        if(indexSymbole ==0) {
            indexSymbole =listeNomSymbole.length-1;
        }else{
            indexSymbole--;
        }
        symbole=listeNomSymbole[indexSymbole];
        SymbolePlayer.setImage(new Image(listeNomSymbole[indexSymbole]));
        SymbolePlayer.setFitHeight(55);
        SymbolePlayer.setFitWidth(55);
    }
    @FXML
    void choisiLeNiveauDuBotFacile(ActionEvent event) {
        niveauBot="facile";
        boutonChoixNiveauFacile.setDisable(true);
        boutonChoixNiveauExpert.setDisable(false);
    }
    @FXML
    void choisiLeNiveauDuBotExpert(ActionEvent event) {
        niveauBot="Expert";
        boutonChoixNiveauFacile.setDisable(false);
        boutonChoixNiveauExpert.setDisable(true);
    }
    public static String getNiveauBot(){
        return niveauBot;
    }
    @FXML
    void valideLeNom(ActionEvent event) {
        nomJoueur.setText(labelNomJoueur.getText());
        nom = labelNomJoueur.getText();
    }

    @FXML
    void passeALaSuite(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreerJoueur.class.getResource("grilleDeJeu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }
    public static String getNom(){
        return nom;
    }
    public static String getSymbole(){
        return symbole;
    }
    @FXML
    void retourEnArriere(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreerJoueur.class.getResource("menuPrincipal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);

    }

}
