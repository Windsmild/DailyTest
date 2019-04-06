package leetcode;

import java.util.PriorityQueue;

/**
 * @author Stephen Cai
 * @date 2019-04-02 09:18
 */
public class 数组中的第K个最大元素_215 {
    //堆排序 ：时间复杂度 O(NlogK)，空间复杂度 O(K)。
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
    //快速选择 ：时间复杂度 O(N)，空间复杂度 O(1) 不过最坏情况仍然是O(n2)
    public int findKthLargest2(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return 0;
        int left = 0, right = nums.length - 1;
        while (true) {
            int position = partition(nums, left, right);
            if (position == k - 1) return nums[position]; //每一轮返回当前pivot的最终位置，它的位置就是第几大的，如果刚好是第K大的数
            else if (position > k - 1) right = position - 1; //二分的思想
            else left = position + 1;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = left;
        int l = left + 1; //记住这里l是left + 1
        int r = right;
        while (l <= r) {
            while (l <= r && nums[l] >= nums[pivot]) l++; //从左边找到第一个小于nums[pivot]的数
            while (l <= r && nums[r] <= nums[pivot]) r--; //从右边找到第一个大于nums[pivot]的数
            if (l <= r && nums[l] < nums[pivot] && nums[r] > nums[pivot]) {
                swap(nums, l++, r--);
            }
        }
        swap(nums, pivot, r); //交换pivot到它所属的最终位置，也就是在r的位置，因为此时r的左边都比r大，右边都比r小
        return r; //返回最终pivot的位置
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
