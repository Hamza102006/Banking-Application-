/**
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;



/*
 * Author;Hamza Khan & S.Thanush
 * Date; Dec 2023
 * Desciption; User Home Menu where all details can be found of the user and edit thier account details 
 *  
 * <METHODS>
 * 
 * 
 * 	private String getCurrentDate() { - getting date
 * 
 * 
 * 	private String getCurrentTime() { - getting time
 * 
 * 
 * 	private void placeComponents(JPanel panel,Savings s, Chequing ch) { - components
 * 
 * 
 * 	private void updateBalanceLabels() { - updating balances
 * 
 * 	public void actionPerformed (ActionEvent e){ - listener
 * 
 * 
 * 
 * <NEW THINGS LEARNED>
 * 
 * [setBorderPainted and setFocusPainted]
 *  
 *  - These two functions were learned and implemented into
 *  the code to make the coe much more visually appealing and user friendly 
 *  the borderpainted set to false makes sure that the button has no 
 *  border on it making it look much cleaner and better. While setFocusPainted 
 *  set to false makes sure that when the button is clicked there is not dotted 
 *  border which appears when the button is clicked hence the title 'focus'. Overall,
 *  these functions make a much more user friendly experience.
 *  
 *  LINKS; https://stackoverflow.com/questions/12386988/painted-focus-on-jbuttons
 *         https://stackoverflow.com/questions/8416295/component-painting-outside-custom-border
 *         
 * 
 * [LocalDateTime and DateTimeFormatter]
 * 
 * - When the user eneters their menu in the top left corner the date is displayed 
 *  to get this date the function LocalDateTime and DateTimeFormatter are used
 *  the local date time function aquires the current date/time while the formatter 
 *  allows me to choose how I want to display the obtained information 
 *  and then I can display the time within my frame by calling the information.
 *  Overall this just makes the GUI more friendly.
 *  
 *  LINKS; https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
 *         https://docs.oracle.com/javase/8/docs/api/java/time/format/class-use/DateTimeFormatter.html#:~:text=The%20main%20API%20for%20dates%2C%20times%2C%20instants%2C%20and%20durations.&text=Generic%20API%20for%20calendar%20systems%20other%20than%20the%20default%20ISO.&text=Provides%20classes%20to%20print%20and%20parse%20dates%20and%20times.
 *         https://www.javatpoint.com/java-get-current-date#:~:text=The%20LocalDateTime.,is%20included%20in%20JDK%201.8.
 *         https://www.youtube.com/watch?v=OUJ7gOg7Uo8
 *         
 *         
 *  [JRadioButton]
 *  
 *  - The JRadioButtons were used serval times within my code to be able to 
 *  select a desired selection. For example the cheq or sav accout. The JRadiobuttons 
 *  help make the GUI much more interactive and friendly instead of using buttons 
 *  all the time. This code was fairly straightforward as it was very simmilar to a regular 
 *  button.
 *  
 *  LINKS; https://docs.oracle.com/javase/8/docs/api/javax/swing/JRadioButton.html
 *         https://www.javatpoint.com/java-jradiobutton
 *         
 * 
 * [ButtonGroup Function]
 * 
 * - Since I was using the muliple JRadioButtons within my code, I came across the issue
 * where I was able to select the both buttons at once. In order to fix this issue 
 * I used the buttongroup function this made sure that only one button was able to be selected
 * this was done by adding the radio button into the new ButtonGroup instance  
 * 
 * LINKS; https://www.geeksforgeeks.org/jradiobutton-java-swing/
 *        https://stackoverflow.com/questions/2301123/how-do-i-use-the-button-group-swing-control-in-java
 *        
 *        
 * [setWrapStyleWord and setLineWrap]
 * 
 * - These were an additional feature added within my code as a precaution as 
 * these functions make sure that the text within the JTextArea does not pass the size of
 * JTextArea. If it does the text would go to the line below and get wrapped as well.
 * 
 * LINKS; https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/javax/swing/JTextArea.html
 *        https://stackoverflow.com/questions/6052821/jtextarea-how-to-wrap-text-by-words-not-characters
 * 
 *  [setVerticalScrollBarPolicy and setHorizontalScrollBarPolicy]
 *  
 *  - These additions were added to the JTextArea to allow scroll bars to
 *  be implemented both vertically and horizontally
 *  
 *  LINKS; https://docs.oracle.com/javase/7/docs/api/javax/swing/JScrollPane.html
 *  
 *  
 *  
 *  [KeyListener] S. Thanush
 *  - This additional feature was added to allow for more easy error prevention. 
 *  KeyListener allowed for only certain keys to be pressed instead of originally having NumberFormatException
 *  error and such others. These additional feature was only done to jtextfields, not dialog boxs. In some 
 *  jtextfields letters was prevented as an input, but slashes and periods were still allowed, as I did not
 *  know how to go around this issue. 
 *  
 *  LINKS: https://stackoverflow.com/questions/11093326/restricting-jtextfield-input-to-integers
 *  		https://www.youtube.com/watch?v=1HyMztaV4ME
 *  		https://www.youtube.com/watch?v=xk4_1vDrzzo&t=31884s
 *  
 *  
 */


public class UserHomeMenu implements ActionListener {


	//private variables 

	private JButton withdraw, deposit, search, Sort, Delete, Export, moneyExchange,Import, moneyTransfer, profileInfo, getHelp, logout;
	private JFrame frame;
	private JRadioButton chequingRadioButton, savingsRadioButton;
	private JLabel sav,cheq,total; //Declared before placeComponents method so it can be updated in other methods as well
	private Savings s;
	private Chequing ch;
	private JTextArea recordsArea;
	private TransactionList list;
	private DecimalFormat d;

	public UserHomeMenu(Savings s, Chequing ch) {

		//Created a deicmal format to prevent long running decimals
		d = new DecimalFormat("0.00");
		//initialize private instances to input parameters
		this.s = s;
		this.ch = ch;
		//initializes list
		this.list = new TransactionList();

		//creating frame
		frame = new JFrame("User Home");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 700);
		frame.setLocation(250,10);

		//creating a panel which will hold all the components
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel,this.s,this.ch);

		//set visible and not resizeable 
		frame.setVisible(true);	
		frame.setResizable(false);
	}


	//method to get the current date 
	private String getCurrentDate() {

		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();

		// creating a date formatter with the pattern "yyyy-MM-dd"
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		// properly formatting the current date using formatter above
		return "Date: " + dateFormatter.format(now);
	}

	//method to get the current time 
	private String getCurrentTime() {

		// Get the current date and time
		LocalDateTime now = LocalDateTime.now();

		// creating a time formatter with the pattern "HH:mm:ss"
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		// properly formatting the current time using the formatter above 
		return "Time: " + timeFormatter.format(now);
	}

	//method which holds all the components 
	private void placeComponents(JPanel panel,Savings s, Chequing ch) {

		//set panel layout null and change backround colour 
		panel.setLayout(null);
		panel.setBackground(new Color(0xf3ede3));		

		//Company logo in the top left corner 
		ImageIcon logoIcon = new ImageIcon("LOGOSMALL.png");
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(-45, -50, 200, 200); // Adjust the position and size
		panel.add(logoLabel); //add

		//title to welcome the user 
		JLabel welcomeTitle = new JLabel("Welcome Back , " + s.getCustomer().getFirstName()); //get cutomers name and details 
		welcomeTitle.setForeground(new Color(0xd8ae5e));
		Font titleFont = new Font("Monotype Corsiva", Font.BOLD, 40);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(250, 25, 400, 50);
		panel.add(welcomeTitle);

		//displaying the date on the frame
		JLabel dateLabel = new JLabel(getCurrentDate());
		dateLabel.setForeground(new Color(0xd8ae5e));
		Font dateFont = new Font("Arial", Font.BOLD, 11);
		dateLabel.setFont(dateFont);
		dateLabel.setBounds(10, -90, 400, 400);
		panel.add(dateLabel);

		//displaying the time on the frame
		JLabel timeLabel = new JLabel(getCurrentTime());
		timeLabel.setForeground(new Color(0xd8ae5e));
		Font timeFont = new Font("Arial", Font.BOLD, 11);
		timeLabel.setFont(timeFont);
		timeLabel.setBounds(10, -70, 400, 400);
		panel.add(timeLabel);

		//JLabel used and formatted as green block to make frame visually appealing 
		//(Horizontal Block)
		JLabel greenBarHorizontal = new JLabel();
		greenBarHorizontal.setOpaque(true);
		greenBarHorizontal.setBackground(new Color(0x1e3b3d)); // Green color
		greenBarHorizontal.setBounds(0, 0, 900, 95); // Adjust the position and size
		panel.add(greenBarHorizontal);

		//JLabel used and formatted as green block to make frame visually appealing 
		//(Vertical Block)
		JLabel greenBarVertical = new JLabel();
		greenBarVertical.setOpaque(true);
		greenBarVertical.setBackground(new Color(0x1e3b3d)); // Green color
		greenBarVertical.setBounds(0, 0, 105, 700); // Adjust the position and size
		panel.add(greenBarVertical);


		//displaying the total funds the user has in both chequing and savings combined
		//using decimal format 
		total = new JLabel("Total Funds/Balance:    $" + d.format(s.getBalance()+ch.getBalance()));
		total.setBounds(125, 75, 600, 100);
		Font one = total.getFont();
		total.setFont(new Font(one.getName(), Font.BOLD, 15));

		//displaying the total chequing funds the user has in
		//using decimal format 
		cheq = new JLabel("Total Chequing Balance:    $" + d.format(ch.getBalance()));
		cheq.setBounds(125, 100, 600, 100);
		Font two = cheq.getFont();
		cheq.setFont(new Font(two.getName(), Font.BOLD, 12));

		//displaying the total savings funds the user has in
		//using decimal format 
		sav = new JLabel("Total Savings Balance:    $" + d.format(s.getBalance()));
		sav.setBounds(125, 125, 600, 100);
		Font three = sav.getFont();
		sav.setFont(new Font(three.getName(), Font.BOLD, 12));

		//message to show user to select which account to manage
		JLabel directions = new JLabel("Select Account to Manage;");
		directions.setBounds(125, 200, 600, 100);
		Font four = sav.getFont();
		directions.setFont(new Font(four.getName(), Font.BOLD, 12));	

		//create a savings JRadioButton
		savingsRadioButton = new JRadioButton("Savings");
		savingsRadioButton.setBounds(125, 265, 100, 30);

		//create a chequing JRadioButton
		chequingRadioButton = new JRadioButton("Chequing");
		chequingRadioButton.setBounds(225, 265, 100, 30);

		// Create a ButtonGroup to ensure only one radio button is selected at a time
		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(savingsRadioButton);
		accountGroup.add(chequingRadioButton);


		//Withdraw BUTTON
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(350, 265, 100, 30);
		withdraw.setBorderPainted(false);
		withdraw.setFocusPainted(false);

		//Deposit BUTTON
		deposit = new JButton("Deposit");
		deposit.setBounds(475, 265, 100, 30);
		deposit.setBorderPainted(false);
		deposit.setFocusPainted(false);


		//message to show where recent transactions are
		JLabel transactions = new JLabel("Recent Transactions;");
		transactions.setBounds(125, 275, 600, 100);
		Font five = transactions.getFont();
		transactions.setFont(new Font(five.getName(), Font.BOLD, 12));

		//JTextArea to show the transactions 
		recordsArea = new JTextArea(20, 40);
		recordsArea.setWrapStyleWord(true);
		recordsArea.setLineWrap(true);
		recordsArea.setEditable(false);
		recordsArea.setText(String.format("%-20s %-20s %-20s %-30s %s\n", "Account", "Type", "Amount", "Start Balance", "End Balance"));

		//adding scroll panes vertcally and horizontally to the JTextArea
		JScrollPane scrollPane = new JScrollPane(recordsArea);
		scrollPane.setBounds(125, 335, 600, 200); // Adjust the bounds as needed
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);


		//Search BUTTON
		search = new JButton("Search");
		search.setBounds(125, 550, 100, 30);

		//THANUSH SUPERMAN
		//DECIDE IF YOU WANT THIS COLOUR OR WHITE FOR ALL THE BUTTONS BELOW

		//search.setBackground(new Color(0x1e3b3d)); // Set the background color
		//search.setForeground(new Color(0xd8ae5e)); // Set text color
		search.setBorderPainted(false);
		search.setFocusPainted(false);


		//Sort BUTTON
		Sort = new JButton("Sort");
		Sort.setBounds(250, 550, 100, 30);
		//Sort.setBackground(new Color(0x1e3b3d)); // Set the background color
		//Sort.setForeground(new Color(0xd8ae5e)); // Set text color
		Sort.setBorderPainted(false);
		Sort.setFocusPainted(false);



		//Delete BUTTON
		Delete = new JButton("Delete");
		Delete.setBounds(375, 550, 100, 30);
		//Delete.setBackground(new Color(0x1e3b3d)); // Set the background color
		//Delete.setForeground(new Color(0xd8ae5e)); // Set text color
		Delete.setBorderPainted(false);
		Delete.setFocusPainted(false);



		//Export List BUTTON
		Export = new JButton("Export");
		Export.setBounds(625, 550, 100, 30);
		//Export.setBackground(new Color(0x1e3b3d)); // Set the background color
		//Export.setForeground(new Color(0xd8ae5e)); // Set text color
		Export.setBorderPainted(false);
		Export.setFocusPainted(false);


		//Export List BUTTON
		Import = new JButton("Import");
		Import.setBounds(500, 550, 100, 30);
		//Import.setBackground(new Color(0x1e3b3d)); // Set the background color
		//Import.setForeground(new Color(0xd8ae5e)); // Set text color
		Import.setBorderPainted(false);
		Import.setFocusPainted(false);

		//money exchange button 
		moneyExchange = new JButton("");
		moneyExchange.setIcon(new ImageIcon("curr.png")); //image for button
		moneyExchange.setBackground(new Color(0x1e3b3d));
		moneyExchange.setForeground(new Color(0x1e3b3d));
		moneyExchange.setBorderPainted(false);
		moneyExchange.setFocusPainted(false);
		moneyExchange.setBounds(825, 600, 50, 50);

		//money transfer button
		moneyTransfer = new JButton("");
		moneyTransfer.setIcon(new ImageIcon("eTransfer.png")); //image for button
		moneyTransfer.setBackground(new Color(0x1e3b3d));
		moneyTransfer.setForeground(new Color(0x1e3b3d));
		moneyTransfer.setBorderPainted(false);
		moneyTransfer.setFocusPainted(false);
		moneyTransfer.setBounds(625, 600, 50, 50);

		//Profile Info BUTTON
		profileInfo = new JButton("");
		profileInfo.setIcon(new ImageIcon("PF.png")); //image for button
		profileInfo.setBounds(825, 100, 50, 50);

		//Help BUTTON
		getHelp = new JButton("");
		getHelp.setIcon(new ImageIcon("HM.png")); //image for button
		getHelp.setBounds(825, 150, 50, 50);

		//Logout BUTTON
		logout = new JButton("");
		logout.setIcon(new ImageIcon("logout.png")); //image for button
		logout.setBounds(825, 200, 50, 50);

		//text for profile info button
		JLabel pfText = new JLabel("Profile Info");
		pfText.setBounds(755, 75, 600, 100);
		Font six = pfText.getFont();
		pfText.setFont(new Font(six.getName(), Font.BOLD, 12));

		//text for help button
		JLabel helpText = new JLabel("Help");
		helpText.setBounds(790, 125, 600, 100);
		Font seven = helpText.getFont();
		helpText.setFont(new Font(seven.getName(), Font.BOLD, 12));

		//text for log out button
		JLabel lgText = new JLabel("Log-Out");
		lgText.setBounds(770, 175, 600, 100);
		Font eight = lgText.getFont();
		lgText.setFont(new Font(eight.getName(), Font.BOLD, 12));

		//text for currency exchange button
		JLabel ceText = new JLabel("Currency-Exchange");
		ceText.setBounds(700, 575, 600, 100);
		Font nine = ceText.getFont();
		ceText.setFont(new Font(nine.getName(), Font.BOLD, 12));

		//text for money transfer button
		JLabel mtText = new JLabel("Money-Transfer");
		mtText.setBounds(525, 575, 600, 100);
		Font ten = mtText.getFont();
		mtText.setFont(new Font(ten.getName(), Font.BOLD, 12));

		//adding all the buttons to the panel
		panel.add(total);
		panel.add(cheq);
		panel.add(sav);
		panel.add(directions);
		panel.add(savingsRadioButton);
		panel.add(chequingRadioButton);
		panel.add(transactions);
		panel.add(scrollPane);
		panel.add(search);
		panel.add(Sort);
		panel.add(Delete);
		panel.add(Export);
		panel.add(Import);
		panel.add(moneyExchange);
		panel.add(moneyTransfer);
		panel.add(profileInfo);
		panel.add(getHelp);
		panel.add(logout);
		panel.add(withdraw);
		panel.add(deposit);
		panel.add(pfText);
		panel.add(helpText);
		panel.add(lgText);
		panel.add(ceText);
		panel.add(mtText);

		//action Listener 
		search.addActionListener(this);
		Sort.addActionListener(this);
		Delete.addActionListener(this);
		Export.addActionListener(this);
		moneyExchange.addActionListener(this);
		moneyTransfer.addActionListener(this);
		profileInfo.addActionListener(this);
		getHelp.addActionListener(this);
		logout.addActionListener(this);
		Import.addActionListener(this);
		withdraw.addActionListener(this);
		deposit.addActionListener(this); 



	}



	//THANUSH SUPERMAN 
	//COMMNETING PLZ THE THINGS BELOW 



	public void actionPerformed (ActionEvent e){


		//If user hits search
		if (e.getSource()== search){
			try {

				//prompts user for record they want to find
				String info = JOptionPane.showInputDialog(frame, "Enter the transaction you want to find using this format!\n(Account/TransactionType/Amount/StartBalance/EndBalance)!");

				//creates temporary transactionRecord
				TransactionRecord temp = new TransactionRecord();

				//processes user entered information
				temp.processRecord(info);
				//gets location of user entered information using linearSearch method
				int location = this.list.linearSearch(temp.toString());

				//if location is greater than -1, than it was found within list, and will
				//display that info accordingly
				if (location > -1) { 
					JOptionPane.showMessageDialog(frame,this.list.getList()[location]);
				}
				//else it will display message accordingly
				else { 
					JOptionPane.showMessageDialog(frame,"Transaction could not be found!");
				}

				//catches error if user enters incorrect format or nothing, displays error message
			} catch (StringIndexOutOfBoundsException error) {
				JOptionPane.showMessageDialog(frame,"Please enter transaction in the correct format!","ERROR",JOptionPane.ERROR_MESSAGE);
				//catches error if user enters incorrect format or nothing, displays error message
			} catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(frame,"Please enter transaction in the correct format!","ERROR",JOptionPane.ERROR_MESSAGE);
				//catches error if user enters incorrect format or nothing, displays error message
			}catch (ArrayIndexOutOfBoundsException error) { 
				JOptionPane.showMessageDialog(frame,"Please enter transaction in the correct format!","ERROR",JOptionPane.ERROR_MESSAGE);
				//catches error if user hits cancel or x
			}	catch (Exception error) { 
				//error.printStackTrace();
			}
		}





		//if user hits sort
		if (e.getSource()== Sort){
			//calls insertsort method that sorts based of balance in ascending order
			this.list.insertSort();
			//updates jtextarea
			recordsArea.setText(this.list.toString());
		}

		//if user hits delete 
		if (e.getSource()== Delete){
			try { 

				//prompts user for record
				String info = JOptionPane.showInputDialog(frame, "Enter the transaction to be deleted using this format!\n(Account/TransactionType/Amount/StartBalance/EndBalance)!");

				//creates temporary transactionRecord
				TransactionRecord temp = new TransactionRecord();

				//processes info into object
				temp.processRecord(info);
				//JOptionPane.showMessageDialog(frame, "Please enter the transaction in the correct format!", "ERROR",JOptionPane.ERROR_MESSAGE);

				//System.out.println(temp.toString()); for testing
				//if record can be deleted, it will display confirmation message
				if(this.list.delete(temp)) { 
					JOptionPane.showMessageDialog(frame, "Transaction Deleted From History!!");
				}
				//if record cant be deleted, it will display message
				else { 
					JOptionPane.showMessageDialog(frame, "Transaction could not be found!");
				}
				//update jtextarea
				recordsArea.setText(this.list.toString());

				//catches error if user enters incorrect format or nothing, displays error message
			} catch (StringIndexOutOfBoundsException error) {
				JOptionPane.showMessageDialog(frame,"Please enter transaction in the correct format!","ERROR",JOptionPane.ERROR_MESSAGE);
				//catches error if user enters incorrect format or nothing, displays error message
			}catch (ArrayIndexOutOfBoundsException error) {
				JOptionPane.showMessageDialog(frame,"Please enter transaction in the correct format!","ERROR",JOptionPane.ERROR_MESSAGE);
				//catches error if user enters incorrect format or nothing, displays error message
			} catch (NumberFormatException error) {
				JOptionPane.showMessageDialog(frame,"Please enter transaction in the correct format!","ERROR",JOptionPane.ERROR_MESSAGE);
				//catches error if user hits x or cancel
			}catch (Exception error) { 
				//error.printStackTrace();
			}
		}

		//if user hits export
		if (e.getSource()== Export){
			try {
				//prompts user for filename to be saved
				String fileName = JOptionPane.showInputDialog(frame, "Enter the name of the file to be exported");
				//calls new file method
				this.list.newFile(fileName);
				//displays confirmation message
				JOptionPane.showMessageDialog(frame, "File Exported!");

				//Try and catch statement just in case user hits export and
				//wants to hit cancel or x, error will be caught
			} catch (Exception error) { 

			}
		}

		if (e.getSource() == Import) {
			try { 
				
				//prompts user for name of file
				String fileName = JOptionPane.showInputDialog(frame, "Enter the name of the file to be imported");
				//String array to create options for optionDialog box.
				String [] options = {"Replace","Add On"};
				
				//prompts user the option of if they want to replace current data or add on to it.
				int replace = JOptionPane.showOptionDialog(frame, "Would you like to replace the current data with data "
						+ "\nfrom the file or add on to it?", "Open File", JOptionPane.DEFAULT_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, options, 0);
				
				//if readFile method returns true, it will display
				//confirmation message
				if(this.list.readFile(fileName, replace)) { 
					JOptionPane.showMessageDialog(frame,"File Imported Successfuly!");
				}
				//if it returns false, it will display error message
				else { 
					JOptionPane.showMessageDialog(frame,"File could not be found OR is corrupted!");				
				}
				
				//sorts information in ascending order based of transaction amount
				this.list.insertSort();
				//updates jtextarea 
				recordsArea.setText(this.list.toString());
				
				//catches error if file is invalid
			} catch (NegativeArraySizeException error) { 
				JOptionPane.showMessageDialog(frame,"File could not be found OR is corrupted!");	
				//catches error if user hits x or cancel
			}catch (Exception error) {
				//error.printStackTrace();
			}
		} 
		
		//if user hits money exhance, calls current_exchance class
		if (e.getSource()== moneyExchange){
			//call currency frame 
			new Currency_Exchange();
		}
		
		//if user hits money transfer, calls money transfer class
		if (e.getSource()== moneyTransfer){
			//call money transfer frame
			new Money_Transfer(this.s,this.ch);
			//dispose frame
			frame.dispose();
		}

		//if user hits profileInfo, calls profileInfo class 
		//with savings input parameter
		if (e.getSource()== profileInfo){
			//call profile info frame
			new ProfileInfo_Button(s);
		}
		
		//if user hits getHelp, calls getHelp class
		if (e.getSource()== getHelp){
			//call help frame
			new HomeMenu_Help();
		}
		
		//if user hits logout, saves user information using
		//saveInfo method, calls log in frame,
		//disposes current frame
		if (e.getSource()== logout){
			//logout and save all details 
			UniversalMethods.saveInfo(s,ch);
			new SignInFrame();	
			frame.dispose();


		}

		// Check which radio button is selected
		if (savingsRadioButton.isSelected()) {
			
			//gets current balance before transaction
			double startBal = this.s.getBalance();
			//creates temp transactionRecord
			TransactionRecord temp = new TransactionRecord();

			//if user chose withdraw
			if (e.getSource() == withdraw) {

				try { 
					//prompts user for amount
					double amount= Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter amount to withdraw from Savings:"));

					//If withdraw can be done with entered amount, it will do so and display
					//message accordingly, else message will display that there is insufficient funds
					if(this.s.withdraw(amount)) { 
						//processes info
						temp.processRecord("s/Withdraw/"+amount+"/"+startBal+"/"+this.s.getBalance());
						
						//if list reaches max size, it will increase the max size than recall add record method
						if (!this.list.add(temp)) { 
							this.list.increaseArraySize(this.list.getSize()+1);
							this.list.add(temp);
						}
						//displays confirmation message
						JOptionPane.showMessageDialog(frame,"Withdraw successful!");
					}
					//if withdraw cant be done, displays message
					else { 
						JOptionPane.showMessageDialog(frame,"Insufficient Funds!");
					}
					
					//catches wrong format being entered, displays error message
				}catch (NumberFormatException error) { 
					JOptionPane.showMessageDialog(frame,"Invalid Input! Please enter a number!","ERROR",JOptionPane.ERROR_MESSAGE);
					//catches error if user hits cancel or x
				}catch (Exception error) { 
					//error.printStackTrace();
				}
			}
			
			//if user chose deposit
			else if (e.getSource() == deposit) {
				try {
					//prompts user for amount
					double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter amount to deposit into Savings:"));

					//If deposit can be done with entered amount, it will do so and display
					//message accordingly, else message will display error <-(should not happen)
					if(this.s.deposit(amount)) { 
						//processes info
						temp.processRecord("s/Deposit/"+amount+"/"+startBal+"/"+this.s.getBalance());
						
						//if list reaches max size, it will increase the max size than recall add record method
						if (!this.list.add(temp)) { 
							this.list.increaseArraySize(this.list.getSize()+1);
							this.list.add(temp);
						}
						//displays confirmation message
						JOptionPane.showMessageDialog(frame,"Deposit successful!");
					}
					else { 
						//if deposit cant be done, displays message
						JOptionPane.showMessageDialog(frame,"Insufficient Funds!");
					}

					//catches wrong format being entered, displays error message
				}catch (NumberFormatException error) { 
					JOptionPane.showMessageDialog(frame,"Invalid Input! Please enter a number!","ERROR",JOptionPane.ERROR_MESSAGE);
					//catches error if user hits cancel or x
				}catch (Exception error) { 
					//error.printStackTrace();
				}
			}
			
			//saves user information with method
			UniversalMethods.saveInfo(this.s,this.ch);
			//calls private method to update jlabels
			updateBalanceLabels();
			//update jtextarea
			recordsArea.setText(this.list.toString());
		} 
		
		//if user chose chequing radio button
		else if (chequingRadioButton.isSelected()) {
			
			//gets current balance before transaction
			double startBal = this.s.getBalance();
			//creates temp transactionRecord
			TransactionRecord temp = new TransactionRecord();

			// if withdraw is hit
			if (e.getSource() == withdraw) {
				try { 
					//prompts user for amount
					double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter amount to withdraw from Chequing:"));

					//If withdraw can be done with entered amount, it will do so and display
					//message accordingly, else message will display that there is insufficient funds
					if(this.ch.withdraw(amount)) { 
						//processes info
						temp.processRecord("c/Withdraw/"+amount+"/"+startBal+"/"+this.ch.getBalance());
						
						//if list reaches max size, it will increase the max size than recall add record method
						if (!this.list.add(temp)) { 
							this.list.increaseArraySize(this.list.getSize()+1);
							this.list.add(temp);
						}
						//displays confirmation message
						JOptionPane.showMessageDialog(frame,"Withdraw successful!");
					}
					else { 
						//if withdraw cant be done, displays message
						JOptionPane.showMessageDialog(frame,"Insufficient Funds!");
					}
					
					//catches wrong format being entered, displays error message
				}catch (NumberFormatException error) { 
					JOptionPane.showMessageDialog(frame,"Invalid Input! Please enter a number!","ERROR",JOptionPane.ERROR_MESSAGE);
					//catches error if user hits cancel or x
				}catch (Exception error) { 
					//error.printStackTrace();
				}

			} 
			//If user chose deposit
			else if (e.getSource() == deposit) {
				try {
					//prompts user for amount
					double amount = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter amount to deposit into Chequing:"));

					//If deposit can be done with entered amount, it will do so and display
					//message accordingly, else message will display error <-(should not happen)
					if(this.ch.deposit(amount)) { 
						//processes info
						temp.processRecord("c/Deposit/"+amount+"/"+startBal+"/"+this.ch.getBalance());
						//if list reaches max size, it will increase the max size than recall add record method
						if (!this.list.add(temp)) { 
							this.list.increaseArraySize(this.list.getSize()+1);
							this.list.add(temp);
						}
						//displays confirmation message
						JOptionPane.showMessageDialog(frame,"Deposit successful!");
					}
					//if deposit cant be done, displays message
					else { 
						JOptionPane.showMessageDialog(frame,"Error!");
					}
					//catches wrong format being entered, displays error message
				}catch (NumberFormatException error) { 
					JOptionPane.showMessageDialog(frame,"Invalid Input! Please enter a number!","ERROR",JOptionPane.ERROR_MESSAGE);
					//catches error if user hits cancel or x
				}catch (Exception error) { 
					//error.printStackTrace();
				}
			}
			//saves user information with method
			UniversalMethods.saveInfo(this.s,this.ch);
			//calls private method to update jlabels
			updateBalanceLabels();
			//update jtextarea
			recordsArea.setText(this.list.toString());
		}
	}




	// Method to update balance labels
	private void updateBalanceLabels() {
		total.setText("Total Funds/Balance:    $" + d.format(s.getBalance() + ch.getBalance()));
		cheq.setText("Total Chequing Balance:    $" + d.format(ch.getBalance()));
		sav.setText("Total Savings Balance:    $" + d.format(s.getBalance()));
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//random objects created for testing
		Customer c = new Customer();
		c.processRecord("123/123/123/123/123/123/123");
		Savings s = new Savings();
		Chequing ch = new Chequing();
		
		//sets customer to savings and chequing object
		//initializes info, than calls frame (NOTE EACH TIME YOU CALL THIS MAIN METHOD
		//ACCOUND ID WILL BE DIFFERENT AND BALANCES WILL RESET IF CHANGES WERE MADE PREVIOUSLY)
		s.setCustomer(c);
		ch.setCustomer(c);
		ch.setAccount(s.getAccount());
		s.deposit(123);
		ch.deposit(123);
		new UserHomeMenu(s,ch);

	}

}