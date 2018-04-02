package myTest.annotationTest;

/**
 * http://gityuan.com/2016/01/23/java-annotation/
 * Created by Stephen Cai on 2017-10-28 17:28.
 */
public class AnnotationDemo {
    @AuthorAnno(name="yuanhh", website = "gityuan.com", revision = 1)
    public static void main(String[] args) {
        System.out.println("I am main method");
    }

    @SuppressWarnings({"unchecked","deprecation"})
    @AuthorAnno(name="yuanhh", website = "gityuan.com", revision = 2)
    public void demo() {
        System.out.println("I am demo method");
    }
}
