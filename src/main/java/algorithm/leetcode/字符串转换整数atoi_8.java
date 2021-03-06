package algorithm.leetcode;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * @author Stephen Cai
 * @date 2019-03-13 11:02
 */
public class 字符串转换整数atoi_8 {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        int sign = 1;
        int base = 0;
        int i = 0;

        //firstMark
        if (str.charAt(0) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i++) == '-' ? -1 :1;
        }
        while (i <str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            // 如果base > MAX_VALUE/10，那么base*10 + new_value > base*10 > MAX_VALUE，这种情况下就会发生溢出。
            // 若base == INT_MAX/10，而且new_value = str.charAt(i++) - '0'`大于`7`，也会发生溢出。因为MAX_VALUE = 2147483647
            if (base > Integer.MAX_VALUE / 10  || (base == Integer.MAX_VALUE/10 && str.charAt(i) - '0' > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = 10 * base + (str.charAt(i++) - '0');
        }
        return base * sign;
    }
}
