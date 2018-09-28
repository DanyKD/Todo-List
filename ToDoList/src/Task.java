import java.util.Calendar;

public class Task {
	
	private String title;
	private ManageDate dueDate;
	private boolean status=false;
	private Project project;
	
	public String getTitle() {	
		return this.title;
	} 
	public void setTitle(String title) {
		this.title=title;
	}
	public ManageDate getDueDate() {
		return this.dueDate;
	}
	public void setDueDate(ManageDate dueDate) {
		this.dueDate=dueDate;
	}
	public boolean getStatus() {
		return this.status;
	}
	public void markAsDone() {
		this.status=true;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
