package main;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class creates a pop up window for displaying the 
 * exceptions generated in the programs back end.
 * 
 * @author Jacob Lyons
 */
public class ErrorMessageBox {

    JFrame parent = new JFrame();
    
    /**
     * This method takes a sting and displays it in the pop up window.
     * 
     * @param Text for display.
     * @author Jacob Lyons.
     */
    public void ErrorMessage(String error) {
    	JOptionPane.showMessageDialog(parent, error);
    }

}