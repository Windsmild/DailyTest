package other;

import com.google.common.base.Objects;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stephen Cai
 * @date 2019-03-15 18:31
 */
public class AminoIPConvertTest {

    private static AminoIPConvert convert = new AminoIPConvert();

    @Test
    public void testNull() {
        Long value = convert.parseIP4Address(null);
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testEmptyString() {
        Long value = convert.parseIP4Address("");
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testEmptyString2() {
        Long value = convert.parseIP4Address(" 172.168.5.1");
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testEmptyString3() {
        Long value = convert.parseIP4Address("172.168.5.1 ");
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testRegular() {
        Long value = convert.parseIP4Address("172.168.5.1");
        Assert.assertTrue(Objects.equal(2896692481L, value));
    }

    @Test
    public void testWithSpace_01() {
        Long value = convert.parseIP4Address("172 .168.5.1");
        Assert.assertTrue(Objects.equal(2896692481L, value));
    }

    @Test
    public void testWithSpace_02() {
        Long value = convert.parseIP4Address("172. 168.5.1");
        Assert.assertTrue(Objects.equal(2896692481L, value));
    }

    @Test
    public void testWithSpace_03() {
        Long value = convert.parseIP4Address("172 . 168.5.1");
        Assert.assertTrue(Objects.equal(2896692481L, value));
    }

    @Test
    public void testWithSpace_04() {
        Long value = convert.parseIP4Address("1 72.168.5.1");
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testWithDot_01() {
        Long value = convert.parseIP4Address("172.168.5.1.");
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testWithDot_02() {
        Long value = convert.parseIP4Address("172.168.51.");
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testWithDot_03() {
        Long value = convert.parseIP4Address("172.168.51");
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testWithDot_04() {
        Long value = convert.parseIP4Address(".172.168.51");
        Assert.assertTrue(Objects.equal(-1L, value));
    }

    @Test
    public void testWithDot_05() {
        Long value = convert.parseIP4Address("..168.51");
        Assert.assertTrue(Objects.equal(-1L, value));
    }
}
