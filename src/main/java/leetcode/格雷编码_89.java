package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Stephen Cai
 * @date 2019-03-17 21:38
 */
public class 格雷编码_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> list = new LinkedList<>();
            for (int j = 0; j < res.size(); j++) {
                list.add(res.get(j) << 1);
            }
            for (int j = res.size() -1; j >=0; j--) {
               list.add((res.get(j) << 1) + 1);
            }
            res = list;

        }
        return res;

    }
}
