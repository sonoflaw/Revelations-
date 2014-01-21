package tabs;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeTab extends JPanel {
	JLabel Title;
	JButton button;
	
	public WelcomeTab(){
		this.setVisible(true);
		this.add(Title = new JLabel("Brought to you by: FLF (Full Lab Fridays)"));
    	Title.setFont(new Font("Serif", Font.PLAIN, 40));
		
    	
    	button = new JButton("Back to classes page");
		button.setSize(500,100);

		this.setBackground(Color.pink);
		this.add(button);
	}
	
	public JButton getButton(){
		return button;
	}
	
}
