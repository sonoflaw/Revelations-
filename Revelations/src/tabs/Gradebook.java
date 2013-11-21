package tabs;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import accessories.Student;

public class Gradebook extends JPanel implements ActionListener {
	
	JButton studentbutton, zerobutton;
	
	JTextField studentname;
	
	JTextArea assignments, grades,studentgrades;
	
	Student activestudent;
	
	public ArrayList<Student>rollcall = new ArrayList<Student>();
	
	public Gradebook(){
		
		this.setLayout(null);
		
		studentbutton = new JButton("Add Student");
		studentbutton.setBounds(10,10,100,20);
		studentbutton.addActionListener(this);
		this.add(studentbutton);
		
		zerobutton = new JButton ("Add zeros");
		zerobutton.setBounds(10,30,100,20);
		zerobutton.addActionListener(this);
		this.add(zerobutton);
		
		studentname= new JTextField(8);
		studentname.setBounds(10,50,100,20);
		this.add(studentname);
		
		assignments= new JTextArea ("",5,30);
		assignments.setBounds(200,10,200,150);
		assignments.setEditable(true);
		assignments.setLineWrap(false);
		this.add(assignments);
		
		grades=new JTextArea("",5,30);
		grades.setBounds(600,10,200,150);
		grades.setEditable(true);
		grades.setLineWrap(false);
		this.add(grades);
		
		studentgrades=new JTextArea();
		studentgrades.setEditable(false);
		studentgrades.setVisible(true);
		studentgrades.setBounds(100, 200, 500, 500);
		studentgrades.setBorder(new LineBorder(Color.BLACK));
		this.add(studentgrades);
		
		this.setOpaque(true);
}
	
	@Override
	public void actionPerformed (ActionEvent e){
		if(e.getSource() == studentbutton)
		{
			String[] assignment = new String [assignments.getLineCount()];
			int[] percentage = new int [grades.getLineCount()];
			
			assignment = assignments.getText().split("\n");
			
			String[] temppercent = grades.getText().split("\n");
			
			System.out.println("LINES: " + grades.getLineCount());
			for(int i=0;i<grades.getLineCount();i++)
			{
				//System.out.println(i+": "+temppercent[i]);
				percentage[i]=Integer.parseInt(temppercent[i]);
				//System.out.println(i+"(%): "+percentage[i]);
			}
			
			Student newstud= new Student (studentname.getText(),11, percentage, assignment);
			
			rollcall.add(newstud);
			
			String string=null;
			
			for(int i=0;i<rollcall.size();i++)
			{
				string+= rollcall.get(i).getName();
				string+='\n';
				string+= rollcall.get(i).getGrades();
			}
			
			studentgrades.setText(string);
			//System.out.println(string);
			
		}
		if(e.getSource() == zerobutton)
			for(int i=0;i<rollcall.size();i++)
				rollcall.get(i).addZero();
		
		String string=null;
		
		for(int i=0;i<rollcall.size();i++)
		{
			string+= rollcall.get(i).getName();
			string+='\n';
			string+= rollcall.get(i).getGrades();
		}
		
		studentgrades.setText(string);
		
	}
}
	
	

