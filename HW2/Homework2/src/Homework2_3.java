import java.util.Random;
import java.util.Scanner;

import edu.heinz.cmu.java.*;

/**
 * Test driver of Homework 2.3
 */

/**
 * @author Yujie
 *
 */
public class Homework2_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Create an array of 4 Order objects and assign objects to it according to deliveryDays.
		Order[] orders=new Order[4];
		orders[0]=new Order();
		orders[1]=new RushOrder(1);
		orders[2]=new RushOrder(2);
		orders[3]=new RushOrder(3);
		
		//Prompt the user to enter the UPC code
		System.out.println("Please enter the UPC (enter done to end): ");
		Scanner input= new Scanner(System.in);
		Random ran=new Random();
		String upc=input.next();
		
		//quite when user enters "done"
		while(upc.compareToIgnoreCase("done")!=0)
		{
			System.out.println("Please enter the quantity");
			int quantity=input.nextInt();
			//randomly generate price and delivery days
			int price=ran.nextInt(51)+50;
			int days=ran.nextInt(7)+1;
			OrderItem item=new OrderItem(upc,quantity,price);
			//add the order item to the order array
			switch (days)
			{
			case 1:
				orders[1].addOrderItem(item);
				break;
			case 2:
				orders[2].addOrderItem(item);
				break;
			case 3:
				orders[3].addOrderItem(item);
				break;
			default:
				orders[0].addOrderItem(item);
				break;
			}
			System.out.println("Please enter the UPC (enter done to end): ");
			upc=input.next();
		}
		
		//total cost of the all the orders
		int sum=0;
		
		//print information about each order
		for(Order order:orders)
		{
			System.out.println("\n*****Displaying an order*****");
			System.out.println(order);
			order.printOrderItems();
			System.out.println("Subtotal: "+order.getTotal());
			sum+=order.getTotal();
		}
		//print out the total cost
		System.out.println("\n*****Total Cost*****\n "+sum);
		
	}

}
