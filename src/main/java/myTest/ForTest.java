package myTest;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author Stephen Cai
 * @date 2018-03-23 10:21
 */
public class ForTest {
    public  static void old() {

        NumberFormat formatter = new DecimalFormat("#0.0");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10;) {
            sb.append("\""+i+"\",");
            i+=1;
        }
        System.out.println(sb);
    }

    public static void wrap() {
        Integer inte = 100;
        for (int i = 0; i < inte; i++) {
            System.out.println(i);
            System.out.println(inte);
            inte-=1;
        }
    }

    public static void main(String[] args) {
        wrap();
    }
}
