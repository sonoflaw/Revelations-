package accessories;

import javax.swing.JTabbedPane;

import tabs.*;

public class ClassPane extends JTabbedPane{
	public Gradebook gradebook;
	public SeatingChart seatingChart;
	public ToDoList todolist;
	public Calendar calendar;
	public WelcomeTab welcomeTab;
	
	public ClassPane(){
		gradebook = new Gradebook();
		seatingChart = new SeatingChart();
		todolist = new ToDoList();
		calendar = new Calendar();
		welcomeTab = new WelcomeTab();
		
		this.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		this.addTab("Welcome", null, welcomeTab, "Welcome");
		this.addTab("Gradebook", null, gradebook, "Gradebook");
		this.addTab("To-Do List", null, todolist, "To-Do List");
		this.addTab("Seating Chart", null, seatingChart, "Seating Chart");
		this.addTab("Calendar", null, calendar, "Calendar");
		
	}
	
	public WelcomeTab getWelcomeTab(){
		
		return welcomeTab;
	}
	
}
