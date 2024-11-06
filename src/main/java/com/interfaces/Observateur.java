package com.interfaces;

import javafx.scene.layout.Pane;

public abstract interface Observateur {
    public abstract void reagir(int[][] cases);
    public abstract Pane getPane();
}
