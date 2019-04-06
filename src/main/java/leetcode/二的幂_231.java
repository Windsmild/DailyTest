package leetcode;

/**
 * @author Stephen Cai
 * @date 2019-04-03 09:38
 */
public class 二的幂_231 {
    public boolean isPowerOfTwo(int n) {
        if (n<=0) {
            return false;
        }
        /**
         * 不妨先看下n-1是什么意思。
         *
         *    令:n=1101011000(二进制,十进制也一样)，则
         *     n-1=1101010111。
         *
         * n&(n-1)=1101010000
         *
         * 由此可以得出，n和n-1的低位不一样，直到有个转折点，就是借位的那个点，从这个点开始的高位，n和n-1都一样，如果高位一样这就造成一个问题，就是n和n-1在相同的位上可能会有同一个1，从而使((n & (n-1)) != 0),如果想要
         *
         * ((n & (n-1)) == 0)，则高位必须全为0，这样就没有相同的1。
         */
        return (n&(n-1)) ==0;
    }

    public static void main(String[] args) {
        int num =996;
        int count=0;
        while(num!=0){
            count+=(num & 1);
            num>>=1;
        }
        System.out.println(2 >>1);
    }
}
