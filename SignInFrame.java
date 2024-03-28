import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;



/*
 * Author; Hamza Khan
 * Date; Dec 2023
 * Description; The User Sign in frame to the access their bank account 
 *  
 *  
 * <METHODS>
 * 
 *  
 * public SignInFrame() {
 *  
 *  
 * private void placeComponents(JPanel panel) { - placing components
 *  
 *  
 * showPassword.addActionListener(new ActionListener() { - show password listener 
 *  
 *  
 * loginButton.addActionListener(new ActionListener() { - login listener
 *  
 *  
 * public void actionPerformed (ActionEvent e){ - all other button listener
 * 
 * 
 * public static void main(String[] args) { - main
 *  
 *  
 *  
 * <NEW THINGS LEARNED>
 *
 *  
 *  [setBorderPainted and setFocusPainted]
 *  
 *  - These two functions were learned and implemented into
 *  the code to make the code much more visually appealing and user friendly 
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
 *  [JCheckBox]
 *  
 *   - The JcheckBox was used to enhance the login by having a show and 
 *   hide functionality to the login process, this addtion was fairly simple 
 *   as all that happened was that when the checkbox was selected the password 
 *   would be shown when not the password was hidden 
 *  
 *  LINKS; https://www.javatpoint.com/java-jcheckbox
 *  
 *  
 *  [Showing and Hiding Password; EchoChar]
 *  
 *  - To be able to show the password entered the checkbox is selected 
 *  (clicked), if it is selected, it sets the EchoChar property of the password field to (char) 0 
 *  within my code which reveals the entered characters. 
 *  However, when the checkbox is not selected, 
 *  it sets the EchoChar to '*' to hide the password by displaying asterisks 
 *  instead of the actual characters. This provides users with the option to 
 *  show or hide their password. The echochar makes sure that the asterisks
 *  still hold value and the user can still sign in 
 *  
 *  LINKS ; https://stackoverflow.com/questions/19755259/hide-show-password-in-a-jtextfield-java-swing
 *          https://www.youtube.com/watch?v=yFljqVmDgh0
 *  
 *  
 */



public class SignInFrame implements ActionListener {

	
	//private Variable
	private JPanel controlPanel;
	private JLayeredPane layeredPane;
	private JButton loginButton, helpButton, aboutUsButton,registerButton, forgotPassButton, exitButton;
	private JFrame frame;
	private Customer c;
	private Savings s;
	private Chequing ch;

	
	
	
	public SignInFrame() {
		
		//Initialize objects using default constructor
		c = new Customer();
		s = new Savings();
		ch = new Chequing();

		//Creating the New Frame for the Sign in Frame
		frame = new JFrame("Sign In");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 600); //size 
		frame.setLocation(100,100); //locations 

		//creating a panel which will hold components  
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x1e3b3d)); // Set the background color of the panel 



		// Display the image above the login area
		// Which is the logo of our company (Evergreen Crown Bank of Canada)
		// Which was made using Canva
		ImageIcon logoIcon = new ImageIcon("LOGOEG.png");
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(225, 30, 500, 200); // Adjust the position and size
		panel.add(logoLabel); //add to panel 

		frame.add(panel); //add the panel to the frame 
		placeComponents(panel); //add all the componebts to the panel 

		frame.setVisible(true); //set visible frame 
	}

	//METHOD which holds all the components within the panel 
	private void placeComponents(JPanel panel) {
		
		//set layout to null to allow open placement of components
		panel.setLayout(null);

		//label to enter user name
		JLabel userLabel = new JLabel("Username");
		userLabel.setBounds(325, 250, 80, 25);
		userLabel.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(userLabel); //add

		// JTextField for Username
		JTextField userText = new JTextField(20);
		userText.setBounds(400, 250, 165, 25);
		userText.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(userText); //add


		// JLabel to enter Password
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(325, 300, 80, 25);
		passwordLabel.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(passwordLabel); //add


		// JPasswordField for Password
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(400, 300, 165, 25);
		passwordText.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(passwordText); //add

		// JCheckBox for Show Password
		JCheckBox showPassword = new JCheckBox("Show Password");
		showPassword.setBackground(new Color(0x1e3b3d)); // Set the background color
		showPassword.setForeground(new Color(0xd8ae5e)); // Set text color
		showPassword.setBounds(420, 325, 150, 25);
		panel.add(showPassword); //add

		//LOGIN BUTTON [COMMENTED EACH LINE TO LIMIT COMMENTING AS OTHER BUTTONS HAVE SIMMILAR COMMENTING]
		loginButton = new JButton("Login");
		
		//set bounds
		loginButton.setBounds(430, 375, 80, 25);
		
		// Set the background color of the button
		loginButton.setBackground(new Color(0xd8ae5e)); 
		
		// Set the foreground (text) color of the button
		loginButton.setForeground(new Color(0x1e3b3d)); 
		
		// Remove the border around the button
		loginButton.setBorderPainted(false);
		
		// Remove the focus border when the button is clicked
		loginButton.setFocusPainted(false);
		
		panel.add(loginButton); //add


		//REGISTER BUTTONS [SAME COMMENTING AS LOGIN]
		registerButton = new JButton("Register");
		registerButton.setBounds(10, 310, 80, 25);
		registerButton.setBackground(new Color(0xd8ae5e)); 
		registerButton.setForeground(new Color(0x1e3b3d)); 
		registerButton.setBorderPainted(false);
		registerButton.setFocusPainted(false);
		panel.add(registerButton);


		//ABOUT US BUTTON [SAME COMMENTING AS LOGIN]
		aboutUsButton = new JButton("About Us");
		aboutUsButton.setBounds(10, 310, 80, 25);
		aboutUsButton.setBackground(new Color(0xd8ae5e));
		aboutUsButton.setForeground(new Color(0x1e3b3d));
		aboutUsButton.setBorderPainted(false);
		aboutUsButton.setFocusPainted(false);
		panel.add(aboutUsButton);

		//HELP BUTTON 
		helpButton = new JButton(""); //no text 
		helpButton.setIcon(new ImageIcon("HM.png")); //add an image to the button
		helpButton.setBounds(835, 10, 45, 45);
		panel.add(helpButton); //add


		//FORGOT PASSWORD BUTTON [SAME COMMENTING AS LOGIN]
		forgotPassButton = new JButton("Forgot Password");
		forgotPassButton.setBounds(10, 310, 80, 25);
		forgotPassButton.setBackground(new Color(0xd8ae5e)); 
		forgotPassButton.setForeground(new Color(0x1e3b3d)); 
		forgotPassButton.setBorderPainted(false);
		forgotPassButton.setFocusPainted(false);
		panel.add(forgotPassButton);

		//EXIT BUTTON [SAME COMMENTING AS LOGIN]
		exitButton = new JButton("Exit Button");
		exitButton.setBounds(10, 310, 80, 25);
		exitButton.setBackground(new Color(0xd8ae5e)); 
		exitButton.setForeground(new Color(0x1e3b3d)); 
		exitButton.setBorderPainted(false);
		exitButton.setFocusPainted(false);
		panel.add(exitButton);

		// Control Panel (all control buttons)
		//Panel made to make all the buttons look organized and neat 
		controlPanel = new JPanel();
		controlPanel.setBackground(new Color(0x1e3b3d)); // Set the background color

		controlPanel.setOpaque(true); // Make the control panel transparent
		controlPanel.add(aboutUsButton); //add
		controlPanel.add(registerButton); //add
		controlPanel.add(forgotPassButton); //add
		controlPanel.add(exitButton); //add
		controlPanel.setBounds(20, 500, 900, 600); //set bounds
		panel.add(controlPanel); //add control panel to actual whole panel

		//all action listners
		loginButton.addActionListener(this);
		registerButton.addActionListener(this);
		aboutUsButton.addActionListener(this);
		helpButton.addActionListener(this);
		forgotPassButton.addActionListener(this);
		exitButton.addActionListener(this);
		showPassword.addActionListener(this);


		//ACTION LISTENER FOR THE CHECK BOX TO SHOW PASSWORD
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showPassword.isSelected()) { //if the check box is clicked
					
					passwordText.setEchoChar((char) 0); // Show the password
				} else {
					passwordText.setEchoChar('*'); // Hide the password
				}
			}
		});


		//ACTION LISTNER FOR LOGIN BUTTON 
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = userText.getText(); //get the user name 
				String password = new String(passwordText.getPassword()); //get the password 
				
				//If entered username or password is not empty, it will do the code below.
				if (!(username.isEmpty()) && !(password.isEmpty())) { 
					
					//Finds location of user information within "information" files 
					//using checkLogin method.
					int location = UniversalMethods.checkLogin(username, password);
					//System.out.println("Location within Sign in Frame: " + location);
					//If value returned isnt -1, meaning user info was found, it will
					//open account data using openAccount method, dispose current frame,
					//than open homepage frame with user info
					if (location > -1) { 
						UniversalMethods.openAccount(location, c, s, ch);
						new UserHomeMenu(s, ch);
						frame.dispose();
					}
					//If value returned is -1, meaning user info was not found, it will
					//display appropriate message
					else { 
						JOptionPane.showMessageDialog(frame, "Username OR Password is Incorrect!\n Register if Not EverGreen Member!","ERROR!",JOptionPane.ERROR_MESSAGE);
					}
				}
				//if one or both textboxs are empty, it will prompt an error message
				else { 
	           		JOptionPane.showMessageDialog(frame, "Please fill in all textboxs!",
	                		"ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}


	//Action Listener for all other buttons 
	public void actionPerformed (ActionEvent e){
		
		if (e.getSource()== aboutUsButton){
			new AboutUs_Frame(); //if about us clicked open about us frame
		}

		if (e.getSource()== helpButton){ 
			new SignIn_Help(); //if help button clicked open help frame
		}

		if (e.getSource()== registerButton){ 
			new Register_Info(); //if register clicked open the first register frame to enter new user info
		}

		if (e.getSource()== forgotPassButton){
			new FindUser_ForgotPassword(); //if forgot password is clicked open the frame to find the user to change pass
			
		}

		if (e.getSource()== exitButton){
			System.exit(0); //if clicked exit and close program 
		}

	}

	public static void main(String[] args) {
		new SignInFrame(); //main calling the Sign - in frame 
	}
}
