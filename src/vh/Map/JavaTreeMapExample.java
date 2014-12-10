package vh.Map;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class JavaTreeMapExample {

	private static void populateUserMap(Map<User,String> userMap) {
		userMap.put(new User("Ani","Bha",12), "My Name1");
		userMap.put(new User("Cal","YYY",15), "My Name2");
		userMap.put(new User("XYZ","WER",22), "My Name3");
		userMap.put(new User("SSS","TER",1), "My Name4");
	}
	private static void diplayMap(Map<User,String> userMap) {
		Set<User> keySet = userMap.keySet();
		for (User user : keySet) {
			System.out.println(user.toString());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Natural ordering of key Integer
		Map<User,String> userMap = new TreeMap<User,String>();
		populateUserMap(userMap);
		Map<User,String> userSalaryMap = new TreeMap<User,String>(new UserSalaryComparator());
		populateUserMap(userSalaryMap);

		System.out.println(userSalaryMap.toString());
		
		diplayMap(userMap);
	}

}
