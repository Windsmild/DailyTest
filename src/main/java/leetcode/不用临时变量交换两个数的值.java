package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-24 22:27
 */
public class 不用临时变量交换两个数的值 {
    public static void swtich(int a, int b) {
        System.out.println("a=" + a + "b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + "b=" + b);
    }

    public static void main(String[] args) {
        swtich(2,6);
        System.out.println(2 ^ 6);
    }

}
