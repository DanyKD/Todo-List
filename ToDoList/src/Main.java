import java.util.Calendar;
//import java.util.Date;
//import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.lang.Exception;
public class Main {
	public static void main(String[] args)  {
		
		/*SimpleDateFormat  date = new SimpleDateFormat("dd-MM-yyyy");
		date.setLenient(false);	
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter due date: ");
		String dueDate = sc.nextLine();
		System.out.println(date.parse(dueDate));*/
  
		ManageDate D=new ManageDate();
		Project p=new Project();
		D.setDue();
		System.out.print(D.getDue().getTime());
		System.out.println(D.isDue());
		Task t=new Task();
		t.setDueDate(D);
		t.setTitle("Dany");
		t.setProject(p);
		System.out.println(t.toString());
		
	}
}
