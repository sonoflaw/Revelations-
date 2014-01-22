package tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Calendar extends JPanel implements ActionListener{
	
	private JTable calendarTable;
	private DefaultTableModel tableModel;
	private JComboBox yearSelect;
	private JLabel month;
	private JButton previousMonth, nextMonth;
	private GregorianCalendar gc;
	private int thisDay, thisMonth, thisYear, selectedMonth, selectedYear;
	private String [] weekdays = {"Sunday", "Monday", "Teusday", "Wednesday", "Thursday", "Friday", "Saturday"};
	private String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	public Calendar(){
		tableModel = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		calendarTable = new JTable(tableModel);
		yearSelect = new JComboBox();
		gc = new GregorianCalendar();
		month = new JLabel("Some month");
		previousMonth = new JButton("Last month");
		nextMonth = new JButton("Next month");
		
		
		
		previousMonth.addActionListener(this);
		nextMonth.addActionListener(this);
		yearSelect.addActionListener(this);
		
		
		
		this.setLayout(null);
		
		calendarTable.setBounds(50, 100, 1100, 550);
		yearSelect.setBounds(500, 50, 100, yearSelect.getPreferredSize().height);
		month.setBounds(300, 50, month.getPreferredSize().width, month.getPreferredSize().height);
		previousMonth.setBounds(20, 50, previousMonth.getPreferredSize().width, previousMonth.getPreferredSize().height);
		nextMonth.setBounds(1120, 50, nextMonth.getPreferredSize().width, nextMonth.getPreferredSize().height);
		
		
		this.add(calendarTable);
		this.add(yearSelect);
		this.add(month);
		this.add(previousMonth);
		this.add(nextMonth);
		
		thisDay = gc.get(GregorianCalendar.DAY_OF_MONTH);
		thisMonth = gc.get(GregorianCalendar.MONTH);
		thisYear = gc.get(GregorianCalendar.YEAR);
		selectedMonth = thisMonth;
		selectedYear = thisYear;
		
		for(int i = 0; i<7; i++)
		{
			tableModel.addColumn(weekdays[i]);
		}
		
		//calendarTable.getParent().setBackground(calendarTable.getBackground());
		
		calendarTable.getTableHeader().setResizingAllowed(false);
		calendarTable.getTableHeader().setReorderingAllowed(false);
		
		calendarTable.setColumnSelectionAllowed(true);
		calendarTable.setRowSelectionAllowed(true);
		calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		calendarTable.setRowHeight(90);
		tableModel.setColumnCount(7);
		tableModel.setRowCount(6);
		
		for (int i=thisYear-100; i<=thisYear+100; i++){
			yearSelect.addItem(String.valueOf(i));
		}
		
		refresh(thisMonth, thisYear);
		
	}
	
	public void refresh(int someMonth, int someYear)
	{
		int daysInMonth, firstOfMonth;
		
		month.setText(months[someMonth]);
		yearSelect.setSelectedItem(String.valueOf(someYear));
		
		
		for (int i=0; i<6; i++){
			for (int a=0; a<7; a++){
				tableModel.setValueAt(null, i, a);
			}
		}
		
		gc.set(someYear, someMonth, 1);
		daysInMonth = gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		firstOfMonth = gc.get(GregorianCalendar.DAY_OF_WEEK);
		
		int row, column;
		
		for (int i = 1; i<=daysInMonth; i++)
		{
			row = new Integer((i+firstOfMonth-2)/7);
			column  =  (i+firstOfMonth-2)%7;
			tableModel.setValueAt(i, row, column);
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		if (e.getSource() == previousMonth)
		{
			if (selectedMonth == 0 && selectedYear == thisYear-100)
				System.out.println("Error: Cannot go beyond 100 years before current year");
			
			else if (selectedMonth == 0)
			{
				selectedMonth = 11;
				selectedYear = selectedYear-1;
			}
			else selectedMonth = selectedMonth - 1;
			
			refresh(selectedMonth, selectedYear);
		}
		
		if (e.getSource() == nextMonth)
		{
			if(selectedMonth == 11 && selectedYear == thisYear+100)
				System.out.println("Error: Cannot go beyond 100 years after current year");
			
			else if (selectedMonth == 11)
			{
				selectedMonth = 0;
				selectedYear = selectedYear+1;
			}
			else selectedMonth = selectedMonth+1;
			
			refresh(selectedMonth, selectedYear);
		}
		
		if (e.getSource() == yearSelect)
		{
			
			if (yearSelect.getSelectedItem() != null)
			{
				String a = yearSelect.getSelectedItem().toString();
				selectedYear = Integer.parseInt(a);
				refresh(selectedMonth, selectedYear);
			}
		}
		

	}
	
}
