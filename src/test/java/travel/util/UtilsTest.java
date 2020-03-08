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
}
