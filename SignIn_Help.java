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
 * Description; Help Frame when signing in  
 * 
 * 
 * <METHODS>
 * 
 * 	public SignIn_Help() { - frame
 * 
 * 	private void placeComponents(JPanel panel) { - components
 * 
 * 
 * backHomeButton.addActionListener(new ActionListener() { - listener
 * 
 * <NEW THINGS LEARNED>
 * 
 * ANY NEW THINGS LEARNED HAVE ALREADY BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 * 
 */

public class SignIn_Help extends JFrame {


	
	public SignIn_Help() {
		
		//frame 
		setTitle("Our Misson");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 600);
		setLocation(100, 100);


		//creating the panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0xE9DCCB)); // Set the background color

		//add to the panel 
		add(panel);
		placeComponents(panel);

		//set visible
		setVisible(true);
	}




	private void placeComponents(JPanel panel) {
		
		//set the layout null
		panel.setLayout(null);

		// Display the image above the login area
		ImageIcon logoIcon = new ImageIcon("help.png");
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(50, 50, 500, 200); // Adjust the position and size
		panel.add(logoLabel);

		//display welcoming title for help screen
		JLabel welcomeTitle = new JLabel("Sign-In Screen Help");
		welcomeTitle.setForeground(new Color(0x1e3b3d));
		Font titleFont = new Font("Monotype Corsiva", Font.BOLD, 45);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(120, -150, 400, 400); // Adjusted y-coordinate
		panel.add(welcomeTitle);


		//JTextArea message for all the help 
		JTextArea help = new JTextArea(

						 "LOGIN HELP - Please Enter Username and Password if all ready an Evergreen Member "
						+ "When Entering your password you are able to see it by clicking show Password\n\n"
						+ "ABOUT US - This Button will help you obtain a better understading of Company and Our Values\n\n"
						+ "REGISTER - If you are NOT a Evergreen Member you may use this button to sign up "
						+ "this button will ask you to enter some personal details and banking info to create your new account\n\n"
						+ "FORGOT PASSWORD - If a Evergreen Member happens to forget their password they may click this password by "
						+ "entering thier username and setting a new password" 
				);

		//help text all details below
		help.setEditable(false);
		help.setLineWrap(true);
		help.setWrapStyleWord(true);
		help.setBackground(new Color(0xE9DCCB)); // Set the background color
		help.setForeground(new Color(0x1e3b3d));
		Font font = new Font("Monotype Corsiva", Font.BOLD, 14);
		help.setFont(font);
		help.setBounds(100, 200, 400, 300); // Adjusted coordinates and size
		panel.add(help);

		//button to close the frame
		JButton backHomeButton = new JButton("Close");
		backHomeButton.setBounds(250, 500, 100, 40); // Adjusted coordinates and size
		panel.add(backHomeButton);

		backHomeButton.addActionListener(new ActionListener() { //when btn clicked
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();  // Close the current frame
			}
		});
	}

	public static void main(String[] args) {
		new SignIn_Help();
	}
}