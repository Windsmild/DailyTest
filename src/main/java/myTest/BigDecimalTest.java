package myTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Stephen Cai on 2017-10-19 15:52.
 */
public class BigDecimalTest {
    public static final BigDecimal ZERO = newBigDecimal(0);

    public static final BigDecimal ONE = newBigDecimal(1);


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

    public static void toInt(){
        int i = new BigDecimal("1.23235").multiply(new BigDecimal("100")).intValue();
        System.out.println(i);
    }
    public static void movePoint() {
        System.out.println(BigDecimal.valueOf(123).movePointLeft(2));

    }
    public static void main(String[] args) {
        movePoint();
        toInt();
        //BigDecimal es = new BigDecimal(""+5.00);
        //System.out.println(es.setScale(0, RoundingMode.HALF_DOWN));
    }

}
