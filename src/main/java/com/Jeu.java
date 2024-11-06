package com;

import com.interfaces.Observateur;
import com.views.VuePlateau;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.lang.Math;
// import eu.Observateur;
// import eu.VueMenu;

public class Jeu extends Application {

    int[][] cases;
    int objectif;
    Observateur observateur;

    @Override
    public void start(Stage primaryStage) {
        
        VuePlateau vuePlateau = new VuePlateau();
        ajouterObservateur(vuePlateau);

        cases = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cases[i][j] = 0;
            }
        }

        observateur.reagir(cases);

        GridPane root = new GridPane(); // this is the main grid pane

        root.add((Pane) observateur, 0, 1);

        Scene scene = new Scene(root, 800, 500);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void createInitialBlocks() {
        int position1 = (int) (Math.random() * 16);
        int position2 = (int) (Math.random() * 16);
        while (position2 == position1) {
            position2 = (int) (Math.random() * 16);
        }
        //cases[position1 % 4][position1 / 4] = 2;
        //cases[position2 % 4][position2 / 4] = 2;
        System.out.println("Number: " + position1 + ", " + position2);

        return;
    }

    public void ajouterObservateur(Observateur obs) {
        observateur = obs;
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.createInitialBlocks();
        launch(args);
    }
}
