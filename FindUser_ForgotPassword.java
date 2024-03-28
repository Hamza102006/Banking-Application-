/**
 * 
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/**
 * Author; Hamza Khan
 * Date: Dec 2023
 * Description; Find the User first in order to change the password frame
 *          
 *          
 * METHODS;
 * 
 * 	public FindUser_ForgotPassword() { // frame
 * 
 * 	private void placeComponents(JPanel panel, JFrame frame) { //componenets
 * 
 *  public void actionPerformed(ActionEvent e) { //listener
 * 
 * 
 * NEW THINGS LEARNED;
 * 
 * ANY NEW THINGS LEARNED HAVE ALREADY BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 * 
 * 
 */
public class FindUser_ForgotPassword {

	
	//private variables
    private JTextField userNameField;
    private JFrame frame;
	
    
	public FindUser_ForgotPassword() {
		
		//frame
		frame = new JFrame("Find Your Account");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocation(100, 100);
		
		//create panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x1e3b3d)); // Set the background color

		//add to frame and panel
		frame.add(panel);
		placeComponents(panel, frame);

		//set visible
		frame.setVisible(true);
	}

	//method to place components 
	private void placeComponents(JPanel panel, JFrame frame) {
		
		//null layout
		panel.setLayout(null);

		//welcome title
		JLabel welcomeTitle = new JLabel("Enter Username to Reset Password");
		welcomeTitle.setForeground(new Color(0xd8ae5e));
		Font titleFont = new Font("Monospaced", Font.BOLD, 15);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(50, -150, 400, 400); // Adjusted y-coordinate
		panel.add(welcomeTitle);

		//label to find username
		JLabel username = new JLabel("Find Username:");
		username.setBounds(60, 125, 100, 25); // Adjusted y-coordinate
		username.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(username);

		// JTextField for username
		userNameField = new JTextField(20);
		userNameField.setBounds(175, 125, 165, 25); // Adjusted y-coordinate
		userNameField.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(userNameField);

		//button to progress to the the resseting password frame 
		JButton nextButton = new JButton("Next: Resetting Password");
		nextButton.setBounds(100, 250, 200, 25); // Adjusted y-coordinate
		panel.add(nextButton );

		nextButton.addActionListener(new ActionListener() { //btn clicked

			
			
			public void actionPerformed(ActionEvent e) {
				
				//If the username field is not empty, it will than do the code below.
				if (!(userNameField.getText().isEmpty())) { 
					
					//Declare and initialize customer related objects
					Customer c = new Customer();
					Savings s = new Savings();
					Chequing ch = new Chequing();
					
					//Check to see if user entered username exists 
					int location = UniversalMethods.check(userNameField.getText(),0,"CustomerList.txt");
					//If username  exists within "database", it will call the open account method,
					//process that users info, dispose currnet frame, than call upon next frame
					//with savings and chequing as input parameters.
					if (location != -1) { 
						UniversalMethods.openAccount(location,c,s,ch);
						frame.dispose();  // Close the current frame
						new Resetting_ForgotPassword(s, ch);
					}
					
					//If username doesnt exist, it will prompt a message accordingly.
					else { 
						JOptionPane.showMessageDialog(frame, "No account exists with this username!","ERROR",JOptionPane.ERROR_MESSAGE);
					}

				}
				//If the username field is empty, it will prompt a message accordingly. 
				else { 
					JOptionPane.showMessageDialog(frame, "Please fill in all textboxs!",
	                		"ERROR!",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
	}





	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FindUser_ForgotPassword();

	}

}
