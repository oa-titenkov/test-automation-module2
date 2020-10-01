package learn.io.optionaltask;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\main\\resources\\optional_task_code.java");
        File privateFieldsFile = new File("src\\main\\resources\\optional_task2.java");
        if(!file.exists()){
            throw new FileNotFoundException("File optional_task_code.java does not exist!");
        }

        List<String> textList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringBuffer result = new StringBuffer();
                Matcher matcher = Pattern.compile("(\\s+(public)\\s+)").matcher(line);
                if (matcher.find()) {
                    matcher.appendReplacement(result, matcher.group(1).replaceAll("public", "private"));
                }
                matcher.appendTail(result);
                textList.add(result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteToFile.writeListToFile(privateFieldsFile, textList);

    }
}
