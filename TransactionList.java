import java.io.*;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.text.html.StyleSheet.ListPainter;




/*
 * @author: Patel Rudra & S.Thanush
 * Date: Dec.2023
 * Description: List being able to be save as records. Allows for user to be prompted
 * 				the choice of adding, deleting, printing and even increasing the size of the array       
 * 
 * 
 * /**
 * Method List:
 * 
 * - public TransactionList() // Default Constructor
 * - public int getSize() // Getter for size
 * - public void setSize(int size) // Setter for size
 * - public boolean add(TransactionRecord record) // Method to add a record into the list
 * - public TransactionRecord[] getList() // Returns the transactionRecord list
 * - public void increaseArraySize(int newSize) // Increases the array size
 * - public boolean delete(TransactionRecord record) // Method to delete a record from the list
 * - public int linearSearch(String info) // Method to perform linear search for a transaction
 * - public void insertSort() // Method to sort list alphabetically
 * - public boolean readFile(String fileName, int replace) // Method to read transaction records from a file
 * - public void newFile(String fileName) // Method to create a new file with transaction records
 *   public String toString() // Method to display all transaction records as a string
 * - public static void main(String[] args) // Main method for self-testing
 */


public class TransactionList {
	private TransactionRecord[] list;
	private int size;
	private int maxSize;

	//Default constructor
	public TransactionList() {
		this.maxSize = 25;
		this.list = new TransactionRecord[maxSize];
		this.size = 0;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/*
	 * Method to add a record into the list 
	 * checks if the list is below the maxSize and adds 
	 * information accordingly.
	 */
	public boolean add(TransactionRecord record) {
		//if the size is below maxSize
		if (this.size < this.maxSize) {
			this.size++;//increae by 1 
			this.list [this.size -1] = record; //add to the record 
			return true;
		}
		else { 
			return false;
		}
	}

	//Returns the transactionRecord list
	public TransactionRecord[] getList() { 
		return list;
	}

	//method which allows the reenters the old data into the 
	//newly modified array size, 
	public void increaseArraySize(int newSize) {
		//object
		TransactionRecord[] newList = new TransactionRecord[newSize];

		// Copy existing records to the new list
		for (int i = 0; i < this.size; i++) {
			newList[i] = this.list[i];
		}
		//set to newList and newSize 
		this.list = newList;
		this.maxSize = newSize;
	}

	/*
	 * Method to delete a record from list
	 */
	public boolean delete (TransactionRecord record) {
		int index = linearSearch(record.toString());
		if (index == -1)  {
			return false;
		}
		for (int i = index; i < this.size - 1; i++) { 
			this.list[i] = this.list[i+1]; //copy the last record to the one to be deleted
		}

		this.size--; //decrease the valid list size
		return true; 
	}

	// Method to perform linear search for a transaction
	public int linearSearch(String info) {
		for (int i = 0; i < size; i++) {
			System.out.println(list[i].toString() + "\t" + info);
			if (list[i].toString().equalsIgnoreCase(info)) {
				return i;
			}
		}
		return -1;
	}

	//method to sort list alphabetically by make first, if make is the same, than alphabetically sorts rest of record.
	public void insertSort () { 		
		TransactionRecord curr;
		int i;
		for (int top = 0; top < size; top++) { 
			curr = this.list[top];
			for (i = top; (i > 0) && curr.getAmount() < this.list[i-1].getAmount(); i--) { 
				this.list[i] = this.list[i-1];
			}
			this.list[i] = curr;
		}
	}


	// Method to read transaction records from a file
	public boolean readFile(String fileName, int replace) {
		try {
			int infoSize = UniversalMethods.fileSize(fileName);

			//Checks to see if user wanted to replace data
			//or add on to current data, sets size accordingly.
			if (replace == 0) { 
				//initialies size of information currently held to 0
				//since data is going to be replaced
				this.size = 0;
				//initializes new max size
				increaseArraySize(infoSize);
			}
			else { 
				//initializes new max size, by adding on to current
				//max size
				increaseArraySize(infoSize + this.maxSize);
			}

			//opens file again to be read
			BufferedReader input2 = new BufferedReader(new FileReader(fileName));

			//loop through the file and save the data in the array
			while (true) { 
				//reads line from file and is stored into variable
				String s = input2.readLine();

				//Checks the line read from file to see if it contains information
				if ((!s.equalsIgnoreCase("EOF")) && (!s.equalsIgnoreCase(""))) {	
					TransactionRecord temp = new TransactionRecord();
					temp.processRecord(s);
					//System.out.println(temp.toString()); //for programmer to check to see if correct information is processed.
					add(temp);//adds to list
				}
				//breaks out of infinite loop if next line is EOF or empty,
				//meaning no more information is left 
				else { 
					break;
				}
			}
			//close the input stream
			input2.close();
			return true;

		} catch (FileNotFoundException e) { 
			return false;
		}
		catch (NullPointerException e) {
			return false;
		}
		catch (NumberFormatException e)  { 
			return false;
		}
		//error trapping that catches the possiblilty of one line of record
		//not being in the correct format.
		catch (ArrayIndexOutOfBoundsException e) { 
			return false;
		}
		catch (IOException e) { 
			e.printStackTrace();
			return false;
		}
	}

	// Method to create a new file with transaction records
	public void newFile(String fileName) {
		try {
			PrintWriter p = new PrintWriter(new FileWriter(fileName));
			for (int i = 0; i < size; i++) {
				p.println(list[i].toString());
			}
			p.print("EOF");
			p.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Method to display all transaction records as a string
	public String toString() {
		String info = "";
		//Formats the table at the top to be much more spaced out and neater (the s's at the end state what type of info it will be, with s being string)
		info += String.format("%-20s %-20s %-20s %-30s %s\n", "Account", "Type", "Amount", "Start Balance", "End Balance");
		info += "-------------------------------------------------------------------------------------------------------------------\n";

		for (int i = 0; i < size; i++) {
			
			info += String.format("%-20s %-20s $%-20.2f $%-30.2f $%.2f\n",
					this.list[i].getAccount() == 's' ? "Savings" : "Chequing", //shorter way of creating an if else statement. Where in short
																			   //if getAccount returns 's', it will now become Savings, anything else 
							this.list[i].getType(),								//after that will be Chequing now.
							this.list[i].getAmount(),
							this.list[i].getStartBal(),
							this.list[i].getEndBal());
		}
		return info;
	}

	public static void main(String[] args) {
		TransactionList transactionList = new TransactionList();

		while (true) {
			char command = JOptionPane.showInputDialog(null,
					"a - Add Record\n" +
							"d - Delete Record\n" +
							"l - Linear Search\n" +
							"m - Increase Size\n" +
							"i - Insert Sort List\n" +
							"p - Print List\n" + 
							"s - Save File\n" + 
							"n - New File\n" + 
							"q - Quit\n" ,"a").charAt(0);

			if (command == 'q') {
				break;
			}

			switch (command) {
			case 'a': {
				String record = JOptionPane.showInputDialog(null, "Enter transaction record details: ");
				TransactionRecord newRecord = new TransactionRecord(record);
				if (transactionList.add(newRecord)) {
					JOptionPane.showMessageDialog(null, "Record added successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Record could NOT be added. List is full!");
				}
				break;
			}

			case 'd': {
				String recordToDelete = JOptionPane.showInputDialog(null, "Enter record to delete: ");
				TransactionRecord record = new TransactionRecord(recordToDelete);
				if (transactionList.delete(record)) {
					JOptionPane.showMessageDialog(null, "Record deleted successfully!");
				} else {
					JOptionPane.showMessageDialog(null, "Record could not be found!");
				}
				break;
			}

			case 'l': {
				String searchInfo = JOptionPane.showInputDialog(null, "Enter the record to search for: ");
				int location = transactionList.linearSearch(searchInfo);
				if (location != -1) {
					JOptionPane.showMessageDialog(null, "Record location: " + location + "\n" + transactionList.getList()[location]);
				} else {
					JOptionPane.showMessageDialog(null, "Record not found!.");
				}
				break;
			}

			case 'i': {
				transactionList.insertSort();
				JOptionPane.showMessageDialog(null, "List sorted successfully.");
				break;
			}

			case 'p': {
				JOptionPane.showMessageDialog(null, "Transaction List:\n" + transactionList.toString());
				break;
			}
			case 's': { 
				//prompts user for file name
				String fileName = JOptionPane.showInputDialog(null,"Enter the name of file to save","testing.txt");
				//calls method to save info to file
				transactionList.newFile(fileName);
				//shows confirmation message
				JOptionPane.showMessageDialog(null, fileName + " has been saved!");
				break;
			}
			case 'n': { 
				//String array to create options for optionDialog box.
				String [] options = {"Replace","Add On"};
				//prompts user for file name
				String fileName = JOptionPane.showInputDialog(null,"Enter the name of file to save","testing.txt");
				//prompts user the option of if they want to replace current data or add on to it.
				int replace = JOptionPane.showOptionDialog(null, "Would you like to replace the current data with data "
						+ "\nfrom the file or add on to it?", "Open File", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, 0);

				//if file can be read, returns true and does code below
				if(transactionList.readFile(fileName,replace)) { 
					//shows confirmation message
					JOptionPane.showMessageDialog(null, fileName + " has been opened and read!");
				}
				//if file can not be read, returns false and does code below.
				else  { 
					//shows confirmation message
					JOptionPane.showMessageDialog(null, fileName + " could not be found OR is corrupted!"
							+ "\nCheck your file or the file name you've entered!");
				}
				break;
			}


			case 'm': { 
				//prompts user for the new list size 
				int addedSize = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Enter the Value you would like to increse the array by:"));
				//calls increase list size method to increase size
				transactionList.increaseArraySize(addedSize);
				//prints what the new list size is
				JOptionPane.showMessageDialog(null, "The New List Size has increased to : " + (addedSize));
				break;
			}
			}
		}


	}
}