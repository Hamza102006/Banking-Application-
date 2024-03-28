/**
 *
 */

/**
 * @author Rudra Patel
 * Date: Dec. 2023
 * Description: Represents a record for customer of evergreen bank.
 * Method List:
 * public Customer() - Default constructor
 * public Customer(String username, String password, String firstName, String lastName, String address, long phone, int sin) - Overload Constructor
 * public String getUsername() - getters for customer info variables
 * public String toString() - method to represent object in string
 * public void processRecord (String record) - process the data in the object
 * public static void main (String args[]) - self-testing main
 *
 *
 */
public class Customer
{

	private int size; // the actual usable size of actual object
	private int maxSize; //the maximum number of records the list can hold

	// instance data (only some here, you may need more)
	// first and last name, address, phone, social insurance number.
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private long phone;
	private int sin;


	public Customer()  // default constructor to initialize data
	{
		// intializes the data
		this.username = "";
		this.password = "";
		this.firstName = "";
		this.lastName = "";
		this.address = "";
		this.phone = 0;
		this.sin = 0;
		this.size = 0;
	}

	//Overloaded Constructor initializes the client information with specific information.
	public Customer(String username, String password, String firstName, String lastName, String address, long phone, int sin)  
	{
		//intializes the data
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
		this.sin = sin;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phone
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}

	/**
	 * @return the sin
	 */
	public int getSin() {
		return sin;
	}

	/**
	 * @param sin the sin to set
	 */
	public void setSin(int sin) {
		this.sin = sin;
	}

	/**
	 * Converts object info into string
	 */
	public String toString() {
		return username + "/" + password + "/" + firstName + "/" + lastName + "/" + address + "/" + phone + "/" + sin ;
	}

	/**
	 * Method to process record in this format (Username/Password/FirstName/LastName/address/phone/sin
	 *
	 */
	public void processRecord (String record) {
		String word[];
		word = record .split("/");
		this.username = word[0];
		this.password = word[1];
		this.firstName = word[2];
		this.lastName = word[3];
		this.address = word[4];
		this.phone = Long.parseLong(word[5]);
		this.sin = Integer.parseInt(word[6]);
	}




	//self-testing main
	public static void main (String args[])
	{
		// Self Testing Main
		// create an object based on a record
		String rec = "Tony123/BankAcoount1!/Tony/Campos/45 Some Street/6478614856/123456789";


		//create an object
		Customer sInfo = new Customer();

		//test the toString
		System.out.println(sInfo.toString());

		// process the record
		sInfo.processRecord(rec);

		//Display
		System.out.println(sInfo.toString());


		//test the setters
		sInfo.setUsername("Rudra123");
		sInfo.setPassword("Patel!");
		sInfo.setFirstName("Rudra");
		sInfo.setLastName("Patel");
		sInfo.setAddress("23 Saturn Way");
		sInfo.setPhone(4167665644L);
		sInfo.setSin(987654321);


		//Display
		System.out.println(sInfo.toString());

		//test the getters
		System.out.println(sInfo.getUsername());
		System.out.println(sInfo.getPassword());
		System.out.println(sInfo.getFirstName());
		System.out.println(sInfo.getLastName());
		System.out.println(sInfo.getAddress());
		System.out.println(sInfo.getPhone());
		System.out.println(sInfo.getSin());

	}



}