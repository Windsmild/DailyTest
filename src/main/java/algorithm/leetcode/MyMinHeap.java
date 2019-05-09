package algorithm.leetcode;

import org.apache.commons.lang.math.RandomUtils;

/**
 * https://juejin.im/post/5cb9d605e51d456e51614aa3
 * 最详细版图解优先队列（堆）
 * 小顶堆
 * @author Stephen Cai
 * @date 2019-03-05 14:56
 */
public class MyMinHeap {
    int[] items;
    int currentSize = 0;

    // 初始化为size + 1，从下标1开始保存元素。
    public MyMinHeap(int size) {
        items = new int[size + 1];
    }

    // 插入元素
    public void insert(int x) {
        if (currentSize == items.length - 1) {
            if (compare(x, items[1]) < 0) {
                return;
            } else if (compare(x, items[1]) > 0) {
                deleteMin();
            }
        }

        int hole = ++currentSize;
        //上滤：为了插入元素X，我们在下一个可用的位置建立空穴（否则会破坏结构性，不是完全二叉树）。如果此元素放入空穴不破坏堆序性，则插入完成；
        // 否则，将父节点下移到空穴，即空穴向根的方向上冒一步。继续该过程，直到X插入空穴为止。这样的过程称为上滤。
        for (items[0] = x; compare(x, items[hole / 2]) < 0; hole /= 2) {
            items[hole] = items[hole / 2];
        }
        items[hole] = x;
    }

    // 删除最小堆中最小元素
    public int deleteMin() {
        int min = items[1];
        items[1] = items[currentSize--];
        percolateDown(1);
        return min;
    }

    // 下滤
    public void percolateDown(int hole) {
        int child;
        int temp = items[1];

        for (; hole * 2 <= currentSize; hole = child) {
            child = 2 * hole;
            if (child != currentSize && compare(items[child + 1], items[child]) == -1) {
                child++;
            }
            if (compare(items[child], temp) < 0) {
                items[hole] = items[child];
            } else {
                break;
            }
        }
        items[hole] = temp;
    }

    // 制定比较规则
    public static int compare(int a, int b) {
        if (a < b) {
            return -1;
        } else if (a > b) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        MyMinHeap topK = new MyMinHeap(10);
        for (int i = 1; i <= 100; i++) {
            topK.insert(RandomUtils.nextInt(100));
        }
        for (int j = 1; j <= topK.currentSize; j++) {
            System.out.print(topK.items[j] + " ");
        }
        System.out.println();
    }
}

