package travel.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtil {
    public static void write(HttpServletResponse response, Object obj) {
        response.setContentType("application/json;charset=utf-8");
        String data = JsonUtil.serialize(obj);
        try {
            response.getWriter().write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
