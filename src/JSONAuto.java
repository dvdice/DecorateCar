import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Class Auto в json
class JSONAuto implements ToSomeFile{
    ToSomeFile toSomeFile;
    public JSONAuto(ToSomeFile toSomeFile) {
        this.toSomeFile = toSomeFile;
    }

    @Override
    public String transform(ToSomeFile auto) throws IllegalAccessException, IOException {
        HashMap<String, Object> json = new HashMap<>();
        for (Field field : auto.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(auto);
            if (value != null) {
                json.put(field.getName(), value);
            }
        }
        String s = "{";
        ArrayList<String> lst = new ArrayList<String>();
        for (Map.Entry entry : json.entrySet()) {
            lst.add("\"" + entry.getKey() + "\"" + ":" + entry.getValue());
        }

        s += String.join(",", lst) + "}";
        return s;
    }
    @Override
    public void writeToFile(String str, String path){
        toSomeFile.writeToFile(str, path + "\\new.json");
    }
}
