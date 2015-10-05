package Homework2_4;
/**
 * Is-a Relationship
 */

/**
 * @author Yujie
 *
 */
public class Homework2_4a {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create a Point object
		Point p=new Point(10,20);
		System.out.println("The Point: "+p);
		
		//create a Circle object and calculate its area
		Circle c=new Circle(3,6,4);
		System.out.println("The Circle: "+c);
		System.out.println("The area of circle: "+c.area());
		
		//create a Cylinder object and calculate its area and volume
		Cylinder cy=new Cylinder(5,8,6,12);
		System.out.println("The Cylinder: "+cy);
		System.out.println("The area of cylinder: "+cy.area());
		System.out.println("The volume of cylinder: "+cy.volume());
	}

}

/**
 * @author Yujie
 * Representing a point
 */
class Point{
	protected int x,y;
	
	/**
	 * Constructor
	 * @param x
	 * @param y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public String toString()
	{
		return "("+x+","+y+")";
	}
}

/**
 * @author Yujie
 * Representing a circle
 */

class Circle extends Point{
	/**
	 * new variance: radius
	 */
	protected double radius;
	
	
	/**
	 * Contructor
	 * @param x
	 * @param y
	 * @param radius
	 */
	public Circle(int x, int y,double radius) {
		super(x, y);
		this.radius=radius;
	}
	
	
	/**
	 * Calculate the area of a circle
	 * @return the area
	 */
	public double area()
	{
		return Math.PI*radius*radius;
	}
	
	@Override
	public String toString() {
		return "Radius: " + radius + ", Center: ("+x+","+y+")";
	}
}

/**
 * @author Yujie
 * Representing a cylinder
 */

class Cylinder extends Circle{

	/**
	 * new variance: height
	 */
	protected double height;

	/**
	 * Constructor
	 * @param x
	 * @param y
	 * @param radius
	 * @param height
	 */
	public Cylinder(int x, int y, double radius,double height) {
		super(x, y, radius);
		this.height=height;
	}
	
	/**
	 * Calculate the area of a cylinder
	 * @return the area
	 */
	@Override
	public double area()
	{
		return super.area()*2 + 2*Math.PI*radius*height;
	}
	
	/**
	 * Calculate the volume of a cylinder
	 * @return the volume
	 */
	public double volume()
	{
		return super.area()*height;
	}
	
	@Override
	public String toString() {
		return "Height: " + height + ", Radius=" + radius + ", Center: ("+x+","+y+")";
	}
	
}


