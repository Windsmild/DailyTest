package myTest;

import java.util.Locale;

/**
 * @author Stephen Cai
 * @date 2018-06-10 22:03
 */
public class LocalTest {

    public static void baseTest() {
        Locale locale = Locale.getDefault();

        System.out.println(locale.getCountry());//输出国家代码

        System.out.println(locale.getLanguage());//输出语言代码s
    }
    public static void main(String[] args) {
        baseTest();
    }
}
