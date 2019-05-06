package other;

import java.util.Calendar;
import java.util.Date;

import static net.minidev.asm.ConvertDate.convertToDate;

/**
 * @author Stephen Cai
 * @date 2019-04-22 11:32
 */
public class DateUtils {
    /**
     * 根据日期字符串判断当月第几周
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static int getWeekOfMonth(String date) throws Exception {
        // 将字符串格式化
        Date d = convertToDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        // 第几周
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    /**
     * 根据日期字符串判断当年第几周
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static int getWeekOfYear(String date) throws Exception {
        // 将字符串格式化
        Date d = convertToDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);

        // 第几周
        return calendar.get(Calendar.WEEK_OF_YEAR);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(getWeekOfMonth("2019-4-30"));
    }
}
