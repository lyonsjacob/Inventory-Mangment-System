package main;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ErrorMessageBox {

    JFrame parent = new JFrame();
    
    public void ErrorMessage(String error) {
    	JOptionPane.showMessageDialog(parent, error);
    }

}