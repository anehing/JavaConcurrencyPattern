package vh.exception;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
