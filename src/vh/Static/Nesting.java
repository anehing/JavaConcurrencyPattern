package vh.Static;

import java.lang.reflect.Field;

public class Nesting {
	static  void Nested(){};
	class Inner{}
	void method() throws InstantiationException, IllegalAccessException{

	 System.out.println(
		new Inner(){
			int z =2;
	 	}.getClass().newInstance().z
	 	);
	 	
	 	
	}
	public static void main(String args[]) throws InstantiationException, IllegalAccessException{
		Nesting ne	=new Nesting();
		 ne.new Inner(){
			public int z =1;
			public int getZ(){
				return z;
			}
		};
		//System.out.println();
		ne.method();
	  
	}
}
