package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-13 17:32
 */
public class 最长公共前缀_14 {
    public static String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        String prefix = "";
        if (count != 0) {
            prefix = strs[0];
        }
        for (int i = 0; i < count; i++) {
            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    public static String brute(String[] strs) {
        int size = strs.length;
        if (size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
            for (int i = 0; ; i++) {
                Character c = new Character(' ');
                for (int j = 0; j < size; j++) {
                    if ( i >= strs[j].length()) {
                        return sb.toString();
                    }
                    if (strs[j].length() ==0 ) {
                        return sb.toString();
                    }
                     c = strs[0].charAt(i);
                   if (strs[j].charAt(i) != c) {
                       return sb.toString();
                   }
                }
                sb.append(c);
            }
    }

    public static void main(String[] args) {
        longestCommonPrefix(new String[]{"吃了吗","吃你妹","吃啥"});
        String b = brute(new String[]{""});
        System.out.println(b);
    }
}
