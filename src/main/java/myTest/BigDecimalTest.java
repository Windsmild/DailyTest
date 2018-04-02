package myTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Stephen Cai on 2017-10-19 15:52.
 */
public class BigDecimalTest {
    public static final BigDecimal ZERO = newBigDecimal(0);

    public static final BigDecimal ONE = newBigDecimal(1);

    public static void main(String[] args) {
        BigDecimal es = new BigDecimal(20);
        BigDecimal ss = new BigDecimal(30);
        System.out.println(es.subtract(ss));
        System.out.println(plus(es,ss));
    }

    /**
     * 返回2位小数
     * @param value
     * @return
     */
    public static BigDecimal newBigDecimal(double value){
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP);
    }

    public static BigDecimal plus(BigDecimal... numbers) {
        BigDecimal zero = newBigDecimal(0);
        for (BigDecimal num : numbers) {
            zero = zero.add(num);
        }
        return zero;
    }

}
