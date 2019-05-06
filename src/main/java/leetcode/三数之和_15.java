package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 思路
 * 先把数组排序
 * 从小到大遍历这个数组，每次取一个元素，将这个元素的相反数设为target
 * 在每次遍历中，使用双指针对当前元素的后面的所有元素进行处理，找到两个元素的和为target，这样，三个元素的和就是 0
 * 双指针的具体处理方式为：头尾各一个指针，每次判断两个指针所指的元素的和与target的大小
 * ，如果和小了，左指针右移；如果和大了，右指针左移，直到两个指针相遇
 * @author Stephen Cai
 * @date 2019-03-13 21:12
 */
public class 三数之和_15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length -1;
            if(i > 0 && nums[i] == nums[i - 1 ]) {
                continue;
            }
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[left] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }

            }
        }
        return result;
    }
}
