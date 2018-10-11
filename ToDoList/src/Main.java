


public class Main {
	
	
	public static void main(String[] args)  {
		
		
		TaskManager T=new TaskManager();
		T.isFileAvailable();
		T.start();
		//T.createTaskWithProject();
		Inputs input =new Inputs();
		while(true) {
			input.selectCases(T);
		}
	}
}
