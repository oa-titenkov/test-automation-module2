package learn.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OptionalTask4 {
  public static void main(String[] args) {
    File file = new File("src\\main\\resources\\optional_task4.java");
    List<String> textList = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        StringBuffer result = new StringBuffer();
        Matcher m = Pattern.compile("(\\w{3,})").matcher(line);
        while (m.find()) {
          m.appendReplacement(result, m.group(1).toUpperCase());
        }
        m.appendTail(result);
        textList.add(result.toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    learn.io.WriteToFile.writeListToFile(file, textList);
  }
}
