package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Stephen Cai
 * @date 2019-03-10 21:37
 */
public class 寻找两个有序数组的中位数_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length || j < nums2.length) {

            if (i == nums1.length) {
               list.add(nums2[j]);
               j++;
               continue;
            }
            if (j == nums2.length) {
                list.add(nums1[i]);
                i++;
                continue;
            }

            if (nums1[i] <= nums2[j]) {
                list.add(nums1[i]);
                i++;
            } else {
                list.add(nums2[j]);
                j++;
            }
        }
        if (list.size() % 2 ==0 ) {
            return ((double)(list.get(list.size()/2 - 1 ) + list.get(list.size()/2 )))/2;
        }else {
            return (double)list.get(list.size()/2);
        }
    }

    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{},new int[]{2,3});

    }
}
