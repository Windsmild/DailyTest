package algorithm.leetcode;

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
    //TODO 快速选择 ：时间复杂度 O(N)，空间复杂度 O(1) 不过最坏情况仍然是O(n2)
    public static int findKthLargestByQuickSort(int[] arr,int k) {
        return findKthLargestByQuickSort(arr, 0,arr.length -1 ,k);
    }
    public static int findKthLargestByQuickSort(int[] arr,int low,int high,int k) {
        int i,j,standard;
        i = low;
        j = high;
        standard = arr[low];
        while (i < j) {
            //先看右边，依次往左递减,直到找到比standard小的
            while (standard <= arr[i] && i < j) {
                j--;
            }
            //再看左边，依次向右递增,直到找到比standard大的
            while (standard >= arr[i] && i<j) {
                i++;
            }
            if (i<j) {
                swap(arr, i,j);
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = standard;
        if ( i == k) {
            return arr[i];
        }
        if (i < k) {
            //如果i在k的左边，说明k在右半区,递归调用右半数组
            return findKthLargestByQuickSort(arr,j+1,high, k);
        } else {
            //递归调用左半数组
            return findKthLargestByQuickSort(arr,low,j+1, k);
        }

    }


    private static void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
