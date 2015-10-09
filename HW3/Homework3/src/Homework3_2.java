import edu.cmu.heinz.ij95713.Atm.Atm;
import edu.cmu.heinz.ij95713.Bank.BankServer;

/**
 * @author Yujie
 *
 */
public class Homework3_2 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BankServer server=new BankServer();
		Atm atm= new Atm(server);
		atm.handleTransaction();
	}

}
