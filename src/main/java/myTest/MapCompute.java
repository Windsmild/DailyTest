package myTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Stephen Cai on 2017-10-11 09:52.
 */
public class MapCompute {
	public static Map<String, Integer> getElementCounts(List<String> list) {
		Map<String, Integer> countsMap = new HashMap<>();

		list.forEach(str -> countsMap.compute(str, (k, v) -> v == null ? 1 : v + 1)); // 此时：新值 = 旧值 + 1

		return countsMap;
	}

	public static void main(String[] args) throws Exception {
		List<String> list = Arrays.asList("a", "b", "b", "c", "c", "c", "d", "d", "d", "f", "f", "g");
		System.out.println("使用 compute 计算元素出现的次数：");
		Map<String, Integer> counts = getElementCounts(list);
		System.out.println(counts);
	}
}
