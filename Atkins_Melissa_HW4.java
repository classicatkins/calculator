//Resource: https://samderlust.com/dev-blog/java/java-swing-gui-make-calculator-part-2-handle-button-event-actionlistener
//Resource: https://www.geeksforgeeks.org/java-string-charat-method-example/
//Resource: https://www.geeksforgeeks.org/java-swing-simple-calculator/
//Resource: https://www.geeksforgeeks.org/double-parsedouble-method-in-java-with-examples/

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class hwFour extends JFrame implements ActionListener 
{
    //creates frame and calculators display
    static JFrame frame;
    static JTextField display;
 
    //strings used for the operators
    String stringZero;
    String stringOne;
    String stringTwo;

    hwFour()
    {
        stringZero = stringOne = stringTwo = "";
    }
    public static void main(String args[])
    {
        //create a frame and display
        JFrame frame = new JFrame("calculator");
        display = new JTextField();

        hwFour cal = new hwFour();
    
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
        JButton buttonPlus = new JButton("+");
        JButton buttonMinus = new JButton("-");
        JButton buttonDivide = new JButton("/");
        JButton buttonMultiply = new JButton("*");
        JButton buttonClear = new JButton("C");
    
        //create a panel that holds the two other panels
        JPanel holder = new JPanel(); 
        JPanel keypadPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        //other panels are put inside the holder panel
        holder.add(keypadPanel);
        holder.add(buttonPanel);

        //display is added to the keypadPanel
        keypadPanel.add(display);

        //buttons are added to ButtonPanel
        buttonPanel.add(buttonZero);
        buttonPanel.add(buttonOne);
        buttonPanel.add(buttonTwo);
        buttonPanel.add(buttonThree);
        buttonPanel.add(buttonFour);
        buttonPanel.add(buttonFive);
        buttonPanel.add(buttonSix);
        buttonPanel.add(buttonSeven);
        buttonPanel.add(buttonEight);
        buttonPanel.add(buttonNine);
        buttonPanel.add(buttonPlus);
        buttonPanel.add(buttonMinus);
        buttonPanel.add(buttonMultiply);
        buttonPanel.add(buttonDivide);
        buttonPanel.add(buttonEqual);
        buttonPanel.add(buttonClear);

        //Gridlayout
        holder.setLayout(new BoxLayout(holder, BoxLayout.PAGE_AXIS));
        keypadPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new GridLayout(4, 3));
        keypadPanel.add(display, BorderLayout.NORTH);
        holder.add(keypadPanel, BorderLayout.CENTER);
        keypadPanel.add(buttonPanel, BorderLayout.CENTER);
         
        //action listeners are added to all the buttons
        buttonZero.addActionListener(cal);
        buttonOne.addActionListener(cal);
        buttonTwo.addActionListener(cal);
        buttonThree.addActionListener(cal);
        buttonFour.addActionListener(cal);
        buttonFive.addActionListener(cal);
        buttonSix.addActionListener(cal);
        buttonSeven.addActionListener(cal);
        buttonEight.addActionListener(cal);
        buttonNine.addActionListener(cal);
  
        buttonMultiply.addActionListener(cal);
        buttonDivide.addActionListener(cal);
        buttonMinus.addActionListener(cal);
        buttonPlus.addActionListener(cal);
        buttonEqual.addActionListener(cal);
        buttonClear.addActionListener(cal);
    
        //holder panel is added to frame and frame is made visable
        frame.add(holder);
        frame.setSize(400, 500);
        frame.setTitle("Calculator");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //determines which button has been clicked
    public void actionPerformed(ActionEvent e)
    {
        String str = e.getActionCommand();
 
        //if statement to reconize numbers 0-9
        if ((str.charAt(0) >= '0' && str.charAt(0) <= '9')) 
        {

            if (stringOne.equals(""))
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
        }

        else 
        {
            if (stringOne.equals("") || stringTwo.equals(""))
                stringOne = str;
        }
    }
}