package common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
    private static Gson gson = new GsonBuilder().create();

    public static Object fromJson(String json, Class c) {
        return gson.fromJson(json, c);
    }
}
