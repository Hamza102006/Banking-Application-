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
 * Author; Hamza Khan & Rudra Patel
 * Date; Dec 2023
 * Description; Frame to reset the password 
 * 
 *METHODS;
 *
 *public Resetting_ForgotPassword(Savings s, Chequing ch) { //frame
 *
 *
 *private void placeComponents(JPanel panel, JFrame frame, Savings s, Chequing ch) { // components
 *
 *public void actionPerformed(ActionEvent e) { //listener
 *
 *NEW THINGS LEARNED;
 *
 * ANY NEW THINGS LEARNED HAVE ALREADY BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 *
 *
 */
public class Resetting_ForgotPassword {

	//private variables
	private JTextField newPassField, confirmPassField;



	public Resetting_ForgotPassword(Savings s, Chequing ch) {

		//creating the frame 
		JFrame frame = new JFrame("Reset Password");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(100, 100);

		//creating the panel 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x1e3b3d)); // Set the background color

		//adding to the panel
		frame.add(panel);
		placeComponents(panel, frame, s, ch);

		frame.setVisible(true);
	}


	private void placeComponents(JPanel panel, JFrame frame, Savings s, Chequing ch) {

		//panel set to null
		panel.setLayout(null);

		//welcome title 
		JLabel welcomeTitle = new JLabel("Reset Password");
		welcomeTitle.setForeground(new Color(0xd8ae5e));
		Font titleFont = new Font("Monospaced", Font.BOLD, 25);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(85, -150, 400, 400); 
		panel.add(welcomeTitle);

		//label to enter new password
		JLabel newPass = new JLabel("New Password;");
		newPass.setBounds(80, 125, 100, 25); 
		newPass.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(newPass);

		// JTextField for new password
		newPassField = new JTextField(20);
		newPassField.setBounds(200, 125, 165, 25); 
		newPassField.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(newPassField);

		//label to confirm new password
		JLabel confirmPass = new JLabel("Confirm Password;");
		confirmPass.setBounds(80, 175, 120, 25); 
		confirmPass.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(confirmPass);

		// JTextField for confrim password
		confirmPassField = new JTextField(20);
		confirmPassField.setBounds(200, 175, 165, 25); 
		confirmPassField.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(confirmPassField);

		//next button to finalize the new password 
		JButton nextButton = new JButton("Finalize Password");
		nextButton.setBounds(160, 350, 200, 25); 
		panel.add(nextButton );


		nextButton.addActionListener(new ActionListener() { //btn to save password 

			public void actionPerformed(ActionEvent e) {
				
				//If both text fields are not empty it will than check to see if password and confirm
				//password are the same
				if (!(newPassField.getText().isEmpty()) && !(confirmPassField.getText().isEmpty())) { 
					if (!newPassField.getText().equals(confirmPassField.getText())) {
						JOptionPane.showMessageDialog(frame, "Passwords are not the same!!");
					} else {		            
						JOptionPane.showMessageDialog(frame, "Password Reset!", "Success!",JOptionPane.INFORMATION_MESSAGE);
						s.getCustomer().setPassword(newPassField.getText());
						ch.getCustomer().setPassword(newPassField.getText());
						UniversalMethods.saveInfo(s, ch);
						frame.dispose();  // Close the current frame

					}
				}

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
		
		new Resetting_ForgotPassword(s,ch);
	}

}
