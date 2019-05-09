import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Stephen Cai
 * @date 2019-05-08 19:01
 */
public class PinDuoDuoTest {
    //import java.util.Scanner;
    //public class Main {
    //public static void main(String[] args) {
    //    Scanner sc = new Scanner(System.in);
    //    int n = sc.nextInt();
    //    int ans = 0, x;
    //    for(int i = 0; i < n; i++){
    //        for(int j = 0; j < n; j++){
    //            x = sc.nextInt();
    //            ans += x;
    //        }
    //    }
    //    System.out.println(ans);
    //}
    //}

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int M = sc.nextInt();
            int N = sc.nextInt();
            int h[] =  new int[M];
            for (int i = 0; i < M; i++) {
                h[i] = sc.nextInt();
        }
        Arrays.sort(h);
            int finalPlus = 0;
        for (int i = 0; i < M - N; i++) {
            int plus = 0;
            for (int j = i; j < i + N; j++) {
                plus += h[i+N -1] - h[j];
                if (i == 0) {
                    finalPlus = plus;
                }
            }
            finalPlus =  Integer.min(finalPlus, plus);
        }
        if (N == 1) {
            System.out.println(1);
        } else {
            System.out.println(finalPlus);

        }
    }
}
