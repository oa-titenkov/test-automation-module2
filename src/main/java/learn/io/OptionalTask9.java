package learn.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OptionalTask9 {
  public static void main(String[] args) {
    File file = new File("src\\main\\resources\\optional_task9.java");
    List<String> textList = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        textList.add(line
                .replaceAll("^([^\"\\r\\n]*?(?:(?<=')\"[^\"\\r\\n]*?|(?<!')\"[^\"\\r\\n]*?\"[^\"\\r\\n]*?)*?)(?<!/)/\\*[^*]*(?:\\*+[^/][^*]*)*?\\*+/", "$1"));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    learn.io.WriteToFile.writeListToFile(file, textList);
  }
}
