package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionalTask2 {
    public static void main(String[] args) {
        File file = new File("src\\main\\resources\\optional_task2.java");
        List<String> textList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringBuilder result = new StringBuilder();
                Matcher m = Pattern.compile("(\\s+\\b(public)\\s+)").matcher(line);
                while (m.find()) {
                    m.appendReplacement(result, m.group(1).replace("public", "private"));
                }
                m.appendTail(result);
                textList.add(result.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        io.WriteToFile.writeListToFile(file, textList);
    }
}
