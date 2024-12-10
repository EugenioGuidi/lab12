package it.unibo.es3;

import java.util.Random;

public class LogicsImpl implements Logics{

    private int[][] matrix;

    public LogicsImpl(final int size) {
        this.matrix = new int[size][size];
        Random random = new Random();
        int x;
        int y;
        for(int i = 0; i < 3; i++) {
            boolean condition = true;
            do {
                x = random.nextInt(size);
                y = random.nextInt(size);
                if(this.matrix[x][y] == 0) {
                    this.matrix[x][y] = 1;
                    condition = false;
                }
            }while(condition);
        }
    }

    public int[][] getMatrix() {
        return this.matrix;
    }

    @Override
    public int[][] hit() {
        final int[][] newMatrix = new int[this.matrix.length][this.matrix[0].length];
        for (int i = 0; i < newMatrix.length; i++) {
            for(int j = 0; j < newMatrix[0].length; j++) {
                if(this.matrix[i][j] == 1) {
                    newMatrix[i][j] = 1;
                    if( j + 1 < newMatrix[0].length) {
                        newMatrix[i][j + 1] = 1;
                    }
                    if(i - 1 > -1 && j + 1 < newMatrix[0].length) {
                        newMatrix[i - 1][j + 1] = 1;
                    }
                    if(i - 1 > -1) {
                        newMatrix[i - 1][j] = 1;
                    }
                    if(i - 1 > -1 && j - 1 > -1) {
                        newMatrix[i - 1][j - 1] = 1;
                    }
                    if(j - 1 > -1) {
                        newMatrix[i][j - 1] = 1;
                    }
                    if(i + 1 < newMatrix.length && j - 1 > -1){
                        newMatrix[i + 1][j - 1] = 1;
                    }
                    if(i + 1 < newMatrix.length) {
                        newMatrix[i + 1][j] = 1;
                    }
                    if(i + 1 < newMatrix.length && j + 1 < newMatrix[0].length) {
                        newMatrix[i + 1][j + 1] = 1;
                    }
                }
            }
        }
        this.matrix = newMatrix;
        return newMatrix;
    }

    @Override
    public boolean toQuit() {
        boolean condition = true;
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[0].length; j++) {
                if(this.matrix[i][j] == 0) {
                    condition = false;
                }
            }
        }
        return condition;
    }
    
}
