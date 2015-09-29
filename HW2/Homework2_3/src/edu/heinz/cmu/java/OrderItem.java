/**
 * 
 */
package edu.heinz.cmu.java;

/**
 * @author Yujie
 * Representing an order item which includes upc, quantity, and price
 */
public class OrderItem {

	/**
	 * OrderItem class has 3 member variables
	 */
	private String upc;
	private int quantity;
	private int price;
	
	/**
	 * Constructor
	 * @param upc		a string object representing the item
	 * @param quantity	the quantity of the item
	 * @param price		the price of the item
	 */
	public OrderItem(String upc, int quantity, int price) {
		this.upc = upc;
		this.quantity = quantity;
		this.price = price;
	}

	
	/**
	 * Calculate the cost of the item
	 * @return the result of price*quantity
	 */
	public int getCost()
	{
		return price*quantity;
	}

	@Override
	public String toString() {
		return ">> UPC: " + upc + ", Quantity: " + quantity + ", Price: " + price;
	}

}
