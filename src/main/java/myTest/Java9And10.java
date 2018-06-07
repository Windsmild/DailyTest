package myTest;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author Stephen Cai
 * @date 2018-06-03 11:09
 */
public class Java9And10 {
    public  static void test9() {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6);
        list.stream().takeWhile(x-> x<3).forEach(System.out::print);
    }

    public static void main(String[] args) {
        test9();
    }
}
