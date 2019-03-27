package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-24 22:32
 */
public class 只出现一次的数字_136 {
    public int singleNumber(int[] nums) {
      if (nums.length == 0) {
          return -1;
      }
      if (nums.length == 0) {
          return nums[0];
      }
      int result = 0;
        for (int i = 0; i < nums.length; i++) {
           result= result^nums[i];
        }
        return result;
    }

}
