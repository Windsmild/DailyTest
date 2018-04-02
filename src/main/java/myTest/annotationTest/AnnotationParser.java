package myTest.annotationTest;

import java.lang.reflect.Method;

/**
 * Created by Stephen Cai on 2017-10-28 17:30.
 */
public class AnnotationParser {
    public static void main(String[] args) throws ClassNotFoundException {
        String clazz = "myTest.annotationTest.AnnotationDemo";
        Method[] demoMethod = AnnotationParser.class.getClassLoader().loadClass(clazz).getMethods();
        for (Method method: demoMethod) {
            if (method.isAnnotationPresent(AuthorAnno.class)) {
                AuthorAnno authorInfo = method.getAnnotation(AuthorAnno.class);
                System.out.println("method:" + method);
                System.out.println("name=" + authorInfo.name() +
                    " , website= "+ authorInfo.website()
                    + " , revision= "+authorInfo.revision());
            }
        }

    }
}
