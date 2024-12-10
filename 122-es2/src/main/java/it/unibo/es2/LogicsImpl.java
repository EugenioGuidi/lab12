package it.unibo.es2;

public class LogicsImpl implements Logics{

    private final int[][] matrix;

    public LogicsImpl(final int size) {
        this.matrix = new int[size][size];
    }

    @Override
    public String hit(final Pair<Integer,Integer> pair) {
        final int row = pair.getX();
        final int col = pair.getY();
        if (this.matrix[row][col] == 0) {
            this.matrix[row][col] = 1;
            return "*";
        } else {
            this.matrix[row][col] = 0;
            return " ";
        }
    }

    @Override
    public boolean toQuit() {
        boolean condition = true;
        for (int i = 0; i < this.matrix.length; i++) {
            condition = true;
            for (int j = 0; j < this.matrix[0].length; j++) {
                if(this.matrix[i][j] == 0) {
                    condition = false;
                }
            }
            if(condition == true) {
                return true;
            }
        }
        condition = true;
        for (int i = 0; i < this.matrix[0].length; i++) {
            condition = true;
            for (int j = 0; j < this.matrix.length; j++) {
                if(this.matrix[j][i] == 0) {
                    condition = false;
                }
            }
            if(condition == true) {
                return true;
            }
        }
        return false;
    }
    
}
