import java.io.Serializable;
import java.util.Calendar;

public class Task implements Serializable{
	
	private int id;
	private String title;
	private DueDate dueDate;
	private boolean status=false;
	private  String project;
	
	Task(int id,String title,String project, DueDate dueDate) {
		
		this.title=title;
		this.project=project.toUpperCase();
		this.dueDate=dueDate;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {	
		return this.title;
	} 

	public void setTitle(String title) {
		this.title=title;
	}

	public DueDate getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(DueDate dueDate) {
		this.dueDate=dueDate;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void markAsDone() {
		this.status=true;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		
		this.project = project.toUpperCase();
	}

	public String toString() {
		
		return id +" Task Title is: "+title+" Project is: "+ project+" Due date of the Task is: "+dueDate.toString()+" Status of the task is: "+status;
	}


	
	public int compareTask(Task other) {
		
		return this.getDueDate().compareTo(other.getDueDate());
	}



}
