package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OptionalTask3 {
  public static void main(String[] args) {
    File file = new File("src\\main\\resources\\optional_task3.java");
    File fileInReverse = new File("src\\main\\resources\\optional_task3_reverse.java");
    List<String> textList = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        StringBuilder result = new StringBuilder();
        result.append(line);
        textList.add(result.reverse().toString());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    io.WriteToFile.writeListToFile(fileInReverse, textList);
  }
}
