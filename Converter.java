import javax.swing.*;
import java.awt.event.*;
import java.util.Stack;

public class Converter extends JFrame implements ActionListener {

	JButton Convert, Clear;
	static JTextField screen1 = new JTextField(12);
	static JTextField screen2 = new JTextField(12);
	static JTextField screen3 = new JTextField(12);

	JLabel error = new JLabel();

	public static void main(String[] args) {

		new Converter();
	}

	public Converter() {
		// creating frame
		JFrame f = new JFrame("Value Converter");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 400);
		f.setResizable(false);

		// creation of panels
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		JPanel p5 = new JPanel();

		// first row
		JLabel Dec = new JLabel();
		Dec.setText("Decimal");
		p1.add(Dec);
		p1.add(screen1); // adding first screen to panel
		p.add(p1); // adding to main panel

		// second row
		JLabel Bin = new JLabel();
		Bin.setText("Binary");
		p2.add(Bin);
		p2.add(screen2); // adding second screen to panel
		p.add(p2); // adding to main panel

		// third row
		JLabel Hex = new JLabel();
		Hex.setText("HexaDecimal");
		p3.add(Hex);
		p3.add(screen3); // adding third screen to panel
		p.add(p3); // adding to main panel

		f.add(p); // add main panel to frame

		JButton Convert = new JButton("Convert");
		JButton Clear = new JButton("Clear");

		p4.add(Clear);
		p4.add(Convert);
		p.add(p4);

		p.add(p5);
		error.setText("");
		p5.add(error);

		Clear.addActionListener(this);
		Convert.addActionListener(this);
		f.setVisible(true);
	}

	/**
	 * Determines which textfield took input and validates that input for proper
	 * conversions.
	 */
	public void actionPerformed(ActionEvent e) {
		String clicked = e.getActionCommand();
		String input = "";
		boolean validate = true;

		if (clicked.equals("Convert")) {

			// first screen input
			if (!(screen1.getText().isEmpty()) & (screen2.getText().isEmpty()) & (screen3.getText().isEmpty())) {
				input = screen1.getText();
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) < 48 || input.charAt(i) > 57) {
						validate = false;
						error.setText(
								"<html><font color='red'>ERROR:<br/>The value entered must be in Decimal format</font></html>");
						errorLock();
					}
				}
				if (validate == true) {
					toBinary(input, 1);
					screen1.setEditable(false);
				}
			}

			// second screen input
			else if ((screen1.getText().isEmpty()) & !(screen2.getText().isEmpty()) & (screen3.getText().isEmpty())) {
				input = screen2.getText();
				for (int i = 0; i < input.length(); i++) {
					if (input.charAt(i) < 48 || input.charAt(i) > 49) {
						error.setText(
								"<html><font color='red'>ERROR:<br/>The value entered must be in Binary format</font></html>");
						validate = false;
						errorLock();
					}
				}
				if (validate == true) {
					toDecimal(input);
					screen1.setEditable(false);
					tohexaDecimal(input);
					screen2.setEditable(false);
				}
			}

			// third screen input
			else if ((screen1.getText().isEmpty()) & (screen2.getText().isEmpty()) & !(screen3.getText().isEmpty())) {
				input = screen3.getText();
				for (int i = 0; i < input.length(); i++) {
					if ((input.charAt(i) < 48 || ((input.charAt(i) > 57) && input.charAt(i) < 65))
							|| input.charAt(i) > 70) {
						error.setText(
								"<html><font color='red'>ERROR:<br/>The value entered must be in Hex format</font></html>");
						validate = false;
						errorLock();
					}
				}
				if (validate == true) {
					toBinary(input, 3);
					screen3.setEditable(false);
				}
			}
		}

		else if (clicked.equals("Clear")) {
			screen1.setText("");
			screen1.setEditable(true);
			screen2.setText("");
			screen2.setEditable(true);
			screen3.setText("");
			screen3.setEditable(true);
			error.setText("");
		}
	}

	/**
	 * Converts binary string to Decimal value and sets the converted
	 * value into the first text field
	 * 
	 * @param input - Valid binary string
	 */
	public void toDecimal(String input) {
		int decimal = 0;
		int position = 0;
		String complete = "";
		for (int i = input.length() - 1; i >= 0; i--) {

			if (input.charAt(i) == '1') {
				decimal += (int) Math.pow(2, position);
			}
			position++;
		}
		complete = Integer.toString(decimal);
		screen1.setText(complete);
	}

	/**
	 * Determines if the input is decimal or hexadecimal and converts to binary.
	 * Displays binary to textfield 2 and calls next conversion (tohexaDecimal or
	 * toDecimal).
	 * 
	 * @param input - string representation of decimal or hexadecimal number
	 * @param x     - defines which way conversion is going
	 */
	public void toBinary(String input, int x) {

		// Decimal to binary
		if (x == 1) {
			int num = Integer.valueOf(input);
			String binary1 = "";
			String binary2 = "";

			// convert to binary but order is backwards
			while (num != 0) {
				binary1 += num % 2;
				num = num / 2;
			}

			// corrects order of binary bits
			for (int i = binary1.length() - 1; i >= 0; i--) {
				binary2 += binary1.charAt(i);
			}

			screen2.setText(binary2);
			screen2.setEditable(false);
			tohexaDecimal(binary2);
		}

		// Hexa-Decimal to binary
		else if (x == 3) {
			String complete = "";

			// find binary representation of hexadecimal characters
			for (int i = 0; i < input.length(); i++) {
				complete += binaryConversion(input.charAt(i));
			}

			// removes any leading 0's from binary result
			for (int i = 0; i < complete.length(); i++) {
				if (complete.charAt(i) == '1') {
					complete = complete.substring(i, complete.length());
					i = complete.length();
				}
			}
			screen2.setText(complete);
			screen2.setEditable(false);
			screen1.setEditable(false);
			toDecimal(complete);
		}
	}

	/**
	 * Ensures binary string length is a multiple of 4 and uses hexConversion to
	 * convert to equivalent hex characters. The Hex characters are then displayed
	 * in
	 * textfield 3.
	 * 
	 * @param input - binary string
	 */
	public void tohexaDecimal(String input) {

		String sub = "";
		String complete = "";
		Stack<String> hexStack = new Stack<String>();

		int padNum = 0;
		String pad = "0000";

		while (input.length() >= 4) {

			// first 4 binary bits (right to left)
			sub = input.substring(input.length() - 4);

			// load Hex characters
			hexStack.push(hexConversion(sub));

			// updated string with first 4 bits removed (right to left)
			input = input.substring(0, input.length() - 4);
		}

		// pad remaining portion (if any) with 0's to make 4 bits
		if (input.length() % 4 != 0) {
			padNum = input.length() % 4;
			padNum = 4 - padNum;
			pad = pad.substring(0, padNum);
			input = pad + input;
			hexStack.push(hexConversion(input));
		}

		// remove Hex characters in order
		while (!(hexStack.isEmpty())) {
			complete += hexStack.pop();
		}
		screen3.setText(complete);
		screen3.setEditable(false);
	}

	/**
	 * Converts valid Hexadecimal value to binary representation
	 * 
	 * @param input - char input of Hexadecimal value
	 * @return Binary representation of a Hexadecimal value
	 */
	public static String binaryConversion(char input) {
		switch (input) {
			case '1':
				return "0001";
			case '2':
				return "0010";
			case '3':
				return "0011";
			case '4':
				return "0100";
			case '5':
				return "0101";
			case '6':
				return "0110";
			case '7':
				return "0111";
			case '8':
				return "1000";
			case '9':
				return "1001";
			case 'A':
				return "1010";
			case 'B':
				return "1011";
			case 'C':
				return "1100";
			case 'D':
				return "1101";
			case 'E':
				return "1110";
			case 'F':
				return "1111";
		}
		return "0000";
	}

	/**
	 * Converts valid nibble to Hexadecimal representation
	 * 
	 * @param input - binary string, 1 nibble (4 bits) at a time.
	 * @return Hexadecimal representation of 1 nibble.
	 */
	public static String hexConversion(String input) {
		switch (input) {
			case "0001":
				return "1";
			case "0010":
				return "2";
			case "0011":
				return "3";
			case "0100":
				return "4";
			case "0101":
				return "5";
			case "0110":
				return "6";
			case "0111":
				return "7";
			case "1000":
				return "8";
			case "1001":
				return "9";
			case "1010":
				return "A";
			case "1011":
				return "B";
			case "1100":
				return "C";
			case "1101":
				return "D";
			case "1110":
				return "E";
			case "1111":
				return "F";
		}
		return "0";
	}

	/**
	 * Locks all text fields from further input in the
	 * evemt of invalid input
	 */
	public static void errorLock() {
		screen1.setEditable(false);
		screen2.setEditable(false);
		screen3.setEditable(false);
	}
}
