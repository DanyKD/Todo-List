
 
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.stream.Collectors;

public class TaskManager implements Serializable{
	//private int taskCount;
	private static HashMap<String,ArrayList<Task>> toDoList=new HashMap<>();
	private final String toDoFileName = "ToDoList.bin";
	FileManager FManger = new FileManager();
	
  // Check if a file is exist
  public void isFileAvailable() {
		String projectPath=System.getProperty("user.dir");
		//System.out.println("Project Path: " + projectPath);
		File currentDir= new File(projectPath);
		checkFileInDirectory(currentDir);
	}
	
  // Check the directory of project if the file is exist
  public static void checkFileInDirectory(File dir) {
		File[] files=dir.listFiles();
		boolean toDoListFile=true;
		for(File file:files) {
			if(file.getName().contains("ToDoList.bin")) {
				toDoListFile=false;
			}
		}
		if(toDoListFile) {
			TaskManager Tmanager=new TaskManager();
			Tmanager.writeToFile();
		} else {
			TaskManager Tmanager=new TaskManager();
			Tmanager.loadFromFile();
		}
	}

  // Add task to the list
  public  void addTask(Task task){
			
		 ArrayList<Task> taskList = toDoList.get(task.getProject());
		 
		    // if list does not exist create it
		    if(taskList == null) {
		         taskList = new ArrayList<Task>();
		         taskList.add(task);
		    } else {
		        // add if Task is not already in list
		        taskList.add(task);
		    }
		    toDoList.put(task.getProject(), taskList);
		    
	}
	
  // Check if the project is already exist in the list
  public boolean isProjectAvailable(String project) {
		try {
			if(toDoList.containsKey(project.toUpperCase()))
			 return true;
		else return false;
		}catch(Exception e) {
		System.out.println(e);
		return false;
		}
		
	}
	
  // add project to the list if the project not in the list
  public String assignProject(String project) {
		if(isProjectAvailable(project)){
			return project.toUpperCase();
		} else {
			toDoList.put(project.toUpperCase(),new ArrayList<Task>());
			return project.toUpperCase();
		} 
	}
	
  // Write list to the file
  public boolean writeToFile() {
        return FManger.write(toDoFileName, toDoList);
    }
	
  // load list from the file
  public void loadFromFile() {
        toDoList= (HashMap<String,ArrayList<Task>>)FManger.read(toDoFileName);
    }
 
  // Format list to print
  public String toString() {
		if(toDoList==null)
			return "there is no task to do.";
		else 
			return toDoList.toString();
	}
	
  // put all tasks in array list 
  public ArrayList<Task> allTasks() {
		return toDoList.values()
					   .stream()
					   .flatMap(Collection::stream)
					   .collect(Collectors.toCollection(ArrayList::new));
								      
	}
	
  // Sort all tasks by date
  public void displayAllTasks() {
	   
	 allTasks().stream()	  
	              .sorted(Task::compareTask)
				  .forEach(e->{
					  System.out.println("TaskId: "+e.toString()+"\n");
				  });
	}

  // Display all Tasks of certain project
  public void displayTasksByProject(String project) {
		
	if(isProjectAvailable(project)) {
	
			toDoList.entrySet()
					.stream()
					.filter(s->s.getKey().equals(project.toUpperCase()))
					.map(s->s.getValue())
					.flatMap(s->s.stream())
					.forEach(e -> {
						System.out.format("Task: %s \n", e.toString());
					});
			}
	else System.out.println("The project "+project+" does not exist.");
	}

  // Create task id by added one to the count of list
  public int getTaskId() {
	 return allTasks().size()+1;
 }
 
  // Count of tasks by certain status
  public int taskCountBystatus(String status) {
		
		return (int)allTasks().stream()
				         .filter(s->s.getStatus().equals(status))
				         .map(s->s.getStatus())
				         .count();
	}
	
  // Count of tasks of status to do
  public int tasksToDoCount() {
		return taskCountBystatus("To Do");
	}
	
//Count of tasks of status Done
  public int tasksAreDoneCount() {
		return taskCountBystatus("Done");
	}
	
  // Welcome message 
  public void start() {
		
	 System.out.println("***********************************************");
	 System.out.println(">> Welcome toDoly");
	 System.out.println(">> You have "+tasksToDoCount()+" tasks todo and "+tasksAreDoneCount()+" tasks are done!");

	}

  // add id to list of tasks
  public ArrayList<Task> setTasksId(){
	  ArrayList<Task> updateIdList=allTasks();
	  Iterator<Task> it=updateIdList.iterator();
	  int countId=1;
	  while(it.hasNext()) {
		  Task task=it.next();
		  task.setId(countId);
		  countId++;
	  }
	  return updateIdList;
	  
 }

  // Search about certain task
  public Task getTask(int id) {
	 
	 try{return toDoList.values()
	 		 .stream()
			 .flatMap(Collection::stream)
	 		 .filter(t->t.getId()==id)
	 		 .findFirst()
	 		 .get();
	 }catch(Exception e) {
		 return null;
	 }
 }

  // Remove task from the list
  public void removeTask(int id) {
    Task task=getTask(id);
    try{
    	if(toDoList.get(task.getProject()).removeIf(e->e.equals(task)))
    	System.out.println("Task number: "+id+" is removed from the list");
    	else System.out.println("Task number:"+id+" not found");
    }catch(Exception e) {
    	System.out.println("Task number:"+id+" not found");
    }
 }

  // Count of tasks
  public int tasksCount() {
	return (int)toDoList.values().stream().flatMap(Collection::stream).count();
}

  // Display projects in the list
  public void displayProject() {
	
	 if(toDoList.size()!=0) {
		 System.out.println("Available projects are: ");
		 toDoList.entrySet()
			 	 .stream()
			 	 .map(e->e.getKey())
			 	 .forEach(e-> {
			 	     System.out.println("*  "+ e.toString());	 
			 	     });}
	 else System.out.println("There is no avaliable project.");
			 //.collect(Collectors.toCollection(ArrayList::new)); 
  }

  // Add project to the task
  public Task createTaskWithProject(Task task,String project){
	 
	 task.createTaskWithoutProject(tasksCount()+1);
	 project=assignProject(project);
	 if(project!=null)
		 task.setProject(project);
	 else System.out.println("There is no entries to add.");
	 return task;
 }
 
  // Mark task as done
  public void markTaskAsDone(int id) {
 try{
	 	Task task=getTask(id);
	 	if(task.getStatus().equals("To Do")) {
	 		task.markAsDone();
	 		System.out.println("Task number: "+id+" is mark as done.");
	 	}
	 	else System.out.println("Task number: "+id+" is already Done.");
    }catch(Exception e) {
 	   	System.out.println("Task number:"+id+" not found");
 }
 }
}

