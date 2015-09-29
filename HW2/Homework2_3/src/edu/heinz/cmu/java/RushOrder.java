/**
 * 
 */
package edu.heinz.cmu.java;

/**
 * @author Yujie
 * Representing a special order with specified delivery days 
 */
public class RushOrder extends Order {
	/**
	 * RushOrder class has a new variable: deliveryDay
	 */
	protected int deliveryDay;
	
	/**
	 * Constructor
	 * @param days
	 */
	public RushOrder(int days) {
		super();
		deliveryDay=days;
	}

	/**
	 * invoke the getTotal()  of superclass(Order class), then add the delivery charge based on the deliveryDays
	 * @return the total cost including the delivery charge
	 */
	@Override
	public int getTotal()
	{
		int cost = super.getTotal();
		if(cost>0)//when there are items in the order, add the delivery charge
		{
			switch(deliveryDay)
			{
			case 1:cost+=25;
				break;
			case 2: cost+=15;
				break;
			case 3: cost+=10;
				break;
			default:
				break;
			}
		}
		return cost;
	}
	
	@Override
	public String toString() {
		return "RushOrder to deliver in "+deliveryDay+(deliveryDay>1?" days":" day");
	}
}
