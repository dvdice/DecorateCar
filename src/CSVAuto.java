import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Class Auto в csv
class CSVAuto implements ToSomeFile{
    ToSomeFile toSomeFile;
    public CSVAuto(ToSomeFile toSomeFile) {
        this.toSomeFile = toSomeFile;
    }

    @Override
    public String transform(ToSomeFile auto) throws IllegalAccessException {
        HashMap<String, Object> csv = new HashMap<>();
        for (Field field : auto.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(auto);
            if (value != null) {
                csv.put(field.getName(), value);
            }
        }
        StringBuilder s = new StringBuilder();
        ArrayList<String> lstKeys = new ArrayList<String>();
        ArrayList<Object> lstValue = new ArrayList<Object>();
        for (Map.Entry entry : csv.entrySet()) {
            s.append("\"").append(entry.getKey().toString()).append("\";");
            lstValue.add(entry.getValue());
        }
        s.append("\n");
        StringBuilder valStr = new StringBuilder();
        for (Object val : lstValue) {
            valStr.append(val.toString()).append(';');
        }
        s.append(valStr);


        return s.toString();
    }
    @Override
    public void writeToFile(String s, String path){
        toSomeFile.writeToFile(s, path+ "\\new.csv");
    }
}
