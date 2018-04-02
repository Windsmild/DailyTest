package myTest;

import java.util.StringJoiner;

/**
 * Created by Stephen Cai on 2017-11-28 10:13.
 */
public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner sjr = new StringJoiner(",", "[", "]");
        sjr.add("Smart").add("Techie");
        System.out.println("The final Joined string is " + sjr);
    }
}
