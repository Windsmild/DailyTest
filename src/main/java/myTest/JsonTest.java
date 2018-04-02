package myTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.TypeReference;
import entity.JosSKU;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Stephen Cai
 * @date 2018-01-31 17:22
 */
public class JsonTest {
    public static void main(String[] args) throws JSONException, IOException {
        String rawJson =
            "{\"jingdong_sku_read_searchSkuList_responce\":{\"code\":\"0\",\"page\":{\"pageSize\":20,\"data\":[{\"status\":2,\"jdPrice\":9.00,\"skuId\":25416150278,\"wareId\":11387765438,\"outerId\":\"414265\"},{\"status\":2,\"jdPrice\":960.00,\"skuId\":25416150277,\"wareId\":11387765438,\"outerId\":\"438049\"},{\"status\":1,\"jdPrice\":960.00,\"skuId\":25416822128,\"wareId\":11387812226,\"outerId\":\"438049\"},{\"status\":1,\"jdPrice\":9.00,\"skuId\":25416822129,\"wareId\":11387812226,\"outerId\":\"414265\"}],\"pageNo\":1,\"totalItem\":4}}}";
        JSONObject jsonObject = new JSONObject(rawJson);

        String json2 = jsonObject.get("jingdong_sku_read_searchSkuList_responce").toString();
        JSONObject jsonObject2 = new JSONObject(json2);
        String data =  new JSONObject(new JSONObject(jsonObject.get("jingdong_sku_read_searchSkuList_responce").toString()).get("page").toString()).get("data").toString();
        System.out.println( new JSONObject(new JSONObject(jsonObject.get("jingdong_sku_read_searchSkuList_responce").toString()).get("page").toString()).get("data").toString());

       List<JosSKU> skuList =  com.alibaba.fastjson.JSONObject.parseArray(data, JosSKU.class);
        //List<JosSKU> skuList1 = JsonUtils.fromStr(data, new TypeReference<List<JosSKU>>() {});
        //List<JosSKU> skuList1 = JsonUtils.fromStr(data, new TypeReference<List<JosSKU>>() {});
        System.out.println(skuList);
        //System.out.println(skuList1);

        System.out.println("----------------------");
        com.alibaba.fastjson.JSONObject aj = JSON.parseObject(rawJson);
        com.alibaba.fastjson.JSONArray jsonObject1 = aj.getJSONObject("jingdong_sku_read_searchSkuList_responce").getJSONObject("page").getJSONArray("data");
        List<JosSKU> skuList2 =  jsonObject1.toJavaList(JosSKU.class);
        System.out.println(skuList2);
        System.out.println(jsonObject1);

        System.out.println("----------------------");
        Object eval = ((JSONArray)JSONPath.compile("$.jingdong_sku_read_searchSkuList_responce.page.data").eval(JSON.parseObject(rawJson))).toJavaList(JosSKU.class);
        List<JosSKU> skuList3 = (List<JosSKU>) eval;
        System.out.println(skuList3.get(0).getJdPrice());
        System.out.println(skuList3);

        System.out.println("-----------map-------------");
        String mapJson = "{\n"
            + "    \"1\":[\"1787472186\",   \"1787472388\",\"1787472389\",\"1787472687\",\"1787472796\",\"1787473290\",\"1787473479\",\"1787473585\",\"1787473895\",\"1787474464\",\"1787475266\",\"1787475267\",\"1787475452\",\"1787475846\",\"1787476234\",\"1787477028\",\"1787477226\",\"1787477227\",\"1787477625\",\"1787477726\",\"1787477922\",\"1787478907\",\"1787478908\",\"1787479602\"],\n"
            + "    \"2\":[\"1\",\"2\"]}";
        Map<Integer,String> map0 = com.alibaba.fastjson.JSONObject.parseObject(mapJson,new TypeReference<HashMap<Integer, String>>(){});
        //Map<Integer,List<String>> map = JsonUtils.fromStr(mapJson,new TypeReference<Map<Integer, List<String>>>(){});
        System.out.println(map0);

    }
}
