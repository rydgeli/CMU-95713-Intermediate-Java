import java.util.Scanner;

public class Homework1_3 {
	
	private static final int paymentPerYear=12;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please input your principal, interest rate and number of years:");
		Scanner in= new Scanner(System.in);
		double principal=0,interest=0,monthlyPayment=0;
		int years=0;
		principal=in.nextDouble();
		interest=in.nextDouble();
		if(interest==0)
		{
			System.out.println("oops! Interest equals to 0. This is not a loan!! Formula is not applicable in this case. ");
			return;
		}
		years=in.nextInt();
		monthlyPayment = (interest*(principal/paymentPerYear))/
				(1-Math.pow((interest/paymentPerYear)+1, -paymentPerYear*years));
		
		System.out.printf("monthlyPayment: %.2f",monthlyPayment);
		System.out.println();
		for (int i=1;i<=years;i++)
		{
			System.out.println("Total payment after this year: "+(years-i)*paymentPerYear*monthlyPayment);
		}
		
		System.out.printf("Total interest paid: %.2f", ((monthlyPayment*years*paymentPerYear)-principal));
		
	}

}
