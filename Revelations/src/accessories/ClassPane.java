package accessories;

import javax.swing.JTabbedPane;

import tabs.*;

public class ClassPane extends JTabbedPane{
	public Gradebook gradebook;
	public SeatingChart seatingChart;
	public ToDoList todolist;
	public Calendar calendar;
	public WelcomeTab welcomeTab;
	private String title;
	
	public ClassPane(){
		gradebook = new Gradebook();
		seatingChart = new SeatingChart();
		todolist = new ToDoList();
		calendar = new Calendar();
		welcomeTab = new WelcomeTab();
		
		this.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		this.addTab(title+"Home", null, welcomeTab, title+"Home");
		this.addTab("Gradebook", null, gradebook, "Gradebook");
		this.addTab("To-Do List", null, todolist, "To-Do List");
		this.addTab("Seating Chart", null, seatingChart, "Seating Chart");
		this.addTab("Calendar", null, calendar, "Calendar");
		
	}
	
	public Gradebook getGradebook() {
		return gradebook;
	}

	public SeatingChart getSeatingChart() {
		return seatingChart;
	}

	public ToDoList getTodolist() {
		return todolist;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public WelcomeTab getWelcomeTab(){
		
		return welcomeTab;
	}
	
	public void setTitle(String t)
	{
		title = t;
		this.setTitleAt(0, t+" Home");
		System.out.println("Title changed to "+t);
		this.revalidate();
		this.repaint();
	}
	
}
