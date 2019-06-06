package algorithm.leetcode;

/**
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 https://juejin.im/post/5ce0e550f265da1b897a9f55
 *
 * @author Stephen Cai
 * @date 2019-05-19 21:51
 */
public class 只出现一次的数字III_260 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // 得到最低的有效位，即两个数不同的那一位
        diff &= -diff;
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //位运算

        System.out.println(Integer.toBinaryString(-7));
        System.out.println(Integer.toBinaryString(10));
        System.out.println(Integer.toBinaryString(-10));
        System.out.println(-10 >> 2);
        System.out.println(Integer.toBinaryString(-10 >> 2));
        System.out.println(Integer.toBinaryString(-10 & 10));
        System.out.println(-10&10);
    }
}
