package myTest.JosTest;

import com.jd.open.api.sdk.request.list.CategoryWriteSaveVenderAttrValueRequest;

/**
 * @author Stephen Cai
 * @date 2018-01-15 14:57
 */
public class JosTest {
    //public JdClient client = new DefaultJdClient(SERVER_URL, accessToken, appKey, appSecret);

    CategoryWriteSaveVenderAttrValueRequest request = new CategoryWriteSaveVenderAttrValueRequest();


    public  void init() {
        //request.setAppId("jingdong");
        //request.setName("jingdong");
        request.setValueId(123L);
        request.setAttValue("jingdong");
        request.setAttributeId(123L);
        request.setCategoryId(123L);
        request.setIndexId(123);
        request.setKey("jingdong,yanfa,pop");
        request.setValue("jingdong,yanfa,pop");

        //CategoryWriteSaveVenderAttrValueResponse response = client.execute(request);
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("sha!" +"sss");
        sb.append("\n");
        sb.append("sha!" +"sss");
        System.out.println(sb);
    }
}
