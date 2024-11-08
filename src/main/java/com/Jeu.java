package com;

import com.interfaces.Observateur;
import com.views.VuePlateau;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.input.KeyEvent;
import java.lang.Math;
// import eu.Observateur;
// import eu.VueMenu;

public class Jeu extends Application {

    int[][] cases;
    int objectif;
    Observateur observateur;
    Handler handler;

    @Override
    public void start(Stage primaryStage) {

        createInitialBlocks();

        VuePlateau vuePlateau = new VuePlateau();
        ajouterObservateur(vuePlateau);

        handler = new Handler();

        System.out.println("Start");

        observateur.reagir(cases);

        GridPane root = new GridPane(); // this is the main grid pane

        root.add((Pane) observateur, 0, 1);

        Scene scene = new Scene(root, 800, 500);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (event) -> {
            cases = handler.handle(event, cases);
        });

        // Set up the game loop using AnimationTimer
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                /*
                scene.addEventHandler(KeyEvent.KEY_PRESSED, (event) -> {
                    cases = handler.handle(event, cases);
                });
                 */
                observateur.reagir(cases);
            }
        };
        gameLoop.start();
        primaryStage.show();
    }

    public void createInitialBlocks()
    {
        cases = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                cases[i][j] = 0;
            }
        }

        int position1 = (int) (Math.random() * 16);
        int position2 = (int) (Math.random() * 16);
        while (position2 == position1) {
            position2 = (int) (Math.random() * 16);
        }
        cases[position1 % 4][position1 / 4] = 2;
        cases[position2 % 4][position2 / 4] = 2;
        System.out.println("Number: " + position1 + ", " + position2);
        return;
    }

    public void ajouterObservateur(Observateur obs) {
        observateur = obs;
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        launch(args);
    }
}

