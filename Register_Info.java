import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * Authour; Hamza Khan & Rudra Patel
 * Date; Dec 2023
 * Description; First of Three (1/3) for the user to create a new account and register, this account asks the user 
 *              for their perosnal details (each data is passed on from frame to frame), and registering progress is tracked
 *              using a progress bar
 *              
 *              
 *  <METHODS>
 *  
 *  public Register_Info() { - frame     
 *              
 * private void placeComponents(JPanel panel, JFrame frame) { - components
 *           
 * nextButton.addActionListener(new ActionListener() { - listener        
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
 *              
 */

public class Register_Info extends JFrame {
  
	
	//private variables 
	private JTextField firstNameField, lastNameField, addressField, phoneField, sinField;
    private JProgressBar progressBar;
    private JFrame frame;
   
    
    public Register_Info() {
    	//new frame 
        frame = new JFrame("Enter; Personal Info");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocation(100, 100);

        //panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0x1e3b3d)); // Set the background color
        
        //adding to frame and panel 
        frame.add(panel);
        placeComponents(panel, frame);

        //set visible
        frame.setVisible(true);
        
        
    }

    //all components method
    private void placeComponents(JPanel panel, JFrame frame) {
        
    	//null layout
    	panel.setLayout(null);

    	//welcome title 
        JLabel welcomeTitle = new JLabel("Enter Personal Info");
        welcomeTitle.setForeground(new Color(0xd8ae5e));
        Font titleFont = new Font("Monospaced", Font.BOLD, 30);
        welcomeTitle.setFont(titleFont);
        welcomeTitle.setBounds(85, -150, 400, 400); 
        panel.add(welcomeTitle);

        //label for first name entry 
        JLabel firstNameLabel = new JLabel("First Name;");
        firstNameLabel.setBounds(100, 100, 80, 25); 
        firstNameLabel.setForeground(new Color(0xd8ae5e)); // Set text color
        panel.add(firstNameLabel);

        // JTextField for First Name
        firstNameField = new JTextField(20);
        firstNameField.setBounds(200, 100, 165, 25); 
        firstNameField.setBackground(new Color(0xd8ae5e)); // Set background color
        panel.add(firstNameField);

        //label for last name entry 
        JLabel lastNameLabel = new JLabel("Last Name;");
        lastNameLabel.setBounds(100, 150, 80, 25); 
        lastNameLabel.setForeground(new Color(0xd8ae5e)); // Set text color
        panel.add(lastNameLabel);

        // JTextField for Last Name
        lastNameField = new JTextField(20);
        lastNameField.setBounds(200, 150, 165, 25); 
        lastNameField.setBackground(new Color(0xd8ae5e)); // Set background color
        panel.add(lastNameField);

        //label for phone number entry 
        JLabel phoneLabel = new JLabel("Phone Number;");
        phoneLabel.setBounds(100, 200, 100, 25); 
        phoneLabel.setForeground(new Color(0xd8ae5e)); // Set text color
        panel.add(phoneLabel);

        // JTextField for Phone Number
        phoneField = new JTextField(20);
        phoneField.setBounds(200, 200, 165, 25); 
        phoneField.setBackground(new Color(0xd8ae5e)); // Set background color
        panel.add(phoneField);
        
		//S. Thanush
		//Adds key listener to textField,if key entered 
		//is not a number , it will be disposed of. If key is a number
		//it will than check if length of input is less than 10,
		//if less than 10, it will keep it editable, if 10 or greater, it will be 
		//un-editable (slashes,colons still work as I do not know how to prevent this)
		phoneField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				//if entered character is a letter, it will be "consumed", or deleted.
				if (Character.isLetter(c)) { 
					e.consume();
				}
				else { 
					//else it will check the length of the input and if it is less than 10 more info can be added
					//else, no new info can be added.
					int length = phoneField.getText().length();
					if (length < 10 || (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) { 
						phoneField.setEditable(true);
					}
					else { 
						phoneField.setEditable(false);
					}
				}
			}
		});

        //label for address entry 
        JLabel addressLabel = new JLabel("Address;");
        addressLabel.setBounds(100, 250, 80, 25); 
        addressLabel.setForeground(new Color(0xd8ae5e)); // Set text color
        panel.add(addressLabel);

        // JTextField for Address
        addressField = new JTextField(20);
        addressField.setBounds(200, 250, 165, 25); 
        addressField.setBackground(new Color(0xd8ae5e)); // Set background color
        panel.add(addressField);

        //label for SIN number entry 
        JLabel sinNumber = new JLabel("SIN Number;");
        sinNumber.setBounds(100, 300, 80, 25); 
        sinNumber.setForeground(new Color(0xd8ae5e)); // Set text color
        panel.add(sinNumber);

        // JTextField for SIN Number
        sinField = new JTextField(20);
        sinField.setBounds(200, 300, 165, 25); 
        sinField.setBackground(new Color(0xd8ae5e)); // Set background color
        panel.add(sinField);
        
		//S. Thanush
		//Adds key listener to textField,if key entered 
		//is not a number , it will be disposed of. If key is a number
		//it will than check if length of input is less than 9,
		//if less than 9, it will keep it editable, if 9 or greater, it will be 
		//un-editable (slashes,colons still work as I do not know how to prevent this)
		sinField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				//Gets character
				char c = e.getKeyChar();
				//if entered character is a letter, it will be "consumed", or deleted.
				if (Character.isLetter(c)) { 
					e.consume();
				}
				//else it will check the length of the input and if it is less than 9 more info can be added
				//else, no new info can be added.
				else { 
					int length = sinField.getText().length();
					if (length < 9|| (c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) { 
						sinField.setEditable(true);
					}
					else { 
						sinField.setEditable(false);
					}
				}
			}
		});

        //progress bar for the first frame (1/3)
        progressBar = new JProgressBar(0, 100); // Set the minimum and maximum values
        progressBar.setValue(30); // Set the initial value to 30 percent
        progressBar.setStringPainted(true); //displaying the the percentage on the bar 
        progressBar.setBounds(160, 400, 200, 25);
        panel.add(progressBar); //add


        //Label telling the user that the bar is for the registering progress
        JLabel progressLabel = new JLabel("Registering Progress");
        progressLabel.setForeground(new Color(0xd8ae5e)); // Set text color
        Font pLabel = new Font("Monospaced", Font.ITALIC + Font.BOLD, 10);
        progressLabel.setFont(pLabel);
        progressLabel.setBounds(190, 425, 200, 25); 
        panel.add(progressLabel);

        //button to go to the next frame which is the login details 
        JButton nextButton = new JButton("Next; Login Details");
        nextButton.setBounds(160, 350, 200, 25); // Adjusted y-coordinate
        panel.add(nextButton );

        nextButton.addActionListener(new ActionListener() {  //when next is clicked        
            public void actionPerformed(ActionEvent e) {
            	
            	//Checks all textfields to see if they contain information or not. if there is information entered within the textfield, it will dispose current frame, and
            	//pass informatin to the next frame.
            	if (!(firstNameField.getText().isEmpty()) && !(lastNameField.getText().isEmpty()) && !(addressField.getText().isEmpty()) && !(phoneField.getText().isEmpty()) 
            			&& !(sinField.getText().isEmpty())) { 
                    // Pass data to the Login class
                    frame.dispose();  // Close the current frame
                    //Call next frame of registering process
                    new Register_Login(firstNameField.getText(), lastNameField.getText(), addressField.getText(), phoneField.getText(), sinField.getText(), progressBar);
            	}
            	
            	//If any textfields do not contain any information, it will prompt an error message
            	else { 
            		JOptionPane.showMessageDialog(frame, "Please fill in all textboxs!",
            		"ERROR!",JOptionPane.ERROR_MESSAGE);
            	}
            }
        });
    }
    
    //register info
    public static void main(String[] args) {
        new Register_Info();
    }
}