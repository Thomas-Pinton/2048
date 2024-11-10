package com;

import javafx.scene.paint.Color;

public class Colors {
    Color[] colors;
    public Colors() {
        colors = new Color[12];
        colors[0] = Color.web("ffffff");
        colors[1] = Color.web("85fd8a");
        colors[2] = Color.web("77fd7d");
        colors[3] = Color.web("6be471");
        colors[4] = Color.web("5fca64");
        colors[5] = Color.web("53b158");
        colors[6] = Color.web("47984b");
        colors[7] = Color.web("3c7f3f");
        colors[8] = Color.web("306532");
        colors[9] = Color.web("244c25");
        colors[10] = Color.web("183319");
        colors[11] = Color.web("0c190c");
    }
    public Color getColor(int value) {
        int result = 0;
        while (value > 1) {
            value >>= 1;
            result++;
        }
        return colors[result];
    }
}
