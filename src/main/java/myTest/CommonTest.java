package myTest;

import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

/**
 * Created by Stephen Cai on 2017-06-04 20:00.
 */
public class CommonTest {

	public static void main(String[] args) throws Exception {
		List<String> typeList = Lists.newArrayList("1", "2");
		System.out.println("type:" + String.join(" OR type:", typeList));

	}
	public static <T> T getRandomElement(List<T> list) {
		Random random = new Random();
		return list.get(random.nextInt(list.size()));
	}
}
