package com;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Handler {

    public int[][] handle(KeyEvent event, int[][] cases) {
        if (event.getCode() == KeyCode.K) {
            moveUp(cases);
        } else if (event.getCode() == KeyCode.J) {
            moveDown(cases);
        } else if (event.getCode() == KeyCode.H) {
            moveLeft(cases);
        } else if (event.getCode() == KeyCode.L) {
            moveRight(cases);
        }
        return cases;
    }
/*
    public void spawnSquare() {
        int pos = (int) (Math.random() * 16);
        if (Math.random() > 0.1) {

        }
    }
 */
    private void moveUp(int[][] cases) {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                moveSquareUp(cases, i, j);
            }
        }
        return;
    }
    private void moveSquareUp(int[][] cases, int i, int j) {
        while (i > 0) {
            if (cases[i][j] != 0 && cases[i-1][j] == 0) {
                cases[i-1][j] = cases[i][j];
                cases[i][j] = 0;
            }
            i--;
        }
        return;
    }

    private void moveDown(int[][] cases) {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                moveSquareDown(cases, i, j);
            }
        }
        return;
    }

    private void moveSquareDown(int[][] cases, int i, int j) {
        while (i < 3) {
            if (cases[i][j] != 0 && cases[i+1][j] == 0) {
                cases[i+1][j] = cases[i][j];
                cases[i][j] = 0;
            }
            i++;
        }
        return;
    }

    private void moveLeft(int[][] cases) {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                moveSquareLeft(cases, i, j);
            }
        }
        return;
    }

    private void moveSquareLeft(int[][] cases, int i, int j) {
        while (j > 0) {
            if (cases[i][j] != 0 && cases[i][j-1] == 0) {
                cases[i][j-1] = cases[i][j];
                cases[i][j] = 0;
            }
            j--;
        }
        return;
    }

    private void moveRight(int[][] cases) {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                moveSquareRight(cases, i, j);
            }
        }
        return;
    }

    private void moveSquareRight(int[][] cases, int i, int j) {
        while (j < 3) {
            if (cases[i][j] != 0 && cases[i][j+1] == 0) {
                cases[i][j+1] = cases[i][j];
                cases[i][j] = 0;
            }
            j++;
        }
        return;
    }
    // public void merge();
}
