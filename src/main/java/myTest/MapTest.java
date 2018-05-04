package myTest;

import com.google.common.collect.Maps;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Stephen Cai on 2017-11-16 17:30.
 */
public class MapTest {

    public static void removeNUll() {
        Map<String,Integer> map = Maps.newHashMap();
        map.put("1",null);
        map.put("3",3);
        map.put("2",2);
        map.put("4",4);
        int ii = map.get("8");
        System.out.println(ii);
        System.out.println(map);
        map.entrySet().removeIf(e -> e.getValue() == null);
        System.out.println(map);
    }
    @Data
    @AllArgsConstructor
    @EqualsAndHashCode
    static class Person {
        private String name;
        private Integer age;
    }

    /**
     * 当集合里的对象属性改变后，remove失败
     */
    public static void hashSetAdd() {
        Set<Person> set = new HashSet<>();
        Person p1 = new Person("tang",50);
        Person p2 = new Person("zhu",30);
        Person p3 = new Person("sun",57);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println(set);
        p3.setAge(111);
        set.remove(p3);
        System.out.println(set);
        set.add(p3);
        System.out.println(set);

    }
    public static void main(String[] args) {
        hashSetAdd();
        //removeNUll();
    }
}

