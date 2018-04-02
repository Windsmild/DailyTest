package myTest;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Created by Stephen Cai on 2017-09-12 09:04.
 */
public class FunctionInterfaceDemo {
	@FunctionalInterface
	interface Predicate<T> {
		boolean test(T t);
	}

	/**
	 * 执行Predicate判断
	 *
	 * @param age       年龄
	 * @param predicate Predicate函数式接口
	 * @return          返回布尔类型结果
	 */
	public static boolean doPredicate(int age, Predicate<Integer> predicate) {
		return predicate.test(age);
	}

	public static List<Integer> supply(Integer num, Supplier<Integer> supplier){
		List<Integer> resultList = new ArrayList<Integer>()   ;
		for(int x=0;x<num;x++)
			resultList.add(supplier.get());
		return resultList ;
	}

	public static void main(String[] args) {
		boolean isAdult = doPredicate(20, x -> x >= 18);
		
		System.out.println(isAdult);
		List<Integer> list = supply(10,() -> (int)(Math.random()*100));
		list.forEach(System.out::println);
	}
}
