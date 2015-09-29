import edu.heinz.cmu.oop95713.Shape.*;

/**
 * @author Yujie
 *
 */
public class Homeworkd2_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//create 6 Shape objects
		System.out.println("*****Created 6 Shape objects*****");
		Circle s1=new Circle(new Point(1,1), 1);
		System.out.println(s1);
		
		Circle s2=new Circle(-1,-1,1);
		System.out.println(s2);
		
		Square s3=new Square(new Point(1,2),new Point(2,2),new Point(1,1),new Point(2,1));
		System.out.println(s3);
		
		Square s4=new Square(-1,-2,-2,-2,-1,-1,-2,-1);
		System.out.println(s4);
		
		Triangle s5=new Triangle(new Point(3,3),new Point(4,3),new Point(4,4));
		System.out.println(s5);

		Triangle s6=new Triangle(-3,-3,-4,-3,-4,-4);
		System.out.println(s6);
		
		//Put those objects into a Shape array
		Shape[] all=new Shape[6];
		all[0]=s1; all[1]=s2;
		all[2]=s3; all[3]=s4;
		all[4]=s5; all[5]=s6;
		
		//invoke draw() on all of them
		System.out.println("\n*****Drawing these Shape objects*****");
		for (int i=0;i<6;i++)
		{
			all[i].draw();
		}
		
		//invoke erase() on all of them
		System.out.println("\n*****Erasing these Shape objects*****");
		for (int i=0;i<6;i++)
		{
			all[i].erase();
		}
	}

}
