package myTest;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author Stephen Cai
 * @date 2018-04-08 21:32
 */
public class XstreamTest {
    public static void main(String[] args) {

    }
}

class Body {
    Object body;
}

@XStreamAlias("req")
class Request {

}
