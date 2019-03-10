package leetcode;

import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Stephen Cai
 * @date 2019-03-10 18:00
 */
public class 按奇偶排序数组905 {
    public static int[] sortArrayByParity(int[] A) {
        List<Integer> even = new ArrayList<Integer>(A.length);
        List<Integer> odd = new ArrayList<Integer>(A.length);

        for(int i=0; i< A.length; i ++) {
            if(A[i]%2 ==0) {
                even.add(A[i]);
            } else {
                odd.add(A[i]);
            }
        }
        even.addAll(odd);
        return  Ints.toArray(even);
    }

    public static void main(String[] args) {
        System.out.println(sortArrayByParity(new int[]{3,1,2,4}));
    }
}
