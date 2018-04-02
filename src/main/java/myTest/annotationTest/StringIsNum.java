package myTest.annotationTest;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * 采用正则表达式判断一个字符串是否是数字
 *
 * @author Stephen Cai
 * @date 2018-01-14 20:07
 */
public class StringIsNum {
    public static void main(String[] args) {
        System.out.println( Double.parseDouble("x"));

        String str1 = "-0..1";
        String str2 = "120";

        List<String> strList = Lists.newArrayList();
        strList.add(str1);
        strList.add(str2);

        for (String s : strList) {
            System.out.println("double " + Double.parseDouble(s));
            Boolean isNum = s.matches("-?[0-9]+\\.?[0-9]*");
            if (isNum) {
                System.out.println(s + " is Num");
            } else {
                System.out.println(s + " is not Num");
            }
        }
       //strToDouble();
    }
    public static void strToDouble() {
        String d= "-1.2";
        System.out.println(Double.toString(-1.2));
    }
}
