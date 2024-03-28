import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


/*
 * Author; Hamza Khan & Rudra Patel
 * Date; Dec, 2023
 * Description; Last of Three (3/3) Frames for Registering which ask the user for the balance details 
 *              (all data is in this class). And will be user to create a new account 
 *              
 *              
 *              
 * <METHODS>
 * 
 * 
 * public Register_Balance(String firstName, String lastName, String address, String phone, String sinN, String username, String password, JProgressBar progressBar) {         
 *              
 * private void placeComponents(JPanel panel, String firstName, String lastName, String address, String phone, String sinN,String username, String password) {
 * 
 * public void actionPerformed(ActionEvent e) {
 * 
 *              
 * <NEW THINGS LEARNED>             
 *              
 * [PROGRESS BAR]
 * 
 * - To make the registering process much more user friendly I made sure to add a progress bar so that the user can 
 * see how much longer the process is, the progress bar fits in this Registering example as their are three frames
 * so the progress bar is changed/updated after every frame is completed. Since this was an entirely new concept to 
 * me I made sure to use other sources and edit them to make sure the progress bar would fit within my frame
 * 
 * 
 * LINK; https://www.geeksforgeeks.org/java-swing-jprogressbar/
 *       https://docs.oracle.com/javase%2Ftutorial%2Fuiswing%2F%2F/components/progress.html
 *       https://www.javatpoint.com/java-jprogressbar 
 * 
 * 
 * ANY NEW THINGS LEARNED HAVE ALREADY BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 *              
 */


//private variables
public class Register_Balance extends JFrame {
	private JTextField chequingField, savingsField;
	private JProgressBar progressBar;
	private JFrame frame;


	public Register_Balance(String firstName, String lastName, String address, String phone, String sinN, String username, String password, JProgressBar progressBar) {
		frame = new JFrame("Enter; Balance Info");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(100, 100);

		this.progressBar = progressBar;  // saved progress of the last JProgressBar

		//create panel 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x1e3b3d)); // Set the background color

		//add to frame and panel
		frame.add(panel);
		placeComponents(panel, firstName, lastName, address, phone,sinN, username, password);

		//set visible
		frame.setVisible(true);
	}

	//method to hold all components 
	private void placeComponents(JPanel panel, String firstName, String lastName, String address, String phone, String sinN,String username, String password) {

		//null layout
		panel.setLayout(null);

		//welcome title for Balance info
		JLabel welcomeTitle = new JLabel("Enter New Balance Info");
		welcomeTitle.setForeground(new Color(0xd8ae5e));
		Font titleFont = new Font("Monospaced", Font.BOLD, 30);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(85, -150, 400, 400); 
		panel.add(welcomeTitle);

		//label to enter cheq balance
		JLabel newCheq = new JLabel("Enter Chequing Balance;");
		newCheq.setBounds(50, 125, 150, 25); 
		newCheq.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(newCheq);

		// JTextField for Chequing Balance
		chequingField = new JTextField(20);
		chequingField.setBounds(200, 125, 165, 25); 
		chequingField.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(chequingField);

		//S. Thanush
		//Adds key listener to textField,if key entered 
		//is not a number and its not '.', it will be disposed of
		//(slashes,colons still work as I do not know how to prevent this)
		chequingField.addKeyListener(new KeyAdapter() {
			char c;
			public void keyTyped(KeyEvent e) {
				c = e.getKeyChar();
				if ( !(Character.isDigit(c)) && c != '.') {
					e.consume();
				}
			}
		});

		//label to enter sav balance
		JLabel newSav = new JLabel("Enter Savings Balance;");
		newSav.setBounds(50, 175, 150, 25); 
		newSav.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(newSav);

		// JTextField for Savings Balance
		savingsField = new JTextField(20);
		savingsField.setBounds(200, 175, 165, 25); 
		savingsField.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(savingsField);

		//S. Thanush
		//Adds key listener to textField,if key entered 
		//is not a number and its not '.', it will be disposed of
		//(slashes,colons still work as I do not know how to prevent this)
		savingsField.addKeyListener(new KeyAdapter() {
			char c;
			public void keyTyped(KeyEvent e) {
				c = e.getKeyChar();
				if ( !(Character.isDigit(c)) && c != '.') {
					e.consume();
				}
			}
		});

		progressBar = new JProgressBar(0, 100); // Set the minimum and maximum values
		progressBar.setValue(90); // Set the initial value to 90 percent
		progressBar.setStringPainted(true); 
		progressBar.setBounds(160, 400, 200, 25);
		panel.add(progressBar);

		//label to let user know registering progress
		JLabel progressLabel = new JLabel("Registering Progress");
		progressLabel.setForeground(new Color(0xd8ae5e)); // Set text color
		Font pLabel = new Font("Monospaced", Font.ITALIC + Font.BOLD, 10);
		progressLabel.setFont(pLabel);
		progressLabel.setBounds(190, 425, 200, 25); // Adjusted y-coordinate
		panel.add(progressLabel);

		//Create Evergreen Member Account
		//clicking this button will create a new account and record for the user 

		JButton nextButton = new JButton("Create Evergreen Account");
		nextButton.setBounds(160, 350, 200, 25); // Adjusted y-coordinate
		panel.add(nextButton);

		nextButton.addActionListener(new ActionListener() { //when button is clicked


			public void actionPerformed(ActionEvent e) {

				//If neither of the textfields are empty, than it will take that information, 
				//put it into a savings and chequing object, set the customer information,
				//save the information using saveInfo method, than dispose the frame while letting the user know 
				//they have registered.
				if (!(savingsField.getText().isEmpty()) && !(chequingField.getText().isEmpty())) { 
					
					//Creates customer related objects for registering
					Savings s = new Savings();
					Chequing c = new Chequing();
					
					//Deposits starting balances into new accounts
					s.deposit(Double.parseDouble(savingsField.getText()));
					c.deposit((Double.parseDouble(chequingField.getText()))+c.getDepositFee());
					
					//Sets customer information into customer object
					s.setCustomer(new Customer(username,password,firstName,lastName,address,Long.parseLong(phone),Integer.parseInt(sinN)));
					//Sets both to have the same customer
					c.setCustomer(s.getCustomer());
					//sets both to have the same account number
					c.setAccount(s.getAccount());
					
					//saves info into "database"
					UniversalMethods.saveInfo(s, c);
					
					//States user has been registered
					JOptionPane.showMessageDialog(frame, "Saved New Login Details. ");
					frame.dispose();//bring them back to main log in frame
					//new UserHomeMenu(s,c); Choose from either logging in automatically for the user when they fully register
					//or bringing them back to the main log in frame
				}

				//If user has 1 or both textfields empty, it will give an error message.
				else { 
					JOptionPane.showMessageDialog(frame, "Please fill in all textboxs!",
							"ERROR!",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
	}

	//self-testing
	public static void main(String[] args) {
		new Register_Balance("123", "123", "123", "123", "123", "123", "123", new JProgressBar());
		
	}
}