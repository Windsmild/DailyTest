package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-06 20:10
 */
public class 反转字符串_344 {
    public String reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
           char tmp = s[i];
           s[i] = s[len -1 - i];
           s[len -1-i] = tmp;
        }
        return new String(s);
    }
}
