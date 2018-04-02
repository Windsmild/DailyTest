package lottery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 不同概率抽奖
 * @author:rex
 * @date:2014年10月20日
 * @version:1.0
 */
public class LotteryTest {
    public static void main(String[] args) {

        List<Gift> gifts = new ArrayList<Gift>();
        // 序号==物品Id==物品名称==概率
        gifts.add(new Gift(1, "P1", "物品1", 0.2d));
        gifts.add(new Gift(2, "P2", "物品2", 0d));
        gifts.add(new Gift(3, "P3", "物品2", 0.2d));
        gifts.add(new Gift(4, "P4", "物品3", 0.4d));
        gifts.add(new Gift(5, "P5", "物品4", 0.3d));
        gifts.add(new Gift(6, "P6", "物品5", 0d));
        gifts.add(new Gift(7, "P7", "物品6", -0.1d));
        gifts.add(new Gift(8, "P8", "物品7", 0.008d));

        List<Double> originalRates = new ArrayList<Double>(gifts.size());
        for (Gift gift : gifts) {
            double probability = gift.getProbability();
            if (probability < 0) {
                probability = 0;
            }
            originalRates.add(probability);
        }

        // statistics
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        double num = 1000000;
        for (int i = 0; i < num; i++) {
            int originalIndex = LotteryUtil.lottery(originalRates);

            Integer value = count.get(originalIndex);
            count.put(originalIndex, value == null ? 1 : value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            System.out.println(gifts.get(entry.getKey()) + ", count=" + entry.getValue() + ", probability="
                + entry.getValue() / num);
        }
    }

}
