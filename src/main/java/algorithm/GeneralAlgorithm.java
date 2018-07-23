package algorithm;

import edu.princeton.cs.algs4.StdDraw;

/**
 * @author Stephen Cai
 * @date 2018-07-20 17:39
 */
public class GeneralAlgorithm {
    public static int gcd(int p, int q){

       if (q == 0) {return p;}
      int r = p%q;
      return gcd(q,r);
    }
    public static void draw() {
        StdDraw.circle(1,1,1);
    }
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(64));
        System.out.println(Double.POSITIVE_INFINITY -1);
        //draw();

        //for (int i = 0; i < 100; i++) {
        //    int p = RandomUtils.nextInt(9999999);
        //    int q = RandomUtils.nextInt(9999999);
        //    System.out.println("p:" + p + "q:" +q);
        //    System.out.println(gcd(p, q));
        //}
    }
}
