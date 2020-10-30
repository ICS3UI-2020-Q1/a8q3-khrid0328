import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  
  JPanel mainPanel;

  JLabel firstLabel;
  JLabel secondLabel;

  JTextField firstInput;
  JTextField secondInput;

  JButton fToC; 
  JButton cToF;

  Font biggerText;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    // initialize the main panal
    mainPanel = new JPanel();

    // disable any layout helpers
    mainPanel.setLayout(null);

    // create the side labels
    firstLabel = new JLabel("Degrees Fahrenheit");
    secondLabel = new JLabel("Degrees Celsius");

    // layout the labels by setting the coordinate and setSize
    firstLabel.setBounds(40, 40, 250, 30);
    secondLabel.setBounds(40, 90, 250, 30);

    // INITIALIZE THE INPUT TEXT FIELDS
    firstInput = new JTextField();
    secondInput = new JTextField();

    // set the location and setSize
    firstInput.setBounds(290, 40, 100, 30);
    secondInput.setBounds(290, 90, 100, 30);

    // initialize the buttons
    cToF = new JButton("C --> F");
    fToC = new JButton("F --> C");

    // set the location and set setSize
    fToC.setBounds(420, 40, 150, 30);
    cToF.setBounds(420, 90, 150, 30);

    // add an action listener to the buttons
    fToC.addActionListener(this);
    cToF.addActionListener(this);

    // set the action commant on the buttons
    fToC.setActionCommand("F --> C");
    cToF.setActionCommand("C --> F");

    // add the labels to the main mainPanel
    mainPanel.add(firstLabel);
    mainPanel.add(secondLabel);

    // add the text fields to the main mainPanel
    mainPanel.add(firstInput);
    mainPanel.add(secondInput);

    // add the buttons to the panel
    mainPanel.add(cToF);
    mainPanel.add(fToC);

    // create a bigger font to use
    biggerText = new Font("arial",Font. PLAIN, 20);

    // set the fonr on the area I want to use
    firstLabel.setFont(biggerText);
    secondLabel.setFont(biggerText);
    firstInput.setFont(biggerText);
    secondInput.setFont(biggerText);
    cToF.setFont(biggerText);
    fToC.setFont(biggerText);

    // add the panel to the window
    frame.add(mainPanel);

  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("F --> C")){
      // get the text from the text box
      String firstText = firstInput.getText();

      // change the string into an integer
      int degreeF = Integer.parseInt(firstText);

      // callculate the degree in Celsius
      int temperatureC = (5 * degreeF - 160) / 9;

      // clear the second text box
      secondInput.setText("");

      // output the answer to the second text box
      secondInput.setText("" + temperatureC);

    }else if(command.equals("C --> F")){
      // get the text from the second text box
      String secondText = secondInput.getText();

      // change the string into an integer
      int degreeC = Integer.parseInt(secondText);

      // callculate the degree in Celsius
      int temperatureF = (9 / 5) * degreeC + 32;

      // clear the first text box
      firstInput.setText("");

      // output the answer to the second text box
      firstInput.setText(""+ temperatureF);
    }
    
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
