//Resource: https://samderlust.com/dev-blog/java/java-swing-gui-make-calculator-part-2-handle-button-event-actionlistener
//Resource: https://www.geeksforgeeks.org/java-string-charat-method-example/
//Resource: https://www.geeksforgeeks.org/java-swing-simple-calculator/
//Resource: https://www.geeksforgeeks.org/double-parsedouble-method-in-java-with-examples/

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class hw4 extends JFrame implements ActionListener 
{ 
	//creates frame and calculators display
	static JFrame frame; 
	static JTextField display; 

	//strings used for the operators
	String stringZero; 
    String stringOne;
    String stringTwo; 
	
	hw4() 
	{ 
		stringZero = stringOne = stringTwo = ""; 
	} 

	// main function 
	public static void main(String args[]) 
	{ 
		//create a frame and display
		frame = new JFrame("calculator"); 	
		hw4 cal = new hw4(); 
		display = new JTextField(16); 
		display.setEditable(false); 

		//all buttons are created
		JButton buttonZero = new JButton("0"); 
		JButton buttonOne = new JButton("1"); 
		JButton buttonTwo = new JButton("2"); 
		JButton buttonThree = new JButton("3"); 
		JButton buttonFour = new JButton("4"); 
		JButton buttonFive = new JButton("5"); 
		JButton buttonSix = new JButton("6"); 
		JButton buttonSeven = new JButton("7"); 
		JButton buttonEight = new JButton("8"); 
		JButton buttonNine = new JButton("9"); 
		
        //operator buttons
		JButton buttonEqual = new JButton("="); 
		JButton buttonAdd = new JButton("+"); 
		JButton buttonMinus = new JButton("-"); 
		JButton buttonDivide = new JButton("/"); 
		JButton buttonTimes = new JButton("*"); 
		JButton buttonClear = new JButton("C"); 
		JButton buttonDot = new JButton("."); 

        //creates panel
		JPanel holder = new JPanel(); 
		
        //adding actionlisteners to calculator
		buttonTimes.addActionListener(cal); 
		buttonDivide.addActionListener(cal); 
		buttonMinus.addActionListener(cal); 
		buttonAdd.addActionListener(cal); 
		buttonNine.addActionListener(cal); 
		buttonEight.addActionListener(cal); 
		buttonSeven.addActionListener(cal); 
		buttonSix.addActionListener(cal); 
		buttonFive.addActionListener(cal); 
		buttonFour.addActionListener(cal); 
		buttonThree.addActionListener(cal); 
		buttonTwo.addActionListener(cal); 
		buttonOne.addActionListener(cal); 
		buttonZero.addActionListener(cal); 
		buttonDot.addActionListener(cal); 
		buttonClear.addActionListener(cal); 
		buttonEqual.addActionListener(cal); 

		//adding buttons and textfield to the panel
		holder.add(display); 
		holder.add(buttonAdd); 
		holder.add(buttonOne); 
		holder.add(buttonTwo); 
		holder.add(buttonThree); 
		holder.add(buttonMinus); 
		holder.add(buttonFour); 
		holder.add(buttonFive); 
		holder.add(buttonSix); 
		holder.add(buttonTimes); 
		holder.add(buttonSeven); 
		holder.add(buttonEight); 
		holder.add(buttonNine); 
		holder.add(buttonDivide); 
		holder.add(buttonDot); 
		holder.add(buttonZero); 
		holder.add(buttonClear); 
		holder.add(buttonEqual); 
 
        //making frame visable and adding stuff to it
		frame.add(holder); 
		frame.setSize(200, 220); 
		frame.setTitle("Calculator");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	} 

    //determines which button has been clicked
	public void actionPerformed(ActionEvent e) 
	{ 
		String str = e.getActionCommand(); 

		//if statement to reconize numbers 0-9
		if ((str.charAt(0) >= '0' && str.charAt(0) <= '9') || str.charAt(0) == '.') { 
			
			if (!stringOne.equals("")) 
				stringTwo = stringTwo + str; 
			else
				stringZero = stringZero + str; 

			//displayed the text of the calculator
			display.setText(stringZero + stringOne + stringTwo); 
		} 
		else if (str.charAt(0) == 'C') 
        { 
			
            //clears the calculator
			stringZero = stringOne = stringTwo = ""; 

			//clears the display
			display.setText(stringZero + stringOne + stringTwo); 
		} 
		else if (str.charAt(0) == '=') 
        { 

			double val; 

			//statement for each operator then displays the result of the mathmatic result
			if (stringOne.equals("+")) 
				val = (Double.parseDouble(stringZero) + Double.parseDouble(stringTwo)); 
                
			else if (stringOne.equals("-")) 
				val = (Double.parseDouble(stringZero) - Double.parseDouble(stringTwo)); 

			else if (stringOne.equals("/")) 
				val = (Double.parseDouble(stringZero) / Double.parseDouble(stringTwo)); 

			else
				val = (Double.parseDouble(stringZero) * Double.parseDouble(stringTwo)); 

            ////displayed the text of the calculator
			display.setText(stringZero + stringOne + stringTwo + "=" + val); 

			
			stringZero = Double.toString(val); 

			stringOne = stringTwo = ""; 
		} 
		else { 
			
			if (stringOne.equals("") || stringTwo.equals("")) 
				stringOne = str; 
			
			else 
            { 
				double val; 

				
				if (stringOne.equals("+")) 
					val = (Double.parseDouble(stringZero) + Double.parseDouble(stringTwo)); 

				else if (stringOne.equals("-")) 
					val = (Double.parseDouble(stringZero) - Double.parseDouble(stringTwo)); 

				else if (stringOne.equals("/")) 
					val = (Double.parseDouble(stringZero) / Double.parseDouble(stringTwo)); 

				else
					val = (Double.parseDouble(stringZero) * Double.parseDouble(stringTwo)); 

				
				stringZero = Double.toString(val); 

				
				stringOne = str; 

				
				stringTwo = ""; 
			} 
			display.setText(stringZero + stringOne + stringTwo); 
		} 
	} 
} 
