import java.util.Scanner;

public class Inputs {
	
	private Scanner inputs;
	
	Inputs(){
		inputs=new Scanner(System.in);
	}
	
	public int setInputsInt() {
		
		int choose=15;
		try {
		 choose=inputs.nextInt();
		
		}catch(Exception e) {
			//System.out.println(">> Pick an option: ");
			inputs.next();
		}
		return choose;
		
	}
	
	public int startEntries() {
		
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.print(">> ");
		return setInputsInt();
	}
	
	public int caseOne() {
		System.out.println(">> (1) Show Task List sorted by date.");
		System.out.println(">> (2) Show Task List filtered by project.");
		System.out.println(">> (0) Return to the main menu.");
		System.out.print(">> Pick an option: ");
		return setInputsInt();
	}
	
	public void caseTwo() {
		
	}
	
	public int caseThree() {
		System.out.println(">> (1) Update Task.");
		System.out.println(">> (2) Mark as done.");
		System.out.println(">> (3) Remove Task.");
		System.out.println(">> (0) Return to the main menu.");
		System.out.print(">> Pick an option: ");
		return setInputsInt();
	}
	
	public int caseFour() {
		System.out.println(">> (1) Save task list in file and quit.");
		System.out.println(">> (2) Quit without saving task list in a file.");
		System.out.println(">> (0) Return to the main menu.");
		System.out.print(">> Pick an option: ");
		return setInputsInt();
	}

	public void selectCases() {
	     
		int option=startEntries();	
		switch(option) {
		case 1: 
			selectCaseOne();
			break;
		case 2: 
			selectCaseTwo();
			break;
		case 3: 
			selectCaseThree();
			break;
		case 4:
			selectCaseFour();
			break;
		default:
			System.out.println("\n Please enter a number between 1 to 4. \n");
			return;
		}
	}

	public void selectCaseOne() {
		
		int option=caseOne();
		switch (option) {
		case 1:
			System.out.println("Hi Dany 1");
			break;
		case 2:
			System.out.println("Hi Dany 2");
			break;
		case 0:
			return;
		default:
			System.out.println("Please enter a number between 1 and 2.");
			break;
		}
	}
	
	public void selectCaseTwo() {
		caseTwo();
	}
	
	public void selectCaseThree() {
		
		int option=caseThree();
		switch(option) {
		case 1:
			System.out.println("Hi Dany 1");
			break;
		case 2:
			System.out.println("Hi Dany 2");
			break;
		case 3:
			System.out.println("Hi Dany 3");
			break;
		case 0:
			return;
		default: 
			System.out.println("Please enter number between 1 and 3.");
			break;
		}
	}
	
	public void selectCaseFour() {
		
		int option=caseFour();
		switch (option) {
		case 1:
			System.out.println("Saving and exit...");
			inputs.close();
			break;
		case 2:
			System.out.println("Quit without saving...Done.");
			inputs.close();
			System.exit(0);
			break;
		case 0:
			return;
		default: 
			System.out.println("Please choose between 1 and 2.");
			break;
		}
	}
}
