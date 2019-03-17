package leetcode;

import java.util.Arrays;

/**
 * @author Stephen Cai
 * @date 2019-03-13 22:31
 */
public class 最接近的三数之和_16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i+1, r= nums.length-1;
            while (l <r) {
                int threeSum = nums[l] +nums[r] + nums[i];
                if(Math.abs(threeSum - target) < Math.abs(closestNum -target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    return target;
                }
            }
        }
        return closestNum;
    }
}
