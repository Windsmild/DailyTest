package myTest;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Created by Stephen Cai on 2017-05-26 15:56.
 */

public class TimeTest {
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	private static class User {
		int userId;
		String name;
	}

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		//Thread.sleep(10000);
		long end = System.currentTimeMillis();
		System.out.println("jos syncActivity end cost " +(end - start)/ 60 + "分");
		System.out.println("jos");

		System.out.println((double)10000L/3);
		System.out.println(new Date().after(null));
		System.out.println(new DateTime().withTimeAtStartOfDay().toDateTime(DateTimeZone.UTC).toString());
		System.out.println(new DateTime().plusDays(1).withTimeAtStartOfDay().toDateTime(DateTimeZone.UTC).toString());
	}


	public static List<String> getTopics(String content) {
		List<String> stringList = Lists.newArrayList();
		String pattern = "#[^#]+#";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(content);
		while (m.find( )) {
			stringList.add(StringUtils.substringBetween(m.group(0), "#", "#"));
		}
		return stringList;
	}

	public static List<Date> genBiologicalRandomDate(Date startDate, Date endDate, int totalNum){
		List<Date> dateList = Lists.newArrayList();

		if (startDate.compareTo(endDate) != -1) {
			return Collections.emptyList();
		}

		long interval = endDate.getTime() - startDate.getTime();
		DateTime startDateTime = new DateTime(startDate);
		if (startDateTime.getHourOfDay() >=0  && startDateTime.getHourOfDay() <= 6) {
			startDateTime = startDateTime.hourOfDay().setCopy(7);
		}
		while (dateList.size() < totalNum){
			long randomDate = (long)(Math.random()* interval) +startDateTime.toDate().getTime();
			DateTime dateTime = new DateTime(randomDate);
			//正常人0点到6点是应该睡觉的
			if (dateTime.getHourOfDay() >=0  && dateTime.getHourOfDay() <= 6) {
				continue;
			}
			dateList.add(new Date(randomDate));
		}

		return dateList.stream().sorted(Comparator.comparing(Date::getTime)).collect(Collectors.toList());
	}
}
