package leetcode;

/**
 * 异或满足交换律和结合律
 * x ^ x == 0
 * x ^ 0 == x
 * 不建议在实际使用中采用这样的写法。这种奇技淫巧虽然看起来十分巧妙，但这样并不见得能够比朴素的交换来的更快。而且这种方法存在一个缺陷：如果 a 和 b 引用的是同一个变量的话，使用这种方法会使得这个变量变为0。
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
