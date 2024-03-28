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
 * 	public HomeMenu_Help() { - frame
 * 
 * 
 * 	private void placeComponents(JPanel panel) { - components
 * 
 * 
 *  backHomeButton.addActionListener(new ActionListener() { - back btn clicked
 * 
 * 
 * <NEW THINGS LEARNED>
 * 
 * ANY NEW THINGS LEARNED HAVE ALREADY BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 */

public class HomeMenu_Help extends JFrame {



	public HomeMenu_Help() {
		
		//frame details
		setTitle("Home Menu Help");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 600);
		setLocation(100, 100);

		//new panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0xE9DCCB)); // Set the background color

		//adding to the panel
		add(panel);
		placeComponents(panel);

		//setting visible
		setVisible(true);
	}



	//method to place components 
	private void placeComponents(JPanel panel) {
		
		//null layout
		panel.setLayout(null);

		// Display the image 
		ImageIcon logoIcon = new ImageIcon("help.png");
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(50, 25, 500, 200); 
		panel.add(logoLabel);

		//welcome title 
		JLabel welcomeTitle = new JLabel("Home Menu Help");
		welcomeTitle.setForeground(new Color(0x1e3b3d));
		Font titleFont = new Font("Monotype Corsiva", Font.BOLD, 45);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(150, -150, 400, 400); 
		panel.add(welcomeTitle);

		//JText to display all help needed in the Home Menu Screen
		JTextArea help = new JTextArea(

						 "PROFILE INFO - Use this button to View all Personal Information\n\n"
						 + "WITHDRAW/DEPOST - Select one of the accounts and click withdraw or deposit "
						 + "to enter the amount you would like and this transaction will be displayed\n\n"
						 + "SEARCH - Use this function to find a specific transaction\n\n"
						 + "SORT - Use this function to sort the transaction list in ascending order\n\n "
						 + "DELETE - Use this Function to Delete a transaction made\n\n"
						 + "IMPORT/EXPORT - This function can be used to import and export transaction lists\n\n"
						 + "MONEY EXCHANGE - Use this function to see the conversion of Canadian Currency to others\n\n"
						 + "MONEY TRANSFER - Use this funciton to send money to other Evergreen Crown Bank Members\n\n"
						 + "LOGOUT - Use this funciton to save all changes made and exit account"
	 
				);

		//JText Help Details Below 
	
		help.setEditable(false);
		help.setLineWrap(true);
		help.setWrapStyleWord(true);
		help.setBackground(new Color(0xE9DCCB)); // Set the background color
		help.setForeground(new Color(0x1e3b3d));
		Font font = new Font("Monotype Corsiva", Font.BOLD, 14);
		help.setFont(font);
		help.setBounds(100, 175, 400, 300); 
		panel.add(help);

		
		//close btn 
		JButton backHomeButton = new JButton("Close");
		backHomeButton.setBounds(250, 500, 100, 40); 
		panel.add(backHomeButton);

		backHomeButton.addActionListener(new ActionListener() { //btn clicked
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();  // Close the current frame
			}
		});
	}

	public static void main(String[] args) {
		new HomeMenu_Help();
	}
}