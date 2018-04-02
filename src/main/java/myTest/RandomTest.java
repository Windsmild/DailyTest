package myTest;

import java.util.Random;

/**
 * Created by Stephen Cai on 2017-11-17 19:14.
 */
public class RandomTest {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i< 1000 ; i++) {
            boolean b = bingo(100);
            if (b == true) {
                count++;
            }
        }
            System.out.println(count);
    }

    public static boolean bingo(int rate) {
        int random = new Random().nextInt(100) + 1;
        if (random <= rate) {
            return true;
        } else {
            return false;
        }
    }
}
