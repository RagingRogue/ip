import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static final String FILE_PATH = "data/Abang.txt";

    public Storage() {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdir();
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public TaskList load() {
        ArrayList<String> fileLines = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(FILE_PATH));
            while (sc.hasNextLine()) {
                fileLines.add(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error: Corrupted file");
        }
        return TaskList.fromFileLines(fileLines);
    }

    public void save(ArrayList<String> fileLines) {
        try {
            FileWriter fw = new FileWriter(new File(FILE_PATH));
            for (String line : fileLines) {
                fw.write(line + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }
}



