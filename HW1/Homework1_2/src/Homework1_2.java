import java.util.Random;

public class Homework1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double balance=0, gain=0, returnRate=0,inflation=0;
		int years=0,contribution=0;
		Random generator=new Random();
		int goal=generator.nextInt(50001)+150000;
		System.out.println("********** Retirement Goal: $"+goal+" **********");
		System.out.println("Year	Contribution	Gain/Loss	New balance so far");
		while(balance < goal)
		{
			contribution=generator.nextInt(10001);
			returnRate=generator.nextDouble()*5;
			inflation=generator.nextDouble()*4;
			balance+=contribution;
			gain=0.01*contribution*(returnRate-inflation);
			balance+=gain;
			years++;
			System.out.printf("%d	$%d		$%7.2f	$%.2f", years,contribution,gain,balance);
			System.out.println();
		}
		
		System.out.println("********** Number of years needed to retire: "+years+" **********");
		
		
	}

}
