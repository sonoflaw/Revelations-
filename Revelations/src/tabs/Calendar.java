package tabs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Calendar extends JPanel implements ActionListener{
	
	private JTable calendarTable;
	private DefaultTableModel tableModel;
	private JComboBox yearSelect;
	private JLabel month;
	private JButton previousMonth, nextMonth;
	
	
	public Calendar(){
		tableModel = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
		calendarTable = new JTable(tableModel);
		yearSelect = new JComboBox();
		month = new JLabel("Some month");
		previousMonth = new JButton("Last month");
		nextMonth = new JButton("Next month");
		
		previousMonth.addActionListener(this);
		nextMonth.addActionListener(this);
		yearSelect.addActionListener(this);
		
		this.setLayout(null);
		
		calendarTable.setBounds(0, 100, 1280, 550);
		yearSelect.setBounds(500, 50, 100, yearSelect.getPreferredSize().height);
		month.setBounds(300, 50, month.getPreferredSize().width, month.getPreferredSize().height);
		previousMonth.setBounds(20, 50, previousMonth.getPreferredSize().width, previousMonth.getPreferredSize().height);
		nextMonth.setBounds(1120, 50, nextMonth.getPreferredSize().width, nextMonth.getPreferredSize().height);
		
		
		this.add(calendarTable);
		this.add(yearSelect);
		this.add(month);
		this.add(previousMonth);
		this.add(nextMonth);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		

	}
	
}
