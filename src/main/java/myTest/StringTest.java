package myTest;

import com.google.common.collect.Lists;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

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

    public static void format() {
        System.out.println(String.format("%s, %s 在线订票, %s 行程, %s 价格, %s 时间, %s 资讯", "关键词","关键词","关键词","关键词","关键词","关键词"));
        System.out.println(new DateTime().getYear());
        String keyword = "帅哥";
        System.out.println(StringUtils.replace("票牛为您提供" + new DateTime().getYear() + "最新 关键词 在线订票、关键词 价格、关键词 行程、关键词 时间等资讯服务。票牛是"
            + "一家热爱生活并热爱现场娱乐的公司，希望让更多人感受现场，享受快乐 我们对接了各大票务平台、主办方、票务代理和场馆资源，为用户提供各类演出票品，同时也为热"
            + "爱演出的用户提供优质演出信息内容和交流平台 我们希望通过技术手段来打造对消费者负责、保障消费者权益的购票平台，鼓励好卖家、淘汰不靠谱卖家，确保每一个热爱演出的观众买得到票，买得放心、买得实惠。", "关键词", keyword));
    }

    public static void main(String[] args) throws UnknownHostException {
        format();
        //Integer i = -1;
        //System.out.println(i);
        //nullPlus();
        trim();
    }

}
