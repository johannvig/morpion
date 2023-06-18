package com.example.morpionjohanne;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.morpionjohanne.CreerJoueurBot.niveauBot;
import static java.lang.Math.abs;

public class GrilleDeJeu {

    @FXML
    private Button bouton1;

    @FXML
    private Button bouton2;

    @FXML
    private Button bouton3;

    @FXML
    private Button bouton4;

    @FXML
    private Button bouton5;

    @FXML
    private Button bouton6;

    @FXML
    private Button bouton7;

    @FXML
    private Button bouton8;

    @FXML
    private Button bouton9;

    @FXML
    private Label labelScoreJoueur1;

    @FXML
    private Label labelScoreJoueur2;
    @FXML
    private Label labelTour;

    @FXML
    private ImageView symboleJoueur1;

    @FXML
    private ImageView symboleJoueur2;
    @FXML
    private Button boutonRelancerLaPartie;

    @FXML
    private Label nomJoueur1;

    @FXML
    private Label nomJoueur2;

    Joueur joueur1 = verifieBot1();
    Joueur joueur2 = verifieBot2();
    public Joueur verifieBot1(){
        if(MenuPrincipal.getModeDeJeu().equals("Multiplayer")){
            return new Joueur(CreerJoueur.getNom(),QuiCommenceMultijoueur.getTourJoueur1(),CreerJoueur.getSymbole());
        }
        else{
            return new Joueur(CreerJoueurBot.getNom(),true,CreerJoueurBot.getSymbole());
        }
    }
    public Joueur verifieBot2(){
        if(MenuPrincipal.getModeDeJeu().equals("Multiplayer")){
            return new Joueur(CreerJoueur2.getNom(),QuiCommenceMultijoueur.getTourJoueur2(),CreerJoueur2.getSymbole());
        }
        else{
            return new Joueur("Terminator",false,"Rond.png",true);
        }
    }
    int scoreJoueur1 = 0;
    int scoreJoueur2 = 0;




    int x;
    @FXML
    void onClick(ActionEvent event) {
        nomJoueur1.setText(joueur1.getNom());
        symboleJoueur1.setImage(new Image(joueur1.getSymbole()));
        symboleJoueur1.setFitHeight(55);
        symboleJoueur1.setFitWidth(55);
        nomJoueur2.setText(joueur2.getNom());
        symboleJoueur2.setImage(new Image(joueur2.getSymbole()));
        symboleJoueur2.setFitHeight(55);
        symboleJoueur2.setFitWidth(55);
        Button clickedButton = (Button) event.getSource();
        if (clickedButton.getText().equals("")) {
            if (joueur1.getTour()) {
                addXOnButton(clickedButton);
                if(verifieEtatGrille()){
                    giveButtonWin();
                }
                System.out.println(joueur2.getBot()+" "+!verifieEtatGrille());
                if(joueur2.getBot()&&!verifieEtatGrille()){
                    if ("Expert".equals(niveauBot)) {
                        auTourDuBotExpert();
                    } else {
                        auTourDuBotFacile();
                    }

                    if(verifieEtatGrille()){
                            giveButtonWin();
                    }
                }
                labelTour.setText("A toi de jouer "+(joueur1.getTour()?joueur1.getNom():joueur2.getNom())+" !");
            }else{
                addOOnButton(clickedButton);
                if(verifieEtatGrille()){
                    giveButtonWin();
                }
                labelTour.setText("A toi de jouer "+(joueur1.getTour()?joueur1.getNom():joueur2.getNom())+" !");
            }
        }
        if(x>=9&&!verifieEtatGrille()){
            partyNull();
        }
        if(verifieEtatGrille()){
            labelTour.setText((!joueur1.getTour()?joueur1.getNom(): joueur2.getNom())+" a gagner la partie");
        }
    }



    public void auTourDuBotExpert(){
        if(joueur2.getTour()&&joueur2.getBot()){
            Button[] listNameButton = {bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9};
            List<Button> listNameButtonVide = new ArrayList<Button>();
            for (int i = 0; i < 9; i++) {
                if(listNameButton[i].getText()==""){
                    listNameButtonVide.add(listNameButton[i]);
                }
            }

            // Chercher une possibilité de victoire pour le bot
            for(Button button : listNameButtonVide) {
                button.setText("O");
                if(verifieEtatGrille()) {
                    addOOnButton(button);
                    return;
                }
                button.setText("");
            }

            // Bloquer le mouvement gagnant du joueur humain
            for(Button button : listNameButtonVide) {
                button.setText("X");
                if(verifieEtatGrille()) {
                    addOOnButton(button);
                    return;
                }
                button.setText("");
            }

            // Si aucune des deux conditions précédentes n'est remplie, choisir un mouvement aléatoire
            try {

                Random rand= new Random();
                addOOnButton(listNameButtonVide.get(rand.nextInt(listNameButtonVide.size())));

            } catch (IllegalArgumentException e){
                // Log or handle the error here
                System.err.println("");

            }
        }
    }



    public void auTourDuBotFacile(){
        if(joueur2.getTour()&&joueur2.getBot()){
            Button[] listNameButton = {bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9};
            List<Button> listNameButtonVide = new ArrayList<Button>();
            for (int i = 0; i < 9; i++) {
                if(listNameButton[i].getText()==""){
                    listNameButtonVide.add(listNameButton[i]);
                }
            }

            Random random = new Random();
            addOOnButton(listNameButtonVide.get(random.nextInt(listNameButtonVide.size())));
        }

    }
    public void tour(){
        joueur1.setTour(joueur2.getTour());
        joueur2.setTour(!joueur1.getTour());
    }
    private boolean giveButtonWin() {
        int[][] winConditions = new int[][] {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // lignes
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // colonnes
                {0, 4, 8}, {2, 4, 6}              // diagonales
        };
        Button[] listNameButton = {bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9};
        for (int i=0;i<winConditions.length;i++) {
            if (listNameButton[winConditions[i][0]].getText().equals(listNameButton[winConditions[i][1]].getText()) && listNameButton[winConditions[i][0]].getText().equals(listNameButton[winConditions[i][2]].getText()) && !listNameButton[winConditions[i][2]].getText().equals("")) {
                endOfMatch(listNameButton[winConditions[i][0]].getText(), listNameButton[winConditions[i][0]], listNameButton[winConditions[i][1]], listNameButton[winConditions[i][2]]);
            }
        }
        return false;
    }
    public void partyNull(){
        Button[] listNameButton = {bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9};
        for (int i = 0; i < 9; i++) {
            if(listNameButton[i].getText()!=""){
                listNameButton[i].setDisable(true);
            }
        }
        labelTour.setText("Match null !");
    }
    public void addXOnButton(Button button){
        tour();
        System.out.println("X");
        button.setText("X");
        ImageView croix = new ImageView(new Image(joueur1.getSymbole()));
        croix.setFitHeight(55);
        croix.setFitWidth(55);
        button.setGraphic(croix);
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        x++;
    }
    public void addOOnButton(Button button){
        tour();
        System.out.println("O");
        ImageView circle = new ImageView(new Image(joueur2.getSymbole()));
        circle.setFitHeight(55);
        circle.setFitWidth(55);
        button.setGraphic(circle);
        button.setText("O");
        button.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        x++;
    }
    private boolean verifieEtatGrille() {
        int[][] winConditions = new int[][] {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // lignes
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // colonnes
                {0, 4, 8}, {2, 4, 6}              // diagonales
        };
        Button[] listNameButton = {bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9};
        for (int i=0;i<winConditions.length;i++) {
            if (listNameButton[winConditions[i][0]].getText().equals(listNameButton[winConditions[i][1]].getText()) && listNameButton[winConditions[i][0]].getText().equals(listNameButton[winConditions[i][2]].getText()) && !listNameButton[winConditions[i][2]].getText().equals("")) {
                return true;
            }
        }
        return false;
    }
    public void endOfMatch(String whoIsWin, Button bouton_1, Button bouton_2, Button bouton_3){
        Button[] listNameButton = {bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9};
        bouton_1.setStyle("-fx-background-color: transparent;" +
                "    -fx-effect: dropshadow(three-pass-box, rgba(57,255,20,0.8), 30, 0.5, 0, 0);");
        bouton_2.setStyle("-fx-background-color: transparent;" +
                "    -fx-effect: dropshadow(three-pass-box, rgba(57,255,20,0.8), 30, 0.5, 0, 0);");
        bouton_3.setStyle("-fx-background-color: transparent;" +
                "    -fx-effect: dropshadow(three-pass-box, rgba(57,255,20,0.8), 30, 0.5, 0, 0);");
        switch (whoIsWin) {
            case "X", "O":
                for (int i = 0; i < 9; i++) {
                    if(listNameButton[i].getText()==""){
                        listNameButton[i].setDisable(true);
                    }
                }
                if(whoIsWin.equals("X")){
                    joueur1.aGagner();
                    labelScoreJoueur1.setText(""+joueur1.getScore());
                    System.out.println("Bravo à "+joueur2.getNom()+" pour avoir gagner la partie");
                    labelTour.setText("Bravo à "+joueur1.getNom()+" pour avoir gagner la partie");
                }
                else{
                    joueur2.aGagner();
                    labelScoreJoueur2.setText(""+joueur2.getScore());
                    System.out.println("Bravo à "+joueur2.getNom()+" pour avoir gagner la partie");
                    labelTour.setText("Bravo à "+joueur2.getNom()+" pour avoir gagner la partie");
                }
                break;
            default:
                break;
        }

    }
    @FXML
    void RelanceLaGrille(){
        x=0;
        for (int i = 0; i < 9; i++) {
            Button[] listNameButton = {bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9};
            listNameButton[i].setText("");
            listNameButton[i].setStyle("-fx-background-color: transparent;");
            listNameButton[i].setGraphic(null);
            //listNameButton[i].setStyle("-fx-border-color: black");
            listNameButton[i].setDisable(false);
        }
        auTourDuBotFacile();
    }



    @FXML
    void retourMenuPrincipale(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GrilleDeJeu.class.getResource("menuPrincipal.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Single player");
        stage.setScene(scene);
    }
}
