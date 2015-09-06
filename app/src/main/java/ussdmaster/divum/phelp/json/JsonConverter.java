package ussdmaster.divum.phelp.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonConverter {

    // uses always the same instance.
    // avoid creating a new instance each time.
    private static Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    private JsonConverter() {
    }

    public static <T> T parseToObject(Class<T> objectClass, String jsonString) {
        return gson.fromJson(jsonString, objectClass);
    }

    public static String parseToJson(Object o) {
        return gson.toJson(o);
    }
}
