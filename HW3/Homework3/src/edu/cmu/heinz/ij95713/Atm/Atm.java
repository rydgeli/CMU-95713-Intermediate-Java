package edu.cmu.heinz.ij95713.Atm;
import edu.cmu.heinz.ij95713.Atm.IOUnit.Transaction;
import edu.cmu.heinz.ij95713.Bank.*;

import java.util.Scanner;

/**
 * @author Yujie
 *
 *Atm class has the following objects as its fields:
 *	CardReader, DepositUnit,CashDispenser, ReceiptPrinter, IOUnit, and BankServer(which the ATM communicates with)
 */
public class Atm {
	private DepositUnit depositUnit;
	private CashDispenser cashDispenser;
	private ReceiptPrinter receiptPrinter;
	private CardReader cardReader;
	private IOUnit ioUnit;
	private BankServer server;

	/**
	 * Constructor
	 * @param bankServer :a bankServer object
	 */
	public Atm(BankServer bankServer)
	{
		server=bankServer;
		cardReader=new CardReader();
		depositUnit=new DepositUnit();
		cashDispenser=new CashDispenser();
		receiptPrinter=new ReceiptPrinter();
		ioUnit=new IOUnit();
		server=bankServer;	
	}
	
	/**
	 * Handles the main procedure of transactions.
	 */
	public void handleTransaction(){
		Scanner in =new Scanner(System.in);
		String cardNumber=cardReader.readCard();
		String pin=ioUnit.obtainCustomerPin();
		boolean flag=true;// use flag to determine if the user wants to do another transaction.
		while(flag)
		{
		int count=0;// count the times of failure.
		while(!server.verifyPin(cardNumber, pin))
		{
			count++;
			if(count==3)
			{
				cardReader.coniscate();
				return;
			}
			System.out.println("Please try again."+" ("+(3-count)+" try left)");
			pin=ioUnit.obtainCustomerPin();
		}
		
		//get the Transaction type from the user.
		Transaction type=ioUnit.obtainTransaction();
		switch(type)
		{
		case DEPOSIT:
			/*
			 * Steps:
			 * obtain amount to be deposited from the user
			 * Take deposit envelop
			 * send doDeposit message to bank server with card number and amount
			*/
			double amount=ioUnit.obtainAmount();
			depositUnit.takeDepositEnvelop();
			server.doDeposit(cardNumber, amount);
			receiptPrinter.printReceipt("Your account balance is "+server.doQuery(cardNumber));
			break;
		case WITHDRAW:
			/*
			 * Steps:
			 * obtain the withdraw amount from the user
			 * verify the availability of funds via  the BankServer method verifyFunds()
			 * if verified: 
			 * 				Send doWithdraw message to bank server with card number and amount
			 * 				dispense cash
			 * 				print a receipt including the total amount in the account
			 * if not verified:
			 * 				print receipt about not having enough funds in the account
			 */
			int amount_1=(int)ioUnit.obtainAmount();
			if(server.verifyFnds(cardNumber, amount_1))
			{
				server.doWithdraw(cardNumber, amount_1);
				cashDispenser.dispenseCash(amount_1);
				receiptPrinter.printReceipt("Your account balance is "+server.doQuery(cardNumber));
			}
			else
			{
				receiptPrinter.printReceipt("you don't have enough funds in the account");
			}
			break;
		case QUERY:
			/*
			 * send doQuery message to bank server with card number 
			 * print a receipt including the current amount in the account
			 */
			receiptPrinter.printReceipt("Your account balance is "+server.doQuery(cardNumber));
			break;
		case CANCEL:
			/*
			 * print a receipt saying transaction is cancelled
			 */
			receiptPrinter.printReceipt("The transaction is cancelled!");
			break;
		default:
			break;
		}
		cardReader.releaseCard();
		
		System.out.println("Do you want to do another transaction on this account? (Please input Y or N)");
		String ans=in.next();
		if(ans.equals("N") || ans.equals("n"))
			flag=false;
		}
	}

}

class CashDispenser{
	/**
	 * Takes an integer amount and prints a message saying that money in the provided amount is dispensed.
	 * @param amount : an integer
	 */
	public void dispenseCash(int amount)
	{
		System.out.println("Money in the amount of "+amount+" is dispensed");
	}
}

class DepositUnit{
	/**
	 * Prints a message saying that envelop is successfully received.
	 */
	public void takeDepositEnvelop()
	{
		System.out.println("Envelop is successfullt received.");
	}
	
}

class ReceiptPrinter{
	/**
	 * Prints the String parameter to the console
	 * @param str : a String
	 */
	public void printReceipt(String str)
	{
		System.out.println(str);
	}
}

class CardReader{
	/**
	 * Ask for the card number from the user, read it and returns it.
	 * @return the card number
	 */
	public String readCard() {
		System.out.println("Please enter your card number:");
		Scanner in=new Scanner(System.in);
		String cardNumber=in.next();
		return cardNumber;
	}
	
	/**
	 * Prints out a message saying that the card is confiscated.
	 */
	public void coniscate(){
		System.out.println("Card is confiscated.");
	}
	
	/**
	 * Prints out  am message saying that the card is released.
	 */
	public void releaseCard()
	{
		System.out.println("Card is released.");
	}
	
}

class IOUnit{
	
	//defines a Transaction enum with objects of DEPOSIT, WITHDRAW, QUERY, and CANCEL.
	public enum Transaction{ DEPOSIT, WITHDRAW, QUERY, CANCEL};
	
	/**
	 * Prompts the user for a pin, reads and returns it.
	 * @return the pin number
	 */
	public String obtainCustomerPin()
	{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your pin number: ");
        String pin = in.next();
        return pin;
	}
	
	/**
	 * Prompts the user to select a transaction from a menu, reads the input and returns the selected transaction.
	 * @return the selected transaction
	 */
	public Transaction obtainTransaction()
	{
        Scanner in = new Scanner(System.in);
        System.out.println("Please select a transaction: 1(Deposit),2(Withdraw),3(Query),4(Cancel)");
        
        String selection = in.next();
        switch(selection)
        {
        case "1":
        	return Transaction.DEPOSIT;
        case "2":
        	return Transaction.WITHDRAW;
        case "3":
        	return Transaction.QUERY;
        case "4":
        	return Transaction.CANCEL;
        default:
        	break;
        }
		return null;
	}
	
	/**
	 * Prompts the user for an amount, reads and returns it. 
	 * @return the amount
	 */
	public double obtainAmount()
	{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        double amount = in.nextDouble();
        return amount;
	}
	
}
