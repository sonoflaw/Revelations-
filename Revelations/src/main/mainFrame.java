package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import accessories.Student;

import tabs.Gradebook;
import tabs.SeatingChart;
import tabs.ToDoList;
import tabs.WelcomeTab;


public class mainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param args
	 */
	private JLabel lab1, lab2, lab3;
	private JButton button, button1;
	private JTabbedPane tabs;
	private JPanel panel1, panel2, panel3, panel4, panel5, panel6, panel7;
	private SeatingChart seats;
	private ToDoList todo;
	private WelcomeTab welcomeTab;
	private Gradebook gradebook;

	
		
	public void Frame1(){
		this.setTitle("Revelations");
		
		this.setSize(1280, 720);
		this.setVisible(true);
		panel7 = new JPanel();
		add(panel7);
        panel7.add(lab1 = new JLabel("REVELATIONS"));
        lab1.setFont(new Font("Serif", Font.PLAIN, 72));
		panel7.setVisible(true);
		panel7.setBackground(Color.lightGray);
		button1 = new JButton("Begin Program");
		panel7.add(button1);
		button1.setSize(300,100);
		//button1.setBounds(400, 500, 300, 100);
		button1.setVisible(true);
		button1.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent f)
            {
                //Execute when button is pressed
                System.out.println("Start button clicked");
                panel7.setVisible(false);
                Testing();
                
            }
        });     
		
		
	}
	public void Testing(){
		
		welcomeTab = new WelcomeTab();
		welcomeTab.setVisible(true);
		
		
		gradebook = new Gradebook();
		gradebook.setVisible(true);
		
		panel2 = new JPanel();
		panel2.setVisible(true);
		panel2.setLayout(null);
		lab3 = new JLabel("Coming Soon!");
		lab3.setFont(new Font("Serif", Font.PLAIN, 40));
		lab3.setBounds(550, 200, 400, 100);
		panel2.add(lab3);
		
		todo = new ToDoList();
		todo.setVisible(true);
		
		panel4 = new JPanel();
		panel4.setVisible(true);
		panel4.setLayout(null);
		lab2 = new JLabel("Coming Soon!");
		lab2.setFont(new Font("Serif", Font.PLAIN, 40));
		lab2.setBounds(550, 200, 400, 100);
		panel4.add(lab2);
		
		seats = new SeatingChart();
		seats.setVisible(true);
		
		
		
		tabs = new JTabbedPane();
		tabs.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		tabs.setVisible(true);
		tabs.setSize(1000, 500);
		
		tabs.addTab("Welcome", null, welcomeTab, "Overview");
		tabs.addTab("Gradebook", null, gradebook, "Edit assignments and grades");
		
		tabs.addTab("To Do", null, todo, "View your impending tasks");
		tabs.addTab("Calendar", null, panel4, "Enter important dates");
		tabs.addTab("Seating Chart", null, seats, "Vew your class layout");
		
		
		add(tabs);
		//getContentPane().setBackground(Color.green);
		

	}
	
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		mainFrame testing = new mainFrame();
		testing.Frame1();
		
	}	

	
}



