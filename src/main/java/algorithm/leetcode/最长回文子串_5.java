package algorithm.leetcode;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 * @author Stephen Cai
 * @date 2019-03-12 17:34
 */
public class 最长回文子串_5 {
    //O(n2)
    public static String longestPalindrome(String s) {
        if (s.isEmpty()||s == null || s.length() ==1) {
            return s;
        }
        String longest = s.substring(0,1);
        for (int i = 0; i < s.length(); i++) {
            //get longest palindrome with center of i
            String tmp = helper(s,i,i);
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
            //get longest palindrome with center of i,i+1
            tmp = helper(s,i,i+1);
            if (tmp.length() > longest.length()) {
                longest=tmp;
            };

        }
        return longest;
    }
    //Given a center ,either one letter or two letter, Find longest palindrome
    public static String helper(String s, int begin,int end) {
       while (begin >= 0 && end <= s.length() -1 && s.charAt(begin) == s.charAt(end)) {
           begin--;
           end++;
       }
       return s.substring(begin+1,end);
    }

    public static String Manacher(String s) {
        // Insert '#'
        String t = "$#";
        for (int i = 0; i < s.length(); ++i) {
            t += s.charAt(i);
            t += "#";
        }
        t += "@";
        // Process t
        int[] p = new int[t.length()];
        ;
        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length() - 1; ++i) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (((i - p[i]) >= 0) && ((i + p[i]) < t.length() - 1) && (t.charAt(i + p[i]) == t.charAt(i - p[i]))) {
                ++p[i];
            }
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen - 1);
    }
        public static void main(String[] args) {
        longestPalindrome("babad");
        Manacher("moon");
    }

}
