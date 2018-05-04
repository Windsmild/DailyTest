package myTest;

/**
 * @author Stephen Cai
 * @date 2018-04-26 13:19
 */
public class IntTest {
    public static void completeDigit() {
        System.out.printf("%012d",250);//其中0表示补零而不是补空格，6表示至少6位
        System.out.println("\n");
        System.out.println(String.format("%012d",250));

    }

    public static void main(String[] args) {
        completeDigit();
    }
}
