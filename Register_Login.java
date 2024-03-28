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


/*
 * Authour; Hamza Khan & Rudra Patel
 * Date; Dec 2023
 * Description; Second of Three (2/3) for the user to create a new account and register, this account asks the user 
 *              for their login details (each data is passed on from frame to frame), and registering progress is tracked
 *              using a progress bar
 *              
 *              
 *  <METHODS>
 *  
 * 	public Register_Login(String firstName, String lastName, String address, String phone, String sinN, JProgressBar progressBar) {             
 *              
 *  private void placeComponents(JPanel panel, String firstName, String lastName, String address, String phone, String sinN) {
 *  
 *  nextButton.addActionListener(new ActionListener() { - listener
 *              
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




public class Register_Login extends JFrame {

	//private variables 
	private JTextField usernameField, passwordField;
	private JProgressBar progressBar;
	private JFrame frame;

	//frame (with all the past frame details)
	public Register_Login(String firstName, String lastName, String address, String phone, String sinN, JProgressBar progressBar) {
		frame = new JFrame("Enter; Login Info");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(100, 100);

		this.progressBar = progressBar;  // Save the past frames JProgressBar details

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x1e3b3d)); // Set the background color

		//adding to the panel and the frame 
		frame.add(panel);
		placeComponents(panel, firstName, lastName, address, phone, sinN);

		//set visible
		frame.setVisible(true);
	}

	//method which hold all the components 
	private void placeComponents(JPanel panel, String firstName, String lastName, String address, String phone, String sinN) {

		//set null layout 
		panel.setLayout(null);

		//welcome title for the login info 
		JLabel welcomeTitle = new JLabel("Enter Login Info");
		welcomeTitle.setForeground(new Color(0xd8ae5e));
		Font titleFont = new Font("Monospaced", Font.BOLD, 30);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(85, -150, 400, 400); 
		panel.add(welcomeTitle);

		//label for the new username 
		JLabel newUsername = new JLabel("New Username;");
		newUsername.setBounds(80, 125, 150, 25); 
		newUsername.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(newUsername);

		// JTextField for User Name
		usernameField = new JTextField(20);
		usernameField.setBounds(200, 125, 165, 25); 
		usernameField.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(usernameField);

		//label for the new password 
		JLabel newPassword = new JLabel("New Password;");
		newPassword.setBounds(80, 175, 150, 25); 
		newPassword.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(newPassword);

		// JTextField for new password
		passwordField = new JTextField(20);
		passwordField.setBounds(200, 175, 165, 25); 
		passwordField.setBackground(new Color(0xd8ae5e)); // Set background color
		panel.add(passwordField);

		//continued progress bar 
		progressBar = new JProgressBar(0, 100); // Set the minimum and maximum values
		progressBar.setValue(60); // Set the initial value to 60 percent
		progressBar.setStringPainted(true);
		progressBar.setBounds(160, 400, 200, 25);
		panel.add(progressBar);

		//label for progress bar and registering progress
		JLabel progressLabel = new JLabel("Registering Progress");
		progressLabel.setForeground(new Color(0xd8ae5e)); // Set text color
		Font pLabel = new Font("Monospaced", Font.ITALIC + Font.BOLD, 10);
		progressLabel.setFont(pLabel);
		progressLabel.setBounds(190, 425, 200, 25); 
		panel.add(progressLabel);


		//Next Button to the next frame
		JButton nextButton = new JButton("Next: Balance Details");
		nextButton.setBounds(160, 350, 200, 25); 
		panel.add(nextButton);

		nextButton.addActionListener(new ActionListener() { //when next is clicked
			public void actionPerformed(ActionEvent e) {
				
				//If neither textboxs are empty, it will than check the next if statement. 
				if (!(usernameField.getText().isEmpty())&&!(passwordField.getText().isEmpty())) { 

					//if the user enters a username that already exist then it displays the according message.
					if (UniversalMethods.check(usernameField.getText(),0,"CustomerList.txt") != -1) { 
						JOptionPane.showMessageDialog(frame,"An account with this username already exists!");
					}
					
					//If username doesnt exist, than it will dispose current frame and call in the next frame for 
					//registering process.
					else { 
						// Pass data to the Balance class
						frame.dispose();  // Close the current frame
						new Register_Balance(firstName, lastName, address, phone, sinN, usernameField.getText(), passwordField.getText(), progressBar);
					}
				}
				
				//if 1 or both textfields are empty,it will display an error message. 
				else { 
            		JOptionPane.showMessageDialog(frame, "Please fill in all textboxs!",
            		"ERROR!",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	//self-testing
	public static void main(String[] args) {
		new Register_Login("123", "123", "123", "123", "123", new JProgressBar() );
	}
}