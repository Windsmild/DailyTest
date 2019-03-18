package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-17 21:00
 */
public class 合并两个有序数组_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        int index = m + n - 1;
        while (index >= 0) {
            if (i < 0) {
                nums1[index--] = nums2[j--];
            } else if (j < 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] > nums2[j] && i >= 0) {
                nums1[index--] = nums1[i--];
            } else if (nums1[i] <= nums2[j] && j >= 0) {
                nums1[index--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {

    }
}
