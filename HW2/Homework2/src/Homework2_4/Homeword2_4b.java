package Homework2_4;
/**
 * Has-a relationship
 */

/**
 * @author Yujie
 *
 */
public class Homeword2_4b {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//create a CPoint object
		CPoint p=new CPoint(10,20);
		System.out.println("The point is "+p);
		
		//create a CCircle object and calculate its area
		CCircle c=new CCircle(3,6,4);
		System.out.println("The circle is "+c);
		System.out.println("the area of circle: "+c.area());
		
		//create a CCylinder object and calculate its area and volume
		CCylinder cy=new CCylinder(5,8,6,12);
		System.out.println("The cylinder is "+cy);
		System.out.println("The area of cylinder: "+cy.area());
		System.out.println("The volume of cylinder: "+cy.volume());
	}

}

/**
 * @author Yujie
 * Representing a point
 */
class CPoint{
	private int x,y;
	
	/**
	 * Constructor
	 * @param x		x value of a point
	 * @param y		y value of a point
	 */
	public CPoint(int x, int y) {
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
 * representing a circle
 */
class CCircle{
	/**
	 * CCircle class has a Point object and a double variance
	 */
	private double radius;
	private CPoint center;
	
	/**
	 * Constructor
	 * @param x		x value of the center point
	 * @param y		y value of the center point
	 * @param radius
	 */
	public CCircle(int x, int y,double radius) {
		center=new CPoint(x,y);
		this.radius=radius;
	}
	
	/**
	 * Getter
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**	
	 * Setter
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
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
		return "Radius: " + radius + ", Center: " + center;
	}
}

/**
 * @author Yujie
 * Representing a Cylinder
 */
class CCylinder{
	
	/**
	 * CCylinder class has a CCircle object and a double variance
	 */
	private double height;
	private CCircle circle;

	/**
	 * Constructor
	 * @param x			x value of the center point in the circle of a cylinder
	 * @param y			y value of the center point in the circle of a cylinder
	 * @param radius	the radius of the circle of a cylinder
	 * @param height	the height of a cylinder
	 */
	public CCylinder(int x, int y, double radius,double height) {
		circle=new CCircle(x,y,radius);
		this.height=height;
	}
	
	/**
	 * Calculate the area of a cylinder
	 * @return the area
	 */
	public double area()
	{
		return circle.area()*2 + 2*Math.PI*circle.getRadius()*height;
	}
	
	/**
	 * Calculate the volume of a cylinder
	 * @return the volume
	 */
	public double volume()
	{
		return circle.area()*height;
	}
	
	@Override
	public String toString() {
		return "Height: " + height + ", " + circle;
	}
	
}

