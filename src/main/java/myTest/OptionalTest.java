package myTest;

import java.util.Optional;
import org.junit.Test;

/**
 * @author Stephen Cai
 * @date 2018-01-21 21:19
 */
public class OptionalTest {
    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    @Test
    public void whenOrElseGetAndOrElseOverlap_thenCorrect() {
        String text = null;
        System.out.println("Using orElseGet:");
        String defaultText =
            Optional.ofNullable(text).orElseGet(this::getMyDefault);

        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    }

    @Test
    public void whenOrElseGetAndOrElseDiffer_thenCorrect() {
        String text = "Text present";

        System.out.println("Using orElseGet:");
        //OrElseGet懒加载
        String defaultText
            = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        System.out.println("Using orElse:");
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
    }
}
