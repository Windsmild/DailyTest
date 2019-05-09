package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stephen Cai
 * @date 2019-03-09 20:22
 */
public class 和为K的子数组 {
    public static int subarraySum(int[] nums, int k) {
        /**
         扫描一遍数组, 使用map记录出现同样的和的次数, 对每个i计算累计和sum并判断map内是否有sum-k
         **/
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ret = 0;

        for(int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if(map.containsKey(sum-k)) {
                ret += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return ret;
    }

    public static void main(String[] args) {
       subarraySum(new int[]{1,2,1,2,4,3} ,5);
       List<Integer> list = new ArrayList<>(5);
        List<Integer> list2 = new ArrayList<>(5);
       list.addAll(list2);
       //list.toArray()
    }
}
