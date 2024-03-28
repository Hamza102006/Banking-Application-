/**
 * 
 */

/**
 * @author S. Thanush
 * Date: Dec. 2023
 * Description: Represents a chequing account from a bank that holds important information
 * 				such as balance, account id, customer information, withdraw and deposit fee
 * 				Inherits from Account class.
 * Method List:
 * - public Chequing()  // Default Constructor
 * - public Chequing(Customer c, double d, double w)  // Overloaded Constructor
 * - public double getWithdrawFee()  // Getter method for withdrawFee
 * - public void setWithdrawFee(double withdrawFee)  // Setter method for withdrawFee
 * - public double getDepositFee()  // Getter method for depositFee
 * - public void setDepositFee(double depositFee)  // Setter method for depositFee
 * - public boolean withdraw(double money)  // Method that withdraws money from balance
 * - public boolean deposit(double money)  // Method that deposits money to balance
 * - public void processRecord(String i, Customer c)  // Processes information from string into the object
 * - public String toString()  // Converts object information to a string
 * - public static void main(String[] args)  // Self-Testing Main Method
 */
public class Chequing extends Account {
	/*
	 * Private instance variables
	 */
	private double withdrawFee;
	private double depositFee;

	/**
	 * Default Constructor
	 */
	public Chequing() {
		super();
		this.withdrawFee = 0.005;
		this.depositFee = 1.25;
	}
	
	//Overloaded constructor
	public Chequing (Customer c, double d, double w) { 
		super(c);
		this.withdrawFee = w;
		this.depositFee = d;
	}

	/**
	 * @return the withdrawFee
	 */
	public double getWithdrawFee() {
		return withdrawFee;
	}

	/**
	 * @param withdrawFee the withdrawFee to set
	 */
	public void setWithdrawFee(double withdrawFee) {
		this.withdrawFee = withdrawFee;
	}

	/**
	 * @return the depositFee
	 */
	public double getDepositFee() {
		return depositFee;
	}

	/**
	 * @param depositFee the depositFee to set
	 */
	public void setDepositFee(double depositFee) {
		this.depositFee = depositFee;
	}

	//Method that withdraws money from balance
	//checks if money is less than balance, than checks if
	//withdraw method is successful for withdraw fee. If successful, it will than check
	//if withdraw method is successful for withdrawing money. If successful it will
	//return true. If any other step is not successful, it will return false.
	public boolean withdraw(double money) { 
		if (money < getBalance()) { 
			if (super.withdraw(getBalance()*this.withdrawFee)) { 
				if (super.withdraw(money)) { 
					return true;
				}
			}
		}
		return false;
	}
	
	//method to deposit money to balance.
	//If the money is not greater than the deposit fee, it will
	//return false, else it will deposit the money using
	//super class deposit fee. 
	public boolean deposit(double money) { 
		if (money > this.depositFee) { 
			super.deposit(money-this.depositFee);
			return true;
		}
		return false;
	}

	//Processes information in string into the object in the format:
	//AccountID/Balance/Withdraw Fee/Deposit Fee, than takes customer parameter and processes
	public void processRecord (String i, Customer c) { 
		String info[] = i.split("/");
		super.setAccount(Long.parseLong(info[0]));
		super.deposit(Double.parseDouble(info[1]));
		this.withdrawFee = Double.parseDouble(info[2]);
		this.depositFee = Double.parseDouble(info[3]);
		super.setCustomer(c);
	}
	
	//Method to convert object information into string
	public String toString () { 
		return super.getAccount() + "/" + super.getBalance() + "/" + this.withdrawFee + "/" + this.depositFee;
	}


	/**
	 * Self-Testing main method
	 */
	public static void main(String[] args) {
		Chequing c = new Chequing();
		boolean check;

		// Deposits 100 into balance, transaction should be true, displays results
		check = c.deposit(100);
		System.out.println("Transaction: " + check + "\nDeposit: $100\nBalance: " + c.getBalance());

		// Withdraws 50 from balance, transaction should be true, displays results
		check = c.withdraw(50);
		System.out.println("\nTransaction: " + check + "\nWithdraw: $50\nBalance: " + c.getBalance());

		// Deposits 5000 to balance, transaction should be true, displays results
		check = c.deposit(5000);
		System.out.println("\nTransaction: " + check + "\nDeposit: $5000\nBalance: " + c.getBalance());

		// Withdraws 10000 from balance, transaction should be false, displays results
		check = c.withdraw(10000);
		System.out.println("\nTransaction: " + check + "\nWithdraw: $10000\nBalance: " + c.getBalance());

		// Withdraws exact balance amount, transaction should be false, displays results
		check = c.withdraw(c.getBalance());
		System.out.println("\nTransaction: " + check + "\nWithdraw: $" + c.getBalance() + "\nBalance: " + c.getBalance());

		// Creates a new Chequing object using overloaded constructor
		Chequing c1 = new Chequing(new Customer("Tony123","BankAcoount1!","Tony","Campos","45 Some Street",6478614856L,123456789), 2.00, 1.50);

		// Deposits 100 into balance, transaction should be true, displays results
		check = c1.deposit(100);
		System.out.println("\nTransaction: " + check + "\nDeposit: $100\nBalance: " + c1.getBalance());

		// Withdraws 50 from balance, transaction should be true, displays results
		check = c1.withdraw(50);
		System.out.println("\nTransaction: " + check + "\nWithdraw: $50\nBalance: " + c1.getBalance());

		// Displays inputted customer information
		System.out.println(c1.getCustomer().toString());

		c1.setDepositFee(5);
		c1.setWithdrawFee(10);
		System.out.println(c1.getDepositFee());
		System.out.println(c1.getWithdrawFee());

		// Deposits 100 into balance, transaction should be true, displays results
		check = c1.deposit(100);
		System.out.println("\nTransaction: " + check + "\nDeposit: $100\nBalance: " + c1.getBalance());

		// Withdraws 50 from balance, transaction should be true, displays results
		check = c1.withdraw(50);
		System.out.println("\nTransaction: " + check + "\nWithdraw: $50\nBalance: " + c1.getBalance());

	}

}
