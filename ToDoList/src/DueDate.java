import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class DueDate implements Serializable{
	
	private Calendar due;
	
	
	DueDate(){
		setDue();
	}
	
	public Calendar getDue() {
		return this.due;
	}
	
	public void setDue() {
	
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
	    		 Scanner sc = new Scanner(System.in);
	    		 System.out.print(">> day: ");
	    		 int Day=sc.nextInt();
	    		 System.out.print(">> Month: ");
	    		 int Month=sc.nextInt();
	    		 System.out.print(">> Year: ");
	    		 int Year=sc.nextInt();
	    		 // set date
	    		 cal.set(Year, Month-1, Day,0,0,0);
	    		 isNotDate=false;
	    		 cal.getTime();
	    		 this.due=cal;
	    	 	} 
	    	 catch(Exception e){
	    		 	System.out.println("Its not a valid date! try again:");
	    		 	isNotDate=true;
	    	 	}
			}
	}
	
	
	public boolean isDue() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
	
	public String toString() {
		
		//create date format
		 SimpleDateFormat  date = new SimpleDateFormat("dd-MM-yyyy");  
		return date.format(due.getTime()).toString();
	}

}
