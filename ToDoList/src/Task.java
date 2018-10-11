import java.io.Serializable;

public class Task implements Serializable{
	
	private int id;
	private String title;
	private DueDate dueDate;
	private String status="To Do";
	private  String project;
	private Inputs inputs;
	
	Task(){
		dueDate=new DueDate();
		inputs=new Inputs();
	};
	
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
		this.dueDate=dueDate.setDue(inputs);
	}

	public String getStatus() {
		return this.status;
	}

	public void markAsDone() {
		this.status="Done";
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

	public String enterString() {
		String str=inputs.setInputsString();
		return str;
	}
	
	/*public void addProject() {
		System.out.println("Please enter a project of the task from the list or enter a new one: ");
		String project=enterString().trim();
		this.setProject(project);
	}*/ 
	
	public void addTitle() {
		System.out.println("Pleaee enter a title of the task: ");
		String title=enterString().trim();
		this.setTitle(title);
	} 
	
	
	public Task createTaskWithoutProject(int id) {
		addTitle();
		setDueDate(dueDate);
		setId(id);
		return this;
	}
}
