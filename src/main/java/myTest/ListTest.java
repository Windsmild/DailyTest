package myTest;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Stephen Cai on 2017-11-08 11:30.
 */
public class ListTest {

    public static void partitionList() {
        List<Integer> list = Lists.newArrayList(1, 3, 4, 5, 6, 7, 8, 9, 10);
        List<List<Integer>> partitions = Lists.partition(list, 11);
        System.out.println(partitions);
    }

    public static void feedSwap() {
        List<Feed> feeds = Lists.newArrayList(new Feed(1, 1), new Feed(1, 2), new Feed(2, 2), new Feed(2, 123), new Feed(3, 123), new Feed(3, 4));
        List<Feed> copyFeeds = new ArrayList<>(feeds);
        for (int i = 2; i < feeds.size(); i++) {
            if (feeds.get(i).getUid() == feeds.get(i - 1).getUid()) {
                Collections.swap(feeds, i - 1, i - 2);
            }
        }

        System.out.println(feeds);
        System.out.println(copyFeeds);
    }

    public static void addNull() {
        List<Feed> feeds = Lists.newArrayList(new Feed(1, 1), new Feed(1, 2), new Feed(2, 2), new Feed(2, 123), new Feed(3, 123), new Feed(3, 4));
        feeds.add(null);
        System.out.println(feeds);
    }

    private void changeList(List<Integer> il) {
        il.remove(null);
        System.out.println();
    }

    private static void subList() {
        List<Integer> raw = Lists.newArrayList(1, 2, 3, 4, 5);
        System.out.println(raw.subList(0, 10));
    }

    public static void main(String[] args) {
        subList();
    }
}

@Data
@AllArgsConstructor class Feed {
    private int uid;
    private int aid;
}
