import java.util.Scanner;

public class Inputs {
	
	
	
	public static int startEntries() {
		
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
		Scanner input=new Scanner(System.in);
		int choose=input.nextInt();
		return choose;
	}

}
