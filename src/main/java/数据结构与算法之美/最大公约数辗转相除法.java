package 数据结构与算法之美;

/**
 * https://juejin.im/post/5a217bac51882531926e8656 当a和b均为偶数，gcb(a,b) = 2*gcb(a/2, b/2) = 2*gcb(a>>1, b>>1) 当a为偶数，b为奇数，gcb(a,b) = gcb(a/2, b) =
 * gcb(a>>1, b) 当a为奇数，b为偶数，gcb(a,b) = gcb(a, b/2) = gcb(a, b>>1)
 *
 * 1.暴力枚举法：时间复杂度是O(min(a, b)))2.辗转相除法：时间复杂度不太好计算，可以近似为O(log(max(a, b)))，但是取模运算性能较差。3.更相减损术：避免了取模运算，但是算法性能不稳定，最坏时间复杂度为O(max(a, b)))4.更相减损术与移位结合：不但避免了取模运算，而且算法性能稳定，时间复杂度为O(log(max(a, b)))
 *
 * 作者：程序员小灰 * 链接：https://juejin.im/post/5a217bac51882531926e8656 来源：掘金 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author Stephen Cai
 * @date 2019-04-08 18:25
 */
public class 最大公约数辗转相除法 {
    public static int gcd(int numA, int numB) {
        if (numA == numB) {
            return numA;
        }
        if (numA < numB) {
            return gcd(numA, numB);
        } else {
            //和1做按位与运算，判断奇偶
            if ((numA & 1) == 0 && (numB & 1) == 0) {
                return gcd(numA >> 1, numB >> 1) << 1;
            } else if ((numA & 1) == 0 && (numB & 1) != 0) {
                return gcd(numA >> 1, numB);
            } else if ((numA & 1) != 0 && (numB & 1) == 0) {
                return gcd(numA, numB >> 1);
            } else {
                return gcd(numA, numA - numB);
            }
        }
    }
}
