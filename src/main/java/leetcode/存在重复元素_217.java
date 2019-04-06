package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stephen Cai
 * @date 2019-04-02 22:22
 */
public class 存在重复元素_217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Object> map = new HashMap<>();
        int index = 0;
        while(index < nums.length) {
            if (map.get(nums[index]) != null) {
                return true;
            }
            map.put(nums[index++],0);

        }

        return false;

    }
}
