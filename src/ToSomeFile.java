import java.io.IOException;

public interface ToSomeFile {
    public String transform(ToSomeFile auto) throws IllegalAccessException, IOException;
    public void writeToFile(String str, String path);
}
