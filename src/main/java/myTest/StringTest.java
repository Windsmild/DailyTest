package myTest;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by Stephen Cai on 2017-10-12 12:47.
 */
public class StringTest {
    public static String replaceColon(String rawString) {
        return rawString.replace(":", "点");
    }

    public static String replaceForbidWords(String rawString) {
        return rawString.replaceAll("日月|月", "");
    }

    public static void before() throws UnknownHostException {
        System.out.println("\"协调能效\"".replace("\"", "\\\""));
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.out.println(InetAddress.getLocalHost());
        System.out.println(InetAddress.getAllByName("Saxon-no-MacBook-Pro.local"));

        System.out.println("------------------------");
        System.out.println(replaceColon("2018年03月23日 周五 21:00"));
        System.out.println(replaceForbidWords("2018年03月23日 日月 周五 21:00"));
        String s =
            "https://img..com/mmbiz_jpg/ic4hNticlI5LDGbpPE5rjK56ae3SuJdmmGQicNgKllqrmxWaUC2qreRlwGCia3DOBaPXnMXbQCRAiciaiaXG1H7tQnN7A/640?imageMogr2/format/gif";
        String[] split = s.split("\\?imageMogr2/");
        String firstSubString = split[0];
        System.out.println(firstSubString);
        List<String> list = Lists.newArrayList("1", "2");
        System.out.println(list.toString().replace("[", "").replace("]", ""));
        System.out.println(String.valueOf(new BigDecimal(0.1).multiply(new BigDecimal(555.547)).setScale(2, RoundingMode.HALF_UP)));
    }

    public static void nullPlus() {

        Object kong = null;
        System.out.println(" " + kong);
    }

    public static void trim() {
        String origin = "953 347 626 340";
        System.out.println(origin.replaceAll("\\s",""));
    }
    public static void main(String[] args) throws UnknownHostException {
        Integer i = -1;
        System.out.println(i);
        //nullPlus();
        trim();
    }

}
