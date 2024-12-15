package it.unibo.es3;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LogicsImpl implements Logics{

    private final Set<Pair<Integer, Integer>> setTotal;
    private final Set<Pair<Integer, Integer>> setNear;
    private final int width;

    public LogicsImpl(final int width) {
        Random randomInt = new Random();
        this.width = width;
        this.setNear = new HashSet<>();
        this.setTotal = new HashSet<>();
        while(this.setTotal.size() < 3) {
            this.setTotal.add(new Pair<Integer,Integer>(randomInt.nextInt(this.width), randomInt.nextInt(this.width)));
        }
    }

    @Override
    public void hit() {
        this.setNear.clear();
        for(int i = 0; i < this.width; i++) {
            for(int j = 0; j < this.width; j++) {
                Pair<Integer, Integer> pair = new Pair<>(i, j);
                if(setTotal.stream().anyMatch(p -> near(p, pair))) {
                    this.setNear.add(pair);
                }
            }
        }
        this.setTotal.addAll(this.setNear);
    }

    @Override
    public boolean toQuit() {
        return this.setTotal.size() == this.width * this.width;
    }

    public Set<Pair<Integer, Integer>> getSet() {
        return new HashSet<>(this.setTotal);
    }

    private boolean near(Pair<Integer, Integer> firstPair, Pair<Integer, Integer> secondPair) {
        boolean condition;
        condition = (Math.abs(firstPair.getX() - secondPair.getX()) < 2 && Math.abs(firstPair.getY() - secondPair.getY()) < 2);
        return condition;
    }
    
}
