package com.views;

import com.interfaces.Observateur;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class VueMenu implements Observateur {
    
    private GridPane grid;

    public void create() {
        grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
    }

    public void reagir(int[][] cases) {
        System.out.println("Vue Menu is reacting");
    }

    public Pane getPane() {
        return grid;
    }

}
