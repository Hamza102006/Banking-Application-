/**
 * 
 */

/**
 * @author S. Thanush
 * Date: Dec. 2023
 * Description: Represents a savings account from a bank. Has important information such as
 * 				balance, account id,customer information, and withdraw fee.
 * 
 * Method List:
 * - public Savings()  // Default Constructor
 * - public Savings(Customer c, double f)  // Overloaded Constructor
 * - public boolean withdraw(double money)  // Overriden withdraw method
 * - public void processRecord(String i, Customer c)  // Processes information from string into the object
 * - public String toString()  // Converts object information to a string
 * - public static void main(String[] args)  // Self-Testing Main Method
 * 				
 */
public class Savings extends Account{

	/*
	 * Private variables
	 */
	private double fee;


	/**
	 * Default constructor
	 */
	public Savings() {
		super();
		this.fee = 1.25;
	}

	/*
	 * Overloaded Constructor
	 */
	public Savings(Customer c, double f) { 
		super(c);
		this.fee = f;
	}

	/*
	 * Overriden withdraw method
	 * Charges a fee if balance is less than 2000
	 */
	public boolean withdraw (double money) {
		if (money <= getBalance()) { 
			if (getBalance() < 2000) { 
				money+= this.fee;
			}
			if (super.withdraw(money)) {
				return true;
			}
		}
		return false;
	}

	//Processes information in string into the object in the format:
	//AccountID/Balance/fee, than takes customer parameter and processes
	public void processRecord (String i, Customer c) { 
		String info[] = i.split("/");
		super.setAccount(Long.parseLong(info[0]));
		super.deposit(Double.parseDouble(info[1]));
		this.fee = Double.parseDouble(info[2]);
		super.setCustomer(c);
	}
	
	
	//Converts object info to string
	public String toString() { 
		return super.getAccount() + "/" + super.getBalance() + "/" + this.fee;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Creates saving account object
		Savings s = new Savings();
		//Boolean variable to check if transaction has gone through
		boolean check;

		//Deposits 100 into balance, transaction should be true, displays results
		check = s.deposit(100);
		System.out.println("Transaction: " + check + "\nDeposit: $100\nBalance: " + s.getBalance());

		//Withdraws 50 from balance, transaction should be true, displays results
		check = s.withdraw(50);
		System.out.println("\nTransaction: " + check + "\nWithdraw: $50\nBalance: " + s.getBalance());

		//Deposit 5000 to balance, transaction should be true, displays results
		check = s.deposit(5000);
		System.out.println("\nTransaction: " + check + "\nDeposit: $5000\nBalance: " + s.getBalance());

		//Withdraw 10000 from balance, transaction should be false, displays results
		check = s.withdraw(10000);
		System.out.println("\nTransaction: " + check + "\nWithdraw: $10000\nBalance: " + s.getBalance());

		//Withdraw exact balance amount, transaction should be false, displays results
		check = s.withdraw(s.getBalance());
		System.out.println("\nTransaction: " + check + "\nWithdraw: $" + s.getBalance() + "\nBalance: " + s.getBalance());

		//Creates new savings object using overloaded constructor
		Savings s1 = new Savings(new Customer("Tony123","BankAcoount1!","Tony","Campos","45 Some Street",6478614856L,123456789),2.00);

		//Deposits 100 into balance, transaction should be true, displays results
		check = s1.deposit(100);
		System.out.println("\nTransaction: " + check + "\nDeposit: $100\nBalance: " + s1.getBalance());

		//Withdraws 50 from balance, transaction should be true, displays results
		check = s1.withdraw(50);
		System.out.println("\nTransaction: " + check + "\nWithdraw: $50\nBalance: " + s1.getBalance());

		//Displays inputted customer information
		System.out.println(s1.getCustomer().toString());

		//test
		s1.processRecord("123456789012/5.5/1.25",s.getCustomer());
		System.out.println("\n" + s1.toString() + "\n" + 
				s1.getCustomer().toString());

	}

}
