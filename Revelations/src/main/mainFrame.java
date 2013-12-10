package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import accessories.ClassPane;
import accessories.Student;

import tabs.Gradebook;
import tabs.SeatingChart;
import tabs.ToDoList;
import tabs.WelcomeTab;


public class mainFrame extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	private JLabel title, question;
	private JPanel panel7;
	
	private ArrayList<ClassPane> classes = new ArrayList<ClassPane>();
	private ArrayList<JButton> classButtons = new ArrayList<JButton>();
	private ArrayList<JButton> editClassesButtons = new ArrayList<JButton>();
	private ArrayList<JTextField> editClasses = new ArrayList<JTextField>();
	private JTextField enterClasses;
		
	public void Frame1(){
		this.setTitle("Revelations");
		this.setLayout(null);
		this.setSize(1280, 720);
		this.setVisible(true);
		
		panel7 = new JPanel();
		panel7.setVisible(true);
		add(panel7);
		
        panel7.add(title = new JLabel("REVELATIONS"));
        title.setFont(new Font("Serif", Font.PLAIN, 72));
        title.setBounds(400, 0, 1000, 100);
        
		panel7.setBackground(Color.lightGray);
		panel7.setSize(1280, 720);
		panel7.setLayout(null);
		
		
		question = new JLabel("Please enter the number of classes that you would like to start out with");
		question.setBounds(400,150,500,50);
		
		enterClasses = new JTextField();
		enterClasses.setBounds(570, 200, 100, 20);
		enterClasses.addActionListener(this);
		
		panel7.add(question);
		panel7.add(enterClasses);
		
	}
	
	public void createClass(int i){
		int x = 100, y = 100, height = 200, width = 200, temp = 0;
		
		classButtons.add(new JButton("Class "+(i+1)));
		classButtons.get(i).addActionListener(this);
		editClasses.add(new JTextField("Enter class name"));
		editClasses.get(i).setHorizontalAlignment(SwingConstants.CENTER);
		editClasses.get(i).addActionListener(this);
		editClassesButtons.add(new JButton("Edit class name"));
		editClassesButtons.get(i).addActionListener(this);
		classes.add(new ClassPane());
		classes.get(i).getWelcomeTab().getButton().addActionListener(this);
		
		for (int a = 0; a<i; a++)
		{
			x+= 220;
			temp++;
			if (temp >= 5)
			{
				y+=240;
				x = 100;
				temp = 0;
			}
		}
		
		classButtons.get(i).setBounds(x, y, width, height);
		editClasses.get(i).setBounds(x, y, width, height);
		editClassesButtons.get(i).setBounds(x, y+200, width, 20);
		editClasses.get(i).setVisible(false);
		panel7.add(classButtons.get(i));
		panel7.add(editClasses.get(i));
		panel7.add(editClassesButtons.get(i));
		panel7.revalidate();
		panel7.repaint();
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		mainFrame revelations = new mainFrame();
		revelations.Frame1();	
	}	

	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if(e.getSource() == enterClasses)
		{
			System.out.println("Create "+enterClasses.getText()+ " classes");
			question.setVisible(false);
			enterClasses.setVisible(false);
			for (int i = 0; i<Integer.parseInt(enterClasses.getText());i++ )
			{
				createClass(i);
				
			}
		}
		
		
		
		else for (int i = 0; i<classes.size(); i++)
		{
			if (e.getSource() == classButtons.get(i))
			{
				panel7.setVisible(false);
				classes.get(i).setVisible(true);
				classes.get(i).setSize(1280, 720);
				this.add(classes.get(i));
			}
			
			else if(e.getSource() == classes.get(i).getWelcomeTab().getButton())
			{
				classes.get(i).setVisible(false);
				panel7.setVisible(true);
			}
			
			else if(e.getSource() == editClasses.get(i))
			{
				editClasses.get(i).setVisible(false);
				classButtons.get(i).setText(editClasses.get(i).getText());
				classButtons.get(i).setVisible(true);
				
			}
			
			else if(e.getSource() == editClassesButtons.get(i))
			{
				classButtons.get(i).setVisible(false);
				editClasses.get(i).setVisible(true);
			}
		}
	}	
}



