import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/*
 * Author; Hamza KhanS
 * Date; Dec 2023
 * Description; Frame for the User to check Exchange rates of Canadian Money to 4 of the top currencies 
 *              in the world
 * 
 * 
 * 
 * <METHODS>
 * 
 * 	public Currency_Exchange() { - frame
 * 
 * 	private void placeComponents(JPanel panel) { - components
 * 
 * 	private void convertCurrency() { - converting currency 
 * 
 *  convertButton.addActionListener(new ActionListener() { - listener
 * 
 * 
 * <NEW THINGS LEARNED>
 * 
 * ANY NEW THINGS LEARNED HAVE BEEN STATED AND EXPLAINED WITHIN; [SignInFrame and UserHomeMenu]
 * 
 */

public class Currency_Exchange  {

	//private variables
	private JTextField amountField;
	private JComboBox currencyComboBox;
	private JLabel resultLabel;
	private JFrame frame;

	// Exchange rates
	private double rateUSA = 0.74;    // 1 USD to CAD
	private double rateChina = 5.27;  // 1 CNY to CAD
	private double rateEngland = 0.59;// 1 GBP to CAD
	private double rateJapan = 106.99; // 1 JPY to CAD

	public Currency_Exchange() {
		//frame 
		frame = new JFrame("Sign In");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 500);
		frame.setLocation(100,100);

		//new panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0x1e3b3d)); // Set the background color

		//adding to the panel
		frame.add(panel);
		placeComponents(panel);

		//make visible
		frame.setVisible(true);
	}

	private void placeComponents(JPanel panel) {

		//set null layout
		panel.setLayout(null);

		//welcome title 
		JLabel welcomeTitle = new JLabel("Money Exchange");
		welcomeTitle.setForeground(new Color(0xd8ae5e));
		Font titleFont = new Font("Monotype Corsiva", Font.BOLD, 35);
		welcomeTitle.setFont(titleFont);
		welcomeTitle.setBounds(225, -150, 400, 400); // Adjusted y-coordinate
		panel.add(welcomeTitle);


		//JText Message about Frame
		JTextArea message = new JTextArea(
				"MESSAGE!!!\n"
						+ "Curious About Other Countries Currencies Compared To Ours "
						+ "Try Our Brand New Money Transfer Feature, Stay Tuned for More Countries Added"


				);

		//JText Message Details Below

		message.setEditable(false);
		message.setLineWrap(true);
		message.setWrapStyleWord(true);
		message.setBackground(new Color(0x1e3b3d)); // Set the background color
		message.setForeground(new Color(0xd8ae5e));
		Font font = new Font("Monotype Corsiva", Font.PLAIN, 14);
		message.setFont(font);
		message.setBounds(225, 70, 250, 100); 
		panel.add(message);

		// Display the image 
		ImageIcon logoIcon = new ImageIcon("Curr2.png");
		JLabel logoLabel = new JLabel(logoIcon);
		logoLabel.setBounds(-140, 0, 500, 200); 
		panel.add(logoLabel);


		//label for user to enter the Cad value to convert 
		JLabel input = new JLabel("Enter CAD Value to Convert;");
		input.setBounds(50, 200, 200, 25);
		input.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(input);

		//amount of cad field
		amountField = new JTextField();
		amountField.setBounds(75, 225, 120, 25);
		panel.add(amountField);
		
		//S. Thanush
		//Adds key listener to amountField textField,if key entered 
		//is not a number and its not '.', it will be disposed of
		//(slashes,colons still work as I do not know how to prevent this)
		amountField.addKeyListener(new KeyAdapter() {
			char c;
			public void keyTyped(KeyEvent e) {
				c = e.getKeyChar();
				if ( !(Character.isDigit(c)) && c != '.') {
					e.consume();
				}
			}
		});


		//label asking user what currency to change to 
		JLabel curr = new JLabel("Select Currency To Transfer To; ");
		curr.setBounds(250, 200, 200, 25);
		curr.setForeground(new Color(0xd8ae5e)); // Set text color
		panel.add(curr);

		//Combo box which has all the different currency to change to 
		currencyComboBox = new JComboBox(new String[]{"USD (Dollars)", "CNY (Yuan)", "GBP (Pounds)", "JPY (Yen)"});
		currencyComboBox.setBounds(275, 225, 120, 25);
		panel.add(currencyComboBox);

		//convert btn
		JButton convertButton = new JButton("Convert");
		convertButton.setBounds(175, 300, 120, 25);
		convertButton.setBackground(new Color(0xd8ae5e)); // Set the background color
		convertButton.setForeground(new Color(0x1e3b3d)); // Set text color
		convertButton.setBorderPainted(false); // Remove the button border
		convertButton.setFocusPainted(false); // Remove the focus bor
		panel.add(convertButton);

		//back btn
		JButton backHomeButton = new JButton("Close");
		backHomeButton.setBounds(175, 425, 120, 25); // Adjusted y-coordinate
		backHomeButton.setBackground(new Color(0xd8ae5e)); // Set the background color
		backHomeButton.setForeground(new Color(0x1e3b3d)); // Set text color
		backHomeButton.setBorderPainted(false); // Remove the button border
		backHomeButton.setFocusPainted(false); // Remove the focus bor
		panel.add(backHomeButton);

		//action listener when the back btn is clicked to close the frame
		backHomeButton.addActionListener(new ActionListener() { //back btn 
			public void actionPerformed(ActionEvent e) {

				frame.dispose();  // Close the current frame
			}
		});


		//result label to show the conversion
		resultLabel = new JLabel("Result will be shown here.");
		resultLabel.setForeground(new Color(0xd8ae5e)); // Set text color
		resultLabel.setBounds(120, 350, 260, 25);
		panel.add(resultLabel);


		// action listener for the convert button
		convertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				convertCurrency(); //converting the currency method which is belwo 
			}
		});
	}

	private void convertCurrency() {
		try {
			//get input and make the double value 
			double amountInCAD = Double.parseDouble(amountField.getText());
			double result = 0.0;

			// Convert based on selected currency
			switch (currencyComboBox.getSelectedItem().toString()) {
			case "USD (Dollars)": //if USA Selected Convert 
				result = convertFromUSD(amountInCAD);
				break;


			case "CNY (Yuan)": //if China Selected Convert 
				result = convertFromCNY(amountInCAD);
				break;


			case "GBP (Pounds)": //if Great Britain Selected Convert 
				result = convertFromGBP(amountInCAD);
				break;


			case "JPY (Yen)": //if Japan Selected Convert 
				result = convertFromJPY(amountInCAD);
				break;
			}

			//output statement which consists of a formated output including all the entered and converted values 
			//as well as the country selected
			resultLabel.setText(String.format("%.2f CAD is equal to %.2f %s", amountInCAD, result, currencyComboBox.getSelectedItem()));
		} catch (NumberFormatException ex) {
			//error catch if an invald number is enetered 
			resultLabel.setText("Invalid input. Please enter a valid number.");
		}
	}

	// Getter methods for exchange rates of the four main countries 
	private double getRateUSA() {
		return rateUSA;
	}

	private double getRateChina() {
		return rateChina;
	}

	private double getRateEngland() {
		return rateEngland;
	}

	private double getRateJapan() {
		return rateJapan;
	}

	// Conversion methods using private instance variables
	//to get the actual value of the currecny converted for all the countries

	private double convertFromUSD(double amountInCAD) {
		return amountInCAD * getRateUSA();
	}

	private double convertFromCNY(double amountInCAD) {
		return amountInCAD * getRateChina();
	}

	private double convertFromGBP(double amountInCAD) {
		return amountInCAD * getRateEngland();
	}

	private double convertFromJPY(double amountInCAD) {
		return amountInCAD * getRateJapan();
	}




	public static void main(String[] args) {
		new Currency_Exchange();


	}
}