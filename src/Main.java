import java.io.IOException;

public class Main {
    public static final String path = "C:\\Users\\damir\\IdeaProjects\\DecorateCar";

    public static void main(String[] args) throws IllegalAccessException, IOException {

        ToSomeFile auto = new Auto();
        JSONAuto json = new JSONAuto(auto); // init json
        XMLAuto xml = new XMLAuto(auto); // init xml
        CSVAuto csv = new CSVAuto(auto); // init csv


        ToSomeFile csvInterface = new CSVAuto(new AbsToSomeFile());
        csvInterface.writeToFile(csv.transform(auto), Main.path);

        ToSomeFile jsonInterface = new JSONAuto(new AbsToSomeFile());
        jsonInterface.writeToFile(json.transform(auto), Main.path);

        ToSomeFile xmlInterface = new XMLAuto(new AbsToSomeFile());
        xmlInterface.writeToFile(xml.transform(auto), Main.path);
    }
}

