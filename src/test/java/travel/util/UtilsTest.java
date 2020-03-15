package travel.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
//import org.springframework.util.StringUtils;

public class UtilsTest {
    @Test
    public void stringIsEmpty() {
        String s = "";
        System.out.println(StringUtils.isEmpty(s));
        s = null;
        System.out.println(StringUtils.isEmpty(s));
        s = "124";
        System.out.println(StringUtils.isEmpty(s));
        System.out.println(StringUtils.isNotEmpty(s));
    }

    @Test
    public void ceil() {
        System.out.println(Math.ceil((5 / 2.0)));
        System.out.println(Math.ceil(1.1));
        System.out.println(Math.ceil(1.5));
        System.out.println(Math.ceil(1.6));
    }
}
