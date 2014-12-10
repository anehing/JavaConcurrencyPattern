package vh.executorservice;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;





public class test {
	interface A {
		int getZ();
	}
	final int z=4;
	test(){
		System.out.println(Thread.currentThread().getName());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test t= new test();
		System.out.println(t.z);
		System.out.println(Thread.currentThread().getName());
		final int z =3;
		System.out.println(z);
	    A  k= new A(){
			public int getZ(){
				System.out.println(Thread.currentThread().getName());
				System.out.println(z);
				return z;
			}
		};
		k.getZ();
		List list = new ArrayList();
		Method[] method = k.getClass().getMethods();
		for(int i=0;i<method.length;i++){
			list.add(method[i]);
		}
		list.forEach(System.out::println);  
		
		
	

	}

}
