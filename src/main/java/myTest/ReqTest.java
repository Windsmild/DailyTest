package myTest;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Stephen Cai
 * @date 2018-04-09 10:55
 */
public class ReqTest {
    public static void main(String[] args) {
        JdpAddVenueRequest jdpAddVenueRequest = new JdpAddVenueRequest();
        jdpAddVenueRequest.setBody(new JdpBodyAddVenue("venue"));
        System.out.println(jdpAddVenueRequest.getBody().getClass());

    }
}

@Data
abstract class JdpRequest<T> {

    String head;
    T body;
}

@Data
class JdpAddVenueRequest<Jdp> extends JdpRequest{
    //JdpBodyAddVenue body;

}

@Data
@AllArgsConstructor
class JdpBodyAddVenue {
    String venueDetail;
}
