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

public class CreerJoueur {

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
    private TextField labelNomJoueur;

    @FXML
    private Label nomJoueur;
    public static String nom="Joueur 1";
    public static String symbole="Croix.png";

    String[] listeNomSymbole = {"Croix.png","pomme.png","perroquet.png","tempete-tropicale.png","fantome-de-pacman.png"};
    int indexSymbole=0;

    public static String getSymbole(){
        System.out.println(symbole);
        return symbole;
    }
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
        nomJoueur.setText(labelNomJoueur.getText());
        nom = labelNomJoueur.getText();
    }

    @FXML
    void CouleurDroit(ActionEvent event) {
    }

    @FXML
    void CouleurGauche(ActionEvent event) {
    }
    @FXML
    void passeALaSuite(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CreerJoueur.class.getResource("creerJoueur2.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }


    public static String getNom(){
        return nom;
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
