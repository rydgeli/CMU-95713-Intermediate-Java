package edu.heinz.cmu.oop95713.Shape;

/**
 * @author Yujie
 * Representing a square
 */
public final class Square extends Shape{
	
	/**
	 * 4 objects of Point class
	 */
	private Point p1,p2,p3,p4;

	/**
	 * Constructor #1
	 * @param p1	
	 * @param p2
	 * @param p3
	 * @param p4
	 */
	public Square(Point p1, Point p2, Point p3, Point p4) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
	/**
	 * Constructor #2
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @param x4
	 * @param y4
	 */
	public Square(int x1,int y1, int x2, int y2, int x3, int y3,int x4, int y4 )
	{
		this.p1=new Point(x1,y1);
		this.p2=new Point(x2,y2);
		this.p3=new Point(x3,y3);
		this.p4=new Point(x4,y4);
	}

	/** 
	 * Draw method
	 */
	@Override
	public void draw() {
		System.out.printf("Drawing square at points %s, %s, %s,%s\n",p1,p2,p3,p4);
	}

	/** 
	 * Erase method
	 */
	@Override
	public void erase() {
		System.out.printf("Erasing square at points %s, %s, %s,%s\n",p1,p2,p3,p4);
	}

	@Override
	public String toString() {
		return "Square at Points"+p1+", "+p2+", "+p3+" and "+p4;
	}

}
