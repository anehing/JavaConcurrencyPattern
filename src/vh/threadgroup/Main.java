package vh.threadgroup;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);
	}

}
