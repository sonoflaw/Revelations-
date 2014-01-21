package tabs;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Dimension;

public class ToDoList extends JPanel implements ActionListener{

	private JLabel todo, enter, jlab;
	private JTextField field;
	private JButton add1;
//	private JTextArea tarea;
	int i = 0;
	private ArrayList<JLabel> tasks = new ArrayList<JLabel>();
	private ArrayList<JRadioButton> checkBoxes = new ArrayList<JRadioButton>();

	
	public void addTask() {
		
		System.out.println("add task");
		int height = 300;
		/*String[] tasks = new String[50];
		String temp = new String();
		field.selectAll();
		temp = field.getText();
		tasks[i] = temp;
		jlab = new JLabel();
		jlab.setText(temp);
		jlab.setVisible(true);
		jlab.setBounds(400, 200, 100, 50);
		this.add(jlab);*/
		for (int a =0; a<i; a++)
		{
			
			height += 75;
			System.out.println("added to height");
			
		}
		
		tasks.add(new JLabel(field.getText()));
		tasks.get(i).setBounds(400, height, 100, 50);
		tasks.get(i).setVisible(true);
		tasks.get(i).setBorder(new LineBorder(Color.black));
		tasks.get(i).setHorizontalAlignment(SwingConstants.CENTER);
		this.add(tasks.get(i));
		tasks.get(i).revalidate();
		tasks.get(i).repaint();
		
		checkBoxes.add(new JRadioButton());
		checkBoxes.get(i).setBounds(510, height + 20, 30, 30);
		checkBoxes.get(i).setVisible(true);
		this.add(checkBoxes.get(i));
		checkBoxes.get(i).revalidate();
		checkBoxes.get(i).repaint();
		
		i++;
		System.out.println("finished");
	}
	
	public ToDoList() {
		
		
		todo = new JLabel("TO DO");
		todo.setFont(new Font("Serif", Font.PLAIN, 48));
		enter = new JLabel("Your current tasks");
		enter.setFont(new Font("Serif", Font.PLAIN, 36));
		//add1 = new JButton("Clear");
		field = new JTextField(30);
		this.setLayout(null);
		
		field.addActionListener(this);
		
		//add1.addActionListener(this);
		
		todo.setVisible(true);
		enter.setVisible(true);
		field.setVisible(true);
		//add1.setVisible(true);
		
		this.setLayout(null);
		todo.setBounds(425,10,150,75);
		enter.setBounds(375,225,400,50);
		field.setBounds(450,100,100,40);
		//add1.setBounds(850, 10, 100, 50);
		
		this.add(todo);
		this.add(enter);
		this.add(field);
		//cesthis.add(add1);
		
	
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == field){
			
			addTask();
		}
		
		/*if(e.getSource() == add1){
			for(int a = 0; a<i; a++){
				this.remove(tasks.get(i));
				this.remove(checkBoxes.get(i));
				
			}
			
			tasks.clear();
			checkBoxes.clear();
			i = 0;
			
		}*/
		
		
	}
}



/*import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ToDoList extends JPanel {
	
	private JLabel todo, enter;
	private JTextField field;
	private JButton add1;
	private JTextArea tarea;
	
	public ToDoList() {
		
		todo = new JLabel("TO DO");
		todo.setFont(new Font("Serif", Font.PLAIN, 48));
		enter = new JLabel("Your current tasks");
		enter.setFont(new Font("Serif", Font.PLAIN, 36));
		field = new JTextField(30);
		add1 = new JButton("Clear");
		tarea = new JTextArea(5,20);
		tarea.setEditable(false);
		
		field.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				String text = field.getText();
				tarea.append(text+ "\n");
				field.selectAll();
				tarea.setCaretPosition(tarea.getDocument().getLength());
			}
		});
		
		add1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt1) {
				tarea.setText("");
			}
		});
		
		todo.setVisible(true);
		enter.setVisible(true);
		field.setVisible(true);
		add1.setVisible(true);
		
		this.setLayout(null);
		todo.setBounds(425,10,150,75);
		enter.setBounds(375,225,400,50);
		field.setBounds(450,100,100,40);
		add1.setBounds(850, 10, 100, 50);
		tarea.setBounds(360,300,300,200);
		this.add(todo);
		this.add(enter);
		this.add(field);
		this.add(add1);
		this.add(tarea);
	
	}
}*/
