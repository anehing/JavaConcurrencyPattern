package vh.unmodiflableCollectiontest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ane on 1/20/15.
 */
public class test {
    public static void main (String args[]){
        List list = new ArrayList<>();
        list.add("1");
        list.add("a");
        list.add("c");
        System.out.println(list.get(1));

        List unmodifylist  = Collections.unmodifiableList(list);
        System.out.println(unmodifylist.get(1));
        unmodifylist.add(1,"w");
    }
}
