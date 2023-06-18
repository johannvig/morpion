package com.example.morpionjohanne;

public class Joueur {
    private String nom;
    private Boolean tour;
    private String symbole;
    private int score;
    private boolean bot;
    public Joueur(String nom, Boolean tour, String symbole) {
        this.nom = nom;
        this.tour = tour;
        this.symbole = symbole;
        bot=false;
        score =0;
    }

    public Joueur(String nom, Boolean tour, String symbole,Boolean bot) {
        this(nom,tour,symbole);
        this.bot=bot;
        score =0;
    }
    public String getNom() {
        return nom;
    }
    public boolean getBot(){
        return bot;
    }
    public void setBot(Boolean bot){
        this.bot=bot;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getScore() {
        return score;
    }
    public Boolean getTour() {
        return tour;
    }
    public void aGagner(){
        score++;
    }

    public void setTour(Boolean tour) {
        this.tour = tour;
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }
}

