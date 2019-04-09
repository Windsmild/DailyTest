package 数据结构与算法之美;

/**
 * https://blog.csdn.net/sdoog_owt/article/details/80058870
 * 快速排序 quicksort
 * @author Stephen Cai
 * @date 2019-04-08 22:07
 */
public class QuickSort {
    public static void sort(int[] arr,int low,int high) {
        int i,j,standard;
        if (low > high) {
            return;
        }
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
        //递归调用左半数组
        sort(arr,low,j-1);
        sort(arr,j+1,high);

        //递归调用右半数组

    }

    private static void swap(int[] a,int i, int j ) {
       int tmp = a[i] ;
       a[i] = a[j];
       a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {10,7,2,4,7,62,3,4,2,1,8,9,19};
        sort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
    }
