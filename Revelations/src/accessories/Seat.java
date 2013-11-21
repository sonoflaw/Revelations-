package accessories;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Seat extends JLabel{

	
	public Seat(String s){
		this.setVisible(true);
		this.setPreferredSize(new Dimension(100, 100));
		this.setText(s);
		this.setHorizontalAlignment(CENTER);
		this.setBorder(new LineBorder(Color.BLACK));

	}
	
	
}

	
	
	
