package it.unibo.es2;

public interface Logics {
	
	/**
	 * @return the new value a button should show after being pressed
	 */
	String hit(final Pair<Integer,Integer> pair);
	
	/**
	 * @return whether it is time to quit
	 */
	boolean toQuit();
}