package myTest;

import com.google.common.collect.Lists;
import entity.AucRawDto;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 反射
 * Created by Stephen Cai on 2017-06-27 16:19.
 */
public class ObjectToMapTest {
	public static Map<String, Object> objectToMap(Object obj) throws Exception {
		if(obj == null){
			return null;
		}
		//获取关联的所有类，本类以及所有父类
		boolean ret = true;
		Class oo = obj.getClass();
		List<Class> clazzs = new ArrayList<Class>();
		while(ret){
			clazzs.add(oo);
			oo = oo.getSuperclass();
			if(oo == null || oo == Object.class)break;
		}

		Map<String, Object> map = new HashMap<String, Object>();

		for(int i=0;i<clazzs.size();i++){
			Field[] declaredFields = clazzs.get(i).getDeclaredFields();
			for (Field field : declaredFields) {
				int mod = field.getModifiers();
				//过滤 static 和 final 类型
				if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){
					continue;
				}
				field.setAccessible(true);
				map.put(field.getName(), field.get(obj));
			}
		}

		return map;
	}
    public static List<AucRawDto> sortByFieldName(List<AucRawDto> list, String fieldName) throws NoSuchFieldException {
        Field field = AucRawDto.class.getDeclaredField(fieldName);
        //if (!String.class.isAssignableFrom(field.getType())) {
        //    throw new IllegalArgumentException("Field is not a string!");
        //}

        field.setAccessible(true);
        return list.stream()
            .sorted((first, second) -> {
                try {
                    String a = String.valueOf(field.get(first));
                    String b = String.valueOf(field.get(second));
                    return a.compareTo(b);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error", e);
                }
            })
            .collect(Collectors.toList());
    }

    public static void main(String[] args) throws Exception {
        AucRawDto d1 = new AucRawDto("1",1,4,11);
        AucRawDto d2 = new AucRawDto("2",2,2,22);
        AucRawDto d3 = new AucRawDto("3",3,3,33);
        List l = Lists.newArrayList(d1,d2,d3);
        ObjectToMapTest.objectToMap(d1);
        System.out.println(sortByFieldName(l,"conv_num"));
    }
}
