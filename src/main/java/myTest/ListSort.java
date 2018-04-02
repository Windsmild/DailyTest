package myTest;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import lombok.Data;
import org.joda.time.DateTime;

/**
 * Created by Stephen Cai on 2017-10-11 16:21.
 */
public class ListSort {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setId(1);
        circle.setCircle("circle");
        circle.setDate(new DateTime().plusDays(1).toDate());

        Circle circle2 = new Circle();
        circle2.setId(1);
        circle2.setCircle("circle");
        circle2.setDate(new DateTime().minusDays(1).toDate());

        Block block = new Block();
        block.setId(1);
        block.setBlock("block");
        block.setDate(new Date());

        List<Shape> list =Lists.newArrayList();
        list.add(circle);
        list.add(circle2);
        list.add(block);
        System.out.println(list);
        Collections.sort(list, new Comparator<Shape>() {
            @Override public int compare(Shape o1, Shape o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        System.out.println(list);
        list.forEach(e -> {
            if (e instanceof Circle) {
                System.out.println(((Circle) e).getCircle());
            }
        });
    }
}

@Data
class Circle extends Shape{
    String circle;
    }

@Data
class Block extends Shape{
    String block;

    }
@Data
abstract class  Shape {
    int id;
    Date date;
}