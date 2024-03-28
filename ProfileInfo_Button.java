import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;



/*
 * Author; Hamza Khan
 * Date; Dec 2023
 * Description; To Display the user profile info 
 * 
 * 
 * 
 * <METHODS>
 * 
 * 	public ProfileInfo_Button(Savings s) { - frame
 * 
 * 	private void placeComponents(JPanel panel, Savings s) { - componnets
 * 
 * backHomeButton.addActionListener(new ActionListener() { - listener
 * 
 * <NEW THINGS LEARNED>
 * 
 * ANY NEW THINGS LEARNED HAVE ALREADY BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 * 
 */


public class ProfileInfo_Button extends JFrame {
	

	
	public ProfileInfo_Button(Savings s) {
		
		//frame details 
		setTitle("Your Profile");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 600);
		setLocation(100, 100);
		
		//create the panel 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x1e3b3d)); // Set the background color
		
		//add to the panel
		add(panel);
		placeComponents(panel, s);
		
		setVisible(true);
	}

	

	
	private void placeComponents(JPanel panel, Savings s) {
		
		//set panel null layout 
		panel.setLayout(null);

		// Display the image 
		ImageIcon logoIcon = new ImageIcon("PFButton.png");
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(50, 75, 500, 200); // Adjust the position and size
		panel.add(logoLabel);
		
		//welcome title for profile info
		JLabel welcomeTitle = new JLabel("Your Profile");
		welcomeTitle.setForeground(new Color(0xd8ae5e));
		Font titleFont = new Font("TimesRoman", Font.BOLD + Font.ITALIC, 70);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(120, -150, 400, 400); // Adjusted y-coordinate
		panel.add(welcomeTitle);

		
		//label for user name and display user name
		JLabel userName = new JLabel("Username: " + s.getCustomer().getUsername());
		userName.setBounds(100, 275, 200, 25);
		userName.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(userName);

		//label for password and display password
		JLabel passWord = new JLabel("Password: " + s.getCustomer().getPassword());
		passWord.setBounds(350, 275, 200, 25);
		passWord.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(passWord);

		//label for first name and display first name
		JLabel firstName = new JLabel("First Name: " + s.getCustomer().getFirstName());
		firstName.setBounds(100, 350, 200, 25);
		firstName.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(firstName);

		//label for last name and display last name
		JLabel lastName = new JLabel("Last Name: " + s.getCustomer().getLastName());
		lastName.setBounds(350, 350, 200, 25);
		lastName.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(lastName);

		//label for address and display address
		JLabel address = new JLabel("Address: " + s.getCustomer().getAddress());
		address.setBounds(100, 425, 200, 25);
		address.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(address);

		//label for phone number and display phone number
		JLabel phoneNumber = new JLabel("Phone Number: " + s.getCustomer().getPhone());
		phoneNumber.setBounds(350, 425, 200, 25);
		phoneNumber.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(phoneNumber);

	    //back button    
		JButton backHomeButton = new JButton("Close");
		backHomeButton.setBounds(250, 525, 100, 25); // Adjusted y-coordinate
		panel.add(backHomeButton);

		backHomeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();  // Close the current frame
			}
		});
	}

	public static void main(String[] args) {
		//random objects created for testing
		Customer c = new Customer();
		c.processRecord("123/123/123/123/123/123/123");
		Savings s = new Savings();
		
		//sets customer to savings and chequing object
		//initializes info, than calls frame (NOTE EACH TIME YOU CALL THIS MAIN METHOD
		//ACCOUND ID WILL BE DIFFERENT AND BALANCES WILL RESET IF CHANGES WERE MADE PREVIOUSLY)
		s.setCustomer(c);
		s.deposit(123);
		new ProfileInfo_Button(s);
	}
}
