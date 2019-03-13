package 数据结构与算法之美;

/**
 * https://time.geekbang.org/column/article/0?cid=126 28 | 堆和堆排序：为什么说堆排序没有快速排序快？
 *堆中比较重要的两个操作是插入一个数据和删除堆顶元素。这两个操作都要用到堆化。插入一个数据的时候，我们把新插入的数据放到数组的最后，然后从下往上堆化；删除堆顶数据的时候，我们把数组中的最后一个元素放到堆顶，然后从上往下堆化。这两个操作时间复杂度都是 O(logn)O(log⁡n)。
 *
 * @author Stephen Cai
 * @date 2019-03-11 16:56
 */
public class Heap {
    public Heap() {

    }

    public Heap(int[] a) {
        this.a = a;
        n = a.length;
        count = a.length;
    }
    //数组
    private int[] a;
    //堆中可以存储的最大数据个数
    private int n;
    //堆中已存储的数据个数
    private int count;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count >= n) return;
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(a, i, i / 2);
            i = i / 2;
        }
    }

    public static void swap(int[] a, int inx1, int inx2) {
        int tmp = a[inx2];
        a[inx2] = a[inx1];
        a[inx1] = tmp;
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    //自上往下的堆化
    private static void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private static void buildHeap(int[] a, int n) {
        for (int i = n/2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    // n 表示数据的个数，数组 a 中的数据从下标 1 到 n 的位置。
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(new int[] {1, 2, 3, 4, 5});
        //heap.swap(heap.a, 0, 1);
        heap.removeMax();
    }
}
