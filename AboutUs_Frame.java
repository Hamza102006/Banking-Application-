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
 * Date; Dec, 2023
 * Description; about us frame for the Evergreen Crown Bank of Canada
 *              
 *              
 * <METHODS>
 * 
 * 	public AboutUs_Frame() { - frame
 * 
 * 	private void placeComponents(JPanel panel) { - components             
 *   
 *  backHomeButton.addActionListener(new ActionListener() { - listener
 *                       
 * 
 * <NEW THINGS LEARNED>
 * 
 * ANY NEW THINGS LEARNED HAVE ALREADY BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 * 
 */

public class AboutUs_Frame extends JFrame {
	


	public AboutUs_Frame() {
		//creating the frame 
		setTitle("Our Misson");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 600);
		setLocation(100, 100);

		//creating the panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0xE9DCCB)); // Set the background color

		//adding to the panel
		add(panel);
		placeComponents(panel);

		//make visible
		setVisible(true);
	}

	

	//components method
	private void placeComponents(JPanel panel) {
		
		//null layout 
		panel.setLayout(null);

		// Display the image 
		ImageIcon logoIcon = new ImageIcon("LOGOEG.png");
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(50, 100, 500, 200); 
		panel.add(logoLabel);
		
		//display the title
		JLabel welcomeTitle = new JLabel("Our Misson");
		welcomeTitle.setForeground(new Color(0x1e3b3d));
		Font titleFont = new Font("Monotype Corsiva", Font.BOLD, 75);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(120, -150, 400, 400); 
		panel.add(welcomeTitle);

		//text area message where all the misson statments are located 
		 JTextArea missionTextArea = new JTextArea(
	                "Our Mission\n"
	                        + "At Evergreen Crown Bank of Canada, our mission is to empower individuals, businesses, and communities "
	                        + "by providing innovative financial solutions, personalized service, and a commitment to ethical banking practices. "
	                        + "We strive to be a trusted partner in our customers' financial journeys, fostering sustainable growth and prosperity. "
	                        + "With a focus on integrity, inclusivity, and community development, we aim to create lasting value for our stakeholders "
	                        + "and contribute to the well-being of Canadian society.\n "
	                        + "\n"
	                        + "Evergreen Crown Bank – Your Financial Growth, Our Shared Success"
	        );

		 //missionTextArea details below 
		
	        missionTextArea.setEditable(false);
	        missionTextArea.setLineWrap(true);
	        missionTextArea.setWrapStyleWord(true);
	        missionTextArea.setBackground(new Color(0xE9DCCB)); // Set the background color
	        missionTextArea.setForeground(new Color(0x1e3b3d));
	        Font font = new Font("Monotype Corsiva", Font.BOLD, 14);
	        missionTextArea.setFont(font);
	        missionTextArea.setBounds(100, 320, 450, 200); 
	        panel.add(missionTextArea);
	        
	        
	    //close button    
		JButton backHomeButton = new JButton("Close");
		backHomeButton.setBounds(250, 525, 100, 25); 
		panel.add(backHomeButton);

		backHomeButton.addActionListener(new ActionListener() { //when close clicked
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();  // Close the current frame
			}
		});
	}

	public static void main(String[] args) {
		new AboutUs_Frame();
	}
}
