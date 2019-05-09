package algorithm;

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



}
