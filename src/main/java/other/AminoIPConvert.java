package other;

import org.apache.commons.lang.StringUtils;

/**
 * Programming Question:
 * Convert an IPv4 address in the format of null-terminated C string into a 32-bit integer. For example, given an IP address “172.168.5.1”, the output should be a 32-bit integer with “172” as the highest order 8 bit, 168 as the second highest order 8 bit, 5 as the second lowest order 8 bit, and 1 as the lowest order 8 bit. That is,
 * "172.168.5.1" => 2896692481 Requirements:
 * 1. You can only iterate the string once.
 * 2. You should handle spaces correctly: a string with spaces between a digit and a dot is a valid input; while a string with spaces between two digits is not.
 * "172[Space].[Space]168.5.1" is a valid input. Should process the output normally.
 * "1[Space]72.168.5.1" is not a valid input. Should report an error. 3. Please provide unit tests.
 * @author Stephen Cai
 * @date 2019-03-15 17:53
 */
public class AminoIPConvert{

    private static final String INVALID_FORMAT = "invalid format";
    private static final long   INVALID_CODE   = -1;

    public long parseIP4Address(String input) {
        if (StringUtils.isBlank(input) || input.startsWith(" ") || input.startsWith(".") || input.endsWith(" ")
                || input.endsWith(".")) {
            System.out.println(INVALID_FORMAT);
            return INVALID_CODE;
        }

        long sum = 0;
        int shift = 3;
        String[] array = input.split("\\.");
        if (array.length != 4) {
            System.out.println(INVALID_FORMAT);
            return INVALID_CODE;
        }

        boolean parseError = false;
        for (int index = 0; index < array.length; index++) {
            try {
                long segment = Long.parseLong(array[index].trim());
                sum += segment << ((shift--) * 8);
            } catch (Exception ex) {
                parseError = true;
                break;
            }
        }
        if (parseError) {
            System.out.println(INVALID_FORMAT);
            return INVALID_CODE;
        }
        return sum;
    }
}
