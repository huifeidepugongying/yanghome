package travel.util;

import org.junit.Test;

public class MailUtilsTest {
    @Test
    public void sendMailTest(){
        MailUtils.sendMail("1028349549@qq.com","小测一把","小帅哥早上好啊");
    }
}
