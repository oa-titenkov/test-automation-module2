package learn.io.optionaltask;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task10 {

    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\optional_task_code.java");
        File editedFile = new File("src\\main\\resources\\optional_task10.java");

        List<String> textList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuffer result = new StringBuffer();
                Matcher firstWordMatcher = Pattern.compile("^[^a-zA-Z]*([a-zA-Z]+)").matcher(line);
                Matcher lastWordMatcher = Pattern.compile("\\s*([a-zA-Z]+)[^a-zA-Z]*$").matcher(line);

                while (firstWordMatcher.find()) {
                    String firstWord = firstWordMatcher.group(1);
                    System.out.println(firstWord);
                    String lastWord = null;
                    while(lastWordMatcher.find()) {
                        lastWord = lastWordMatcher.group(1);

//                        lastWordMatcher.appendReplacement(result, "firstWord");
                    }
                    if(lastWord != null) {
                        firstWordMatcher.appendReplacement(result, lastWord);
                    }
                }
                firstWordMatcher.appendTail(result);
//                lastWordMatcher.appendTail(result);
                textList.add(result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        WriteToFile.writeListToFile(editedFile, textList);

    }

}
