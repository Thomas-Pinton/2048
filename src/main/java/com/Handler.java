package com;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Handler {

    int [][] cases;

    public int[][] handle(KeyEvent event, int[][] c) {

        cases = c;

        if (event.getCode() == KeyCode.K) {
            moveUp();
        } else if (event.getCode() == KeyCode.J) {
            moveDown();
        } else if (event.getCode() == KeyCode.H) {
            moveLeft();
        } else if (event.getCode() == KeyCode.L) {
            moveRight();
        } else {
            return cases;
        }
        generateRandomBlock();
        return cases;
    }
/*
    public void spawnSquare() {
        int pos = (int) (Math.random() * 16);
        if (Math.random() > 0.1) {

        }
    }
 */
    private void moveUp() {
        for (int i = 1; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                moveSquareUp(i, j);
            }
        }
        return;
    }
    private void moveSquareUp(int i, int j) {
        while (i > 0) {
            if (cases[i][j] != 0 && cases[i-1][j] == 0) {
                cases[i - 1][j] = cases[i][j];
                cases[i][j] = 0;
            } else if (cases[i][j] == cases[i-1][j]) {
                cases[i - 1][j] *= 2;
                cases[i][j] = 0;
            }
            i--;
        }
        return;
    }

    private void moveDown() {
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                moveSquareDown(i, j);
            }
        }
        return;
    }

    private void moveSquareDown(int i, int j) {
        while (i < 3) {
            if (cases[i][j] != 0 && cases[i+1][j] == 0) {
                cases[i + 1][j] = cases[i][j];
                cases[i][j] = 0;
            } else if (cases[i][j] == cases[i+1][j]) {
                merge(new int[]{i+1, j}, new int[]{i, j});
            }
            i++;
        }
        return;
    }

    private void moveLeft() {
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                moveSquareLeft(i, j);
            }
        }
        return;
    }

    private void moveSquareLeft(int i, int j) {
        while (j > 0) {
            if (cases[i][j] != 0 && cases[i][j-1] == 0) {
                cases[i][j-1] = cases[i][j];
                cases[i][j] = 0;
            } else if (cases[i][j] == cases[i][j-1]) {
                merge(new int[]{i, j-1}, new int[]{i, j});
            }
            j--;
        }
        return;
    }

    private void moveRight() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j >= 0; j--) {
                moveSquareRight(i, j);
            }
        }
        return;
    }

    private void moveSquareRight(int i, int j) {
        while (j < 3) {
            if (cases[i][j] != 0 && cases[i][j+1] == 0) {
                moveToEmptySpace(new int[]{i, j+1}, new int[]{i, j});
            } else if (cases[i][j] == cases[i][j+1]) {
                merge(new int[]{i, j+1}, new int[]{i, j});
            }
            j++;
        }
        return;
    }

    private void moveToEmptySpace(int[] target, int[] piece) {
        cases[target[0]][target[1]] = cases[piece[0]][piece[1]];
        cases[piece[0]][piece[1]] = 0;
    }

    private void merge(int[] target, int[] auxiliary) {
        cases[target[0]][target[1]] *= 2;
        cases[auxiliary[0]][auxiliary[1]] = 0;
    }

    public void generateRandomBlock() {
        System.out.println("Generating block");
        int position1;
        int[] availablePositions = new int[16];
        int size = 0;

        // checking all available positions
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (cases[i][j] == 0) {
                    availablePositions[size] = 4*i + j;
                    size++;
                }
            }
        }
        if (size == 0) {
            System.out.println("You lost!");
        }
        position1 = availablePositions[(int) (Math.random() * size)];
        cases[position1 / 4][position1 % 4] = (Math.random() > 0.1) ? 2 : 4;
        return;
    }
    // public void merge();
}
