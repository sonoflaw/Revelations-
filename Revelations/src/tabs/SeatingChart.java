package tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import accessories.Seat;
import accessories.Student;

public class SeatingChart extends JPanel implements ActionListener{

	private ArrayList<Seat> seats = new ArrayList<Seat>(30);
	private ArrayList<JButton> buttons = new ArrayList<JButton>();
	private ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	public ArrayList<Student> students = new ArrayList<Student>();
	
	private JTextField ask, askColumns;
	private JLabel intro, title;
	
	
	//Constructor////////////////////////////////////
	
	public SeatingChart(){
		
		this.setLayout(null);
		intro = new JLabel("Please enter the number of students in your class:");
		intro.setVisible(true);
		intro.setBounds(480, 10, 350, 100);
		
		ask = new JTextField();
		ask.setVisible(true);
		ask.setBounds(540, 100, 200, 20);
		ask.addActionListener(this);
		
		this.add(ask);
		this.add(intro);
		
		
	}
	
	public void setColumns()
	{
		title = new JLabel("Please enter the number of seat columns in your class: ");
		title.setVisible(true);
		title.setBounds(480, 10, 1000, 100);
		
		askColumns = new JTextField();
		askColumns.setVisible(true);
		askColumns.setBounds(540, 100, 200, 20);
		askColumns.addActionListener(this);
		
		this.add(askColumns);
		this.add(title);
		
	}
	
	
	
	//Create a new seat/////////////////////////
	
	private void createSeat(int i){
		int x = 10, y = 10, width = 100, height = 100;
		int temp = 0;
		
		seats.add(new Seat("Student "+(i+1)));
		
		for (int a = 0; a<i; a++){
			x += 110;
			temp++;
			if(temp >= Integer.parseInt(askColumns.getText())){
				y += 140;
				x = 10;
				temp = 0;
			}
			
			

		}
		
		
		seats.get(i).setBounds(x, y, width, height);
		this.add(seats.get(i));	
		seats.get(i).revalidate();
		seats.get(i).repaint();
	}
	
	
	
	
	//Create a new edit button/////////////////
	private void createButton(int i){
		int x = 10, y = 120, width = 100, height = 20;
		int temp = 0;
		
		buttons.add(new JButton("New Student"));
		buttons.get(i).addActionListener(this);
		
		for (int a = 0; a<i; a++){
			x += 110;
			temp++;
			if(temp >= Integer.parseInt(askColumns.getText())){
				y += 140;
				x = 10;
				temp = 0;
			}
			

		}
		
		
		buttons.get(i).setBounds(x, y, width, height);
		this.add(buttons.get(i));	
		buttons.get(i).revalidate();
		buttons.get(i).repaint();
		
	}
	
	
	
	//Create a new TextField//////////////////
	
	private void createTextField(int i){
		int x = 10, y = 10, width = 100, height = 100;
		int temp = 0;
		
		textFields.add(new JTextField());
		textFields.get(i).setVisible(false);
		textFields.get(i).addActionListener(this);
		
		for (int a = 0; a<i; a++){
			x += 110;
			temp++;
			if(temp >= Integer.parseInt(askColumns.getText())){
				y += 140;
				x = 10;
				temp = 0;
			}	

		}
		
		
		textFields.get(i).setBounds(x, y, width, height);
		this.add(textFields.get(i));	
		textFields.get(i).revalidate();
		textFields.get(i).repaint();
		
	}
	
	
	
	//Action Listeners//////////////////////////////////////////
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == ask){
			ask.setVisible(false);
			intro.setVisible(false);
			setColumns();
				
		}
		
		else if (e.getSource() == askColumns)
		{
			askColumns.setVisible(false);
			title.setVisible(false);
			for(int i = 0; i<Integer.parseInt(ask.getText()); i++){
				createSeat(i);
				createButton(i);
				createTextField(i);
			}
			
			
		}
			
		for (int i = 0; i < buttons.size(); i++ )
		{
			if (e.getSource() == buttons.get(i))
			{
				seats.get(i).setVisible(false);
				textFields.get(i).setVisible(true);
			}	
		}
		

			
		for (int i = 0; i<textFields.size(); i++)
		{
			if (e.getSource() == textFields.get(i))
			{
				seats.get(i).setText(textFields.get(i).getText());
				textFields.get(i).setVisible(false);
				seats.get(i).setVisible(true);
				buttons.get(i).setText("Edit");
			}
				
		}
		
		
		
		
		
		
	}
}


