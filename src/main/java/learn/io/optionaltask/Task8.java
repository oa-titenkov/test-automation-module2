package learn.io.optionaltask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task8 {

    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\optional_task_code.java");
        File fileEdited = new File("src\\main\\resources\\optional_task8.java");
        List<String> textList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if(!line.equals("")) {
                    textList.add(line
                            .trim()
                            .replaceAll("\\s*}\\s*", "}")
                            .replaceAll("\\s*\\{\\s*", "{"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteToFile.writeListToFile(fileEdited, textList);

    }
}
