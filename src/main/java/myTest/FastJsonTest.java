package myTest;

import com.alibaba.fastjson.JSON;
import entity.AucRawDto;

/**
 * @author Stephen Cai
 * @date 2020-03-30 17:31
 */
public class FastJsonTest {

    public static void main(String[] args) {
        String content = "{account_id:\"123\",pcvr:\"null\"}";
        AucRawDto dto = JSON.parseObject(content, AucRawDto.class);
        System.out.println(dto);

    }


}
