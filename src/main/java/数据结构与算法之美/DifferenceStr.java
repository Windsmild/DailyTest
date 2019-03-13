package 数据结构与算法之美;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Stephen Cai
 * @date 2019-03-13 11:39
 */
public class DifferenceStr {
    public static String differenceStr(String totalStr, String partStr) {
        Set<String> totalSet = new LinkedHashSet<>(Arrays.asList(totalStr.split(",")));
        Set<String> partSet = new LinkedHashSet<>(Arrays.asList(partStr.split(",")));
        List<String> restSet = new ArrayList<>();
        totalSet.removeAll(partSet);
        StringBuilder sb = new StringBuilder();
        String res  = String.join("," , totalSet);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(differenceStr("1,2,3", "2,3"));
    }
}
