import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Class Auto в xml
class XMLAuto implements ToSomeFile {
    ToSomeFile toSomeFile;
    public XMLAuto(ToSomeFile toSomeFile){
    this.toSomeFile = toSomeFile;
    }
    @Override
    public String transform(ToSomeFile auto) throws IllegalAccessException, IOException {
        HashMap<String, Object> xml = new HashMap<>();
        for (Field field : auto.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(auto);
            if (value != null) {
                xml.put(field.getName(), value);
            }
        }
        String s = "<xml>";
        ArrayList<String> lst = new ArrayList<String>();
        for (Map.Entry entry : xml.entrySet()) {
            lst.add("<" + entry.getKey() + ">" + entry.getValue() + "</" + entry.getKey() + ">");
        }

        s += String.join("", lst) + "</xml>";
        return s;
    }
    @Override
    public void writeToFile(String str, String path){
        toSomeFile.writeToFile(str, path + "\\new.xml");
    }
}
