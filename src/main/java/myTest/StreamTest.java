package myTest;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Stephen Cai
 * @date 2017-12-20 18:57
 */
public class StreamTest {
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }

    public static void main(String[] args) {
        List<String> ss = Lists.newArrayList();
        System.out.println(sout(true, "", ()-> ss.get(0)));
        Stream.of("one", "two", "three", "four")
            .filter(e -> e.length() > 3)
            .peek(e -> System.out.println("Filtered value: " + e))
            .map(String::toUpperCase)
            .peek(e -> System.out.println("Mapped value: " + e))
            .collect(Collectors.toList()); //如果不加collect((Collectors.toList()); it won't print


        List<User> users = Lists.newArrayList(new User("a",1),new User("t",3),new User("a",3));
        users.stream().forEach(user -> System.out.println("forEach"+ user));
        users.stream().map(user -> {
            user.setAge(100);
            System.out.println("daye"+user.getAge());
            return user;
        });
        users = users.stream().filter(distinctByKey(User::getName)).collect(Collectors.toList());
        System.out.println(users);
    }

    public static String sout(Boolean b, String s, Supplier<String> f) {
        if (b) {
            return f.get();
        }
        return "";
    }

    public static <T,R> List<R> map(List<T> list,Function<T,R> f){
        List<R> listR = new ArrayList<>();
        for(T t:list){
            listR.add(f.apply(t));
        }
        return listR;
    }
}
