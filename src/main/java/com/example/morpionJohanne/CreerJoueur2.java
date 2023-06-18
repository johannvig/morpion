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

public class CreerJoueur2 {

    @FXML
    private ImageView SymbolePlayer;

    @FXML
    private ImageView SymbolePlayerCouleur;

    @FXML
    private Button boutonCouleurDroit;

    @FXML
    private Button boutonCouleurGauche;

    @FXML
    private Button boutonRetour;

    @FXML
    private Button boutonSuivant;

    @FXML
    private Button boutonSymboleDroit;

    @FXML
    private Button boutonSymboleGauche;
    @FXML
    private Label nomJoueur2;

    @FXML
    private TextField labelNomJoueur;

    public static String nom="Joueur2";
    public static String symbole;

    @FXML
    void CouleurDroit(ActionEvent event) {

    }

    @FXML
    void CouleurGauche(ActionEvent event) {

    }

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
    void valideLeNom(ActionEvent event) {
        labelNomJoueur.getText().equals("");
        nomJoueur2.setText(labelNomJoueur.getText());
        nom = labelNomJoueur.getText();
    }
    @FXML
    void passeALaSuite(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreerJoueur2.class.getResource("quiCommenceMultijoueur.fxml"));
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
        FXMLLoader fxmlLoader = new FXMLLoader(CreerJoueur2.class.getResource("creerJoueur.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }

}
