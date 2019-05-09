package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stephen Cai
 * @date 2019-04-01 22:41
 */
public class 求众数_169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
           Integer count = map.get(num) ;
           if (count == null) {
               count =1;
           } else {
               count = ++count;
           }
           map.put(num, count);
           if (count > n/2){
               return num;
           }
        }

        return 0;
    }

    public static void main(String[] args) {
        new 求众数_169().majorityElement(new int[]{3,2,3});
    }
}
