package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-06 10:34
 */
public class 除自身以外数组的乘积_238 {
    public int[] productExceptSelf(int[] nums) {
        int len= nums.length;
        int[] res = new int[len];
        int left =1;
        for (int i = 0; i < len; i++) {
           if (i > 0) {
               left =left * nums[i-1];
           }
           res[i] =left;
        }
        int right =1;
        for (int i = len -1; i >=0 ; i--) {
            if (i < nums.length -1) {
                right = right* nums[i+1];
            }
            res[i] *= right;
        }
        return res;
    }
}
