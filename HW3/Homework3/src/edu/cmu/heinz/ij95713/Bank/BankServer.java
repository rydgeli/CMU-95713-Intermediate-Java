package edu.cmu.heinz.ij95713.Bank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

/**
 * @author Yujie
 *
 *BankServer class has an arrayList object to store all accounts from the input file.
 */
public class BankServer {
	
	private ArrayList<Account> accounts;
	
	/**
	 * Constructor
	 * initialize the accounts list and invoke the loadAccounts method to read the input file.
	 */
	public BankServer()
	{
		accounts=new ArrayList<Account>();
		
		try {
			loadAccounts("accounts.dat");
		} catch (IOException e) {
			System.out.println("Error when reading file");
			e.printStackTrace();
		}
	}

	/**
	 * Verify the pin for the account
	 * @param cardNumber : the card number input from user
	 * @param pin : the pin input from user
	 * @return true if account exists and the pin number is correct
	 */
	public boolean verifyPin(String cardNumber, String pin) {
		for(Account account:accounts)
		{
			if(account.getAccountId().equals(cardNumber))
			{
				if(account.getPin().equals(pin))
				{
					return true;
				}
				
				break;
			}
		}
		return false;
	}

	/**
	 * Invoke withdraw() method on the account if exits.
	 * @param cardNumber : the card Number input from the user
	 * @param amount : the amount of money
	 */
	public void doWithdraw(String cardNumber, int amount) {
		for(Account account:accounts)
		{
			if(account.getAccountId().equals(cardNumber))
			{
				account.withdraw(amount);
				break;
			}
		}
	}

	/**
	 * invoke the deposit method on the account if exits.
	 * @param cardNumber : the card number that input from the user
	 * @param amount : the amount of money
	 */
	public void doDeposit(String cardNumber, double amount) {
		for(Account account:accounts)
		{
			if(account.getAccountId().equals(cardNumber))
			{
				account.deposit(amount);
				break;
			}
		}
	}

	/**
	 * Searches for the account and returns the balance 
	 * @param cardNumber
	 * @return the balance of the account
	 */
	public double doQuery(String cardNumber) {
		for(Account account:accounts)
		{
			if(account.getAccountId().equals(cardNumber))
			{
				return account.getBalance();
			}
		}
		return 0;
	}

	/**
	 * Searches for the account if exists and make sure its balance is greater than or equal to the amount.
	 * @param cardNumber
	 * @param amount
	 * @return true if the account exists and the amount is reasonable.
	 */
	public boolean verifyFnds(String cardNumber, double amount) {
		for(Account account:accounts)
		{
			if(account.getAccountId().equals(cardNumber))
			{
				if(account.getBalance()>=amount)
				{
					return true;
				}
				
				break;
			}
		}
		return false;
	}
	
	
	/**
	 * Reads an input file that contains the account information and creates the account objects.
	 * @param filename : the name of the input file
	 * @throws IOException
	 */
	private void loadAccounts(String filename) throws IOException {
		BufferedReader instream=new BufferedReader(new FileReader(filename));
		String line;
		ArrayList<String> temp=new ArrayList<String>();
		
		while((line=instream.readLine())!=null)
		{
			StringTokenizer tokenizer=new StringTokenizer(line,"|");
			while(tokenizer.hasMoreTokens())
			{
				temp.add(tokenizer.nextToken());
			}
			if(temp.get(0).equals("S"))// if the account is a saving account
			{
				SavingsAccount account=new SavingsAccount(temp.get(1),temp.get(2),temp.get(3),temp.get(4),temp.get(5));
				accounts.add(account);
			}
			if(temp.get(0).equals("C"))// if the account is a checking account
			{
				CheckingAccount account=new CheckingAccount(temp.get(1),temp.get(2),temp.get(3),temp.get(4),temp.get(5),temp.get(6),temp.get(7),temp.get(8),temp.get(9),temp.get(10));
				accounts.add(account);
			}
			temp.clear();
		}
		instream.close();
	}

}

/**
 * Account class has accountId, customerId, pin, and balance fields.
 *
 */
class Account {
	private String accountId;
	private String customerId;
	private String pin;
	private double balance;
	
	/**
	 * Constructor
	 * @param s1 : account id
	 * @param s2 : customer id
	 * @param s3 : pin number
	 * @param s4 : balance
	 */
	public Account(String s1, String s2,String s3, String s4)
	{
		accountId=s1;
		customerId=s2;
		pin=s3;
		balance=Double.parseDouble(s4);
	}
	
	/**
	 * @return the accountId
	 */
	public String getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId : the accountId to set
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the customerId
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId : the customerId to set
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the pin of the account
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * @param pin : the pin to set
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * @return the balance of the account
	 */
	public double getBalance(){
		return balance;
	}
	
	/**
	 * @param balance : the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * Adds the amount to the account balance.
	 * @param amount
	 * 
	 */
	public void deposit(double amount) {
		setBalance(getBalance()+amount);
	}

	/**
	 * Subtracts the amount from the account balance.
	 * @param amount
	 */
	public void withdraw(double amount) {
		setBalance(getBalance()-amount);
	}

	/**
	 * Override the equals method
	 * Compare the value of accountId, customerId to decide if they equal to each other.
	 */
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(getClass()!=obj.getClass())
			return false;
		
		if(this.getAccountId().equals(((Account) obj).getAccountId()) &&
				this.getCustomerId().equals(((Account)obj).getCustomerId()))
			return true;
		return false;
	}
}

class SavingsAccount extends Account {

	private double interestRate;
	
	/**
	 * @return the interestRate
	 */
	public double getInterestRate() {
		return interestRate;
	}

	/**
	 * @param interestRate : the interestRate to set
	 */
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public SavingsAccount(String s1, String s2, String s3, String s4, String s5){
		super(s1,s2,s3,s4);
		setInterestRate(Double.parseDouble(s5));
	}

	/**
	 * Calculates the monthly interest and adds it to the balance.
	 */
	public void applyMounthlyinterest() {
		setBalance(getBalance()+getBalance()*interestRate/12);
	}
	

	/* (non-Javadoc)
	 * @see edu.cmu.heinz.ij95713.Bank.Account#equals(java.lang.Object)
	 */
	public boolean equals(Object obj)
	{
		if(super.equals(obj) && this.getInterestRate()==((SavingsAccount)obj).getInterestRate())
		{
			return true;
		}
		return false;
	}

}

class CheckingAccount extends Account {
	private Date lastDepositDate;
	private double lastDepositAmount;
	
	public CheckingAccount(String s1, String s2, String s3, String s4, String s5,String s6, String s7, String s8, String s9, String s10) {
		super(s1, s2, s3, s4);
		lastDepositAmount=Double.parseDouble(s5);
		GregorianCalendar calendar=new GregorianCalendar();
		calendar.set(Integer.parseInt(s6), Integer.parseInt(s7), Integer.parseInt(s8), Integer.parseInt(s9), Integer.parseInt(s10));
		lastDepositDate=calendar.getTime();
	}

	/**
	 * @return the lastDepositDate
	 */
	public Date getLastDepositDate() {
		return lastDepositDate;
	}

	/**
	 * @param lastDepositDate the lastDepositDate to set
	 */
	public void setLastDepositDate(Date lastDepositDate) {
		this.lastDepositDate = lastDepositDate;
	}

	/**
	 * @return the lastDepositAmount
	 */
	public double getLastDepositAmount() {
		return lastDepositAmount;
	}

	/**
	 * @param lastDepositAmount the lastDepositAmount to set
	 */
	public void setLastDepositAmount(double lastDepositAmount) {
		this.lastDepositAmount = lastDepositAmount;
	}

	/**
	 * override the deposit method to update the lastDepositDate and lastDepositAmount fields in addition to the inherited behavior.
	 * @param amount
	 */
	@Override
	public void deposit(double amount) {
		super.deposit(amount);
		setLastDepositAmount(amount);
		GregorianCalendar calendar=new GregorianCalendar();
		setLastDepositDate(calendar.getTime());
		System.out.println("Lastest Deposit Date is: "+getLastDepositDate().toString());
		System.out.println("Lastest Deposit Amount is: "+getLastDepositAmount());
	}
	
	/* (non-Javadoc)
	 * @see edu.cmu.heinz.ij95713.Bank.Account#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(super.equals(obj) && this.getLastDepositAmount()==((CheckingAccount)obj).getLastDepositAmount()
				&& this.getLastDepositDate().equals(((CheckingAccount)obj).getLastDepositDate()))
			return true;
		return false;
	}
}
