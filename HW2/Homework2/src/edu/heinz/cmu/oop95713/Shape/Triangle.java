package edu.heinz.cmu.oop95713.Shape;

/**
 * @author Yujie
 * Representing a triangle
 */
public final class Triangle extends Shape {
	/**
	 * Triangle class has 3 objects of Point Class
	 */
	private Point p1,p2,p3;

	/**
	 * Constructor #1
	 * @param p1	a Point object
	 * @param p2	a Point object
	 * @param p3	a Point object
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	/**
	 * Constructor #2
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 */
	public Triangle(int x1, int y1,int x2, int y2,int x3,int y3)
	{
		this.p1=new Point(x1,y1);
		this.p2=new Point(x2,y2);
		this.p3=new Point(x3,y3);
	}

	/** 
	 * Draw method
	 */
	@Override
	public void draw() {
		System.out.printf("Drawing triangle at points %s, %s, %s\n",p1,p2,p3);
	}

	/** 
	 * Erase method
	 */
	@Override
	public void erase() {
		System.out.printf("Erasing triangle at points %s, %s,%s\n",p1,p2,p3);
	}

	@Override
	public String toString() {
		return "Triangle at Points "+p1+", "+p2+" and "+p3;
	}

}
