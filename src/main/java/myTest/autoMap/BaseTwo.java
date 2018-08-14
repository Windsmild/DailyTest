package myTest.autoMap;

import org.springframework.stereotype.Service;

/**
 * @author Stephen Cai
 * @date 2018-07-25 18:07
 */

@Service
public class BaseTwo implements BaseInterface {
    @Override public String getName() {
        return "TWO";
    }
}
