import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 */

/**
 * @author S. Thanush
 * Date: Dec. 2023
 * Description: Class that contains all methods that are used by a multitude of classes within this
 * 				project.
 * 
 * Method List:
 * - public static void openAccount(int location, Customer c, Savings s, Chequing ch)
 * - public static int check(String check, int index, String fileName)
 * - public static int checkPassword(String password, int location)
 * - public static int fileSize(String fileName)
 * - public static int checkLogin(String username, String password)
 * - public static void saveInfo(Savings s, Chequing ch)
 * - public static void writeFile(String info, String fileName)
 * - public static void main(String[] args)
 *
 */
public class UniversalMethods {

	/**
	 * 
	 */
	public UniversalMethods() {
		// TODO Auto-generated constructor stub
	}

	//Method to open all "information" files and process that information
	//into objects accordingly. In short, open the user's account.
	public static void openAccount(int location, Customer c, Savings s, Chequing ch) { 
		try {
			
			//Opens file to be read
			BufferedReader input = new BufferedReader(new FileReader ("CustomerList.txt"));
			//skips every line and stops right before the location
			for (int i = 0; i < location; i++) { 
				input.readLine();		
			}
			//reads and processes info
			c.processRecord(input.readLine());
			//closes file
			input.close();
			
			//opens file to be read
			BufferedReader input1 = new BufferedReader(new FileReader ("InfoList.txt"));
			
			//skips every line and stops right before location
			for (int i = 0; i < location; i++) { 
				input1.readLine();	
				input1.readLine();		
			}
			
			//reads and process info
			ch.processRecord(input1.readLine(),c);
			s.processRecord(input1.readLine(),c);
			//closes file
			input1.close();
		
			//catches error
		}catch (IOException e) { 
			e.printStackTrace();
		}
	}

	//Method to check if customer entered information already exists within "database"
	//returns location with CustomerList.txt file if found, else returns -1 if not found
	public static int check (String check, int index, String fileName) { 
		try {
			//gets file size from filesize method
			int size = fileSize(fileName);
			
			//opens file to be read
			BufferedReader input2 = new BufferedReader(new FileReader(fileName));
			//for loop that checks to see if the user entered info already exists within
			//"database", if yes it will return location, if not, it will return -1.
			for (int i = 0; i < size; i++) { 
				//splits info into array
				String info[] = input2.readLine().split("/");
				
				//hard coded to wear index 0 is username , index 1 is password,... etc
				if (check.equals(info[index])) { 
					//System.out.println(check + " " + info[index] + " \nLocation" + i);
					return i;
				}
			}
			//closes file
			input2.close();
			return -1;
			//catches error
		} catch (IOException e) {
			return -1;
		}
	}


	//Method to check if password at certain line of code is the same as user entered
	//password (seperate method required due to possible chance of multiple users with the 
	//same password)
	public static int checkPassword (String password, int location) { 
		try  { 
			
			//opens file to be read
			BufferedReader input = new BufferedReader(new FileReader("CustomerList.txt"));
			
			//skips every line right before the location
			for (int i = 0; i < location; i++) { 
				input.readLine();
			}
			
			//splits that info into an array
			String check[] = input.readLine().split("/");
			//closes file
			input.close();
			//hard coded to wear index 1 is password, and checks
			//to see if use entered password is the same, returns original
			//location value if true,if false returns -1.
			if (password.equals(check[1]))  { 
				return location;
			}
			return -1;
			//catches error
		} catch (IOException e) { 
			return -1;
		}
	}

	//Method to calculate the number of lines before file reaches EOF.
	//Returns size if file can be found, or -1 if it cant be found.
	public static int fileSize (String fileName) { 
		try {
			//open the file in fileName to read
			BufferedReader input = new BufferedReader(new FileReader (fileName));
			int size = 0;
			//finds max size of record list 
			while (!input.readLine().equalsIgnoreCase("EOF")) { 
				size++;
			}
			//closes file
			input.close();
			
			//returns size of file
			return size;

		} catch (IOException e) { 
			return -1;
		}
	}

	//Checks if entered username and password is found within "information" held files using check methods
	//Returns location within file if found, else, returns -1;
	public static int checkLogin (String username, String password) { 
		
		//gets location of username within file
		int location = check(username,0, "CustomerList.txt");
		//gets location of password within file
		int location2 = checkPassword(password,location);
		
		//if username and password location are the same and are greater than -1 
		//meaning they exist within the file, it will return the location of its
		//info
		if ((location == location2) && location > -1 && location2 > -1) { 
			return location;
		}
		
		//else,it will return -1
		return -1;
	}


	//Method to save information all related to user into "database"
	//if user logs out or quits program. can also be used for registering 
	//process.
	public static void saveInfo (Savings s, Chequing ch) { 
		try {
			
			//declares string variables
			String customerInfo = "";
			String moneyInfo = "";
			//open the file in fileName to read
			BufferedReader inputRead = new BufferedReader(new FileReader ("CustomerList.txt"));
			
			//gets file size
			int size = fileSize("CustomerList.txt");
			
			//reads every single line of txt info into variable
			for (int i = 0; i < size; i++) {
				customerInfo += inputRead.readLine() + "\n";
			}
			//closes file
			inputRead.close();

			//open the file in fileName to read
			BufferedReader input2 = new BufferedReader(new FileReader ("InfoList.txt"));
			
			//reads every single line of txt into variable
			for (int i = 0; i < size; i++) { 
				moneyInfo += input2.readLine() + "\n";	
				moneyInfo += input2.readLine() + "\n";	
			}
			//closes file
			input2.close();
			
			//gets location of customer username
			int location = check(s.getCustomer().getUsername(),0,"CustomerList.txt");
			//System.out.println("Location For Username: " + location);
			
			//if the user already exists as a customer, than it will
			//update the information within the databse files accordingly 
			//exactly at location within file
			if (location > -1) { 
				//splits info into array
				String cusUpdate[] = customerInfo.split("\n");
				String moneyUpdate[] = moneyInfo.split("\n");
				//updates info at exact location
				cusUpdate[location] = s.getCustomer().toString();
				//rejoins array of info into string
				customerInfo = String.join("\n", cusUpdate);
				
				//updates info at exact location
				moneyUpdate[(location*2)] = ch.toString();
				moneyUpdate[(location*2)+1] = s.toString();
				//rejoins array of into into string
				moneyInfo = String.join("\n",moneyUpdate);
				
				//Self-Testing
				//System.out.println("Money Info:" + moneyInfo);
				//System.out.println("Customer Info:" + customerInfo);
			} 
			
			//If user doesn't exist, meaning they've just registered, it will
			//add their new information at the end of the "Database" files
			else { 
				customerInfo += s.getCustomer().toString();
				moneyInfo += ch.toString() + "\n" + s.toString();
			}
			
			//calls writeFile method to update database files
			writeFile(customerInfo,"CustomerList.txt");
			writeFile(moneyInfo,"InfoList.txt");
			
			//catches error
		}catch (IOException e) {

		}
	}

	//Method that writes information into a file
	public static void writeFile (String info, String fileName) { 
		try  { 
			//creates new file to write to
			PrintWriter wFile = new PrintWriter(new FileWriter(fileName));
			//writes info into file
			wFile.println(info);
			//writes eof to indicate end of file
			wFile.print("EOF");
			//closes file
			wFile.close();
			//catches error
		} catch (IOException e) { 

		}
	}

	public static void main(String[] args) {
		//random objects created for testing
		Customer c = new Customer();
		Savings s = new Savings();
		Chequing ch = new Chequing();
		
		//test open account method
		openAccount(4,c,s,ch);
		System.out.println(c.toString());
		System.out.println(s.toString());
		System.out.println(ch.toString());
		
		//checks if this information is their within file, should return 4 (greater than -1)
		int check = check("123",0,"CustomerList.txt");
		System.out.println(check);
		
		//checks if this information is same as location within file, should return 4 (greater than -1)
		check = checkPassword(c.getPassword(),4);
		System.out.println(check);
		
		//checks file size of text file, should return 5
		int size = fileSize("CustomerList.txt");
		System.out.println(size);
		
		//checks to see if username and password is within databse, should return -1
		check = checkLogin(c.getUsername(),"random");
		System.out.println(check);
		
		//orignally was 123, password should change
		s.getCustomer().setPassword("changed");
		ch.getCustomer().setPassword("changed");

		//saves info, need to check both txt fils to see if info saved correctly, in short, password should have changed
		//from 123 to changed
		saveInfo(s,ch);
		
		//tests write file method
		writeFile("hello self-testing info here", "Self-Testing.txt");

	}

}
