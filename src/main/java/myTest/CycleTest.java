package myTest;

/**
 * @author Stephen Cai
 * @date 2018-05-02 12:07
 */
public class CycleTest {
    public static int returnTest() {
        int i = 0;
        while (true) {
            if (i == 10) {
                return 10;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(returnTest());
    }
}
