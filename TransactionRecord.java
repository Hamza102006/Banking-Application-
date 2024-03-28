import java.io.IOException;

/**
 * 
 */

/**
 * Author; S. Thanush
 * Date: Nov. 2023
 * Description. Represents objects containing vehicle records 
 * 
 * Method List:
 * - public TransactionRecord() // Default Constructor
 * - public TransactionRecord(String info) // Overloaded Constructor
 * - public char getAccount() // Getter for account
 * - public void setAccount(char account) // Setter for account
 * - public String getType() // Getter for type
 * - public void setType(String type) // Setter for type
 * - public double getAmount() // Getter for amount
 * - public void setAmount(double amount) // Setter for amount
 * - public double getStartBal() // Getter for start balance
 * - public void setStartBal(double startBal) // Setter for start balance
 * - public double getEndBal() // Getter for end balance
 * - public void setEndBal(double endBal) // Setter for end balance
 * - public String toString() // Method to convert object to string
 * - public void processRecord(String record) // Method that processes a record
 * - public static void main(String[] args) // Main method for self-testing
 */
public class TransactionRecord {

	/**
	 * Private instances/variables
	 */
	private char account;
	private String type;
	private double amount,startBal,endBal;

	public TransactionRecord() {
		this.account = ' ';
		this.type = "";
		this.amount = 0;
		this.startBal = 0;
		this.endBal = 0;
	}

	public TransactionRecord(String info) { 
		processRecord(info);
	}

	/**
	 * @return the account
	 */
	public char getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(char account) {
		this.account = account;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the startBal
	 */
	public double getStartBal() {
		return startBal;
	}

	/**
	 * @param startBal the startBal to set
	 */
	public void setStartBal(double startBal) {
		this.startBal = startBal;
	}

	/**
	 * @return the endBal
	 */
	public double getEndBal() {
		return endBal;
	}

	/**
	 * @param endBal the endBal to set
	 */
	public void setEndBal(double endBal) {
		this.endBal = endBal;
	}

	//create toString method 
	public String toString() {
		String accountType = ""; //string 
		//convert the char to a word

		switch (this.account) {
		case 's':
			accountType = "Savings";
			break;
		case 'c':
			accountType = "Chequing";
			break;
		default:
			accountType = "Unknown";
			break;
		}
		

		//return statement 
		return accountType +  "/" + this.type + "/" + this.amount
				+ "/" + this.startBal + "/" + this.endBal;
	}

	//METHOD THAT WILL PROCESS RECORD 
	// Record format: Account/Type/Amount/Start Balance/End Balance
	public void processRecord (String record) {
		
			String info[];
			info = record.split("/"); //splits the record in to elements 
			this.account = info[0].toLowerCase().charAt(0);
			this.type = info[1];   // assign the elements into different private data
			this.amount = Double.parseDouble(info[2]);
			this.startBal = Double.parseDouble(info[3]);
			this.endBal = Double.parseDouble(info[4]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 // Create an object based on a record
	    String information = "s/Deposit/5000/2500/7500";

	    // Create object
	    TransactionRecord info = new TransactionRecord(); // Test the constructor

	    // Test toString
	    System.out.println(info.toString());
	    info.processRecord(information);
	    System.out.println(info.toString()); // Test with data

	    // Test the setters
	    info.setAccount('c');
	    info.setType("Withdraw");
	    info.setAmount(3000);
	    info.setStartBal(4000);
	    info.setEndBal(1000);

	    // Display
	    System.out.println(info.toString()); // Test with data

	    // Test the getters
	    System.out.println(info.getAccount()); // Test with data
	    System.out.println(info.getType()); // Test with data
	    System.out.println(info.getAmount()); // Test with data
	    System.out.println(info.getStartBal()); // Test with data
	    System.out.println(info.getEndBal()); // Test with data
	}

}
