package algorithm.leetcode;

/**
 * @author Stephen Cai
 * @date 2019-03-14 22:39
 */
public class 字符串相乘_43 {
    /**
     num1的第i位(高位从0开始)和num2的第j位相乘的结果在乘积中的位置是[i+j, i+j+1]
     例: 123 * 45,  123的第1位 2 和45的第0位 4 乘积 08 存放在结果的第[1, 2]位中
     index:    0 1 2 3 4

     1 2 3
     *     4 5
     ---------
     1 5
     1 0
     0 5
     ---------
     0 6 1 5
     1 2
     0 8
     0 4
     ---------
     0 5 5 3 5
     这样我们就可以单独都对每一位进行相乘计算把结果存入相应的index中
     **/

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int len1 = num1.length(),len2 = num2.length();
        int product,carry,i,j;
        int[] num = new int[len1+len2];
        for (i = len1 - 1; i >= 0; i--) {
           carry = 0;
            for (j = len2 - 1; j >= 0; j--) {
                product = carry + (int) (num1.charAt(i) - '0') * (int) (num2.charAt(j) - '0') + num[i+j+1];
                num[i+j+1] = product%10;
                carry = product/10;
            }
            num[i+j+1] = carry;
        }
        i=0;
        while (i<len1+len2 && num[i] == 0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i <len1 + len2) {
            sb.append(num[i]);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        multiply("123","888");
    }

}
