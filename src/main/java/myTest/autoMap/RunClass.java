package myTest.autoMap;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Stephen Cai
 * @date 2018-07-25 18:15
 */
@Component
public class RunClass {
    @Autowired private Map<String, BaseInterface>  map;

    public void test() {
        map.get("BaseOne");
    }
}
