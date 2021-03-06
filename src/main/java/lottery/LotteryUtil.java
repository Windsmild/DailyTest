package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不同概率抽奖工具包
 * @author:rex
 * @date:2014年10月20日
 * @version:1.0
 */
public class LotteryUtil {
    /**
     * 抽奖
     *
     * @param originalRates 原始的概率列表，保证顺序和实际物品对应
     * @return 物品的索引
     */
    public static int lottery(List<Double> originalRates) {
        if (originalRates == null || originalRates.isEmpty()) {
            return -1;
        }

        int size = originalRates.size();

        // 计算总概率，这样可以保证不一定总概率是1
        double sumRate = 0d;
        for (double rate : originalRates) {
            sumRate += rate;
        }

        // 计算每个物品在总概率的基础下的概率情况
        List<Double> sortOriginalRates = new ArrayList<Double>(size);
        Double tempSumRate = 0d;
        for (double rate : originalRates) {
            tempSumRate += rate;
            sortOriginalRates.add(tempSumRate / sumRate);
        }

        // 根据区块值来获取抽取到的物品索引
        double nextDouble = Math.random();
        sortOriginalRates.add(nextDouble);
        Collections.sort(sortOriginalRates);

        return sortOriginalRates.indexOf(nextDouble);
    }
}
