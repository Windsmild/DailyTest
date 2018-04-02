package myTest;

import lombok.Data;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by Stephen Cai on 2017-09-12 09:33.
 */

@Data
// 店铺属性
public class Property {
	String  name;
	// 距离，单位:米
	Integer distance;
	// 销量，月售
	Integer sales;
	// 价格，这里简单起见就写一个级别代表价格段
	Integer priceLevel;
	public Property(String name, int distance, int sales, int priceLevel) {
		this.name = name;
		this.distance = distance;
		this.sales = sales;
		this.priceLevel = priceLevel;
	}
	// getter setter 省略
	public static void main(String[] args) {
		Property p1 = new Property("叫了个鸡", 1000, 500, 2);
		Property p2 = new Property("张三丰饺子馆", 2300, 1500, 3);
		Property p3 = new Property("永和大王", 580, 3000, 1);
		Property p4 = new Property("肯德基", 6000, 200, 4);
		List<Property> properties = Arrays.asList(p1, p2, p3, p4);
		Collections.sort(properties, Comparator.comparing(x -> x.distance));
		String name = properties.get(0).name;
		out.println("距离我最近的店铺是:" + name);
		String name2 = properties.stream()
				.sorted(Comparator.comparingInt(Property::getDistance).reversed())
				.findFirst()
				.get().name;
		properties.stream()
				.sorted(Comparator.comparing(Property::getDistance).reversed())
				.limit(2);
		out.println("2距离我最近的店铺是:" + name2);
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		numbers.forEach(out::println);
		numbers.parallelStream()
				.forEach(out::println);

	}
}
