
import java.io.Serializable;
import java.util.Scanner;

public class Inputs implements Serializable{
	
	//private static Scanner inputs;
	
	// create constructor of inputs 
	public Inputs(){
		
	}
	
	// User input of integer
	public int setInputsInt() {
		Scanner inputs=new Scanner(System.in);
		int choose=0;
		try {
		 choose=inputs.nextInt();
		
		}catch(Exception e) {
			inputs.next();
		}
		return choose;
	}
	
	// User input of String
	public String setInputsString() {
		Scanner inputs=new Scanner(System.in);
		String str=null;
		try {
		 str=inputs.nextLine();
		
		}catch(Exception e) {
			inputs.next();
		}
		return str;
	}
	
	// Show the main menu 
	public int startEntries() {
		
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.println(">> Pick an option:");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		System.out.println("***********************************************");
		System.out.println("***********************************************");
		System.out.print(">> ");
		return setInputsInt();
	}
	
	//Show sub menu of Task List (by date or project)
	public int caseOne() {
		System.out.println(">> Pick an option: ");
		System.out.println(">> (1) Show Task List sorted by date.");
		System.out.println(">> (2) Show Task List filtered by project.");
		System.out.println(">> (0) Return to the main menu.");
		System.out.print(">> ");
		return setInputsInt();
	}
	
	public int casesOfUpdateTask() {
		System.out.println(">> Pick an option: ");
		System.out.println(">> (1) Update Task title.");
		System.out.println(">> (2) Update Task due date.");
		System.out.println(">> (3) Update Task project.");
		System.out.println(">> (0) Return to the back menu.");
		System.out.print(">> ");
		return setInputsInt();
	}
	
	// show sub menu of Edit Task
	public int caseThree() {
		System.out.println(">> Pick an option: ");
		System.out.println(">> (1) Update Task.");
		System.out.println(">> (2) Mark as done.");
		System.out.println(">> (3) Remove Task.");
		System.out.println(">> (0) Return to the main menu.");
		System.out.print(">> ");
		return setInputsInt();
	}
	
	// show sub menu of Save and Quit
	public int caseFour() {
		System.out.println(">> Pick an option: ");
		System.out.println(">> (1) Save task list in file and quit.");
		System.out.println(">> (2) Quit without saving task list in a file.");
		System.out.println(">> (0) Return to the main menu.");
		System.out.print(">> ");
		return setInputsInt();
	}

	// Switch cases for the main menu
	public void selectCases(TaskManager t) {
	     
		int option=startEntries();	
		switch(option) {
		case 1: 
			selectCaseOne(t);
			break;
		case 2: 
			selectCaseTwo(t);
			break;
		case 3: 
			selectCaseThree(t);
			break;
		case 4:
			selectCaseFour(t);
			break;
		default:
			System.out.println("\n Please enter a number between 1 to 4. \n");
			return;
		}
	}

	// Switch cases for the first sub menu
	public void selectCaseOne(TaskManager t) {
		
		// User input of integer
		int option=caseOne();
		switch (option) {
		case 1:
			// Display all Tasks sorted by date
			if(t.tasksCount()!=0)
			t.displayAllTasks();
			else System.out.println("\nThere is no tasks to display.\n");
			break;
		case 2:
			// Display all Tasks filtered by project
			System.out.print("Please enter a project you need to filter it >>");
			String project=setInputsString();
			if(t.tasksCount()!=0)
			t.displayTasksByProject(project);
			else System.out.println("\nThere is no tasks to display.\n");
			break;
		case 0:
			// Back to the main menu
			return;
		default:
			// message for wrong inputs
			System.out.println("Please enter a number between 1 and 2.");
			break;
		}
	}

	// Add new Task
	public void selectCaseTwo(TaskManager t) {
		//caseTwo();
		Task task=new Task();
		// Display all project if exist
		t.displayProject();
		System.out.print("Please enter a project >>");
		String project=setInputsString();
		// Added project to the task 
		t.createTaskWithProject(task, project);
		// Added task to task manager
		t.addTask(task);
		System.out.println(t.allTasks().toString());
	}
	
	
	// Switch cases for the third sub menu
	public void selectCaseThree(TaskManager t) {
		
		int option=caseThree();
		switch(option) {
		case 1:
			selectCasesOfUpdateTask(t);
			break;
		case 2:
			// Ask User to input task id
			int taskId=askForTaskId("mark as done",t);
			// Mark task as done
			t.markTaskAsDone(taskId);
			break;
		case 3:
			// Ask User to input task id
		    taskId=askForTaskId("remove",t);
			// Remove task
		    t.removeTask(taskId);
			break;
		case 0:
			// return to main menu
			return;
		default: 
			// Print message to user for wrong entry
			System.out.println("Please enter number between 1 and 3.");
			break;
		}
	}
	
	// Switch cases for the fourth sub menu
	
	public void selectCaseFour(TaskManager t) {
		// User input of integer
		int option=caseFour();
		switch (option) {
		case 1:
			// Saving data to a file and exit 
			if(t.writeToFile()) {
			System.out.println("Saving and exit...Done.");
			//inputs.close();
			System.exit(0);
			}
			break;
		case 2:
			// exit without saving
			System.out.println("Quit without saving...Done.");
			//inputs.close();
			System.exit(0);
			break;
		case 0:
			// Back to main menu
			return;
		default: 
			// Print message to user for wrong entry
			System.out.println("Please choose between 1 and 2.");
			break;
		}
	}

	
	// User entry for task id
	public int askForTaskId(String function,TaskManager t) {
		t.displayAllTasks();
		System.out.print("Please enter task number you want to "+function+" >>");
		return setInputsInt();
		
	}

	// Update task 
	public void selectCasesOfUpdateTask(TaskManager t) {
		int option=casesOfUpdateTask();
		// Ask User to input task id
		switch(option) {
		case 1:
			int taskId=askForTaskId("update title",t);
			t.updateTaskTitle(taskId);
			break;
		case 2:
			taskId=askForTaskId("update due date",t);
			t.updateTaskDueDate(taskId);
			break;
		case 3:
			taskId=askForTaskId("update project",t);
			t.updateTaskProject(taskId);
			break;
		case 0: 
			return;
		default:
			System.out.println("Task could not updated");
			break;
		}
	}

}
