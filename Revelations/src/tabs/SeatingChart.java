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


//Previous code//////////////

/*
		
		if(e.getSource() == button1){
			s1.setVisible(false);
			t1.setVisible(true);	
		}
		if(e.getSource() == t1){
			s1.setText(t1.getText());
			t1.setVisible(false);
			s1.setVisible(true);	
		}
		
		if(e.getSource() == button2){
			s2.setVisible(false);
			t2.setVisible(true);	
		}
		if(e.getSource() == t2){
			s2.setText(t2.getText());
			t2.setVisible(false);
			s2.setVisible(true);	
		}
		
		if(e.getSource() == button3){
			s3.setVisible(false);
			t3.setVisible(true);	
		}
		if(e.getSource() == t3){
			s3.setText(t3.getText());
			t3.setVisible(false);
			s3.setVisible(true);	
		}
		
		if(e.getSource() == button4){
			s4.setVisible(false);
			t4.setVisible(true);	
		}
		if(e.getSource() == t4){
			s4.setText(t4.getText());
			t4.setVisible(false);
			s4.setVisible(true);	
		}
		
		if(e.getSource() == button5){
			s5.setVisible(false);
			t5.setVisible(true);	
		}
		if(e.getSource() == t5){
			s5.setText(t5.getText());
			t5.setVisible(false);
			s5.setVisible(true);	
		}
		*/

/*public void init(){
	
	
	s1 = new Seat("Student1");
	s2 = new Seat("Student2");
	s3 = new Seat("Student3");
	s4 = new Seat("Student4");
	s5 = new Seat("Student5");
	
	button1 = new JButton("Edit");
	button1.addActionListener(this);
	button2 = new JButton("Edit");
	button2.addActionListener(this);
	button3 = new JButton("Edit");
	button3.addActionListener(this);
	button4 = new JButton("Edit");
	button4.addActionListener(this);
	button5 = new JButton("Edit");
	button5.addActionListener(this);
	
	t1 = new JTextField("Student");
	t1.addActionListener(this);
	t1.setVisible(false);
	t2 = new JTextField("Student");
	t2.addActionListener(this);
	t2.setVisible(false);
	t3 = new JTextField("Student");
	t3.addActionListener(this);
	t3.setVisible(false);
	t4 = new JTextField("Student");
	t4.addActionListener(this);
	t4.setVisible(false);
	t5 = new JTextField("Student");
	t5.addActionListener(this);
	t5.setVisible(false);
	
	this.setLayout(null);
	
	s1.setBounds(10, 10, 100, 100);
	s2.setBounds(120, 10, 100, 100);
	s3.setBounds(230, 10, 100, 100);
	s4.setBounds(340, 10, 100, 100);
	s5.setBounds(450, 10, 100, 100);
	
	t1.setBounds(10, 10, 100, 100);
	t2.setBounds(120, 10, 100, 100);
	t3.setBounds(230, 10, 100, 100);
	t4.setBounds(340, 10, 100, 100);
	t5.setBounds(450, 10, 100, 100);
	
	button1.setBounds(10, 120, 100, 20);
	button2.setBounds(120, 120, 100, 20);
	button3.setBounds(230, 120, 100, 20);
	button4.setBounds(340, 120, 100, 20);
	button5.setBounds(450, 120, 100, 20);
	
	
	this.add(s1);
	this.add(s2);
	this.add(s3);
	this.add(s4);
	this.add(s5);
	this.add(button1);
	this.add(button2);
	this.add(button3);
	this.add(button4);
	this.add(button5);
	this.add(t1);
	this.add(t2);
	this.add(t3);
	this.add(t4);
	this.add(t5);
	
	
	
	

}*/


