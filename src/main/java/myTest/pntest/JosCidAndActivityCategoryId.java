package myTest.pntest;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import java.util.HashMap;
import java.util.Set;
import lombok.Data;

/**
 * @author Stephen Cai
 * @date 2018-01-24 15:22
 */
@Data
public class JosCidAndActivityCategoryId {
    /**
     * 票牛类目id
     */
    private Integer activityCategoryId;
    /**
     * 京东类目id
     */
    private Integer cid;

    public static void main(String[] args) {
        JSONObject.parseObject("[{\"activityCategoryId\":\"1\",\"cid\":\"2\"}]",new TypeReference<Set<JosCidAndActivityCategoryId>>(){});
        JSONObject.parseObject("[{\"activityCategoryId\":\"1\",\"cid\":\"2\"}]",new TypeReference<HashMap<Integer,String>>(){});
        JSONObject.parseArray("[{\"activityCategoryId\":\"1\",\"cid\":\"2\"}]",JosCidAndActivityCategoryId.class);
    }

}
