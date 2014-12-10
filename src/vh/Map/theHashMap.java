package vh.Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author ane
 *
 * @version 11:13:20 AM 2014
 *
 */
public class theHashMap {
    public static void main(String[] args) {
    	TreeMap<Long,Long> map = new TreeMap<Long,Long>();
        map.put(new Long(1), new Long(1));//这里的key是Long类型
        Integer key = new Integer(1);
        boolean result = map.containsKey(key.longValue());//这里的key是Integer类型
        System.out.println(result);
        System.out.println(map.firstKey());
    }

}
