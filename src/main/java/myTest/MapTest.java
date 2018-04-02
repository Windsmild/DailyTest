package myTest;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * Created by Stephen Cai on 2017-11-16 17:30.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<Long,Integer> map = Maps.newHashMap();
        map.put(1L,1);
        System.out.println(map.get(2));
        System.out.println(map.get(1L)) ;


    }
}
