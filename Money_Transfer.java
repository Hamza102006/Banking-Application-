
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



/*
 * Author; Hamza Khan
 * Date; Dec 2023
 * Description; Money Transferring to other Evergreen Bank Members
 * 
 * 
 * 
 * <METHODS>
 * 
 * 	public Money_Transfer(Savings s, Chequing c) { - frame
 * 
 * 	private void placeComponents(JPanel panel) { - components 
 * 
 * 	public void actionPerformed(ActionEvent e) { - listener
 * 
 * 
 * 
 * <NEW THINGS LEARNED>
 * 
 * ANY NEW THINGS LEARNED HAVE BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 * 
 * 
 * 
 */



public class Money_Transfer implements ActionListener{

	//Private instances/variables
	private JTextField moneySentField, accNumField;
	private JFrame frame;
	private JRadioButton savingsRadioButton, userSavingsRadioButton;
	private JRadioButton chequingRadioButton, userChequingRadioButton;
	private JButton backHomeButton, sendMoney;
	private Chequing c;
	private Savings s;

	//method for the main frame and creating it with efficient details 
	public Money_Transfer(Savings s, Chequing c) {

		//Initialize current class objects with previous class input objects
		this.s = s;
		this.c = c;

		//create frame
		frame = new JFrame("Money Tranfer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(100,100);

		//create panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x1e3b3d)); 

		//add panel to frame
		frame.add(panel);
		//call place components 
		placeComponents(panel);


		//set visibility true
		frame.setVisible(true);
	}

	//all components in teh panel
	private void placeComponents(JPanel panel) {

		//null layout 
		panel.setLayout(null);


		//welcome title to the frame 
		JLabel welcomeTitle = new JLabel("Money Transfer");
		welcomeTitle.setForeground(new Color(0xd8ae5e));
		Font titleFont = new Font("Monotype Corsiva", Font.BOLD, 35);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(225, -150, 400, 400); // Adjusted y-coordinate
		panel.add(welcomeTitle);

		//Jtext message about the frame and functionality 
		JTextArea message = new JTextArea(
				"MESSAGE!!!\n"
						+ "Use this platform to send money to other Evergreen Crown Members"
				);

		//message details below 
		message.setEditable(false);
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		message.setBackground(new Color(0x1e3b3d)); // Set the background color
		message.setForeground(new Color(0xd8ae5e));
		Font font = new Font("Monotype Corsiva", Font.PLAIN, 14);
		message.setFont(font);
		message.setBounds(225, 70, 250, 100); // Adjusted coordinates and size
		panel.add(message);

		// Display the image 
		ImageIcon logoIcon = new ImageIcon("ET.png");
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(-150, -10, 500, 200); // Adjust the position and size
		panel.add(logoLabel);


		//label to tell user the account nember to send 
		JLabel accNum = new JLabel("Enter Account Number to Send To; ");
		accNum.setBounds(75, 225, 250, 25);
		accNum.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(accNum);

		//field to eneter the account number 
		accNumField = new JTextField();
		accNumField.setBounds(300, 225, 120, 25);
		panel.add(accNumField);

		//label to tell user the amount of moeny to send
		JLabel moneySent = new JLabel("Enter Amount of Money to Send; ");
		moneySent.setBounds(75, 275, 250, 25);
		moneySent.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(moneySent);

		//field to enter the moeny amount 
		moneySentField = new JTextField();
		moneySentField.setBounds(300, 275, 120, 25);
		panel.add(moneySentField);

		//label to ask the user from which account they want to send from 
		JLabel curr = new JLabel("Select Account you would like to SEND Money to; ");
		curr.setBounds(100, 325, 300, 25);
		curr.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(curr);

		//JRadio Button to ask the user where send (savings)
		savingsRadioButton = new JRadioButton("Savings");
		savingsRadioButton.setBounds(150, 350, 100, 30); // Adjusted y-coordinate
		savingsRadioButton.setBackground(new Color(0x1e3b3d)); // Set the background color
		savingsRadioButton.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(savingsRadioButton);

		//JRadio Button to ask the user where send (chequing)
		chequingRadioButton = new JRadioButton("Chequing");
		chequingRadioButton.setBounds(250, 350, 100, 30); // Adjusted y-coordinate
		chequingRadioButton.setBackground(new Color(0x1e3b3d)); // Set the background color
		chequingRadioButton.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(chequingRadioButton);

		//ask the user which account of THIERS they want to send from 
		JLabel yourAcc = new JLabel("Select YOUR Account to Send Money From: ");
		yourAcc.setBounds(125, -25, 300, 400);
		yourAcc.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(yourAcc);

		//JRadio Button to ask the user which account of thier they want to send from (savings)
		userSavingsRadioButton = new JRadioButton("Savings");
		userSavingsRadioButton.setBounds(150, 185, 100, 30);
		userSavingsRadioButton.setBackground(new Color(0x1e3b3d)); // Set the background color
		userSavingsRadioButton.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(userSavingsRadioButton);

		//JRadio Button to ask the user which account of thier they want to send from (chequing)
		userChequingRadioButton = new JRadioButton("Chequing");
		userChequingRadioButton.setBounds(250, 185, 100, 30);
		userChequingRadioButton.setBackground(new Color(0x1e3b3d)); // Set the background color
		userChequingRadioButton.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(userChequingRadioButton);



		// Create a ButtonGroup to ensure only one radio button is selected at a time (to send)
		ButtonGroup accountGroup = new ButtonGroup();
		accountGroup.add(savingsRadioButton);
		accountGroup.add(chequingRadioButton);

		// Create a ButtonGroup to ensure only one radio button is selected at a time (to send FROM)
		ButtonGroup userAccountGroup = new ButtonGroup();
		userAccountGroup.add(userSavingsRadioButton);
		userAccountGroup.add(userChequingRadioButton);

		//button to send the money and confirm the send 
		sendMoney = new JButton("Send Money");
		sendMoney.setBounds(125, 425, 120, 25);
		sendMoney.setBackground(new Color(0xd8ae5e)); // Set the background color
		sendMoney.setForeground(new Color(0x1e3b3d)); // Set text color
		sendMoney.setBorderPainted(false); // Remove the button border
		sendMoney.setFocusPainted(false); // Remove the focus bor
		panel.add(sendMoney);

		//button to close the frame 
		backHomeButton = new JButton("Close");
		backHomeButton.setBounds(275, 425, 120, 25); // Adjusted y-coordinate
		backHomeButton.setBackground(new Color(0xd8ae5e)); // Set the background color
		backHomeButton.setForeground(new Color(0x1e3b3d)); // Set text color
		backHomeButton.setBorderPainted(false); // Remove the button border
		backHomeButton.setFocusPainted(false); // Remove the focus bor
		panel.add(backHomeButton);


		//action listener
		backHomeButton.addActionListener(this);
		sendMoney.addActionListener(this);
		chequingRadioButton.addActionListener(this);
		savingsRadioButton.addActionListener(this);
		userChequingRadioButton.addActionListener(this);
		userSavingsRadioButton.addActionListener(this);

		//S. Thanush
		//Adds key listener to textField,if key entered 
		//is not a number , it will be disposed of. If key is a number
		//it will than check if length of input is less than 12,
		//if less than 12, it will keep it editable, if 12 or greater, it will be 
		//un-editable (slashes,colons still work as I do not know how to prevent this)
		accNumField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isLetter(c)) { 
					e.consume();
				}
				else { 
					int length = accNumField.getText().length();
					if (length < 12 || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) { 
						accNumField.setEditable(true);
					}
					else { 
						accNumField.setEditable(false);
					}
				}
			}
		});

		//S. Thanush
		//Adds key listener to textField,if key entered 
		//is not a number and its not '.', it will be disposed of
		//(slashes,colons still work as I do not know how to prevent this)
		moneySentField.addKeyListener(new KeyAdapter() {
			char c;
			public void keyTyped(KeyEvent e) {
				c = e.getKeyChar();
				if ( !(Character.isDigit(c)) && c != '.') {
					e.consume();
				}
			}
		});

	}


	public void actionPerformed(ActionEvent e) {


		if (e.getSource() == backHomeButton) {
			frame.dispose(); // Close the current frame

			//Brings back previous frame, with new information
			new UserHomeMenu(this.s,this.c);

		} 
		else if (e.getSource() == sendMoney) {

			try { 

				//If both textfields arent empty, it will do the code below
				if (!(accNumField.getText().isEmpty()) && !(moneySentField.getText().isEmpty())) { 

					//Gets the account number from user
					String accountNumber = accNumField.getText();
					double moneySent = Double.parseDouble(moneySentField.getText());

					//gets location of account info
					int location = UniversalMethods.check(accountNumber, 0, "InfoList.txt");

					//If returned value is less than 0, dispalys accordingly
					if(location < 0) { 
						JOptionPane.showMessageDialog(frame,"Account could not be found!");
					}

					//If account could be found, does code below.
					else {

						//Declares and initializes new customer related
						//objects to store account to send moenyto
						Customer c = new Customer();
						Savings s = new Savings();
						Chequing ch = new Chequing();

						//opens account (divides location by 2 since this location value
						//read info from infolist.tx, which is double the size of customerlist.txt)
						UniversalMethods.openAccount(location/2,c,s,ch);

						//If user chose savings, does code below.
						if (userSavingsRadioButton.isSelected()) {

							//if user can withdraw the money sent it will do the code below
							if (this.s.withdraw(moneySent)) { 

								//If user chose to send to savings account, money will be deposited
								//to recipient savings account
								if (savingsRadioButton.isSelected()) { 
									s.deposit(moneySent);
								}
								//if user chose to send to chequing accoun, it will check if money can be deposited
								//to recipient chequing account. If not possible due to low funds, message will display.
								else if(chequingRadioButton.isSelected()) { 
									if (!ch.deposit(moneySent)) { 
										JOptionPane.showMessageDialog(frame, ch.getCustomer().getFirstName() + " has insufficient funds for deposit!", "Error",
												JOptionPane.ERROR_MESSAGE);
									}
								}

								//If user didnt choose an option,message will display
								else {
									JOptionPane.showMessageDialog(frame, "Please select an account to send to!.", "Error",
											JOptionPane.ERROR_MESSAGE);
								}
							}

							//if user cant withdraw the money sent it will display message accordingly
							else { 
								JOptionPane.showMessageDialog(frame, "Insufficient Funds!.", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}

						//If user chose chequing, does code below
						else if (userChequingRadioButton.isSelected()) {

							//if user can withdraw the money sent it will do the code below
							if (this.c.withdraw(moneySent)) { 

								//If user chose to send to savings account, money will be deposited
								//to recipient savings account
								if (savingsRadioButton.isSelected()) { 
									s.deposit(moneySent);
								}

								//if user chose to send to chequing accoun, it will check if money can be deposited
								//to recipient chequing account. If not possible due to low funds, message will display.
								else if(chequingRadioButton.isSelected()) { 
									if (!ch.deposit(moneySent)) { 
										JOptionPane.showMessageDialog(frame, ch.getCustomer().getFirstName() + " has insufficient funds for deposit!", "Error",
												JOptionPane.ERROR_MESSAGE);
									}	

									//If user didnt choose an option,message will display}
									else { 
										JOptionPane.showMessageDialog(frame, "Please select an account to send to!.", "Error",
												JOptionPane.ERROR_MESSAGE);
									}
								}

								//if the user cant withdraw money, it will display according message.
								else { 
									JOptionPane.showMessageDialog(frame, "Insufficient Funds!.", "Error",
											JOptionPane.ERROR_MESSAGE);
								}
								//If user didnt choose an option, message will display
							} else {
								JOptionPane.showMessageDialog(frame, "Please select an account type.", "Error",
										JOptionPane.ERROR_MESSAGE);
							}
							//User info and recipient info will be saved after every withdraw and deposit
							UniversalMethods.saveInfo(this.s, this.c);
							UniversalMethods.saveInfo(s, ch);
						}

					}	
				}
				//if user left textfields empty, it will display message
				else { 
					JOptionPane.showMessageDialog(frame, "Please fill in all textboxs!",
							"ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				//Catches number formatting error, displays according message
			}catch (NumberFormatException error) { 
				JOptionPane.showMessageDialog(frame, "Invalid Input!", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			//catches any other error 
			}catch (Exception error) {
				//error.printStackTrace();
			}	
		}
	}

	// Getter methods for exchange rates

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
		new Money_Transfer(s,ch);

	}
}