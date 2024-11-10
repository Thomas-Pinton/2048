package com.views;

import com.interfaces.Observateur;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class VueStats extends Pane implements Observateur {
    
    private Label label;

    public VueStats() {
        label = new Label("Games won / played: 2 / 5");
        this.getChildren().add(label);
    }

    public void reagir(int[][] cases, int[] games)
    {
        label.setText("Games won / played: " + games[0] + " / " + games[1]);
    }

    public Pane getPane() {
        return this;
    }

}
