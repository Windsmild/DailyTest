package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 从正整数 N 开始，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 * @author Stephen Cai
 * @date 2019-03-12 22:14
 */
public class 重新排序得到2的幂_869 {
    public static boolean reorderedPowerOf2(int N) {
        Set<String> powerSet = new TreeSet();
        for (int i = 0; ; i++) {
            int res = (int) Math.pow(2, i);
            powerSet.add(String.valueOf(res));
            if (res > (int) Math.pow(10, 9)) {
                break;
            }
        }
        String numS = String.valueOf(N);
        for (String p : powerSet) {
            if (numS.length() == p.length()) {
                Map<Character, Integer> pMap = strToMap(p);
                Map<Character, Integer> nMap = strToMap(numS);
                boolean matchRes = pMap.entrySet().stream().anyMatch(entry -> {
                    return nMap.get(entry.getKey()) == null || !nMap.get(entry.getKey()).equals(entry.getValue());
                });
                if (!matchRes) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Map<Character, Integer> strToMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {

        boolean res = reorderedPowerOf2(46);
        System.out.println(res);
        //Map<Character,Integer> pMap = strToMap("123");
        //Map<Character,Integer> nMap = strToMap("21");
        //boolean res = pMap.entrySet().stream().allMatch(entry -> {
        //    return nMap.get(entry.getKey()) == null && nMap.get(entry.getKey()).equals(entry.getValue());
        //});
        //System.out.println(res);

    }
}
