package it.unibo.es2;

import java.util.List;

public class LogicsImpl implements Logics{

    private final int[][] matrix;

    public LogicsImpl(final int size) {
        this.matrix = new int[size][size];
    }

    @Override
    public int size() {
        // per ora lo lascio vuoto
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public List<Integer> values() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'values'");
    }

    @Override
    public List<Boolean> enablings() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enablings'");
    }

    @Override
    public int hit(int elem) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hit'");
    }

    @Override
    public String result() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'result'");
    }

    @Override
    public boolean toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }
    
}
