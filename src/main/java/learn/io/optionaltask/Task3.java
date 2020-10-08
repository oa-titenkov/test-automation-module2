package learn.io.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task3 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\main\\resources\\optional_task_code.java");
        File fileInReverse = new File("src\\main\\resources\\optional_task3.java");
        if (!file.exists()) {
            throw new FileNotFoundException("File optional_task_code.java does not exist!");
        }

        List<String> textList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuilder result = new StringBuilder();
                result.append(line);
                textList.add(result.reverse().toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteToFile.writeListToFile(fileInReverse, textList);

    }
}
