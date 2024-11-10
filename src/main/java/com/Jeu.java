package com;

import com.interfaces.Observateur;
import com.views.VueStats;
import com.views.VuePlateau;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javafx.scene.input.KeyEvent;
import java.lang.Math;
// import eu.VueMenu;

public class Jeu extends Application {

    int[][] cases;
    int[] games; // played and won
    Observateur[] observateurs;
    Handler handler;
    public enum State {
        ONGOING, WON, LOST
    }
    private State state;

    @Override
    public void start(Stage primaryStage) {

        createInitialBlocks();
        games = new int[]{0, 0};

        observateurs = new Observateur[3];
        for (int i = 0; i < 3; i++) {
            observateurs[i] = null;
        }

        VuePlateau vuePlateau = new VuePlateau();
        ajouterObservateur(vuePlateau);

        VueStats vueStats = new VueStats();
        ajouterObservateur(vueStats);

        handler = new Handler();

        System.out.println("Start");

        GridPane root = new GridPane(); // this is the main grid pane

        int i = 0;
        for (Observateur o : observateurs)
        {
            if (o != null)
            {
                root.add((Pane) o, 0, i);
                i++;
            }
        }

        Scene scene = new Scene(root, 700, 600);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.addEventHandler(KeyEvent.KEY_PRESSED, (event) -> {
            cases = handler.handle(event, cases);
            updateState();
            if (state != State.ONGOING)
            {
                reset();
            }
        });

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (Observateur o : observateurs)
                {
                    if (o != null)
                        o.reagir(cases, games);
                }
            }
        };
        gameLoop.start();
        primaryStage.show();
    }

    private void updateState() {
        boolean foundSpace = false;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cases[i][j] == 0)
                {
                    foundSpace = true;
                }
                else if (cases[i][j] == 2048)
                {
                    state = State.WON;
                    return;
                }
            }
        }
        if (foundSpace)
        {
            state = State.ONGOING;
            return;
        }
        state = State.LOST;
        return;
    }

    private void reset()
    {
        createInitialBlocks();
        if (state == State.WON)
            games[0]++;
        games[1]++;
        state = State.ONGOING;
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
        int i = 0;
        while (i < 3 && observateurs[i] != null)
        {
            i++;
        }
        System.out.println(i);
        observateurs[i] = obs;
    }

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        launch(args);
    }
}

