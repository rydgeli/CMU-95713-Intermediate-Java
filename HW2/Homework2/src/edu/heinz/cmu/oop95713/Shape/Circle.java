package edu.heinz.cmu.oop95713.Shape;

/**
 * @author Yujie
 * Representing a circle
 */
public final class Circle extends Shape{
	
	/**
	 * center: An instance of Point class representing its center
	 * radius: An double instance representing its radius
	 */
	private Point center;
	private double radius;

	/**
	 * Constructor #1
	 * @param center	a Point object representing the center of a circle
	 * @param radius	a double variable representing the radius of a circle
	 */
	public Circle(Point center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	
	/**
	 * Constructor #2
	 * @param x			x value of the center point
	 * @param y			y value of the center point
	 * @param radius	radius of a circle
	 */
	public Circle(int x,int y, double radius)
	{
		this.center=new Point(x,y);
		this.radius=radius;
	}

	/** 
	 * Draw method
	 */
	@Override
	public void draw() {
		System.out.printf("Drawing circle at point %s with radius %.2f\n",center,radius);
	}

	/**
	 * Erase method
	 */
	@Override
	public void erase() {
		System.out.printf("Erasing circle at point %s with radius %.2f\n",center,radius);
	}
	
	@Override
	public String toString() {
		return "Circle at Point "+center+" with radius "+radius;
	}
	
}
