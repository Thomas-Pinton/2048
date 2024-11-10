package com.views;

import com.interfaces.Observateur;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class VueMenu extends GridPane implements Observateur {
    
    private Label label;

    public VueMenu() {
        this.setHgap(10);
        this.setVgap(10);
        label = new Label("Games won / played: 2 / 5");

        this.add(label, 0, 0);
    }

    public void reagir(int[][] cases, int[] games)
    {
        label.setText("Games won / played: " + games[0] + " / " + games[1]);
    }

    public Pane getPane() {
        return this;
    }

}
