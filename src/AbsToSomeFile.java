import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AbsToSomeFile implements ToSomeFile{
    @Override
    public String transform(ToSomeFile auto) throws IllegalAccessException, IOException {
        return auto.toString();
    }

    @Override
    public void writeToFile(String str, String path) {
        File file = new File(path);

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter(path))
        {
            writer.write(str);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
