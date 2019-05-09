package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-13 09:50
 */
public class 整数反转_7 {
    //求余
    public static int reverse(int x) {
        int result = 0;
        while ( x != 0) {
            int tail = x% 10;
            int newResult = result * 10 + tail;
            //加一个判断判断整数溢出，妙啊
            if ((newResult - tail ) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x/10;
        }
        return result;

    }

    public static void main(String[] args) {
        reverse(1231234349);

    }
}
