package Date;




import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.Scanner;

import Todoly.Inputs;



public class DueDate implements  Serializable , Comparable<DueDate>{
	
	private Calendar due;
	
	// create constructor of due date 
	public DueDate(){
	due=Calendar.getInstance();
	}
	// getter for due
	public Calendar getDue() {
		return this.due;
	}
	
	// setter for due
	public DueDate setDue(Inputs inputs) {
	
		boolean isNotDate=true;
		System.out.println("Please enter due date: ");
		while(isNotDate) { 
	    	 try {
	    		 //create date format
	    		 //SimpleDateFormat  date = new SimpleDateFormat("dd-MM-yyyy");  
	    		 // date object
	    		 Calendar cal= Calendar.getInstance();
	    		 cal.setLenient(false);
	    		 // input date
	    		 //Scanner sc = new Scanner(System.in);
	    		 System.out.print(">> day: ");
	    		 int Day=inputs.setInputsInt();
	    		 System.out.print(">> Month: ");
	    		 int Month=inputs.setInputsInt();
	    		 System.out.print(">> Year: ");
	    		 int Year=inputs.setInputsInt();
	    		 //sc.close();
	    		 // set date
	    		 cal.set(Year, Month-1, Day,0,0,0);
	    		 isNotDate=false;
	    		 cal.getTime();
	    		 this.due=cal;
	    	 	} 
	    	 catch(Exception e){
	    		 	System.out.println("It is not a valid date! try again:");
	    		 	isNotDate=true;
	    		 	
	    	 	}
			}
		return this;
	}
	
	// check if the date is overdue
	public boolean isDue() {
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Calendar now=Calendar.getInstance();
		
		now.set(Calendar.HOUR_OF_DAY,0);
		now.set(Calendar.MINUTE,0);
		now.set(Calendar.SECOND,0);
		now.set(Calendar.MILLISECOND, 0);
		System.out.println(due.getTime());
		System.out.println(now.getTime());
		if (due.compareTo(now)>=0)
			 return true;
		else return false;
		
	}
	
	// Format date
	public String toString() {
		
		//create date format
		 SimpleDateFormat  date = new SimpleDateFormat("dd-MM-yyyy");  
		return date.format(due.getTime()).toString();
	}

	// compare two due date
	@Override
	public int compareTo(DueDate other) {
		
		if (this.getDue().getTime() == null || other.getDue().getTime() == null)
	        
			 return 0;
		
		else return this.getDue().getTime().compareTo(other.getDue().getTime());
		
	}

}
