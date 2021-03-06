package vh.daemon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 // Deque<Event> deque = new ConcurrentLinkedDeque<Event>();
	  Deque<Event> deque = new ArrayDeque<Event>();
	  WriterTask writer = new WriterTask(deque);
	  for(int i=0; i<3; i++){
		  Thread thread = new Thread(writer);
		  thread.start();
	  }
	  CleanerTask cleaner = new CleanerTask(deque);
	  cleaner.start();
	}

}
