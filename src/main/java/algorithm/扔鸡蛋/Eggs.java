package algorithm.扔鸡蛋;

/**
 * 扔鸡蛋问题
 * https://zhuanlan.zhihu.com/p/41257286
 * 我们可以把M层楼 / N个鸡蛋的问题转化成一个函数 F（M，N），其中楼层数M和鸡蛋数N是函数的两个参数，而函数的值则是最优解的最大尝试次数。
 * 假设我们第一个鸡蛋扔出的位置在第X层（1<=X<=M），会出现两种情况：
 * @author Stephen Cai
 * @date 2019-05-07 10:52
 */
public class Eggs {
//    1.第一个鸡蛋没碎
//    那么剩余的M-X层楼，剩余N个鸡蛋，可以转变为下面的函数：
//    F（M-X，N）+ 1，1<=X<=M
//2.第一个鸡蛋碎了
//    那么只剩下从1层到X-1层楼需要尝试，剩余的鸡蛋数量是N-1，可以转变为下面的函数：
//    F（X-1，N-1） + 1，1<=X<=M
//    整体而言，我们要求出的是 M层楼 / N个鸡蛋 条件下，最大尝试次数最小的解，所以这个题目的状态转移方程式如下：
//    F（M，N）= Min（Max（ F（M-X，N）+ 1， F（X-1，N-1） + 1）），1<=X<=M

    public int getMinSteps(int eggNum, int floorNum) {
        if (eggNum < 1 || floorNum <1) {
            return 0;
        }
        //备忘录，存储eggNum个极端，floorNum层楼条件下的最优化尝试次数
        int[][] cache = new int[eggNum+1][floorNum+1];
        //把备忘录每个元素初始化成最大的尝试次数
        for (int i = 1; i <= eggNum; i++) {
            for (int j = 1; j <= floorNum; j++) {
                cache[i][j] = j;

            }
        }
        //时间复杂度 mmn 空间复杂度 mn
        for (int n = 2; n <= eggNum; n++) {
            for (int m = 1; m <= floorNum ; m++) {
                for (int k = 1; k <m ; k++) {
                    //扔鸡蛋的楼层从1到m枚举一遍，如果算出尝试次数小于上次算出的尝试次数，则取代上一次的尝试次数
                    System.out.println("k值："+k);
                    cache[n][m] = Math.min(cache[n][m], 1+ Math.max(cache[n-1][k-1],cache[n][m-k]));
                }
            }
        }
        return cache[eggNum][floorNum];
    }

    public int getMinStepsOptimized (int eggNum, int floorNum) {
        if (eggNum < 1 || floorNum <1) {
            return 0;
        }
        //上一层备忘录，存储鸡蛋数量-1的floorNum层楼条件下的最优化尝试次数
        int[] preCache = new int[floorNum + 1];
        //当前备忘录，存储当前鸡蛋数量的floorNum层楼条件下的最优化尝试次数
        int[] currentCache = new int[floorNum +1];
        //把备忘录每个元素初始化成最大的尝试次数
        for (int i = 1; i <= floorNum; i++) {
            currentCache[i] =i;
        }
        for (int n = 2; n <= eggNum; n++) {
            //当前备忘录拷贝给上一次备忘录，并重新初始化当前备忘录
            preCache = currentCache.clone();
            for (int i = 1; i <= floorNum; i++) {
                currentCache[i] =i;
            }
            for (int m = 1; m <= floorNum ; m++) {
                for (int k = 1; k < m; k++) {
                    //扔鸡蛋的楼层从1到m枚举一遍，如果当前算出的尝试次数小于上次算出的尝试次数，则取代上次的尝试次数
                    currentCache[m] = Math.min(currentCache[m], 1+ Math.max(preCache[k-1],currentCache[m-k]));
                }

            }
        }
        return currentCache[floorNum];

    }
    public static void main(String[] args) {
        Eggs e = new Eggs();
        System.out.println(e.getMinSteps(5,500));
    }


}
