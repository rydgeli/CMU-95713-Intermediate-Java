/**
 * 
 */
package edu.heinz.cmu.java;

import java.util.ArrayList;

/**
 * @author Yujie
 * Representing a order which consists of order items
 */
public class Order {
	
	/**
	 * Order class has a list of OrderItem objects 
	 */
	private ArrayList<OrderItem> list;
	
	/**
	 * Constructor
	 */
	public Order() {
		list = new ArrayList<OrderItem>();
	}

	/**
	 * Append an OrderItem object to the list
	 * @param item	an OrderItem object
	 */
	public void addOrderItem(OrderItem item)
	{
		list.add(item);
	}
	
	/**
	 * @return total cost of all items in the list
	 */
	public int getTotal()
	{
		int cost=0;
		for (OrderItem item : list)
		{
			cost+=item.getCost();
		}
		return cost;
	}
	
	/**
	 * print out all the items in the list
	 */
	public void printOrderItems()
	{
		for (OrderItem item:list)
		{
			System.out.println(item);
		}
	}

	@Override
	public String toString() {
		return "Standard Order (within 7 days delivery)";
	}

}
