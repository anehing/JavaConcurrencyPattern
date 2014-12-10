package vh.Map;

import java.util.Comparator;

public class UserSalaryComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		if (o1.getFirstName().compareTo(o2.getFirstName())>0) {
			return 1;
		} else {	
			return -1;	
		}
	}
}
