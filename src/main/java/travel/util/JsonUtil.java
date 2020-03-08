package travel.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
    public static String serialize(Object obj) {
        if (obj == null) return "";
        ObjectMapper mapper = new ObjectMapper();
        String str = "";
        try {
            str = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }

//    public static T deSerialize<T>(String str){
//
//    }
}
