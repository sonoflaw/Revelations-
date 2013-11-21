package accessories;

import java.util.*;

public class Student 
{
    private String name;
    private int classperiod;
	public ArrayList<Grade> gradebook;
	
	public Student(String name,int classperiod,int iGrade[], String cGrade[]){
		
		gradebook = new ArrayList<Grade>();
		setName(name);
		setClassperiod(classperiod);
		
		for(int i=0;i<cGrade.length;i++)
		{
			int x=iGrade[i];
			
			if(i>iGrade.length)
				x=0;
			
			addGrade(cGrade[i],x);
		}
	}
	
	public String getGrades()
	{
		String graduate = null;
		
		for(int i=0;i<gradebook.size();i++)
		{
			graduate+=gradebook.get(i).getCategory();
			
			graduate+=' ';
			
			graduate+=gradebook.get(i).getPercentage();
			
			graduate+='\n';
		}
		
		return graduate;
	}
	
	public void addGrade(String catergory,int percent)
	{
		Grade newgrade = new  Grade(percent, catergory);
		
		gradebook.add(newgrade);
	}
	
	public void addZero()
	{
		addGrade("Quiz",0);
	}
	
	
	public int calculateAverage()
	{
		int x = 0;
		
		for(int i=0;i<gradebook.size();i++)
			x+=(gradebook.get(i)).getPercentage();
					
		x=x/gradebook.size();
		
		return x;
	}
	
	class Grade
	{
		private int percentage;
		private String category;
		
		public Grade (int p, String c) {
			setPercentage(p);
			setCategory(c);
		}

		public int getPercentage() {
			return percentage;
		}

		public void setPercentage(int percentage) {
			this.percentage = percentage;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassperiod() {
		return classperiod;
	}

	public void setClassperiod(int classperiod) {
		this.classperiod = classperiod;
	}
	
}

