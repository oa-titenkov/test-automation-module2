package learn.io.optionaltask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Task4 {

    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\optional_task_code.java");
        File editedFile = new File("src\\main\\resources\\optional_task4.java");

        List<String> textList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuffer result = new StringBuffer();
                Matcher matcher = Pattern.compile("(\\w{3,})").matcher(line);
                while (matcher.find()) {
                    matcher.appendReplacement(result, matcher.group(1).toUpperCase());
                }
                matcher.appendTail(result);
                textList.add(result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteToFile.writeListToFile(editedFile, textList);

    }
}
