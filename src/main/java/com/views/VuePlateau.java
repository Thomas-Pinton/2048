package com.views;

import com.Colors;
import com.interfaces.Observateur;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class VuePlateau extends GridPane implements Observateur {

    AnchorPane[] anchorPanes;
    Colors colors;
    Color color2 = Color.web("85fd8a");
    Color color4 = Color.web("77fd7d");
    Color color8 = Color.web("6be471");
    Color color16 = Color.web("5fca64");
    Color color32 = Color.web("53b158");
    Color color64 = Color.web("47984b");
    Color color128 = Color.web("3c7f3f");
    Color color256 = Color.web("306532");
    Color color512 = Color.web("244c25");
    Color color1024 = Color.web("183319");
    Color color2048 = Color.web("0c190c");

    public VuePlateau() {
        this.setHgap(5);
        this.setVgap(5);
        // Label testLabel = new Label("This is the Vue Plateau!");
        // this.getChildren().addAll(square);
        createSquares();
        colors = new Colors();
    }

    public void createSquares() {
        int side = 100;
        int border = 1;
        anchorPanes = new AnchorPane[16];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Text text = new Text("2");
                AnchorPane.setTopAnchor(text, (double) side/2 - 2);
                AnchorPane.setLeftAnchor(text, (double) side/2 - 2);

                Rectangle rect = new Rectangle();

                rect.setWidth(side); rect.setHeight(side);
                rect.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                rect.setStroke(Color.BLACK);

                AnchorPane pane = new AnchorPane();
                pane.getChildren().addAll(rect, text);

                this.add(pane, j, i, 1, 1);

                anchorPanes[4*i + j] = pane;

            }
        }
    }

    public Pane getPane() {
        return this;
    }

    public void reagir(int[][] cases) {
        // update the squares values
        System.out.println("Vue Plateau is reacting");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                AnchorPane pane = anchorPanes[4*i + j];
                for (Node node : pane.getChildren()) {
                    if (node instanceof Text txt) {
                        txt.setText(String.valueOf(cases[i][j]));
                    }
                    if (node instanceof Rectangle rect) {
                        rect.setFill(colors.getColor(cases[i][j]));
                    }
                }
            }
        }
    }

}
