package algorithm.leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * https://juejin.im/post/5ce0e550f265da1b897a9f55
 * @author Stephen Cai
 * @date 2019-05-19 21:51
 */
public class 只出现一次的数字II_137 {
    public int singleNumber(int[] nums) {
        // 这里我们改一下变量名
        // 用 one 记录到当前处理的元素为止，二进制1出现“1次”（mod 3 之后的 1）的有哪些二进制位；
        // 用 two 记录到当前计算的变量为止，二进制1出现“2次”（mod 3 之后的 2）的有哪些二进制位。
        int one = 0, two = 0;
        int mask;
        for (int num : nums) {
            // 由于 two 要考虑，one 的已有状态，和当前是否继续出现。所以要先算
            two ^= one & num;
            // one 就是一个0,1的二值位，在两个状态间转换
            one ^= num;
            // 当 one 和 two 中的某一位同时为1时表示该二进制位上1出现了3次，此时需要清零。
            mask = ~(one & two);
            // 清零操作
            one &= mask;
            two &= mask;
        }
        // 即用 二进制 模拟 三进制 运算。最终 one 记录的是最终结果。
        return one;
    }
}
