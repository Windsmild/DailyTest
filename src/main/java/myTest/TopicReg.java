package myTest;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Stephen Cai on 2017-10-11 13:21.
 */
public class TopicReg {
    public static List<String> analysisTopics(String content) {
        List<String> stringList = Lists.newArrayList();
        String pattern = "#[^#]{1,140}#";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(content);
        while (m.find( )) {
            stringList.add(removeHash(m.group(0)));
        }

        return stringList.stream().distinct().collect(Collectors.toList());
    }

 public static List<String> unMatch(String content) {
        List<String> stringList = Lists.newArrayList();
        String pattern = "^(#[^#]{1,140}#)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(content);
        while (m.find( )) {
            stringList.add(m.group(0));
        }
        return stringList;
    }

    static String removeHash(String topic) {
        return StringUtils.substringBetween(topic, "#", "#");
    }

    public static void main(String[] args) {
        String content = "#s#";
        //List<String> list = analysisTopics(content);
        List<String> unMatchList = unMatch(content);
        System.out.println(unMatchList);
        String contentWithoutTopic = content.replaceAll("#[^#]{1,140}#", "");
        System.out.println(contentWithoutTopic.length());
    }
}
