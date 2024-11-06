package com.views;

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

    public VuePlateau() {
        this.setHgap(5);
        this.setVgap(5);
        // Label testLabel = new Label("This is the Vue Plateau!");
        // this.getChildren().addAll(square);
        createSquares();
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

                if (i == 1 || i == 3)
                {
                    rect.setFill(Color.GREEN);
                }
                else
                {
                    rect.setFill(Color.RED);
                    rect.setStroke(Color.BLACK);
                }

                AnchorPane pane = new AnchorPane();
                pane.getChildren().addAll(rect, text);

                this.add(pane, i, j, 1, 1);

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
                }
            }
        }
    }

}
