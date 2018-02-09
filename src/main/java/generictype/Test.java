package generictype;

import java.util.ArrayList;
import java.util.List;

public class Test<A> {
    public List<A> list = new ArrayList<A>();

    public static void main(String[] args) {
        Test<String> test = new Test<String>();
        test.list.add("Hello");
        System.out.println(test.list);
    }
}
