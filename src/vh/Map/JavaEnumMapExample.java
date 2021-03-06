package vh.Map;

import java.util.EnumMap;
import java.util.Map;

public class JavaEnumMapExample {
	
	public enum MealType{
		BREAKFAST,LUNCH,SNACK,DINNER
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<MealType,String> myMealMap = new EnumMap<MealType,String> (MealType.class);
		myMealMap.put(MealType.BREAKFAST,"Enjoy Milk and Eggs for breakfast!");
	    myMealMap.put(MealType.LUNCH,"Enjoy Chicken, Rice and bread for Lunch!");
	    myMealMap.put(MealType.SNACK,"How about an apple for the evening snack!");
	    myMealMap.put(MealType.DINNER,"Keep the dinner light, lets have some salad!");
	    System.out.println(myMealMap); 
	    System.out.println("Welcome to meal planner, we have suggestions for following meals : ");

	    //print all the keys of enum map in sorted order
	    System.out.println(myMealMap.keySet());
	    
	    //We can get the value from enumType
        System.out.println(" Q: What should I have for lunch? ");
        System.out.println(" A: "+myMealMap.get(MealType.LUNCH));
        
        System.out.println(" Q: What should I have for snack? ");
        System.out.println(" A: "+myMealMap.get(MealType.SNACK));
      
        System.out.println(" Q: What should I have for dinner? ");
        System.out.println(" A: "+myMealMap.get(MealType.DINNER));
        
      //Iterate over enumMap
 
        for (MealType mealType : myMealMap.keySet()) {
            System.out.println(myMealMap.get(mealType));
        }

        System.out.println("*** Checking for concurrent modification exception! ***");
        //Does not throw Concurrent modification Exception in enumMap
        
        for (MealType mealType : myMealMap.keySet()) {
            if(MealType.SNACK.equals(mealType)){
                myMealMap.remove(MealType.SNACK);
            }
        }
        //map changed without throwing Concurrent modification Exception
        System.out.println(myMealMap);     


	}
}
