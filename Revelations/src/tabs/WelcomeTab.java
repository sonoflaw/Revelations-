package tabs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WelcomeTab extends JPanel implements ActionListener{
	JLabel Title;
	JButton button;
	
	public WelcomeTab(){
		this.setVisible(true);
		this.add(Title = new JLabel("Brought to you by: FLF (Full Lab Fridays)"));
    	Title.setFont(new Font("Serif", Font.PLAIN, 40));
		
    	
    	button = new JButton("Start");
		button.setSize(300,100);
		button.addActionListener((ActionListener) this);
		/*{
		 
        	public void actionPerformed(ActionEvent e)
        	{
            	//Execute when button is pressed
            	System.out.println("You clicked the button");
            	button.setVisible(false);
            	NewFrame1();
            
        	}
    	});  */
		this.setBackground(Color.pink);
		this.add(button);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("You clicked the button");
    	button.setVisible(false);
		
	}
	
}
