package Todoly;



import java.io.Serializable;

import Date.DueDate;

public class Task implements Serializable{
	
	private int id;
	private String title;
	private DueDate dueDate;
	private String status="To Do";
	private  String project;
	private Inputs inputs;
	
	// create constructor of Task
	public Task(){
		dueDate=new DueDate();
		inputs=new Inputs();
	};
	
	// create constructor of Task with parameter
	Task(int id,String title,String project, DueDate dueDate) {
		
		this.title=title;
		this.project=project.toUpperCase();
		this.dueDate=dueDate;
	}
	
	// Getter for id
	public int getId() {
		return id;
	}

	// Setter for id
	public void setId(int id) {
		this.id = id;
	}

	// Getter for title
	public String getTitle() {	
		return this.title;
	} 

	// Setter for title
	public void setTitle(String title) {
		this.title=title;
	}

	// Getter for Due date
	public DueDate getDueDate() {
		return this.dueDate;
	}

	// Setter for due date
	public void setDueDate(DueDate dueDate) {
		this.dueDate=dueDate.setDue(inputs);
	}

	// Getter for status
	public String getStatus() {
		return this.status;
	}

	// Mark task as done
	public void markAsDone() {
		this.status="Done";
	}

	// Getter project
	public String getProject() {
		return project;
	}

	// Setter for project
	public void setProject(String project) {
		
		this.project = project.toUpperCase();
	}

	// Format Task to print
	public String toString() {
		
		return id +", Title: "+title+", Project: "+ project+", Due date: "+dueDate.toString()+", Status: "+status;
	}
	
	// Compare two tasks
	public int compareTask(Task other) {
		
		return this.getDueDate().compareTo(other.getDueDate());
	}

	// Entries
	public String enterString() {
		String str=inputs.setInputsString();
		return str;
	}
	
	/*public void addProject() {
		System.out.println("Please enter a project of the task from the list or enter a new one: ");
		String project=enterString().trim();
		this.setProject(project);
	}*/ 
	
	// Add title to a task
	public void addTitle() {
		System.out.print("Pleaee enter a title of the task >>");
		String title=enterString().trim();
		this.setTitle(title);
	} 
	
	// Add Project to a task
	public void addProject() {
			System.out.print("Pleaee enter a project of the task >>");
			String project=enterString().trim();
			this.setProject(project);
		} 
		
	// Add DueDate to a task
	public void addDueDate() {
		this.setDueDate(dueDate);
	}
	
	// Create new task without add project
	public Task createTaskWithoutProject(int id) {
		addTitle();
		setDueDate(dueDate);
		setId(id);
		return this;
	}

}
