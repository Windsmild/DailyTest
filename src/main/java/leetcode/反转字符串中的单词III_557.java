package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-06 20:16
 */
public class 反转字符串中的单词III_557 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word:words) {
            res.append(new StringBuilder(word).reverse().append(" "));
        }
        return res.toString().trim();
    }
    }
