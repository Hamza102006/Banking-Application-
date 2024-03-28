import java.util.Random;

import javax.swing.JOptionPane;

/**
 * 
 */

/**
 * @author S. Thanush
 * Date: Dec. 2023
 * Description: Represents a bank account, holding important information such as balance, account number, and customer info.
 * 
 * Method List: 
 * - public Account() // Default Constructor
 * - public Account(Customer c)  // Overloaded Constructor
 * - public long generateNumber()  // Generates Account ID
 * - public boolean withdraw(double money)  // Method that withdraws money from balance
 * - public boolean deposit(double money)   // Method that deposits money to balance
 * - public Customer getCustomer()   // Getter method for customer
 * - public void setCustomer(Customer customer)  // Setter method for customer
 * - public double getBalance()   // Getter method for balance
 * - public long getAccount()   // Getter method for account
 * - public void setAccount(long account)   // Setter method for account
 * - public static void main(String[] args)   // Self-Testing Main Method
 * 
 * 
 */
public class Account {

	/*
	 * Private instances/variables
	 */
	private double balance;
	private long account;
	private Customer customer;	

	/**
	 * Default Constructor
	 */
	public Account() {
		this.balance = 0;
		this.account = generateNumber();
		this.customer = new Customer();
	}

	/*
	 * Overloaded Constructor
	 */
	public Account (Customer c) { 
		this.balance = 0;
		this.account = generateNumber();
		this.customer = c;

	}

	/*
	 * Generates Account ID
	 */
	public long generateNumber () {
		String acc = "";
		for (int i = 0; i < 12; i++) { 
			acc += String.valueOf((int)(Math.random()*9)+1);
		}
		return Long.valueOf(acc);
	}

	/*
	 * Method that withdraws money from balance
	 */
	public boolean withdraw (double money){ 
		if (money <= this.balance) { 
			this.balance -= money;
			return true;
		}
		return false;
	}
	/*
	 * Method that deposits money to balance
	 */
	public boolean deposit (double money) {
		this.balance += money;
		return true;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}


	/**
	 * @return the account
	 */
	public long getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(long account) {
		this.account = account;
	}

	/*
	 * Self-Testing Main Method	
	 */
	public static void main(String[] args) {
		
		//Creates object and prints out information to check defualt constructor
		//works
		Account a = new Account();
		System.out.println(a.getCustomer().toString());
		
		//Tests deposit method, getting customer object, and its methods
		a.deposit(100);
		a.getCustomer().setUsername("Hello");
		a.getCustomer().setPassword("hi");
		a.getCustomer().setFirstName("Thanush");
		a.getCustomer().setLastName("isAwesome");
		a.getCustomer().setAddress("45 Daviselm Dr");
		a.getCustomer().setPhone(9876543210L);
		a.getCustomer().setSin(123456789);
		JOptionPane.showMessageDialog(null, "Wait");
		System.out.println("Balance: " + a.getBalance());
		System.out.println(a.getCustomer().toString());
		
		//Tests withdraw method to see if it returns true and prints out information
		if(a.withdraw(100)) { 
			JOptionPane.showMessageDialog(null, "Withdraw Successful");
		}
		else { 
			JOptionPane.showMessageDialog(null, "Insufficient Balance");
		}
		
		System.out.println("\nBalance: " +  a.getBalance());
		
		//Tests withdraw method to see if it returns false and prints out information
		if(a.withdraw(100)) { 
			JOptionPane.showMessageDialog(null, "Withdraw Successful");
		}
		else { 
			JOptionPane.showMessageDialog(null, "Insufficient Balance");
		}
		System.out.println("\nBalance: " +  a.getBalance());
		
		//Creates customer object, adds information through overloaded constructor
		//and creates account object through overloaded constructor, than prints information
		Customer c = new Customer("Hello","hi","Tony","Campos","45 Some Street",6479789764L,123456789);
		Account a1 = new Account(c);
		a1.deposit(100.5);
		JOptionPane.showMessageDialog(null, "Wait");
		System.out.println("\nBalance: " +  a1.getBalance());
		System.out.println(a1.getCustomer().toString());
		
		//Test length of account id generation to make sure its 12 digits 
		JOptionPane.showMessageDialog(null, "Wait");	
		for (int i = 0; i < 10; i++) { 
			System.out.println("\nAccount ID:" + a.generateNumber() + "\t Length: " + String.valueOf(a.generateNumber()).length());
		}


	}

}
