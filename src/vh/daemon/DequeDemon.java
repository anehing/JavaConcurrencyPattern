package vh.daemon;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque de = new ArrayDeque();
		de.add("a");
		de.add("b");
		de.addFirst(1);
		de.offer("A");
		 int retval = (int) de.peek();
		System.out.println(retval);
		System.out.println(de.peek());
	}

}
