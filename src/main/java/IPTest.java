import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author Stephen Cai
 * @date 2018-01-31 20:35
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        System.out.println("Local HostAddress:" + addr.getHostAddress());
    }
}
