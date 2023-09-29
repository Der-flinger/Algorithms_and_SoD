import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;

/**
 * prog
 */
public class prog {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        Employee employee1 = new Employee("user1", 38);
        Employee employee2 = new Employee("user2", 46);
        Employee employee3 = new Employee("user3", 41);

        System.out.println(new DecimalFormat("###,###").format(employee1.hashCode()));
        System.out.println(new DecimalFormat("###,###").format(employee2.hashCode()));
        System.out.println(new DecimalFormat("###,###").format(employee3.hashCode()));

        HashMap<String, String> hashMap = new HashMap<>(4);
        String oldValue = hashMap.put("+79001112233", "AAAAAAAAA");
        oldValue = hashMap.put("+79001112231", "BBBBBB");
        oldValue = hashMap.put("+79001112232", "CCCCCC");
        oldValue = hashMap.put("+79001112233", "DDDDDDDD");
        oldValue = hashMap.put("+79001112234", "EEEEEEE");
        oldValue = hashMap.put("+79001112235", "MMMMMM");
        oldValue = hashMap.put("+79001112236", "FFFFF");
        oldValue = hashMap.put("+79001112237", "GGGGG1");
        oldValue = hashMap.put("+79001112238", "GGGGG2");
        oldValue = hashMap.put("+79001112239", "GGGGG3");
        oldValue = hashMap.put("+79001112230", "GGGGG4");

        System.out.println(hashMap);
    }

}