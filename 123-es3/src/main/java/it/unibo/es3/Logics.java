package it.unibo.es3;

public interface Logics {

    /**
     * 
     * @param pair
     * 
     * @return @return the new value a button should show after being pressed
     */
    int[][] hit ();

    public int[][] getMatrix();

    /**
     * 
     * @return whether it is time to quit
     */
    boolean toQuit();
    
}
