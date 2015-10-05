package edu.heinz.cmu.oop95713.Shape;

/**
 * @author Yujie
 * Representing a point
 */

public class Point {
	
	/**
	 * Two integer instance members: X and Y
	 */
	private int x,y;

	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Getter
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Setter
	 * @param x: the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Getter
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Setter
	 * @param y: the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "("+x+","+y+")";
	}
	

}
