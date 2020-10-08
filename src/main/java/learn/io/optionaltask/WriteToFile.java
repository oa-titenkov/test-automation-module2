package learn.io.optionaltask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {

    public static void writeListToFile(File file, List<String> list) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : list) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
