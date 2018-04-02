package myTest;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
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


}
